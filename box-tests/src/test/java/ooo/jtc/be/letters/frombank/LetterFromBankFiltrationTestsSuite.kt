package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_FILTRATION
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.tests.LetterFromBankFiltrationCountTest
import ooo.jtc.api.letters.frombank.tests.LetterFromBankFiltrationTest
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.ATTACH_FILE_NAME
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.DOCUMENT_NUMBER
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.DOCUMENT_DATE
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.STATUS
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.DOC_TYPE
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.DOC_THEME
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.DOC_TEXT
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.IS_HAS_ATTACH
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.BRANCH_ID
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.CONTACT_NAME
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.CONTACT_PHONE
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.CREATED_AT
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.CUSTOMER_ID
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams.SEND_DATE
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
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_FILTRATION)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' filtration suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_FILTRATION
@TestInstance(PER_CLASS)
class LetterFromBankFiltrationTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4671") annotation class T4671
@Tag("JTCSALTO-T4672") annotation class T4672
@Tag("JTCSALTO-T4673") annotation class T4673
@Tag("JTCSALTO-T4674") annotation class T4674
@Tag("JTCSALTO-T4675") annotation class T4675
@Tag("JTCSALTO-T4676") annotation class T4676
@Tag("JTCSALTO-T4677") annotation class T4677
@Tag("JTCSALTO-T4678") annotation class T4678
@Tag("JTCSALTO-T4679") annotation class T4679
@Tag("JTCSALTO-T4680") annotation class T4680
@Tag("JTCSALTO-T4681") annotation class T4681
@Tag("JTCSALTO-T4682") annotation class T4682
@Tag("JTCSALTO-T4683") annotation class T4683
@Tag("JTCSALTO-T4684") annotation class T4684
@Tag("JTCSALTO-T4685") annotation class T4685
@Tag("JTCSALTO-T4686") annotation class T4686
@Tag("JTCSALTO-T4687") annotation class T4687
@Tag("JTCSALTO-T4688") annotation class T4688
@Tag("JTCSALTO-T4689") annotation class T4689
@Tag("JTCSALTO-T4690") annotation class T4690
@Tag("JTCSALTO-T4691") annotation class T4691
@Tag("JTCSALTO-T4692") annotation class T4692
@Tag("JTCSALTO-T4693") annotation class T4693
@Tag("JTCSALTO-T4694") annotation class T4694
@Tag("JTCSALTO-T4695") annotation class T4695
@Tag("JTCSALTO-T4696") annotation class T4696
@Tag("JTCSALTO-T4697") annotation class T4697
@Tag("JTCSALTO-T4698") annotation class T4698
@Tag("JTCSALTO-T4699") annotation class T4699
@Tag("JTCSALTO-T4700") annotation class T4700
@Tag("JTCSALTO-T4701") annotation class T4701
@Tag("JTCSALTO-T4702") annotation class T4702
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val bankUser = Users.bankOperator
    private val dtoForClientFiltration: LetterFromBankDto by lazy {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = clientUser,
            getPageRequest = { recentDocFilterData.and(IS_HAS_ATTACH.eq(true)).toPageRequest() },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createDeliveredLetterFromBank(
                    receiverClientUser = clientUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        receiverClientUser = clientUser,
                        attachments = listOf(AttachmentPrepareSteps.DEFAULT_ATTACH_FILE)
                    )
                )
            }
        )
    }
    private val dtoForBankFiltration: LetterFromBankDto by lazy {
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = bankUser,
            getPageRequest = {
                recentDocFilterData
                    .and(IS_HAS_ATTACH.eq(true))
                    .and(STATUS.eq(LetterFromBankStatus.DELIVERED))
                    .toPageRequest()
            },
            createLfbFunc = {
                LetterFromBankPrepareSteps.createDeliveredLetterFromBank(
                    creatorBankUser = bankUser,
                    dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                        creatorBankUser = bankUser,
                        attachments = listOf(AttachmentPrepareSteps.DEFAULT_ATTACH_FILE)
                    )
                )
            }
        )
    }

    @TestFactory
    @T4671 //'Письмо из Банка'. Фильтрация по полю 'customerId' (eq) [CLIENT]
    @T4672 //'Письмо из Банка'. Фильтрация по полю 'documentNumber' (contains) [CLIENT]
    @T4673 //'Письмо из Банка'. Фильтрация по полю 'documentDate' (ge) [CLIENT]
    @T4674 //'Письмо из Банка'. Фильтрация по полю 'documentDate' (le) [CLIENT]
    @T4675 //'Письмо из Банка'. Фильтрация по полю 'documentDate' ge and 'documentDate' le [CLIENT]
    @T4676 //'Письмо из Банка'. Фильтрация по полю 'branchId' (eq) [CLIENT]
    @T4677 //'Письмо из Банка'. Фильтрация по полю 'docTheme' (contains) [CLIENT]
    @T4678 //'Письмо из Банка'. Фильтрация по полю 'docText' (contains) [CLIENT]
    @T4679 //'Письмо из Банка'. Фильтрация по полю 'attachName' (contains) [CLIENT]
    @T4680 //'Письмо из Банка'. Фильтрация по полю 'isHasAttach' (eq) [CLIENT]
    internal fun clientFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // Tests are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727433
                customerIdEqFiltrationTest(clientUser, dtoForClientFiltration).withId(T4671::class),             // (0)
                docNumberContainsTest(clientUser, dtoForClientFiltration).withId(T4672::class),                  // 1
                docDateGeFiltrationTest(clientUser, dtoForClientFiltration).withId(T4673::class),                // 2
                docDateLeFiltrationTest(clientUser, dtoForClientFiltration).withId(T4674::class),                // 3
                docDateLeGeFiltrationTest(clientUser, dtoForClientFiltration).withId(T4675::class),              // 2&3
                branchIdEqFiltrationTest(clientUser, dtoForClientFiltration).withId(T4676::class),               // (4)
                docThemeContainsFiltrationTest(clientUser, dtoForClientFiltration).withId(T4677::class),         // 5
                docTextContainsFiltrationTest(clientUser, dtoForClientFiltration).withId(T4678::class),          // 6
                attachFileNameContainsFiltrationTest(clientUser, dtoForClientFiltration).withId(T4679::class),   // 7
                isHasAttachFiltrationTest(clientUser, dtoForClientFiltration).withId(T4680::class),              // 8
            )
        )
    }

    @TestFactory
    @T4681 //'Письмо из Банка'. Фильтрация по полю 'documentNumber' (contains) [BANK]
    @T4682 //'Письмо из Банка'. Фильтрация по полю 'status' (eq) [BANK]
    @T4683 //'Письмо из Банка'. Фильтрация по полю 'customerId' (eq) [BANK]
    @T4684 //'Письмо из Банка'. Фильтрация по полю 'branchId' (eq) [BANK]
    @T4685 //'Письмо из Банка'. Фильтрация по полю 'docType' (eq) [BANK]
    @T4686 //'Письмо из Банка'. Фильтрация по полю 'docTheme' (contains) [BANK]
    @T4687 //'Письмо из Банка'. Фильтрация по полю 'docText' (contains) [BANK]
    @T4688 //'Письмо из Банка'. Фильтрация по полю 'attachName' (contains) [BANK]
    @T4689 //'Письмо из Банка'. Фильтрация по полю 'isHasAttach' (eq) [BANK]
    @T4690 //'Письмо из Банка'. Фильтрация по полю 'contactName' (contains) [BANK]
    @T4691 //'Письмо из Банка'. Фильтрация по полю 'contactPhone' (contains) [BANK]
    @T4692 //'Письмо из Банка'. Фильтрация по полю 'createdAt' (ge) [BANK]
    @T4693 //'Письмо из Банка'. Фильтрация по полю 'createdAt' (le) [BANK]
    @T4694 //'Письмо из Банка'. Фильтрация по полю 'createdAt' ge and 'createdAt' le [BANK]
    @T4695 //'Письмо из Банка'. Фильтрация по полю 'sendDate' (ge) [BANK]
    @T4696 //'Письмо из Банка'. Фильтрация по полю 'sendDate' (le) [BANK]
    @T4697 //'Письмо из Банка'. Фильтрация по полю 'sendDate' ge and 'sendDate' le [BANK]
    internal fun bankFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727436
                docNumberContainsTest(bankUser, dtoForBankFiltration).withId(T4681::class),                  // 1
                statusEqFiltrationTest(bankUser, dtoForBankFiltration).withId(T4682::class),                 // 2
                customerIdEqFiltrationTest(bankUser, dtoForBankFiltration).withId(T4683::class),             // (3)
                branchIdEqFiltrationTest(bankUser, dtoForBankFiltration).withId(T4684::class),               // (4)
                docTypeEqFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4685::class),            // 5
                docThemeContainsFiltrationTest(bankUser, dtoForBankFiltration).withId(T4686::class),         // 6
                docTextContainsFiltrationTest(bankUser, dtoForBankFiltration).withId(T4687::class),          // 7
                attachFileNameContainsFiltrationTest(bankUser, dtoForBankFiltration).withId(T4688::class),   // 8
                isHasAttachFiltrationTest(bankUser, dtoForBankFiltration).withId(T4689::class),              // 9
                contactNameContainsFiltrationTest(bankUser, dtoForBankFiltration).withId(T4690::class),      // 10
                contactPhoneContainsFiltrationTest(bankUser, dtoForBankFiltration).withId(T4691::class),     // 11
                createdAtGeFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4692::class),          // 12
                createdAtLeFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4693::class),          // 13
                createdAtLeGeFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4694::class),        // 12&13
                sendDateGeFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4695::class),           // 14
                sendDateLeFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4696::class),           // 15
                sendDateLeGeFiltrationBankTest(bankUser, dtoForBankFiltration).withId(T4697::class)          // 14&15
            )
        )
    }

    @TestFactory
    @T4698 //'Письмо из Банка'. Получение количества документов по фильтру (documentDate) [CLIENT]
    @T4699 //'Письмо из Банка'. Получение количества документов по фильтру (documentNumber) [CLIENT]
    internal fun filtrationCountClientTests(): List<DynamicTest> {
        val filterByDate = DOCUMENT_DATE.eq(dtoForClientFiltration.documentDate).toFilter()
        val filterByNumber = DOCUMENT_NUMBER.eq(dtoForClientFiltration.documentNumber).toFilter()
        val filterByWrongNumber = DOCUMENT_NUMBER.eq("-1").toFilter()

        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankFiltrationCountTest(clientUser, filterByDate).withId(T4698::class),
                LetterFromBankFiltrationCountTest(clientUser, filterByNumber).withId(T4699::class),
                LetterFromBankFiltrationCountTest(clientUser, filterByWrongNumber).withId(T4699::class)
            )
        )
    }

    @TestFactory
    @T4700 //'Письмо из Банка'. Получение количества документов по фильтру (documentDate) [BANK]
    @T4701 //'Письмо из Банка'. Получение количества документов по фильтру (status) [BANK]
    @T4702 //'Письмо из Банка'. Получение количества документов по фильтру (documentNumber) [BANK]
    internal fun filtrationCountBankTests(): List<DynamicTest> {
        val filterByDate = DOCUMENT_DATE.eq(dtoForBankFiltration.documentDate).toFilter()
        val filterByStatus = STATUS.eq(dtoForBankFiltration.status!!).toFilter()
        val filterByNumber = DOCUMENT_NUMBER.eq(dtoForBankFiltration.documentNumber).toFilter()
        val filterByWrongNumber = DOCUMENT_NUMBER.eq("-1").toFilter()

        return EntityTestGenerator.generate(
            listOf(
                LetterFromBankFiltrationCountTest(bankUser, filterByDate).withId(T4700::class),
                LetterFromBankFiltrationCountTest(bankUser, filterByStatus).withId(T4701::class),
                LetterFromBankFiltrationCountTest(bankUser, filterByNumber).withId(T4702::class),
                LetterFromBankFiltrationCountTest(bankUser, filterByWrongNumber).withId(T4702::class)
            )
        )
    }


    //region Tests
    private val docNumberContainsTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            name = "documentNumber ${Predicate.CONTAINS}",
            user = user,
            preExecution = { filtrationDto },
            filterRequestFunction = { DOCUMENT_NUMBER.contains(it!!.documentNumber.randomSubstringPf()) })
    }
    private val docDateGeFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "documentDate ${Predicate.GE}", user, { filtrationDto },
            { DOCUMENT_DATE.ge(it!!.documentDate.minusDays(1)) })
    }
    private val docDateLeFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "documentDate ${Predicate.LE}", user, { filtrationDto },
            { DOCUMENT_DATE.le(it!!.documentDate.plusDays(1)) })
    }
    private val docDateLeGeFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "documentDate ${Predicate.LE} + ${Predicate.GE}", user, { filtrationDto },
            {
                DOCUMENT_DATE.ge(it!!.documentDate.minusDays(1))
                    .and(DOCUMENT_DATE.le(it.documentDate.plusDays(1)))
            })
    }
    private val branchIdEqFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "branchId ${Predicate.EQ}", user, { filtrationDto },
            { BRANCH_ID.eq(it!!.branchId!!) })
    }
    private val customerIdEqFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "customerId ${Predicate.EQ}", user, { filtrationDto },
            { CUSTOMER_ID.eq(it!!.customerId!!) })
    }
    private val statusEqFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "status ${Predicate.EQ}", user, { filtrationDto },
            { STATUS.eq(it!!.status!!) })
    }
    private val docThemeContainsFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "docTheme ${Predicate.CONTAINS}", user, { filtrationDto },
            { DOC_THEME.contains(it!!.docTheme!!) })
    }
    private val docTextContainsFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "docText ${Predicate.CONTAINS}", user, { filtrationDto },
            { DOC_TEXT.contains(it!!.docText!!) })
    }
    private val attachFileNameContainsFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "attachFileName ${Predicate.CONTAINS}", user, { filtrationDto },
            { ATTACH_FILE_NAME.contains(it!!.attachments!!.random().fileName) })
    }
    private val isHasAttachFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "isHasAttach ${Predicate.EQ}", user, { filtrationDto },
            { IS_HAS_ATTACH.eq(it!!.isHasAttach!!) })
    }
    private val contactNameContainsFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "contactName ${Predicate.CONTAINS}", user, { filtrationDto },
            { CONTACT_NAME.contains(it!!.contactName!!) })
    }
    private val contactPhoneContainsFiltrationTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "contactPhone ${Predicate.CONTAINS}", user, { filtrationDto },
            { CONTACT_PHONE.contains(it!!.contactPhone!!) })
    }
    private val docTypeEqFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "docType ${Predicate.EQ}", user, { filtrationDto },
            { DOC_TYPE.eq(it!!.docType!!) })
    }
    private val createdAtGeFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "createdAt ${Predicate.GE}", user, { filtrationDto },
            { CREATED_AT.ge(it!!.createdAt!!.minusDays(1).truncatedTo(DAYS)) })
    }
    private val createdAtLeFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "createdAt ${Predicate.LE}", user, { filtrationDto },
            { CREATED_AT.le(it!!.createdAt!!.plusDays(1).truncatedTo(DAYS)) })
    }
    private val createdAtLeGeFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "createdAt ${Predicate.LE} + ${Predicate.GE}", user, { filtrationDto },
            {
                CREATED_AT.ge(it!!.createdAt!!.minusDays(1).truncatedTo(DAYS))
                    .and(CREATED_AT.le(it.createdAt!!.plusDays(1).truncatedTo(DAYS)))
            })
    }
    private val sendDateGeFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "sendDate ${Predicate.GE}", user, { filtrationDto },
            { SEND_DATE.ge(it!!.sendDate!!.minusDays(1).truncatedTo(DAYS)) })
    }
    private val sendDateLeFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "sendDate ${Predicate.LE}", user, { filtrationDto },
            { SEND_DATE.le(it!!.sendDate!!.plusDays(1).truncatedTo(DAYS)) })
    }
    private val sendDateLeGeFiltrationBankTest = { user: User, filtrationDto: LetterFromBankDto ->
        LetterFromBankFiltrationTest(
            "sendDate ${Predicate.LE} + ${Predicate.GE}", user, { filtrationDto },
            {
                SEND_DATE.ge(it!!.sendDate!!.minusDays(1).truncatedTo(DAYS))
                    .and(SEND_DATE.le(it.sendDate!!.plusDays(1).truncatedTo(DAYS)))
            })
    }
    //endregion
}