package ooo.jtc.api.platform.crypto.profile;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u001b\u0010\u0006\u001a\u00020\u00078TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Looo/jtc/api/platform/crypto/profile/ProfileSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/crypto/ProfileDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "servicePath", "", "getServicePath", "()Ljava/lang/String;", "servicePath$delegate", "Lkotlin/Lazy;", "getByUserId", "Looo/jtc/generic/GenericListResponseDto;", "userId", "Ljava/util/UUID;", "box-tests"})
public final class ProfileSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.crypto.ProfileDto, ooo.jtc.crypto.ProfileDto> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy servicePath$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getServicePath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \'\u041f\u0440\u043e\u0444\u0438\u043b\u044c\' \u043f\u043e id \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.crypto.ProfileDto> getByUserId(@org.jetbrains.annotations.NotNull()
    java.util.UUID userId) {
        return null;
    }
    
    public ProfileSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
    
    public ProfileSteps() {
        super(null, null, null, null);
    }
}