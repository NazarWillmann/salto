package ooo.jtc.core.elements;

import java.lang.System;

/**
 * Аннотация для формирования [ooo.jtc.core.container.SContainer.title].
 * Описывает тип элемента ("Кнопка", "Поле ввода", etc.)
 * @param name - поле для задания типа элемента. Имеет значение по умолчанию `"Элемент"`
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Looo/jtc/core/elements/ElementType;", "", "name", "", "()Ljava/lang/String;", "qa-core-ui"})
@java.lang.annotation.Target(value = {java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.METHOD})
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.RUNTIME)
@kotlin.annotation.Target(allowedTargets = {kotlin.annotation.AnnotationTarget.CLASS, kotlin.annotation.AnnotationTarget.PROPERTY, kotlin.annotation.AnnotationTarget.PROPERTY_GETTER})
public abstract @interface ElementType {
    
    public abstract java.lang.String name() default "\u042d\u043b\u0435\u043c\u0435\u043d\u0442";
}