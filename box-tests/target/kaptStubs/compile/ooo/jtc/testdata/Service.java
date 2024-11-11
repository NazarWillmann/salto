package ooo.jtc.testdata;

import java.lang.System;

/**
 * Service information, created from service info [ServiceInfo] and [DbSchema]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Looo/jtc/testdata/Service;", "", "serviceInfo", "Looo/jtc/core/ServiceInfo;", "dbSchema", "Looo/jtc/db/DbSchema;", "(Looo/jtc/core/ServiceInfo;Looo/jtc/db/DbSchema;)V", "baseEndpoint", "", "getBaseEndpoint", "()Ljava/lang/String;", "setBaseEndpoint", "(Ljava/lang/String;)V", "db", "Looo/jtc/db/DbExecutorJdbi;", "getDb", "()Looo/jtc/db/DbExecutorJdbi;", "db$delegate", "Lkotlin/Lazy;", "getDbSchema", "()Looo/jtc/db/DbSchema;", "setDbSchema", "(Looo/jtc/db/DbSchema;)V", "port", "", "getPort", "()I", "setPort", "(I)V", "box-tests"})
public final class Service {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String baseEndpoint;
    private int port;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy db$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.db.DbSchema dbSchema;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBaseEndpoint() {
        return null;
    }
    
    public final void setBaseEndpoint(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int getPort() {
        return 0;
    }
    
    public final void setPort(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.db.DbExecutorJdbi getDb() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.db.DbSchema getDbSchema() {
        return null;
    }
    
    public final void setDbSchema(@org.jetbrains.annotations.NotNull()
    ooo.jtc.db.DbSchema p0) {
    }
    
    public Service(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.ServiceInfo serviceInfo, @org.jetbrains.annotations.NotNull()
    ooo.jtc.db.DbSchema dbSchema) {
        super();
    }
}