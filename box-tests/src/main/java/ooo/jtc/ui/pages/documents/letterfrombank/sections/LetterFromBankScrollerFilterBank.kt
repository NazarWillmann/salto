package ooo.jtc.ui.pages.documents.letterfrombank.sections

import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.checkboxByText
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.inputDropdown
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.scroller.FilterForm
import ooo.jtc.generic.DocumentNames

@ElementType("Форма фильтра скроллера ${DocumentNames.LETTER_FROM_BANK} [Банк]")
class LetterFromBankScrollerFilterBank : FilterForm() {
    val documentNumber get() = input["documentNumber"].withTitle("Номер документа")
    val status get() = dropdown["status"].withTitle("Статус")

    val shortCustomerName get() = inputDropdown["shortCustomerName"].withTitle("Наименование Клиента")

    val branch get() = dropdown["branchId"].withTitle("Наименование подразделения Банка")
    val docType get() = dropdown["docType"].withTitle("Тип письма")
    val docTheme get() = input["docTheme"].withTitle("Тема письма")
    val docText get() = input["docText"].withTitle("Текст письма")
    val attachName get() = input["attachName"].withTitle("Имя файла-вложения")
    val isHasAttach get() = checkboxByText["есть файлы-вложения"].withTitle("есть файлы-вложения")

    val contactName get() = input["contactName"].withTitle("ФИО")
    val contactPhone get() = input["contactPhone"].withTitle("Телефон")
    val docDateFrom get() = input["docDateFrom"].withTitle("Дата документа от")
    val docDateTo get() = input["docDateTo"].withTitle("Дата документа до")
    val receiveDateFrom get() = input["receiveDateFrom"].withTitle("Прием документа от")
    val receiveDateTo get() = input["receiveDateTo"].withTitle("Прием документа до")
    val executionDateFrom get() = input["executionDateFrom"].withTitle("Дата/время исполнения документа от")
    val executionDateTo get() = input["executionDateTo"].withTitle("Дата/время исполнения документа до")

}