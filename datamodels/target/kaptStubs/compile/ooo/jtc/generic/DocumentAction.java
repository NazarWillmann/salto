package ooo.jtc.generic;

import java.lang.System;

/**
 * Интерфейс для объектов Действий (/GetActions).
 * Сейчас значения действий зашиты на фронте. Но в будущем (в след релизе) фронт будет брать их c бэка из ЛокРесов (/GetLocResource).
 * Так же на примере этих экшенов, я решил реализовать механизм использования "своих" локресов для проверок. См. подробнее в /wiki/TestLocResources.md
 *
 * Интерфейс соответствует объекту ответа `/GetActions` [AvailableActionDto] c дополнениями по локализации.
 *
 * !!Сейчас бэк присылает не актуальную информацию в `/GetActions`. Поэтому занчения для [title] в энамах используются "наши".
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003J\b\u0010\u0013\u001a\u00020\u0005H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/generic/DocumentAction;", "T", "Looo/jtc/interfaces/IDocument;", "", "actionName", "", "getActionName", "()Ljava/lang/String;", "i18nMap", "", "getI18nMap", "()Ljava/util/Map;", "statuses", "", "Looo/jtc/documents/IDocumentStatus;", "getStatuses", "()Ljava/util/List;", "title", "getTitle", "getUiName", "datamodels"})
public abstract interface DocumentAction<T extends ooo.jtc.interfaces.IDocument> {
    
    /**
     * Системное наименование действия.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getActionName();
    
    /**
     * Доступные для действия статусы документа.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<ooo.jtc.documents.IDocumentStatus<T>> getStatuses();
    
    /**
     * Ключ-ссылка для фронта на локресы.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTitle();
    
    /**
     * Мапа с локресами из [LocResourceRepository].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.Map<java.lang.String, java.lang.String> getI18nMap();
    
    /**
     * Получить наименование действия для фронта с учетом локализации по [title].
     *
     * Т.к. [title] с бэка приходит в двойных квадратных скобках "[[some.loc.resource]]",
     * а локрес-файлах эти ключи без скобок, нужно делать repace.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getUiName();
    
    /**
     * Интерфейс для объектов Действий (/GetActions).
     * Сейчас значения действий зашиты на фронте. Но в будущем (в след релизе) фронт будет брать их c бэка из ЛокРесов (/GetLocResource).
     * Так же на примере этих экшенов, я решил реализовать механизм использования "своих" локресов для проверок. См. подробнее в /wiki/TestLocResources.md
     *
     * Интерфейс соответствует объекту ответа `/GetActions` [AvailableActionDto] c дополнениями по локализации.
     *
     * !!Сейчас бэк присылает не актуальную информацию в `/GetActions`. Поэтому занчения для [title] в энамах используются "наши".
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        /**
         * Получить наименование действия для фронта с учетом локализации по [title].
         *
         * Т.к. [title] с бэка приходит в двойных квадратных скобках "[[some.loc.resource]]",
         * а локрес-файлах эти ключи без скобок, нужно делать repace.
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IDocument>java.lang.String getUiName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.generic.DocumentAction<? extends T> $this) {
            return null;
        }
    }
}