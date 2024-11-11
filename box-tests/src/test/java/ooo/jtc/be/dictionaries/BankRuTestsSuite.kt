package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BANKRU
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.bankru.BankRuCreateTest
import ooo.jtc.api.dictionaries.bankru.BankRuDeleteTest
import ooo.jtc.api.dictionaries.bankru.BankRuFiltrationTest
import ooo.jtc.api.dictionaries.bankru.BankRuFolderOther
import ooo.jtc.api.dictionaries.bankru.BankRuGetPageTest
import ooo.jtc.api.dictionaries.bankru.BankRuGetTest
import ooo.jtc.api.dictionaries.bankru.BankRuSortingTest
import ooo.jtc.api.dictionaries.bankru.BankRuSteps
import ooo.jtc.api.dictionaries.bankru.BankRuUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.tm4j.Tm4jComponent
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jPriority
import ooo.jtc.dictionaries.bankru.BankRu
import ooo.jtc.dictionaries.bankru.BankRuDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.bankru.BankRuData
import ooo.jtc.testdata.dictionaries.bankru.BankRuFilterParams
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.ADDRESS
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.BANK_NAME
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.BIC
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.CONTROL_DATE
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.CORR_ACCOUNT
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.CTRLCODE_ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.CTRLCODE_NESTED_CODE
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.CTRLCODE_NESTED_DESCR
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.CTRLCODE_NESTED_ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.LOCATION
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.LOCTYPE_ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.LOCTYPE_NESTED_ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.LOCTYPE_NESTED_TYPE
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.PHONE
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.REG_NUMBER
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.UER_ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.UER_NESTED_BANKTYPE
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.UER_NESTED_DESCR
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.UER_NESTED_ID
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.UER_NESTED_UER
import ooo.jtc.testdata.dictionaries.bankru.BankRuSortingParams.ZIP
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.BANK_RU)
@DisplayName("API '${DictionaryNames.BANK_RU}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BANKRU
@TestInstance(PER_CLASS)
class BankRuTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T2316") annotation class T2316
@Tag("JTCSALTO-T2317") annotation class T2317
@Tag("JTCSALTO-T2318") annotation class T2318
@Tag("JTCSALTO-T2319") annotation class T2319
@Tag("JTCSALTO-T2320") annotation class T2320
@Tag("JTCSALTO-T2321") annotation class T2321
@Tag("JTCSALTO-T2322") annotation class T2322
@Tag("JTCSALTO-T2323") annotation class T2323
@Tag("JTCSALTO-T2324") annotation class T2324
@Tag("JTCSALTO-T2325") annotation class T2325
@Tag("JTCSALTO-T2326") annotation class T2326
@Tag("JTCSALTO-T2327") annotation class T2327
@Tag("JTCSALTO-T2328") annotation class T2328
@Tag("JTCSALTO-T2329") annotation class T2329
@Tag("JTCSALTO-T2330") annotation class T2330
@Tag("JTCSALTO-T2331") annotation class T2331
@Tag("JTCSALTO-T2332") annotation class T2332
@Tag("JTCSALTO-T2333") annotation class T2333
@Tag("JTCSALTO-T2334") annotation class T2334
@Tag("JTCSALTO-T2335") annotation class T2335
@Tag("JTCSALTO-T2336") annotation class T2336
@Tag("JTCSALTO-T2338") annotation class T2338
@Tag("JTCSALTO-T2339") annotation class T2339
@Tag("JTCSALTO-T2340") annotation class T2340
@Tag("JTCSALTO-T2341") annotation class T2341
@Tag("JTCSALTO-T2342") annotation class T2342
@Tag("JTCSALTO-T2343") annotation class T2343
@Tag("JTCSALTO-T2344") annotation class T2344
@Tag("JTCSALTO-T2345") annotation class T2345
@Tag("JTCSALTO-T2346") annotation class T2346
@Tag("JTCSALTO-T2347") annotation class T2347
@Tag("JTCSALTO-T2348") annotation class T2348
@Tag("JTCSALTO-T2349") annotation class T2349
@Tag("JTCSALTO-T2350") annotation class T2350
@Tag("JTCSALTO-T2351") annotation class T2351
@Tag("JTCSALTO-T2352") annotation class T2352
@Tag("JTCSALTO-T2353") annotation class T2353
@Tag("JTCSALTO-T2354") annotation class T2354
@Tag("JTCSALTO-T2355") annotation class T2355
@Tag("JTCSALTO-T2356") annotation class T2356
@Tag("JTCSALTO-T2357") annotation class T2357
@Tag("JTCSALTO-T2358") annotation class T2358
@Tag("JTCSALTO-T2359") annotation class T2359
@Tag("JTCSALTO-T2360") annotation class T2360
@Tag("JTCSALTO-T2361") annotation class T2361
@Tag("JTCSALTO-T2362") annotation class T2362
@Tag("JTCSALTO-T2363") annotation class T2363
@Tag("JTCSALTO-T2364") annotation class T2364
@Tag("JTCSALTO-T2365") annotation class T2365
@Tag("JTCSALTO-T2366") annotation class T2366
@Tag("JTCSALTO-T2367") annotation class T2367
@Tag("JTCSALTO-T2368") annotation class T2368
@Tag("JTCSALTO-T2369") annotation class T2369
@Tag("JTCSALTO-T2370") annotation class T2370
@Tag("JTCSALTO-T2371") annotation class T2371
@Tag("JTCSALTO-T2372") annotation class T2372
@Tag("JTCSALTO-T2373") annotation class T2373
@Tag("JTCSALTO-T2374") annotation class T2374
@Tag("JTCSALTO-T2375") annotation class T2375
@Tag("JTCSALTO-T2376") annotation class T2376
@Tag("JTCSALTO-T2377") annotation class T2377
@Tag("JTCSALTO-T2378") annotation class T2378
@Tag("JTCSALTO-T2379") annotation class T2379
@Tag("JTCSALTO-T2380") annotation class T2380
@Tag("JTCSALTO-T2381") annotation class T2381
@Tag("JTCSALTO-T2382") annotation class T2382
@Tag("JTCSALTO-T2383") annotation class T2383
@Tag("JTCSALTO-T2384") annotation class T2384
@Tag("JTCSALTO-T2385") annotation class T2385
@Tag("JTCSALTO-T2386") annotation class T2386
@Tag("JTCSALTO-T2387") annotation class T2387
@Tag("JTCSALTO-T2388") annotation class T2388
@Tag("JTCSALTO-T2389") annotation class T2389
@Tag("JTCSALTO-T2390") annotation class T2390
@Tag("JTCSALTO-T2391") annotation class T2391
@Tag("JTCSALTO-T2392") annotation class T2392
@Tag("JTCSALTO-T2393") annotation class T2393
@Tag("JTCSALTO-T2394") annotation class T2394
@Tag("JTCSALTO-T2395") annotation class T2395
@Tag("JTCSALTO-T2396") annotation class T2396
@Tag("JTCSALTO-T2397") annotation class T2397
@Tag("JTCSALTO-T2398") annotation class T2398
@Tag("JTCSALTO-T2399") annotation class T2399
@Tag("JTCSALTO-T2400") annotation class T2400
@Tag("JTCSALTO-T2401") annotation class T2401
@Tag("JTCSALTO-T2402") annotation class T2402
@Tag("JTCSALTO-T2403") annotation class T2403
@Tag("JTCSALTO-T2404") annotation class T2404
@Tag("JTCSALTO-T2405") annotation class T2405
@Tag("JTCSALTO-T2406") annotation class T2406
@Tag("JTCSALTO-T2407") annotation class T2407
@Tag("JTCSALTO-T2408") annotation class T2408
@Tag("JTCSALTO-T2409") annotation class T2409
@Tag("JTCSALTO-T2410") annotation class T2410
@Tag("JTCSALTO-T2411") annotation class T2411
@Tag("JTCSALTO-T2412") annotation class T2412
@Tag("JTCSALTO-T2413") annotation class T2413
@Tag("JTCSALTO-T2414") annotation class T2414
@Tag("JTCSALTO-T2415") annotation class T2415
@Tag("JTCSALTO-T2416") annotation class T2416
@Tag("JTCSALTO-T2417") annotation class T2417
@Tag("JTCSALTO-T2431") annotation class T2431
@Tag("JTCSALTO-T2432") annotation class T2432
@Tag("JTCSALTO-T2433") annotation class T2433
@Tag("JTCSALTO-T2434") annotation class T2434
@Tag("JTCSALTO-T2435") annotation class T2435
@Tag("JTCSALTO-T2436") annotation class T2436
@Tag("JTCSALTO-T2437") annotation class T2437
@Tag("JTCSALTO-T2438") annotation class T2438
@Tag("JTCSALTO-T2439") annotation class T2439
@Tag("JTCSALTO-T2440") annotation class T2440
@Tag("JTCSALTO-T2441") annotation class T2441
@Tag("JTCSALTO-T2442") annotation class T2442
@Tag("JTCSALTO-T2443") annotation class T2443
@Tag("JTCSALTO-T2444") annotation class T2444
@Tag("JTCSALTO-T2445") annotation class T2445
@Tag("JTCSALTO-T2446") annotation class T2446
//@formatter:on
//endregion

    private val adminUser = Users.bankAdmin
    private val clientUser = Users.client
    private lateinit var dataForFilter: BankRuDto
    private lateinit var testDataScope: TestDataScope<BankRu>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = BankRuData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory

    @T2316 //'Банк России'. CRUD: Создаем запись от пользователя [BANK]
    @T2394 //'Банк России'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T2395 //'Банк России'. CRUD: Получаем запись по id от пользователя [BANK]
    @T2396 //'Банк России'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T2397 //'Банк России'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T2398 //'Банк России'. CRUD: Удаляем запись от пользователя [BANK]
    @T2399 //'Банк России'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun bankRuCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BankRuCreateTest().withId(T2316::class),
                BankRuGetTest(clientUser).withId(T2394::class),
                BankRuGetTest(adminUser).withId(T2395::class),
                BankRuGetPageTest(clientUser).withId(T2396::class),
                BankRuGetPageTest(adminUser).withId(T2397::class),
                BankRuDeleteTest().withId(T2398::class),
                BankRuUpdateTest().withId(T2399::class)
            )
        )
    }

    @TestFactory
    @T2354 //'Банк России'. Сортировка по полю 'id, ASC' [CLIENT]
    @T2355 //'Банк России'. Сортировка по полю 'bic, ASC' [CLIENT]
    @T2356 //'Банк России'. Сортировка по полю 'zip, ASC' [CLIENT]
    @T2357 //'Банк России'. Сортировка по полю 'phone, ASC' [CLIENT]
    @T2358 //'Банк России'. Сортировка по полю 'address, ASC' [CLIENT]
    @T2359 //'Банк России'. Сортировка по полю 'location, ASC' [CLIENT]
    @T2360 //'Банк России'. Сортировка по полю 'bankName, ASC' [CLIENT]
    @T2361 //'Банк России'. Сортировка по полю 'regNumber, ASC' [CLIENT]
    @T2362 //'Банк России'. Сортировка по полю 'controlDate, ASC' [CLIENT]
    @T2363 //'Банк России'. Сортировка по полю 'corrAccount, ASC' [CLIENT]
    @T2364 //'Банк России'. Сортировка по полю 'locationTypeId, ASC' [CLIENT]
    @T2365 //'Банк России'. Сортировка по полю 'locationType.id, ASC' [CLIENT]
    @T2366 //'Банк России'. Сортировка по полю 'locationType.locationType, ASC' [CLIENT]
    @T2367 //'Банк России'. Сортировка по полю 'controlCodeId, ASC' [CLIENT]
    @T2368 //'Банк России'. Сортировка по полю 'controlCode.id, ASC' [CLIENT]
    @T2369 //'Банк России'. Сортировка по полю 'controlCode.code, ASC' [CLIENT]
    @T2370 //'Банк России'. Сортировка по полю 'controlCode.description, ASC' [CLIENT]
    @T2371 //'Банк России'. Сортировка по полю 'uerId, ASC' [CLIENT]
    @T2372 //'Банк России'. Сортировка по полю 'uer.id, ASC' [CLIENT]
    @T2373 //'Банк России'. Сортировка по полю 'uer.uer, ASC' [CLIENT]
    @T2374 //'Банк России'. Сортировка по полю 'uer.bankType, ASC' [CLIENT]
    @T2375 //'Банк России'. Сортировка по полю 'uer.description, ASC' [CLIENT]
    internal fun bankRuSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankRuSortingTest(user, ID::asc, ID.limit).withId(T2354::class),
                BankRuSortingTest(user, BIC::asc, BIC.limit).withId(T2355::class),
                BankRuSortingTest(user, ZIP::asc, ZIP.limit).withId(T2356::class),
                BankRuSortingTest(user, PHONE::asc, PHONE.limit).withId(T2357::class),
                BankRuSortingTest(user, ADDRESS::asc, ADDRESS.limit).withId(T2358::class),
                BankRuSortingTest(user, LOCATION::asc, LOCATION.limit).withId(T2359::class),
                BankRuSortingTest(user, BANK_NAME::asc, BANK_NAME.limit).withId(T2360::class),
                BankRuSortingTest(user, REG_NUMBER::asc, REG_NUMBER.limit).withId(T2361::class),
                BankRuSortingTest(user, CONTROL_DATE::asc, CONTROL_DATE.limit).withId(T2362::class),
                BankRuSortingTest(user, CORR_ACCOUNT::asc, CORR_ACCOUNT.limit).withId(T2363::class),
                BankRuSortingTest(user, LOCTYPE_ID::asc, LOCTYPE_ID.limit).withId(T2364::class),
                BankRuSortingTest(user, LOCTYPE_NESTED_ID::asc, LOCTYPE_NESTED_ID.limit).withId(T2365::class),
                BankRuSortingTest(user, LOCTYPE_NESTED_TYPE::asc, LOCTYPE_NESTED_TYPE.limit).withId(T2366::class),
                BankRuSortingTest(user, CTRLCODE_ID::asc, CTRLCODE_ID.limit).withId(T2367::class),
                BankRuSortingTest(user, CTRLCODE_NESTED_ID::asc, CTRLCODE_NESTED_ID.limit).withId(T2368::class),
                BankRuSortingTest(user, CTRLCODE_NESTED_CODE::asc, CTRLCODE_NESTED_CODE.limit).withId(T2369::class),
                BankRuSortingTest(user, CTRLCODE_NESTED_DESCR::asc, CTRLCODE_NESTED_DESCR.limit).withId(T2370::class),
                BankRuSortingTest(user, UER_ID::asc, UER_ID.limit).withId(T2371::class),
                BankRuSortingTest(user, UER_NESTED_ID::asc, UER_NESTED_ID.limit).withId(T2372::class),
                BankRuSortingTest(user, UER_NESTED_UER::asc, UER_NESTED_UER.limit).withId(T2373::class),
                BankRuSortingTest(user, UER_NESTED_BANKTYPE::asc, UER_NESTED_BANKTYPE.limit).withId(T2374::class),
                BankRuSortingTest(user, UER_NESTED_DESCR::asc, UER_NESTED_DESCR.limit).withId(T2375::class)
            )
        )
    }

    @TestFactory
    @T2331 //'Банк России'. Сортировка по полю 'id, ASC' [BANK]
    @T2332 //'Банк России'. Сортировка по полю 'bic, ASC' [BANK]
    @T2333 //'Банк России'. Сортировка по полю 'zip, ASC' [BANK]
    @T2334 //'Банк России'. Сортировка по полю 'phone, ASC' [BANK]
    @T2335 //'Банк России'. Сортировка по полю 'address, ASC' [BANK]
    @T2336 //'Банк России'. Сортировка по полю 'location, ASC' [BANK]
    @T2338 //'Банк России'. Сортировка по полю 'bankName, ASC' [BANK]
    @T2339 //'Банк России'. Сортировка по полю 'regNumber, ASC' [BANK]
    @T2340 //'Банк России'. Сортировка по полю 'controlDate, ASC' [BANK]
    @T2341 //'Банк России'. Сортировка по полю 'corrAccount, ASC' [BANK]
    @T2342 //'Банк России'. Сортировка по полю 'locationTypeId, ASC' [BANK]
    @T2343 //'Банк России'. Сортировка по полю 'locationType.id, ASC' [BANK]
    @T2344 //'Банк России'. Сортировка по полю 'locationType.locationType, ASC' [BANK]
    @T2345 //'Банк России'. Сортировка по полю 'controlCodeId, ASC' [BANK]
    @T2346 //'Банк России'. Сортировка по полю 'controlCode.id, ASC' [BANK]
    @T2347 //'Банк России'. Сортировка по полю 'controlCode.code, ASC' [BANK]
    @T2348 //'Банк России'. Сортировка по полю 'controlCode.description, ASC' [BANK]
    @T2349 //'Банк России'. Сортировка по полю 'uerId, ASC' [BANK]
    @T2350 //'Банк России'. Сортировка по полю 'uer.id, ASC' [BANK]
    @T2351 //'Банк России'. Сортировка по полю 'uer.uer, ASC' [BANK]
    @T2352 //'Банк России'. Сортировка по полю 'uer.bankType, ASC' [BANK]
    @T2353 //'Банк России'. Сортировка по полю 'uer.description, ASC' [BANK]
    internal fun bankRuSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                BankRuSortingTest(user, ID::asc, ID.limit).withId(T2331::class),
                BankRuSortingTest(user, BIC::asc, BIC.limit).withId(T2332::class),
                BankRuSortingTest(user, ZIP::asc, ZIP.limit).withId(T2333::class),
                BankRuSortingTest(user, PHONE::asc, PHONE.limit).withId(T2334::class),
                BankRuSortingTest(user, ADDRESS::asc, ADDRESS.limit).withId(T2335::class),
                BankRuSortingTest(user, LOCATION::asc, LOCATION.limit).withId(T2336::class),
                BankRuSortingTest(user, BANK_NAME::asc, BANK_NAME.limit).withId(T2338::class),
                BankRuSortingTest(user, REG_NUMBER::asc, REG_NUMBER.limit).withId(T2339::class),
                BankRuSortingTest(user, CONTROL_DATE::asc, CONTROL_DATE.limit).withId(T2340::class),
                BankRuSortingTest(user, CORR_ACCOUNT::asc, CORR_ACCOUNT.limit).withId(T2341::class),
                BankRuSortingTest(user, LOCTYPE_ID::asc, LOCTYPE_ID.limit).withId(T2342::class),
                BankRuSortingTest(user, LOCTYPE_NESTED_ID::asc, LOCTYPE_NESTED_ID.limit).withId(T2343::class),
                BankRuSortingTest(user, LOCTYPE_NESTED_TYPE::asc, LOCTYPE_NESTED_TYPE.limit).withId(T2344::class),
                BankRuSortingTest(user, CTRLCODE_ID::asc, CTRLCODE_ID.limit).withId(T2345::class),
                BankRuSortingTest(user, CTRLCODE_NESTED_ID::asc, CTRLCODE_NESTED_ID.limit).withId(T2346::class),
                BankRuSortingTest(user, CTRLCODE_NESTED_CODE::asc, CTRLCODE_NESTED_CODE.limit).withId(T2347::class),
                BankRuSortingTest(user, CTRLCODE_NESTED_DESCR::asc, CTRLCODE_NESTED_DESCR.limit).withId(T2348::class),
                BankRuSortingTest(user, UER_ID::asc, UER_ID.limit).withId(T2349::class),
                BankRuSortingTest(user, UER_NESTED_ID::asc, UER_NESTED_ID.limit).withId(T2350::class),
                BankRuSortingTest(user, UER_NESTED_UER::asc, UER_NESTED_UER.limit).withId(T2351::class),
                BankRuSortingTest(user, UER_NESTED_BANKTYPE::asc, UER_NESTED_BANKTYPE.limit).withId(T2352::class),
                BankRuSortingTest(user, UER_NESTED_DESCR::asc, UER_NESTED_DESCR.limit).withId(T2353::class)
            )
        )
    }


    @TestFactory
    @T2400 //'Банк России'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T2401 //'Банк России'. Фильтрация по полю 'bic' (eq) [CLIENT]
    @T2402 //'Банк России'. Фильтрация по полю 'bic' (contains) [CLIENT]
    @T2403 //'Банк России'. Фильтрация по полю 'zip' (eq) [CLIENT]
    @T2404 //'Банк России'. Фильтрация по полю 'zip' (contains) [CLIENT]
    @T2405 //'Банк России'. Фильтрация по полю 'bankName' (eq) [CLIENT]
    @T2406 //'Банк России'. Фильтрация по полю 'bankName' (contains) [CLIENT]
    @T2407 //'Банк России'. Фильтрация по полю 'corrAccount' (eq) [CLIENT]
    @T2408 //'Банк России'. Фильтрация по полю 'corrAccount' (contains) [CLIENT]
    @T2409 //'Банк России'. Фильтрация по полю 'phone' (eq) [CLIENT]
    @T2410 //'Банк России'. Фильтрация по полю 'phone' (contains) [CLIENT]
    @T2411 //'Банк России'. Фильтрация по полю 'address' (eq) [CLIENT]
    @T2412 //'Банк России'. Фильтрация по полю 'address' (contains) [CLIENT]
    @T2413 //'Банк России'. Фильтрация по полю 'location' (eq) [CLIENT]
    @T2414 //'Банк России'. Фильтрация по полю 'location' (contains) [CLIENT]
    @T2415 //'Банк России'. Фильтрация по полю 'regNumber' (eq) [CLIENT]
    @T2416 //'Банк России'. Фильтрация по полю 'regNumber' (contains) [CLIENT]
    @T2417 //'Банк России'. Фильтрация по полю 'controlDate' (eq) [CLIENT]
    internal fun bankRuFiltrationBasicFieldsClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankRuFiltrationTest("id equals", user, { dataForFilter },
                    { BankRuFilterParams.ID.eq(it!!.id!!) }).withId(T2400::class),
                BankRuFiltrationTest("bic equals", user, { dataForFilter },
                    { BankRuFilterParams.BIC.eq(it!!.bic) }).withId(T2401::class),
                BankRuFiltrationTest("bic contains", user, { dataForFilter },
                    { BankRuFilterParams.BIC.contains(it!!.bic) }).withId(T2402::class),
                BankRuFiltrationTest("zip equals", user, { dataForFilter },
                    { BankRuFilterParams.ZIP.eq(it!!.zip) }).withId(T2403::class),
                BankRuFiltrationTest("zip contains", user, { dataForFilter },
                    { BankRuFilterParams.ZIP.contains(it!!.zip) }).withId(T2404::class),
                BankRuFiltrationTest("bankName equals", user, { dataForFilter },
                    { BankRuFilterParams.BANK_NAME.eq(it!!.bankName) }).withId(T2405::class),
                BankRuFiltrationTest("bankName contains", user, { dataForFilter },
                    { BankRuFilterParams.BANK_NAME.contains(it!!.bankName) }).withId(T2406::class),
                BankRuFiltrationTest("corrAccount equals", user, { dataForFilter },
                    { BankRuFilterParams.CORR_ACCOUNT.eq(it!!.corrAccount!!) }).withId(T2407::class),
                BankRuFiltrationTest("corrAccount contains", user, { dataForFilter },
                    { BankRuFilterParams.CORR_ACCOUNT.contains(it!!.corrAccount!!.randomSubstringPf()) }).withId(T2408::class),
                BankRuFiltrationTest("phone equals", user, { dataForFilter },
                    { BankRuFilterParams.PHONE.eq(it!!.phone!!) }).withId(T2409::class),
                BankRuFiltrationTest("phone contains", user, { dataForFilter },
                    { BankRuFilterParams.PHONE.contains(it!!.phone!!.randomSubstringPf()) }).withId(T2410::class),
                BankRuFiltrationTest("address equals", user, { dataForFilter },
                    { BankRuFilterParams.ADDRESS.eq(it!!.address!!) }).withId(T2411::class),
                BankRuFiltrationTest("address contains", user, { dataForFilter },
                    { BankRuFilterParams.ADDRESS.contains(it!!.address!!.randomSubstringPf()) }).withId(T2412::class),
                BankRuFiltrationTest("location equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCATION.eq(it!!.location!!) }).withId(T2413::class),
                BankRuFiltrationTest("location contains", user, { dataForFilter },
                    { BankRuFilterParams.LOCATION.contains(it!!.location!!.randomSubstringPf()) }).withId(T2414::class),
                BankRuFiltrationTest("regNumber equals", user, { dataForFilter },
                    { BankRuFilterParams.REG_NUMBER.eq(it!!.regNumber!!) }).withId(T2415::class),
                BankRuFiltrationTest("regNumber contains", user, { dataForFilter },
                    { BankRuFilterParams.REG_NUMBER.contains(it!!.regNumber!!.randomSubstringPf()) }).withId(T2416::class),
                BankRuFiltrationTest("controlDate equals", user, { dataForFilter },
                    { BankRuFilterParams.CONTROL_DATE.eq(it!!.controlDate!!) }).withId(T2417::class)
            )
        )
    }

    @TestFactory
    @T2376 //'Банк России'. Фильтрация по полю 'id' (eq) [BANK]
    @T2377 //'Банк России'. Фильтрация по полю 'bic' (eq) [BANK]
    @T2378 //'Банк России'. Фильтрация по полю 'bic' (contains) [BANK]
    @T2379 //'Банк России'. Фильтрация по полю 'zip' (eq) [BANK]
    @T2380 //'Банк России'. Фильтрация по полю 'zip' (contains) [BANK]
    @T2381 //'Банк России'. Фильтрация по полю 'bankName' (eq) [BANK]
    @T2382 //'Банк России'. Фильтрация по полю 'bankName' (contains) [BANK]
    @T2383 //'Банк России'. Фильтрация по полю 'corrAccount' (eq) [BANK]
    @T2384 //'Банк России'. Фильтрация по полю 'corrAccount' (contains) [BANK]
    @T2385 //'Банк России'. Фильтрация по полю 'phone' (eq) [BANK]
    @T2386 //'Банк России'. Фильтрация по полю 'phone' (contains) [BANK]
    @T2387 //'Банк России'. Фильтрация по полю 'address' (eq) [BANK]
    @T2388 //'Банк России'. Фильтрация по полю 'address' (contains) [BANK]
    @T2389 //'Банк России'. Фильтрация по полю 'location' (eq) [BANK]
    @T2390 //'Банк России'. Фильтрация по полю 'location' (contains) [BANK]
    @T2391 //'Банк России'. Фильтрация по полю 'regNumber' (eq) [BANK]
    @T2392 //'Банк России'. Фильтрация по полю 'regNumber' (contains) [BANK]
    @T2393 //'Банк России'. Фильтрация по полю 'controlDate' (eq) [BANK]
    internal fun bankRuFiltrationBasicFieldsBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                BankRuFiltrationTest("id equals", user, { dataForFilter },
                    { BankRuFilterParams.ID.eq(it!!.id!!) }).withId(T2376::class),
                BankRuFiltrationTest("bic equals", user, { dataForFilter },
                    { BankRuFilterParams.BIC.eq(it!!.bic) }).withId(T2377::class),
                BankRuFiltrationTest("bic contains", user, { dataForFilter },
                    { BankRuFilterParams.BIC.contains(it!!.bic) }).withId(T2378::class),
                BankRuFiltrationTest("zip equals", user, { dataForFilter },
                    { BankRuFilterParams.ZIP.eq(it!!.zip) }).withId(T2379::class),
                BankRuFiltrationTest("zip contains", user, { dataForFilter },
                    { BankRuFilterParams.ZIP.contains(it!!.zip) }).withId(T2380::class),
                BankRuFiltrationTest("bankName equals", user, { dataForFilter },
                    { BankRuFilterParams.BANK_NAME.eq(it!!.bankName) }).withId(T2381::class),
                BankRuFiltrationTest("bankName contains", user, { dataForFilter },
                    { BankRuFilterParams.BANK_NAME.contains(it!!.bankName) }).withId(T2382::class),

                BankRuFiltrationTest("corrAccount equals", user, { dataForFilter },
                    { BankRuFilterParams.CORR_ACCOUNT.eq(it!!.corrAccount!!) }).withId(T2383::class),
                BankRuFiltrationTest("corrAccount contains", user, { dataForFilter },
                    { BankRuFilterParams.CORR_ACCOUNT.contains(it!!.corrAccount!!.randomSubstringPf()) }).withId(T2384::class),
                BankRuFiltrationTest("phone equals", user, { dataForFilter },
                    { BankRuFilterParams.PHONE.eq(it!!.phone!!) }).withId(T2385::class),
                BankRuFiltrationTest("phone contains", user, { dataForFilter },
                    { BankRuFilterParams.PHONE.contains(it!!.phone!!.randomSubstringPf()) }).withId(T2386::class),
                BankRuFiltrationTest("address equals", user, { dataForFilter },
                    { BankRuFilterParams.ADDRESS.eq(it!!.address!!) }).withId(T2387::class),
                BankRuFiltrationTest("address contains", user, { dataForFilter },
                    { BankRuFilterParams.ADDRESS.contains(it!!.address!!.randomSubstringPf()) }).withId(T2388::class),
                BankRuFiltrationTest("location equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCATION.eq(it!!.location!!) }).withId(T2389::class),
                BankRuFiltrationTest("location contains", user, { dataForFilter },
                    { BankRuFilterParams.LOCATION.contains(it!!.location!!.randomSubstringPf()) }).withId(T2390::class),
                BankRuFiltrationTest("regNumber equals", user, { dataForFilter },
                    { BankRuFilterParams.REG_NUMBER.eq(it!!.regNumber!!) }).withId(T2391::class),
                BankRuFiltrationTest("regNumber contains", user, { dataForFilter },
                    { BankRuFilterParams.REG_NUMBER.contains(it!!.regNumber!!.randomSubstringPf()) }).withId(T2392::class),
                BankRuFiltrationTest("controlDate equals", user, { dataForFilter },
                    { BankRuFilterParams.CONTROL_DATE.eq(it!!.controlDate!!) }).withId(T2393::class)
            )
        )
    }

    @TestFactory
    @T2317 //'Банк России'. Фильтрация по полю 'locationTypeId' (eq) [CLIENT]
    @T2318 //'Банк России'. Фильтрация по полю 'locationType.id' (eq) [CLIENT]
    @T2319 //'Банк России'. Фильтрация по полю 'locationType.locationType' (eq) [CLIENT]
    @T2320 //'Банк России'. Фильтрация по полю 'controlCodeId' (eq) [CLIENT]
    @T2321 //'Банк России'. Фильтрация по полю 'controlCode.id' (eq) [CLIENT]
    @T2322 //'Банк России'. Фильтрация по полю 'controlCode.code' (eq) [CLIENT]
    @T2323 //'Банк России'. Фильтрация по полю 'controlCode.description' (eq) [CLIENT]
    @T2324 //'Банк России'. Фильтрация по полю 'controlCode.description' (contains) [CLIENT]
    @T2325 //'Банк России'. Фильтрация по полю 'uerId' (eq) [CLIENT]
    @T2326 //'Банк России'. Фильтрация по полю 'uer.id' (eq) [CLIENT]
    @T2327 //'Банк России'. Фильтрация по полю 'uer.uer' (eq) [CLIENT]
    @T2328 //'Банк России'. Фильтрация по полю 'uer.bankType' (eq) [CLIENT]
    @T2329 //'Банк России'. Фильтрация по полю 'uer.description' (eq) [CLIENT]
    @T2330 //'Банк России'. Фильтрация по полю 'uer.description' (contains) [CLIENT]
    internal fun bankRuFiltrationWithNestedFieldsClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankRuFiltrationTest("idLocationType equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCTYPE_ID.eq(it!!.idLocationType!!) }).withId(T2317::class),
                BankRuFiltrationTest("locationType.id equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCTYPE_NESTED_ID.eq(it!!.locationType!!.id!!) }).withId(T2318::class),
                BankRuFiltrationTest("locationType.locationType equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCTYPE_NESTED_TYPE.eq(it!!.locationType!!.locationType!!) }).withId(T2319::class),

                BankRuFiltrationTest("idControlCode equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_ID.eq(it!!.idControlCode!!) }).withId(T2320::class),
                BankRuFiltrationTest("controlCode.id equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_ID.eq(it!!.controlCode!!.id!!) }).withId(T2321::class),
                BankRuFiltrationTest("controlCode.code equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_CODE.eq(it!!.controlCode!!.code!!) }).withId(T2322::class),
                BankRuFiltrationTest("controlCode.description equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_DESCR.eq(it!!.controlCode!!.description!!) }).withId(T2323::class),
                BankRuFiltrationTest("controlCode.description contains", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_DESCR.contains((it!!.controlCode!!.description!!).randomSubstringPf()) }).withId(T2324::class),

                BankRuFiltrationTest("idUer equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_ID.eq(it!!.idUer) }).withId(T2325::class),
                BankRuFiltrationTest("uer.id equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_ID.eq(it!!.uer!!.id!!) }).withId(T2326::class),
                BankRuFiltrationTest("uer.uer equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_UER.eq(it!!.uer!!.uer) }).withId(T2327::class),
                BankRuFiltrationTest("uer.bankType equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_BANKTYPE.eq(it!!.uer!!.bankType) }).withId(T2328::class),
                BankRuFiltrationTest("uer.description equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_DESCR.eq(it!!.uer!!.description) }).withId(T2329::class),
                BankRuFiltrationTest("uer.description contains", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_DESCR.contains(it!!.uer!!.description.randomSubstringPf()) }).withId(T2330::class)
            )
        )
    }


    @TestFactory
    @T2433 //'Банк России'. Фильтрация по полю 'locationTypeId' (eq) [BANK]
    @T2434 //'Банк России'. Фильтрация по полю 'locationType.id' (eq) [BANK]
    @T2435 //'Банк России'. Фильтрация по полю 'locationType.locationType' (eq) [BANK]
    @T2436 //'Банк России'. Фильтрация по полю 'controlCodeId' (eq) [BANK]
    @T2437 //'Банк России'. Фильтрация по полю 'controlCode.id' (eq) [BANK]
    @T2438 //'Банк России'. Фильтрация по полю 'controlCode.code' (eq) [BANK]
    @T2439 //'Банк России'. Фильтрация по полю 'controlCode.description' (eq) [BANK]
    @T2440 //'Банк России'. Фильтрация по полю 'controlCode.description' (contains) [BANK]
    @T2441 //'Банк России'. Фильтрация по полю 'uerId' (eq) [BANK]
    @T2442 //'Банк России'. Фильтрация по полю 'uer.id' (eq) [BANK]
    @T2443 //'Банк России'. Фильтрация по полю 'uer.uer' (eq) [BANK]
    @T2444 //'Банк России'. Фильтрация по полю 'uer.bankType' (eq) [BANK]
    @T2445 //'Банк России'. Фильтрация по полю 'uer.description' (eq) [BANK]
    @T2446 //'Банк России'. Фильтрация по полю 'uer.description' (contains) [BANK]
    internal fun bankRuFiltrationWithNestedFieldsBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                BankRuFiltrationTest("idLocationType equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCTYPE_ID.eq(it!!.idLocationType!!) }).withId(T2433::class),
                BankRuFiltrationTest("locationType.id equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCTYPE_NESTED_ID.eq(it!!.locationType!!.id!!) }).withId(T2434::class),
                BankRuFiltrationTest("locationType.locationType equals", user, { dataForFilter },
                    { BankRuFilterParams.LOCTYPE_NESTED_TYPE.eq(it!!.locationType!!.locationType!!) }).withId(T2435::class),

                BankRuFiltrationTest("idControlCode equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_ID.eq(it!!.idControlCode!!) }).withId(T2436::class),
                BankRuFiltrationTest("controlCode.id equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_ID.eq(it!!.controlCode!!.id!!) }).withId(T2437::class),
                BankRuFiltrationTest("controlCode.code equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_CODE.eq(it!!.controlCode!!.code!!) }).withId(T2438::class),
                BankRuFiltrationTest("controlCode.description equals", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_DESCR.eq(it!!.controlCode!!.description!!) }).withId(T2439::class),
                BankRuFiltrationTest("controlCode.description contains", user, { dataForFilter },
                    { BankRuFilterParams.CTRLCODE_NESTED_DESCR.contains((it!!.controlCode!!.description!!).randomSubstringPf()) }).withId(T2440::class),

                BankRuFiltrationTest("idUer equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_ID.eq(it!!.idUer) }).withId(T2441::class),
                BankRuFiltrationTest("uer.id equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_ID.eq(it!!.uer!!.id!!) }).withId(T2442::class),
                BankRuFiltrationTest("uer.uer equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_UER.eq(it!!.uer!!.uer) }).withId(T2443::class),
                BankRuFiltrationTest("uer.bankType equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_BANKTYPE.eq(it!!.uer!!.bankType) }).withId(T2444::class),
                BankRuFiltrationTest("uer.description equals", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_DESCR.eq(it!!.uer!!.description) }).withId(T2445::class),
                BankRuFiltrationTest("uer.description contains", user, { dataForFilter },
                    { BankRuFilterParams.UER_NESTED_DESCR.contains(it!!.uer!!.description.randomSubstringPf()) }).withId(T2446::class)
            )
        )
    }

    private fun getBankByBicBody(user: User, bankBic: String) {
        val response = BankRuSteps(user).getBanksByBic(bankBic)
        val actResult = response.list!!

        "Проверить, что в ответе вернулись банки с ожидаемым БИК = '{bankBic}'" {
            val expResult: List<BankRuDto> = BankRuData
                .get { bankBic == it.bic }
                .map { it.toDto() }

            assertThat("Количество банков не совпадает с ожидаемым", actResult.size, equalTo(expResult.size))
            assertThat(
                "Фактический результат не совпадает с ожидаемым",
                actResult, containsInAnyOrder(*expResult.toTypedArray())
            )
        }
    }

    @TestFactory
    @T2431 //Банк России. Получение списка Банков РФ по БИК'у [CLIENT]
    @T2432 //Банк России. Получение списка Банков РФ по БИК'у [BANK]
    internal fun getBankByBicTest(): List<DynamicTest> {
        val testName = "'${DictionaryNames.BANK_RU}'. Получение списка Банков РФ по БИК'у"
        val bicClient = BankRuData.randomOrException().bic
        val bicBank = BankRuData.randomOrException().bic
        return EntityTestGenerator.generate(listOf(
            UnitBeTest(
                name = "$testName [${clientUser.userType}]",
                params = { mapOf(PARAM_USER to clientUser, "Банк" to bicClient) },
                testBody = { getBankByBicBody(clientUser, bicClient) }
            ).withId(T2431::class),
            UnitBeTest(
                name = "$testName [${adminUser.userType}]",
                params = { mapOf(PARAM_USER to adminUser, "Банк" to bicBank) },
                testBody = { getBankByBicBody(adminUser, bicBank) }
            ).withId(T2432::class))
            .map {
                it
                    .withFolder(BankRuFolderOther::class)
                    .withPriority(Tm4jPriority.Normal)
                    .withComponent(Tm4jComponent.DICTIONARY)
                    .withTaskIds(Tm4jEpic.EPIC_R_RKO_DICTIONARY)
            }
        )
    }
}