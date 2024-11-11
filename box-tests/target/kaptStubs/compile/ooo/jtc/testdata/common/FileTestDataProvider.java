package ooo.jtc.testdata.common;

import java.lang.System;

/**
 * Test data provider from file.
 *
 * @param file - destination file
 * @param fileResultProcessor - executing function after load data
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012,\b\u0002\u0010\u0004\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00180\u0017H\u0016R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR2\u0010\u0004\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/testdata/common/FileTestDataProvider;", "Looo/jtc/testdata/common/TestDataProvider;", "file", "Ljava/io/File;", "fileResultProcessor", "Lkotlin/Function1;", "", "", "", "(Ljava/io/File;Lkotlin/jvm/functions/Function1;)V", "dataSource", "Looo/jtc/testdata/common/TestDataSource;", "getDataSource", "()Looo/jtc/testdata/common/TestDataSource;", "getFile", "()Ljava/io/File;", "log", "Lorg/slf4j/Logger;", "getLog", "()Lorg/slf4j/Logger;", "log$delegate", "Looo/jtc/logging/LoggerDelegate;", "getData", "", "", "box-tests"})
public final class FileTestDataProvider implements ooo.jtc.testdata.common.TestDataProvider {
    private final ooo.jtc.logging.LoggerDelegate log$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.testdata.common.TestDataSource dataSource = ooo.jtc.testdata.common.TestDataSource.FILE;
    @org.jetbrains.annotations.NotNull()
    private final java.io.File file = null;
    private final kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, java.lang.Object>, java.util.Map<java.lang.String, java.lang.Object>> fileResultProcessor = null;
    
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
    public final java.io.File getFile() {
        return null;
    }
    
    public FileTestDataProvider(@org.jetbrains.annotations.NotNull()
    java.io.File file, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.Map<java.lang.String, java.lang.Object>, ? extends java.util.Map<java.lang.String, java.lang.Object>> fileResultProcessor) {
        super();
    }
}