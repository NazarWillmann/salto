package ooo.jtc.documents;

import java.lang.System;

/**
 * Signature change (signing/removing signature) applicability
 * Request DTO
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Looo/jtc/documents/GetSignChangeApplicability;", "", "documents", "", "Ljava/util/UUID;", "actionName", "", "(Ljava/util/List;Ljava/lang/String;)V", "getActionName", "()Ljava/lang/String;", "getDocuments", "()Ljava/util/List;", "setDocuments", "(Ljava/util/List;)V", "datamodels"})
public class GetSignChangeApplicability {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.util.UUID> documents;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String actionName = null;
    
    @org.jetbrains.annotations.NotNull()
    public java.util.List<java.util.UUID> getDocuments() {
        return null;
    }
    
    public void setDocuments(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActionName() {
        return null;
    }
    
    public GetSignChangeApplicability(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> documents, @org.jetbrains.annotations.NotNull()
    java.lang.String actionName) {
        super();
    }
}