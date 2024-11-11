package ooo.jtc.api.dictionaries.timezone;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/api/dictionaries/timezone/TimezoneSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/timezone/TimezoneDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "getTimezoneByName", "Looo/jtc/generic/GenericResponseDto;", "name", "", "withCheckResponseCode", "", "statusCode", "", "getTimezonesByShift", "Looo/jtc/generic/GenericListResponseDto;", "shift", "box-tests"})
public final class TimezoneSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.timezone.TimezoneDto, ooo.jtc.dictionaries.timezone.TimezoneDto> {
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0447\u0430\u0441\u043e\u0432\u043e\u0439 \u043f\u043e\u044f\u0441 \u043d\u043e \u0435\u0433\u043e \u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u044e \'{name}\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.timezone.TimezoneDto> getTimezoneByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0432\u0441\u0435 \u0447\u0430\u0441\u043e\u0432\u044b\u0435 \u043f\u043e\u044f\u0441\u0430 \u0441\u043e \u0441\u0434\u0432\u0438\u0433\u043e\u043c \'{shift}\'")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.dictionaries.timezone.TimezoneDto> getTimezonesByShift(int shift, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public TimezoneSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}