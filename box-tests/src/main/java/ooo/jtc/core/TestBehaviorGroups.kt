package ooo.jtc.core

/** Values for BDD allure annotations  Epic -> Feature -> Story*/

object TestEpic {
    const val API = "API"
    const val UI = "UI"
}

object TestFeature {
    const val ATTACHMENTS = "Вложения"
    const val CORRESPONDENCE = "Рассылка"
    const val CRYPTO = "Крипто"
    const val CUR_TRANSFER = "Валютный перевод"
    const val DICTIONARY = "Справочники"
    const val LETTER_TO_BANK = "Письмо в Банк"
    const val LETTER_FROM_BANK = "Письмо из Банка"
    const val RUPAYMENT = "Рублевое ПП"
    const val UAA = "УАА"
    const val SALARY_REGISTER = "Зарплатный реестр"
    const val ROLE_MODEL = "Ролевая модель"
}

object TestStoryPlatform {
    const val PLATFORM = "Общие механизмы"
}

object TestStoryRuPayment {
    const val RUPAYMENT_CRUD = "Рублевое ПП. Основные операции"
    const val RUPAYMENT_FILTRATION = "Рублевое ПП. Фильтрация"
    const val RUPAYMENT_SORTING = "Рублевое ПП. Сортировка"
    const val RUPAYMENT_CATEGORIES = "Рублевое ПП. Категории"
    const val RUPAYMENT_OTHER = "Рублевое ПП. Другие операции"
}

object TestStoryLetterToBank {
    const val LETTER_TO_BANK_ACTIONS = "Письмо в Банк. Действия с документом"
    const val LETTER_TO_BANK_CATEGORIES = "Письмо в Банк. Категории"
    const val LETTER_TO_BANK_CRUD = "Письмо в Банк. Основные операции"
    const val LETTER_TO_BANK_EXPORT = "Письмо в Банк. Экспорт"
    const val LETTER_TO_BANK_FAVORITES = "Письмо в Банк. Избранное"
    const val LETTER_TO_BANK_FILTRATION = "Письмо в Банк. Фильтрация"
    const val LETTER_TO_BANK_HISTORY = "Письмо в Банк. История"
    const val LETTER_TO_BANK_LIFECYCLE = "Письмо в Банк. Жизненный цикл"
    const val LETTER_TO_BANK_OTHER = "Письмо в Банк. Другие операции"
    const val LETTER_TO_BANK_PRINT = "Письмо в Банк. Печать"
    const val LETTER_TO_BANK_RECALL = "Письмо в Банк. Отзыв"
    const val LETTER_TO_BANK_SORTING = "Письмо в Банк. Сортировка"
    const val LETTER_TO_BANK_TABS = "Письмо в Банк. Форма. Закладки"
}

object TestStoryLetterFromBank {
    const val LETTER_FROM_BANK_ACTIONS = "Письмо из Банка. Действия с документом"
    const val LETTER_FROM_BANK_CATEGORIES = "Письмо из Банка. Категории"
    const val LETTER_FROM_BANK_CONTROLS = "Письмо из Банка. Контроли"
    const val LETTER_FROM_BANK_CRUD = "Письмо из Банка. Основные операции"
    const val LETTER_FROM_BANK_EXPORT = "Письмо из Банка. Экспорт"
    const val LETTER_FROM_BANK_FAVORITES = "Письмо из Банка. Избранное"
    const val LETTER_FROM_BANK_FILTRATION = "Письмо из Банка. Фильтрация"
    const val LETTER_FROM_BANK_HISTORY = "Письмо из Банка. История"
    const val LETTER_FROM_BANK_LIFECYCLE = "Письмо из Банка. Жизненный цикл"
    const val LETTER_FROM_BANK_OTHER = "Письмо из Банка. Другие операции"
    const val LETTER_FROM_BANK_PRINT = "Письмо из Банка. Печать"
    const val LETTER_FROM_BANK_SORTING = "Письмо из Банка. Сортировка"
}

object TestStoryCorrespondence {
    const val CORRESPONDENCE_PUBLICATION_CATEGORIES = "Банковская рассылка. Публикация. Категории"
    const val CORRESPONDENCE_PUBLICATION_CRUD = "Банковская рассылка. Публикация. Основные операции"
    const val CORRESPONDENCE_PUBLICATION_CONTROLS = "Банковская рассылка. Публикация. Контроли"
    const val CORRESPONDENCE_PUBLICATION_LIFECYCLE = "Банковская рассылка. Публикация. Жизненный цикл"
    const val CORRESPONDENCE_PUBLICATION_OTHER = "Банковская рассылка. Публикация. Другие операции"

    const val CORRESPONDENCE_DICTIONARY_MAILGROUP = "Банковская рассылка. Спр. 'Группа рассылки Клиентов'"
    const val CORRESPONDENCE_DICTIONARY_MAILGROUP_CONTROLS = "Банковская рассылка. Спр. 'Группа рассылки Клиентов'. Контроли"
}

object TestStoryCurTransfer {
    const val CUR_TRANSFER_CATEGORIES = "Валютный перевод. Категории"
    const val CUR_TRANSFER_CRUD = "Валютный перевод. Основные операции"
    const val CUR_TRANSFER_CONTROLS = "Валютный перевод. Контроли"
    const val CUR_TRANSFER_LIFECYCLE = "Валютный перевод. Жизненный цикл"
    const val CUR_TRANSFER_OTHER = "Валютный перевод. Другие операции"
}

object TestStorySalaryRegister{
    const val SALARY_REGISTER_CRUD = "Зарплатный реестр. Основные Операции"
}