@file:Suppress("MemberVisibilityCanBePrivate")

package ooo.jtc.ui.common.templates

import com.codeborne.selenide.Condition.visible
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestTemplateConstants.PARAM_CUSTOMER_ID
import ooo.jtc.core.TestTemplateConstants.PARAM_DOC_VIEW
import ooo.jtc.core.container.shouldNot
import ooo.jtc.core.elements.scroller.DocumentScroller
import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.core.elements.scroller.ScrollerCategory
import ooo.jtc.interfaces.IDocumentView
import ooo.jtc.scripts.invoke
import ooo.jtc.scripts.step
import ooo.jtc.sign.SignToolType
import ooo.jtc.uaa.User
import ooo.jtc.ui.common.actions.UiCommonChecks
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.common.sections.modals.ModalSignDocument
import ooo.jtc.ui.common.sections.modals.ModalSignDocumentResult
import java.util.*


open class UiSignFormCancelTestTemplate<
        V : IDocumentView,
        P : DocumentPage,
        M : ModalSignDocument<V>
        >(
    var entityName: String,
    val user: User,
    val formPage: P,
    val modalSignDocument: M,
    val beSteps: AbstractDocumentSteps<*, *>,
    override val preExecution: () -> V,
    val signToolType: SignToolType = SignToolType.SMS,
    val action: String = "Подписать",
    val expDocCounterText: String = "На подпись"
) : AbstractTest<V, Unit>(
    name = "$entityName. Форма Результат подписи. Кнопка Закрыть. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: V?) {
        val view = preconditionResult!!

        formPage.openFormByParams(user, view.id!!)
        formPage.makeAction(action)
        modalSignDocument.checkModalOpened(expDocCount = 1, expDocCounterText = expDocCounterText)
        modalSignDocument.cancelBtn.click(false)
        modalSignDocument shouldNot visible
        "Проверить, что статус документа не изменился"{
            UiCommonChecks.checkDocSystemStatusThroughBE(beSteps, view.id!!, listOf(view.statusSystem))
        }
    }

    override fun params(): Map<String, Any> = mapOf(PARAM_USER to user, PARAM_DOC_VIEW to preconditionResult!!)
}

open class UiSignResultFormCloseTestTemplate<
        V : IDocumentView,
        P : DocumentPage,
        M : ModalSignDocument<V>,
        R : ModalSignDocumentResult<V>
        >(
    var entityName: String,
    val user: User,
    val formPage: P,
    val modalSignDocument: M,
    val modalSignDocumentResult: R,
    val beSteps: AbstractDocumentSteps<*, *>,
    val expSignedStatus: String,
    override val preExecution: () -> V,
    val signToolType: SignToolType = SignToolType.SMS,
    val certUserName: String? = null,
    val action: String = "Подписать",
    val expDocCounterText: String = "На подпись"
) : AbstractTest<V, Unit>(
    name = "$entityName. Форма Результат подписи. Кнопка Закрыть. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: V?) {
        val view = preconditionResult!!

        formPage.openFormByParams(user, view.id!!)
        formPage.makeAction(action)
        modalSignDocument.checkModalOpened(expDocCount = 1, expDocCounterText = expDocCounterText)
        modalSignDocument.sign(signToolType = signToolType, certUserName = certUserName)
        modalSignDocumentResult.checkModalOpened()
        modalSignDocumentResult.checkCounters(1, "Подписано", 0, "Ошибка подписи")
        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps = beSteps, dtoId = view.id!!, expStatuses = listOf(expSignedStatus))
        modalSignDocumentResult.closeBtn.click(false)
        modalSignDocumentResult shouldNot visible
        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps = beSteps, dtoId = view.id!!, expStatuses = listOf(expSignedStatus))
    }

    override fun params(): Map<String, Any> = mapOf(PARAM_USER to user, PARAM_DOC_VIEW to preconditionResult!!)
}

open class UiSignResultFormSendTestTemplate<
        V : IDocumentView,
        P : DocumentPage,
        M : ModalSignDocument<V>,
        R : ModalSignDocumentResult<V>
        >(
    var entityName: String,
    val user: User,
    val formPage: P,
    val modalSignDocument: M,
    val modalSignDocumentResult: R,
    val beSteps: AbstractDocumentSteps<*, *>,
    val expSentStatuses: List<String>,
    override val preExecution: () -> V,
    val signToolType: SignToolType = SignToolType.SMS,
    val certUserName: String? = null,
    val action: String = "Подписать",
    val expDocCounterText: String = "На подпись"
) : AbstractTest<V, Unit>(
    name = "$entityName. Форма Результат подписи. Отправить документ. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: V?) {
        val view = preconditionResult!!
        val expSentPushMessage = "Отправлен в банк 1 документ"

        formPage.openFormByParams(user, view.id!!)
        formPage.makeAction(action)
        modalSignDocument.checkModalOpened(expDocCount = 1, expDocCounterText = expDocCounterText)
        modalSignDocument.sign(signToolType = signToolType, certUserName = certUserName)
        modalSignDocumentResult.checkModalOpened()
        modalSignDocumentResult.checkCounters(1, "Подписано", 0, "Ошибка подписи")
        modalSignDocumentResult.sendBtn.click(false)
        modalSignDocumentResult shouldNot visible
        UiCommonChecks.checkPushMessage(expSentPushMessage)
        UiCommonChecks.checkDocSystemStatusThroughBE(beSteps = beSteps, dtoId = view.id!!, expStatuses = expSentStatuses)
    }

    override fun params(): Map<String, Any> = mapOf(PARAM_USER to user, PARAM_DOC_VIEW to preconditionResult!!)
}

/**
 * @param extraFiltration - дополнительная фильтрация документов на скроллере.
 * @param expDocListFunc - возвращает список ожидаемых view для проверки по ID выделенных строк на скроллере.
 */
open class UiScrollerSignFormRequisitesTestTemplate<
        V : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>,
        C : ScrollerCategory,
        M : ModalSignDocument<V>
        >(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val modalSignDocument: M,
    override val preExecution: () -> UUID,
    val expDocListFunc: (actDocIds: List<UUID>) -> List<V>,
    val extraFiltration: ((FilterForm) -> Unit)? = null,
    val docCounterText: String = "На подпись",
    val docCount: Int = 2,
    val action: String = "Подписать",
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Форма Подпись. Проверка реквизитов быстрого просмотра. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.openTab(scrollerCategory)

        extraFiltration?.let {
            "Выполнить дополнительную фильтрацию"{
                scrollerPage.openFilter()
                it(scrollerPage.filterForm)
            }
        }

        val rows = scrollerPage.scroller.selectRows(docCount)
        val actIds = rows.map { UUID.fromString(it.id) }
        scrollerPage.makeAction(action)

        modalSignDocument.checkModalOpened(docCount, docCounterText)
        val expDocList = "Получить данные выбранных документов на скроллере" step { expDocListFunc(actIds) }
        modalSignDocument.checkDocsPreview(expDocList = expDocList)
    }

    override fun params(): Map<String, Any> = mapOf(PARAM_USER to user, PARAM_CUSTOMER_ID to preconditionResult!!)
}