package ooo.jtc.api.dictionaries.stmntoperationtype;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J*\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007J*\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00a8\u0006\u0015"}, d2 = {"Looo/jtc/api/dictionaries/stmntoperationtype/StatementOperationTypeSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/stmntoperationtype/StatementOperationTypeDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "deleteSoTypeByDescription", "", "description", "", "withCheckResponseCode", "", "statusCode", "", "getSoTypeByCode", "Looo/jtc/generic/GenericResponseDto;", "code", "getSoTypeByDescription", "validateSoTypeById", "id", "Ljava/util/UUID;", "box-tests"})
public final class StatementOperationTypeSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto, ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto> {
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0442\u0438\u043f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0432\u044b\u043f\u0438\u0441\u043a\u0438 \u043f\u043e \u0435\u0433\u043e \u043a\u043e\u0434\u0443 \'{code}\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto> getSoTypeByCode(@org.jetbrains.annotations.NotNull()
    java.lang.String code, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0442\u0438\u043f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0432\u044b\u043f\u0438\u0441\u043a\u0438 \u043f\u043e \u0435\u0433\u043e \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044e \'{description}\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto> getSoTypeByDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0442\u0438\u043f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0432\u044b\u043f\u0438\u0441\u043a\u0438 \u043f\u043e \u0435\u0433\u043e \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044e \'{description}\'")
    public final void deleteSoTypeByDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String description, boolean withCheckResponseCode, int statusCode) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043d\u0430 \u043a\u043e\u0440\u0440\u0435\u043a\u0442\u043d\u043e\u0441\u0442\u044c \u0441\u0443\u0449\u0435\u0441\u0442\u0432\u0443\u044e\u0449\u0438\u0439 \u0442\u0438\u043f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \u0432\u044b\u043f\u0438\u0441\u043a\u0438 \u0441 id = \'{id}\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto> validateSoTypeById(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public StatementOperationTypeSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}