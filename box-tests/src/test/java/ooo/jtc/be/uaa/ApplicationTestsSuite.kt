package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_APPLICATION
import ooo.jtc.api.uaa.tests.ApplicationCreateTest
import ooo.jtc.api.uaa.tests.ApplicationDeleteTest
import ooo.jtc.api.uaa.tests.ApplicationFilterTests
import ooo.jtc.api.uaa.tests.ApplicationGetPageTest
import ooo.jtc.api.uaa.tests.ApplicationGetTest
import ooo.jtc.api.uaa.tests.ApplicationSortingTest
import ooo.jtc.api.uaa.tests.ApplicationUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.uaa.application.ApplicationData
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.ACCESS_TOKEN_LIFE_TIME
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.AUTO_APPROVE_SCOPES
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.CLIENT_ID
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.DESCRIPTION
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.ID
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.NAME
import ooo.jtc.testdata.uaa.application.ApplicationFilterParams.REDIRECT_URLS
import ooo.jtc.testdata.uaa.application.ApplicationSortingParams
import ooo.jtc.uaa.application.dto.ApplicationDto
import ooo.jtc.uaa.application.model.Application
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
@Feature(TestFeature.UAA)
@Story(UaaNames.APPLICATION)
@DisplayName("API '${UaaNames.APPLICATION}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_UAA_APPLICATION
@TestInstance(PER_CLASS)
class ApplicationTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3349") annotation class T3349
@Tag("JTCSALTO-T3350") annotation class T3350
@Tag("JTCSALTO-T3351") annotation class T3351
@Tag("JTCSALTO-T3352") annotation class T3352
@Tag("JTCSALTO-T3353") annotation class T3353
@Tag("JTCSALTO-T3354") annotation class T3354
@Tag("JTCSALTO-T3355") annotation class T3355
@Tag("JTCSALTO-T3356") annotation class T3356
@Tag("JTCSALTO-T3357") annotation class T3357
@Tag("JTCSALTO-T3358") annotation class T3358
@Tag("JTCSALTO-T3359") annotation class T3359
@Tag("JTCSALTO-T3360") annotation class T3360
@Tag("JTCSALTO-T3361") annotation class T3361
@Tag("JTCSALTO-T3362") annotation class T3362
@Tag("JTCSALTO-T3363") annotation class T3363
@Tag("JTCSALTO-T3364") annotation class T3364
@Tag("JTCSALTO-T3365") annotation class T3365
@Tag("JTCSALTO-T3366") annotation class T3366
@Tag("JTCSALTO-T3367") annotation class T3367
@Tag("JTCSALTO-T3368") annotation class T3368
@Tag("JTCSALTO-T3369") annotation class T3369
@Tag("JTCSALTO-T3370") annotation class T3370
@Tag("JTCSALTO-T3371") annotation class T3371
@Tag("JTCSALTO-T3372") annotation class T3372
@Tag("JTCSALTO-T3373") annotation class T3373
@Tag("JTCSALTO-T3374") annotation class T3374
@Tag("JTCSALTO-T3375") annotation class T3375
@Tag("JTCSALTO-T3376") annotation class T3376
//@formatter:on
//endregion

    private lateinit var dataForFilter: ApplicationDto
    private lateinit var testDataScope: TestDataScope<Application>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = ApplicationData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3349 //'Приложение'. CRUD: Создаем запись от пользователя [BANK]
    @T3350 //'Приложение'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3351 //'Приложение'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3352 //'Приложение'. CRUD: Удаляем запись от пользователя [BANK]
    @T3353 //'Приложение'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun crudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ApplicationCreateTest().withId(T3349::class),
                ApplicationGetTest().withId(T3350::class),
                ApplicationGetPageTest().withId(T3351::class),
                ApplicationDeleteTest().withId(T3352::class),
                ApplicationUpdateTest().withId(T3353::class)
            )
        )
    }

    @TestFactory
    @T3363 //'Приложение'. Сортировка по полю 'id, ASC' [BANK]
    @T3364 //'Приложение'. Сортировка по полю 'clientId, ASC' [BANK]
    @T3365 //'Приложение'. Сортировка по полю 'accessTokenLifeTime, ASC' [BANK]
    @T3366 //'Приложение'. Сортировка по полю 'autoApproveScopes, ASC' [BANK]
    @T3367 //'Приложение'. Сортировка по полю 'description, ASC' [BANK]
    @T3368 //'Приложение'. Сортировка по полю 'name, ASC' [BANK]
    @T3369 //'Приложение'. Сортировка по полю 'redirectUrls, ASC' [BANK]

    @T3370 //'Приложение'. Сортировка по полю 'id, DESC' [BANK]
    @T3371 //'Приложение'. Сортировка по полю 'clientId, DESC' [BANK]
    @T3372 //'Приложение'. Сортировка по полю 'accessTokenLifeTime, DESC' [BANK]
    @T3373 //'Приложение'. Сортировка по полю 'autoApproveScopes, DESC' [BANK]
    @T3374 //'Приложение'. Сортировка по полю 'description, DESC' [BANK]
    @T3375 //'Приложение'. Сортировка по полю 'name, DESC' [BANK]
    @T3376 //'Приложение'. Сортировка по полю 'redirectUrls, DESC' [BANK]
    internal fun applicationSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ApplicationSortingTest(ApplicationSortingParams.ID::asc).withId(T3363::class),
                ApplicationSortingTest(ApplicationSortingParams.CLIENT_ID::asc).withId(T3364::class),
                ApplicationSortingTest(ApplicationSortingParams.ACCESS_TOKEN_LIFE_TIME::asc).withId(T3365::class),
                ApplicationSortingTest(ApplicationSortingParams.AUTO_APPROVE_SCOPES::asc).withId(T3366::class),
                ApplicationSortingTest(ApplicationSortingParams.DESCRIPTION::asc).withId(T3367::class),
                ApplicationSortingTest(ApplicationSortingParams.NAME::asc).withId(T3368::class),
                ApplicationSortingTest(ApplicationSortingParams.REDIRECT_URLS::asc).withId(T3369::class),

                ApplicationSortingTest(ApplicationSortingParams.ID::desc).withId(T3370::class),
                ApplicationSortingTest(ApplicationSortingParams.CLIENT_ID::desc).withId(T3371::class),
                ApplicationSortingTest(ApplicationSortingParams.ACCESS_TOKEN_LIFE_TIME::desc).withId(T3372::class),
                ApplicationSortingTest(ApplicationSortingParams.AUTO_APPROVE_SCOPES::desc).withId(T3373::class),
                ApplicationSortingTest(ApplicationSortingParams.DESCRIPTION::desc).withId(T3374::class),
                ApplicationSortingTest(ApplicationSortingParams.NAME::desc).withId(T3375::class),
                ApplicationSortingTest(ApplicationSortingParams.REDIRECT_URLS::desc).withId(T3376::class)
            )
        )
    }


    @TestFactory
    @T3354 //'Приложение'. Фильтрация по полю 'id' (eq) [BANK]
    @T3355 //'Приложение'. Фильтрация по полю 'clientId' (eq) [BANK]
    @T3356 //'Приложение'. Фильтрация по полю 'accessTokenLifeTime' (eq) [BANK]
    @T3357 //'Приложение'. Фильтрация по полю 'autoApproveScopes' (eq) [BANK]
    @T3358 //'Приложение'. Фильтрация по полю 'description' (eq) [BANK]
    @T3359 //'Приложение'. Фильтрация по полю 'description' (contains) [BANK]
    @T3360 //'Приложение'. Фильтрация по полю 'name' (eq) [BANK]
    @T3361 //'Приложение'. Фильтрация по полю 'name' (contains) [BANK]
    @T3362 //'Приложение'. Фильтрация по полю 'redirectUrls' (eq) [BANK]
    internal fun applicationFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ApplicationFilterTests("id equals", { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3354::class),
                ApplicationFilterTests("clientId equals", { dataForFilter },
                    { CLIENT_ID.eq(it!!.clientId!!) }).withId(T3355::class),
                ApplicationFilterTests("accessTokenLifeTime equals", { dataForFilter },
                    { ACCESS_TOKEN_LIFE_TIME.eq(it!!.accessTokenLifeTime!!) }).withId(T3356::class),
                ApplicationFilterTests("autoApproveScopes equals", { dataForFilter },
                    { AUTO_APPROVE_SCOPES.eq(it!!.autoApproveScopes) }).withId(T3357::class),
                ApplicationFilterTests("description equals", { dataForFilter },
                    { DESCRIPTION.eq(it!!.description) }).withId(T3358::class),
                ApplicationFilterTests("description contains", { dataForFilter },
                    { DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3359::class),
                ApplicationFilterTests("name equals", { dataForFilter },
                    { NAME.eq(it!!.name) }).withId(T3360::class),
                ApplicationFilterTests("name contains", { dataForFilter },
                    { NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3361::class),
                ApplicationFilterTests("redirectUrls equals", { dataForFilter },
                    { REDIRECT_URLS.eq(it!!.redirectUrls ?: "") }).withId(T3362::class)
            )
        )
    }
}