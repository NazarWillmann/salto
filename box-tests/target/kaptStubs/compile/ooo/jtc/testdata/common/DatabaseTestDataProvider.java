package ooo.jtc.testdata.common;

import java.lang.System;

/**
 * Test data provider from database.
 *
 * @param dbDataConsumer - function, that load data from database
 * @param dbResultProcessor - executing function after load data
 * @param dbDataProvider - function, that crate data in database
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bo\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0004\u0012\u001a\b\u0002\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u000b0\n\u0012,\b\u0002\u0010\f\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\n\u00a2\u0006\u0002\u0010\rJ\u001a\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u001b0\u0005H\u0016R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R2\u0010\f\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Looo/jtc/testdata/common/DatabaseTestDataProvider;", "T", "Looo/jtc/testdata/common/TestDataProvider;", "dbDataConsumer", "Lkotlin/Function0;", "", "", "", "", "dbDataProvider", "Lkotlin/Function1;", "", "dbResultProcessor", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "dataSource", "Looo/jtc/testdata/common/TestDataSource;", "getDataSource", "()Looo/jtc/testdata/common/TestDataSource;", "getDbDataProvider", "()Lkotlin/jvm/functions/Function1;", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "getData", "", "box-tests"})
public final class DatabaseTestDataProvider<T extends java.lang.Object> implements ooo.jtc.testdata.common.TestDataProvider {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.testdata.common.TestDataSource dataSource = ooo.jtc.testdata.common.TestDataSource.DATABASE;
    private final kotlin.jvm.functions.Function0<java.util.List<java.util.Map<java.lang.String, java.lang.Object>>> dbDataConsumer = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.util.List<? extends T>, kotlin.Unit> dbDataProvider = null;
    private final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> dbResultProcessor = null;
    
    private final org.slf4j.Logger getLog() {
        return null;
    }
    
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
    public final kotlin.jvm.functions.Function1<java.util.List<? extends T>, kotlin.Unit> getDbDataProvider() {
        return null;
    }
    
    public DatabaseTestDataProvider(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>> dbDataConsumer, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends T>, kotlin.Unit> dbDataProvider, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, java.lang.Object>, ? extends java.util.Map<java.lang.String, java.lang.Object>> dbResultProcessor) {
        super();
    }
}