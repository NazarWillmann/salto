package ooo.jtc.ui.pages.documents.lettertobank.form

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.exactTextCaseSensitive
import com.codeborne.selenide.Condition.exist
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Condition.textCaseSensitive
import com.codeborne.selenide.Condition.value
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.conditions.MatchText
import io.qameta.allure.Step
import ooo.jtc.core.container.should
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.element
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.label
import ooo.jtc.core.elements.AllElements.listElementsX
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.Attachment
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.getPhoneWithoutCountryCode
import ooo.jtc.core.kexensions.getClientRepresentativePhone
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.core.kexensions.hasCustomerMultiBranch
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.string
import ooo.jtc.generic.KJavaConverter.getUiMaskedPhone
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.scripts.invoke
import ooo.jtc.uaa.User
import ooo.jtc.ui.UiHelper
import ooo.jtc.ui.UiHelper.uiCurrentDate
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.BASIC_REQUISITES
import ooo.jtc.ui.common.sections.tabs.TabSection
import ooo.jtc.ui.interfaces.CreatePage
import ooo.jtc.ui.interfaces.EditablePage
import ooo.jtc.ui.interfaces.ViewPage
import java.io.File
import java.time.LocalDate
import java.util.*

@ElementType("Форма 'Письмо в банк'. Закладка 'Основные реквизиты'")
class LetterToBankFormBasicRequisitesTab(pageType: ApplicationPageType) : LetterToBankFormPage(pageType = pageType),
    CreatePage<LetterToBankView>,
    EditablePage<LetterToBankView>,
    ViewPage,
    TabSection<LetterToBankFormBasicRequisitesTab> {
    override val tabName: String = BASIC_REQUISITES.tabName

    /* Form fields */
    val customerName get() = dropdown["customerName"].withTitle("Отправитель")
    val branchName get() = dropdown["branchName"].withTitle("Получатель")
    val docTypeDescription get() = dropdown["docTypeDescription"].withTitle("Тип письма")
    val contactName get() = input["contactName"].withTitle("ФИО")
    val contactPhone get() = input["contactPhone"].withTitle("Телефон")
    val docTheme get() = input["docTheme"].withTitle("Тема")
    val docText get() = textArea["docText"].withTitle("Текст")

    /**
     * Внутренний класс с полями для формы просмотра.
     */
    inner class LabelFields {
        val customerName get() = label["customerName"].withTitle("Отправитель")
        val branchName get() = label["branchName"].withTitle("Получатель")
        val docTypeDescription get() = label["docTypeDescription"].withTitle("Тип письма")
        val contactName get() = label["contactName"].withTitle("ФИО")
        val contactPhone get() = label["contactPhone"].withTitle("Телефон")
        val docTheme get() = label["docTheme"].withTitle("Тема")
        val docText get() = label["docText"].withTitle("Текст")
    }

    val addAttachFileInput
        get() = element("input[type='file']")
            .withTitle("Выбрать файлы вложения")


    val attachments: List<Attachment> get() = listElementsX(".//*[contains(@data-name,'attachments') and @role]") { Attachment(sElement = it) }

    @Step("Заполнить форму создания")
    override fun fill(view: LetterToBankView) {
        customerName.select(view.customerName)
        if (view.hasCustomerMultiBranch()) branchName.select(view.branchName)
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

    @Step("Проверить, что форма заполнена корректно")
    override fun checkEditFromFilledCorrect(view: LetterToBankView) {
        customerName should textCaseSensitive(view.customerName)
        if (view.hasCustomerMultiBranch()) branchName should textCaseSensitive(view.branchName)
        else LabelFields().branchName should textCaseSensitive(view.branchName)
        docTypeDescription should textCaseSensitive(view.docTypeDescription)
        contactName should value(view.contactName)
        contactPhone should value(getUiMaskedPhone(view.contactPhone))
        docTheme should value(view.docTheme)
        docText should textCaseSensitive(view.docText)
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

    @Step("Проверить поля на форме просмотра")
    fun checkViewFormFilledCorrect(view: LetterToBankView) {
        val labels = LabelFields()
        labels.customerName.should(exactTextCaseSensitive(view.customerName))
        labels.branchName.should(exactTextCaseSensitive(view.branchName))
        labels.docTypeDescription.should(exactTextCaseSensitive(view.docTypeDescription))
        labels.contactName.should(exactTextCaseSensitive(view.contactName))
        labels.contactPhone.should(exactTextCaseSensitive(view.contactPhone))
        labels.docTheme.should(exactTextCaseSensitive(view.docTheme))
        labels.docText.should(exactTextCaseSensitive(view.docText))
    }


    @Step("Проверить заголовок формы создания")
    fun checkHeader(docDate: LocalDate) {
        header.shouldBe(visible)
        val date = docDate.string(DOTS_DATE_FORMAT)
        header.sibling(0).shouldHave(MatchText("№ \\d+ от $date"))
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

    @Step("Проверить, что поля отображаются с возможностью редактирования")
    override fun checkFieldsEditable(view: LetterToBankView) {
        listOf(
            customerName,
            docTypeDescription,
            contactName,
            contactPhone,
            docTheme,
            docText,
        ).forEach {
            it should visible
        }
        if (view.hasCustomerMultiBranch()) branchName should visible else LabelFields().branchName should visible
        addAttachFileInput.should(exist)
    }

    @Step("Проверить, что вложения {condition.name}")
    fun checkAllAttachments(condition: Condition) {
        attachments.forEach {
            it.attachName.should(condition)
            it.attachSize.should(condition)
            it.attachRemove.should(condition)
        }
    }

    @Step("Удалить вложения. Кол-во: {qty}")
    fun removeAttachments(qty: Int) {
        //TODO A.Stykalin [03.09.2020] проверить для нескольких вложений
        for (i in 1..qty) {
            attachments[i - 1].attachRemove.click()
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

    @Step("Проверить, что отсутствует значок удаления у вложений")
    fun checkAttachmentsCantRemove() {
        attachments.forEach {
            it.attachRemove.shouldNot(visible)
        }
    }

    //based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171398
    @Step("Проверить, что на форме создания предзаполнены поля")
    fun checkPreFilled(clientUser: User, view: LetterToBankView) {
        customerName should textCaseSensitive(view.customerName)
        if (!view.hasCustomerMultiBranch()) LabelFields().branchName should textCaseSensitive(view.branchName)
        contactName should value(clientUser.getFio())
        val clientRepresentativePhone = clientUser.getClientRepresentativePhone(view.customerId)
        val preFilledPhone = getUiMaskedPhone(clientRepresentativePhone)
        contactPhone should value(preFilledPhone)
    }

    @Step("Проверить, что открылась форма ответа на письмо {lfbDocTheme} ")
    fun checkAnswerToLfb(
        user: User,
        customerId: UUID,
        lfbDocNumber: String,
        lfbDocDate: String,
        lfbDocTheme: String,
        lfbDocText: String
    ) {
        this.headerName = "Новое письмо в банк"
        documentNumberAndDate should text(uiCurrentDate)
        docTypeDescription should text("Не выбран")
        docTheme should value("RE: $lfbDocTheme")
        val expDocText = "\n\nВ ответ на: Письмо из банка (№$lfbDocNumber от $lfbDocDate)\n\n$lfbDocText"
        docText should text(expDocText)
        contactName should value(user.getFio())
        val clientRepresentativePhone = user.getClientRepresentativePhone(customerId)
        val preFilledPhone = getUiMaskedPhone(clientRepresentativePhone)
        contactPhone should value(preFilledPhone)
    }
}