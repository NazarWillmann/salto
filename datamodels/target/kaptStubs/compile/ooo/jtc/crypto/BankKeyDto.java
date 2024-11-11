package ooo.jtc.crypto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\n\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\u0002\u0010\u0011J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00c6\u0003Js\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u00c6\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003J\t\u0010;\u001a\u00020\u0005H\u00d6\u0001J\t\u0010<\u001a\u00020\nH\u00d6\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\r\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b\'\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006="}, d2 = {"Looo/jtc/crypto/BankKeyDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "profileType", "Looo/jtc/crypto/ProfileType;", "userId", "storageName", "", "storagePassword", "alias", "keyPassword", "keyParameters", "", "", "(Ljava/util/UUID;ILooo/jtc/crypto/ProfileType;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAlias", "()Ljava/lang/String;", "setAlias", "(Ljava/lang/String;)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getKeyParameters", "()Ljava/util/List;", "setKeyParameters", "(Ljava/util/List;)V", "getKeyPassword", "setKeyPassword", "getProfileType", "()Looo/jtc/crypto/ProfileType;", "setProfileType", "(Looo/jtc/crypto/ProfileType;)V", "getStorageName", "setStorageName", "getStoragePassword", "setStoragePassword", "getUserId", "setUserId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u0411\u0430\u043d\u043a\u043e\u0432\u0441\u043a\u0438\u0439 \u043a\u043b\u044e\u0447")
@com.github.pozo.KotlinBuilder()
public final class BankKeyDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.crypto.BankKeyDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.crypto.ProfileType profileType;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID userId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String storageName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String storagePassword;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String alias;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String keyPassword;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends java.lang.Object> keyParameters;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.UUID getId() {
        return null;
    }
    
    @java.lang.Override()
    public void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @java.lang.Override()
    public int getVersion() {
        return 0;
    }
    
    @java.lang.Override()
    public void setVersion(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.ProfileType getProfileType() {
        return null;
    }
    
    public final void setProfileType(@org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStorageName() {
        return null;
    }
    
    public final void setStorageName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStoragePassword() {
        return null;
    }
    
    public final void setStoragePassword(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAlias() {
        return null;
    }
    
    public final void setAlias(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getKeyPassword() {
        return null;
    }
    
    public final void setKeyPassword(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> getKeyParameters() {
        return null;
    }
    
    public final void setKeyParameters(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> p0) {
    }
    
    public BankKeyDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType profileType, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId, @org.jetbrains.annotations.Nullable()
    java.lang.String storageName, @org.jetbrains.annotations.Nullable()
    java.lang.String storagePassword, @org.jetbrains.annotations.Nullable()
    java.lang.String alias, @org.jetbrains.annotations.Nullable()
    java.lang.String keyPassword, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> keyParameters) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public ooo.jtc.interfaces.ITransferEntity toModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.ProfileType component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Object> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.BankKeyDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType profileType, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId, @org.jetbrains.annotations.Nullable()
    java.lang.String storageName, @org.jetbrains.annotations.Nullable()
    java.lang.String storagePassword, @org.jetbrains.annotations.Nullable()
    java.lang.String alias, @org.jetbrains.annotations.Nullable()
    java.lang.String keyPassword, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.lang.Object> keyParameters) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}