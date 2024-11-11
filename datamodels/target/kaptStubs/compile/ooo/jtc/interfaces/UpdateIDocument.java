package ooo.jtc.interfaces;

import java.lang.System;

/**
 * Interface-marker.
 * Mark Document which uses for update [T] Document.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003\u00a8\u0006\u0004"}, d2 = {"Looo/jtc/interfaces/UpdateIDocument;", "T", "Looo/jtc/interfaces/IDocument;", "Looo/jtc/interfaces/UpdateIEntityDto;", "datamodels"})
public abstract interface UpdateIDocument<T extends ooo.jtc.interfaces.IDocument> extends ooo.jtc.interfaces.IDocument, ooo.jtc.interfaces.UpdateIEntityDto<T> {
    
    /**
     * Interface-marker.
     * Mark Document which uses for update [T] Document.
     */
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @java.lang.Override()
        public static <T extends ooo.jtc.interfaces.IDocument>boolean isInStatus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.UpdateIDocument<T> $this, @org.jetbrains.annotations.NotNull()
        java.lang.String... statuses) {
            return false;
        }
        
        @java.lang.Override()
        public static <T extends ooo.jtc.interfaces.IDocument>boolean isInStatus(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.UpdateIDocument<T> $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.IDocumentStatus<? extends ooo.jtc.interfaces.IDocument>... statuses) {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static <T extends ooo.jtc.interfaces.IDocument>java.lang.String getEntityName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.UpdateIDocument<T> $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        @com.fasterxml.jackson.annotation.JsonIgnore()
        public static <T extends ooo.jtc.interfaces.IDocument>ooo.jtc.interfaces.ITransferEntity toModel(@org.jetbrains.annotations.NotNull()
        ooo.jtc.interfaces.UpdateIDocument<T> $this) {
            return null;
        }
    }
}