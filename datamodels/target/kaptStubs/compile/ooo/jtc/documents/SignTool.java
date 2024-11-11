package ooo.jtc.documents;

import java.lang.System;

/**
 * Signature tool
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\rH\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J[\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020\rH\u00d6\u0001J\t\u0010)\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006*"}, d2 = {"Looo/jtc/documents/SignTool;", "", "enabled", "", "id", "Ljava/util/UUID;", "signKind", "Looo/jtc/documents/SignKind;", "signKindId", "toolType", "", "userId", "version", "", "refId", "(ZLjava/util/UUID;Looo/jtc/documents/SignKind;Ljava/util/UUID;Ljava/lang/String;Ljava/util/UUID;ILjava/util/UUID;)V", "getEnabled", "()Z", "getId", "()Ljava/util/UUID;", "getRefId", "getSignKind", "()Looo/jtc/documents/SignKind;", "getSignKindId", "getToolType", "()Ljava/lang/String;", "getUserId", "getVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "datamodels"})
public final class SignTool {
    private final boolean enabled = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.UUID id = null;
    @org.jetbrains.annotations.NotNull()
    private final ooo.jtc.documents.SignKind signKind = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.UUID signKindId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String toolType = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.UUID userId = null;
    private final int version = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.util.UUID refId = null;
    
    public final boolean getEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.documents.SignKind getSignKind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getSignKindId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getToolType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUserId() {
        return null;
    }
    
    public final int getVersion() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getRefId() {
        return null;
    }
    
    public SignTool(boolean enabled, @org.jetbrains.annotations.NotNull()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.SignKind signKind, @org.jetbrains.annotations.NotNull()
    java.util.UUID signKindId, @org.jetbrains.annotations.NotNull()
    java.lang.String toolType, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId, int version, @org.jetbrains.annotations.Nullable()
    java.util.UUID refId) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.documents.SignKind component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component6() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component8() {
        return null;
    }
    
    /**
     * Signature tool
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.documents.SignTool copy(boolean enabled, @org.jetbrains.annotations.NotNull()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.SignKind signKind, @org.jetbrains.annotations.NotNull()
    java.util.UUID signKindId, @org.jetbrains.annotations.NotNull()
    java.lang.String toolType, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId, int version, @org.jetbrains.annotations.Nullable()
    java.util.UUID refId) {
        return null;
    }
    
    /**
     * Signature tool
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Signature tool
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Signature tool
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}