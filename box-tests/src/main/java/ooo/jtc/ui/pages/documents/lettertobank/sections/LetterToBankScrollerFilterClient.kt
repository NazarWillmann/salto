package ooo.jtc.ui.pages.documents.lettertobank.sections

import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.checkboxByText
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.generic.DocumentNames

@ElementType("Форма фильтра скроллера ${DocumentNames.LETTER_TO_BANK} [Клиент]")
class LetterToBankScrollerFilterClient : FilterForm() {

    val documentNumber get() = input["documentNumber"].withTitle("Номер документа")
    val status get() = dropdown["status"].withTitle("Назначение платежа")

    val createDateFrom get() = input["from"].withTitle("Создание документа от")
    val createDateTo get() = input["to"].withTitle("Создание документа до")
    val branchId get() = dropdown["branchId"].withTitle("Получатель")
    val docTheme get() = input["docTheme"].withTitle("Тема")
    val docText get() = input["docText"].withTitle("Текст")
    val fileName get() = input["attachName"].withTitle("Имя файла-вложения")
    val isHasAttach get() = checkboxByText["есть файлы-вложения"].withTitle("есть файлы-вложения")

    val contactName get() = input["contactName"].withTitle("ФИО")
    val contactPhone get() = input["contactPhone"].withTitle("Телефон")
}