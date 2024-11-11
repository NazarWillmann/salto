package ooo.jtc.uaa;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u00020\u0015X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u0015X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u0018\u0010\u001b\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R\u0018\u0010\u001e\u001a\u00020\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\u0005\"\u0004\b \u0010\u0007R\u001a\u0010!\u001a\u0004\u0018\u00010\tX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010\rR\u001a\u0010$\u001a\u0004\u0018\u00010%X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020+X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00100\u001a\u000201X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00066"}, d2 = {"Looo/jtc/uaa/User;", "Looo/jtc/interfaces/IEntity;", "bearer", "", "getBearer", "()Ljava/lang/String;", "setBearer", "(Ljava/lang/String;)V", "catalogId", "Ljava/util/UUID;", "getCatalogId", "()Ljava/util/UUID;", "setCatalogId", "(Ljava/util/UUID;)V", "domain", "getDomain", "setDomain", "id", "getId", "setId", "isBank", "", "()Z", "setBank", "(Z)V", "isClient", "setClient", "login", "getLogin", "setLogin", "password", "getPassword", "setPassword", "uaaUserId", "getUaaUserId", "setUaaUserId", "userDetails", "Looo/jtc/uaa/user/dto/UserDetails;", "getUserDetails", "()Looo/jtc/uaa/user/dto/UserDetails;", "setUserDetails", "(Looo/jtc/uaa/user/dto/UserDetails;)V", "userType", "Looo/jtc/uaa/UserType;", "getUserType", "()Looo/jtc/uaa/UserType;", "setUserType", "(Looo/jtc/uaa/UserType;)V", "version", "", "getVersion", "()I", "setVersion", "(I)V", "datamodels"})
public abstract interface User extends ooo.jtc.interfaces.IEntity {
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public abstract java.util.UUID getId();
    
    @java.lang.Override()
    public abstract void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0);
    
    @java.lang.Override()
    public abstract int getVersion();
    
    @java.lang.Override()
    public abstract void setVersion(int p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getLogin();
    
    public abstract void setLogin(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getPassword();
    
    public abstract void setPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.UUID getCatalogId();
    
    public abstract void setCatalogId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDomain();
    
    public abstract void setDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.uaa.UserType getUserType();
    
    public abstract void setUserType(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getBearer();
    
    public abstract void setBearer(@org.jetbrains.annotations.Nullable()
    java.lang.String p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract ooo.jtc.uaa.user.dto.UserDetails getUserDetails();
    
    public abstract void setUserDetails(@org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.user.dto.UserDetails p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.UUID getUaaUserId();
    
    public abstract void setUaaUserId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0);
    
    public abstract boolean isBank();
    
    public abstract void setBank(boolean p0);
    
    public abstract boolean isClient();
    
    public abstract void setClient(boolean p0);
}