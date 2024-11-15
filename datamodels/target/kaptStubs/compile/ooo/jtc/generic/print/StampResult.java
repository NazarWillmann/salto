package ooo.jtc.generic.print;

import java.lang.System;

/**
 * Relation between a status [T] and a stamp result [stampResult] at print form.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u0000*\u000e\b\u0000\u0010\u0001 \u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Looo/jtc/generic/print/StampResult;", "T", "Looo/jtc/documents/IDocumentStatus;", "", "stampResult", "", "getStampResult", "()Ljava/lang/String;", "statuses", "", "getStatuses", "()Ljava/util/List;", "datamodels"})
public abstract interface StampResult<T extends ooo.jtc.documents.IDocumentStatus<?>> {
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getStampResult();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<T> getStatuses();
}