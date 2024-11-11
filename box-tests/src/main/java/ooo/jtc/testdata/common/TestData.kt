package ooo.jtc.testdata.common

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter
import io.qameta.allure.Allure.step
import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.allure.systemStep
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.core.TestDataStrategy
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.queueSize
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.interfaces.IEntity
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.serialization.SerializationUtils
import java.io.File
import java.util.UUID
import java.util.concurrent.BlockingQueue
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.LinkedBlockingQueue
import java.util.stream.Stream
import kotlin.random.Random
import kotlin.streams.toList

/**
 * Indicates the quantity of test data records required for tests.
 */
const val REQUIRED_DATA_COUNT = 3L

/**
 * Abstract class to load from testDataProvider as [TestDataProvider] store test data
 */
abstract class TestData<E : IEntity>(val entityClass: Class<E>) {

    private val log by LoggerDelegate()

    protected val testDataName: String = this::class.java.simpleName

    abstract var atMarkerPredicate: (E) -> Boolean

    /**
     * Uses in [withRequiredFields] for create test data record in specific service.
     */
    open var createRecord: (() -> E)? =
        { throw RuntimeException("To use [withRequiredFields] function need to implement of 'createRecord' function in $testDataName.") }

    /**
     * Uses in [TestDataScope.removeGenerated] for remove test data record generated in [withRequiredFields].
     */
    open var removeRecord: ((E) -> Unit)? =
        { throw RuntimeException("To use [removeGenerated] function need to implement of 'removeRecord' function in $testDataName.") }

    /**
     * Function to consume test data from Database
     */
    protected abstract val dbDataConsumer: () -> List<MutableMap<String, Any>>

    /**
     * Function to update test data, that consume from DB
     */
    open val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> = { it }

    /**
     * Function to load test data in DB
     */
    open val dbDataProvider: (List<E>) -> Unit = {}

    /**
     * File name with test data
     */
    abstract val dataFileName: String

    /**
     * Get list of test data
     */
    open fun get(fromCache: Boolean = true, seekAtCreated: Boolean? = null): List<E> {
        val data = if (fromCache) data else getFromDatabase()
        return seekAtCreated
            ?.let { data.filter { (seekAtCreated == atMarkerPredicate(it)) } }
            ?: data
    }

    /**
     * Get list of test data by [predicate]
     */
    @Step("Найти в {this.testDataName} данные по предикату")
    open fun get(fromCache: Boolean = true, seekAtCreated: Boolean? = null, predicate: (E) -> Boolean): List<E> =
        get(fromCache, seekAtCreated)
            .filter(predicate)
            .attachToAllure()

    /**
     * Find entity by id
     */
    open fun byId(id: UUID, fromCache: Boolean = true) = get(fromCache).find { id == it.id }
        ?: throw NoSuchElementException("Test data ${entityClass.name} with id=$id not found")

    /**
     * Get random entity from test data.
     */
    open fun random(fromCache: Boolean = true, seekAtCreated: Boolean? = null): E? {
        val computedData = get(fromCache, seekAtCreated)
        return if (computedData.isNotEmpty()) computedData.random() else null
    }

    /**
     * Get random entity from test data.
     */
    @Step("Найти в {this.testDataName} случайные данные")
    open fun randomOrException(fromCache: Boolean = true, seekAtCreated: Boolean? = null): E {
        val computedData = get(fromCache, seekAtCreated)
        return (if (computedData.isNotEmpty()) computedData.random() else throw RuntimeException("Test data ${entityClass.name} is empty.")).attachToAllure()
    }

    /**
     * Get random size list of random ids.
     * By default size of list is random,
     * but you can explicitly set [size] of list.
     */
    open fun getRandomIds(size: Int = Random.nextInt(data.size), fromCache: Boolean = true): List<UUID?> =
        get(fromCache).shuffled().subList(0, size).map { it.id }

    /**
     * Get first element of test data by [predicate]
     */
    open fun find(fromCache: Boolean = true, predicate: (E) -> Boolean): E =
        get(fromCache).find(predicate) ?: throw NoSuchElementException("Can't find test data by predicate.")


    /**
     * Generate random fields with checking in TestData.
     * @param size - random data size
     * @param consume - function for consuming field value from TestData
     * @param generate - function for generate random field value.
     */
    fun <R> generateUniqueValues(size: Long = queueSize, consume: (E) -> R, generate: () -> R):
            BlockingQueue<R> {
        val existValues = get(false).map { consume(it) }
        val result = LinkedBlockingQueue<R>()
        val maxSize = size * 10
        for (i in 0..maxSize) {
            val generatedValue = generate()
            if (!existValues.contains(generatedValue) && !result.contains(generatedValue)) result.add(generatedValue)
            if (result.size.toLong() == size) break
        }
        if (result.size < size) log.warn("Generated ${result.size} data, but need $size")
        return result
    }

    @Step("Удалить все созданые АТ записи для {this.testDataName}")
    fun cleanAtCreated() {
        log.info("Starting remove records from $testDataName")
        var counter = 0
        getFromDatabase().filter(atMarkerPredicate).forEach {
            removeRecord!!.invoke(it)
            counter++
        }
        step("$counter records successfully removed from $testDataName")
    }

    /**
     * Returned tesData with required for test not null fields.
     * To use this function it's necessary to override [createRecord] function in specific testData.
     */
    @Step("Подготовка данных с обязательными для тестов полями")
    open fun withRequiredFields(
        fromCache: Boolean = true,
        requiredDataCount: Long = REQUIRED_DATA_COUNT,
        additionalFilter: (E) -> Boolean = { true },
        customCreator: (() -> E)? = null //TODO A.Stykalin [21.06.2020] удалить значние по умолчанию
    ): TestDataScope<E> {
        val testDataScope = TestDataScope(this)
        val actualData = (if (fromCache) data else getFromDatabase()).ifNotEmpty { dataList ->
            dataList
                .filter(additionalFilter)
                .filter { isRequiredFieldsNonNull(it) }
        } ?: emptyList()
        testDataScope.consumed = actualData
        if (actualData.size < requiredDataCount) {
            val needToCreate = requiredDataCount - actualData.size
            testDataScope.generated = Stream
                .generate(customCreator ?: createRecord)
                .limit(needToCreate)
                .toList()
        }
        return testDataScope.attachToAllure()
    }

    private fun isRequiredFieldsNonNull(model: E): Boolean {
        val declaredFields = model.javaClass.declaredFields
        val requiredFields = declaredFields.filter { it.getAnnotation(NotRequiredForTest::class.java) == null }
        if (declaredFields.size == requiredFields.size) {
            throw RuntimeException(
                "In ${model.javaClass.simpleName} model not found annotation @NotRequiredForTest. " +
                        "You should mark at least one field when used `withRequiredFields()` function."
            )
        }
        return requiredFields
            .map {
                it.isAccessible = true
                it
            }.none { (it.get(model) == null) || (it.get(model).toString().isBlank()) }
    }

    /**
     * Copy [TestData] from one [TestDataSource] to another.
     * e.g. from Db to File.
     */
    fun transfer(from: TestDataSource, to: TestDataSource) {
        val data = this.getFrom(from)
        when (to) {
            TestDataSource.FILE -> SerializationUtils.OBJECT_MAPPER
                .writer(DefaultPrettyPrinter())
                .writeValue(this.testDataFile, data)
            TestDataSource.DATABASE -> this.dbDataProvider.invoke(data)
            else -> throw RuntimeException("Not supported yet")
        }
    }

    private fun getFrom(source: TestDataSource): List<E> = when (source) {
        TestDataSource.FILE -> getFromFile()
        TestDataSource.DATABASE -> getFromDatabase()
        TestDataSource.REST -> throw RuntimeException("Not supported yet")
    }

    /**
     * Get test data from DB
     */
    @Step("Получаем тестовые данные из БД для {this.testDataName}")
    private fun getFromDatabase(): List<E> =
        DatabaseTestDataProvider(
            dbDataConsumer = dbDataConsumer,
            dbDataProvider = dbDataProvider,
            dbResultProcessor = dbResultPostProcessor
        ).getData().mapNotNull(transform)


    /**
     * Get test data from file
     */
    @Step("Получаем тестовые данные из файла для {this.testDataName}")
    private fun getFromFile(): List<E> =
        FileTestDataProvider(testDataFile).getData().mapNotNull(transform)

    /**
     * Create file for test data if it doesn't exist
     */
    private val testDataFile: File by lazy {
        val file = File("${applicationProperties.testdata.dir}/$dataFileName")
        if (!file.exists()) {
            file.parentFile.mkdirs()
            file.createNewFile()
        }
        file
    }

    /**
     * Transform mapping from source data to model object [E].
     */
    private val transform: (Map<String, Any>) -> E? =
        { map ->
            SerializationUtils.OBJECT_MAPPER.convertValue(map, entityClass)
            //TODO A.Stykalin [14.09.2020] не помню на какой случай тут было обернуто... но это затрудняет локализацию проблемы,
            // когда мы падаем на десериализации объекта из БД. Пусть недельку-другую (до 28 сент. 2020) повисит закомменченое.
            // Если за это время не обнаружится веских причин для try-catch, удалить. Либо написать коммент зачем тут перехватываем.
//            try {
//                 SerializationUtils.OBJECT_MAPPER.convertValue(map, entityClass)
//            } catch (ex: Throwable) {
//                log.error("Error deserialization object $entityClass from map\n $map\n$ex")
//                null
//            }
        }

    /**
     * Test data, that loaded from testDataProvider and deserialize into List of entity
     */
    private val data by lazy {
        val strategy = applicationProperties.testdata.strategy
        "Подготовить тестовые данные из БД для $testDataName" systemStep {
            val dataList = when (strategy) {
                TestDataStrategy.FROM_DB -> getFromDatabase()
                TestDataStrategy.FROM_FILE -> {
                    val dataFromFile = getFromFile()
                    //upload from db for local development
                    if (dataFromFile.isEmpty()) {
                        this.transfer(TestDataSource.DATABASE, TestDataSource.FILE)
                        getFromFile()
                    } else {
                        dataFromFile
                    }
                }
            }
            if (dataList.isEmpty()) log.warn("Data '$testDataName' consuming by $strategy strategy is empty. Check the source.")
            CopyOnWriteArrayList(dataList)
        }
    }

}


/**
 * Class accumulates test data for tests.
 * Used in [withRequiredFields] function.
 * [consumed] - test data from DB.
 * [generated] - test data generated by [createRecord] function
 * [all] - all ([consumed] and [generated]) test data together
 */
class TestDataScope<E : IEntity>(private val testData: TestData<E>) {
    var consumed: List<E> = emptyList()
    var generated: List<E> = emptyList()
    val all: List<E>
        get() = listOf(consumed, generated).flatten()

    @Step("Удалить сгенерированные для теста данные")
    fun removeGenerated(customRemover: ((E) -> Unit)? = null) {
        generated.forEach(customRemover ?: testData.removeRecord!!)
    }
}

