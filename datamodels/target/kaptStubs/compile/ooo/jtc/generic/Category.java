package ooo.jtc.generic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003J\u001c\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\t2\u0006\u0010\u000b\u001a\u00020\fH&R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\r"}, d2 = {"Looo/jtc/generic/Category;", "T", "Looo/jtc/interfaces/IDocument;", "", "category", "", "getCategory", "()Ljava/lang/String;", "getStatuses", "", "Looo/jtc/documents/IDocumentStatus;", "userType", "Looo/jtc/uaa/UserType;", "datamodels"})
public abstract interface Category<T extends ooo.jtc.interfaces.IDocument> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getCategory();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<ooo.jtc.documents.IDocumentStatus<T>> getStatuses(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType);
}