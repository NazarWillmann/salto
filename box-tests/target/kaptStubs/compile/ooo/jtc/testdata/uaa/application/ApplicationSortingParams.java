package ooo.jtc.testdata.uaa.application;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B%\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007\u00a2\u0006\u0002\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/testdata/uaa/application/ApplicationSortingParams;", "", "Looo/jtc/api/common/sorting/ISortingParams;", "Looo/jtc/uaa/application/dto/ApplicationDto;", "field", "", "fieldDataProvider", "Lkotlin/Function1;", "", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getField", "()Ljava/lang/String;", "setField", "(Ljava/lang/String;)V", "getFieldDataProvider", "()Lkotlin/jvm/functions/Function1;", "setFieldDataProvider", "(Lkotlin/jvm/functions/Function1;)V", "ID", "CLIENT_ID", "ACCESS_TOKEN_LIFE_TIME", "AUTO_APPROVE_SCOPES", "DESCRIPTION", "NAME", "REDIRECT_URLS", "box-tests"})
public enum ApplicationSortingParams implements ooo.jtc.api.common.sorting.ISortingParams<ooo.jtc.uaa.application.dto.ApplicationDto> {
    /*public static final*/ ID /* = new ID(null, null) */,
    /*public static final*/ CLIENT_ID /* = new CLIENT_ID(null, null) */,
    /*public static final*/ ACCESS_TOKEN_LIFE_TIME /* = new ACCESS_TOKEN_LIFE_TIME(null, null) */,
    /*public static final*/ AUTO_APPROVE_SCOPES /* = new AUTO_APPROVE_SCOPES(null, null) */,
    /*public static final*/ DESCRIPTION /* = new DESCRIPTION(null, null) */,
    /*public static final*/ NAME /* = new NAME(null, null) */,
    /*public static final*/ REDIRECT_URLS /* = new REDIRECT_URLS(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String field;
    @org.jetbrains.annotations.NotNull()
    private kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.application.dto.ApplicationDto, ? extends java.lang.Object> fieldDataProvider;
    
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
    public kotlin.jvm.functions.Function1<ooo.jtc.uaa.application.dto.ApplicationDto, java.lang.Object> getFieldDataProvider() {
        return null;
    }
    
    @java.lang.Override()
    public void setFieldDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.application.dto.ApplicationDto, ? extends java.lang.Object> p0) {
    }
    
    ApplicationSortingParams(java.lang.String field, kotlin.jvm.functions.Function1<? super ooo.jtc.uaa.application.dto.ApplicationDto, ? extends java.lang.Object> fieldDataProvider) {
    }
    
    /**
     * Set sorting asc
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<ooo.jtc.generic.pageparams.Sort> asc() {
        return null;
    }
    
    /**
     * Set sorting desc
     */
    @org.jetbrains.annotations.NotNull()
    public java.util.List<ooo.jtc.generic.pageparams.Sort> desc() {
        return null;
    }
}