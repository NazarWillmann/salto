package ooo.jtc.ui.common.actions

import com.codeborne.selenide.Condition
import io.qameta.allure.Step
import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.core.container.defaultContext
import ooo.jtc.core.container.should
import ooo.jtc.core.container.shouldNot
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.tooltip
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.IDocumentView
import ooo.jtc.ui.UiHelper
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.interfaces.CreatePage
import java.util.UUID

object UiCommonChecks {

    @Step("Отобразилось уведомление: {message}")
    fun checkPushMessage(message: String) {
        defaultContext.elementByText[message].should(Condition.visible)
    }

    @Step("Отобразилось уведомление об успешном выполнении действия")
    fun checkPushSuccessMessage() {
        defaultContext.elementByText["Успешная операция"].should(Condition.visible)
    }

    @Step("Отобразилась подсказка: {message}")
    fun checkTooltipMessage(message: String) {
        defaultContext.tooltip[message].should(Condition.visible)
    }

    @Step("Проверить, что документ [{dtoId}] в одном из статусов {expStatuses}")
    fun <T: IDocument> checkDocSystemStatusThroughBE(
        beSteps: AbstractDocumentSteps<T, *>,
        dtoId: UUID,
        expStatuses: List<String>
    ) {
        val byId = beSteps.getById(dtoId).data!!
        ApiDocumentChecks<T>().checkDocumentStatus(byId, expStatuses)
    }

    @Suppress("UNCHECKED_CAST")
    @Step("Проверить, что документ скопирован успешно")
    fun <T : IDocumentView> checkDocumentCopiedSuccessfully(formPage: DocumentPage, view: T, expHeaderText: String) {
        (formPage as CreatePage<T>).checkEditFromFilledCorrect(view)
        formPage.checkHeader(expHeaderText)
        formPage.documentNumberAndDate shouldNot Condition.text(view.documentNumber)
        val currentDate = UiHelper.uiCurrentDate
        formPage.documentNumberAndDate should Condition.text(currentDate)
    }
}