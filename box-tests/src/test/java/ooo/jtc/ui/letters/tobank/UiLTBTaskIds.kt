package ooo.jtc.ui.letters.tobank

import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.core.tm4j.Tm4jStoryAT.AT_STORY_LETTERS_EXPORT

const val AT_STORY_LTB_UI_FORM = "JTCSALTO-1861"        //Проект Salto: Release 1 > Переписка с банком > Письмо в банк > Экранные формы
const val AT_STORY_LTB_UI_FORM_CLIENT = "JTCSALTO-1862" //Проект Salto: Release 1 > Переписка с банком > Письмо в банк > Экранные формы > На клиенте

const val AT_STORY_LTB_UI_EXPORT_CSV = "JTCSALTO-1966" //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > CSV
const val AT_STORY_LTB_UI_EXPORT_XLS = "JTCSALTO-1961" //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XLS
const val AT_STORY_LTB_UI_EXPORT_XML = "JTCSALTO-1956" //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XML

const val TID_LTB_UI_EXPORT_CSV = "JTCSALTO-1969"      //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > CSV > Тестирование
const val TID_LTB_UI_EXPORT_XLS = "JTCSALTO-1964"      //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XLS > Тестирование
const val TID_LTB_UI_EXPORT_XML = "JTCSALTO-1959"      //Проект Salto: Release 1 > Переписка с банком > Импорт/Экспорт > Экспорт > XML > Тестирование

@TaskIds([Tm4jEpic.EPIC_R_RKO_LETTERS, Tm4jStoryAT.AT_STORY_LTB, AT_STORY_LTB_UI_FORM, AT_STORY_LTB_UI_FORM_CLIENT])
annotation class LTBTaskIdsUiCommon

@TaskIds(["JTCSALTO-1404"])
annotation class MT //Написание тест-кейсов

@MT
@LTBTaskIdsUiCommon
@TaskIds(["JTCSALTO-2637"])
annotation class LTBTaskIdsUiForm //AT. Письма в банк. Функции (UC). Привилегия "Клиент.Запись" [FE]

@MT
@LTBTaskIdsUiCommon
@TaskIds(["JTCSALTO-2931"])
annotation class LTBTaskIdsUiFormTabs //AT. Письма в банк. Функции (UC). Форма документа. Закладки. (Клиент) [FE]

@MT
@LTBTaskIdsUiCommon
@TaskIds(["JTCSALTO-2636"])
annotation class LTBTaskIdsUiFavorites //AT. Письма в банк. Функции (UC). Привилегия "Избранное" [FE]

@MT
@LTBTaskIdsUiCommon
@TaskIds(["JTCSALTO-2639", "JTCSALTO-2952"])
annotation class LTBTaskIdsUiScroller //AT. Письма в банк. Функции (UC). Привилегия "Клиент.Чтение" [FE]

@TaskIds(["JTCSALTO-3022"])
annotation class LTBTaskIdsUiRecall //AT. Письма в банк. Функции (UC). Отзыв документа (Банк) [FE]

@TaskIds(["JTCSALTO-3023"])
annotation class LTBTaskIdsUiProcess //AT. Письма в банк. Функции (UC). Обработка документа (Банк) [FE]

@TaskIds([Tm4jEpic.EPIC_R_RKO_LETTERS, Tm4jStoryAT.AT_STORY_LETTERS, Tm4jStoryAT.AT_STORY_LETTERS_IMPORT_EXPORT, AT_STORY_LETTERS_EXPORT])
annotation class LTBTaskIdsUiExport

@LTBTaskIdsUiExport
@TaskIds([AT_STORY_LTB_UI_EXPORT_CSV, TID_LTB_UI_EXPORT_CSV])
annotation class LTBTaskIdsUiExportCSV

@LTBTaskIdsUiExport
@TaskIds([AT_STORY_LTB_UI_EXPORT_XLS, TID_LTB_UI_EXPORT_XLS])
annotation class LTBTaskIdsUiExportXLS

@LTBTaskIdsUiExport
@TaskIds([AT_STORY_LTB_UI_EXPORT_XML, TID_LTB_UI_EXPORT_XML])
annotation class LTBTaskIdsUiExportXML

@LTBTaskIdsUiCommon
@TaskIds(
    [
        "JTCSALTO-1895", //..>..> Визард снятия подписи (один документ, несколько документов) > ANALITICS. Разработка требований
        "JTCSALTO-1897", //..> Ручное тестирование
        "JTCSALTO-2653", //AT. Письма в банк. Функции (UC). Снятие подписи [FE]
    ]
)
annotation class LTBTaskIdsUiUnSign