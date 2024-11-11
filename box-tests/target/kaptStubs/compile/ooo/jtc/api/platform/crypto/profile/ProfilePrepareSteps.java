package ooo.jtc.api.platform.crypto.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J.\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u00a8\u0006\u000f"}, d2 = {"Looo/jtc/api/platform/crypto/profile/ProfilePrepareSteps;", "", "()V", "getProfileDtoForUpdate", "Looo/jtc/crypto/ProfileDto;", "profileDto", "getProfileDtoForUserForCreate", "bankUser", "Looo/jtc/uaa/User;", "authOnly", "", "profileType", "Looo/jtc/crypto/ProfileType;", "state", "", "box-tests"})
public final class ProfilePrepareSteps {
    public static final ooo.jtc.api.platform.crypto.profile.ProfilePrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \'\u041f\u0440\u043e\u0444\u0438\u043b\u044c\' DTO \u0434\u043b\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f {bankUser.login}")
    public final ooo.jtc.crypto.ProfileDto getProfileDtoForUserForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser, boolean authOnly, @org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileType profileType, @org.jetbrains.annotations.NotNull()
    java.lang.String state) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.crypto.ProfileDto getProfileDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.crypto.ProfileDto profileDto) {
        return null;
    }
    
    private ProfilePrepareSteps() {
        super();
    }
}