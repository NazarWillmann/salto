package ooo.jtc.ui.common.templates

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.text
import com.google.common.collect.Ordering
import io.qameta.allure.Allure.step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.steps.AbstractDocumentSteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.asserts.assertEqualList
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestConstants.documentWordFormFunc
import ooo.jtc.core.TestConstants.documentWordFormGenitiveFunc
import ooo.jtc.core.TestTemplateConstants.PARAM_CUSTOMER_ID
import ooo.jtc.core.container.should
import ooo.jtc.core.container.shouldNot
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.scroller.DocumentScroller
import ooo.jtc.core.elements.scroller.DocumentScrollerRow
import ooo.jtc.core.elements.scroller.ExpandedScroller
import ooo.jtc.core.elements.scroller.ExpandedScrollerRow
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.core.elements.scroller.Scroller.Companion.anyRow
import ooo.jtc.core.elements.scroller.ScrollerCategory
import ooo.jtc.core.elements.scroller.UiSortDirection
import ooo.jtc.core.selenide.scrollIntoView
import ooo.jtc.interfaces.IDocument
import ooo.jtc.interfaces.IDocumentView
import ooo.jtc.scripts.invoke
import ooo.jtc.scripts.step
import ooo.jtc.text.TextUtils.declensionByDigit
import ooo.jtc.uaa.User
import ooo.jtc.ui.common.actions.UiActionPlace
import ooo.jtc.ui.common.actions.UiCommonChecks.checkDocSystemStatusThroughBE
import ooo.jtc.ui.common.actions.UiCommonChecks.checkDocumentCopiedSuccessfully
import ooo.jtc.ui.common.actions.UiCommonChecks.checkPushMessage
import ooo.jtc.ui.common.pages.DocumentPage
import ooo.jtc.ui.common.pages.DocumentScrollerPage
import ooo.jtc.ui.common.sections.CommonSections.modalConfirmRemoving
import ooo.jtc.ui.common.sections.CommonSections.modalUnSignDocument
import ooo.jtc.ui.common.sections.modals.ModalSignDocument
import ooo.jtc.ui.interfaces.CreatePage
import ooo.jtc.ui.interfaces.EditablePage
import ooo.jtc.ui.interfaces.UiFiltrationParam
import ooo.jtc.ui.interfaces.UiSortingParam
import ooo.jtc.ui.interfaces.ViewPage
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import java.util.*


/**
 * Проверка фильтрации.
 * В прекондишене необходимо получить документ для проверки фильтрации по значениям его полей.
 */
open class UiScrollerFiltrationTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out ExpandedScroller<out ExpandedScrollerRow>, *, C, FilterForm>,
        SR : ExpandedScrollerRow,
        C : ScrollerCategory,
        FF : FilterForm
        >(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val filtrationParam: UiFiltrationParam<T, FF, SR>,
    override val preExecution: () -> T,
    open val maxRowLimit: Int = 20
) : AbstractTest<T, Unit>(
    name = "$entityName. Фильтрация по полю '${filtrationParam.fpName}'. [${user.userType}]",
    preExecution = preExecution
) {
    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        scrollerPage.openScrollerBy(user, dto.customerId!!)
        scrollerPage.openTab(scrollerCategory)

        scrollerPage.openFilter()
        val filterForm = scrollerPage.filterForm

        "Заполнить поля на форме фильтрации и нажать на кнопку Применить"{
            filtrationParam.fillFilterFields(filterForm as FF, dto)
            filterForm.apply.click()
            filterForm.shouldNot(Condition.visible)
        }
        scrollerPage.loader.shouldNot(Condition.visible)
        val filteredCount = scrollerPage.activeTab.getCount().toInt()

        "Проверить, что отобразился список документов, у которых значения полей '${filtrationParam.fpName}' соответствуют фильтруемым"{
            val scroller = scrollerPage.scroller
            val checkAction: (ExpandedScrollerRow) -> Unit = { row -> filtrationParam.checkFilteredValue(row as SR, dto) }
            scroller.makeActionWithRows(condition = anyRow, action = checkAction, limitRows = maxRowLimit)
        }

        scrollerPage.scroller.scrollToBottom()

        "Проверить, что по центру отобразился текст:"{
            scrollerPage.find("[role='option']").should(Condition.exist)
            scrollerPage.elementByText["Применен фильтр"] should Condition.visible
            scrollerPage.elementByText["Сейчас вы видите не все документы,"] should Condition.visible
            scrollerPage.elementByText["так как применен фильтр."] should Condition.visible
            scrollerPage.textButton["Показать все документы"] should Condition.visible
        }
        scrollerPage.textButton["Показать все документы"].scrollIntoView().scrollTo().click()

        "Проверить, что Фильтр сбросился. Показались все документы в скроллере" {
            scrollerPage.find("[role='option']").waitWhile(Condition.visible, 3000)
            scrollerPage.elementByText["Применен фильтр"] shouldNot Condition.exist
            scrollerPage.elementByText["Сейчас вы видите не все документы, так как применен фильтр."] shouldNot Condition.exist
            scrollerPage.textButton["Показать все документы"] shouldNot Condition.exist

            scrollerPage.loader.shouldNot(Condition.visible)
            val allCount = scrollerPage.activeTab.getCount().toInt()
            assertThat(
                "Счетчик кол-ва всех документов ($allCount) меньше, чем счетчик фильтрованных ($filteredCount).",
                filteredCount, Matchers.lessThanOrEqualTo(allCount)
            )
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, "Объект с полями для фильтрации" to preconditionResult!!, "Поле фильтрации" to filtrationParam.fpName)
    }
}

/**
 * Проверка сортировки.
 * В прекондишене необходимо проверить, что в системе существует минимум 3 документа для проверки сортировки.
 */
open class UiScrollerSortingTestTemplate<S : DocumentScrollerPage<out ExpandedScroller<out ExpandedScrollerRow>, *, C, *>,
        C : ScrollerCategory,
        SP : UiSortingParam>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val sortingParam: SP,
    override val preExecution: () -> UUID,
    open val maxRowLimit: Int = 50
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Сортировка по полю '${sortingParam.fieldName}'. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerCategory?.let { scrollerPage.openTab(scrollerCategory) }

        val scroller = scrollerPage.scroller
        scroller.toolbar.sortBtn.select(sortingParam.fieldName)

        val collectActValuesFunc = {
            val searchLocator = "div[data-field='${sortingParam.rowDataField}']"
            scroller.getValuesFromRows(searchLocator, maxRowLimit).map(sortingParam.stringToComparable).attachToAllure()
        }

        "Проверить, что список документов отсортирован по полю '${sortingParam.fieldName}', по убыванию"{
            val actValues = collectActValuesFunc.invoke()
            val actResult = Ordering.natural<Comparable<*>>().reverse<Comparable<*>>().isOrdered(actValues)
            assertThat("Список не отсортирован по убыванию", actResult)
        }
        "Изменить порядок сортировки"{
            scroller.toolbar.sortDirButton.sortByAsc()
        }
        "Проверить, что список документов отсортирован по полю '${sortingParam.fieldName}', по возрастанию"{
            val actValues = collectActValuesFunc.invoke()
            val actResult = Ordering.natural<Comparable<*>>().isOrdered(actValues)
            assertThat("Список не отсортирован по возрастанию", actResult)
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, "ID клиента" to preconditionResult!!, "Поле сортировки" to sortingParam.fieldName)
    }
}

/**
 * Проверка сортировки.
 * В прекондишене необходимо проверить, что в системе существует минимум 3 документа для проверки сортировки.
 */
open class UiScrollerSortingFieldTestTemplate<S : DocumentScrollerPage<out ExpandedScroller<out ExpandedScrollerRow>, *, *, *>>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val expDefaultDirection: UiSortDirection,
    val expDefaultSortingField: String,
    val expSortingFields: List<String>
) : AbstractTest<Unit, Unit>(
    name = "$entityName. Сортировка. Список полей. [${user.userType}]"
) {
    override fun execution(preconditionResult: Unit?) {
        scrollerPage.openScrollerBy(user)
        val scroller = scrollerPage.scroller

        "Проверить, что направление сортировки по умолчанию - $expDefaultDirection"{
            assertThat(
                "Направление сортировки по умолчанию отличается",
                scroller.toolbar.sortDirButton.getDirection(), equalTo(expDefaultDirection)
            )
        }

        "Проверить, что поле сортировки по умолчанию - $expDefaultSortingField"{
            assertThat(
                "сортировка по умолчанию не $expDefaultSortingField",
                scroller.toolbar.sortFieldText, equalTo(expDefaultSortingField)
            )
        }

        scroller.toolbar.sortBtn.click()

        "Проверить, что открылся список сортируемых полей $expSortingFields"{
            val actSortingFields = scroller.toolbar.sortBtn.options.items.map { it.text }
            assertThat(
                "Список сортируемых полей на форме отличается от ожидаемого $expDefaultSortingField",
                actSortingFields, Matchers.containsInAnyOrder(*expSortingFields.toTypedArray())
            )
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to user,
            "Направление сортировки по умолчанию" to expDefaultDirection,
            "Поле сортировки по умолчанию" to expDefaultSortingField,
            "Ожидаемый список сортируемых полей" to expSortingFields
        )
    }
}

/**
 * Проверка соответствия статусов документов в проверяемой категории.
 * В прекондишене необходимо проверить, что в системе для проверяемой категории есть документы.
 */
open class UiScrollerCategoryTestTemplate<
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val expStatuses: List<String>,
    override val preExecution: () -> UUID,
    open val maxRowLimit: Int = 50
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Категории документов. ${scrollerCategory.categoryName}. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult
        if (user.isClient) {
            scrollerPage.openScrollerBy(user, customerId!!)
        } else {
            scrollerPage.openScrollerBy(user)
        }
        scrollerPage.openTab(scrollerCategory)

        "Проверить, что отобразились документы только в статусах $expStatuses ($maxRowLimit)"{
            scrollerPage.scroller.makeActionWithRows(
                condition = anyRow,
                action = { assertThat("документ в недопустимом статусе", expStatuses, Matchers.hasItem(it.status.text)) },
                limitRows = maxRowLimit
            )
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, "ID клиента" to preconditionResult!!, "Категория" to scrollerCategory)
    }
}

//region Actions
open class UiScrollerAvailableActionsTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>,
        C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val expActions: List<String>,
    override val preExecution: () -> T
) : AbstractTest<T, Unit>(
    name = "$entityName. Проверка доступных действия из скроллера. [${user.userType}]",
    preExecution = preExecution
) {
    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        scrollerPage.openScrollerBy(user, dto.customerId!!)
        scrollerCategory?.let { scrollerPage.openTab(scrollerCategory) }
        val availableActions = scrollerPage.scroller.getFirstRow().moreButtonMenu.getAvailableActions()
        assertEqualList("доступные действия", expActions, availableActions)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

/**
 * Для теста следует выбирать категорию документов (со статусами) из которой можно удалить документы.
 * Например "Черновики" (DRAFTS).
 */
open class UiScrollerDeleteTestTemplate<T : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val expRowContextActions: List<String>,
    override val preExecution: () -> T
) : AbstractTest<T, Unit>(
    name = "$entityName. Удаление документа. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val view = preconditionResult!!
        scrollerPage.openScrollerBy(user, view.customerId)
        scrollerPage.openTab(scrollerCategory)
        val row =
            "Найти 1 документ из предусловия и кликнуть на элемент (три точки) вызова действия с документом" step {
                val row = scrollerPage.scroller.getRowById(view.id!!, view.documentNumber)
                row.moreButtonMenu.openMoreMenu()
                row
            }
        "Проверить, что отобразились все возможные действия с документом"{
            assertThat(
                "действия на скроллере не соответсвуют возможным для документа",
                row.moreButtonMenu.itemsText, Matchers.equalTo(expRowContextActions)
            )
        }
        "Выбрать действие Удалить"{
            row.moreButtonMenu.item["Удалить"].click()
        }
        "Появилось диалоговое окно с подтверждением удаления и кнопками Удалить и Отмена"{
            modalConfirmRemoving should Condition.visible
            modalConfirmRemoving.confirm should Condition.visible
            modalConfirmRemoving.decline should Condition.visible
        }
        "Нажать Удалить"{
            modalConfirmRemoving.confirm.click()
        }
        "Отобразилось сообщение с результатом удаления 'Успешная операция Документ N был успешно удален'"{
            scrollerPage.elementByText["Удален 1 документ"] should Condition.visible
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerSignFormTestTemplate<V : IDocumentView,
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
    val actionPlace: UiActionPlace,
    val docCount: Int,
    val action: String = "Подписать",
    val expDocCounterText: String = "На подпись"
) : AbstractTest<UUID, Unit>(
    name = {
        val actionDescription = if (docCount == 1) actionPlace.description else "групповая операция"
        val documentWordForm = documentWordFormGenitiveFunc(docCount)
        "$entityName. Форма подписи $documentWordForm из скроллера ($actionDescription). [${user.userType}]"
    }(),
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.openTab(scrollerCategory)
        val rows = scrollerPage.scroller.selectRows(docCount)
        actionPlace.makeAction(scrollerPage, rows[0], action)
        modalSignDocument.checkHeader()
        modalSignDocument.checkModalOpened(expDocCount = docCount, expDocCounterText = expDocCounterText)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_CUSTOMER_ID to preconditionResult!!)
    }
}

open class UiScrollerSendToBankSingleDocTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val beSteps: AbstractDocumentSteps<T, *>,
    val expStatuses: List<String>,
    override val preExecution: () -> T,
    val action: String = "Отправить",
    val actionPlace: UiActionPlace
) : AbstractTest<T, Unit>(
    name = "$entityName. Отправка документа в банк из скроллера (${actionPlace.description}).[${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val dto = preconditionResult!!
        scrollerPage.openScrollerBy(user, dto.customerId!!)
        scrollerPage.openTab(scrollerCategory)
        val row = scrollerPage.findDocumentRowByNumber(dto.documentNumber)
        actionPlace.makeAction(scrollerPage, row, action)
        checkPushMessage("Отправлен в банк 1 документ")
        checkDocSystemStatusThroughBE(beSteps, dto.id!!, expStatuses)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerSendToBankMultiDocTestTemplate<T : IDocument,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val beSteps: AbstractDocumentSteps<T, *>,
    val expStatuses: List<String>,
    override val preExecution: () -> UUID,
    val docCount: Int = 2,
    val action: String = "Отправить",
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Отправка документов в банк. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.openTab(scrollerCategory)
        val rows = scrollerPage.scroller.selectRows(docCount)
        val actIds = rows.map { UUID.fromString(it.id) }
        scrollerPage.makeAction(action)
        val sentActionStr = declensionByDigit(docCount, "Отправлен", "Отправлено", "Отправлено")
        val docStr = documentWordFormFunc(docCount)
        checkPushMessage("$sentActionStr в банк $docCount $docStr")
        "Проверить статус документов"{
            actIds.forEach { docId -> checkDocSystemStatusThroughBE(beSteps, docId, expStatuses) }
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerUnSignFormTestTemplate<V : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>,
        C : ScrollerCategory
        >(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    override val preExecution: () -> List<V>,
    val actionPlace: UiActionPlace,
    val docCount: Int = preExecution().size,
    val action: String = "Снять подпись"
) : AbstractTest<List<V>, Unit>(
    name = {
        val actionDescription = if (docCount == 1) actionPlace.description else "групповая операция"
        val documentWordForm = documentWordFormGenitiveFunc(docCount)
        "$entityName. Форма Снять подпись с $documentWordForm из скроллера ($actionDescription). [${user.userType}]"
    }(),
    preExecution = preExecution
) {
    override fun execution(preconditionResult: List<V>?) {
        val viewList = preconditionResult!!
        val customerId = viewList[0].customerId
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.openTab(scrollerCategory)
        val docNumbers = viewList.map { it.documentNumber }
        val rows = scrollerPage.scroller.selectRowByText(docNumbers)
        actionPlace.makeAction(scrollerPage, rows[0], action)
        modalUnSignDocument.checkHeader()
        modalUnSignDocument.checkModalOpened()
        modalUnSignDocument.checkMessage(docCount, true)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_CUSTOMER_ID to preconditionResult!!)
    }
}

open class UiScrollerEditTestTemplate<T : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>,
        C : ScrollerCategory,
        Form : DocumentPage>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val formPage: Form,
    override val preExecution: () -> T,
    val expHeaderText: String,
    val action: String = "Редактировать",
    val actionPlace: UiActionPlace
) : AbstractTest<T, Unit>(
    name = "$entityName. Редактирование документа из скроллера (${actionPlace.description}). [${user.userType}]",
    preExecution = preExecution
) {
    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: T?) {
        val view = preconditionResult!!
        scrollerPage.openScrollerBy(user, view.customerId)
        scrollerCategory?.let { scrollerPage.openTab(scrollerCategory) }
        val row = scrollerPage.findDocumentRowByNumber(view.documentNumber)
        actionPlace.makeAction(scrollerPage, row, action)

        "Проверить, что открылась форма просмотра документа c возможностью редактирования полей"{
            formPage.checkDocumentNumber(view.documentNumber)
            (formPage as EditablePage<T>).checkFieldsEditable(view)
            (formPage as CreatePage<T>).checkEditFromFilledCorrect(view)
        }

        formPage.checkHeader(expHeaderText)
        formPage.documentNumberAndDate should text(view.documentNumber)
        formPage.documentNumberAndDate should text(view.documentDate)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerViewTestTemplate<T : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>,
        C : ScrollerCategory,
        Form : DocumentPage>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C?,
    val formPage: Form,
    override val preExecution: () -> T,
    val expHeaderText: String,
    val action: String = "Просмотреть",
    val actionPlace: UiActionPlace
) : AbstractTest<T, Unit>(
    name = "$entityName. Просмотр документа из скроллера (${actionPlace.description}). [${user.userType}]",
    preExecution = preExecution
) {
    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: T?) {
        val view = preconditionResult!!
        scrollerPage.openScrollerBy(user, view.customerId)
        scrollerCategory?.let { scrollerPage.openTab(scrollerCategory) }
        val row = scrollerPage.findDocumentRowByNumber(view.documentNumber)
        actionPlace.makeAction(scrollerPage, row, action)

        "Проверить, что открылась форма просмотра документа без возможности редактирования полей"{
            formPage.checkDocumentNumber(view.documentNumber)
            (formPage as ViewPage).checkFieldsNotEditable()
        }

        formPage.checkHeader(expHeaderText)
        formPage.documentNumberAndDate should text(view.documentNumber)
        formPage.documentNumberAndDate should text(view.documentDate)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

open class UiScrollerCopyTestTemplate<T : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>,
        C : ScrollerCategory,
        Form : DocumentPage>(
    var entityName: String,
    val user: User,
    val scrollerPage: S,
    val scrollerCategory: C,
    val formPage: Form,
    override val preExecution: () -> T,
    val expHeaderText: String,
    val action: String = "Повторить",
    val actionPlace: UiActionPlace
) : AbstractTest<T, Unit>(
    name = "$entityName. Копирование документа из скроллера (${actionPlace.description}). [${user.userType}]",
    preExecution = preExecution
) {
    @Suppress("UNCHECKED_CAST")
    override fun execution(preconditionResult: T?) {
        val view = preconditionResult!!
        scrollerPage.openScrollerBy(user, view.customerId)
        scrollerPage.openTab(scrollerCategory)
        val row = scrollerPage.findDocumentRowByNumber(view.documentNumber)
        actionPlace.makeAction(scrollerPage, row, action)
        checkDocumentCopiedSuccessfully(formPage, view, expHeaderText)
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}
//endregion

//region Favorites
open class UiAddRemoveFavoriteTestTemplate<T : IDocumentView,
        S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    var user: User,
    var scrollerPage: S,
    var scrollerCategory: C,
    override var preExecution: () -> T
) : AbstractTest<T, Unit>(
    name = "$entityName. Добавление/ Удаление в Избранное. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: T?) {
        val view = preconditionResult!!
        scrollerPage.openScrollerBy(user, view.customerId)
        scrollerPage.openTab(scrollerCategory)

        val row = scrollerPage.scroller.getFirstNotFavoriteRow()
        row.favoriteStar.mark()
        row.favoriteStar.checkIsMarked()
        row.favoriteStar.unMark()
        row.favoriteStar.checkNotMarked()
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, PARAM_OBJECT_TYPE to preconditionResult!!)
    }
}

/**
 * В [preExecution] нужно проверить, что у определенного клиента есть документы добавленные в Избранное и не добавленные.
 * И вернуть ID этого клиента.
 */
open class UiFavoritesModeTestTemplate<S : DocumentScrollerPage<out DocumentScroller<out DocumentScrollerRow>, *, C, *>, C : ScrollerCategory>(
    var entityName: String,
    var user: User,
    var scrollerPage: S,
    var scrollerCategory: C,
    preExecution: (() -> UUID)
) : AbstractTest<UUID, Unit>(
    name = "$entityName. Избранное. [${user.userType}]",
    preExecution = preExecution
) {
    override fun execution(preconditionResult: UUID?) {
        val customerId = preconditionResult!!
        scrollerPage.openScrollerBy(user, customerId)
        scrollerPage.openTab(scrollerCategory)

        scrollerPage.favoriteStar.mark()

        var expFavoritesCount = 0
        step("Проверить, что Отобразились только документы, добавленные в Избранное") { ->
            scrollerPage.scroller.makeActionWithRows(condition = anyRow,
                action = {
                    expFavoritesCount++
                    it.favoriteStar.checkIsMarked()
                })
        }
        step("Проверить, что счетчик категорий отображает верное ко-во избранных документов") { ->
            val actCount = scrollerPage.openTab(scrollerCategory).getCount()
            assertThat(actCount, Matchers.equalTo(expFavoritesCount.toString()))
        }

        scrollerPage.favoriteStar.unMark()

        var expAllDocCount = 0
        step("Проверить, что Отобразились все документы") { ->
            scrollerPage.scroller.makeActionWithRows(
                condition = anyRow,
                action = { expAllDocCount++ },
                limitRows = expFavoritesCount + 1
            )
            assertThat("Кол-во всех документов не превышает кол-ва в избранном", expAllDocCount, Matchers.greaterThan(expFavoritesCount))
        }
        step("Проверить, что счетчик категорий отображает верное ко-во всех документов") { ->
            val actCount = scrollerPage.openTab(scrollerCategory).getCount()
            assertThat(actCount, Matchers.greaterThanOrEqualTo(expFavoritesCount.toString()))
        }
    }

    override fun params(): Map<String, Any> {
        return mapOf(PARAM_USER to user, "ID Клиента банка" to preconditionResult!!)
    }
}
//endregion
