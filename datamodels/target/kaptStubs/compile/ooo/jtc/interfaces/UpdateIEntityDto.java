package ooo.jtc.interfaces;

import java.lang.System;

/**
 * Interface-marker.
 * Mark Dto which uses for update [T] Dto.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"Looo/jtc/interfaces/UpdateIEntityDto;", "T", "Looo/jtc/interfaces/IEntityDto;", "datamodels"})
public abstract interface UpdateIEntityDto<T extends ooo.jtc.interfaces.IEntityDto> extends ooo.jtc.interfaces.IEntityDto {
    
    /**
     * Interface-marker.
     * Mark Dto which uses for update [T] Dto.
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static <T extends ooo.jtc.interfaces.IEntityDto>java.lang.String getEntityName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.UpdateIEntityDto<T> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static <T extends ooo.jtc.interfaces.IEntityDto>ooo.jtc.interfaces.ITransferEntity toModel(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.UpdateIEntityDto<T> $this) {
            return null;
        }
    }
}