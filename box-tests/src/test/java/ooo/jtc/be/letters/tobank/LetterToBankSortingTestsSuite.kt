package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_SORTING
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createProcessedLetterToBank
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.executedLTBFilter
import ooo.jtc.api.letters.tobank.steps.LetterToBankSteps
import ooo.jtc.api.letters.tobank.tests.LetterToBankSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.BRANCH_ID
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.BRANCH_NAME
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.CREATED_AT
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.CUSTOMER_ID
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.CUSTOMER_NAME
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.DOCUMENT_DATE
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.DOCUMENT_NUMBER
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.DOC_TYPE_DESCRIPTION
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.EXECUTION_DATE
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.RECEIVE_DATE
import ooo.jtc.testdata.letters.tobank.LetterToBankSortingParams.STATUS
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
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_SORTING)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' sorting suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_SORTING
@TestInstance(PER_CLASS)
class LetterToBankSortingTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T1959") annotation class T1959
    @Tag("JTCSALTO-T1960") annotation class T1960
    @Tag("JTCSALTO-T1961") annotation class T1961
    @Tag("JTCSALTO-T1962") annotation class T1962
    @Tag("JTCSALTO-T1963") annotation class T1963
    @Tag("JTCSALTO-T1964") annotation class T1964
    @Tag("JTCSALTO-T1965") annotation class T1965
    @Tag("JTCSALTO-T1966") annotation class T1966
    @Tag("JTCSALTO-T1967") annotation class T1967
    @Tag("JTCSALTO-T1968") annotation class T1968
    @Tag("JTCSALTO-T1969") annotation class T1969
    @Tag("JTCSALTO-T1970") annotation class T1970
    @Tag("JTCSALTO-T1971") annotation class T1971
    @Tag("JTCSALTO-T1972") annotation class T1972
    @Tag("JTCSALTO-T4267") annotation class T4267
    @Tag("JTCSALTO-T4268") annotation class T4268
    @Tag("JTCSALTO-T4269") annotation class T4269
    @Tag("JTCSALTO-T4270") annotation class T4270
    @Tag("JTCSALTO-T4271") annotation class T4271
    @Tag("JTCSALTO-T4272") annotation class T4272
    @Tag("JTCSALTO-T4273") annotation class T4273
    @Tag("JTCSALTO-T4274") annotation class T4274
    @Tag("JTCSALTO-T4275") annotation class T4275
    @Tag("JTCSALTO-T4276") annotation class T4276
    @Tag("JTCSALTO-T4277") annotation class T4277
    @Tag("JTCSALTO-T4278") annotation class T4278
    @Tag("JTCSALTO-T4279") annotation class T4279
    @Tag("JTCSALTO-T4280") annotation class T4280
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client

    @BeforeAll
    fun prepareDataForLetterToBankSortingTests() {
        val isNotEnoughForTest: (GenericPageResponseDto<LetterToBankDto>) -> Boolean = {
            it.page.isNullOrEmpty() || REQUIRED_DATA_COUNT > (it.size ?: 0)
        }
        val bankAvailableLetters = LetterToBankSteps(bankUser).getPage(executedLTBFilter.toPageRequest())
        val clientAvailableLetters = LetterToBankSteps(clientUser).getPage()

        if (isNotEnoughForTest.invoke(clientAvailableLetters) || isNotEnoughForTest.invoke(bankAvailableLetters))
            repeat(REQUIRED_DATA_COUNT.toInt()) { createProcessedLetterToBank(clientUser, bankUser) }
    }

    @TestFactory
    @T1959 //'Письмо в Банк'. Сортировка по полю 'documentNumber, ASC' [CLIENT]
    @T1960 //'Письмо в Банк'. Сортировка по полю 'documentDate, ASC' [CLIENT]
    @T1961 //'Письмо в Банк'. Сортировка по полю 'customerId, ASC' [CLIENT]
    @T1962 //'Письмо в Банк'. Сортировка по полю 'customerName, ASC' [CLIENT]
    @T1963 //'Письмо в Банк'. Сортировка по полю 'branchId, ASC' [CLIENT]
    @T1964 //'Письмо в Банк'. Сортировка по полю 'branchName, ASC' [CLIENT]
    @T1965 //'Письмо в Банк'. Сортировка по полю 'status, ASC' [CLIENT]
    @T4279 //'Письмо в Банк'. Сортировка по полю 'createdAt, ASC' [CLIENT]

    @T1966 //'Письмо в Банк'. Сортировка по полю 'documentNumber, DESC' [CLIENT]
    @T1967 //'Письмо в Банк'. Сортировка по полю 'documentDate, DESC' [CLIENT]
    @T1968 //'Письмо в Банк'. Сортировка по полю 'customerId, DESC' [CLIENT]
    @T1969 //'Письмо в Банк'. Сортировка по полю 'customerName, DESC' [CLIENT]
    @T1970 //'Письмо в Банк'. Сортировка по полю 'branchId, DESC' [CLIENT]
    @T1971 //'Письмо в Банк'. Сортировка по полю 'branchName, DESC' [CLIENT]
    @T1972 //'Письмо в Банк'. Сортировка по полю 'status, DESC' [CLIENT]
    @T4280 //'Письмо в Банк'. Сортировка по полю 'createdAt, DESC' [CLIENT]
    internal fun letterToBankSortingClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // Tests are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725513
                LetterToBankSortingTest(clientUser, DOCUMENT_NUMBER::asc).withId(T1959::class), //6.3 | 1
                LetterToBankSortingTest(clientUser, DOCUMENT_DATE::asc).withId(T1960::class),   //6.3 | 2
                LetterToBankSortingTest(clientUser, CUSTOMER_ID::asc).withId(T1961::class),
                LetterToBankSortingTest(clientUser, CUSTOMER_NAME::asc).withId(T1962::class),
                LetterToBankSortingTest(clientUser, BRANCH_ID::asc).withId(T1963::class),
                LetterToBankSortingTest(clientUser, BRANCH_NAME::asc).withId(T1964::class),
                LetterToBankSortingTest(clientUser, STATUS::asc).withId(T1965::class),
                LetterToBankSortingTest(clientUser, CREATED_AT::asc).withId(T4279::class),      //6.3 | 3

                LetterToBankSortingTest(clientUser, DOCUMENT_NUMBER::desc).withId(T1966::class),//6.3 | 1
                LetterToBankSortingTest(clientUser, DOCUMENT_DATE::desc).withId(T1967::class),  //6.3 | 2
                LetterToBankSortingTest(clientUser, CUSTOMER_ID::desc).withId(T1968::class),
                LetterToBankSortingTest(clientUser, CUSTOMER_NAME::desc).withId(T1969::class),
                LetterToBankSortingTest(clientUser, BRANCH_ID::desc).withId(T1970::class),
                LetterToBankSortingTest(clientUser, BRANCH_NAME::desc).withId(T1971::class),
                LetterToBankSortingTest(clientUser, STATUS::desc).withId(T1972::class),
                LetterToBankSortingTest(clientUser, CREATED_AT::desc).withId(T4280::class)      //6.3 | 3
            )
        )
    }

    @TestFactory
    @T4267 //'Письмо в Банк'. Сортировка по полю 'documentDate, ASC' [BANK]
    @T4268 //'Письмо в Банк'. Сортировка по полю 'status, ASC' [BANK]
    @T4269 //'Письмо в Банк'. Сортировка по полю 'customerName, ASC' [BANK]
    @T4270 //'Письмо в Банк'. Сортировка по полю 'docTypeDescription, ASC' [BANK]
    @T4271 //'Письмо в Банк'. Сортировка по полю 'receiveDate, ASC' [BANK]
    @T4272 //'Письмо в Банк'. Сортировка по полю 'executionDate, ASC' с фильтром по 'executionDate' [BANK]

    @T4273 //'Письмо в Банк'. Сортировка по полю 'documentDate, DESC' [BANK]
    @T4274 //'Письмо в Банк'. Сортировка по полю 'status, DESC' [BANK]
    @T4275 //'Письмо в Банк'. Сортировка по полю 'customerName, DESC' [BANK]
    @T4276 //'Письмо в Банк'. Сортировка по полю 'docTypeDescription, DESC' [BANK]
    @T4277 //'Письмо в Банк'. Сортировка по полю 'receiveDate, DESC' [BANK]
    @T4278 //'Письмо в Банк'. Сортировка по полю 'executionDate, DESC' с фильтром по 'executionDate' [BANK]
    internal fun letterToBankSortingBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // Tests are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725515
                LetterToBankSortingTest(bankUser, DOCUMENT_DATE::asc).withId(T4267::class),         //6.3 | 1
                LetterToBankSortingTest(bankUser, STATUS::asc).withId(T4268::class),                //6.3 | 2
                LetterToBankSortingTest(bankUser, CUSTOMER_NAME::asc).withId(T4269::class),         //6.3 | 3
                LetterToBankSortingTest(bankUser, DOC_TYPE_DESCRIPTION::asc).withId(T4270::class),  //6.3 | 4
                LetterToBankSortingTest(bankUser, RECEIVE_DATE::asc).withId(T4271::class),          //6.3 | 5
                LetterToBankSortingTest(bankUser, EXECUTION_DATE::asc,
                    filterFunction = { executedLTBFilter.toFilter() }
                ).withId(T4272::class),                                                             //6.3 | 6

                LetterToBankSortingTest(bankUser, DOCUMENT_DATE::desc).withId(T4273::class),        //6.3 | 1
                LetterToBankSortingTest(bankUser, STATUS::desc).withId(T4274::class),               //6.3 | 2
                LetterToBankSortingTest(bankUser, CUSTOMER_NAME::desc).withId(T4275::class),        //6.3 | 3
                LetterToBankSortingTest(bankUser, DOC_TYPE_DESCRIPTION::desc).withId(T4276::class), //6.3 | 4
                LetterToBankSortingTest(bankUser, RECEIVE_DATE::desc).withId(T4277::class),         //6.3 | 5
                LetterToBankSortingTest(bankUser, EXECUTION_DATE::desc,
                    filterFunction = { executedLTBFilter.toFilter() }
                ).withId(T4278::class)                                                              //6.3 | 6
            )
        )
    }
}