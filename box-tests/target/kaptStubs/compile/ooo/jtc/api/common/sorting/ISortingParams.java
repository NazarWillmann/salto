package ooo.jtc.api.common.sorting;

import java.lang.System;

/**
 * Entity sorting params
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u0018\u0010\u0004\u001a\u00020\u0005X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/api/common/sorting/ISortingParams;", "T", "Looo/jtc/interfaces/IEntityDto;", "", "field", "", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "fieldDataProvider", "Lkotlin/Function1;", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "asc", "", "Looo/jtc/generic/pageparams/Sort;", "desc", "Companion", "box-tests"})
public abstract interface ISortingParams<T extends ooo.jtc.interfaces.IEntityDto> {
    public static final ooo.jtc.api.common.sorting.ISortingParams.Companion Companion = null;
    
    /**
     * Field name for sorting
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getField();
    
    /**
     * Field name for sorting
     */
    public abstract void setField(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<T, java.lang.Object> getFieldDataProvider();
    
    public abstract void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> p0);
    
    /**
     * Set sorting asc
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<ooo.jtc.generic.pageparams.Sort> asc();
    
    /**
     * Set sorting desc
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<ooo.jtc.generic.pageparams.Sort> desc();
    
    /**
     * Entity sorting params
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        /**
         * Set sorting asc
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IEntityDto>java.util.List<ooo.jtc.generic.pageparams.Sort> asc(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.sorting.ISortingParams<T> $this) {
            return null;
        }
        
        /**
         * Set sorting desc
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IEntityDto>java.util.List<ooo.jtc.generic.pageparams.Sort> desc(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.sorting.ISortingParams<T> $this) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J=\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042*\u0010\u0006\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b0\u0007\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\b\u00a2\u0006\u0002\u0010\tJ<\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\b\b\u0001\u0010\f*\u00020\r\"\u000e\b\u0002\u0010\u000e*\b\u0012\u0004\u0012\u0002H\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0012\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/common/sorting/ISortingParams$Companion;", "", "()V", "and", "", "Looo/jtc/generic/pageparams/Sort;", "operands", "", "Lkotlin/Function0;", "([Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "findByFiledName", "Looo/jtc/api/common/sorting/ISortingParams;", "E", "Looo/jtc/interfaces/IEntityDto;", "T", "fieldName", "", "iFilterParamsClass", "Ljava/lang/Class;", "box-tests"})
    public static final class Companion {
        
        /**
         * Find Sorting params in enum by field name.
         */
        @org.jetbrains.annotations.NotNull()
        public final <E extends ooo.jtc.interfaces.IEntityDto, T extends ooo.jtc.api.common.sorting.ISortingParams<E>>ooo.jtc.api.common.sorting.ISortingParams<E> findByFiledName(@org.jetbrains.annotations.NotNull()
        java.lang.String fieldName, @org.jetbrains.annotations.NotNull()
        java.lang.Class<T> iFilterParamsClass) {
            return null;
        }
        
        /**
         * Join any operands with AND predicate
         */
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<ooo.jtc.generic.pageparams.Sort> and(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<? extends java.util.List<ooo.jtc.generic.pageparams.Sort>>... operands) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}