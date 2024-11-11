package ooo.jtc.rupayment.model

/**
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337200
 */
enum class UserPaymentType(val description: String) {
    BUDGET("перевод в пользу бюджетной организации"),
    BUSINESS("перевод в пользу организации или ИП"),
    CUSTOM("выплата таможенного платежа"),
    OTHER("перевод, заполненный с использованием формы 383-П"),
    OWNACCOUNTS("перевод между своими счетами"),
    PERSON("перевод в пользу физического лица"),
    TAX("выплата налогов и сборов"),
    ;
}