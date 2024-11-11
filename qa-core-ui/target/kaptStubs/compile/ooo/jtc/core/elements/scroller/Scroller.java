package ooo.jtc.core.elements.scroller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\b\'\u0018\u0000 J*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001JB\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\r\u0010 \u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010!J\r\u0010\"\u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010!J\r\u0010#\u001a\u00028\u0000H\u0007\u00a2\u0006\u0002\u0010!J)\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u001b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\'0\nH\u0007\u00a2\u0006\u0002\u0010(J\u001d\u0010)\u001a\u00028\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001bH\u0007\u00a2\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00028\u00002\u0006\u0010/\u001a\u00020\u001b\u00a2\u0006\u0002\u00100J)\u00101\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\u001b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\'0\nH\u0007\u00a2\u0006\u0002\u0010(J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u00103\u001a\u000204J\'\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u00106\u001a\u00020\u001b2\n\b\u0002\u00103\u001a\u0004\u0018\u000104H\u0016\u00a2\u0006\u0002\u00107J}\u00108\u001a\b\u0012\u0004\u0012\u0002H90\u001a\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010:2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H:0\n2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u00020\'0\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u0002H:\u0012\u0004\u0012\u0002H90\n2\n\b\u0002\u0010=\u001a\u0004\u0018\u0001042\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010>\u001a\u00020?H\u0002\u00a2\u0006\u0002\u0010@Ja\u0010A\u001a\b\u0012\u0004\u0012\u0002H90\u001a\"\u0004\b\u0001\u001092\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\'0\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H90\n2\n\b\u0002\u0010=\u001a\u0004\u0018\u0001042\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010>\u001a\u00020?\u00a2\u0006\u0002\u0010BJa\u0010C\u001a\b\u0012\u0004\u0012\u0002H90\u001a\"\u0004\b\u0001\u001092\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\'0\n2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002H90\n2\n\b\u0002\u0010=\u001a\u0004\u0018\u0001042\n\b\u0002\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u0010>\u001a\u00020?\u00a2\u0006\u0002\u0010BJ\u0006\u0010D\u001a\u00020\'J\u0006\u0010E\u001a\u00020FJ\u0010\u0010G\u001a\u00020F2\b\b\u0002\u0010>\u001a\u00020?J\u000e\u0010H\u001a\u00020F2\u0006\u0010/\u001a\u00020\u001bJ\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0007R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u000b\u001a\u00020\f8@X\u0081\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006K"}, d2 = {"Looo/jtc/core/elements/scroller/Scroller;", "R", "Looo/jtc/core/elements/scroller/ScrollerRow;", "Looo/jtc/core/container/SContainer;", "rowClass", "Lkotlin/reflect/KClass;", "sElement", "Lcom/codeborne/selenide/SelenideElement;", "(Lkotlin/reflect/KClass;Lcom/codeborne/selenide/SelenideElement;)V", "createScrollerRowAction", "Lkotlin/Function1;", "log", "Lorg/slf4j/Logger;", "getLog$annotations", "()V", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "rowBy", "Lorg/openqa/selenium/By;", "getRowClass", "()Lkotlin/reflect/KClass;", "setRowClass", "(Lkotlin/reflect/KClass;)V", "allRowsText", "", "", "createScrollerRow", "(Lcom/codeborne/selenide/SelenideElement;)Looo/jtc/core/elements/scroller/ScrollerRow;", "findRows", "Lcom/codeborne/selenide/ElementsCollection;", "getFirstFavoriteRow", "()Looo/jtc/core/elements/scroller/ScrollerRow;", "getFirstNotFavoriteRow", "getFirstRow", "getRow", "conditionDescription", "condition", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Looo/jtc/core/elements/scroller/ScrollerRow;", "getRowById", "uuid", "Ljava/util/UUID;", "documentNumber", "(Ljava/util/UUID;Ljava/lang/String;)Looo/jtc/core/elements/scroller/ScrollerRow;", "getRowByText", "rowText", "(Ljava/lang/String;)Looo/jtc/core/elements/scroller/ScrollerRow;", "getRowWithSelenide", "getRows", "limitRows", "", "getValuesFromRows", "searchLocator", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/util/List;", "makeActionWithMapper", "T", "M", "mapper", "action", "limitActions", "timeout", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/Integer;J)Ljava/util/List;", "makeActionWithRows", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;Ljava/lang/Integer;J)Ljava/util/List;", "makeActionWithSelenide", "scrollPageDown", "scrollToBottom", "", "scrollToFirstRow", "selectRowByText", "rowTextList", "Companion", "qa-core-ui"})
@ooo.jtc.core.elements.ElementType(name = "\u0421\u043a\u0440\u043e\u043b\u043b\u0435\u0440")
public abstract class Scroller<R extends ooo.jtc.core.elements.scroller.ScrollerRow> extends ooo.jtc.core.container.SContainer {
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    private final org.openqa.selenium.By rowBy = null;
    private final kotlin.jvm.functions.Function1<com.codeborne.selenide.SelenideElement, R> createScrollerRowAction = null;
    @org.jetbrains.annotations.NotNull()
    private kotlin.reflect.KClass<R> rowClass;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> anyRow = null;
    public static final ooo.jtc.core.elements.scroller.Scroller.Companion Companion = null;
    
    @kotlin.PublishedApi()
    @java.lang.Deprecated()
    public static void getLog$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.slf4j.Logger getLog() {
        return null;
    }
    
    /**
     * Функция создания строки скроллера из элемента.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract R createScrollerRow(@org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement);
    
    public final void selectRowByText(@org.jetbrains.annotations.NotNull()
    java.lang.String rowText) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @io.qameta.allure.Step(value = "\u041e\u0442\u043c\u0435\u0442\u0438\u0442\u044c \u0447\u0435\u043a\u0431\u043e\u043a\u0441 \u0432 \u0441\u0442\u0440\u043e\u043a\u0430\u0445 \u0441 \u0442\u0435\u043a\u0441\u0442\u043e\u043c {rowTextList}")
    public final java.util.List<R> selectRowByText(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> rowTextList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final R getRowByText(@org.jetbrains.annotations.NotNull()
    java.lang.String rowText) {
        return null;
    }
    
    /**
     * Ищем строку по [uuid].
     * Но, т.к. [uuid] не отображается на UI, передаем [documentNumber] для поиска и сопоставления на скрине.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0441\u0442\u0440\u043e\u043a\u0443 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435 \u043f\u043e ID (documentNumber: {documentNumber})")
    public final R getRowById(@org.jetbrains.annotations.NotNull()
    java.util.UUID uuid, @org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber) {
        return null;
    }
    
    /**
     * Получаем первую подходящую под условие строку на скроллере.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0441\u0442\u0440\u043e\u043a\u0443 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435 \u043f\u043e \u0443\u0441\u043b\u043e\u0432\u0438\u044e: {conditionDescription}")
    public final R getRowWithSelenide(@org.jetbrains.annotations.NotNull()
    java.lang.String conditionDescription, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.codeborne.selenide.SelenideElement, java.lang.Boolean> condition) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0441\u0442\u0440\u043e\u043a\u0443 \u043d\u0430 \u0441\u043a\u0440\u043e\u043b\u043b\u0435\u0440\u0435 \u043f\u043e \u0443\u0441\u043b\u043e\u0432\u0438\u044e: {conditionDescription}")
    public final R getRow(@org.jetbrains.annotations.NotNull()
    java.lang.String conditionDescription, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super R, java.lang.Boolean> condition) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043f\u0435\u0440\u0432\u0443\u044e \u0441\u0442\u0440\u043e\u043a\u0443")
    public final R getFirstRow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043f\u0435\u0440\u0432\u0443\u044e \u0441\u0442\u0440\u043e\u043a\u0443 \u0432 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u043c")
    public final R getFirstFavoriteRow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043f\u0435\u0440\u0432\u0443\u044e \u0441\u0442\u0440\u043e\u043a\u0443 \u043d\u0435 \u0432 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u043c")
    public final R getFirstNotFavoriteRow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.lang.String> getValuesFromRows(@org.jetbrains.annotations.NotNull()
    java.lang.String searchLocator, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limitRows) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<R> getRows(int limitRows) {
        return null;
    }
    
    /**
     * @return list of all rows text, not only visible
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> allRowsText() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.util.List<T> makeActionWithRows(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super R, java.lang.Boolean> condition, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super R, ? extends T> action, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limitActions, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limitRows, long timeout) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.util.List<T> makeActionWithSelenide(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.codeborne.selenide.SelenideElement, java.lang.Boolean> condition, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.codeborne.selenide.SelenideElement, ? extends T> action, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limitActions, @org.jetbrains.annotations.Nullable()
    java.lang.Integer limitRows, long timeout) {
        return null;
    }
    
    /**
     * Основной метод для взаимодействия со строками скроллера.
     *
     * Строки в DOM подгружаются динамически. Итерируемся по строкам ориентируясь на innerText в элементе.
     * !!Не пытайся даже думать, чтобы итерироваться по индексу. т.к. элементы в списке `visibleRows` меняются тоже динамически,
     * в зависимости от изменений на скроллере, и каких-то внутренних механизмов (не стал глубоко копать).
     * Поэтому каждую строку последовательно проверяем по предикату [condition] и в случае совпадения - выполняем действие.
     * Возвращаем список с результатами действия [action].
     *
     * @param mapper - функция для преобразования (SelenideElement) в тип [M],
     * после чего и [condition] и [action] будут взаимодействовать с этим типом.
     * @param condition - предикат для поиска.
     * @param action - действие с найденным элементом.
     * @param limitActions - лимит выполняемых действий.
     * Используется когда нужно выполнить действие только над заданным кол-вом найденных по [condition] строк.
     * @param limitRows - лимит проверяемых строк.
     * Используется когда нужно проверить по [condition] заданное кол-во строк от начала.
     * Если ни одна из строк не соответствует [condition], действие выполняться не будет.
     * @param timeout - максимальное время поиска на скроллере.
     */
    private final <T extends java.lang.Object, M extends java.lang.Object>java.util.List<T> makeActionWithMapper(kotlin.jvm.functions.Function1<? super com.codeborne.selenide.SelenideElement, ? extends M> mapper, kotlin.jvm.functions.Function1<? super M, java.lang.Boolean> condition, kotlin.jvm.functions.Function1<? super M, ? extends T> action, java.lang.Integer limitActions, java.lang.Integer limitRows, long timeout) {
        return null;
    }
    
    /**
     * Скролим вниз до "последней" загруженной строки в DOM'e.
     * И предполагаем, что это (supposedLastRow) самая последняя строка.
     * Если после скрола до неё новых строк не подгружается (сравниваем строки по тексту),
     * то считаем, что это самая последняя строка и возвращаем `false`. (Как значение, что проскролить не удалось).
     * Соответственно, если проскролить удалось (подгрузились новые строки), возвращаем `true`
     */
    public final boolean scrollPageDown() {
        return false;
    }
    
    /**
     * Скроллинг до самой нижней строки.
     */
    public final void scrollToBottom() {
    }
    
    /**
     * Скроллинг строк на скроллере до первого вверх.
     * Находим пердпалагаемую епрвую строку (supposedFirstRow);
     * Пытаемся проскролить её к низу.
     * Если после скрола первая строка (scrolledFirstRow) отличается от предполагаемой (supposedFirstRow),
     * то повторяем скролл наверх, через рекурсию.
     * [timeout] - Время для скрола. Зачита от зацикливания.
     */
    public final void scrollToFirstRow(long timeout) {
    }
    
    /**
     * Сокращение для поиска строк на скроллере.
     */
    private final com.codeborne.selenide.ElementsCollection findRows() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public kotlin.reflect.KClass<R> getRowClass() {
        return null;
    }
    
    public void setRowClass(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<R> p0) {
    }
    
    public Scroller(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<R> rowClass, @org.jetbrains.annotations.NotNull()
    com.codeborne.selenide.SelenideElement sElement) {
        super(null, null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Looo/jtc/core/elements/scroller/Scroller$Companion;", "", "()V", "anyRow", "Lkotlin/Function1;", "", "getAnyRow", "()Lkotlin/jvm/functions/Function1;", "qa-core-ui"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<java.lang.Object, java.lang.Boolean> getAnyRow() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}