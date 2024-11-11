package ooo.jtc.be.uaa

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_UAA_USER
import ooo.jtc.api.uaa.prepare.PrepareUaaUserData
import ooo.jtc.api.uaa.steps.UaaUserSteps
import ooo.jtc.api.uaa.tests.UaaUserCreateTest
import ooo.jtc.api.uaa.tests.UaaUserDeleteTest
import ooo.jtc.api.uaa.tests.UaaUserFilterTests
import ooo.jtc.api.uaa.tests.UaaUserGetPageTest
import ooo.jtc.api.uaa.tests.UaaUserGetTest
import ooo.jtc.api.uaa.tests.UaaUserSortingTest
import ooo.jtc.api.uaa.tests.UaaUserUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.UaaNames
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.uaa.user.UaaUserData
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.BLOCK_REASON
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.BLOCK_USER
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.ID
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.PERMANENT_BLOCKED
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.PREFERRED_LOCALE
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.TEMPORARY_BLOCKED
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.TEMPORARY_BLOCKED_UNTIL
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.USER_DETAILS_EMAIL
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.USER_DETAILS_FIRST_NAME
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.USER_DETAILS_LAST_NAME
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.USER_DETAILS_MIDDLE_NAME
import ooo.jtc.testdata.uaa.user.UaaUserFilterParams.USER_DETAILS_PHONE
import ooo.jtc.testdata.uaa.user.UaaUserSortingParams
import ooo.jtc.uaa.user.model.UaaUser
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
@Story(UaaNames.USER)
@DisplayName("API '${UaaNames.USER}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_UAA_USER
@TestInstance(PER_CLASS)
class UaaUserTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3472") annotation class T3472
@Tag("JTCSALTO-T3473") annotation class T3473
@Tag("JTCSALTO-T3474") annotation class T3474
@Tag("JTCSALTO-T3475") annotation class T3475
@Tag("JTCSALTO-T3476") annotation class T3476
@Tag("JTCSALTO-T3477") annotation class T3477
@Tag("JTCSALTO-T3478") annotation class T3478
@Tag("JTCSALTO-T3479") annotation class T3479
@Tag("JTCSALTO-T3480") annotation class T3480
@Tag("JTCSALTO-T3481") annotation class T3481
@Tag("JTCSALTO-T3482") annotation class T3482
@Tag("JTCSALTO-T3483") annotation class T3483
@Tag("JTCSALTO-T3484") annotation class T3484
@Tag("JTCSALTO-T3485") annotation class T3485
@Tag("JTCSALTO-T3486") annotation class T3486
@Tag("JTCSALTO-T3487") annotation class T3487
@Tag("JTCSALTO-T3488") annotation class T3488
@Tag("JTCSALTO-T3489") annotation class T3489
@Tag("JTCSALTO-T3490") annotation class T3490
@Tag("JTCSALTO-T3491") annotation class T3491
@Tag("JTCSALTO-T3492") annotation class T3492
@Tag("JTCSALTO-T3493") annotation class T3493
@Tag("JTCSALTO-T3494") annotation class T3494
@Tag("JTCSALTO-T3495") annotation class T3495
@Tag("JTCSALTO-T3496") annotation class T3496
@Tag("JTCSALTO-T3497") annotation class T3497
@Tag("JTCSALTO-T3498") annotation class T3498
@Tag("JTCSALTO-T3499") annotation class T3499
@Tag("JTCSALTO-T3500") annotation class T3500
@Tag("JTCSALTO-T3501") annotation class T3501
@Tag("JTCSALTO-T3502") annotation class T3502
@Tag("JTCSALTO-T3503") annotation class T3503
@Tag("JTCSALTO-T3504") annotation class T3504
@Tag("JTCSALTO-T3505") annotation class T3505
@Tag("JTCSALTO-T3506") annotation class T3506
@Tag("JTCSALTO-T3507") annotation class T3507
@Tag("JTCSALTO-T3508") annotation class T3508
@Tag("JTCSALTO-T3509") annotation class T3509
@Tag("JTCSALTO-T3510") annotation class T3510
@Tag("JTCSALTO-T3511") annotation class T3511
@Tag("JTCSALTO-T3512") annotation class T3512
@Tag("JTCSALTO-T3513") annotation class T3513
@Tag("JTCSALTO-T3514") annotation class T3514
@Tag("JTCSALTO-T3515") annotation class T3515
@Tag("JTCSALTO-T3516") annotation class T3516
@Tag("JTCSALTO-T3517") annotation class T3517
@Tag("JTCSALTO-T3518") annotation class T3518
@Tag("JTCSALTO-T3519") annotation class T3519
@Tag("JTCSALTO-T3520") annotation class T3520
@Tag("JTCSALTO-T3521") annotation class T3521
//@formatter:on
//endregion

    private lateinit var testDataScope: TestDataScope<UaaUser>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = UaaUserData.withRequiredFields(
            additionalFilter = { it.tempBlock },
            customCreator = { UaaUserSteps().create(PrepareUaaUserData.prepareTempBlockedUaaUserDtoForCreate()).data!!.toModel() }
        )
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    /* data for filtration tests */
    private val dataForFilter by lazy {
        val uaaUserDto = (UaaUserData.get().find { it.prefLocale != null }?.toDto()
            ?: throw RuntimeException("Не найдено УааПользователя для тестов на фильтрацию"))
        uaaUserDto
    }

    private val permBlockDataForFilterDelegate = lazy {
        val dtoForCreate = PrepareUaaUserData.preparePermBlockedUaaUserDtoForCreate()
        PrepareUaaUserData.createUaaUser(dtoForCreate)
    }
    private val permBlockDataForFilter by permBlockDataForFilterDelegate

    private val tempBlockDataForFilterDelegate = lazy {
        val dtoForCreate = PrepareUaaUserData.prepareTempBlockedUaaUserDtoForCreate()
        PrepareUaaUserData.createUaaUser(dtoForCreate)
    }
    private val tempBlockDataForFilter by tempBlockDataForFilterDelegate

    @AfterAll
    fun tearDown() {
        if (permBlockDataForFilterDelegate.isInitialized()) {
            UaaUserSteps().delete(permBlockDataForFilter.id!!)
        }
        if (tempBlockDataForFilterDelegate.isInitialized()) {
            UaaUserSteps().delete(tempBlockDataForFilter.id!!)
        }
    }

    @TestFactory
    @T3472 //'УааПользователь'. CRUD: Создаем запись от пользователя [BANK]
    @T3473 //'УааПользователь'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3474 //'УааПользователь'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3475 //'УааПользователь'. CRUD: Удаляем запись от пользователя [BANK]
    @T3476 //'УааПользователь'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun uaaUserCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UaaUserCreateTest().withId(T3472::class),
                UaaUserGetTest().withId(T3473::class),
                UaaUserGetPageTest().withId(T3474::class),
                UaaUserDeleteTest().withId(T3475::class),
                UaaUserUpdateTest().withId(T3476::class)
            )
        )
    }

    @TestFactory
    @T3498 //'УааПользователь'. Сортировка по полю 'id, ASC' [BANK]
    @T3499 //'УааПользователь'. Сортировка по полю 'blockReason, ASC' [BANK]
    @T3500 //'УааПользователь'. Сортировка по полю 'blockUser, ASC' [BANK]
    @T3501 //'УааПользователь'. Сортировка по полю 'permanentBlocked, ASC' [BANK]
    @T3502 //'УааПользователь'. Сортировка по полю 'preferredLocale, ASC' [BANK]
    @T3503 //'УааПользователь'. Сортировка по полю 'temporaryBlocked, ASC' [BANK]
    @T3504 //'УааПользователь'. Сортировка по полю 'temporaryBlockedUntil, ASC' [BANK]
    @T3505 //'УааПользователь'. Сортировка по полю 'userDetails.firstName, ASC' [BANK]
    @T3506 //'УааПользователь'. Сортировка по полю 'userDetails.middleName, ASC' [BANK]
    @T3507 //'УааПользователь'. Сортировка по полю 'userDetails.lastName, ASC' [BANK]
    @T3508 //'УааПользователь'. Сортировка по полю 'userDetails.email, ASC' [BANK]
    @T3509 //'УааПользователь'. Сортировка по полю 'userDetails.phoneNumber, ASC' [BANK]

    @T3510 //'УааПользователь'. Сортировка по полю 'id, DESC' [BANK]
    @T3511 //'УааПользователь'. Сортировка по полю 'blockReason, DESC' [BANK]
    @T3512 //'УааПользователь'. Сортировка по полю 'blockUser, DESC' [BANK]
    @T3513 //'УааПользователь'. Сортировка по полю 'permanentBlocked, DESC' [BANK]
    @T3514 //'УааПользователь'. Сортировка по полю 'preferredLocale, DESC' [BANK]
    @T3515 //'УааПользователь'. Сортировка по полю 'temporaryBlocked, DESC' [BANK]
    @T3516 //'УааПользователь'. Сортировка по полю 'temporaryBlockedUntil, DESC' [BANK]
    @T3517 //'УааПользователь'. Сортировка по полю 'userDetails.firstName, DESC' [BANK]
    @T3518 //'УааПользователь'. Сортировка по полю 'userDetails.middleName, DESC' [BANK]
    @T3519 //'УааПользователь'. Сортировка по полю 'userDetails.lastName, DESC' [BANK]
    @T3520 //'УааПользователь'. Сортировка по полю 'userDetails.email, DESC' [BANK]
    @T3521 //'УааПользователь'. Сортировка по полю 'userDetails.phoneNumber, DESC' [BANK]
    internal fun uaaUserSortingTests(): List<DynamicTest> {
        permBlockDataForFilter
        tempBlockDataForFilter
        return EntityTestGenerator.generate(
            listOf(
                UaaUserSortingTest(UaaUserSortingParams.ID::asc).withId(T3498::class),
                UaaUserSortingTest(UaaUserSortingParams.BLOCK_REASON::asc).withId(T3499::class),
                UaaUserSortingTest(UaaUserSortingParams.BLOCK_USER::asc).withId(T3500::class),
                UaaUserSortingTest(UaaUserSortingParams.PERMANENT_BLOCKED::asc).withId(T3501::class),
                UaaUserSortingTest(UaaUserSortingParams.PREFERRED_LOCALE::asc).withId(T3502::class),
                UaaUserSortingTest(UaaUserSortingParams.TEMPORARY_BLOCKED::asc).withId(T3503::class),
                UaaUserSortingTest(UaaUserSortingParams.TEMPORARY_BLOCKED_UNTIL::asc).withId(T3504::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_FIRST_NAME::asc).withId(T3505::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_MIDDLE_NAME::asc).withId(T3506::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_LAST_NAME::asc).withId(T3507::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_EMAIL::asc).withId(T3508::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_PHONE::asc).withId(T3509::class),

                UaaUserSortingTest(UaaUserSortingParams.ID::desc).withId(T3510::class),
                UaaUserSortingTest(UaaUserSortingParams.BLOCK_REASON::desc).withId(T3511::class),
                UaaUserSortingTest(UaaUserSortingParams.BLOCK_USER::desc).withId(T3512::class),
                UaaUserSortingTest(UaaUserSortingParams.PERMANENT_BLOCKED::desc).withId(T3513::class),
                UaaUserSortingTest(UaaUserSortingParams.PREFERRED_LOCALE::desc).withId(T3514::class),
                UaaUserSortingTest(UaaUserSortingParams.TEMPORARY_BLOCKED::desc).withId(T3515::class),
                UaaUserSortingTest(UaaUserSortingParams.TEMPORARY_BLOCKED_UNTIL::desc).withId(T3516::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_FIRST_NAME::desc).withId(T3517::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_MIDDLE_NAME::desc).withId(T3518::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_LAST_NAME::desc).withId(T3519::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_EMAIL::desc).withId(T3520::class),
                UaaUserSortingTest(UaaUserSortingParams.USER_DETAILS_PHONE::desc).withId(T3521::class)
            )
        )
    }

    @TestFactory
    @T3477 //'УааПользователь'. Фильтрация по полю 'id' (eq) [BANK]
    @T3478 //'УааПользователь'. Фильтрация по полю 'blockReason' (eq) [BANK]
    @T3479 //'УааПользователь'. Фильтрация по полю 'blockReason' (contains) [BANK]
    @T3480 //'УааПользователь'. Фильтрация по полю 'blockUser' (eq) [BANK]
    @T3481 //'УааПользователь'. Фильтрация по полю 'permanentBlocked' (eq) [BANK]
    @T3482 //'УааПользователь'. Фильтрация по полю 'preferredLocale' (eq) [BANK]
    @T3483 //'УааПользователь'. Фильтрация по полю 'preferredLocale' (contains) [BANK]
    @T3484 //'УааПользователь'. Фильтрация по полю 'temporaryBlocked' (eq) [BANK]
    @T3485 //'УааПользователь'. Фильтрация по полю 'temporaryBlockedUntil' (eq) [BANK]
    @T3486 //'УааПользователь'. Фильтрация по полю 'temporaryBlockedUntil' (ge) [BANK]
    @T3487 //'УааПользователь'. Фильтрация по полю 'temporaryBlockedUntil' (le) [BANK]
    @T3488 //'УааПользователь'. Фильтрация по полю 'userDetails.firstName' (eq) [BANK]
    @T3489 //'УааПользователь'. Фильтрация по полю 'userDetails.firstName' (contains) [BANK]
    @T3490 //'УааПользователь'. Фильтрация по полю 'userDetails.middleName' (eq) [BANK]
    @T3491 //'УааПользователь'. Фильтрация по полю 'userDetails.middleName' (contains) [BANK]
    @T3492 //'УааПользователь'. Фильтрация по полю 'userDetails.lastName' (eq) [BANK]
    @T3493 //'УааПользователь'. Фильтрация по полю 'userDetails.lastName' (contains) [BANK]
    @T3494 //'УааПользователь'. Фильтрация по полю 'userDetails.email' (eq) [BANK]
    @T3495 //'УааПользователь'. Фильтрация по полю 'userDetails.email' (contains) [BANK]
    @T3496 //'УааПользователь'. Фильтрация по полю 'userDetails.phoneNumber' (eq) [BANK]
    @T3497 //'УааПользователь'. Фильтрация по полю 'userDetails.phoneNumber' (contains) [BANK]
    internal fun uaaUserFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                UaaUserFilterTests("id equals", { dataForFilter },
                    { ID.eq(it!!.id!!) }).withId(T3477::class),
                UaaUserFilterTests("blockReason equals", { permBlockDataForFilter },
                    { BLOCK_REASON.eq(it!!.blockReason!!) }).withId(T3478::class),
                UaaUserFilterTests("blockReason contains", { tempBlockDataForFilter },
                    { BLOCK_REASON.contains(it!!.blockReason!!.randomSubstringPf()) }).withId(T3479::class),
                UaaUserFilterTests("blockUser equals", { permBlockDataForFilter },
                    { BLOCK_USER.eq(it!!.blockUser!!) }).withId(T3480::class),
                UaaUserFilterTests("permanentBlocked equals", { permBlockDataForFilter },
                    { PERMANENT_BLOCKED.eq(it!!.permanentBlocked) }).withId(T3481::class),
                UaaUserFilterTests("preferredLocale equals", { dataForFilter },
                    { PREFERRED_LOCALE.eq(it!!.preferredLocale!!) }).withId(T3482::class),
                UaaUserFilterTests("preferredLocale contains", { dataForFilter },
                    { PREFERRED_LOCALE.contains(it!!.preferredLocale!!.randomSubstringPf()) }).withId(T3483::class),
                UaaUserFilterTests("temporaryBlocked equals", { tempBlockDataForFilter },
                    { TEMPORARY_BLOCKED.eq(it!!.temporaryBlocked) }).withId(T3484::class),
                UaaUserFilterTests("temporaryBlockedUntil equals", { tempBlockDataForFilter },
                    { TEMPORARY_BLOCKED_UNTIL.eq(it!!.temporaryBlockedUntil!!) }).withId(T3485::class),
                UaaUserFilterTests("temporaryBlockedUntil greater than", { tempBlockDataForFilter },
                    { TEMPORARY_BLOCKED_UNTIL.ge(it!!.temporaryBlockedUntil!!.minusMinutes(2)) }).withId(T3486::class),
                UaaUserFilterTests("temporaryBlockedUntil less than", { tempBlockDataForFilter },
                    { TEMPORARY_BLOCKED_UNTIL.le(it!!.temporaryBlockedUntil!!.plusMinutes(1)) }).withId(T3487::class),
                UaaUserFilterTests("userDetails.firstName equals", { dataForFilter },
                    { USER_DETAILS_FIRST_NAME.eq(it!!.userDetails!!.firstName!!) }).withId(T3488::class),
                UaaUserFilterTests("userDetails.firstName contains", { dataForFilter },
                    { USER_DETAILS_FIRST_NAME.contains(it!!.userDetails!!.firstName!!.randomSubstringPf()) }).withId(T3489::class),
                UaaUserFilterTests("userDetails.middleName equals", { dataForFilter },
                    { USER_DETAILS_MIDDLE_NAME.eq(it!!.userDetails!!.middleName!!) }).withId(T3490::class),
                UaaUserFilterTests("userDetails.middleName contains", { dataForFilter },
                    { USER_DETAILS_MIDDLE_NAME.contains(it!!.userDetails!!.middleName!!.randomSubstringPf()) }).withId(T3491::class),
                UaaUserFilterTests("userDetails.lastName equals", { dataForFilter },
                    { USER_DETAILS_LAST_NAME.eq(it!!.userDetails!!.lastName!!) }).withId(T3492::class),
                UaaUserFilterTests("userDetails.lastName contains", { dataForFilter },
                    { USER_DETAILS_LAST_NAME.contains(it!!.userDetails!!.lastName!!.randomSubstringPf()) }).withId(T3493::class),
                UaaUserFilterTests("userDetails.email equals", { dataForFilter },
                    { USER_DETAILS_EMAIL.eq(it!!.userDetails!!.email!!) }).withId(T3494::class),
                UaaUserFilterTests("userDetails.email contains", { dataForFilter },
                    { USER_DETAILS_EMAIL.contains(it!!.userDetails!!.email!!.randomSubstringPf()) }).withId(T3495::class),
                UaaUserFilterTests("userDetails.phoneNumber equals", { dataForFilter },
                    { USER_DETAILS_PHONE.eq(it!!.userDetails!!.phoneNumber!!) }).withId(T3496::class),
                UaaUserFilterTests("userDetails.phoneNumber contains", { dataForFilter },
                    { USER_DETAILS_PHONE.contains(it!!.userDetails!!.phoneNumber!!.randomSubstringPf()) }).withId(T3497::class)
            )
        )
    }
}