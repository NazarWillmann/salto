package ooo.jtc.api.platform

import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic

const val RELEASE_1 = "JTCSALTO-2755"        //Проект Salto: Release 1
const val RELEASE_1_COMMON = "JTCSALTO-2578" //Проект Salto: Release 1 > Общие механизмы

const val FS = "JTCSALTO-2606"               //Проект Salto: Release 1 > Общие механизмы  > Файловое хранилище

const val DOCUMENT_SIGNING = "JTCSALTO-2607" //Проект Salto: Release 1 > Общие механизмы > Подпись документов
const val DOCUMENT_SIGN_MODEL_FRAGMENT =
    "JTCSALTO-2609" //Проект Salto: Release 1 > Общие механизмы > Подпись документов > Реализация. Фрагмент доменной модели "Подпись/Модель подписания"


@TaskIds([Tm4jEpic.EPIC_PLATFORM, RELEASE_1, RELEASE_1_COMMON])
annotation class PlatformCommonTaskIds

//region ATTACHMENT
@PlatformCommonTaskIds
@TaskIds([FS])
annotation class AttachmentTaskIdsCommon
//endregion

// region SIGNING
@PlatformCommonTaskIds
@TaskIds([DOCUMENT_SIGNING, DOCUMENT_SIGN_MODEL_FRAGMENT, "JTCSALTO-2928"])
annotation class ProfileTaskIdsCommon
//endregion