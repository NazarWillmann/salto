package ooo.jtc.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0017J\b\u0010\u0004\u001a\u00020\u0005H\u0017\u00a8\u0006\u0006"}, d2 = {"Looo/jtc/interfaces/IEntityDto;", "Looo/jtc/interfaces/Identifiable;", "getEntityName", "", "toModel", "Looo/jtc/interfaces/ITransferEntity;", "datamodels"})
public abstract interface IEntityDto extends ooo.jtc.interfaces.Identifiable {
    
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public abstract java.lang.String getEntityName();
    
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public abstract ooo.jtc.interfaces.ITransferEntity toModel();
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static java.lang.String getEntityName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.IEntityDto $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static ooo.jtc.interfaces.ITransferEntity toModel(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.IEntityDto $this) {
            return null;
        }
    }
}