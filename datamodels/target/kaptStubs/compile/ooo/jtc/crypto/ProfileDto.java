package ooo.jtc.crypto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\tH\u00c6\u0003J\t\u0010(\u001a\u00020\u000bH\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003JG\u0010*\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010+\u001a\u00020\u00072\b\u0010,\u001a\u0004\u0018\u00010-H\u00d6\u0003J\t\u0010.\u001a\u00020\u0005H\u00d6\u0001J\b\u0010/\u001a\u000200H\u0016J\t\u00101\u001a\u00020\u000bH\u00d6\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u00062"}, d2 = {"Looo/jtc/crypto/ProfileDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "authOnly", "", "profileType", "Looo/jtc/crypto/ProfileType;", "state", "", "userId", "(Ljava/util/UUID;IZLooo/jtc/crypto/ProfileType;Ljava/lang/String;Ljava/util/UUID;)V", "getAuthOnly", "()Z", "setAuthOnly", "(Z)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getProfileType", "()Looo/jtc/crypto/ProfileType;", "setProfileType", "(Looo/jtc/crypto/ProfileType;)V", "getState", "()Ljava/lang/String;", "setState", "(Ljava/lang/String;)V", "getUserId", "setUserId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "", "hashCode", "toModel", "Looo/jtc/crypto/Profile;", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u041f\u0440\u043e\u0444\u0438\u043b\u044c")
@com.github.pozo.KotlinBuilder()
public final class ProfileDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.crypto.ProfileDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    private boolean authOnly;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.crypto.ProfileType profileType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String state;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID userId;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.crypto.Profile toModel() {
        return null;
    }
    
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
    
    public final boolean getAuthOnly() {
        return false;
    }
    
    public final void setAuthOnly(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.ProfileType getProfileType() {
        return null;
    }
    
    public final void setProfileType(@org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getState() {
        return null;
    }
    
    public final void setState(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    public ProfileDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, boolean authOnly, @org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType profileType, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.ProfileType component4() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.ProfileDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, boolean authOnly, @org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType profileType, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.util.UUID userId) {
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