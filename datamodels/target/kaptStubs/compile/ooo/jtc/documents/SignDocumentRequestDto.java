package ooo.jtc.documents;

import java.lang.System;

/**
 * Request for singing document
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\nH\u00c6\u0003JG\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006+"}, d2 = {"Looo/jtc/documents/SignDocumentRequestDto;", "", "digest", "", "documentId", "Ljava/util/UUID;", "signature", "signToolId", "signToolRef", "version", "", "(Ljava/lang/String;Ljava/util/UUID;Ljava/lang/String;Ljava/util/UUID;Ljava/util/UUID;J)V", "getDigest", "()Ljava/lang/String;", "setDigest", "(Ljava/lang/String;)V", "getDocumentId", "()Ljava/util/UUID;", "setDocumentId", "(Ljava/util/UUID;)V", "getSignToolId", "setSignToolId", "getSignToolRef", "setSignToolRef", "getSignature", "setSignature", "getVersion", "()J", "setVersion", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "datamodels"})
public final class SignDocumentRequestDto {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String digest;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID documentId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String signature;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID signToolId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID signToolRef;
    private long version;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDigest() {
        return null;
    }
    
    public final void setDigest(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getDocumentId() {
        return null;
    }
    
    public final void setDocumentId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSignature() {
        return null;
    }
    
    public final void setSignature(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getSignToolId() {
        return null;
    }
    
    public final void setSignToolId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getSignToolRef() {
        return null;
    }
    
    public final void setSignToolRef(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    public final long getVersion() {
        return 0L;
    }
    
    public final void setVersion(long p0) {
    }
    
    public SignDocumentRequestDto(@org.jetbrains.annotations.NotNull()
    java.lang.String digest, @org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, @org.jetbrains.annotations.NotNull()
    java.lang.String signature, @org.jetbrains.annotations.NotNull()
    java.util.UUID signToolId, @org.jetbrains.annotations.Nullable()
    java.util.UUID signToolRef, long version) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    /**
     * Request for singing document
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.documents.SignDocumentRequestDto copy(@org.jetbrains.annotations.NotNull()
    java.lang.String digest, @org.jetbrains.annotations.NotNull()
    java.util.UUID documentId, @org.jetbrains.annotations.NotNull()
    java.lang.String signature, @org.jetbrains.annotations.NotNull()
    java.util.UUID signToolId, @org.jetbrains.annotations.Nullable()
    java.util.UUID signToolRef, long version) {
        return null;
    }
    
    /**
     * Request for singing document
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Request for singing document
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Request for singing document
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}