package ooo.jtc.uaa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e\u00a8\u0006\u0010"}, d2 = {"Looo/jtc/uaa/UserType;", "", "pathPrefix", "", "catalogs", "", "Looo/jtc/uaa/catalog/model/DefaultCatalog;", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getCatalogs", "()Ljava/util/List;", "getPathPrefix", "()Ljava/lang/String;", "BANK", "CLIENT", "INDIVIDUAL", "Companion", "datamodels"})
public enum UserType {
    /*public static final*/ BANK /* = new BANK(null, null) */,
    /*public static final*/ CLIENT /* = new CLIENT(null, null) */,
    /*public static final*/ INDIVIDUAL /* = new INDIVIDUAL(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String pathPrefix = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<ooo.jtc.uaa.catalog.model.DefaultCatalog> catalogs = null;
    public static final ooo.jtc.uaa.UserType.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPathPrefix() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.uaa.catalog.model.DefaultCatalog> getCatalogs() {
        return null;
    }
    
    UserType(java.lang.String pathPrefix, java.util.List<? extends ooo.jtc.uaa.catalog.model.DefaultCatalog> catalogs) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/uaa/UserType$Companion;", "", "()V", "getByCatalog", "Looo/jtc/uaa/UserType;", "defaultCatalog", "Looo/jtc/uaa/catalog/model/DefaultCatalog;", "datamodels"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final ooo.jtc.uaa.UserType getByCatalog(@org.jetbrains.annotations.NotNull()
        ooo.jtc.uaa.catalog.model.DefaultCatalog defaultCatalog) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}