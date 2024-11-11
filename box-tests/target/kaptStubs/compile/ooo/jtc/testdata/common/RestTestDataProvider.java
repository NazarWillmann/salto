package ooo.jtc.testdata.common;

import java.lang.System;

/**
 * Test data provider using REST API.
 *
 * @param restDataConsumer - function, that load data using REST
 * @param restResultProcessor - executing function after load data
 * @param restDataProvider - function to creating data using REST
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001Bc\u0012\u001e\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u0012,\b\u0002\u0010\t\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\n\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00130\u0004H\u0016R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR&\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R2\u0010\t\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/testdata/common/RestTestDataProvider;", "Looo/jtc/testdata/common/TestDataProvider;", "restDataConsumer", "Lkotlin/Function0;", "", "", "", "", "restDataProvider", "restResultProcessor", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "dataSource", "Looo/jtc/testdata/common/TestDataSource;", "getDataSource", "()Looo/jtc/testdata/common/TestDataSource;", "getRestDataProvider", "()Lkotlin/jvm/functions/Function0;", "getData", "", "box-tests"})
public final class RestTestDataProvider implements ooo.jtc.testdata.common.TestDataProvider {
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.testdata.common.TestDataSource dataSource = ooo.jtc.testdata.common.TestDataSource.REST;
    private final kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> restDataConsumer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<java.lang.Object> restDataProvider = null;
    private final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> restResultProcessor = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.testdata.common.TestDataSource getDataSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function0<java.lang.Object> getRestDataProvider() {
        return null;
    }
    
    public RestTestDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>> restDataConsumer, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.lang.Object> restDataProvider, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, java.lang.Object>, ? extends java.util.Map<java.lang.String, java.lang.Object>> restResultProcessor) {
        super();
    }
}