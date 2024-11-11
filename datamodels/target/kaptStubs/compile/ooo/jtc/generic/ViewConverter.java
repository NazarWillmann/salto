package ooo.jtc.generic;

import java.lang.System;

@org.mapstruct.Named(value = "ViewConverter")
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Looo/jtc/generic/ViewConverter;", "", "()V", "amountToString", "", "source", "Ljava/math/BigDecimal;", "localDateToString", "Ljava/time/LocalDate;", "maskAccount", "datamodels"})
public final class ViewConverter {
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Named(value = "LocalDateToString")
    public final java.lang.String localDateToString(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Named(value = "AmountToString")
    public final java.lang.String amountToString(@org.jetbrains.annotations.Nullable()
    java.math.BigDecimal source) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @org.mapstruct.Named(value = "MaskAccount")
    public final java.lang.String maskAccount(@org.jetbrains.annotations.Nullable()
    java.lang.String source) {
        return null;
    }
    
    public ViewConverter() {
        super();
    }
}