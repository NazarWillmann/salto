package ooo.jtc.ui.common.pages

enum class DocumentPageTabs(val urlName: String?, val tabName: String) {
    BASIC_REQUISITES(urlName = null, tabName = "Основные реквизиты"),
    SIGNATURES(urlName = "SIGNATURES", tabName = "Подписи"),
    HISTORY(urlName = "HISTORY", tabName = "История изменений"),
    ;
}