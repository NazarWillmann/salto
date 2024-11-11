package ooo.jtc.ui.pages.documents.letterfrombank.form

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.conditions.MatchText
import io.qameta.allure.Step
import ooo.jtc.core.container.should
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.inputDropdown
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.listElementsX
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.Attachment
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.getPhoneWithoutCountryCode
import ooo.jtc.core.kexensions.getBankRepresentativePhone
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.string
import ooo.jtc.generic.KJavaConverter
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.uaa.User
import ooo.jtc.ui.UiHelper
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.common.sections.tabs.TabSection
import ooo.jtc.ui.interfaces.CreatePage
import ooo.jtc.ui.interfaces.ViewPage
import java.io.File
import java.time.LocalDate

@ElementType("Форма 'Письмо из банка'. Закладка 'Основные реквизиты'")
class LetterFromBankFormBasicRequisitesTab(pageType: ApplicationPageType) : LetterFromBankFormPage(pageType = pageType),
    CreatePage<LetterFromBankView>,
    ViewPage,
    TabSection<LetterFromBankFormBasicRequisitesTab> {
    override val tabName: String = BASIC_REQUISITES.tabName

    /* Form fields */
    val customerName get() = inputDropdown["customerName"].withTitle("Получатель")
    val branchName get() = dropdown["branchName"].withTitle("Отправитель")
    val docTypeDescription get() = dropdown["docTypeDescription"].withTitle("Тип письма")
    val contactName get() = input["contactName"].withTitle("ФИО")
    val contactPhone get() = input["contactPhone"].withTitle("Телефон")
    val docTheme get() = input["docTheme"].withTitle("Тема")
    val docText get() = textArea["docText"].withTitle("Текст")

    val labelFields: LabelFields by lazy { LabelFields() }

    inner class LabelFields {
        val customerName get() = label["customerName"].withTitle("Получатель")
        val branchName get() = label["branchName"].withTitle("Отправитель")
        val docTypeDescription get() = label["docTypeDescription"].withTitle("Тип письма")
        val contactName get() = label["contactName"].withTitle("ФИО")
        val contactPhone get() = label["contactPhone"].withTitle("Телефон")
        val docTheme get() = label["docTheme"].withTitle("Тема")
        val docText get() = label["docText"].withTitle("Текст")
    }

    val addAttachFileInput
        get() = element("input[type='file']")
            .withTitle("Выбрать файлы вложения")

    val addAttachFileText get() = elementByText["Перетащите файлы сюда"]
    val selectFileText get() = elementByText["Выбрать файлы"]

    val attachments: List<Attachment> get() = listElementsX(".//*[contains(@data-name,'attachments') and @role]") { Attachment(sElement = it) }

    override fun fill(view: LetterFromBankView) {
        branchName.select(view.branchName)
        customerName.select(view.customerName)
        docTypeDescription.select(view.docTypeDescription)
        contactName.value = view.contactName
        contactPhone.value = getPhoneWithoutCountryCode(view.contactPhone)
        docTheme.value = view.docTheme
        docText.value = view.docText

        view.attachmentFiles?.let { attaches ->
            attaches.forEach {
                addAttachFileInput.uploadFile(it)
            }
        }
    }

    override fun checkEditFromFilledCorrect(view: LetterFromBankView) {
        branchName should Condition.textCaseSensitive(view.branchName)
        docTypeDescription should Condition.textCaseSensitive(view.docTypeDescription)
        contactName should Condition.value(view.contactName)
        contactPhone should Condition.value(KJavaConverter.getUiMaskedPhone(view.contactPhone))
        docTheme should Condition.value(view.docTheme)
        docText should Condition.textCaseSensitive(view.docText)
        "Проверить вложения" {
            view.attachmentFiles?.let { attaches ->
                attaches.forEach { expAttach ->
                    attachments.find { it.attachName.text == expAttach.name }
                        .getOrException("Среди вложений нет наименования ${expAttach.name}")

                }
                attachments.forEach {
                    it.attachSize should visible
                    it.attachRemove should visible
                }
            }
        }
    }

    @Step("Проверить, что поля отображаются без возможности редактирования")
    override fun checkFieldsNotEditable() {
        val labels = LabelFields()
        listOf(
            labels.customerName,
            labels.branchName,
            labels.docTypeDescription,
            labels.contactName,
            labels.contactPhone,
            labels.docTheme,
            labels.docText,
        ).forEach {
            it.shouldBe(visible)
        }
    }

    @Step("Проверить заголовок формы создания")
    fun checkHeader(docDate: LocalDate) {
        header.shouldBe(visible)
        val date = docDate.string(DOTS_DATE_FORMAT)
        header.sibling(0).shouldHave(MatchText("№ \\d+ от $date"))
    }

    @Step("Проверить, что отсутствует значок удаления у вложений")
    fun checkAttachmentsCantRemove() {
        attachments.forEach {
            it.attachRemove.shouldNot(visible)
        }
    }

    @Step("Скачать вложение по имени '{attachName}'")
    fun downloadAttachment(attachName: String): File {
        attachments.find { it.attachName.text == attachName }
            .getOrException("Не удалось найти вложение с именем $attachName")
            .also { println("Attachment found: $it") }
            .attachName
            .click()

        return UiHelper.getDownloadedFile(attachName)
    }

    @Step("Удалить вложения. Кол-во: {qty}")
    fun removeAttachments(qty: Int) {
        for (i in 1..qty) {
            attachments[i - 1].attachRemove.click()
        }
    }

    @Step("Проверить, что вложения {condition.name}")
    fun checkAllAttachments(condition: Condition, isRemovable: Boolean = true) {
        attachments.forEach {
            it.attachName.should(condition)
            it.attachSize.should(condition)
            if (isRemovable) it.attachRemove.should(condition)
        }
    }

    //based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726830
    //TODO A.Stykalin [06.11.2020] возможно тут нет бага и реализация верная, см. в ТЗ https://confluence.jtc.ooo/pages/viewpage.action?pageId=21728727 4.1. Поля. п.5
//    TODO переделать, когда исправят https://jira.jtc.ooo/browse/JTCSALTO-3062
    @Step("Проверить, что на форме создания предзаполнены поля")
    fun checkPreFilled(bankUser: User, view: LetterFromBankView) {
        val isUserSingleBranch = BranchRepresentativeData.checkIfUserHasOnlyOneBranch(bankUser)

        branchName should Condition.textCaseSensitive(view.branchName)
        if (isUserSingleBranch) LabelFields().branchName should Condition.textCaseSensitive(view.branchName)
        contactName should Condition.value(bankUser.getFio())
        val contactRepresentativePhone = bankUser.getBankRepresentativePhone(view.branchId!!)
        val preFilledPhone = KJavaConverter.getUiMaskedPhone(contactRepresentativePhone)
        contactPhone should Condition.value(preFilledPhone)
    }
}