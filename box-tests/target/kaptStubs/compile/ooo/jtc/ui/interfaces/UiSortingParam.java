package ooo.jtc.ui.interfaces;

import java.lang.System;

/**
 * Интерфейс для формирования объектов для проверки сортировки на UI.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R1\u0010\b\u001a!\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Looo/jtc/ui/interfaces/UiSortingParam;", "", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "rowDataField", "getRowDataField", "stringToComparable", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "act", "", "getStringToComparable", "()Lkotlin/jvm/functions/Function1;", "box-tests"})
public abstract interface UiSortingParam {
    
    /**
     * Наименование поля по которому сортируем.
     * В дальнейшем скорее всего нужно будет прикрутить локализацию.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getFieldName();
    
    /**
     * Значение @data-name атрибута для поля,
     * в котором отображается 'значение результата выдачи' (actValue).
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getRowDataField();
    
    /**
     * Функция конвертирует значение из строки скроллера в [Comparable] объект для поверки сортировки.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<java.lang.String, java.lang.Comparable<?>> getStringToComparable();
}