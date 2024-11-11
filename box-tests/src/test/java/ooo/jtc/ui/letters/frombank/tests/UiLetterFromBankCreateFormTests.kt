package ooo.jtc.ui.letters.frombank.tests

import com.codeborne.selenide.Condition.empty
import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.exactText
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.value
import com.codeborne.selenide.Condition.visible
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps
import ooo.jtc.core.container.should
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.dictionaries.lettertypefrombank.LetterTypeFromBankData
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.BankApplication
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.letters.frombank.LFBTaskIdsUiFormBasicRequisites
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormBasicRequisitesTab
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsInAnyOrder
import org.hamcrest.Matchers.hasItems
import java.time.LocalDate


private fun openCreateLFBForm(bankUser: User): LetterFromBankFormBasicRequisitesTab {
    val scrollerPage = BankApplication.lFBScrollerPageBank

    scrollerPage.openScrollerBy(bankUser)
    scrollerPage.createLetter.click(false)
    return BankApplication.lFBFormBasicRequisitesBank
}

@LFBTaskIdsUiFormBasicRequisites
@NormalPriority
class UiLTBCreateFormNumberDateStatusTest(val bankUser: User) : AbstractTest<Unit, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. ЭФ создания документа. Поля Номер, Дата, Статус"
) {
    override fun execution(preconditionResult: Unit?) {
        val createForm = openCreateLFBForm(bankUser)

        createForm.headerName = "Новое письмо из банка"
        //TODO A.Stykalin [09.11.2020] тут падаем на проверке номера документа.
        // ждем ответа от аналитики по багу https://jira.jtc.ooo/browse/JTCSALTO-3062
        // возможно нужно будет изменить ТК (JTCSALTO-T4121), т.к. branchId не приходит из /PreFill (потому что у пользователя больше одного подразделения),
        // то и запрос /GetNextOutgoingDocumentNumber фронт не отсылает, соответственно номер документа не получен и не отображается
        createForm.checkHeader(LocalDate.now())
        createForm.checkVisibleTabs(BASIC_REQUISITES)
        "Проверить, что элемент управления 'Избранным' не отображается"{
            createForm.isFavorite.shouldNot(visible)
        }

        "Проверить, что Статус не отображается"{
            createForm.status.shouldNot(visible)
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to bankUser)
    }
}

@LFBTaskIdsUiFormBasicRequisites
@NormalPriority
class UiLTBCreateFormAttachmentTest(val bankUser: User) : AbstractTest<Unit, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. ЭФ создания документа. Область выбора файла для загрузки"
) {
    override fun execution(preconditionResult: Unit?) {
        //!!Внимание! [expFileSize] зависит от содержимого в [fileToUpload].
        val fileToUpload = AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
        val expFileSize = "21 Б"

        val createForm = openCreateLFBForm(bankUser)

        createForm.addAttachFileText should visible
        createForm.selectFileText should visible

        createForm.addAttachFileInput.uploadFile(fileToUpload)

        createForm.attachments[0].let {
            it.attachName should text(fileToUpload.name)
            it.attachSize should text(expFileSize)
            it.attachRemove should enabled
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to bankUser)
    }
}

@LFBTaskIdsUiFormBasicRequisites
@NormalPriority
class UiLTBCreateFormThemeAndTextTest(val bankUser: User) : AbstractTest<Unit, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. ЭФ создания документа. Поле Тема и Текст"
) {
    override fun execution(preconditionResult: Unit?) {
        val createForm = openCreateLFBForm(bankUser)

        createForm.docTheme should empty
        createForm.docText should empty
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to bankUser)
    }
}

@LFBTaskIdsUiFormBasicRequisites
@NormalPriority
class UiLTBCreateFormTypeDescriptionTest(val bankUser: User) : AbstractTest<Unit, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. ЭФ создания документа. Поле Тип письма"
) {
    override fun execution(preconditionResult: Unit?) {
        val notSelectedOption = "Не выбран"
        val expTypeDescriptionOptions = LetterTypeFromBankData.get().map { it.description }.toMutableList()
        expTypeDescriptionOptions.add(notSelectedOption)
        val createForm = openCreateLFBForm(bankUser)

        createForm.docTypeDescription should text(notSelectedOption)
        createForm.docTypeDescription.openOptions()
        val actTypeDescriptionOptions = createForm.docTypeDescription.optionsValues
        assertThat(
            "Список Тип письма не соответствует ожидаемому",
            actTypeDescriptionOptions,
            containsInAnyOrder(*expTypeDescriptionOptions.toTypedArray())
        )
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to bankUser)
    }
}

@LFBTaskIdsUiFormBasicRequisites
@NormalPriority
class UiLTBCreateFormCustomerAndBranchNameOneBranchTest : AbstractTest<Unit, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. ЭФ создания документа. Поля Отправитель и Получатель. " +
            "Пользователь привязан к 1 Подразделению (поле Отправитель)"
) {
    override fun execution(preconditionResult: Unit?) {
        val oneBranchOperator = Users.systemBankOperator
        val branchId = BranchRepresentativeData.searchBy(oneBranchOperator)[0].branchId
            .getOrException("Оператор не привязан к подразделению.")
        val branchShortName = BranchData.byId(branchId).shortName
        val customerId = BranchCustomerData.searchByBranchesIds(branchId)[0].customerId
            .getOrException("К подразделению ($branchId) не привязан ни один клиент")
        val customerShortName = CustomerData.byId(customerId).shortName
        val customerShortNamePrefix = customerShortName.take(3)

        val createForm = openCreateLFBForm(oneBranchOperator)

        createForm.labelFields.branchName should exactText(branchShortName)

        createForm.customerName should enabled
        createForm.customerName should empty

        createForm.customerName.value = customerShortNamePrefix

        assertThat(
            "В списке предложений Получателей нет значения '$customerShortName'",
            createForm.customerName.optionsValues, Matchers.hasItem(customerShortName)
        )

        createForm.customerName.select(customerShortName)
        createForm.customerName should value(customerShortName)
    }
}

@LFBTaskIdsUiFormBasicRequisites
@NormalPriority
class UiLTBCreateFormCustomerAndBranchNameMultiBranchTest : AbstractTest<Unit, Unit>(
    name = "[Банк] ${DocumentNames.LETTER_FROM_BANK}. ЭФ создания документа. Поля Отправитель и Получатель. " +
            "Пользователь является представителем нескольких подразделений Банка (поле Отправитель)"
) {
    override fun execution(preconditionResult: Unit?) {
        val multiBranchOperator = Users.bankOperator

        /* Ищем все подразделения доступные пользователю */
        val userBranchIds = BranchRepresentativeData.searchBy(multiBranchOperator).map { it.branchId!! }
        val userBranches = BranchData.get { it.id!! in userBranchIds }
        val branchShortNames = userBranches.map { it.shortName }


        val createForm = openCreateLFBForm(multiBranchOperator)
        createForm.branchName should text("Отправитель")
        val actSelectedBranchName = createForm.branchName.text.replace("Отправитель\n", "")
        assertThat("значение в поле Отправитель не в списке допустимых", branchShortNames, Matchers.hasItem(actSelectedBranchName))

        createForm.branchName.openOptions()
        val actBranchNameValues = createForm.branchName.optionsValues

        assertThat(
            "Список доступных подразделений не соответствует ожидаемому - '$branchShortNames'",
            branchShortNames, hasItems(*actBranchNameValues.toTypedArray())
        )

        /* Проверяем, что у выбранного по умолчанию подразделения есть клиенты доступные пользователю */
        val selectedBranchId = userBranches.find { it.shortName == actSelectedBranchName }!!.id!!
        var customerIds = BranchCustomerData.searchByBranchesIds(selectedBranchId).map { it.customerId }

        //если нет, выбираем в поле Отправитель подразделение с доступными клиентами и
        // т.к. в дропдауне (без прокрутки) отображаются только первые 100 записей
        // (не уверен, что в реальной жизни такое будет возможно, но делаю тест максимально стабильным с учетом и таких тестовых данных),
        // то проверяем, что выбираемое подразделение находится в первой сотне

        if (customerIds.isEmpty()) {
            val displayedUserBranchesIds = userBranches.filter { it.shortName in actBranchNameValues }.map { it.id!! }
            val availableBranchCustomers = BranchCustomerData.get { it.branchId in displayedUserBranchesIds }
            val branchIdForSelect = availableBranchCustomers.random().branchId
            customerIds = availableBranchCustomers.filter { it.branchId == branchIdForSelect }.map { it.customerId }
            val branchShortNameForSelect = userBranches.find { it.id!! == branchIdForSelect }!!.shortName
            createForm.branchName.select(branchShortNameForSelect)
        } else {
            createForm.branchName.closeOptions()
        }

        val customerShortNamesList = CustomerData.get { customerIds.contains(it.id!!) }.map { it.shortName }
        val customerShortNameForSearch = customerShortNamesList.random()
        val customerShortNamePrefix = customerShortNameForSearch.take(3)
        val expCustomerShortNameList = customerShortNamesList.filter { it.startsWith(customerShortNamePrefix) }

        createForm.customerName should enabled
        createForm.customerName should empty

        createForm.customerName.value = customerShortNamePrefix

        val actCustomerNameValues = createForm.customerName.optionsValues
        assertThat(
            "В списке предложений Получателей нет значения '$customerShortNameForSearch'",
            actCustomerNameValues, Matchers.hasItem(customerShortNameForSearch)
        )
        assertThat(
            "Список доступных получателей не соответствует ожидаемому - '$expCustomerShortNameList'",
            expCustomerShortNameList, hasItems(*actCustomerNameValues.toTypedArray())
        )

        createForm.customerName.select(customerShortNameForSearch)
        createForm.customerName should value(customerShortNameForSearch)
    }
}