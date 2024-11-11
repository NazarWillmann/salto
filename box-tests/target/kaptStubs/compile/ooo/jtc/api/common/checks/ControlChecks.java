package ooo.jtc.api.common.checks;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Looo/jtc/api/common/checks/ControlChecks;", "", "()V", "checkDefaultControlLevel", "", "reason", "", "actual", "Looo/jtc/api/common/controls/ControlLevel;", "expected", "checkValidationResult", "actualValidationResult", "expectedValidationResult", "box-tests"})
public final class ControlChecks {
    public static final ooo.jtc.api.common.checks.ControlChecks INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u043a\u0430 \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u044f \u0443\u0440\u043e\u0432\u043d\u044f \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u044f \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e")
    public final void checkDefaultControlLevel(@org.jetbrains.annotations.NotNull()
    java.lang.String reason, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.controls.ControlLevel actual, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.controls.ControlLevel expected) {
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u0440\u0435\u0437\u0443\u043b\u044c\u0442\u0430\u0442 \u0432\u0430\u043b\u0438\u0434\u0430\u0446\u0438\u0438 \u0440\u0430\u0432\u0435\u043d \'{expectedValidationResult}\'")
    public final void checkValidationResult(@org.jetbrains.annotations.NotNull()
    java.lang.String actualValidationResult, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedValidationResult) {
    }
    
    private ControlChecks() {
        super();
    }
}