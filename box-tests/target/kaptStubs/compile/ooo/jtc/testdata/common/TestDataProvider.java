package ooo.jtc.testdata.common;

import java.lang.System;

/**
 * Provide test data from [TestDataSource]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b0\u0007H&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\n"}, d2 = {"Looo/jtc/testdata/common/TestDataProvider;", "", "dataSource", "Looo/jtc/testdata/common/TestDataSource;", "getDataSource", "()Looo/jtc/testdata/common/TestDataSource;", "getData", "", "", "", "box-tests"})
public abstract interface TestDataProvider {
    
    /**
     * Provide data as List<Map<String, Any>>
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<java.util.Map<java.lang.String, java.lang.Object>> getData();
    
    /**
     * TestDataSource as [TestDataSource] type
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.testdata.common.TestDataSource getDataSource();
}