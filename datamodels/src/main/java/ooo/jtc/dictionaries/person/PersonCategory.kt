package ooo.jtc.dictionaries.person

/**
 * Категория, определяющая для работы в каком приложении заведена персона.
 */
enum class PersonCategory(val value: String) {
    BANK_USER("BankUser"),              // персона заведена для работы в Банковском приложении
    CUSTOMER_USER("CustomerUser"),      // персона заведена для работы в Клиентском приложении для ЮЛ
    INDIVIDUAL_USER("IndividualUser"),  // персона заведена для работы в Клиентском приложении для ФЛ
    ;
}