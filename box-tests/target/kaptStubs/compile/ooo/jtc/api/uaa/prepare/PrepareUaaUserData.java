package ooo.jtc.api.uaa.prepare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0007J\u0014\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0010\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0002Jv\u0010\u0013\u001a\u00020\n2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00122\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\""}, d2 = {"Looo/jtc/api/uaa/prepare/PrepareUaaUserData;", "", "()V", "defaultBlockedUserId", "Ljava/util/UUID;", "getDefaultBlockedUserId", "()Ljava/util/UUID;", "defaultBlockedUserId$delegate", "Lkotlin/Lazy;", "createUaaUser", "Looo/jtc/uaa/user/dto/UaaUserDto;", "dtoForCreate", "getUaaUserDtoForUpdate", "createdDto", "preparePermBlockedUaaUserDtoForCreate", "blockedUserId", "prepareTempBlockedUaaUserDtoForCreate", "prepareTestUserDetails", "Looo/jtc/uaa/user/dto/UserDetails;", "prepareUaaUserDtoForCreate", "scopes", "", "userDetails", "preferredLocale", "", "blockReason", "blockUser", "scopeDetails", "Looo/jtc/uaa/scope/dto/ScopeDetails;", "permanentBlocked", "", "temporaryBlocked", "temporaryBlockedUntil", "Ljava/time/ZonedDateTime;", "box-tests"})
public final class PrepareUaaUserData {
    private static final kotlin.Lazy defaultBlockedUserId$delegate = null;
    public static final ooo.jtc.api.uaa.prepare.PrepareUaaUserData INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0442\u0435\u0441\u0442\u043e\u0432\u044b\u0439 \'\u0423\u0430\u0430\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c\' \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e")
    public final ooo.jtc.uaa.user.dto.UaaUserDto prepareUaaUserDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> scopes, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.user.dto.UserDetails userDetails, @org.jetbrains.annotations.NotNull()
    java.lang.String preferredLocale, @org.jetbrains.annotations.Nullable()
    java.lang.String blockReason, @org.jetbrains.annotations.Nullable()
    java.util.UUID blockUser, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.uaa.scope.dto.ScopeDetails> scopeDetails, boolean permanentBlocked, boolean temporaryBlocked, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime temporaryBlockedUntil) {
        return null;
    }
    
    private final ooo.jtc.uaa.user.dto.UserDetails prepareTestUserDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \'\u0423\u0430\u0430\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c\' \u0434\u043b\u044f \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u044f")
    public final ooo.jtc.uaa.user.dto.UaaUserDto getUaaUserDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.user.dto.UaaUserDto createdDto) {
        return null;
    }
    
    private final java.util.UUID getDefaultBlockedUserId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0437\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u043e\u0433\u043e \'\u0423\u0430\u0430\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c\'")
    public final ooo.jtc.uaa.user.dto.UaaUserDto preparePermBlockedUaaUserDtoForCreate(@org.jetbrains.annotations.Nullable()
    java.util.UUID blockedUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0432\u0440\u0435\u043c\u0435\u043d\u043d\u043e \u0437\u0430\u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u043e\u0433\u043e \'\u0423\u0430\u0430\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c\'")
    public final ooo.jtc.uaa.user.dto.UaaUserDto prepareTempBlockedUaaUserDtoForCreate(@org.jetbrains.annotations.Nullable()
    java.util.UUID blockedUserId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0423\u0430\u0430\u041f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f {dtoForCreate.id}")
    public final ooo.jtc.uaa.user.dto.UaaUserDto createUaaUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.user.dto.UaaUserDto dtoForCreate) {
        return null;
    }
    
    private PrepareUaaUserData() {
        super();
    }
}