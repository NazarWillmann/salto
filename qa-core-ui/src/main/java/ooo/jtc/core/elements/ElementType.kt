package ooo.jtc.core.elements

/**
 * Аннотация для формирования [ooo.jtc.core.container.SContainer.title].
 * Описывает тип элемента ("Кнопка", "Поле ввода", etc.)
 * @param name - поле для задания типа элемента. Имеет значение по умолчанию `"Элемент"`
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
annotation class ElementType(val name: String = "Элемент")