package ooo.jtc.generic;

import java.lang.System;

/**
 * Converter kotlin code to java for mapping expression in Mapstruct.
 * @see [ooo.jtc.letters.LetterToBankViewMapper]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J1\u0010\b\u001a\u00020\u0004\"\f\b\u0000\u0010\t*\u0006\u0012\u0002\b\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000eJ1\u0010\u000f\u001a\u00020\u0004\"\f\b\u0000\u0010\t*\u0006\u0012\u0002\b\u00030\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\t0\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0002\u0010\u000eJ\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0012"}, d2 = {"Looo/jtc/generic/KJavaConverter;", "", "()V", "amountToMaskedAntieString", "", "source", "Ljava/math/BigDecimal;", "amountToMaskedString", "convertToStatusBank", "T", "Looo/jtc/documents/IDocumentStatus;", "values", "", "status", "([Looo/jtc/documents/IDocumentStatus;Ljava/lang/String;)Ljava/lang/String;", "convertToStatusClient", "getUiMaskedPhone", "hiddenMaskAccount", "datamodels"})
public final class KJavaConverter {
    public static final ooo.jtc.generic.KJavaConverter INSTANCE = null;
    
    /**
     * Convert 'Draft' to 'Черновик'
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends ooo.jtc.documents.IDocumentStatus<?>>java.lang.String convertToStatusClient(@org.jetbrains.annotations.NotNull()
    T[] values, @org.jetbrains.annotations.Nullable()
    java.lang.String status) {
        return null;
    }
    
    /**
     * Convert 'Draft' to 'Черновик'
     */
    @org.jetbrains.annotations.NotNull()
    public final <T extends ooo.jtc.documents.IDocumentStatus<?>>java.lang.String convertToStatusBank(@org.jetbrains.annotations.NotNull()
    T[] values, @org.jetbrains.annotations.Nullable()
    java.lang.String status) {
        return null;
    }
    
    /**
     * Convert 40807810438602823436 to 40807...3436
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String hiddenMaskAccount(@org.jetbrains.annotations.Nullable()
    java.lang.String source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String amountToMaskedString(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String amountToMaskedAntieString(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal source) {
        return null;
    }
    
    /**
     * Convert phone from +71234567890 to ui format `+7 (123) 456 - 78 - 90`
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u043c\u0430\u0441\u043a\u0443 \u043d\u043e\u043c\u0435\u0440\u0443 \u0442\u0435\u043b\u0435\u0444\u043e\u043d\u0430 ({source}) \u0434\u043b\u044f UI")
    public final java.lang.String getUiMaskedPhone(@org.jetbrains.annotations.Nullable()
    java.lang.String source) {
        return null;
    }
    
    private KJavaConverter() {
        super();
    }
}