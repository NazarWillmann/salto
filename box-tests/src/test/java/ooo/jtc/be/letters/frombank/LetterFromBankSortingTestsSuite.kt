package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_SORTING
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createDeliveredLetterFromBank
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.sentLfbFilter
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.api.letters.frombank.tests.LetterFromBankSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.REQUIRED_DATA_COUNT
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.ID
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.DOCUMENT_NUMBER
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.DOCUMENT_DATE
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.STATUS
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.DOC_TYPE
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.DOC_TYPE_DESCRIPTION
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.DOC_THEME
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.DOC_TEXT
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.IS_HAS_ATTACH
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.BRANCH_ID
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.BRANCH_NAME
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.CONTACT_NAME
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.CONTACT_PHONE
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.CUSTOMER_ID
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.CUSTOMER_NAME
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.CREATED_AT
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.SEND_DATE
import ooo.jtc.testdata.letters.frombank.LetterFromBankSortingParams.IS_FAVORITES
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
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_SORTING)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' sorting suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_SORTING
@TestInstance(PER_CLASS)
class LetterFromBankSortingTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4599") annotation class T4599
@Tag("JTCSALTO-T4600") annotation class T4600
@Tag("JTCSALTO-T4601") annotation class T4601
@Tag("JTCSALTO-T4602") annotation class T4602
@Tag("JTCSALTO-T4603") annotation class T4603
@Tag("JTCSALTO-T4604") annotation class T4604
@Tag("JTCSALTO-T4605") annotation class T4605
@Tag("JTCSALTO-T4606") annotation class T4606
@Tag("JTCSALTO-T4607") annotation class T4607
@Tag("JTCSALTO-T4608") annotation class T4608
@Tag("JTCSALTO-T4609") annotation class T4609
@Tag("JTCSALTO-T4610") annotation class T4610
@Tag("JTCSALTO-T4611") annotation class T4611
@Tag("JTCSALTO-T4612") annotation class T4612
@Tag("JTCSALTO-T4613") annotation class T4613
@Tag("JTCSALTO-T4614") annotation class T4614
@Tag("JTCSALTO-T4615") annotation class T4615
@Tag("JTCSALTO-T4616") annotation class T4616
@Tag("JTCSALTO-T4617") annotation class T4617
@Tag("JTCSALTO-T4618") annotation class T4618
@Tag("JTCSALTO-T4619") annotation class T4619
@Tag("JTCSALTO-T4620") annotation class T4620
@Tag("JTCSALTO-T4621") annotation class T4621
@Tag("JTCSALTO-T4622") annotation class T4622
@Tag("JTCSALTO-T4623") annotation class T4623
@Tag("JTCSALTO-T4624") annotation class T4624
@Tag("JTCSALTO-T4625") annotation class T4625
@Tag("JTCSALTO-T4626") annotation class T4626
@Tag("JTCSALTO-T4627") annotation class T4627
@Tag("JTCSALTO-T4628") annotation class T4628
@Tag("JTCSALTO-T4629") annotation class T4629
@Tag("JTCSALTO-T4630") annotation class T4630
@Tag("JTCSALTO-T4631") annotation class T4631
@Tag("JTCSALTO-T4632") annotation class T4632
@Tag("JTCSALTO-T4633") annotation class T4633
@Tag("JTCSALTO-T4634") annotation class T4634
@Tag("JTCSALTO-T4635") annotation class T4635
@Tag("JTCSALTO-T4636") annotation class T4636
@Tag("JTCSALTO-T4637") annotation class T4637
@Tag("JTCSALTO-T4638") annotation class T4638
@Tag("JTCSALTO-T4639") annotation class T4639
@Tag("JTCSALTO-T4640") annotation class T4640
@Tag("JTCSALTO-T4641") annotation class T4641
@Tag("JTCSALTO-T4642") annotation class T4642
@Tag("JTCSALTO-T4643") annotation class T4643
@Tag("JTCSALTO-T4644") annotation class T4644
@Tag("JTCSALTO-T4645") annotation class T4645
@Tag("JTCSALTO-T4646") annotation class T4646
@Tag("JTCSALTO-T4647") annotation class T4647
@Tag("JTCSALTO-T4648") annotation class T4648
@Tag("JTCSALTO-T4649") annotation class T4649
@Tag("JTCSALTO-T4650") annotation class T4650
@Tag("JTCSALTO-T4651") annotation class T4651
@Tag("JTCSALTO-T4652") annotation class T4652
@Tag("JTCSALTO-T4653") annotation class T4653
@Tag("JTCSALTO-T4654") annotation class T4654
@Tag("JTCSALTO-T4655") annotation class T4655
@Tag("JTCSALTO-T4656") annotation class T4656
@Tag("JTCSALTO-T4657") annotation class T4657
@Tag("JTCSALTO-T4658") annotation class T4658
@Tag("JTCSALTO-T4659") annotation class T4659
@Tag("JTCSALTO-T4660") annotation class T4660
@Tag("JTCSALTO-T4661") annotation class T4661
@Tag("JTCSALTO-T4662") annotation class T4662
@Tag("JTCSALTO-T4663") annotation class T4663
@Tag("JTCSALTO-T4664") annotation class T4664
@Tag("JTCSALTO-T4665") annotation class T4665
@Tag("JTCSALTO-T4666") annotation class T4666
@Tag("JTCSALTO-T4667") annotation class T4667
@Tag("JTCSALTO-T4668") annotation class T4668
//@formatter:on
//endregion

    private val bankUser by lazy { Users.bankOperator }
    private val clientUser by lazy { Users.client }

    @BeforeAll
    fun prepareDataForLetterFromBankSortingTests() {
        val isNotEnoughForTest: (GenericPageResponseDto<LetterFromBankDto>) -> Boolean = {
            it.page.isNullOrEmpty() || REQUIRED_DATA_COUNT > (it.size ?: 0)
        }
        val bankAvailableLetters = LetterFromBankSteps(bankUser).getPage(sentLfbFilter.toPageRequest())
        val clientAvailableLetters = LetterFromBankSteps(clientUser).getPage()

        if (isNotEnoughForTest.invoke(clientAvailableLetters) || isNotEnoughForTest.invoke(bankAvailableLetters))
            repeat(REQUIRED_DATA_COUNT.toInt()) { createDeliveredLetterFromBank(creatorBankUser = bankUser, receiverClientUser = clientUser) }
    }

    @TestFactory
    @T4599 //'Письмо из Банка'. Сортировка по полю 'id, ASC' [CLIENT]
    @T4600 //'Письмо из Банка'. Сортировка по полю 'documentNumber, ASC' [CLIENT]
    @T4601 //'Письмо из Банка'. Сортировка по полю 'documentDate, ASC' [CLIENT]
    @T4602 //'Письмо из Банка'. Сортировка по полю 'status, ASC' [CLIENT]
    @T4603 //'Письмо из Банка'. Сортировка по полю 'docType, ASC' [CLIENT]
    @T4604 //'Письмо из Банка'. Сортировка по полю 'docTypeDescription, ASC' [CLIENT]
    @T4605 //'Письмо из Банка'. Сортировка по полю 'docTheme, ASC' [CLIENT]
    @T4606 //'Письмо из Банка'. Сортировка по полю 'docText, ASC' [CLIENT]
    @T4607 //'Письмо из Банка'. Сортировка по полю 'isHasAttach, ASC' [CLIENT]
    @T4608 //'Письмо из Банка'. Сортировка по полю 'branchId, ASC' [CLIENT]
    @T4609 //'Письмо из Банка'. Сортировка по полю 'branchName, ASC' [CLIENT]
    @T4610 //'Письмо из Банка'. Сортировка по полю 'contactName, ASC' [CLIENT]
    @T4611 //'Письмо из Банка'. Сортировка по полю 'contactPhone, ASC' [CLIENT]
    @T4612 //'Письмо из Банка'. Сортировка по полю 'customerId, ASC' [CLIENT]
    @T4613 //'Письмо из Банка'. Сортировка по полю 'customerName, ASC' [CLIENT]
    @T4614 //'Письмо из Банка'. Сортировка по полю 'createdAt, ASC' [CLIENT]
    @T4615 //'Письмо из Банка'. Сортировка по полю 'isFavorites, ASC' [CLIENT]

    @T4616 //'Письмо из Банка'. Сортировка по полю 'id, DESC' [CLIENT]
    @T4617 //'Письмо из Банка'. Сортировка по полю 'documentNumber, DESC' [CLIENT]
    @T4618 //'Письмо из Банка'. Сортировка по полю 'documentDate, DESC' [CLIENT]
    @T4619 //'Письмо из Банка'. Сортировка по полю 'status, DESC' [CLIENT]
    @T4620 //'Письмо из Банка'. Сортировка по полю 'docType, DESC' [CLIENT]
    @T4621 //'Письмо из Банка'. Сортировка по полю 'docTypeDescription, DESC' [CLIENT]
    @T4622 //'Письмо из Банка'. Сортировка по полю 'docTheme, DESC' [CLIENT]
    @T4623 //'Письмо из Банка'. Сортировка по полю 'docText, DESC' [CLIENT]
    @T4624 //'Письмо из Банка'. Сортировка по полю 'isHasAttach, DESC' [CLIENT]
    @T4625 //'Письмо из Банка'. Сортировка по полю 'branchId, DESC' [CLIENT]
    @T4626 //'Письмо из Банка'. Сортировка по полю 'branchName, DESC' [CLIENT]
    @T4627 //'Письмо из Банка'. Сортировка по полю 'contactName, DESC' [CLIENT]
    @T4628 //'Письмо из Банка'. Сортировка по полю 'contactPhone, DESC' [CLIENT]
    @T4629 //'Письмо из Банка'. Сортировка по полю 'customerId, DESC' [CLIENT]
    @T4630 //'Письмо из Банка'. Сортировка по полю 'customerName, DESC' [CLIENT]
    @T4631 //'Письмо из Банка'. Сортировка по полю 'createdAt, DESC' [CLIENT]
    @T4632 //'Письмо из Банка'. Сортировка по полю 'isFavorites, DESC' [CLIENT]
    internal fun letterToBankSortingClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // Numbers are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727433
                LetterFromBankSortingTest(clientUser, ID::asc).withId(T4599::class),
                LetterFromBankSortingTest(clientUser, DOCUMENT_NUMBER::asc).withId(T4600::class),    //6.3 | 1
                LetterFromBankSortingTest(clientUser, DOCUMENT_DATE::asc).withId(T4601::class),      //6.3 | 2
                LetterFromBankSortingTest(clientUser, STATUS::asc).withId(T4602::class),
                LetterFromBankSortingTest(clientUser, DOC_TYPE::asc).withId(T4603::class),
                LetterFromBankSortingTest(clientUser, DOC_TYPE_DESCRIPTION::asc).withId(T4604::class),
                LetterFromBankSortingTest(clientUser, DOC_THEME::asc).withId(T4605::class),
                LetterFromBankSortingTest(clientUser, DOC_TEXT::asc).withId(T4606::class),
                LetterFromBankSortingTest(clientUser, IS_HAS_ATTACH::asc).withId(T4607::class),
                LetterFromBankSortingTest(clientUser, BRANCH_ID::asc).withId(T4608::class),
                LetterFromBankSortingTest(clientUser, BRANCH_NAME::asc).withId(T4609::class),
                LetterFromBankSortingTest(clientUser, CONTACT_NAME::asc).withId(T4610::class),
                LetterFromBankSortingTest(clientUser, CONTACT_PHONE::asc).withId(T4611::class),
                LetterFromBankSortingTest(clientUser, CUSTOMER_ID::asc).withId(T4612::class),
                LetterFromBankSortingTest(clientUser, CUSTOMER_NAME::asc).withId(T4613::class),
                LetterFromBankSortingTest(clientUser, CREATED_AT::asc).withId(T4614::class),
                //LetterFromBankSortingTest(clientUser, SEND_DATE::asc),//unavailable field
                LetterFromBankSortingTest(clientUser, IS_FAVORITES::asc).withId(T4615::class),

                LetterFromBankSortingTest(clientUser, ID::desc).withId(T4616::class),
                LetterFromBankSortingTest(clientUser, DOCUMENT_NUMBER::desc).withId(T4617::class),   //6.3 | 1
                LetterFromBankSortingTest(clientUser, DOCUMENT_DATE::desc).withId(T4618::class),     //6.3 | 2
                LetterFromBankSortingTest(clientUser, STATUS::desc).withId(T4619::class),
                LetterFromBankSortingTest(clientUser, DOC_TYPE::desc).withId(T4620::class),
                LetterFromBankSortingTest(clientUser, DOC_TYPE_DESCRIPTION::desc).withId(T4621::class),
                LetterFromBankSortingTest(clientUser, DOC_THEME::desc).withId(T4622::class),
                LetterFromBankSortingTest(clientUser, DOC_TEXT::desc).withId(T4623::class),
                LetterFromBankSortingTest(clientUser, IS_HAS_ATTACH::desc).withId(T4624::class),
                LetterFromBankSortingTest(clientUser, BRANCH_ID::desc).withId(T4625::class),
                LetterFromBankSortingTest(clientUser, BRANCH_NAME::desc).withId(T4626::class),
                LetterFromBankSortingTest(clientUser, CONTACT_NAME::desc).withId(T4627::class),
                LetterFromBankSortingTest(clientUser, CONTACT_PHONE::desc).withId(T4628::class),
                LetterFromBankSortingTest(clientUser, CUSTOMER_ID::desc).withId(T4629::class),
                LetterFromBankSortingTest(clientUser, CUSTOMER_NAME::desc).withId(T4630::class),
                LetterFromBankSortingTest(clientUser, CREATED_AT::desc).withId(T4631::class),
                //LetterFromBankSortingTest(clientUser, SEND_DATE::desc),//unavailable field
                LetterFromBankSortingTest(clientUser, IS_FAVORITES::desc).withId(T4632::class),
            )
        )
    }

    @TestFactory
    @T4633 //'Письмо из Банка'. Сортировка по полю 'id, ASC' [BANK]
    @T4634 //'Письмо из Банка'. Сортировка по полю 'documentNumber, ASC' [BANK]
    @T4635 //'Письмо из Банка'. Сортировка по полю 'documentDate, ASC' [BANK]
    @T4636 //'Письмо из Банка'. Сортировка по полю 'status, ASC' [BANK]
    @T4637 //'Письмо из Банка'. Сортировка по полю 'docType, ASC' [BANK]
    @T4638 //'Письмо из Банка'. Сортировка по полю 'docTypeDescription, ASC' [BANK]
    @T4639 //'Письмо из Банка'. Сортировка по полю 'docTheme, ASC' [BANK]
    @T4640 //'Письмо из Банка'. Сортировка по полю 'docText, ASC' [BANK]
    @T4641 //'Письмо из Банка'. Сортировка по полю 'isHasAttach, ASC' [BANK]
    @T4642 //'Письмо из Банка'. Сортировка по полю 'branchId, ASC' [BANK]
    @T4643 //'Письмо из Банка'. Сортировка по полю 'branchName, ASC' [BANK]
    @T4644 //'Письмо из Банка'. Сортировка по полю 'contactName, ASC' [BANK]
    @T4645 //'Письмо из Банка'. Сортировка по полю 'contactPhone, ASC' [BANK]
    @T4646 //'Письмо из Банка'. Сортировка по полю 'customerId, ASC' [BANK]
    @T4647 //'Письмо из Банка'. Сортировка по полю 'customerName, ASC' [BANK]
    @T4648 //'Письмо из Банка'. Сортировка по полю 'createdAt, ASC' [BANK]
    @T4649 //'Письмо из Банка'. Сортировка по полю 'sendDate, ASC' с фильтром по 'sendDate' [BANK]
    @T4650 //'Письмо из Банка'. Сортировка по полю 'isFavorites, ASC' [BANK]

    @T4651 //'Письмо из Банка'. Сортировка по полю 'id, DESC' [BANK]
    @T4652 //'Письмо из Банка'. Сортировка по полю 'documentNumber, DESC' [BANK]
    @T4653 //'Письмо из Банка'. Сортировка по полю 'documentDate, DESC' [BANK]
    @T4654 //'Письмо из Банка'. Сортировка по полю 'status, DESC' [BANK]
    @T4655 //'Письмо из Банка'. Сортировка по полю 'docType, DESC' [BANK]
    @T4656 //'Письмо из Банка'. Сортировка по полю 'docTypeDescription, DESC' [BANK]
    @T4657 //'Письмо из Банка'. Сортировка по полю 'docTheme, DESC' [BANK]
    @T4658 //'Письмо из Банка'. Сортировка по полю 'docText, DESC' [BANK]
    @T4659 //'Письмо из Банка'. Сортировка по полю 'isHasAttach, DESC' [BANK]
    @T4660 //'Письмо из Банка'. Сортировка по полю 'branchId, DESC' [BANK]
    @T4661 //'Письмо из Банка'. Сортировка по полю 'branchName, DESC' [BANK]
    @T4662 //'Письмо из Банка'. Сортировка по полю 'contactName, DESC' [BANK]
    @T4663 //'Письмо из Банка'. Сортировка по полю 'contactPhone, DESC' [BANK]
    @T4664 //'Письмо из Банка'. Сортировка по полю 'customerId, DESC' [BANK]
    @T4665 //'Письмо из Банка'. Сортировка по полю 'customerName, DESC' [BANK]
    @T4666 //'Письмо из Банка'. Сортировка по полю 'createdAt, DESC' [BANK]
    @T4667 //'Письмо из Банка'. Сортировка по полю 'sendDate, DESC' с фильтром по 'sendDate' [BANK]
    @T4668 //'Письмо из Банка'. Сортировка по полю 'isFavorites, DESC' [BANK]
    internal fun letterToBankSortingBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                // Numbers are based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21727436
                LetterFromBankSortingTest(bankUser, ID::asc).withId(T4633::class),
                LetterFromBankSortingTest(bankUser, DOCUMENT_NUMBER::asc).withId(T4634::class),
                LetterFromBankSortingTest(bankUser, DOCUMENT_DATE::asc).withId(T4635::class),        //6.3 | 1
                LetterFromBankSortingTest(bankUser, STATUS::asc).withId(T4636::class),               //6.3 | 2
                LetterFromBankSortingTest(bankUser, DOC_TYPE::asc).withId(T4637::class),
                LetterFromBankSortingTest(bankUser, DOC_TYPE_DESCRIPTION::asc).withId(T4638::class), //6.3 | 4
                LetterFromBankSortingTest(bankUser, DOC_THEME::asc).withId(T4639::class),
                LetterFromBankSortingTest(bankUser, DOC_TEXT::asc).withId(T4640::class),
                LetterFromBankSortingTest(bankUser, IS_HAS_ATTACH::asc).withId(T4641::class),
                LetterFromBankSortingTest(bankUser, BRANCH_ID::asc).withId(T4642::class),
                LetterFromBankSortingTest(bankUser, BRANCH_NAME::asc).withId(T4643::class),
                LetterFromBankSortingTest(bankUser, CONTACT_NAME::asc).withId(T4644::class),
                LetterFromBankSortingTest(bankUser, CONTACT_PHONE::asc).withId(T4645::class),
                LetterFromBankSortingTest(bankUser, CUSTOMER_ID::asc).withId(T4646::class),
                LetterFromBankSortingTest(bankUser, CUSTOMER_NAME::asc).withId(T4647::class),        //6.3 | 3
                LetterFromBankSortingTest(bankUser, CREATED_AT::asc).withId(T4648::class),           //6.3 | 5
                LetterFromBankSortingTest(bankUser, SEND_DATE::asc,
                    filterFunction = { sentLfbFilter.toFilter() }
                ).withId(T4649::class),                                                              //6.3 | 6
                LetterFromBankSortingTest(bankUser, IS_FAVORITES::asc).withId(T4650::class),

                LetterFromBankSortingTest(bankUser, ID::desc).withId(T4651::class),
                LetterFromBankSortingTest(bankUser, DOCUMENT_NUMBER::desc).withId(T4652::class),
                LetterFromBankSortingTest(bankUser, DOCUMENT_DATE::desc).withId(T4653::class),       //6.3 | 1
                LetterFromBankSortingTest(bankUser, STATUS::desc).withId(T4654::class),              //6.3 | 2
                LetterFromBankSortingTest(bankUser, DOC_TYPE::desc).withId(T4655::class),
                LetterFromBankSortingTest(bankUser, DOC_TYPE_DESCRIPTION::desc).withId(T4656::class),//6.3 | 4
                LetterFromBankSortingTest(bankUser, DOC_THEME::desc).withId(T4657::class),
                LetterFromBankSortingTest(bankUser, DOC_TEXT::desc).withId(T4658::class),
                LetterFromBankSortingTest(bankUser, IS_HAS_ATTACH::desc).withId(T4659::class),
                LetterFromBankSortingTest(bankUser, BRANCH_ID::desc).withId(T4660::class),
                LetterFromBankSortingTest(bankUser, BRANCH_NAME::desc).withId(T4661::class),
                LetterFromBankSortingTest(bankUser, CONTACT_NAME::desc).withId(T4662::class),
                LetterFromBankSortingTest(bankUser, CONTACT_PHONE::desc).withId(T4663::class),
                LetterFromBankSortingTest(bankUser, CUSTOMER_ID::desc).withId(T4664::class),
                LetterFromBankSortingTest(bankUser, CUSTOMER_NAME::desc).withId(T4665::class),       //6.3 | 3
                LetterFromBankSortingTest(bankUser, CREATED_AT::desc).withId(T4666::class),          //6.3 | 5
                LetterFromBankSortingTest(bankUser, SEND_DATE::desc,
                    filterFunction = { sentLfbFilter.toFilter() }
                ).withId(T4667::class),                                                              //6.3 | 6
                LetterFromBankSortingTest(bankUser, IS_FAVORITES::desc).withId(T4668::class),
            )
        )
    }
}