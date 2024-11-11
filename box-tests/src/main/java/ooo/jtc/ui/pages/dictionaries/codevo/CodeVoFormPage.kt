package ooo.jtc.ui.pages.dictionaries.codevo

import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.codevo.CodeVoView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Код вида валютной операции'")
open class CodeVoFormPage : DictionaryCreatePage<CodeVoView>("rupayment/codeVO/create") {

    val code get() = input["code"].apply { title = "Код вида ВО" }

    val description get() = textArea["description"].apply { title = "Описание" }

    override fun fill(view: CodeVoView) {
        code.value = view.code
        description.value = view.description
    }

    override fun checkEditFromFilledCorrect(view: CodeVoView) {
        TODO("Not yet implemented")
    }
}

