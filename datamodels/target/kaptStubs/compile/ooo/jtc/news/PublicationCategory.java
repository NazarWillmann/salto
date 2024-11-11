package ooo.jtc.news;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014\u00a8\u0006\u0016"}, d2 = {"Looo/jtc/news/PublicationCategory;", "", "Looo/jtc/generic/Category;", "Looo/jtc/news/dto/PublicationDto;", "category", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "getStatuses", "", "Looo/jtc/documents/IDocumentStatus;", "userType", "Looo/jtc/uaa/UserType;", "ALL", "PROBLEMATIC", "WAITING_POST_DATE", "COMPLETED", "DRAFT", "POSTED", "FOR_POST", "Companion", "datamodels"})
public enum PublicationCategory implements ooo.jtc.generic.Category<ooo.jtc.news.dto.PublicationDto> {
    /*public static final*/ ALL /* = new ALL(null) */,
    /*public static final*/ PROBLEMATIC /* = new PROBLEMATIC(null) */,
    /*public static final*/ WAITING_POST_DATE /* = new WAITING_POST_DATE(null) */,
    /*public static final*/ COMPLETED /* = new COMPLETED(null) */,
    /*public static final*/ DRAFT /* = new DRAFT(null) */,
    /*public static final*/ POSTED /* = new POSTED(null) */,
    /*public static final*/ FOR_POST /* = new FOR_POST(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    
    /**
     * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733768
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<ooo.jtc.news.PublicationCategory, java.util.List<ooo.jtc.news.PublicationStatus>> bankCategoriesAndStatuses = null;
    
    /**
     * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21726777
     */
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<ooo.jtc.news.PublicationCategory, java.util.List<ooo.jtc.news.PublicationStatus>> clientCategoriesAndStatuses = null;
    public static final ooo.jtc.news.PublicationCategory.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<ooo.jtc.documents.IDocumentStatus<ooo.jtc.news.dto.PublicationDto>> getStatuses(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getCategory() {
        return null;
    }
    
    PublicationCategory(java.lang.String category) {
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Looo/jtc/news/PublicationCategory$Companion;", "", "()V", "bankCategoriesAndStatuses", "", "Looo/jtc/news/PublicationCategory;", "", "Looo/jtc/news/PublicationStatus;", "getBankCategoriesAndStatuses", "()Ljava/util/Map;", "clientCategoriesAndStatuses", "getClientCategoriesAndStatuses", "datamodels"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<ooo.jtc.news.PublicationCategory, java.util.List<ooo.jtc.news.PublicationStatus>> getBankCategoriesAndStatuses() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Map<ooo.jtc.news.PublicationCategory, java.util.List<ooo.jtc.news.PublicationStatus>> getClientCategoriesAndStatuses() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}