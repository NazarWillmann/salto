package ooo.jtc.ui.interfaces

/**
 * Интерфейс для формирования объектов для проверки сортировки на UI.
 */
interface UiSortingParam {

    /**
     * Наименование поля по которому сортируем.
     * В дальнейшем скорее всего нужно будет прикрутить локализацию.
     */
    val fieldName: String

    /**
     *  Значение @data-name атрибута для поля,
     *  в котором отображается 'значение результата выдачи' (actValue).
     */
    val rowDataField: String

    /**
     * Функция конвертирует значение из строки скроллера в [Comparable] объект для поверки сортировки.
     */
    val stringToComparable: (act: String) -> Comparable<*>

}