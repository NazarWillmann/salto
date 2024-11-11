package ooo.jtc.ui.pages.documents.lettertobank.sections

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.ui.common.pages.ApplicationPageType
import ooo.jtc.ui.common.pages.DocumentPageTabs.HISTORY
import ooo.jtc.ui.common.sections.modals.ModalProcessingResult
import ooo.jtc.ui.common.sections.modals.ModalReceptionResult
import ooo.jtc.ui.common.sections.tabs.HistoryRow
import ooo.jtc.ui.common.sections.tabs.HistoryTab
import ooo.jtc.ui.pages.documents.lettertobank.form.LetterToBankFormPage

class LetterToBankHistoryTab(override val sElement: SelenideElement, pageType: ApplicationPageType) : LetterToBankFormPage(pageType = pageType),
    HistoryTab<LetterToBankHistoryTab, HistoryRow> {
    override val tabName: String = HISTORY.tabName
    override val createRow: (SelenideElement) -> HistoryRow = { HistoryRow(it) }

    override val detailStatuses: List<IDocumentStatus<*>>
        get() = listOf(receptionStatuses, processingStatuses).flatten()

    /**
     * Статусы в которых должна отображаться кнопка "Подробнее"
     * для просмотра Сведений о результатах обработки в банке.
     */
    private val processingStatuses = listOf(
        LetterToBankStatus.RECALLED,
        LetterToBankStatus.PROCESSED
    )

    /**
     * Статусы в которых должна отображаться кнопка "Подробнее"
     * для просмотра Сведений о результатах приема в банке.
     */
    private val receptionStatuses = listOf(
        LetterToBankStatus.WRONG_ESIGNATURE,
        LetterToBankStatus.DETAILS_ERROR,
        LetterToBankStatus.RECEIVED
    )

    @Step("Открыть Сведения о результатах обработки в банке")
    fun openProcessingModal(pageType: ApplicationPageType): ModalProcessingResult {
        clickDetailButton(processingStatuses, pageType)
        return ModalProcessingResult(this.headerName)
    }

    @Step("Открыть Сведения о результатах приемки в банке")
    fun openReceptionModal(pageType: ApplicationPageType): ModalReceptionResult {
        clickDetailButton(receptionStatuses, pageType)
        return ModalReceptionResult(this.headerName)
    }
}