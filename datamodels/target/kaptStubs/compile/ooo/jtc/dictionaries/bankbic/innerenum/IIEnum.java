package ooo.jtc.dictionaries.bankbic.innerenum;

import java.lang.System;

/**
 * Interface InnerEnum
 * Enums, that implement this interface, are stored withing product code and no accessible by any means
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\n"}, d2 = {"Looo/jtc/dictionaries/bankbic/innerenum/IIEnum;", "", "description", "", "getDescription", "()Ljava/lang/String;", "value", "getValue", "toDto", "Looo/jtc/dictionaries/bankbic/innerenum/IIEnumDto;", "datamodels"})
public abstract interface IIEnum {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getValue();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDescription();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.dictionaries.bankbic.innerenum.IIEnumDto toDto();
}