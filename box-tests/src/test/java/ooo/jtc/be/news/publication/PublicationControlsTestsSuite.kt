package ooo.jtc.be.news.publication

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_PUBLICATION_CONTROLS
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.dictionaries.customer.CustomerSteps
import ooo.jtc.api.news.publication.PublicationControlTest
import ooo.jtc.api.news.publication.PublicationPrepareSteps
import ooo.jtc.api.news.publication.PublicationServerErrorTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.JTCSALTO_3085
import ooo.jtc.core.Issues.JTCSALTO_3105
import ooo.jtc.core.ServiceErrors.PSQL_EXCEPTION
import ooo.jtc.core.ServiceErrors.VARCHAR_VALUE_TOO_LONG
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.news.dto.PublicationTargetType
import ooo.jtc.news.dto.ReceiverCustomerDto
import ooo.jtc.news.dto.toReceiverCustomer
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.news.publication.PublicationControls
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.time.LocalDate

@Epic(TestEpic.API)
@Feature(TestFeature.CORRESPONDENCE)
@Story(TestStoryCorrespondence.CORRESPONDENCE_PUBLICATION_CONTROLS)
@DisplayName("API '${DocumentNames.PUBLICATION}' controls suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_PUBLICATION_CONTROLS
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PublicationControlsTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4877") annotation class T4877
@Tag("JTCSALTO-T4878") annotation class T4878
@Tag("JTCSALTO-T4879") annotation class T4879
@Tag("JTCSALTO-T4880") annotation class T4880
@Tag("JTCSALTO-T4881") annotation class T4881
@Tag("JTCSALTO-T4882") annotation class T4882
@Tag("JTCSALTO-T4883") annotation class T4883
@Tag("JTCSALTO-T4884") annotation class T4884
@Tag("JTCSALTO-T4885") annotation class T4885
@Tag("JTCSALTO-T4886") annotation class T4886
@Tag("JTCSALTO-T4887") annotation class T4887
@Tag("JTCSALTO-T4888") annotation class T4888
@Tag("JTCSALTO-T4889") annotation class T4889
@Tag("JTCSALTO-T4890") annotation class T4890
@Tag("JTCSALTO-T4891") annotation class T4891
@Tag("JTCSALTO-T4892") annotation class T4892
@Tag("JTCSALTO-T4893") annotation class T4893
@Tag("JTCSALTO-T4894") annotation class T4894
@Tag("JTCSALTO-T4895") annotation class T4895
@Tag("JTCSALTO-T4896") annotation class T4896
@Tag("JTCSALTO-T4897") annotation class T4897
@Tag("JTCSALTO-T4902") annotation class T4902
//@Tag("JTCSALTO-T4903") annotation class T4903
@Tag("JTCSALTO-T4904") annotation class T4904
@Tag("JTCSALTO-T4905") annotation class T4905
//@Tag("JTCSALTO-T4906") annotation class T4906
//@Tag("JTCSALTO-T4907") annotation class T4907
@Tag("JTCSALTO-T4908") annotation class T4908
@Tag("JTCSALTO-T4909") annotation class T4909
@Tag("JTCSALTO-T4910") annotation class T4910
@Tag("JTCSALTO-T4911") annotation class T4911
@Tag("JTCSALTO-T4912") annotation class T4912
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client
    private val superUser = Users.superUser
    private val getDto: PublicationDto
        get() = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(relatedBankUser = bankUser)

    @TestFactory
    @T4877 //'Публикация'. Контроль: номера рассылки на непустоту. [BANK]
    @T4878 //'Публикация'. Контроль: номера рассылки на пробелы. [BANK]
    @T4879 //'Публикация'. Контроль: длины номера рассылки. [BANK]
    @T4880 //'Публикация'. Контроль: допустимых символов в номере рассылки. [BANK]
    @T4881 //'Публикация'. Контроль: уникальности номера рассылки за текущий год. [BANK]
    internal fun publicationDocumentNumberControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "номера рассылки на непустоту",
                    preExecution = { getDto.apply { documentNumber = "" } },
                    control = PublicationControls.DOCUMENT_NUMBER_EMPTY
                ).withId(T4877::class),
                PublicationControlTest(
                    testName = "номера рассылки на пробелы",
                    preExecution = { getDto.apply { documentNumber = "   " } },
                    control = PublicationControls.DOCUMENT_NUMBER_EMPTY
                ).withId(T4878::class),
                PublicationControlTest(
                    testName = "длины номера рассылки",
                    preExecution = { getDto.apply { documentNumber = digits.random(length = 11) } },
                    control = PublicationControls.DOCUMENT_NUMBER_LENGTH
                ).withId(T4879::class),
                PublicationControlTest(
                    testName = "допустимых символов в номере рассылки",
                    preExecution = { getDto.apply { documentNumber = "€" } },
                    control = PublicationControls.DOCUMENT_NUMBER_AVAILABLE_SYMBOLS
                ).withId(T4880::class),
                PublicationControlTest(
                    testName = "уникальности номера рассылки за текущий год",
                    preExecution = {
                        val existingPublication = PublicationPrepareSteps.getOrCreatePublicationDto(searchingUser = bankUser)
                        getDto.apply {
                            documentNumber = existingPublication.documentNumber
                            branchId = existingPublication.branchId
                            branchName = existingPublication.branchName
                            documentDate = existingPublication.documentDate
                        }
                    },
                    control = PublicationControls.DOCUMENT_NUMBER_UNIQUE
                ).withId(T4881::class)
            )
        )
    }

    @TestFactory
    @T4882 //'Публикация'. Контроль: допустимости даты рассылки (дата больше текущей). [BANK]
    @T4883 //'Публикация'. Контроль: допустимости даты рассылки (дата меньше текущей). [BANK]
    internal fun publicationDocumentDateControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "допустимости даты рассылки (дата больше текущей)",
                    preExecution = { getDto.apply { documentDate = LocalDate.now().plusDays(1) } },
                    control = PublicationControls.DOCUMENT_DATE_OUT_OF_RANGE
                ).withId(T4882::class),
                PublicationControlTest(
                    testName = "допустимости даты рассылки (дата меньше текущей)",
                    preExecution = { getDto.apply { documentDate = LocalDate.now().minusDays(1) } },
                    control = PublicationControls.DOCUMENT_DATE_OUT_OF_RANGE
                ).withId(T4883::class)
            )
        )
    }

    @TestFactory
    @T4902 //'Публикация'. Контроль: типа публикации на непустоту. [BANK]
    //@T4903 //'Публикация'. Контроль: типа публикации на пробелы. [BANK]
    internal fun publicationPublicationTypeControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "типа публикации на непустоту",
                    preExecution = { getDto.apply { publicationType = null } },
                    control = PublicationControls.PUBLICATION_TYPE_EMPTY
                ).withId(T4902::class)
            )
        )
    }

    @TestFactory
    @T4884 //'Публикация'. Контроль: описания публикации на непустоту. [BANK]
    @T4885 //'Публикация'. Контроль: описания публикации на пробелы. [BANK]
    @T4904 //'Публикация'. Контроль: длины описания публикации. [BANK]
    internal fun publicationDescriptionControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "описания публикации на непустоту",
                    preExecution = { getDto.apply { description = "" } },
                    control = PublicationControls.DESCRIPTION_EMPTY
                ).withId(T4884::class),
                PublicationControlTest(
                    testName = "описания публикации на пробелы",
                    preExecution = { getDto.apply { description = "   " } },
                    control = PublicationControls.DESCRIPTION_EMPTY
                ).withId(T4885::class),
                PublicationServerErrorTest(
                    testName = "длины описания публикации",
                    preExecution = { getDto.apply { description = regexWords.random(length = 255) + TestConstants.AT_POSTFIX } },
                    expectedCode = 600,
                    expectedMessage = PSQL_EXCEPTION + VARCHAR_VALUE_TOO_LONG.format(255)
                ).withId(T4904::class)
            )
        )
    }

    @TestFactory
    @T4886 //'Публикация'. Контроль: списка адресатов (Клиентов) на непустоту для адресной рассылки. [BANK]
    @T4905 //'Публикация'. Контроль: способа формирования списка адресатов на непустоту. [BANK]
    //@T4906 //'Публикация'. Контроль: способа формирования списка адресатов на пробелы. [BANK]
    //@T4907 //'Публикация'. Контроль: способа формирования списка адресатов на соответствие заданным значениям. [BANK]
    internal fun publicationTargetTypeControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "списка адресатов (Клиентов) на непустоту для адресной рассылки",
                    preExecution = {
                        getDto.apply {
                            targetType = PublicationTargetType.DIRECT.type
                            customers = emptyList()
                        }
                    },
                    control = PublicationControls.TARGET_TYPE_CUSTOMERS_EMPTY
                ).withId(T4886::class),
                PublicationControlTest(
                    testName = "способа формирования списка адресатов на непустоту",
                    preExecution = { getDto.apply { targetType = null } },
                    control = PublicationControls.TARGET_TYPE_EMPTY
                ).withId(T4905::class)
            )
        )
    }

    @TestFactory
    @T4887 //'Публикация'. Контроль: содержимого публикации на непустоту. [BANK]
    @T4888 //'Публикация'. Контроль: длины заголовка публикации. [BANK]
    @T4889 //'Публикация'. Контроль: длины текста публикации. [BANK]
    @T4890 //'Публикация'. Контроль: длины текста для ссылки публикации. [BANK]
    internal fun publicationContentControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "содержимого публикации на непустоту",
                    preExecution = {
                        getDto.apply {
                            header = ""
                            text = ""
                            picture = null
                        }
                    },
                    control = PublicationControls.CONTENT_EMPTY
                ).withId(T4887::class),
                PublicationControlTest(
                    testName = "длины заголовка публикации",
                    preExecution = { getDto.apply { header = regexWords.random(length = 81) } },
                    control = PublicationControls.HEADER_LENGTH
                ).withId(T4888::class),
                PublicationControlTest(
                    testName = "длины текста публикации",
                    preExecution = { getDto.apply { text = regexWords.random(length = 2001) } },
                    control = PublicationControls.TEXT_LENGTH
                ).withId(T4889::class),
                PublicationControlTest(
                    testName = "длины текста для ссылки публикации",
                    preExecution = { getDto.apply { linkText = regexWords.random(length = 81) } },
                    control = PublicationControls.LINK_TEXT_LENGTH
                ).withId(T4890::class)
            )
        )
    }

    @TestFactory
    @T4891 //'Публикация'. Контроль: текста для ссылки публикации на непустоту. [BANK]
    @T4892 //'Публикация'. Контроль: текста для ссылки публикации на пробелы. [BANK]
    @T4908 //'Публикация'. Контроль: для ссылки публикации на непустоту. [BANK]
    @T4909 //'Публикация'. Контроль: для ссылки публикации на пробелы. [BANK]
    internal fun publicationContentFutureControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
//                TODO mfilatov 26.11.2020 следующих двух ещё нет в ТЗ, но будут. Пометить как ISSUE!
                PublicationControlTest(
                    testName = "ссылки публикации на непустоту",
                    preExecution = {
                        getDto.apply {
                            link = ""
                            linkText = regexWords.random(length = 10)
                        }
                    },
                    control = PublicationControls.LINK_EMPTY
                ).withId(T4908::class).withIssues(JTCSALTO_3085),
                PublicationControlTest(
                    testName = "ссылки публикации на пробелы",
                    preExecution = {
                        getDto.apply {
                            link = "   "
                            linkText = regexWords.random(length = 10)
                        }
                    },
                    control = PublicationControls.LINK_EMPTY
                ).withId(T4909::class).withIssues(JTCSALTO_3085),

                PublicationControlTest(
                    testName = "текста для ссылки публикации на непустоту",
                    preExecution = {
                        getDto.apply {
                            link = regexWords.random(length = 10)
                            linkText = ""
                        }
                    },
                    control = PublicationControls.LINK_TEXT_EMPTY
                ).withId(T4891::class),
                PublicationControlTest(
                    testName = "текста для ссылки публикации на пробелы",
                    preExecution = {
                        getDto.apply {
                            link = regexWords.random(length = 10)
                            linkText = "   "
                        }
                    },
                    control = PublicationControls.LINK_TEXT_EMPTY
                ).withId(T4892::class)
            )
        )
    }

    @TestFactory
    @T4893 //'Публикация'. Контроль: наименования подразделения Банка на непустоту. [BANK]
    @T4894 //'Публикация'. Контроль: наименования подразделения Банка на пробелы. [BANK]
    @T4895 //'Публикация'. Контроль: подразделения Банка на соответствие справочнику. [BANK]
    internal fun publicationBranchNameControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "наименования подразделения Банка на непустоту",
                    preExecution = { getDto.apply { branchName = "" } },
                    control = PublicationControls.BRANCH_NAME_EMPTY
                ).withId(T4893::class),
                PublicationControlTest(
                    testName = "наименования подразделения Банка на пробелы",
                    preExecution = { getDto.apply { branchName = "   " } },
                    control = PublicationControls.BRANCH_NAME_EMPTY
                ).withId(T4894::class),
                PublicationControlTest(
                    testName = "подразделения Банка на соответствие справочнику",
                    preExecution = { getDto.apply { branchName = regexWord.random(length = 10) + TestConstants.AT_POSTFIX } },
                    control = PublicationControls.BRANCH_IN_DICTIONARY
                ).withId(T4895::class)
            )
        )
    }

    @TestFactory
    @T4896 //'Публикация'. Контроль: отсутствия блокировки адресата (Клиента). [BANK]
    @T4910 //'Публикация'. Контроль: адресата (Клиента) на соответствие справочнику (непустота). [BANK]
    @T4911 //'Публикация'. Контроль: адресата (Клиента) на соответствие справочнику (пробелы). [BANK]
    @T4912 //'Публикация'. Контроль: обслуживания адресата (Клиента) в подразделении Банка. [BANK]
    internal fun publicationCustomerControlsTests(): List<DynamicTest> {
        val availableCustomers = CustomerData.searchBy(bankUser)
        val unavailableCustomer = CustomerData.get().minus(availableCustomers)
            .random()
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "отсутствия блокировки адресата (Клиента)",
                    preExecution = {
                        val customerDto = CustomerPrepareSteps.getCustomerDtoForCreate()
                        customerDto.block.isBlock = true
                        val blockedCustomer = CustomerSteps(superUser).createWithoutBranchCustomer(customerDto).data.getOrException()
                        val availableToUserBranch = BranchData.searchBy(bankUser).map { it.id!! }.random()
                        val branchCustomerDto = BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate(availableToUserBranch, blockedCustomer.id!!)
                        BranchCustomerSteps().create(branchCustomerDto)

                        getDto.apply {
                            branchId = branchCustomerDto.branchId
                            targetType = PublicationTargetType.DIRECT.type
                            customers = listOf(blockedCustomer.toReceiverCustomer())
                        }
                    },
                    control = PublicationControls.CUSTOMER_NOT_BLOCKED,
                    postExecution = { pblDto -> pblDto.customers!!.forEach { CustomerSteps(superUser).delete(it.customerId) } }
                ).withId(T4896::class),
                PublicationControlTest(
                    testName = "адресата (Клиента) на соответствие справочнику (непустота)",
                    preExecution = {
                        getDto.apply {
                            customers = listOf(ReceiverCustomerDto(customerId = unavailableCustomer.id!!, customerName = ""))
                            targetType = PublicationTargetType.DIRECT.type
                        }
                    },
                    control = PublicationControls.CUSTOMER_NAME_EMPTY
                ).withId(T4910::class).withIssues(JTCSALTO_3105),
                PublicationControlTest(
                    testName = "адресата (Клиента) на соответствие справочнику (пробелы)",
                    preExecution = {
                        getDto.apply {
                            customers = listOf(ReceiverCustomerDto(customerId = unavailableCustomer.id!!, customerName = "   "))
                            targetType = PublicationTargetType.DIRECT.type
                        }
                    },
                    control = PublicationControls.CUSTOMER_NAME_EMPTY
                ).withId(T4911::class).withIssues(JTCSALTO_3105),
                PublicationControlTest(
                    testName = "обслуживания адресата (Клиента) в подразделении Банка",
                    preExecution = {
                        getDto.apply {
                            branchName = regexWord.random(length = 10)
                            customers = listOf(ReceiverCustomerDto(customerId = unavailableCustomer.id!!))
                            targetType = PublicationTargetType.DIRECT.type
                        }
                    },
                    control = PublicationControls.CUSTOMER_IN_DICTIONARY
                ).withId(T4912::class).withIssues(JTCSALTO_3105)
            )
        )
    }

    @TestFactory
    @T4897 //'Публикация'. Контроль: уникальности публикации (общей рассылки). [BANK]
    internal fun publicationGeneralControlsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationControlTest(
                    testName = "уникальности публикации (общей рассылки)",
                    preExecution = {
                        val existingPublication = PublicationPrepareSteps.getOrCreatePublicationDto(searchingUser = bankUser)
                        getDto.apply {
                            header = existingPublication.header
                            text = existingPublication.text
                            picture = existingPublication.picture
                            targetType = PublicationTargetType.GENERAL.type
                        }
                    },
                    control = PublicationControls.PUBLICATION_DIRECT_UNIQUE
                ).withId(T4897::class)
            )
        )
    }
}