package ooo.jtc.core

object Issues {
    const val JTCSALTO_2963 = "JTCSALTO-2963"             // A. Уточнить требования для сортировки поля Статус
    const val JTCSALTO_2990 = "JTCSALTO-2990"             // AN. LTB/LFB. Change history. Deleting Letter (questionable behavior)
    const val JTCSALTO_3044 = "JTCSALTO-3044"             // FE. (Письмо в Банк). (Отзыв докуменитов). Push-уведомления не по ТЗ
    const val JTCSALTO_3062 = "JTCSALTO-3062"             // FE Письмо из Банка. Поле "Отправитель" не должно предзаполняться, если найдено больше одной организации
    const val JTCSALTO_3085 = "JTCSALTO-3085"             // BE Банковская рассылка. Публикация. Контроли. Добавить контроль поля link
    const val JTCSALTO_3093 = "JTCSALTO-3093"             // BE Банковская рассылка. Публикации. ЖЦ. Не происходит автоматический переход WaitingForAutoPost -> AutoPosted
    const val JTCSALTO_3094 = "JTCSALTO-3094"             // BE. (Письмо из Банка). /PreFill увеличивает счётчик документов
    const val JTCSALTO_3105 = "JTCSALTO-3105"             // BE. Банковская рассылка. Публикация. Контроли. Не срабатывает контроль при передаче некорректного customer'a
    const val JTCSALTO_4327 = "JTCSALTO-4327"             // AN. Роли. Копирование роли. Наименование для UI. Контроль на уникальность
    const val CONTROL_NOT_IMPLEMENTED = "NOT_IMPLEMENTED" // Controls that aren't implemented
    const val JTCSALTO_4386 = "JTCSALTO-4386"             // BE. Ролевая модель. Недостаточно прав для совершения операций
    const val IT_366 = "IT-366"                           // Устранить ошибки деплоя сборки qa-sign-server-deploy
}

object CommonTodos {
    //TODO [Sergeyev]: Печать: проверка слишком слабая из-за разницы в порядке расположения данных в разных форматах надо что-то придумать
    //TODO [Sergeyev]: Печать и экспорт: работа с наименованием файла через regExp - не самое удобное решение, но другого придумать пока не получается
    //TODO [Sergeyev]: assertThat() refactoring
    //TODO [Sergeyev]: parallel document signing in different classes
    //TODO A.Stykalin [22.06.2020] update filter data Predicate for IN and NOT EQ queries.
    //TODO A.Stykalin [15.09.2020] подумать, как отражать в отчете suite-тесты, которые падают в @BeforeAll
    //TODO Sergeyev [2020.11.16]: попробовать использование профилей chrome для разрешения запуска расширений в инкогнито
    //TODO Sergeyev [2020.11.16]: ? настройка расширения через код: добавление доверенного сайта
    //TODO Sergeyev [2020.12.07]: when 3094 will be fixed: /PreFill tests (increasing doc counter)
    //TODO Sergeyev [2021.02.05]: Addresses-/Blocking-/PhoneInfo mapping + filtration/sorting (Customer,Branch,representatives,...)
    //TODO Sergeyev [2021.02.08]: Write Sorting/Filtration by nested _list_ (e.g. BankInfo)
    //TODO Sergeyev [2021.03.09]: get info about kapt() not mapping data to open classes

}