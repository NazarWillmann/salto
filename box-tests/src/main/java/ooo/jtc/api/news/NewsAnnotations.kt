package ooo.jtc.api.news

import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_CORRESPONDENCE

//@formatter:off
private const val JTCSALTO_1846 = "JTCSALTO-1846"   //  Проект Salto: Release 1 > Переписка с банком
private const val JTCSALTO_2049 = "JTCSALTO-2049"   //      [JTCSALTO-1846] > Новости банка
private const val JTCSALTO_2057 = "JTCSALTO-2057"   //          [JTCSALTO-2049] > Жизненный цикл
private const val JTCSALTO_2058 = "JTCSALTO-2058"   //              [JTCSALTO-2057] > ANALITICS. Разработка требований
private const val JTCSALTO_2059 = "JTCSALTO-2059"   //              [JTCSALTO-2057] > BE. Реализация
private const val JTCSALTO_2060 = "JTCSALTO-2060"   //              [JTCSALTO-2057] > Тестирование (Написание автотестов, прочие работы тестирования)
private const val JTCSALTO_3091 = "JTCSALTO-3091"   //                  [JTCSALTO-2060] > AT. Публикация. Жизненный цикл
private const val JTCSALTO_2061 = "JTCSALTO-2061"   //          [JTCSALTO-2049] > Функции (UC)
private const val JTCSALTO_2062 = "JTCSALTO-2062"   //              [JTCSALTO-2061] > ANALITICS. Разработка требований
private const val JTCSALTO_2063 = "JTCSALTO-2063"   //              [JTCSALTO-2061] > BE. Реализация
private const val JTCSALTO_2064 = "JTCSALTO-2064"   //              [JTCSALTO-2061] > Тестирование (Написание автотестов, прочие работы тестирования)
private const val JTCSALTO_3046 = "JTCSALTO-3046"   //                  [JTCSALTO-2064] > AT. Публикация. Функции (UC). Привилегии Банка. Создание, Редактирование, Удаление, Просмотр. [BE]
private const val JTCSALTO_3090 = "JTCSALTO-3090"   //                  [JTCSALTO-2064] > AT. Публикация. Функции (UC). Обновление АТ по изменениям ТЗ
private const val JTCSALTO_3071 = "JTCSALTO-3071"   // (mailGroup)  [JTCSALTO-2061] > Тестирование (Написание автотестов, прочие работы тестирования) 2
private const val JTCSALTO_3070 = "JTCSALTO-3070"   // (mailGroup)      [JTCSALTO-3071] > AT. Группа рассылки Клиентов. Функции (UC). Привилегии Банка. Создание, Редактирование, Удаление, Просмотр. [BE]
private const val JTCSALTO_2100 = "JTCSALTO-2100"   //          [JTCSALTO-2049] > Контроли
private const val JTCSALTO_2101 = "JTCSALTO-2101"   //              [JTCSALTO-2100] > Серверные
private const val JTCSALTO_2102 = "JTCSALTO-2102"   //                  [JTCSALTO-2101] > ANALITICS. Разработка требований
private const val JTCSALTO_2103 = "JTCSALTO-2103"   //                  [JTCSALTO-2101] > BE. Реализация
private const val JTCSALTO_2104 = "JTCSALTO-2104"   //                  [JTCSALTO-2101] > Тестирование (Написание автотестов, прочие работы тестирования)
private const val JTCSALTO_3075 = "JTCSALTO-3075"   // (mailGroup)          [JTCSALTO-2104] > AT. Группа рассылки Клиентов. Контроли [BE]
private const val JTCSALTO_3076 = "JTCSALTO-3076"   //                      [JTCSALTO-2104] > AT. Публикации. Контроли [BE]


@TaskIds([EPIC_CORRESPONDENCE, JTCSALTO_1846, JTCSALTO_2049])
annotation class CommonPublicationTaskIds

@CommonPublicationTaskIds
@TaskIds([JTCSALTO_2057, JTCSALTO_2058, JTCSALTO_2059, JTCSALTO_2060, JTCSALTO_3091])
annotation class PublicationTaskIdsLifecycle

@CommonPublicationTaskIds
@TaskIds([JTCSALTO_2061, JTCSALTO_2062, JTCSALTO_2063])
annotation class PublicationTaskIdsDocApiCommon

@PublicationTaskIdsDocApiCommon
@TaskIds([JTCSALTO_2064, JTCSALTO_3046])
annotation class PublicationTaskIdsDocApi

@PublicationTaskIdsDocApiCommon
@TaskIds([JTCSALTO_2064, JTCSALTO_3090])
annotation class PublicationTaskIdsAvailability

@CommonPublicationTaskIds
@TaskIds([JTCSALTO_2100, JTCSALTO_2101, JTCSALTO_2102, JTCSALTO_2103, JTCSALTO_2104])
annotation class PublicationTaskIdsControlsCommon

@PublicationTaskIdsControlsCommon
@TaskIds([JTCSALTO_3075])
annotation class PublicationTaskIdsControls


@PublicationTaskIdsDocApiCommon
@TaskIds([JTCSALTO_3071, JTCSALTO_3070])
annotation class MailGroupTaskIdsDocApi

@PublicationTaskIdsControlsCommon
@TaskIds([JTCSALTO_3076])
annotation class MailGroupTaskIdsControls
//@formatter:on