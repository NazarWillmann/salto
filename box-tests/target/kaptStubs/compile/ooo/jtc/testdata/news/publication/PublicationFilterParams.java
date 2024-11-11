package ooo.jtc.testdata.news.publication;

import java.lang.System;

/**
 * Numbers are a reference to https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733403
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b#\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B#\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b\'j\u0002\b(j\u0002\b)j\u0002\b*\u00a8\u0006+"}, d2 = {"Looo/jtc/testdata/news/publication/PublicationFilterParams;", "", "Looo/jtc/api/common/filter/IFilterParams;", "Looo/jtc/news/dto/PublicationDto;", "field", "", "fieldDataProvider", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "ID", "DOCUMENT_NUMBER", "DOCUMENT_DATE", "STATUS", "DESCRIPTION", "PUBL_TYPE", "TARGET_TYPE", "IS_MUST_KNOW", "IS_IMPORTANT", "START_AT", "END_AT", "MAILING_CHANNEL", "IS_FOR_ALL_BRANCHES", "HEADER", "TEXT", "LINK", "LINK_TEXT", "PICTURE", "BRANCH_ID", "BRANCH_NAME", "CREATED_AT", "IS_HAS_ATTACH", "ATTACH_FILE_NAME", "POSTED_AT", "IS_FAVORITES", "box-tests"})
public enum PublicationFilterParams implements ooo.jtc.api.common.filter.IFilterParams<ooo.jtc.news.dto.PublicationDto> {
    /*public static final*/ ID /* = new ID(null, null) */,
    /*public static final*/ DOCUMENT_NUMBER /* = new DOCUMENT_NUMBER(null, null) */,
    /*public static final*/ DOCUMENT_DATE /* = new DOCUMENT_DATE(null, null) */,
    /*public static final*/ STATUS /* = new STATUS(null, null) */,
    /*public static final*/ DESCRIPTION /* = new DESCRIPTION(null, null) */,
    /*public static final*/ PUBL_TYPE /* = new PUBL_TYPE(null, null) */,
    /*public static final*/ TARGET_TYPE /* = new TARGET_TYPE(null, null) */,
    /*public static final*/ IS_MUST_KNOW /* = new IS_MUST_KNOW(null, null) */,
    /*public static final*/ IS_IMPORTANT /* = new IS_IMPORTANT(null, null) */,
    /*public static final*/ START_AT /* = new START_AT(null, null) */,
    /*public static final*/ END_AT /* = new END_AT(null, null) */,
    /*public static final*/ MAILING_CHANNEL /* = new MAILING_CHANNEL(null, null) */,
    /*public static final*/ IS_FOR_ALL_BRANCHES /* = new IS_FOR_ALL_BRANCHES(null, null) */,
    /*public static final*/ HEADER /* = new HEADER(null, null) */,
    /*public static final*/ TEXT /* = new TEXT(null, null) */,
    /*public static final*/ LINK /* = new LINK(null, null) */,
    /*public static final*/ LINK_TEXT /* = new LINK_TEXT(null, null) */,
    /*public static final*/ PICTURE /* = new PICTURE(null, null) */,
    /*public static final*/ BRANCH_ID /* = new BRANCH_ID(null, null) */,
    /*public static final*/ BRANCH_NAME /* = new BRANCH_NAME(null, null) */,
    /*public static final*/ CREATED_AT /* = new CREATED_AT(null, null) */,
    /*public static final*/ IS_HAS_ATTACH /* = new IS_HAS_ATTACH(null, null) */,
    /*public static final*/ ATTACH_FILE_NAME /* = new ATTACH_FILE_NAME(null, null) */,
    /*public static final*/ POSTED_AT /* = new POSTED_AT(null, null) */,
    /*public static final*/ IS_FAVORITES /* = new IS_FAVORITES(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String field;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.news.dto.PublicationDto, ? extends java.lang.Object> fieldDataProvider;
    
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
    public kotlin.jvm.functions.Function1<ooo.jtc.news.dto.PublicationDto, java.lang.Object> getFieldDataProvider() {
        return null;
    }
    
    @java.lang.Override()
    public void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.news.dto.PublicationDto, ? extends java.lang.Object> p0) {
    }
    
    PublicationFilterParams(java.lang.String field, kotlin.jvm.functions.Function1<? super ooo.jtc.news.dto.PublicationDto, ? extends java.lang.Object> fieldDataProvider) {
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