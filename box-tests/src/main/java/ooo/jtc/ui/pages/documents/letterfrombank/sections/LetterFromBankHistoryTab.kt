package ooo.jtc.ui.pages.documents.letterfrombank.sections

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.HISTORY
import ooo.jtc.ui.common.sections.modals.ModalProcessingResult
import ooo.jtc.ui.common.sections.modals.ModalReceptionResult
import ooo.jtc.ui.common.sections.modals.ModalSendingResult
import ooo.jtc.ui.common.sections.tabs.HistoryRow
import ooo.jtc.ui.common.sections.tabs.HistoryTab
import ooo.jtc.ui.pages.documents.letterfrombank.form.LetterFromBankFormPage

class LetterFromBankHistoryTab(override val sElement: SelenideElement, pageType: ApplicationPageType)
    : LetterFromBankFormPage(pageType = pageType), HistoryTab<LetterFromBankHistoryTab, HistoryRow>
{
    override val tabName: String = HISTORY.tabName
    override val createRow: (SelenideElement) -> HistoryRow = { HistoryRow(it) }

    override val detailStatuses: List<IDocumentStatus<*>>
        get() = sentStatuses
    /**
     * Статусы в которых должна отображаться кнопка "Подробнее"
     * для просмотра Сведений о результатах отправки клиенту.
     */
    private val sentStatuses: List<IDocumentStatus<*>>
        get() = listOf(
            LetterFromBankStatus.WRONG_ESIGNATURE,
            LetterFromBankStatus.DETAILS_ERROR,
            LetterFromBankStatus.DELIVERED
        )

    @Step("Открыть Сведения о результатах отправки клиенту")
    fun openSentModal(pageType: ApplicationPageType): ModalSendingResult {
        clickDetailButton(sentStatuses, pageType)
        return ModalSendingResult(this.headerName)
    }
}