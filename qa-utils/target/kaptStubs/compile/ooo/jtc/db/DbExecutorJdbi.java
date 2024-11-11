package ooo.jtc.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00110\u00102\u0006\u0010\u0012\u001a\u00020\bJ,\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0010\"\b\b\u0000\u0010\u0013*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015J:\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0010\"\b\b\u0000\u0010\u0013*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0017JD\u0010\u000f\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u0012\u001a\u00020\b2)\u0010\u0018\u001a%\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00110\u0010\u0012\u0004\u0012\u0002H\u00130\u0019\u00a2\u0006\u0002\b\u001a\u00a2\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0012\u001a\u00020\bJZ\u0010\u001e\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132\u0006\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2+\b\u0002\u0010\u0018\u001a%\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00110\u0010\u0012\u0004\u0012\u0002H\u00130\u0019\u00a2\u0006\u0002\b\u001a\u00a2\u0006\u0002\u0010\"J+\u0010#\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015\u00a2\u0006\u0002\u0010$R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006%"}, d2 = {"Looo/jtc/db/DbExecutorJdbi;", "", "dbSchema", "Looo/jtc/db/DbSchema;", "dbConnectionInfo", "Looo/jtc/db/DbConnectionInfo;", "(Looo/jtc/db/DbSchema;Looo/jtc/db/DbConnectionInfo;)V", "dbType", "", "jdbi", "Lorg/jdbi/v3/core/Jdbi;", "getJdbi", "()Lorg/jdbi/v3/core/Jdbi;", "jdbi$delegate", "Lkotlin/Lazy;", "execSql", "", "", "sql", "T", "modelClass", "Ljava/lang/Class;", "mapper", "Lorg/jdbi/v3/core/mapper/RowMapper;", "extracting", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "execute", "", "select", "table", "fields", "where", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "selectFirst", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "qa-utils"})
public final class DbExecutorJdbi {
    private final java.lang.String dbType = "postgresql";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy jdbi$delegate = null;
    private final ooo.jtc.db.DbSchema dbSchema = null;
    private final ooo.jtc.db.DbConnectionInfo dbConnectionInfo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final org.jdbi.v3.core.Jdbi getJdbi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.util.Map<java.lang.String, java.lang.Object>> execSql(@org.jetbrains.annotations.NotNull()
    java.lang.String sql) {
        return null;
    }
    
    public final void execute(@org.jetbrains.annotations.NotNull()
    java.lang.String sql) {
    }
    
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public final <T extends java.lang.Object>T select(@org.jetbrains.annotations.NotNull()
    java.lang.String table, @org.jetbrains.annotations.NotNull()
    java.lang.String fields, @org.jetbrains.annotations.NotNull()
    java.lang.String where, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>, ? extends T> extracting) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>T selectFirst(@org.jetbrains.annotations.NotNull()
    java.lang.String sql, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.util.List<T> execSql(@org.jetbrains.annotations.NotNull()
    java.lang.String sql, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.Object>java.util.List<T> execSql(@org.jetbrains.annotations.NotNull()
    java.lang.String sql, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> modelClass, @org.jetbrains.annotations.NotNull()
    org.jdbi.v3.core.mapper.RowMapper<T> mapper) {
        return null;
    }
    
    public final <T extends java.lang.Object>T execSql(@org.jetbrains.annotations.NotNull()
    java.lang.String sql, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<? extends java.util.Map<java.lang.String, java.lang.Object>>, ? extends T> extracting) {
        return null;
    }
    
    public DbExecutorJdbi(@org.jetbrains.annotations.NotNull()
    ooo.jtc.db.DbSchema dbSchema, @org.jetbrains.annotations.NotNull()
    ooo.jtc.db.DbConnectionInfo dbConnectionInfo) {
        super();
    }
}