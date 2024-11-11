package ooo.jtc.testdata.common

import com.fasterxml.jackson.module.kotlin.readValue
import ooo.jtc.extensions.createOrEmpty
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.serialization.SerializationUtils.OBJECT_MAPPER
import java.io.File

/**
 * Provide test data from [TestDataSource]
 */
interface TestDataProvider {

    /**
     * Provide data as List<Map<String, Any>>
     */
    fun getData(): List<Map<String, Any>>

    /**
     * TestDataSource as [TestDataSource] type
     */
    val dataSource: TestDataSource


}

/**
 * TestDataSource type.
 */
enum class TestDataSource {
    FILE,
    DATABASE,
    REST
}

/**
 * Test data provider from file.
 *
 * @param file - destination file
 * @param fileResultProcessor - executing function after load data
 */
class FileTestDataProvider(
    val file: File,
    private val fileResultProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> = { it }
) : TestDataProvider {

    private val log by LoggerDelegate()

    override val dataSource = TestDataSource.FILE

    override fun getData(): List<Map<String, Any>> =
        createOrEmpty { OBJECT_MAPPER.readValue<List<MutableMap<String, Any>>>(file) }.mapNotNull {
            try {
                fileResultProcessor.invoke(it)
            } catch (ex: Throwable) {
                log.error("Error executing fileResultProcessor on map\n $it ")
                null
            }
        }
}

/**
 * Test data provider from database.
 *
 * @param dbDataConsumer - function, that load data from database
 * @param dbResultProcessor - executing function after load data
 * @param dbDataProvider - function, that crate data in database
 */
class DatabaseTestDataProvider<T>(
    private val dbDataConsumer: () -> List<MutableMap<String, Any>>,
    val dbDataProvider: (List<T>) -> Unit = {},
    private val dbResultProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> = { it }
) : TestDataProvider {

    private val log by LoggerDelegate()

    override val dataSource = TestDataSource.DATABASE

    override fun getData(): List<Map<String, Any>> = createOrEmpty {
        dbDataConsumer.invoke().mapNotNull {
            try {
                dbResultProcessor.invoke(it)
            } catch (ex : Throwable) {
                log.error("Error executing dbResultProcessor on map\n $it ")
                null
            }
        }
    }
}

/**
 * Test data provider using REST API.
 *
 * @param restDataConsumer - function, that load data using REST
 * @param restResultProcessor - executing function after load data
 * @param restDataProvider - function to creating data using REST
 */
class RestTestDataProvider(
    private val restDataConsumer: () -> List<MutableMap<String, Any>>,
    val restDataProvider: () -> Any = {},
    private val restResultProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> = { it }
) : TestDataProvider {

    override val dataSource = TestDataSource.REST

    override fun getData(): List<Map<String, Any>> = createOrEmpty { restDataConsumer.invoke().map(restResultProcessor) }
}