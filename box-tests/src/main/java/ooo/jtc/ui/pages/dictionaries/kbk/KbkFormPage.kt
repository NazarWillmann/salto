package ooo.jtc.ui.pages.dictionaries.kbk

import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textArea
import ooo.jtc.core.elements.ElementType
import ooo.jtc.dictionaries.kbk.KbkView
import ooo.jtc.ui.common.pages.DictionaryCreatePage

@ElementType("Форма создания 'Код бюджетной классификации (КБК)'")
open class KbkFormPage : DictionaryCreatePage<KbkView>("rupayment/kbk/create") {

    val code get() = input["code"].withTitle("КБК")

    val description get() = textArea["description"].apply { title = "Описание" }

    override fun fill(view: KbkView) {
        code.value = view.code
        description.value = view.description
    }

    override fun checkEditFromFilledCorrect(view: KbkView) {
        TODO("Not yet implemented")
    }
}

