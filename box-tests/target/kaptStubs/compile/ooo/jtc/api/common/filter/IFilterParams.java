package ooo.jtc.api.common.filter;

import java.lang.System;

/**
 * Entity filtering params
 * Filtration rules by default https://confluence.jtc.ooo/pages/viewpage.action?pageId=12912916
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0019*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0019J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003H\u0016J\u0018\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0003H\u0002R\u0018\u0010\u0004\u001a\u00020\u0005X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u000bX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/api/common/filter/IFilterParams;", "T", "Looo/jtc/interfaces/IEntityDto;", "", "field", "", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "fieldDataProvider", "Lkotlin/Function1;", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "contains", "Looo/jtc/generic/pageparams/FilterData;", "value", "eq", "ge", "le", "prepFilterData", "predicate", "Looo/jtc/generic/pageparams/Predicate;", "Companion", "box-tests"})
public abstract interface IFilterParams<T extends ooo.jtc.interfaces.IEntityDto> {
    public static final ooo.jtc.api.common.filter.IFilterParams.Companion Companion = null;
    
    /**
     * Field name for filtering
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getField();
    
    /**
     * Field name for filtering
     */
    public abstract void setField(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    /**
     * Method for retrieve field data from dto
     */
    @org.jetbrains.annotations.NotNull()
    public abstract kotlin.jvm.functions.Function1<T, java.lang.Object> getFieldDataProvider();
    
    /**
     * Method for retrieve field data from dto
     */
    public abstract void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends java.lang.Object> p0);
    
    /**
     * Creating Filter Data that find entities when [field] contains [value]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.pageparams.FilterData contains(@org.jetbrains.annotations.NotNull()
    java.lang.Object value);
    
    /**
     * Creating Filter Data that find entities when [field] equals [value]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.pageparams.FilterData eq(@org.jetbrains.annotations.NotNull()
    java.lang.Object value);
    
    /**
     * Creating Filter Data that find entities when [field] ge [value]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.pageparams.FilterData ge(@org.jetbrains.annotations.NotNull()
    java.lang.Object value);
    
    /**
     * Creating Filter Data that find entities when [field] le [value]
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.pageparams.FilterData le(@org.jetbrains.annotations.NotNull()
    java.lang.Object value);
    
    /**
     * Entity filtering params
     * Filtration rules by default https://confluence.jtc.ooo/pages/viewpage.action?pageId=12912916
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        private static <T extends ooo.jtc.interfaces.IEntityDto>ooo.jtc.generic.pageparams.FilterData prepFilterData(ooo.jtc.api.common.filter.IFilterParams<T> $this, ooo.jtc.generic.pageparams.Predicate predicate, java.lang.Object value) {
            return null;
        }
        
        /**
         * Creating Filter Data that find entities when [field] contains [value]
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IEntityDto>ooo.jtc.generic.pageparams.FilterData contains(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.filter.IFilterParams<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return null;
        }
        
        /**
         * Creating Filter Data that find entities when [field] equals [value]
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IEntityDto>ooo.jtc.generic.pageparams.FilterData eq(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.filter.IFilterParams<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return null;
        }
        
        /**
         * Creating Filter Data that find entities when [field] ge [value]
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IEntityDto>ooo.jtc.generic.pageparams.FilterData ge(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.filter.IFilterParams<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return null;
        }
        
        /**
         * Creating Filter Data that find entities when [field] le [value]
         */
        @org.jetbrains.annotations.NotNull()
        public static <T extends ooo.jtc.interfaces.IEntityDto>ooo.jtc.generic.pageparams.FilterData le(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.filter.IFilterParams<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.Object value) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J+\u0010\u0003\u001a\u00020\u00042\u001e\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006\"\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0002\u0010\bJ<\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\b\b\u0001\u0010\u000b*\u00020\f\"\u000e\b\u0002\u0010\r*\b\u0012\u0004\u0012\u0002H\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\u0011J+\u0010\u0012\u001a\u00020\u00042\u001e\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006\"\b\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/common/filter/IFilterParams$Companion;", "", "()V", "and", "Looo/jtc/generic/pageparams/FilterData;", "operands", "", "Lkotlin/Function0;", "([Lkotlin/jvm/functions/Function0;)Looo/jtc/generic/pageparams/FilterData;", "findByFiledName", "Looo/jtc/api/common/filter/IFilterParams;", "E", "Looo/jtc/interfaces/IEntityDto;", "T", "fieldName", "", "iFilterParamsClass", "Ljava/lang/Class;", "or", "box-tests"})
    public static final class Companion {
        
        /**
         * Find Filter params in enum by field name.
         */
        @org.jetbrains.annotations.NotNull()
        public final <E extends ooo.jtc.interfaces.IEntityDto, T extends ooo.jtc.api.common.filter.IFilterParams<E>>ooo.jtc.api.common.filter.IFilterParams<E> findByFiledName(@org.jetbrains.annotations.NotNull()
        java.lang.String fieldName, @org.jetbrains.annotations.NotNull()
        java.lang.Class<T> iFilterParamsClass) {
            return null;
        }
        
        /**
         * Join any operands with AND predicate
         */
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.generic.pageparams.FilterData and(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.FilterData>... operands) {
            return null;
        }
        
        /**
         * Join any operands with OR predicate
         */
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.generic.pageparams.FilterData or(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.FilterData>... operands) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}