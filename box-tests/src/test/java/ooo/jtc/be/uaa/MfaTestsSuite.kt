package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_MFA
import ooo.jtc.api.uaa.tests.MfaCreateTest
import ooo.jtc.api.uaa.tests.MfaDeleteTest
import ooo.jtc.api.uaa.tests.MfaFilterTests
import ooo.jtc.api.uaa.tests.MfaGetPageTest
import ooo.jtc.api.uaa.tests.MfaGetTest
import ooo.jtc.api.uaa.tests.MfaSortingTest
import ooo.jtc.api.uaa.tests.MfaUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.uaa.mfa.MfaData
import ooo.jtc.testdata.uaa.mfa.MfaFilterParams.DESCRIPTION
import ooo.jtc.testdata.uaa.mfa.MfaFilterParams.ID
import ooo.jtc.testdata.uaa.mfa.MfaFilterParams.MFA_TYPE
import ooo.jtc.testdata.uaa.mfa.MfaFilterParams.NAME
import ooo.jtc.testdata.uaa.mfa.MfaFilterParams.TITLE
import ooo.jtc.testdata.uaa.mfa.MfaSortingParams
import ooo.jtc.uaa.mfa.dto.MfaDto
import ooo.jtc.uaa.mfa.model.Mfa
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.UAA)
@Story(UaaNames.MFA)
@DisplayName("API '${UaaNames.MFA}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_UAA_MFA
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MfaTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3409") annotation class T3409
@Tag("JTCSALTO-T3410") annotation class T3410
@Tag("JTCSALTO-T3411") annotation class T3411
@Tag("JTCSALTO-T3412") annotation class T3412
@Tag("JTCSALTO-T3413") annotation class T3413
@Tag("JTCSALTO-T3414") annotation class T3414
@Tag("JTCSALTO-T3415") annotation class T3415
@Tag("JTCSALTO-T3416") annotation class T3416
@Tag("JTCSALTO-T3417") annotation class T3417
@Tag("JTCSALTO-T3418") annotation class T3418
@Tag("JTCSALTO-T3419") annotation class T3419
@Tag("JTCSALTO-T3420") annotation class T3420
@Tag("JTCSALTO-T3421") annotation class T3421
@Tag("JTCSALTO-T3422") annotation class T3422
@Tag("JTCSALTO-T3423") annotation class T3423
@Tag("JTCSALTO-T3424") annotation class T3424
@Tag("JTCSALTO-T3425") annotation class T3425
@Tag("JTCSALTO-T3426") annotation class T3426
@Tag("JTCSALTO-T3427") annotation class T3427
@Tag("JTCSALTO-T3428") annotation class T3428
@Tag("JTCSALTO-T3429") annotation class T3429
@Tag("JTCSALTO-T3430") annotation class T3430
@Tag("JTCSALTO-T3431") annotation class T3431
@Tag("JTCSALTO-T3432") annotation class T3432
//@formatter:on
//endregion

    private lateinit var dataForFilter: MfaDto
    private lateinit var testDataScope: TestDataScope<Mfa>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = MfaData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T3428 //'МФА'. CRUD: Создаем запись от пользователя [BANK]
    @T3429 //'МФА'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3430 //'МФА'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3431 //'МФА'. CRUD: Удаляем запись от пользователя [BANK]
    @T3432 //'МФА'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun mfaCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MfaCreateTest().withId(T3428::class),
                MfaGetTest().withId(T3429::class),
                MfaGetPageTest().withId(T3430::class),
                MfaDeleteTest().withId(T3431::class),
                MfaUpdateTest().withId(T3432::class)
            )
        )
    }

    @TestFactory
    @T3418 //'МФА'. Сортировка по полю 'id, ASC' [BANK]
    @T3419 //'МФА'. Сортировка по полю 'mfaType, ASC' [BANK]
    @T3420 //'МФА'. Сортировка по полю 'name, ASC' [BANK]
    @T3421 //'МФА'. Сортировка по полю 'title, ASC' [BANK]
    @T3422 //'МФА'. Сортировка по полю 'description, ASC' [BANK]

    @T3423 //'МФА'. Сортировка по полю 'id, DESC' [BANK]
    @T3424 //'МФА'. Сортировка по полю 'mfaType, DESC' [BANK]
    @T3425 //'МФА'. Сортировка по полю 'name, DESC' [BANK]
    @T3426 //'МФА'. Сортировка по полю 'title, DESC' [BANK]
    @T3427 //'МФА'. Сортировка по полю 'description, DESC' [BANK]
    internal fun mfaSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MfaSortingTest(MfaSortingParams.ID::asc).withId(T3418::class),
                MfaSortingTest(MfaSortingParams.MFA_TYPE::asc).withId(T3419::class),
                MfaSortingTest(MfaSortingParams.NAME::asc).withId(T3420::class),
                MfaSortingTest(MfaSortingParams.TITLE::asc).withId(T3421::class),
                MfaSortingTest(MfaSortingParams.DESCRIPTION::asc).withId(T3422::class),

                MfaSortingTest(MfaSortingParams.ID::desc).withId(T3423::class),
                MfaSortingTest(MfaSortingParams.MFA_TYPE::desc).withId(T3424::class),
                MfaSortingTest(MfaSortingParams.NAME::desc).withId(T3425::class),
                MfaSortingTest(MfaSortingParams.TITLE::desc).withId(T3426::class),
                MfaSortingTest(MfaSortingParams.DESCRIPTION::desc).withId(T3427::class)
            )
        )
    }

    @TestFactory
    @T3409 //'МФА'. Фильтрация по полю 'id' (eq) [BANK]
    @T3410 //'МФА'. Фильтрация по полю 'mfaType' (eq) [BANK]
    @T3411 //'МФА'. Фильтрация по полю 'mfaType' (contains) [BANK]
    @T3412 //'МФА'. Фильтрация по полю 'name' (eq) [BANK]
    @T3413 //'МФА'. Фильтрация по полю 'name' (contains) [BANK]
    @T3414 //'МФА'. Фильтрация по полю 'title' (eq) [BANK]
    @T3415 //'МФА'. Фильтрация по полю 'title' (contains) [BANK]
    @T3416 //'МФА'. Фильтрация по полю 'description' (eq) [BANK]
    @T3417 //'МФА'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun mfaFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MfaFilterTests("id equals", { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3409::class),
                MfaFilterTests("mfaType equals", { dataForFilter },
                    { MFA_TYPE.eq(it!!.mfaType) }).withId(T3410::class),
                MfaFilterTests("mfaType contains", { dataForFilter },
                    { MFA_TYPE.contains(it!!.mfaType.randomSubstringPf()) }).withId(T3411::class),
                MfaFilterTests("name equals", { dataForFilter },
                    { NAME.eq(it!!.name) }).withId(T3412::class),
                MfaFilterTests("name contains", { dataForFilter },
                    { NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3413::class),
                MfaFilterTests("title equals", { dataForFilter },
                    { TITLE.eq(it!!.title) }).withId(T3414::class),
                MfaFilterTests("title contains", { dataForFilter },
                    { TITLE.contains(it!!.title.randomSubstringPf()) }).withId(T3415::class),
                MfaFilterTests("description equals", { dataForFilter },
                    { DESCRIPTION.eq(it!!.description) }).withId(T3416::class),
                MfaFilterTests("description contains", { dataForFilter },
                    { DESCRIPTION.contains(it!!.description.randomSubstringPf()) }).withId(T3417::class)
            )
        )
    }
}