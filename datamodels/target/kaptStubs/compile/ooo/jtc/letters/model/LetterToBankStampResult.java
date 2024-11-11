package ooo.jtc.letters.model;

import java.lang.System;

/**
 * Relation between a status [LetterToBankStatus] and a stamp result [stampResult] at print form.
 * https://confluence.jtc.ooo/pages/viewpage.action?pageId=21729817
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u00a2\u0006\u0002\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/letters/model/LetterToBankStampResult;", "", "Looo/jtc/generic/print/StampResult;", "Looo/jtc/letters/model/LetterToBankStatus;", "stampResult", "", "statuses", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "getStampResult", "()Ljava/lang/String;", "getStatuses", "()Ljava/util/List;", "RECEIVED", "REJECTED", "PROCESSED", "RECALLED", "datamodels"})
public enum LetterToBankStampResult implements ooo.jtc.generic.print.StampResult<ooo.jtc.letters.model.LetterToBankStatus> {
    /*public static final*/ RECEIVED /* = new RECEIVED(null, null) */,
    /*public static final*/ REJECTED /* = new REJECTED(null, null) */,
    /*public static final*/ PROCESSED /* = new PROCESSED(null, null) */,
    /*public static final*/ RECALLED /* = new RECALLED(null, null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String stampResult = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<ooo.jtc.letters.model.LetterToBankStatus> statuses = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getStampResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<ooo.jtc.letters.model.LetterToBankStatus> getStatuses() {
        return null;
    }
    
    LetterToBankStampResult(java.lang.String stampResult, java.util.List<? extends ooo.jtc.letters.model.LetterToBankStatus> statuses) {
    }
}