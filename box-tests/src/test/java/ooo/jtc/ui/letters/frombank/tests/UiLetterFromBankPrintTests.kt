package ooo.jtc.ui.letters.frombank.tests

import com.mifmif.common.regex.Generex
import java.util.UUID
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionCustomerIdByStatus
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.LFBPreExecutionDeliveredWithMultipleAttach
import ooo.jtc.api.letters.frombank.LetterFromBankPreExecutions.dtoForCreateWithMultipleAttach
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps.preparePrintExpContent
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps.preparePrintFileNameSingleDoc
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps.preparePrintTableExpContent
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createDeliveredLetterFromBank
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createDraftLetterFromBank
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.retrieveBankUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.getFilterData
import ooo.jtc.generic.pageparams.and
import ooo.jtc.generic.pageparams.toFilter
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.interfaces.recentDocFilterData
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.model.LetterFromBankCategory
import ooo.jtc.letters.model.LetterFromBankPrintExportFormat
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication.lFBScrollerPageBank
import ooo.jtc.ui.application.ClientApplication.lFBScrollerPageClient
import ooo.jtc.ui.common.templates.UiScrollerPrintTableMultiplePageTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerPrintTableTestTemplate
import ooo.jtc.ui.common.templates.UiScrollerPrintTestTemplate
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiPrint
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerCategory
import ooo.jtc.ui.pages.documents.letterfrombank.scroller.LetterFromBankScrollerPage
import org.hamcrest.MatcherAssert.assertThat

const val JTCSALTO_2035 = "JTCSALTO-2035"   //  Проект Salto: Release 1 > Переписка с банком > Письмо из банка > Печатные формы > ПФ документов
const val JTCSALTO_2036 = "JTCSALTO-2036"   //      [JTCSALTO-2035] > ANALITICS. Разработка требований
const val JTCSALTO_2038 = "JTCSALTO-2038"   //      [JTCSALTO-2035] > Тестирование (Написание автотестов, прочие работы тестирования)
const val JTCSALTO_2039 = "JTCSALTO-2039"   //      [JTCSALTO-2035] > Ручное тестирование
@LFBTaskIdsUiPrint
@TaskIds([JTCSALTO_2035, JTCSALTO_2036, JTCSALTO_2038, JTCSALTO_2039])
annotation class LFBTaskIdsUiPrintSingleDocument

const val JTCSALTO_2040 = "JTCSALTO-2040"   //  Проект Salto: Release 1 > Переписка с банком > Письмо из банка > Печатные формы > Реестр документов
const val JTCSALTO_2041 = "JTCSALTO-2041"   //      [JTCSALTO-2040] > ANALITICS. Разработка требований
const val JTCSALTO_2043 = "JTCSALTO-2043"   //      [JTCSALTO-2040] > Тестирование (Написание автотестов, прочие работы тестирования)
const val JTCSALTO_2856 = "JTCSALTO-2856"   //      [JTCSALTO-2040] > Ручное тестирование
@LFBTaskIdsUiPrint
@TaskIds([JTCSALTO_2040, JTCSALTO_2041, JTCSALTO_2043, JTCSALTO_2856])
annotation class LFBTaskIdsUiPrintDocumentTable



@LFBTaskIdsUiPrintSingleDocument
@NormalPriority
open class UiLFBScrollerPrintTestTemplate(
    user: User,
    printFormat: LetterFromBankPrintExportFormat,
    testName: String? = null,
    preExecution: () -> LetterFromBankDto,
    getExpFileContentFunc: (LetterFromBankDto) -> List<String> = { preparePrintExpContent(listOf(it), true, user) },
    additionalChecks: (dto: LetterFromBankDto, actContent: String) -> Unit = { _: LetterFromBankDto, _: String -> }
) : UiScrollerPrintTestTemplate<LetterFromBankDto, LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
    user = user,
    format = printFormat,
    testName = testName,
    preExecution = preExecution,
    scrollerPage = if (user.isClient) lFBScrollerPageClient else lFBScrollerPageBank,
    scrollerCategory = if (user.isClient) null else LetterFromBankScrollerCategory.ALL,
    entityName = DocumentNames.LETTER_FROM_BANK,
    availableFormats = LetterFromBankPrintExportFormat.printFormats,
    getExpFileName = { preparePrintFileNameSingleDoc(it) + "." + printFormat.format.name.toLowerCase() },
    getExpFileContentFunc = getExpFileContentFunc,
    additionalChecks = additionalChecks
)

@LFBTaskIdsUiPrintSingleDocument
@NormalPriority
class UiLFBScrollerPrintTest(
    user: User,
    printFormat: LetterFromBankPrintExportFormat
) : UiLFBScrollerPrintTestTemplate(
    user = user,
    printFormat = printFormat,
    preExecution = { LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(user) }
)

@LFBTaskIdsUiPrintSingleDocument
@NormalPriority
class UiLFBScrollerPrintWithManyAttachmentsTest(
    user: User,
    printFormat: LetterFromBankPrintExportFormat,
) : UiLFBScrollerPrintTestTemplate(
    user = user,
    testName = "${DocumentNames.LETTER_FROM_BANK}. Проверка наличия реквизитов в ПФ. (из скроллера)." +
            "[${printFormat.description}]. Количество вложений > 5. [${user.userType}]",
    printFormat = printFormat,
    preExecution = { LFBPreExecutionDeliveredWithMultipleAttach(user, 30) }
)

@LFBTaskIdsUiPrintSingleDocument
@NormalPriority
class UiLFBScrollerPrintMultiPageHugeDocTest(
    user: User,
    printFormat: LetterFromBankPrintExportFormat,
) : UiLFBScrollerPrintTestTemplate(
    user = user,
    testName = "${DocumentNames.LETTER_FROM_BANK}. Проверка наличия реквизитов в ПФ. (из скроллера)." +
            "[${printFormat.description}]. 2 страницы. [${user.userType}]",
    printFormat = printFormat,
    preExecution = {
        val hugeLetterMarker = "HUGE_LETTER"
        LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto(
            searchingUser = user,
            getPageRequest = { recentDocFilterData.and(LetterFromBankFilterParams.DOC_THEME.contains(hugeLetterMarker)).toPageRequest() },
            createLfbFunc = {
                val stringGenerator = RandomData(Generex("[0-9a-zA-Zа-яА-Я]*"))
                /* Особая подготовка данных письма.
                 * При печати длинных строк они автоматически по алгоритму (джасперРепорта) разбиваются на подстроки.
                 * В зависимости от начертания символов, строки могут получиться длиной от 69 до 76 символов.
                 * Так как при считывании из файла мы получаем не целую исходную строку, а набор её подстрок,
                 * разбитых по пробелам (например), у которых при этом 'висящие' пробелы убраны, то мы не можем
                 * в общем случае сказать, где был убран пробел, было ли их два, и т.п.
                 * Поэтому здесь подготавливаются блоки по 65 символов ('слово') и соединяются через пробелы.
                 * Количество подготавливаемых строк определяется необходимой длиной конечной строки.
                 * Также тело и тема письма будут разбиваться колонтитулами страниц, когда на странице недостаточно места,
                 * чтобы вместить всё поле.
                 *
                 * @author Pavel_Sergeyev [2020.11.12]
                 */

                // 255 - макс. длина темы по фронтовым (и мягким бэковым) контролям
                // 2000 - макс. длина текста по фронтовым (и мягким бэковым) контролям
                val hugeDocTheme = stringGenerator.hugeString(255, 65, hugeLetterMarker, AT_POSTFIX)
                val hugeDocText = stringGenerator.hugeString(2000, 65, "HugeLtrBody", AT_POSTFIX)
                LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser(
                    user = user,
                    // 6 вложений - потому что иначе не набирается на 2 страницы
                    dtoForCreate = dtoForCreateWithMultipleAttach(retrieveBankUser(user), "hugeDocTinyFile", 6)
                        .apply {
                            docTheme = hugeDocTheme
                            docText = hugeDocText
                        }
                )
            }
        )
    },
    getExpFileContentFunc = {
        val documentPlainValues = preparePrintExpContent(listOf(it), true, user)
        documentPlainValues
            .map { value -> if (value.length > 100) value.split(' ') else listOf(value) }
            .flatten()
    },
    additionalChecks = { _: LetterFromBankDto, actContent: String ->
        val pageQty = "Страница 2"
        assertThat("В документе нет строки '$pageQty'", actContent.contains(pageQty))
    }
)

@LFBTaskIdsUiPrintDocumentTable
@NormalPriority
class UiLFBScrollerPrintTableTest(
    user: User,
    printFormat: LetterFromBankPrintExportFormat,
    docAmount: Int = 2
) : UiScrollerPrintTableTestTemplate<LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lFBScrollerPageClient else lFBScrollerPageBank,
    scrollerCategory = if (user.isClient) null else LetterFromBankScrollerCategory.ALL,
    preExecution = {
        if (user.isClient) { LFBPreExecutionCustomerIdByStatus(user, docAmount, LetterFromBankStatus.DELIVERED) }
        else {
            //TODO Sergeyev [2020.11.03]: test launch on empty system (without clients) will result in error
            val availableCustomers = CustomerData.searchBy(user)
            /* Банковским пользователям отображаются все документы доступных клиентов,
             * вне зависимости от того, как ("под каким Клиентом") зашёл пользователь. */
            val filter = LetterFromBankStatus.DELIVERED.asFilterData(user).toFilter()
            val count = LetterFromBankSteps(user).getCount(filter = filter).count

            if (count < docAmount) {
                val missedDocCount = docAmount - count
                repeat(missedDocCount) { createDraftLetterFromBank(creatorBankUser = user) }
            }

            availableCustomers.random().id!!
        }
    },
    searchStatus = LetterFromBankStatus.DELIVERED.getDescription(user.userType),
    entityName = DocumentNames.LETTER_FROM_BANK,
    printFormat = printFormat,
    printAvailableFormats = LetterFromBankPrintExportFormat.printFormats,
    getExpFileName = { LetterFromBankPreparePrintSteps.preparePrintTableFileNameRegex() },
    getExpTableContentFunc = { actIds ->
        val steps = LetterFromBankSteps(user)
        val listExpDto = actIds.map { steps.getById(it).data.getOrException() }
        preparePrintTableExpContent(listExpDto, user.userType)
    }
)

@LFBTaskIdsUiPrintDocumentTable
@NormalPriority
class UiLFBScrollerPrintTableMultiPageTest(
    user: User,
    printFormat: LetterFromBankPrintExportFormat,
    docAmount: Int = 30 // необходимо наличие >=30 документов на скроллере
) : UiScrollerPrintTableMultiplePageTestTemplate<LetterFromBankScrollerPage, LetterFromBankScrollerCategory>(
    user = user,
    scrollerPage = if (user.isClient) lFBScrollerPageClient else lFBScrollerPageBank,
    scrollerCategory = if (user.isClient) null else LetterFromBankScrollerCategory.ALL,
    preExecution = {
        val availableCustomers = CustomerData.searchBy(user)
        val steps = LetterFromBankSteps(user)

        if (user.isClient) {
            /* Т.к. Клиентам на UI письма отображаются для конкретного клиента, ищем у всех доступных пользователю клиентов. */
            var customerWithMaxDocs: Pair<UUID, Int>? = null

            val availableCustomer = availableCustomers.find {
                val filter = LetterFromBankFilterParams.CUSTOMER_ID.eq(it.id!!).toFilter()
                val count = steps.getCount(filter = filter).count

                //region Optimization. Get customer with max (from customers) docs. For creating missing docs if can't find >=30.
                val maxDocCustomer = customerWithMaxDocs
                if (maxDocCustomer == null) customerWithMaxDocs = Pair(it.id!!, count) //first init
                else {
                    if (count > maxDocCustomer.second) customerWithMaxDocs = Pair(it.id!!, count)
                }
                //endregion

                count >= docAmount
            }

            val createMissedDocsFunc: (User, Pair<UUID, Int>) -> UUID = { clientUser, maxDocCustomer ->
                val missedDocCount = docAmount - maxDocCustomer.second
                repeat(missedDocCount) { createDeliveredLetterFromBank(receiverClientUser = clientUser) }
                maxDocCustomer.first
            }

            val preparedCustomerId = availableCustomer?.id ?: createMissedDocsFunc(user, customerWithMaxDocs!!)
            preparedCustomerId
        } else {
            /* Банковским пользователям отображаются все документы доступных клиентов,
             * вне зависимости от того, как ("под каким Клиентом") зашёл пользователь. */
            val filter = LetterFromBankCategory.ALL.getFilterData().toFilter()
            val count = steps.getCount(filter = filter).count

            if (count < docAmount) {
                val missedDocCount = docAmount - count
                repeat(missedDocCount) { createDraftLetterFromBank(creatorBankUser = user)}
            }

            availableCustomers.random().id!!
        }
    },
    entityName = DocumentNames.LETTER_FROM_BANK,
    printFormat = printFormat,
    getExpTableContentFunc = {
        // TODO Sergeyev [2020.11.03]: not an empty list; <document> default sorting
        val allExpContent = preparePrintTableExpContent(emptyList(), user.userType).toMutableList()
        allExpContent.add("Страница 2")
        allExpContent
    }
)
