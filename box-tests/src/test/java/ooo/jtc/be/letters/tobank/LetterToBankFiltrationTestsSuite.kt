package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_FILTRATION
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.tests.LetterToBankFiltrationCountTest
import ooo.jtc.api.letters.tobank.tests.LetterToBankFiltrationTest
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.ATTACH_FILE_NAME
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.BRANCH_ID
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.CONTACT_NAME
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.CONTACT_PHONE
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.CUSTOMER_ID
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.DOCUMENT_DATE
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.DOCUMENT_NUMBER
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.DOC_TEXT
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.DOC_THEME
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.DOC_TYPE
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.EXECUTION_DATE
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.RECEIVE_DATE
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams.STATUS
import ooo.jtc.uaa.User
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.time.temporal.ChronoUnit.DAYS

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_FILTRATION)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' filtration suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_FILTRATION
@TestInstance(PER_CLASS)
class LetterToBankFiltrationTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T1941") annotation class T1941
    @Tag("JTCSALTO-T1942") annotation class T1942
    @Tag("JTCSALTO-T1943") annotation class T1943
    @Tag("JTCSALTO-T1944") annotation class T1944
    @Tag("JTCSALTO-T1945") annotation class T1945
    @Tag("JTCSALTO-T1946") annotation class T1946
    @Tag("JTCSALTO-T1947") annotation class T1947
    @Tag("JTCSALTO-T1948") annotation class T1948
    @Tag("JTCSALTO-T1949") annotation class T1949
    @Tag("JTCSALTO-T1950") annotation class T1950
    @Tag("JTCSALTO-T1951") annotation class T1951
    @Tag("JTCSALTO-T1952") annotation class T1952
    @Tag("JTCSALTO-T1953") annotation class T1953
    @Tag("JTCSALTO-T4241") annotation class T4241
    @Tag("JTCSALTO-T4242") annotation class T4242
    @Tag("JTCSALTO-T4243") annotation class T4243
    @Tag("JTCSALTO-T4244") annotation class T4244
    @Tag("JTCSALTO-T4245") annotation class T4245
    @Tag("JTCSALTO-T4246") annotation class T4246
    @Tag("JTCSALTO-T4247") annotation class T4247
    @Tag("JTCSALTO-T4248") annotation class T4248
    @Tag("JTCSALTO-T4249") annotation class T4249
    @Tag("JTCSALTO-T4250") annotation class T4250
    @Tag("JTCSALTO-T4251") annotation class T4251
    @Tag("JTCSALTO-T4252") annotation class T4252
    @Tag("JTCSALTO-T4253") annotation class T4253
    @Tag("JTCSALTO-T4254") annotation class T4254
    @Tag("JTCSALTO-T4255") annotation class T4255
    @Tag("JTCSALTO-T4256") annotation class T4256
    @Tag("JTCSALTO-T4257") annotation class T4257
    @Tag("JTCSALTO-T4258") annotation class T4258
    @Tag("JTCSALTO-T4259") annotation class T4259
    @Tag("JTCSALTO-T4260") annotation class T4260
    @Tag("JTCSALTO-T4261") annotation class T4261
    @Tag("JTCSALTO-T4262") annotation class T4262
    @Tag("JTCSALTO-T4263") annotation class T4263
    @Tag("JTCSALTO-T4264") annotation class T4264
    @Tag("JTCSALTO-T4265") annotation class T4265
    @Tag("JTCSALTO-T4266") annotation class T4266
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val bankUser = Users.bankOperator
    private val dtoForClientFiltration: LetterToBankDto by lazy {
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = clientUser,
            getPageRequest = {
                IFilterParams.and(
                    { recentDocFilterData },
                    { IS_HAS_ATTACH.eq(true) }
                ).toPageRequest()
            },
            createLtbFunc = {
                LetterToBankPrepareSteps.createLetterToBankDto(
                    creatorClientUser = clientUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        creatorClientUser = clientUser,
                        attachments = listOf(DEFAULT_ATTACH_FILE)
                    )
                )
            }
        )
    }
    private val dtoForBankFiltration: LetterToBankDto by lazy {
        LetterToBankPrepareSteps.getOrCreateLetterToBankDto(
            searchingUser = bankUser,
            getPageRequest = {
                IFilterParams.and(
                    { recentDocFilterData },
                    { IS_HAS_ATTACH.eq(true) },
                    { STATUS.eq(LetterToBankStatus.PROCESSED.descriptionBank) }
                ).toPageRequest()
            },
            createLtbFunc = {
                LetterToBankPrepareSteps.createProcessedLetterToBank(
                    receiverBankUser = bankUser,
                    dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                        receiverBankUser = bankUser,
                        attachments = listOf(DEFAULT_ATTACH_FILE)
                    )
                )
            }
        )
    }

    @TestFactory
    @T1941 //'Письмо в Банк'. Фильтрация по полю 'documentNumber' (contains) [CLIENT]
    @T1942 //'Письмо в Банк'. Фильтрация по полю 'documentDate' (ge) [CLIENT]
    @T1943 //'Письмо в Банк'. Фильтрация по полю 'documentDate' (le) [CLIENT]
    @T1944 //'Письмо в Банк'. Фильтрация по полю 'documentDate' ge and 'documentDate' le [CLIENT]
    @T1945 //'Письмо в Банк'. Фильтрация по полю 'branchId' (eq) [CLIENT]
    @T1946 //'Письмо в Банк'. Фильтрация по полю 'customerId' (eq) [CLIENT]
    @T1947 //'Письмо в Банк'. Фильтрация по полю 'status' (eq) [CLIENT]
    @T4241 //'Письмо в Банк'. Фильтрация по полю 'docTheme' (contains) [CLIENT]
    @T4242 //'Письмо в Банк'. Фильтрация по полю 'docText' (contains) [CLIENT]
    @T4243 //'Письмо в Банк'. Фильтрация по полю 'attachName' (contains) [CLIENT]
    @T4244 //'Письмо в Банк'. Фильтрация по полю 'isHasAttach' (eq) [CLIENT]
    @T4245 //'Письмо в Банк'. Фильтрация по полю 'contactName' (contains) [CLIENT]
    @T4246 //'Письмо в Банк'. Фильтрация по полю 'contactPhone' (contains) [CLIENT]
    internal fun clientFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // Tests are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725513
                docNumberContainsTest.invoke(clientUser, dtoForClientFiltration).withId(T1941::class),
                docDateGeFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T1942::class),
                docDateLeFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T1943::class),
                docDateLeGeFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T1944::class),
                branchIdEqFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T1945::class),
                customerIdEqFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T1946::class),
                statusEqFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T1947::class),
                docThemeContainsFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T4241::class),
                docTextContainsFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T4242::class),
                attachFileNameContainsFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T4243::class),
                isHasAttachFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T4244::class),
                contactNameContainsFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T4245::class),
                contactPhoneContainsFiltrationTest.invoke(clientUser, dtoForClientFiltration).withId(T4246::class)
            )
        )
    }

    @TestFactory
    @T4247 //'Письмо в Банк'. Фильтрация по полю 'documentNumber' (contains) [BANK]
    @T4248 //'Письмо в Банк'. Фильтрация по полю 'documentDate' (ge) [BANK]
    @T4249 //'Письмо в Банк'. Фильтрация по полю 'documentDate' (le) [BANK]
    @T4250 //'Письмо в Банк'. Фильтрация по полю 'documentDate' ge and 'documentDate' le [BANK]
    @T4251 //'Письмо в Банк'. Фильтрация по полю 'branchId' (eq) [BANK]
    @T4252 //'Письмо в Банк'. Фильтрация по полю 'customerId' (eq) [BANK]
    @T4253 //'Письмо в Банк'. Фильтрация по полю 'status' (eq) [BANK]
    @T4254 //'Письмо в Банк'. Фильтрация по полю 'docTheme' (contains) [BANK]
    @T4255 //'Письмо в Банк'. Фильтрация по полю 'docText' (contains) [BANK]
    @T4256 //'Письмо в Банк'. Фильтрация по полю 'attachName' (contains) [BANK]
    @T4257 //'Письмо в Банк'. Фильтрация по полю 'isHasAttach' (eq) [BANK]
    @T4258 //'Письмо в Банк'. Фильтрация по полю 'contactName' (contains) [BANK]
    @T4259 //'Письмо в Банк'. Фильтрация по полю 'contactPhone' (contains) [BANK]
    @T4260 //'Письмо в Банк'. Фильтрация по полю 'docType' (eq) [BANK]
    @T4261 //'Письмо в Банк'. Фильтрация по полю 'receiveDate' (ge) [BANK]
    @T4262 //'Письмо в Банк'. Фильтрация по полю 'receiveDate' (le) [BANK]
    @T4263 //'Письмо в Банк'. Фильтрация по полю 'receiveDate' ge and 'receiveDate' le [BANK]
    @T4264 //'Письмо в Банк'. Фильтрация по полю 'executionDate' (ge) [BANK]
    @T4265 //'Письмо в Банк'. Фильтрация по полю 'executionDate' (le) [BANK]
    @T4266 //'Письмо в Банк'. Фильтрация по полю 'executionDate' ge and 'executionDate' le [BANK]
    internal fun bankFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725515
                docNumberContainsTest.invoke(bankUser, dtoForBankFiltration).withId(T4247::class),
                docDateGeFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4248::class),
                docDateLeFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4249::class),
                docDateLeGeFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4250::class),
                branchIdEqFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4251::class),
                customerIdEqFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4252::class),
                statusEqFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4253::class),
                docThemeContainsFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4254::class),
                docTextContainsFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4255::class),
                attachFileNameContainsFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4256::class),
                isHasAttachFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4257::class),
                contactNameContainsFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4258::class),
                contactPhoneContainsFiltrationTest.invoke(bankUser, dtoForBankFiltration).withId(T4259::class),

                docTypeEqFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4260::class),
                receiveDateGeFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4261::class),
                receiveDateLeFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4262::class),
                receiveDateLeGeFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4263::class),
                executionDateGeFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4264::class),
                executionDateLeFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4265::class),
                executionDateLeGeFiltrationBankTest.invoke(bankUser, dtoForBankFiltration).withId(T4266::class)
            )
        )
    }

    @TestFactory
    @T1948 //'Письмо в Банк'. Получение количества документов по фильтру (documentDate) [CLIENT]
    @T1949 //'Письмо в Банк'. Получение количества документов по фильтру (status) [CLIENT]
    @T1950 //'Письмо в Банк'. Получение количества документов по фильтру (documentNumber) [CLIENT]
    internal fun filtrationCountClientTests(): List<DynamicTest> {
        val filterByDate = DOCUMENT_DATE.eq(dtoForClientFiltration.documentDate).toFilter()
        val filterByStatus = STATUS.eq(dtoForClientFiltration.status!!).toFilter()
        val filterByNumber = DOCUMENT_NUMBER.eq(dtoForClientFiltration.documentNumber).toFilter()
        val filterByWrongNumber = DOCUMENT_NUMBER.eq("-1").toFilter()

        return EntityTestGenerator.generate(
            listOf(
                LetterToBankFiltrationCountTest(clientUser, filterByDate).withId(T1948::class),
                LetterToBankFiltrationCountTest(clientUser, filterByStatus).withId(T1949::class),
                LetterToBankFiltrationCountTest(clientUser, filterByNumber).withId(T1950::class),
                LetterToBankFiltrationCountTest(clientUser, filterByWrongNumber).withId(T1950::class)
            )
        )
    }

    @TestFactory
    @T1951 //'Письмо в Банк'. Получение количества документов по фильтру (documentDate) [BANK]
    @T1952 //'Письмо в Банк'. Получение количества документов по фильтру (status) [BANK]
    @T1953 //'Письмо в Банк'. Получение количества документов по фильтру (documentNumber) [BANK]
    internal fun filtrationCountBankTests(): List<DynamicTest> {
        val filterByDate = DOCUMENT_DATE.eq(dtoForBankFiltration.documentDate).toFilter()
        val filterByStatus = STATUS.eq(dtoForBankFiltration.status!!).toFilter()
        val filterByNumber = DOCUMENT_NUMBER.eq(dtoForBankFiltration.documentNumber).toFilter()
        val filterByWrongNumber = DOCUMENT_NUMBER.eq("-1").toFilter()

        return EntityTestGenerator.generate(
            listOf(
                LetterToBankFiltrationCountTest(bankUser, filterByDate).withId(T1951::class),
                LetterToBankFiltrationCountTest(bankUser, filterByStatus).withId(T1952::class),
                LetterToBankFiltrationCountTest(bankUser, filterByNumber).withId(T1953::class),
                LetterToBankFiltrationCountTest(bankUser, filterByWrongNumber).withId(T1953::class)
            )
        )
    }


    //region Tests
    private val docNumberContainsTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            name = "documentNumber ${Predicate.CONTAINS}",
            user = user,
            preExecution = { filtrationDto },
            filterRequestFunction = { DOCUMENT_NUMBER.contains(it!!.documentNumber.randomSubstringPf()) })
    }
    private val docDateGeFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "documentDate ${Predicate.GE}", user, { filtrationDto },
            { DOCUMENT_DATE.ge(it!!.documentDate.minusDays(1)) })
    }
    private val docDateLeFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "documentDate ${Predicate.LE}", user, { filtrationDto },
            { DOCUMENT_DATE.le(it!!.documentDate.plusDays(1)) })
    }
    private val docDateLeGeFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "documentDate ${Predicate.LE} + ${Predicate.GE}", user, { filtrationDto },
            {
                DOCUMENT_DATE.ge(it!!.documentDate.minusDays(1))
                    .and(DOCUMENT_DATE.le(it.documentDate.plusDays(1)))
            })
    }
    private val branchIdEqFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "branchId ${Predicate.EQ}", user, { filtrationDto },
            { BRANCH_ID.eq(it!!.branchId!!) })
    }
    private val customerIdEqFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "customerId ${Predicate.EQ}", user, { filtrationDto },
            { CUSTOMER_ID.eq(it!!.customerId!!) })
    }
    private val statusEqFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "status ${Predicate.EQ}", user, { filtrationDto },
            { STATUS.eq(it!!.status!!) })
    }
    private val docThemeContainsFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "docTheme ${Predicate.CONTAINS}", user, { filtrationDto },
            { DOC_THEME.contains(it!!.docTheme!!) })
    }
    private val docTextContainsFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "docText ${Predicate.CONTAINS}", user, { filtrationDto },
            { DOC_TEXT.contains(it!!.docText!!) })
    }
    private val attachFileNameContainsFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "attachFileName ${Predicate.CONTAINS}", user, { filtrationDto },
            { ATTACH_FILE_NAME.contains(it!!.attachments!!.random().fileName) })
    }
    private val isHasAttachFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "isHasAttach ${Predicate.EQ}", user, { filtrationDto },
            { IS_HAS_ATTACH.eq(it!!.isHasAttach!!) })
    }
    private val contactNameContainsFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "contactName ${Predicate.CONTAINS}", user, { filtrationDto },
            { CONTACT_NAME.contains(it!!.contactName!!) })
    }
    private val contactPhoneContainsFiltrationTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "contactPhone ${Predicate.CONTAINS}", user, { filtrationDto },
            { CONTACT_PHONE.contains(it!!.contactPhone!!) })
    }


    private val docTypeEqFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "docType ${Predicate.EQ}", user, { filtrationDto },
            { DOC_TYPE.eq(it!!.docType!!) })
    }
    private val receiveDateGeFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "receiveDate ${Predicate.GE}", user, { filtrationDto },
            { RECEIVE_DATE.ge(it!!.receiveDate!!.minusDays(1).truncatedTo(DAYS)) })
    }
    private val receiveDateLeFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "receiveDate ${Predicate.LE}", user, { filtrationDto },
            { RECEIVE_DATE.le(it!!.receiveDate!!.plusDays(1).truncatedTo(DAYS)) })
    }
    private val receiveDateLeGeFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "receiveDate ${Predicate.LE} + ${Predicate.GE}", user, { filtrationDto },
            {
                RECEIVE_DATE.ge(it!!.receiveDate!!.minusDays(1).truncatedTo(DAYS))
                    .and(RECEIVE_DATE.le(it.receiveDate!!.plusDays(1).truncatedTo(DAYS)))
            })
    }
    private val executionDateGeFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "executionDate ${Predicate.GE}", user, { filtrationDto },
            { EXECUTION_DATE.ge(it!!.executionDate!!.minusDays(1).truncatedTo(DAYS)) })
    }
    private val executionDateLeFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "executionDate ${Predicate.LE}", user, { filtrationDto },
            { EXECUTION_DATE.le(it!!.executionDate!!.plusDays(1).truncatedTo(DAYS)) })
    }
    private val executionDateLeGeFiltrationBankTest = { user: User, filtrationDto: LetterToBankDto ->
        LetterToBankFiltrationTest(
            "executionDate ${Predicate.LE} + ${Predicate.GE}", user, { filtrationDto },
            {
                EXECUTION_DATE.ge(it!!.executionDate!!.minusDays(1).truncatedTo(DAYS))
                    .and(EXECUTION_DATE.le(it.executionDate!!.plusDays(1).truncatedTo(DAYS)))
            })
    }
    //endregion
}