package ooo.jtc.core.kexensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006\u001a\u001f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002\u00a2\u0006\u0002\u0010\n\u001a#\u0010\u000b\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000e\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000e\u001a\u0019\u0010\u0011\u001a\u00020\u0005\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002\u00a2\u0006\u0002\u0010\u0012\u001a\n\u0010\u0011\u001a\u00020\u0005*\u00020\u0013\u001a7\u0010\u0014\u001a\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\u0002\u0010\u001b\u001a\u0019\u0010\u001c\u001a\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002\u00a2\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001e\u001a\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u0002\u00a2\u0006\u0002\u0010\u001d\u00a8\u0006\u001f"}, d2 = {"checkIsBankUser", "", "T", "Looo/jtc/uaa/User;", "message", "", "(Looo/jtc/uaa/User;Ljava/lang/String;)V", "checkIsClientUser", "getAvailableCNList", "", "(Looo/jtc/uaa/User;)Ljava/util/List;", "getBankRepresentativePhone", "branchId", "Ljava/util/UUID;", "(Looo/jtc/uaa/User;Ljava/util/UUID;)Ljava/lang/String;", "getClientRepresentativePhone", "customerId", "getFio", "(Looo/jtc/uaa/User;)Ljava/lang/String;", "Looo/jtc/uaa/user/dto/UserDetails;", "invokeAuth", "mfaType", "Looo/jtc/uaa/MfaType;", "defaultCatalog", "Looo/jtc/uaa/catalog/model/DefaultCatalog;", "newToken", "", "(Looo/jtc/uaa/User;Looo/jtc/uaa/MfaType;Looo/jtc/uaa/catalog/model/DefaultCatalog;Z)Looo/jtc/uaa/User;", "retrieveBankUser", "(Looo/jtc/uaa/User;)Looo/jtc/uaa/User;", "retrieveClientUser", "box-tests"})
public final class UserExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final synchronized <T extends ooo.jtc.uaa.User>ooo.jtc.uaa.User invokeAuth(@org.jetbrains.annotations.NotNull()
    T $this$invokeAuth, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.MfaType mfaType, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.catalog.model.DefaultCatalog defaultCatalog, boolean newToken) {
        return null;
    }
    
    public static final <T extends ooo.jtc.uaa.User>void checkIsBankUser(@org.jetbrains.annotations.NotNull()
    T $this$checkIsBankUser, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    public static final <T extends ooo.jtc.uaa.User>void checkIsClientUser(@org.jetbrains.annotations.NotNull()
    T $this$checkIsClientUser, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends ooo.jtc.uaa.User>ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    T $this$retrieveClientUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends ooo.jtc.uaa.User>ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    T $this$retrieveBankUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends ooo.jtc.uaa.User>java.lang.String getFio(@org.jetbrains.annotations.NotNull()
    T $this$getFio) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getFio(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.user.dto.UserDetails $this$getFio) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends ooo.jtc.uaa.User>java.lang.String getClientRepresentativePhone(@org.jetbrains.annotations.NotNull()
    T $this$getClientRepresentativePhone, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final <T extends ooo.jtc.uaa.User>java.lang.String getBankRepresentativePhone(@org.jetbrains.annotations.NotNull()
    T $this$getBankRepresentativePhone, @org.jetbrains.annotations.NotNull()
    java.util.UUID branchId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends ooo.jtc.uaa.User>java.util.List<java.lang.String> getAvailableCNList(@org.jetbrains.annotations.NotNull()
    T $this$getAvailableCNList) {
        return null;
    }
}