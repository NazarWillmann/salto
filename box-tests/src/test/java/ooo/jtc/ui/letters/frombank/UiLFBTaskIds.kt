package ooo.jtc.ui.letters.frombank

import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_LETTERS_EXPORT

/** [Tm4jStoryAT.AT_STORY_LFB]: Проект Salto: Release 1 > Переписка с банком > Письмо из банка */
const val JTCSALTO_1984 = "JTCSALTO-1984" //[AT_STORY_LFB] > Экранные формы
const val JTCSALTO_1985 = "JTCSALTO-1985" //    [JTCSALTO_1984] > На банке
const val JTCSALTO_1990 = "JTCSALTO-1990" //        [JTCSALTO_1985] > Форма на банке
const val JTCSALTO_1991 = "JTCSALTO-1991" //            [JTCSALTO_1990] > Закладка "Основные реквизиты" (создание/редактирование/просмотр)
const val JTCSALTO_1992 = "JTCSALTO-1992" //                [JTCSALTO_1991] > ANALITICS. Разработка требований
const val JTCSALTO_1994 = "JTCSALTO-1994" //                [JTCSALTO_1991] > Ручное тестирование
const val JTCSALTO_1999 = "JTCSALTO-1999" //            [JTCSALTO_1990] > Закладка "Подписи"
const val JTCSALTO_2001 = "JTCSALTO-2001" //                [JTCSALTO_1999] > FE. Реализация
const val JTCSALTO_2000 = "JTCSALTO-2000" //                [JTCSALTO_1999] > ANALITICS. Разработка требований
const val JTCSALTO_2002 = "JTCSALTO-2002" //                [JTCSALTO_1999] > Ручное тестирование
const val JTCSALTO_2007 = "JTCSALTO-2007" //    [JTCSALTO_1984] > На клиенте

const val MT_WRITING_TC = "JTCSALTO-1404"               //Написание тест-кейсов
const val LFB_UI_FORM_BANK_WRITING_TC = "JTCSALTO-1570" //Сторона Банка. Письма из Банка. ЭФ. Написание тест-кейсов

const val LFB_PRINT_FORMS = "JTCSALTO-2034"             //Проект Salto: Release 1 > Переписка с банком > Письмо из банка > Печатные формы

const val AT_STORY_LFB_UI_EXPORT_CSV = "JTCSALTO-1966"  //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > CSV
const val AT_STORY_LFB_UI_EXPORT_XLS = "JTCSALTO-1961"  //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XLS
const val AT_STORY_LFB_UI_EXPORT_XML = "JTCSALTO-1956"  //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XML

const val TID_LFB_UI_EXPORT_CSV = "JTCSALTO-1969"       //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > CSV > Тестирование
const val TID_LFB_UI_EXPORT_XLS = "JTCSALTO-1964"       //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XLS > Тестирование
const val TID_LFB_UI_EXPORT_XML = "JTCSALTO-1959"       //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XML > Тестирование

const val JTCSALTO_3021 = "JTCSALTO-3021" //AT. Письма из банка. Функции (UC). Привилегия "История изменений" [FE]
const val JTCSALTO_3048 = "JTCSALTO-3048" //AT. Письмо из банка. Экранная форма. Закладка основные реквизиты [БАНК] [FE]
const val JTCSALTO_2692 = "JTCSALTO-2692" //AT. Письма из банка. Функции (UC). Привилегия "Банк.Запись" [FE]
const val JTCSALTO_3058 = "JTCSALTO-3058" //AT. Письмо из банка. Сортировка [FE]
const val JTCSALTO_3055 = "JTCSALTO-3055" //AT. Письмо из банка. Печатные формы [FE]
const val JTCSALTO_3056 = "JTCSALTO-3056" //AT. Письмо из банка. Действия с документами в скроллере. [Клиент] [FE]
const val JTCSALTO_3061 = "JTCSALTO-3061" //AT. Письмо из банка. ЭФ создания документа. [Банк] [FE]
const val JTCSALTO_3059 = "JTCSALTO-3059" //AT. Письмо из банка. Экранная форма. Закладка подписи [БАНК] [FE]
const val JTCSALTO_3066 = "JTCSALTO-3066" //AT. Письмо из банка. Категории. [Банк] [FE]

@TaskIds([Tm4jEpic.EPIC_R_RKO_LETTERS, Tm4jStoryAT.AT_STORY_LFB, JTCSALTO_1984])
annotation class LFBTaskIdsUiCommon

@TaskIds([JTCSALTO_1985, LFB_UI_FORM_BANK_WRITING_TC])
annotation class LFBUiFormsBank

@TaskIds([JTCSALTO_2007])
annotation class LFBUiFormsClient

@TaskIds([MT_WRITING_TC])
annotation class MT

@MT
@LFBTaskIdsUiCommon
@TaskIds([JTCSALTO_3021])
annotation class LFBTaskIdsUiChangeHistory

@TaskIds([Tm4jEpic.EPIC_R_RKO_LETTERS, Tm4jStoryAT.AT_STORY_LETTERS, Tm4jStoryAT.AT_STORY_LETTERS_IMPORT_EXPORT, AT_STORY_LETTERS_EXPORT])
annotation class LFBTaskIdsUiExport

@LFBTaskIdsUiExport
@TaskIds([AT_STORY_LFB_UI_EXPORT_CSV, TID_LFB_UI_EXPORT_CSV])
annotation class LFBTaskIdsUiExportCSV

@LFBTaskIdsUiExport
@TaskIds([AT_STORY_LFB_UI_EXPORT_XLS, TID_LFB_UI_EXPORT_XLS])
annotation class LFBTaskIdsUiExportXLS

@LFBTaskIdsUiExport
@TaskIds([AT_STORY_LFB_UI_EXPORT_XML, TID_LFB_UI_EXPORT_XML])
annotation class LFBTaskIdsUiExportXML

@MT
@LFBTaskIdsUiCommon
@LFBUiFormsBank
@TaskIds([JTCSALTO_3048])
annotation class LFBTaskIdsUiFormTabs

@MT
@LFBTaskIdsUiCommon
@TaskIds([JTCSALTO_3066])
annotation class LFBTaskIdsUiScroller //AT. Письмо из банка. Категории. [Банк] [FE]

@MT
@LFBTaskIdsUiCommon
@LFBUiFormsBank
@TaskIds([JTCSALTO_2692])
annotation class LFBTaskIdsUiForm

@LFBTaskIdsUiCommon
@TaskIds([JTCSALTO_1991, JTCSALTO_1992, JTCSALTO_1994, JTCSALTO_3061])
annotation class LFBTaskIdsUiFormBasicRequisites

@LFBTaskIdsUiCommon
@LFBUiFormsBank
@TaskIds([JTCSALTO_1999, JTCSALTO_2001, JTCSALTO_2000, JTCSALTO_2002, JTCSALTO_3059])
annotation class LFBTaskIdsUiFormBankSignatures

@LFBTaskIdsUiCommon
@TaskIds([JTCSALTO_3058])
annotation class LFBTaskIdsUiSorting

@LFBTaskIdsUiCommon
@TaskIds([LFB_PRINT_FORMS, JTCSALTO_3055])
annotation class LFBTaskIdsUiPrint

@LFBTaskIdsUiCommon
@TaskIds([JTCSALTO_3056])
annotation class LFBTaskIdsUiScrollerActions