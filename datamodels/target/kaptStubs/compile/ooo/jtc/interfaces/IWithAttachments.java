package ooo.jtc.interfaces;

import java.lang.System;

/**
 * IWithAttachments.
 * Interface for entities/documents with attachments.
 * Used mostly in *TestTemplates for null-ing attachments' access tokens
 * via call to [List &lt AttachmentDto &gt ?.nullAccessTokens()]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003R \u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0005X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Looo/jtc/interfaces/IWithAttachments;", "A", "Looo/jtc/generic/attachments/AttachmentDto;", "", "attachments", "", "getAttachments", "()Ljava/util/List;", "setAttachments", "(Ljava/util/List;)V", "datamodels"})
public abstract interface IWithAttachments<A extends ooo.jtc.generic.attachments.AttachmentDto> {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.List<A> getAttachments();
    
    public abstract void setAttachments(@org.jetbrains.annotations.Nullable()
    java.util.List<? extends A> p0);
}