package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BANKREPRESENTATIVE
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeBlockingTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeCreateTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeDeleteTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeFiltrationTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeGetPageTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeGetTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeSortingTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeUnblockingTest
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentative
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeFilterParams
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.BANK_ID
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.BLOCK_DATE
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.BLOCK_USER
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.EMAIL
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.ID
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.IS_BLOCKED
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.PHONE
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.POSITION
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeSortingParams.USER_ID
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
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.BANK_REPRESENTATIVE)
@DisplayName("API '${DictionaryNames.BANK_REPRESENTATIVE}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BANKREPRESENTATIVE
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankRepresentativeTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T5479") annotation class T5479
@Tag("JTCSALTO-T5480") annotation class T5480
@Tag("JTCSALTO-T5481") annotation class T5481
@Tag("JTCSALTO-T5482") annotation class T5482
@Tag("JTCSALTO-T5483") annotation class T5483
@Tag("JTCSALTO-T5484") annotation class T5484
@Tag("JTCSALTO-T5485") annotation class T5485
@Tag("JTCSALTO-T5486") annotation class T5486
@Tag("JTCSALTO-T5487") annotation class T5487
@Tag("JTCSALTO-T5488") annotation class T5488
@Tag("JTCSALTO-T5489") annotation class T5489
@Tag("JTCSALTO-T5490") annotation class T5490
@Tag("JTCSALTO-T5491") annotation class T5491
@Tag("JTCSALTO-T5492") annotation class T5492
@Tag("JTCSALTO-T5493") annotation class T5493
@Tag("JTCSALTO-T5494") annotation class T5494
@Tag("JTCSALTO-T5495") annotation class T5495
@Tag("JTCSALTO-T5496") annotation class T5496
@Tag("JTCSALTO-T5497") annotation class T5497
@Tag("JTCSALTO-T5498") annotation class T5498
@Tag("JTCSALTO-T5499") annotation class T5499
@Tag("JTCSALTO-T5500") annotation class T5500
@Tag("JTCSALTO-T5501") annotation class T5501
@Tag("JTCSALTO-T5502") annotation class T5502
@Tag("JTCSALTO-T5503") annotation class T5503
@Tag("JTCSALTO-T5504") annotation class T5504
@Tag("JTCSALTO-T5505") annotation class T5505
@Tag("JTCSALTO-T5506") annotation class T5506
@Tag("JTCSALTO-T5507") annotation class T5507
@Tag("JTCSALTO-T5508") annotation class T5508
@Tag("JTCSALTO-T5509") annotation class T5509
@Tag("JTCSALTO-T5510") annotation class T5510
@Tag("JTCSALTO-T5511") annotation class T5511
@Tag("JTCSALTO-T5512") annotation class T5512
@Tag("JTCSALTO-T5513") annotation class T5513
@Tag("JTCSALTO-T5514") annotation class T5514
@Tag("JTCSALTO-T5515") annotation class T5515
@Tag("JTCSALTO-T5516") annotation class T5516
//@formatter:on
//endregion

    private val almightyUser = Users.superUser
    private val bankOperator = Users.bankOperator
    private lateinit var dataForFilter: BankRepresentativeDto
    private lateinit var blockedDataForFilter: BankRepresentativeDto
    private lateinit var testDataScope: TestDataScope<BankRepresentative>

    @BeforeAll
    fun prepareTestData() {
        val allGeneratedBankRepresentatives = mutableListOf<BankRepresentative>()
        testDataScope = BankRepresentativeData.withRequiredFields(
            additionalFilter = { !it.isBlock },
            customCreator = {
                val newBank = BankInfoPrepareSteps.createBankInfoDto()
                val preparedBankRepres = BankRepresentativePrepareSteps.getBankRepresentativeDtoForCreate(
                    uaaUserId = bankOperator.uaaUserId!!,
                    bankId = newBank.id!!
                )
                val bankRepres = BankRepresentativePrepareSteps.createBankRepresentativeDto(preparedBankRepres)
                bankRepres.toModel()
            }
        )
        dataForFilter = testDataScope.all.random().toDto()

        repeat(
            times = REQUIRED_DATA_COUNT.toInt(),
            action = {
                val newBank = BankInfoPrepareSteps.createBankInfoDto()
                val preparedBankRepres = BankRepresentativePrepareSteps.getBankRepresentativeDtoForCreate(
                    uaaUserId = bankOperator.uaaUserId!!,
                    bankId = newBank.id!!
                )
                val blockedBankRepres = BankRepresentativePrepareSteps.createBlockedBankRepresentativeDto(preparedBankRepres)
                allGeneratedBankRepresentatives.add(blockedBankRepres.toModel())
            }
        )
        blockedDataForFilter = allGeneratedBankRepresentatives.random().toDto()

        allGeneratedBankRepresentatives.addAll(testDataScope.generated)
        testDataScope.generated = allGeneratedBankRepresentatives
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated(
            customRemover = { BankInfoPrepareSteps.deleteBankInfoAndRelatedEntities(it.bankId!!, deleteAtOnly = true) }
        )
    }

    @TestFactory
    @T5510 //'Представитель банка'. CRUD: Создаем запись от пользователя [BANK]
    @T5511 //'Представитель банка'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5512 //'Представитель банка'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5513 //'Представитель банка'. CRUD: Удаляем запись от пользователя [BANK]
    @T5514 //'Представитель банка'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun bankRepresentativeCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BankRepresentativeCreateTest(almightyUser, createEntityForUser = bankOperator).withId(T5510::class),
                BankRepresentativeGetTest(almightyUser).withId(T5511::class),
                BankRepresentativeGetTest(bankOperator).withId(T5511::class),
                BankRepresentativeGetPageTest(almightyUser).withId(T5512::class),
                BankRepresentativeGetPageTest(bankOperator).withId(T5512::class),
                BankRepresentativeDeleteTest(almightyUser, createEntityForUser = bankOperator).withId(T5513::class),
                BankRepresentativeUpdateTest(almightyUser, createEntityForUser = bankOperator).withId(T5514::class)
            )
        )
    }

    @TestFactory
    @T5515 //'Представитель банка'. Блокировка [BANK]
    @T5516 //'Представитель банка'. Разблокировка [BANK]
    internal fun bankRepresentativeBlockingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BankRepresentativeBlockingTest(almightyUser, createEntityForUser = bankOperator).withId(T5515::class),
                BankRepresentativeUnblockingTest(almightyUser, createEntityForUser = bankOperator).withId(T5516::class)
                //TODO Sergeyev [2021.03.24]: when role model is fixed, add tests for correct blocking logic (unavailable banks)
            )
        )
    }

    @TestFactory
    @T5492 //'Представитель банка'. Сортировка по полю 'id, ASC' [BANK]
    @T5493 //'Представитель банка'. Сортировка по полю 'bankId, ASC' [BANK]
    @T5494 //'Представитель банка'. Сортировка по полю 'userId, ASC' [BANK]
    @T5498 //'Представитель банка'. Сортировка по полю 'position, ASC' [BANK]
    @T5499 //'Представитель банка'. Сортировка по полю 'email, ASC' [BANK]
    @T5500 //'Представитель банка'. Сортировка по полю 'phone, ASC' [BANK]

    @T5501 //'Представитель банка'. Сортировка по полю 'id, DESC' [BANK]
    @T5502 //'Представитель банка'. Сортировка по полю 'bankId, DESC' [BANK]
    @T5503 //'Представитель банка'. Сортировка по полю 'userId, DESC' [BANK]
    @T5507 //'Представитель банка'. Сортировка по полю 'position, DESC' [BANK]
    @T5508 //'Представитель банка'. Сортировка по полю 'email, DESC' [BANK]
    @T5509 //'Представитель банка'. Сортировка по полю 'phone, DESC' [BANK]
    internal fun bankRepresentativeSortingTests(): List<DynamicTest> {
        val user = bankOperator
        return EntityTestGenerator.generate(
            listOf(
                BankRepresentativeSortingTest(user, ID::asc).withId(T5492::class),
                BankRepresentativeSortingTest(user, BANK_ID::asc).withId(T5493::class),
                BankRepresentativeSortingTest(user, USER_ID::asc).withId(T5494::class),
                BankRepresentativeSortingTest(user, POSITION::asc).withId(T5498::class),
                BankRepresentativeSortingTest(user, EMAIL::asc).withId(T5499::class),
                BankRepresentativeSortingTest(user, PHONE::asc).withId(T5500::class),

                BankRepresentativeSortingTest(user, ID::desc).withId(T5501::class),
                BankRepresentativeSortingTest(user, BANK_ID::desc).withId(T5502::class),
                BankRepresentativeSortingTest(user, USER_ID::desc).withId(T5503::class),
                BankRepresentativeSortingTest(user, POSITION::desc).withId(T5507::class),
                BankRepresentativeSortingTest(user, EMAIL::desc).withId(T5508::class),
                BankRepresentativeSortingTest(user, PHONE::desc).withId(T5509::class)
            )
        )
    }

    @TestFactory
    @T5495 //'Представитель банка'. Сортировка по полю 'block.isBlock, ASC' [BANK]
    @T5496 //'Представитель банка'. Сортировка по полю 'block.blockDate, ASC' [BANK]
    @T5497 //'Представитель банка'. Сортировка по полю 'block.blockUser, ASC' [BANK]

    @T5504 //'Представитель банка'. Сортировка по полю 'block.isBlock, DESC' [BANK]
    @T5505 //'Представитель банка'. Сортировка по полю 'block.blockDate, DESC' [BANK]
    @T5506 //'Представитель банка'. Сортировка по полю 'block.blockUser, DESC' [BANK]
    internal fun almightyBankRepresentativeSortingTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                BankRepresentativeSortingTest(user, USER_ID::asc).withId(T5494::class),
                BankRepresentativeSortingTest(user, IS_BLOCKED::asc).withId(T5495::class),
                BankRepresentativeSortingTest(user, BLOCK_DATE::asc).withId(T5496::class),
                BankRepresentativeSortingTest(user, BLOCK_USER::asc).withId(T5497::class),

                BankRepresentativeSortingTest(user, USER_ID::desc).withId(T5503::class),
                BankRepresentativeSortingTest(user, IS_BLOCKED::desc).withId(T5504::class),
                BankRepresentativeSortingTest(user, BLOCK_DATE::desc).withId(T5505::class),
                BankRepresentativeSortingTest(user, BLOCK_USER::desc).withId(T5506::class)
            )
        )
    }

    @TestFactory
    @T5479 //'Представитель банка'. Фильтрация по полю 'id' (eq) [BANK]
    @T5480 //'Представитель банка'. Фильтрация по полю 'bankId' (eq) [BANK]
    @T5481 //'Представитель банка'. Фильтрация по полю 'userId' (eq) [BANK]
    @T5486 //'Представитель банка'. Фильтрация по полю 'position' (eq) [BANK]
    @T5487 //'Представитель банка'. Фильтрация по полю 'position' (contains) [BANK]
    @T5488 //'Представитель банка'. Фильтрация по полю 'email' (eq) [BANK]
    @T5489 //'Представитель банка'. Фильтрация по полю 'email' (contains) [BANK]
    @T5490 //'Представитель банка'. Фильтрация по полю 'phone' (eq) [BANK]
    @T5491 //'Представитель банка'. Фильтрация по полю 'phone' (contains) [BANK]
    internal fun bankRepresentativeFiltrationTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                BankRepresentativeFiltrationTest("id equals", user, { dataForFilter },
                    { BankRepresentativeFilterParams.ID.eq(it!!.id!!) }).withId(T5479::class),
                BankRepresentativeFiltrationTest("bankId equals", user, { dataForFilter },
                    { BankRepresentativeFilterParams.BANK_ID.eq(it!!.bankId!!) }).withId(T5480::class),
                BankRepresentativeFiltrationTest("userId equals", user, { dataForFilter },
                    { BankRepresentativeFilterParams.USER_ID.eq(it!!.userId!!) }).withId(T5481::class),
                BankRepresentativeFiltrationTest("position equals", user, { dataForFilter },
                    { BankRepresentativeFilterParams.POSITION.eq(it!!.position!!) }).withId(T5486::class),
                BankRepresentativeFiltrationTest("position contains", user, { dataForFilter },
                    { BankRepresentativeFilterParams.POSITION.contains(it!!.position!!.randomSubstringPf()) }).withId(T5487::class),
                BankRepresentativeFiltrationTest("email equals", user, { dataForFilter },
                    { BankRepresentativeFilterParams.EMAIL.eq(it!!.email!!) }).withId(T5488::class),
                BankRepresentativeFiltrationTest("email contains", user, { dataForFilter },
                    { BankRepresentativeFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T5489::class),
                BankRepresentativeFiltrationTest("phone equals", user, { dataForFilter },
                    { BankRepresentativeFilterParams.PHONE.eq(it!!.phone!!) }).withId(T5490::class),
                BankRepresentativeFiltrationTest("phone contains", user, { dataForFilter },
                    { BankRepresentativeFilterParams.PHONE.contains(it!!.phone!!.randomSubstringPf()) }).withId(T5491::class)
            )
        )
    }

    @TestFactory
    @T5482 //'Представитель банка'. Фильтрация по полю 'block.isBlock' (eq) [BANK]
    @T5483 //'Представитель банка'. Фильтрация по полю 'block.blockDate' (ge) [BANK]
    @T5484 //'Представитель банка'. Фильтрация по полю 'block.blockDate' (le) [BANK]
    @T5485 //'Представитель банка'. Фильтрация по полю 'block.blockUser' (eq) [BANK]
    internal fun blockedBankRepresentativeFiltrationTests(): List<DynamicTest> {
        val user = almightyUser
        return EntityTestGenerator.generate(
            listOf(
                BankRepresentativeFiltrationTest("isBlocked equals", user, { blockedDataForFilter },
                    { BankRepresentativeFilterParams.IS_BLOCKED.eq(it!!.block.isBlock) }).withId(T5482::class),
                BankRepresentativeFiltrationTest("blockDate greaterOrEquals", user, { blockedDataForFilter },
                    { BankRepresentativeFilterParams.BLOCK_DATE.ge(it!!.block.blockDate!!.minusSeconds(5)) }).withId(T5483::class),
                BankRepresentativeFiltrationTest("blockDate lesserOrEquals", user, { blockedDataForFilter },
                    { BankRepresentativeFilterParams.BLOCK_DATE.le(it!!.block.blockDate!!.plusSeconds(5)) }).withId(T5484::class),
                BankRepresentativeFiltrationTest("blockUser equals", user, { blockedDataForFilter },
                    { BankRepresentativeFilterParams.BLOCK_USER.eq(it!!.block.blockUser!!) }).withId(T5485::class)
            )
        )
    }
}