package ooo.jtc.api.dictionaries.ground;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J6\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/dictionaries/ground/GroundSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/ground/GroundDto;", "Looo/jtc/dictionaries/ground/GroundUpdateRequest;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "getListForContractor", "Looo/jtc/generic/GenericListResponseDto;", "contractorId", "Ljava/util/UUID;", "withCheckResponseCode", "", "statusCode", "", "getPageForContractor", "Looo/jtc/generic/GenericPageResponseDto;", "params", "Looo/jtc/generic/pageparams/Params;", "box-tests"})
public final class GroundSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.ground.GroundDto, ooo.jtc.dictionaries.ground.GroundUpdateRequest> {
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u043e\u0432 \u043f\u043e ID \'{contractorId}\'")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.dictionaries.ground.GroundDto> getListForContractor(@org.jetbrains.annotations.Nullable()
    java.util.UUID contractorId, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u043e\u0432 \u043f\u043e ID \'{contractorId}\'")
    public final ooo.jtc.generic.GenericPageResponseDto<ooo.jtc.dictionaries.ground.GroundDto> getPageForContractor(@org.jetbrains.annotations.Nullable()
    java.util.UUID contractorId, boolean withCheckResponseCode, int statusCode, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params params) {
        return null;
    }
    
    public GroundSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}