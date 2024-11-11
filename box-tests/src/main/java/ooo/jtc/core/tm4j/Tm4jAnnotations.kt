@file:Suppress("DEPRECATED_JAVA_ANNOTATION")

package ooo.jtc.core.tm4j

import java.lang.annotation.Repeatable

@Repeatable(TaskIds::class)
annotation class TaskIds(val value: Array<String>)

annotation class Folder(val value: String)

annotation class Component(val value: Tm4jComponent)

//@formatter:off
@Component(Tm4jComponent.CUR_PAYMENT)       annotation class ComponentCurPayment
@Component(Tm4jComponent.DICTIONARY)        annotation class ComponentDictionary
@Component(Tm4jComponent.FREE_FORMAT_DOC)   annotation class ComponentFreeFormatDoc
@Component(Tm4jComponent.NEWS)              annotation class ComponentNews
@Component(Tm4jComponent.PLATFORM)          annotation class ComponentPlatform
@Component(Tm4jComponent.RU_PAYMENT)        annotation class ComponentRuPayment
@Component(Tm4jComponent.STATEMENT)         annotation class ComponentStatement
@Component(Tm4jComponent.UAA)               annotation class ComponentUaa
//@formatter:on
/**
 * Component of application.
 * Used for the formation of folder path in TMS.
 */
enum class Tm4jComponent(val ruName: String) {
    CUR_PAYMENT("ВРКО ВП"),
    DICTIONARY("Справочники"),
    FREE_FORMAT_DOC("ДСФ"),
    NEWS("Новости"),
    PLATFORM("Общие сервисы платформы"),
    RU_PAYMENT("РРКО ПП"),
    STATEMENT("Выписка"),
    UAA("УАА"),
    NONE("None")
    ;
}

annotation class Priority(val value: Tm4jPriority)

//@formatter:off
@Priority(Tm4jPriority.High)    annotation class HighPriority
@Priority(Tm4jPriority.Normal)  annotation class NormalPriority
@Priority(Tm4jPriority.Low)     annotation class LowPriority
//@formatter:on

enum class Tm4jPriority {
    High,
    Normal,
    Low;
}

object FolderPrefix {
    const val UAA = "UAA"
    const val DICTIONARY = "Справочник"
    const val CRYPTO = "Крипто"
    const val LETTER_TO_BANK = "Письмо в Банк"
    const val LETTER_FROM_BANK = "Письмо из Банка"
    const val ATTACHMENT = "Вложения"
}

object SubFolder {
    const val CONTROLS = "Контроли"
    const val CRUD = "Основные операции"
    const val DEFAULTS = "Наполнение"
    const val EXPORT = "Экспорт"
    const val FILTRATION = "Фильтрация"
    const val HISTORY = "История изменений"
    const val LIFECYCLE = "Жизненный цикл"
    const val OTHER = "Другие операции"
    const val PRINT = "Печать"
    const val SIGNATURE = "Просмотр подписи"
    const val SORTING = "Сортировка"
}

object Tm4jEpic {
    const val EPIC_R_RKO_DICTIONARY = "JTCSALTO-397"    //"Рублевое РКО. Справочники",
    const val EPIC_R_RKO_STATEMENT = "JTCSALTO-27"      //"Рублевое РКО. Выписка"
    const val EPIC_R_RKO_PAYMENT = "JTCSALTO-26"        //"Рублевое РКО. Платежное поручение"
    const val EPIC_R_RKO_LETTERS = "JTCSALTO-30"        //"Рублевое РКО. Переписка с банком"
    const val EPIC_R_RKO_CONTRACTOR = "JTCSALTO-29"     //"Рублевое РКО. Контрагенты"
    const val EPIC_R_RKO_IMPORT = "JTCSALTO-28"         //"Рублевое РКО. Импорт платежных поручений"
    const val EPIC_R_RKO_NOTIFICATIONS = "JTCSALTO-32"  //"Рублевое РКО. Уведомления"
    const val EPIC_R_RKO_MAIN_PAGE = "JTCSALTO-31"      //"Рублевое РКО. Главная страница"
    const val EPIC_UAA = "JTCSALTO-475"                 //"UAA"
    const val EPIC_CORRESPONDENCE = "JTCSALTO-1644"     //"Переписка с банком. Новости банка"
    const val EPIC_PLATFORM = "JTCSALTO-1648"           //"Платформа. Общие механизмы"
    const val EPIC_C_RKO_TRANSFER = "JTCSALTO-2897"     //"Валютное РКО. Валютный перевод"
    const val EPIC_SALARY = "JSSP-1"                    //"Зарплатный проект"
}

object Tm4jStoryAT {
    const val AT_STORY_COMMON_DICTIONARIES_CHANGES = "JTCSALTO-3125"    //Изменения в общесистемных справочниках
    const val AT_STORY_R_RKO_DICTIONARY = "JTCSALTO-850"        //Рублёвое РКО / АТ. Справочники. BE
    const val AT_STORY_UAA = "JTCSALTO-766"                     //UAA. Автоматическое тестирование
    const val AT_STORY_LETTERS = "JTCSALTO-1846"                //Проект Salto: Release 1 > Переписка с банком
    const val AT_STORY_LETTERS_IMPORT_EXPORT = "JTCSALTO-1954"  //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт
    const val AT_STORY_LETTERS_EXPORT = "JTCSALTO-1955"         //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт
    const val AT_STORY_LTB = "JTCSALTO-1847"                    //Проект Salto: Release 1 > Переписка с банком > Письмо в банк
    const val AT_STORY_LFB = "JTCSALTO-1971"                    //Проект Salto: Release 1 > Переписка с банком > Письмо из банка

    const val AT_STORY_ROLEMODEL = "JTCSALTO-3484"              //Проект развития JTC СДМ УБРиР > Механизмы > Права доступа (роли/привилегии и раздача прав)
}