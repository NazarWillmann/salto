package ooo.jtc.core;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Looo/jtc/core/TestStoryLetterFromBank;", "", "()V", "LETTER_FROM_BANK_ACTIONS", "", "LETTER_FROM_BANK_CATEGORIES", "LETTER_FROM_BANK_CONTROLS", "LETTER_FROM_BANK_CRUD", "LETTER_FROM_BANK_EXPORT", "LETTER_FROM_BANK_FAVORITES", "LETTER_FROM_BANK_FILTRATION", "LETTER_FROM_BANK_HISTORY", "LETTER_FROM_BANK_LIFECYCLE", "LETTER_FROM_BANK_OTHER", "LETTER_FROM_BANK_PRINT", "LETTER_FROM_BANK_SORTING", "box-tests"})
public final class TestStoryLetterFromBank {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_ACTIONS = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0414\u0435\u0439\u0441\u0442\u0432\u0438\u044f \u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u043c";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_CATEGORIES = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u041a\u0430\u0442\u0435\u0433\u043e\u0440\u0438\u0438";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_CONTROLS = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u041a\u043e\u043d\u0442\u0440\u043e\u043b\u0438";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_CRUD = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u041e\u0441\u043d\u043e\u0432\u043d\u044b\u0435 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u0438";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_EXPORT = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u042d\u043a\u0441\u043f\u043e\u0440\u0442";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_FAVORITES = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0418\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0435";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_FILTRATION = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0424\u0438\u043b\u044c\u0442\u0440\u0430\u0446\u0438\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_HISTORY = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0418\u0441\u0442\u043e\u0440\u0438\u044f";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_LIFECYCLE = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0416\u0438\u0437\u043d\u0435\u043d\u043d\u044b\u0439 \u0446\u0438\u043a\u043b";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_OTHER = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0414\u0440\u0443\u0433\u0438\u0435 \u043e\u043f\u0435\u0440\u0430\u0446\u0438\u0438";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_PRINT = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u041f\u0435\u0447\u0430\u0442\u044c";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LETTER_FROM_BANK_SORTING = "\u041f\u0438\u0441\u044c\u043c\u043e \u0438\u0437 \u0411\u0430\u043d\u043a\u0430. \u0421\u043e\u0440\u0442\u0438\u0440\u043e\u0432\u043a\u0430";
    public static final ooo.jtc.core.TestStoryLetterFromBank INSTANCE = null;
    
    private TestStoryLetterFromBank() {
        super();
    }
}