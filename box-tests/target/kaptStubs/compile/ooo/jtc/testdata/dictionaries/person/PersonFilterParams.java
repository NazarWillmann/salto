package ooo.jtc.testdata.dictionaries.person;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/testdata/dictionaries/person/PersonFilterParams;", "", "Looo/jtc/api/common/filter/IFilterParams;", "Looo/jtc/dictionaries/person/PersonDto;", "field", "", "fieldDataProvider", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "ID", "FIRST_NAME", "LAST_NAME", "MIDDLE_NAME", "MOBILE_PHONE", "EMAIL", "BIRTHDATE", "DESCRIPTION", "SEX", "CATEGORY", "EMAIL_CONFIRMED", "PHONE_CONFIRMED", "box-tests"})
public enum PersonFilterParams implements ooo.jtc.api.common.filter.IFilterParams<ooo.jtc.dictionaries.person.PersonDto> {
    /*public static final*/ ID /* = new ID(null, null) */,
    /*public static final*/ FIRST_NAME /* = new FIRST_NAME(null, null) */,
    /*public static final*/ LAST_NAME /* = new LAST_NAME(null, null) */,
    /*public static final*/ MIDDLE_NAME /* = new MIDDLE_NAME(null, null) */,
    /*public static final*/ MOBILE_PHONE /* = new MOBILE_PHONE(null, null) */,
    /*public static final*/ EMAIL /* = new EMAIL(null, null) */,
    /*public static final*/ BIRTHDATE /* = new BIRTHDATE(null, null) */,
    /*public static final*/ DESCRIPTION /* = new DESCRIPTION(null, null) */,
    /*public static final*/ SEX /* = new SEX(null, null) */,
    /*public static final*/ CATEGORY /* = new CATEGORY(null, null) */,
    /*public static final*/ EMAIL_CONFIRMED /* = new EMAIL_CONFIRMED(null, null) */,
    /*public static final*/ PHONE_CONFIRMED /* = new PHONE_CONFIRMED(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String field;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.person.PersonDto, ? extends java.lang.Object> fieldDataProvider;
    
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
    public kotlin.jvm.functions.Function1<ooo.jtc.dictionaries.person.PersonDto, java.lang.Object> getFieldDataProvider() {
        return null;
    }
    
    @java.lang.Override()
    public void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.person.PersonDto, ? extends java.lang.Object> p0) {
    }
    
    PersonFilterParams(java.lang.String field, kotlin.jvm.functions.Function1<? super ooo.jtc.dictionaries.person.PersonDto, ? extends java.lang.Object> fieldDataProvider) {
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