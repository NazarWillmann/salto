package ooo.jtc.be.news.mailgroup

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_MAILGROUP_CONTROLS
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.api.news.mailgroup.MailGroupControlTest
import ooo.jtc.api.news.mailgroup.MailGroupPrepareSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.news.dto.ReceiverCustomerDto
import ooo.jtc.news.dto.toReceiverCustomer
import ooo.jtc.news.mailgroup.MailGroupDto
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.news.mailgroup.MailGroupControls
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CORRESPONDENCE)
@Story(TestStoryCorrespondence.CORRESPONDENCE_DICTIONARY_MAILGROUP_CONTROLS)
@DisplayName("API '${DictionaryNames.MAIL_GROUP}' controls suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_MAILGROUP_CONTROLS
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MailGroupControlsTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4869") annotation class T4869
@Tag("JTCSALTO-T4870") annotation class T4870
@Tag("JTCSALTO-T4871") annotation class T4871
@Tag("JTCSALTO-T4872") annotation class T4872
@Tag("JTCSALTO-T4873") annotation class T4873
@Tag("JTCSALTO-T4874") annotation class T4874
@Tag("JTCSALTO-T4875") annotation class T4875
@Tag("JTCSALTO-T4876") annotation class T4876
@Tag("JTCSALTO-T4898") annotation class T4898
@Tag("JTCSALTO-T4899") annotation class T4899
@Tag("JTCSALTO-T4900") annotation class T4900
@Tag("JTCSALTO-T4901") annotation class T4901
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client
    private val superUser = Users.superUser
    private val getDto: MailGroupDto
        get() = MailGroupPrepareSteps.getGeneralMailGroupDtoForCreate(creatorBankUser = bankUser)

    @TestFactory
    @T4869 //'Группа рассылки Клиентов'. Контроль: наименования группы рассылки на пробелы. [BANK]
    @T4870 //'Группа рассылки Клиентов'. Контроль: наименования группы рассылки на непустоту. [BANK]
    @T4871 //'Группа рассылки Клиентов'. Контроль: длины наименования группы рассылки. [BANK]
    @T4874 //'Группа рассылки Клиентов'. Контроль: уникальности наименования группы рассылки. [BANK]
    @T4875 //'Группа рассылки Клиентов'. Контроль: допустимых символов в наименовании группы рассылки. [BANK]
    internal fun mailGroupNameControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MailGroupControlTest(
                    testName = "наименования группы рассылки на пробелы",
                    preExecution = { getDto.apply { name = "   " } },
                    control = MailGroupControls.NAME_EMPTY
                ).withId(T4869::class),
                MailGroupControlTest(
                    testName = "наименования группы рассылки на непустоту",
                    preExecution = { getDto.apply { name = "" } },
                    control = MailGroupControls.NAME_EMPTY
                ).withId(T4870::class),
                MailGroupControlTest(
                    testName = "длины наименования группы рассылки",
                    preExecution = { getDto.apply { name = regexWord.random(length = 255) + TestConstants.AT_POSTFIX } },
                    control = MailGroupControls.NAME_LENGTH
                ).withId(T4871::class),
                MailGroupControlTest(
                    testName = "уникальности наименования группы рассылки",
                    preExecution = {
                        val mailGroup = MailGroupPrepareSteps.createMailGroup(bankUser)
                        getDto.apply { name = mailGroup.name }
                    },
                    control = MailGroupControls.NAME_UNIQUE
                ).withId(T4874::class),
                MailGroupControlTest(
                    testName = "допустимых символов в наименовании группы рассылки",
                    preExecution = { getDto.apply { name = "€" } },
                    control = MailGroupControls.NAME_AVAILABLE_SYMBOLS
                ).withId(T4875::class)
            )
        )
    }

    @TestFactory
    @T4872 //'Группа рассылки Клиентов'. Контроль: наименования подразделения Банка на соответствие справочнику. [BANK]
    @T4873 //'Группа рассылки Клиентов'. Контроль: наименования подразделения Банка на пробелы. [BANK]
    @T4876 //'Группа рассылки Клиентов'. Контроль: наименования подразделения Банка на непустоту. [BANK]
    internal fun mailGroupBranchControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MailGroupControlTest(
                    testName = "наименования подразделения Банка на соответствие справочнику",
                    preExecution = { getDto.apply { branchName = regexWord.random(length = 10) + TestConstants.AT_POSTFIX } },
                    control = MailGroupControls.BRANCH_IN_DICTIONARY
                ).withId(T4872::class),
                MailGroupControlTest(
                    testName = "наименования подразделения Банка на пробелы",
                    preExecution = { getDto.apply { branchName = "   " } },
                    control = MailGroupControls.BRANCH_NAME_EMPTY
                ).withId(T4873::class),
                MailGroupControlTest(
                    testName = "наименования подразделения Банка на непустоту",
                    preExecution = { getDto.apply { branchName = "" } },
                    control = MailGroupControls.BRANCH_NAME_EMPTY
                ).withId(T4876::class)
            )
        )
    }

    @TestFactory
    @T4898 //'Группа рассылки Клиентов'. Контроль: отсутствия блокировки адресата (Клиента). [BANK]
    @T4899 //'Группа рассылки Клиентов'. Контроль: адресата (Клиента) на соответствие справочнику (непустота). [BANK]
    @T4900 //'Группа рассылки Клиентов'. Контроль: адресата (Клиента) на соответствие справочнику (пробелы). [BANK]
    @T4901 //'Группа рассылки Клиентов'. Контроль: обслуживания адресата (Клиента) в подразделении Банка. [BANK]
    internal fun mailGroupCustomerControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                MailGroupControlTest(
                    testName = "отсутствия блокировки адресата (Клиента)",
                    preExecution = {
                        val customerDto = CustomerPrepareSteps.getCustomerDtoForCreate()
                        customerDto.block.isBlock = true
                        val blockedCustomer = CustomerSteps(superUser).createWithoutBranchCustomer(customerDto).data.getOrException()
                        val availableToUserBranch = BranchData.searchBy(bankUser).map { it.id!! }.random()
                        val branchCustomerDto = BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate(availableToUserBranch, blockedCustomer.id!!)
                        BranchCustomerSteps().create(branchCustomerDto)
                        bankUser.invokeAuth(newToken = true)

                        getDto.apply {
                            branchId = branchCustomerDto.branchId
                            customers = listOf(blockedCustomer.toReceiverCustomer())
                        }
                    },
                    control = MailGroupControls.CUSTOMER_NOT_BLOCKED,
                    postExecution = { mgDto ->
                        mgDto.customers!!.forEach {
                            CustomerPrepareSteps.deleteCustomerAndRelatedEntitiesIfPossible(it.customerId)
                        }
                    }
                ).withId(T4898::class),
                MailGroupControlTest(
                    testName = "адресата (Клиента) на соответствие справочнику (непустота)",
                    preExecution = {
                        getDto.apply { customers = listOf(ReceiverCustomerDto(customerId = clientUser.id!!, customerName = "")) }
                    },
                    control = MailGroupControls.CUSTOMER_NAME_EMPTY
                ).withId(T4899::class),
                MailGroupControlTest(
                    testName = "адресата (Клиента) на соответствие справочнику (пробелы)",
                    preExecution = {
                        getDto.apply { customers = listOf(ReceiverCustomerDto(customerId = clientUser.id!!, customerName = "   ")) }
                    },
                    control = MailGroupControls.CUSTOMER_NAME_EMPTY
                ).withId(T4900::class),
                MailGroupControlTest(
                    testName = "обслуживания адресата (Клиента) в подразделении Банка",
                    preExecution = {
                        getDto.apply {
                            branchName = regexWord.random(length = 10)
                            customers = listOf(ReceiverCustomerDto(customerId = clientUser.id!!))
                        }
                    },
                    control = MailGroupControls.CUSTOMER_IN_DICTIONARY
                ).withId(T4901::class)
            )
        )
    }
}