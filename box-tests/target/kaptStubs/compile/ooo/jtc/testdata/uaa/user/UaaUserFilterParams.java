package ooo.jtc.testdata.uaa.user;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/testdata/uaa/user/UaaUserFilterParams;", "", "Looo/jtc/api/common/filter/IFilterParams;", "Looo/jtc/uaa/user/dto/UaaUserDto;", "field", "", "fieldDataProvider", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "ID", "BLOCK_REASON", "BLOCK_USER", "PERMANENT_BLOCKED", "PREFERRED_LOCALE", "TEMPORARY_BLOCKED", "TEMPORARY_BLOCKED_UNTIL", "USER_DETAILS_FIRST_NAME", "USER_DETAILS_MIDDLE_NAME", "USER_DETAILS_LAST_NAME", "USER_DETAILS_EMAIL", "USER_DETAILS_PHONE", "box-tests"})
public enum UaaUserFilterParams implements ooo.jtc.api.common.filter.IFilterParams<ooo.jtc.uaa.user.dto.UaaUserDto> {
    /*public static final*/ ID /* = new ID(null, null) */,
    /*public static final*/ BLOCK_REASON /* = new BLOCK_REASON(null, null) */,
    /*public static final*/ BLOCK_USER /* = new BLOCK_USER(null, null) */,
    /*public static final*/ PERMANENT_BLOCKED /* = new PERMANENT_BLOCKED(null, null) */,
    /*public static final*/ PREFERRED_LOCALE /* = new PREFERRED_LOCALE(null, null) */,
    /*public static final*/ TEMPORARY_BLOCKED /* = new TEMPORARY_BLOCKED(null, null) */,
    /*public static final*/ TEMPORARY_BLOCKED_UNTIL /* = new TEMPORARY_BLOCKED_UNTIL(null, null) */,
    /*public static final*/ USER_DETAILS_FIRST_NAME /* = new USER_DETAILS_FIRST_NAME(null, null) */,
    /*public static final*/ USER_DETAILS_MIDDLE_NAME /* = new USER_DETAILS_MIDDLE_NAME(null, null) */,
    /*public static final*/ USER_DETAILS_LAST_NAME /* = new USER_DETAILS_LAST_NAME(null, null) */,
    /*public static final*/ USER_DETAILS_EMAIL /* = new USER_DETAILS_EMAIL(null, null) */,
    /*public static final*/ USER_DETAILS_PHONE /* = new USER_DETAILS_PHONE(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String field;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.user.dto.UaaUserDto, ? extends java.lang.Object> fieldDataProvider;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getField() {
        return null;
    }
    
    @java.lang.Override()
    public void setField(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.jvm.functions.Function1<ooo.jtc.uaa.user.dto.UaaUserDto, java.lang.Object> getFieldDataProvider() {
        return null;
    }
    
    @java.lang.Override()
    public void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.user.dto.UaaUserDto, ? extends java.lang.Object> p0) {
    }
    
    UaaUserFilterParams(java.lang.String field, kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.user.dto.UaaUserDto, ? extends java.lang.Object> fieldDataProvider) {
    }
    
    /**
     * Creating Filter Data that find entities when [field] contains [value]
     */
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.generic.pageparams.FilterData contains(@org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
        return null;
    }
    
    /**
     * Creating Filter Data that find entities when [field] equals [value]
     */
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.generic.pageparams.FilterData eq(@org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
        return null;
    }
    
    /**
     * Creating Filter Data that find entities when [field] ge [value]
     */
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.generic.pageparams.FilterData ge(@org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
        return null;
    }
    
    /**
     * Creating Filter Data that find entities when [field] le [value]
     */
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.generic.pageparams.FilterData le(@org.jetbrains.annotations.NotNull()
    java.lang.Object value) {
        return null;
    }
}