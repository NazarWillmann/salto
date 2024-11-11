package ooo.jtc.ui.pages.dictionaries.statementoperationtype

import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Тип документа выписки'")
open class StatementOperationTypeFormPage : DictionaryCreatePage<StatementOperationTypeView>("rupayment/statementOperationType/create") {

    val code get() = input["code"].apply { title = "Цифр. обозначение" }

    val description get() = textArea["description"].apply { title = "Наименование документа" }

    override fun fill(view: StatementOperationTypeView) {
        code.value = view.code
        description.value = view.description
    }

    override fun checkEditFromFilledCorrect(view: StatementOperationTypeView) {
        TODO("Not yet implemented")
    }
}

