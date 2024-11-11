package ooo.jtc.generic

//@formatter:off

object EntityNames {
    val DOCUMENT_NAMES = DocumentNames
    val DICTIONARY_NAMES = DictionaryNames
    val UAA_NAMES = UaaNames
    val CRYPTO_NAMES = CryptoNames
}

object DocumentNames {
    const val RU_PAYMENT = "Рублевое ПП"             // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12917091
    const val CUR_TRANSFER = "Валютный перевод"      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21730725
    const val LETTER_TO_BANK = "Письмо в Банк"       // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170974
    const val LETTER_FROM_BANK = "Письмо из Банка"   // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170976
    const val PUBLICATION = "Публикация"             // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733411
    const val SALARY_REGISTER = "Зарплатный реестр"  // https://confluence.jtc.ooo/pages/viewpage.action?pageId=7573659
}

object DictionaryNames {

    //общие элементы справочников
    const val EXT_ID = "id внешней системы"             // NONE

    const val ADDRESS = "Адрес"                         // https://confluence.jtc.ooo/pages/viewpage.action?pageId=29918624
    const val ADDRESS_RU = "Адрес (РФ)"                 // + https://confluence.jtc.ooo/pages/viewpage.action?pageId=29917650 (branch; table 2)
    const val ADDRESS_INT = "Адрес (международный)"     // + https://confluence.jtc.ooo/pages/viewpage.action?pageId=12913704 (customer; table 3)
    const val ADDRESSES_INFO = "Блок адресов"

    const val BLOCKING_INFO = "Информация о блокировке" // NONE / present as fields in different domain models (customer, branch, representatives)

    const val PHONE_INFO = "Телефоны горячей линии"     // NONE / mentioned in different entities (bank, branch)

    //справочники
    const val ACCOUNT = "Счет"                                        // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336193
    const val ACCOUNT_TYPE = "Тип счета"                              // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336193
    const val BANK_BIC = "БИК РФ"                                     // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725407
    const val BANK_INFO = "Банк"                                      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=10225146
    const val BANK_REPRESENTATIVE = "Представитель банка"             // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31266131
    const val BANK_RU = "Банк России"                                 // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337278
    const val BRANCH = "Подразделение банка"                          // https://confluence.jtc.ooo/pages/viewpage.action?pageId=29917650
    const val BRANCH_CUSTOMER = "Связь подразделений и клиентов ЮЛ"   // NONE
    const val BRANCH_INDIVIDUAL = "Связь подразделений и клиентов ФЛ" // NONE
    const val BRANCH_REPRESENTATIVE = "Представитель подразделения"   // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31266175
    const val BUDGET_PAYER_STATUS = "Показатель статуса плательщика"  // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12917181
    const val BUDGET_REASON_CODE = "Основание платежа"                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=108789795
    const val CUSTOMER_REPRESENTATIVE = "Представитель Клиента ЮЛ"    // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336373
    const val CODE_VO = "Код вида ВО"                                 // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12919227
    const val CONTRACTOR = "Контрагент"                               // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170239
    const val CONTRACTOR_CONTACT = "Контактное лицо контрагента"      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170241
    const val CONTRACTOR_PAYMENT = "Платежные реквизиты контрагента"  // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170243
    const val CONTROL_CODE = "Код контроля"                           // 1st section 2.3 https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337278
    const val COUNTRY = "Страна"                                      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336195
    const val CURRENCY = "Валюта"                                     // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336184
    const val CUSTOMER = "Клиент банка"                               // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336171
    const val CUSTOMER_KPP = "КПП клиента"                            // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336171 (КПП)
    const val CUSTOMER_TYPE = "Тип клиента ЮЛ"                        // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262718
    const val GROUND = "Назначение платежа"                           // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337263
    const val INCOME_TYPE = "Вид дохода"                              // https://confluence.jtc.ooo/pages/viewpage.action?pageId=88342600
    const val INDIVIDUAL = "Клиент банка (ФЛ)"                        // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262529
    const val INDIVIDUAL_REPRESENTATIVE = "Представитель Клиента ФЛ"  // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31266235
    //ДУЛ - документ, удостоверяющий личность
    const val IDENTITY_DOC_TYPE = "Вид ДУЛ"                           // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31264263
    const val KBK = "Код бюджетной классификации"                     // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12919359
    const val LOCATION_TYPE = "Тип населенного пункта"                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336192
    const val NDS_CALCULATION = "Способ расчета НДС"                  // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337293
    const val NDS_PERCENT = "Ставка НДС"                              // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337287
    const val OKFS = "ОКФС (Форма собственности)"                     // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12912660
    const val OKOPF = "ОКОПФ (Организационно-правовая форма)"         // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12912658
    const val PAYMENT_DETAILS_BIC = "Реквизиты для расчетов в рублях"
    const val PAYMENT_DETAILS_SWIFT = "Реквизиты для расчетов в иностранной валюте"
    const val PAYMENT_PRIORITY = "Очередность платежа"                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12916902
    const val PAYMENT_TYPE = "Вид платежа"                            // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170071
    const val PERSON = "Персона"                                      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262415
    const val RESIDENCY_PERMIT_DOCUMENT_TYPE =
        "Вид документа, подтверждающего право пребывания в РФ"        // https://confluence.jtc.ooo/pages/viewpage.action?pageId=105644112
    const val RU_REGION = "Субъект РФ"                                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336190
    const val SALARY_EMPLOYEE = "Сотрудники"                          // https://confluence.jtc.ooo/pages/viewpage.action?pageId=7573659
    const val SALARY_PAYMENT_TYPE = "Тип выплаты"                     // https://confluence.jtc.ooo/pages/viewpage.action?pageId=86900764
    const val STATEMENT_OPERATION_TYPE = "Тип документа выписки"      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12915666
    const val SWIFT = "SWIFT"                                         // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21732566
    const val TIME_ZONE = "Часовой пояс"                              // https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336391
    const val TRANSFER_TERM = "Условие перевода"                      // https://confluence.jtc.ooo/pages/viewpage.action?pageId=104595521
    const val TREASURY_ACCOUNT_TAX = "Казначейский счет"              // https://confluence.jtc.ooo/pages/viewpage.action?pageId=99778613
    const val UER = "Участие в электронных расчетах"                  // 2nd section 2.3 https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337278

    // переписка с банком
    const val LETTER_TYPE_TO_BANK = "Тип письма в банк"               // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171109
    const val LETTER_TYPE_FROM_BANK = "Тип письма из банка"           // https://confluence.jtc.ooo/pages/viewpage.action?pageId=19171253

    // банковская рассылка
    const val MAIL_GROUP = "Группа рассылки Клиентов"                 // https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733425

    // личный кабинет / резервирование счетов
    const val ACTIVITY_TYPE = "Вид деятельности ГОЗ"                  // https://confluence.jtc.ooo/pages/viewpage.action?pageId=12912664
    const val GOZ_CONTRACT = "Государственный контракт"               // NONE

    const val AGREEMENT = "Соглашение"                                // https://confluence.jtc.ooo/pages/viewpage.action?pageId=144146458
}

object UaaNames {
    const val AUTHORIZATION = "Авторизация"
    const val APPLICATION = "Приложение"
    const val RESOURCE = "Ресурс"
    const val SCOPE = "Скоуп"
    const val CATALOG = "Каталог"
    const val MFA = "МФА"
    const val USER = "УааПользователь"
}

object CryptoNames {
    const val CERTIFICATE = "Сертификат"
    const val PROFILE = "Профиль"
    const val BANK_KEY = "Банковский ключ"
}

object RoleModelNames {
    const val ACCESS_OBJECT = "Объект доступа Системы"
    const val ACCESS_OBJECT_TYPE = "Тип объекта доступа"
    const val ROLE = "Роль"
    const val PRIVILEGE = "Привилегия"
    const val PRIVILEGE_GROUP = "Группа привилегий"
    const val PRODUCT = "Продукт/Сервис Системы"
}

object FsNames {
    const val FS_SYSTEM = "Вложения"
}