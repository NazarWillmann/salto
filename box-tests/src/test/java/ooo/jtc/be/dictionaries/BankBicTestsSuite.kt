package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BANKBIC
import ooo.jtc.api.dictionaries.bankbic.BankBicFiltrationTest
import ooo.jtc.api.dictionaries.bankbic.BankBicFindByBicTest
import ooo.jtc.api.dictionaries.bankbic.BankBicGetPageTest
import ooo.jtc.api.dictionaries.bankbic.BankBicGetTest
import ooo.jtc.api.dictionaries.bankbic.BankBicImportTest
import ooo.jtc.api.dictionaries.bankbic.BankBicPrepareSteps
import ooo.jtc.api.dictionaries.bankbic.BankBicSortingTest
import ooo.jtc.api.dictionaries.bankbic.BankBicSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.bankbic.BankBic
import ooo.jtc.dictionaries.bankbic.innerenum.BankBicAllowedServicesIEnumDto
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.bankbic.BankBicData
import ooo.jtc.testdata.dictionaries.bankbic.BankBicFilterParams
import ooo.jtc.testdata.dictionaries.bankbic.BankBicSortingParams
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.BANK_BIC)
@DisplayName("API '${DictionaryNames.BANK_BIC}' suite")
@Execution(ExecutionMode.SAME_THREAD)// + ordered execution: otherwise import may break concurrent get-tests
@BE_DICTIONARY_BANKBIC
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class BankBicTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T5372") annotation class T5372
@Tag("JTCSALTO-T5373") annotation class T5373
@Tag("JTCSALTO-T5374") annotation class T5374
@Tag("JTCSALTO-T5375") annotation class T5375
@Tag("JTCSALTO-T5376") annotation class T5376
@Tag("JTCSALTO-T5377") annotation class T5377
@Tag("JTCSALTO-T5378") annotation class T5378
@Tag("JTCSALTO-T5379") annotation class T5379
@Tag("JTCSALTO-T5380") annotation class T5380
@Tag("JTCSALTO-T5381") annotation class T5381
@Tag("JTCSALTO-T5382") annotation class T5382
@Tag("JTCSALTO-T5383") annotation class T5383
@Tag("JTCSALTO-T5384") annotation class T5384
@Tag("JTCSALTO-T5385") annotation class T5385
@Tag("JTCSALTO-T5386") annotation class T5386
@Tag("JTCSALTO-T5387") annotation class T5387
@Tag("JTCSALTO-T5388") annotation class T5388
@Tag("JTCSALTO-T5389") annotation class T5389
@Tag("JTCSALTO-T5390") annotation class T5390
@Tag("JTCSALTO-T5391") annotation class T5391
@Tag("JTCSALTO-T5392") annotation class T5392
@Tag("JTCSALTO-T5393") annotation class T5393
@Tag("JTCSALTO-T5394") annotation class T5394
@Tag("JTCSALTO-T5395") annotation class T5395
@Tag("JTCSALTO-T5396") annotation class T5396
@Tag("JTCSALTO-T5397") annotation class T5397
@Tag("JTCSALTO-T5398") annotation class T5398
@Tag("JTCSALTO-T5399") annotation class T5399
@Tag("JTCSALTO-T5400") annotation class T5400
@Tag("JTCSALTO-T5401") annotation class T5401
@Tag("JTCSALTO-T5402") annotation class T5402
@Tag("JTCSALTO-T5403") annotation class T5403
@Tag("JTCSALTO-T5404") annotation class T5404
@Tag("JTCSALTO-T5405") annotation class T5405
@Tag("JTCSALTO-T5406") annotation class T5406
@Tag("JTCSALTO-T5407") annotation class T5407
@Tag("JTCSALTO-T5408") annotation class T5408
@Tag("JTCSALTO-T5409") annotation class T5409
@Tag("JTCSALTO-T5410") annotation class T5410
@Tag("JTCSALTO-T5411") annotation class T5411
@Tag("JTCSALTO-T5412") annotation class T5412
@Tag("JTCSALTO-T5413") annotation class T5413
@Tag("JTCSALTO-T5414") annotation class T5414
@Tag("JTCSALTO-T5415") annotation class T5415
@Tag("JTCSALTO-T5416") annotation class T5416
@Tag("JTCSALTO-T5417") annotation class T5417
@Tag("JTCSALTO-T5418") annotation class T5418
@Tag("JTCSALTO-T5419") annotation class T5419
@Tag("JTCSALTO-T5420") annotation class T5420
@Tag("JTCSALTO-T5421") annotation class T5421
@Tag("JTCSALTO-T5422") annotation class T5422
@Tag("JTCSALTO-T5423") annotation class T5423
@Tag("JTCSALTO-T5424") annotation class T5424
@Tag("JTCSALTO-T5425") annotation class T5425
@Tag("JTCSALTO-T5426") annotation class T5426
@Tag("JTCSALTO-T5427") annotation class T5427
@Tag("JTCSALTO-T5428") annotation class T5428
@Tag("JTCSALTO-T5429") annotation class T5429
@Tag("JTCSALTO-T5430") annotation class T5430
@Tag("JTCSALTO-T5431") annotation class T5431
@Tag("JTCSALTO-T5432") annotation class T5432
@Tag("JTCSALTO-T5433") annotation class T5433
@Tag("JTCSALTO-T5434") annotation class T5434
@Tag("JTCSALTO-T5435") annotation class T5435
@Tag("JTCSALTO-T5436") annotation class T5436
@Tag("JTCSALTO-T5437") annotation class T5437
@Tag("JTCSALTO-T5438") annotation class T5438
@Tag("JTCSALTO-T5439") annotation class T5439
@Tag("JTCSALTO-T5440") annotation class T5440
@Tag("JTCSALTO-T5441") annotation class T5441
@Tag("JTCSALTO-T5442") annotation class T5442
@Tag("JTCSALTO-T5443") annotation class T5443
@Tag("JTCSALTO-T5444") annotation class T5444
@Tag("JTCSALTO-T5445") annotation class T5445
@Tag("JTCSALTO-T5446") annotation class T5446
@Tag("JTCSALTO-T5447") annotation class T5447
@Tag("JTCSALTO-T5448") annotation class T5448
@Tag("JTCSALTO-T5449") annotation class T5449
@Tag("JTCSALTO-T5450") annotation class T5450
@Tag("JTCSALTO-T5451") annotation class T5451
@Tag("JTCSALTO-T5452") annotation class T5452
@Tag("JTCSALTO-T5453") annotation class T5453
@Tag("JTCSALTO-T5454") annotation class T5454
@Tag("JTCSALTO-T5455") annotation class T5455
@Tag("JTCSALTO-T5456") annotation class T5456
@Tag("JTCSALTO-T5457") annotation class T5457
@Tag("JTCSALTO-T5458") annotation class T5458
@Tag("JTCSALTO-T5459") annotation class T5459
@Tag("JTCSALTO-T5460") annotation class T5460
@Tag("JTCSALTO-T5461") annotation class T5461
@Tag("JTCSALTO-T5462") annotation class T5462
@Tag("JTCSALTO-T5463") annotation class T5463
@Tag("JTCSALTO-T5464") annotation class T5464
@Tag("JTCSALTO-T5465") annotation class T5465
@Tag("JTCSALTO-T5466") annotation class T5466
@Tag("JTCSALTO-T5475") annotation class T5475
@Tag("JTCSALTO-T5476") annotation class T5476
//@formatter:on
//endregion

    private val bankUser = Users.bankAdmin
    private val clientUser = Users.client
    private lateinit var existingData: List<BankBic>

    @BeforeAll
    fun prepareTestData() {
        existingData = BankBicData.get()
    }

    @AfterAll
    fun cleanTestData() {
        val prepareExistedData = existingData.map { it.toDto().toReducedED807Node() }
        val existedBics = BankBicPrepareSteps.prepareTempFileForBankBicImport(prepareExistedData)
        BankBicSteps(bankUser).importBankBic(existedBics)
    }

    @TestFactory
    @Order(1)
    @T5372 //'БИК РФ'. Импорт справочника пользователем [BANK]
    internal fun importTest(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BankBicImportTest(bankUser).withId(T5372::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.CONCURRENT)
    @Order(2)
    @T5373 //'БИК РФ'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5374 //'БИК РФ'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T5375 //'БИК РФ'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5376 //'БИК РФ'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T5475 //'БИК РФ'. Получение инф. о Банке по его БИК [BANK]
    @T5476 //'БИК РФ'. Получение инф. о Банке по его БИК [CLIENT]
    internal fun bankBicReceiveTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BankBicGetTest(bankUser).withId(T5373::class),
                BankBicGetTest(clientUser).withId(T5374::class),
                BankBicGetPageTest(bankUser).withId(T5375::class),
                BankBicGetPageTest(clientUser).withId(T5376::class),
                BankBicFindByBicTest(bankUser).withId(T5475::class),
                BankBicFindByBicTest(clientUser).withId(T5476::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.CONCURRENT)
    @Order(2)
    @T5377 //'БИК РФ'. Сортировка по полю 'id, ASC' [CLIENT]
    @T5378 //'БИК РФ'. Сортировка по полю 'bic, ASC' [CLIENT]
    @T5379 //'БИК РФ'. Сортировка по полю 'countryAlpha2Code, ASC' [CLIENT]
    @T5380 //'БИК РФ'. Сортировка по полю 'zip, ASC' [CLIENT]
    @T5381 //'БИК РФ'. Сортировка по полю 'locationType, ASC' [CLIENT]
    @T5382 //'БИК РФ'. Сортировка по полю 'location, ASC' [CLIENT]
    @T5383 //'БИК РФ'. Сортировка по полю 'address, ASC' [CLIENT]
    @T5384 //'БИК РФ'. Сортировка по полю 'parentBic, ASC' [CLIENT]
    @T5385 //'БИК РФ'. Сортировка по полю 'participantTransferType, ASC' [CLIENT]
    @T5386 //'БИК РФ'. Сортировка по полю 'participantType, ASC' [CLIENT]
    @T5387 //'БИК РФ'. Сортировка по полю 'allowedServices, ASC' [CLIENT]
    @T5388 //'БИК РФ'. Сортировка по полю 'dateIn, ASC' [CLIENT]
    @T5389 //'БИК РФ'. Сортировка по полю 'dateOut, ASC' [CLIENT]
    @T5390 //'БИК РФ'. Сортировка по полю 'status, ASC' [CLIENT]

    @T5391 //'БИК РФ'. Сортировка по полю 'id, DESC' [CLIENT]
    @T5392 //'БИК РФ'. Сортировка по полю 'bic, DESC' [CLIENT]
    @T5393 //'БИК РФ'. Сортировка по полю 'countryAlpha2Code, DESC' [CLIENT]
    @T5394 //'БИК РФ'. Сортировка по полю 'zip, DESC' [CLIENT]
    @T5395 //'БИК РФ'. Сортировка по полю 'locationType, DESC' [CLIENT]
    @T5396 //'БИК РФ'. Сортировка по полю 'location, DESC' [CLIENT]
    @T5397 //'БИК РФ'. Сортировка по полю 'address, DESC' [CLIENT]
    @T5398 //'БИК РФ'. Сортировка по полю 'parentBic, DESC' [CLIENT]
    @T5399 //'БИК РФ'. Сортировка по полю 'participantTransferType, DESC' [CLIENT]
    @T5400 //'БИК РФ'. Сортировка по полю 'participantType, DESC' [CLIENT]
    @T5401 //'БИК РФ'. Сортировка по полю 'allowedServices, DESC' [CLIENT]
    @T5402 //'БИК РФ'. Сортировка по полю 'dateIn, DESC' [CLIENT]
    @T5403 //'БИК РФ'. Сортировка по полю 'dateOut, DESC' [CLIENT]
    @T5404 //'БИК РФ'. Сортировка по полю 'status, DESC' [CLIENT]
    internal fun bankBicSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankBicSortingTest(user, BankBicSortingParams.ID::asc).withId(T5377::class),
                BankBicSortingTest(user, BankBicSortingParams.BIC::asc).withId(T5378::class),
                BankBicSortingTest(user, BankBicSortingParams.COUNTRY_2_ALPHA_CODE::asc).withId(T5379::class),
                BankBicSortingTest(user, BankBicSortingParams.ZIP::asc).withId(T5380::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION_TYPE::asc).withId(T5381::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION::asc).withId(T5382::class),
                BankBicSortingTest(user, BankBicSortingParams.ADDRESS::asc).withId(T5383::class),
                BankBicSortingTest(user, BankBicSortingParams.PARENT_BIC::asc).withId(T5384::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TRANSF_TYPE::asc).withId(T5385::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TYPE::asc).withId(T5386::class),
                BankBicSortingTest(user, BankBicSortingParams.ALLOWED_SERVICES::asc).withId(T5387::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_IN::asc).withId(T5388::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_OUT::asc).withId(T5389::class),
                BankBicSortingTest(user, BankBicSortingParams.STATUS::asc).withId(T5390::class),

                BankBicSortingTest(user, BankBicSortingParams.ID::desc).withId(T5391::class),
                BankBicSortingTest(user, BankBicSortingParams.BIC::desc).withId(T5392::class),
                BankBicSortingTest(user, BankBicSortingParams.COUNTRY_2_ALPHA_CODE::desc).withId(T5393::class),
                BankBicSortingTest(user, BankBicSortingParams.ZIP::desc).withId(T5394::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION_TYPE::desc).withId(T5395::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION::desc).withId(T5396::class),
                BankBicSortingTest(user, BankBicSortingParams.ADDRESS::desc).withId(T5397::class),
                BankBicSortingTest(user, BankBicSortingParams.PARENT_BIC::desc).withId(T5398::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TRANSF_TYPE::desc).withId(T5399::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TYPE::desc).withId(T5400::class),
                BankBicSortingTest(user, BankBicSortingParams.ALLOWED_SERVICES::desc).withId(T5401::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_IN::desc).withId(T5402::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_OUT::desc).withId(T5403::class),
                BankBicSortingTest(user, BankBicSortingParams.STATUS::desc).withId(T5404::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.CONCURRENT)
    @Order(2)
    @T5405 //'БИК РФ'. Сортировка по полю 'id, ASC' [BANK]
    @T5406 //'БИК РФ'. Сортировка по полю 'bic, ASC' [BANK]
    @T5407 //'БИК РФ'. Сортировка по полю 'countryAlpha2Code, ASC' [BANK]
    @T5408 //'БИК РФ'. Сортировка по полю 'zip, ASC' [BANK]
    @T5409 //'БИК РФ'. Сортировка по полю 'locationType, ASC' [BANK]
    @T5410 //'БИК РФ'. Сортировка по полю 'location, ASC' [BANK]
    @T5411 //'БИК РФ'. Сортировка по полю 'address, ASC' [BANK]
    @T5412 //'БИК РФ'. Сортировка по полю 'parentBic, ASC' [BANK]
    @T5413 //'БИК РФ'. Сортировка по полю 'participantTransferType, ASC' [BANK]
    @T5414 //'БИК РФ'. Сортировка по полю 'participantType, ASC' [BANK]
    @T5415 //'БИК РФ'. Сортировка по полю 'allowedServices, ASC' [BANK]
    @T5416 //'БИК РФ'. Сортировка по полю 'dateIn, ASC' [BANK]
    @T5417 //'БИК РФ'. Сортировка по полю 'dateOut, ASC' [BANK]
    @T5418 //'БИК РФ'. Сортировка по полю 'status, ASC' [BANK]

    @T5419 //'БИК РФ'. Сортировка по полю 'id, DESC' [BANK]
    @T5420 //'БИК РФ'. Сортировка по полю 'bic, DESC' [BANK]
    @T5421 //'БИК РФ'. Сортировка по полю 'countryAlpha2Code, DESC' [BANK]
    @T5422 //'БИК РФ'. Сортировка по полю 'zip, DESC' [BANK]
    @T5423 //'БИК РФ'. Сортировка по полю 'locationType, DESC' [BANK]
    @T5424 //'БИК РФ'. Сортировка по полю 'location, DESC' [BANK]
    @T5425 //'БИК РФ'. Сортировка по полю 'address, DESC' [BANK]
    @T5426 //'БИК РФ'. Сортировка по полю 'parentBic, DESC' [BANK]
    @T5427 //'БИК РФ'. Сортировка по полю 'participantTransferType, DESC' [BANK]
    @T5428 //'БИК РФ'. Сортировка по полю 'participantType, DESC' [BANK]
    @T5429 //'БИК РФ'. Сортировка по полю 'allowedServices, DESC' [BANK]
    @T5430 //'БИК РФ'. Сортировка по полю 'dateIn, DESC' [BANK]
    @T5431 //'БИК РФ'. Сортировка по полю 'dateOut, DESC' [BANK]
    @T5432 //'БИК РФ'. Сортировка по полю 'status, DESC' [BANK]
    internal fun bankBicSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                BankBicSortingTest(user, BankBicSortingParams.ID::asc).withId(T5405::class),
                BankBicSortingTest(user, BankBicSortingParams.BIC::asc).withId(T5406::class),
                BankBicSortingTest(user, BankBicSortingParams.COUNTRY_2_ALPHA_CODE::asc).withId(T5407::class),
                BankBicSortingTest(user, BankBicSortingParams.ZIP::asc).withId(T5408::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION_TYPE::asc).withId(T5409::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION::asc).withId(T5410::class),
                BankBicSortingTest(user, BankBicSortingParams.ADDRESS::asc).withId(T5411::class),
                BankBicSortingTest(user, BankBicSortingParams.PARENT_BIC::asc).withId(T5412::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TRANSF_TYPE::asc).withId(T5413::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TYPE::asc).withId(T5414::class),
                BankBicSortingTest(user, BankBicSortingParams.ALLOWED_SERVICES::asc).withId(T5415::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_IN::asc).withId(T5416::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_OUT::asc).withId(T5417::class),
                BankBicSortingTest(user, BankBicSortingParams.STATUS::asc).withId(T5418::class),

                BankBicSortingTest(user, BankBicSortingParams.ID::desc).withId(T5419::class),
                BankBicSortingTest(user, BankBicSortingParams.BIC::desc).withId(T5420::class),
                BankBicSortingTest(user, BankBicSortingParams.COUNTRY_2_ALPHA_CODE::desc).withId(T5421::class),
                BankBicSortingTest(user, BankBicSortingParams.ZIP::desc).withId(T5422::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION_TYPE::desc).withId(T5423::class),
                BankBicSortingTest(user, BankBicSortingParams.LOCATION::desc).withId(T5424::class),
                BankBicSortingTest(user, BankBicSortingParams.ADDRESS::desc).withId(T5425::class),
                BankBicSortingTest(user, BankBicSortingParams.PARENT_BIC::desc).withId(T5426::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TRANSF_TYPE::desc).withId(T5427::class),
                BankBicSortingTest(user, BankBicSortingParams.PART_TYPE::desc).withId(T5428::class),
                BankBicSortingTest(user, BankBicSortingParams.ALLOWED_SERVICES::desc).withId(T5429::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_IN::desc).withId(T5430::class),
                BankBicSortingTest(user, BankBicSortingParams.DATE_OUT::desc).withId(T5431::class),
                BankBicSortingTest(user, BankBicSortingParams.STATUS::desc).withId(T5432::class)
            )
        )
    }

    private val dataForFilter by lazy {
        BankBicData.get(fromCache = false)
            .filter(BankBicData.atMarkerPredicate)
            .random().toDto()
    }

    @TestFactory
    @Execution(ExecutionMode.CONCURRENT)
    @Order(2)
    @T5433 //'БИК РФ'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T5434 //'БИК РФ'. Фильтрация по полю 'bic' (eq) [CLIENT]
    @T5435 //'БИК РФ'. Фильтрация по полю 'countryAlpha2Code' (eq) [CLIENT]
    @T5436 //'БИК РФ'. Фильтрация по полю 'zip' (eq) [CLIENT]
    @T5437 //'БИК РФ'. Фильтрация по полю 'zip' (contains) [CLIENT]
    @T5438 //'БИК РФ'. Фильтрация по полю 'locationType' (eq) [CLIENT]
    @T5439 //'БИК РФ'. Фильтрация по полю 'location' (eq) [CLIENT]
    @T5440 //'БИК РФ'. Фильтрация по полю 'location' (contains) [CLIENT]
    @T5441 //'БИК РФ'. Фильтрация по полю 'address' (eq) [CLIENT]
    @T5442 //'БИК РФ'. Фильтрация по полю 'address' (contains) [CLIENT]
    @T5443 //'БИК РФ'. Фильтрация по полю 'parentBic' (eq) [CLIENT]
    @T5444 //'БИК РФ'. Фильтрация по полю 'participantTransferType.value' (eq) [CLIENT]
    @T5445 //'БИК РФ'. Фильтрация по полю 'participantType.value' (eq) [CLIENT]
    @T5446 //'БИК РФ'. Фильтрация по полю 'allowedServices.value' (eq) [CLIENT]
    @T5447 //'БИК РФ'. Фильтрация по полю 'dateIn' (eq) [CLIENT]
    @T5448 //'БИК РФ'. Фильтрация по полю 'dateOut' (eq) [CLIENT]
    @T5449 //'БИК РФ'. Фильтрация по полю 'status.value' (eq) [CLIENT]
    internal fun bankBicFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankBicFiltrationTest("id equals", user, { dataForFilter },
                    { BankBicFilterParams.ID.eq(it!!.id!!) }).withId(T5433::class),
                BankBicFiltrationTest("bic equals", user, { dataForFilter },
                    { BankBicFilterParams.BIC.eq(it!!.bic) }).withId(T5434::class),
                BankBicFiltrationTest("countryAlpha2Code equals", user, { dataForFilter },
                    { BankBicFilterParams.COUNTRY_2_ALPHA_CODE.eq(it!!.countryAlpha2Code!!) }).withId(T5435::class),
                BankBicFiltrationTest("zip equals", user, { dataForFilter },
                    { BankBicFilterParams.ZIP.eq(it!!.zip!!) }).withId(T5436::class),
                BankBicFiltrationTest("zip contains", user, { dataForFilter },
                    { BankBicFilterParams.ZIP.contains(it!!.zip!!.randomSubstringPf()) }).withId(T5437::class),
                BankBicFiltrationTest("locationType equals", user, { dataForFilter },
                    { BankBicFilterParams.LOCATION_TYPE.eq(it!!.locationType!!) }).withId(T5438::class),
                BankBicFiltrationTest("location equals", user, { dataForFilter },
                    { BankBicFilterParams.LOCATION.eq(it!!.location!!) }).withId(T5439::class),
                BankBicFiltrationTest("location contains", user, { dataForFilter },
                    { BankBicFilterParams.LOCATION.contains(it!!.location!!.randomSubstringPf()) }).withId(T5440::class),
                BankBicFiltrationTest("address equals", user, { dataForFilter },
                    { BankBicFilterParams.ADDRESS.eq(it!!.address!!) }).withId(T5441::class),
                BankBicFiltrationTest("address contains", user, { dataForFilter },
                    { BankBicFilterParams.ADDRESS.contains(it!!.address!!.randomSubstringPf()) }).withId(T5442::class),
                BankBicFiltrationTest("parentBic equals", user, { dataForFilter },
                    { BankBicFilterParams.PARENT_BIC.eq(it!!.parentBic!!) }).withId(T5443::class),
                BankBicFiltrationTest("participantTransferType equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.PART_TRANSF_TYPE.eq(
                            ValDescIEnumDto(
                                value = it!!.participantTransferType.value,
                                description = it.participantTransferType.description
                            )
                        )
                    }).withId(T5444::class),
                BankBicFiltrationTest("participantType equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.PART_TYPE.eq(
                            ValDescIEnumDto(
                                value = it!!.participantType.value,
                                description = it.participantType.description
                            )
                        )
                    }).withId(T5445::class),
                BankBicFiltrationTest("allowedServices equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.ALLOWED_SERVICES.eq(
                            BankBicAllowedServicesIEnumDto(
                                value = it!!.allowedServices.value,
                                description = it.allowedServices.description,
                                normalPays = it.allowedServices.normalPays,
                                urgentPays = it.allowedServices.urgentPays,
                                quickPays = it.allowedServices.quickPays
                            )
                        )
                    }).withId(T5446::class),
                BankBicFiltrationTest("dateIn equals", user, { dataForFilter },
                    { BankBicFilterParams.DATE_IN.eq(it!!.dateIn) }).withId(T5447::class),
                BankBicFiltrationTest("dateOut equals", user, { dataForFilter },
                    { BankBicFilterParams.DATE_OUT.eq(it!!.dateOut!!) }).withId(T5448::class),
                BankBicFiltrationTest("status equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.STATUS.eq(
                            ValDescIEnumDto(
                                value = it!!.status.value,
                                description = it.status.description
                            )
                        )
                    }).withId(T5449::class)
            )
        )
    }

    @TestFactory
    @Execution(ExecutionMode.CONCURRENT)
    @Order(2)
    @T5450 //'БИК РФ'. Фильтрация по полю 'id' (eq) [BANK]
    @T5451 //'БИК РФ'. Фильтрация по полю 'bic' (eq) [BANK]
    @T5452 //'БИК РФ'. Фильтрация по полю 'countryAlpha2Code' (eq) [BANK]
    @T5453 //'БИК РФ'. Фильтрация по полю 'zip' (eq) [BANK]
    @T5454 //'БИК РФ'. Фильтрация по полю 'zip' (contains) [BANK]
    @T5455 //'БИК РФ'. Фильтрация по полю 'locationType' (eq) [BANK]
    @T5456 //'БИК РФ'. Фильтрация по полю 'location' (eq) [BANK]
    @T5457 //'БИК РФ'. Фильтрация по полю 'location' (contains) [BANK]
    @T5458 //'БИК РФ'. Фильтрация по полю 'address' (eq) [BANK]
    @T5459 //'БИК РФ'. Фильтрация по полю 'address' (contains) [BANK]
    @T5460 //'БИК РФ'. Фильтрация по полю 'parentBic' (eq) [BANK]
    @T5461 //'БИК РФ'. Фильтрация по полю 'participantTransferType.value' (eq) [BANK]
    @T5462 //'БИК РФ'. Фильтрация по полю 'participantType.value' (eq) [BANK]
    @T5463 //'БИК РФ'. Фильтрация по полю 'allowedServices.value' (eq) [BANK]
    @T5464 //'БИК РФ'. Фильтрация по полю 'dateIn' (eq) [BANK]
    @T5465 //'БИК РФ'. Фильтрация по полю 'dateOut' (eq) [BANK]
    @T5466 //'БИК РФ'. Фильтрация по полю 'status.value' (eq) [BANK]
    internal fun bankBicFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                BankBicFiltrationTest("id equals", user, { dataForFilter },
                    { BankBicFilterParams.ID.eq(it!!.id!!) }).withId(T5450::class),
                BankBicFiltrationTest("bic equals", user, { dataForFilter },
                    { BankBicFilterParams.BIC.eq(it!!.bic) }).withId(T5451::class),
                BankBicFiltrationTest("countryAlpha2Code equals", user, { dataForFilter },
                    { BankBicFilterParams.COUNTRY_2_ALPHA_CODE.eq(it!!.countryAlpha2Code!!) }).withId(T5452::class),
                BankBicFiltrationTest("zip equals", user, { dataForFilter },
                    { BankBicFilterParams.ZIP.eq(it!!.zip!!) }).withId(T5453::class),
                BankBicFiltrationTest("zip contains", user, { dataForFilter },
                    { BankBicFilterParams.ZIP.contains(it!!.zip!!.randomSubstringPf()) }).withId(T5454::class),
                BankBicFiltrationTest("locationType equals", user, { dataForFilter },
                    { BankBicFilterParams.LOCATION_TYPE.eq(it!!.locationType!!) }).withId(T5455::class),
                BankBicFiltrationTest("location equals", user, { dataForFilter },
                    { BankBicFilterParams.LOCATION.eq(it!!.location!!) }).withId(T5456::class),
                BankBicFiltrationTest("location contains", user, { dataForFilter },
                    { BankBicFilterParams.LOCATION.contains(it!!.location!!.randomSubstringPf()) }).withId(T5457::class),
                BankBicFiltrationTest("address equals", user, { dataForFilter },
                    { BankBicFilterParams.ADDRESS.eq(it!!.address!!) }).withId(T5458::class),
                BankBicFiltrationTest("address contains", user, { dataForFilter },
                    { BankBicFilterParams.ADDRESS.contains(it!!.address!!.randomSubstringPf()) }).withId(T5459::class),
                BankBicFiltrationTest("parentBic equals", user, { dataForFilter },
                    { BankBicFilterParams.PARENT_BIC.eq(it!!.parentBic!!) }).withId(T5460::class),
                BankBicFiltrationTest("participantTransferType equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.PART_TRANSF_TYPE.eq(
                            ValDescIEnumDto(
                                value = it!!.participantTransferType.value,
                                description = it.participantTransferType.description
                            )
                        )
                    }).withId(T5461::class),
                BankBicFiltrationTest("participantType equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.PART_TYPE.eq(
                            ValDescIEnumDto(
                                value = it!!.participantType.value,
                                description = it.participantType.description
                            )
                        )
                    }).withId(T5462::class),
                BankBicFiltrationTest("allowedServices equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.ALLOWED_SERVICES.eq(
                            BankBicAllowedServicesIEnumDto(
                                value = it!!.allowedServices.value,
                                description = it.allowedServices.description,
                                normalPays = it.allowedServices.normalPays,
                                urgentPays = it.allowedServices.urgentPays,
                                quickPays = it.allowedServices.quickPays
                            )
                        )
                    }).withId(T5463::class),
                BankBicFiltrationTest("dateIn equals", user, { dataForFilter },
                    { BankBicFilterParams.DATE_IN.eq(it!!.dateIn) }).withId(T5464::class),
                BankBicFiltrationTest("dateOut equals", user, { dataForFilter },
                    { BankBicFilterParams.DATE_OUT.eq(it!!.dateOut!!) }).withId(T5465::class),
                BankBicFiltrationTest("status equals", user, { dataForFilter },
                    {
                        BankBicFilterParams.STATUS.eq(
                            ValDescIEnumDto(
                                value = it!!.status.value,
                                description = it.status.description
                            )
                        )
                    }).withId(T5466::class)
            )
        )
    }
}