package ooo.jtc.api.common.templates.entity;

import java.lang.System;

/**
 * Template for testing BE validation that bypass controls.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00060\u0005B\u0083\u0001\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\f\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e\u0012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\b\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00060\u000e\u00a2\u0006\u0002\u0010\u0016\u00a8\u0006\u0017"}, d2 = {"Looo/jtc/api/common/templates/entity/ServerErrorTestTemplate;", "T", "Looo/jtc/interfaces/IEntityDto;", "U", "Looo/jtc/interfaces/UpdateIEntityDto;", "Looo/jtc/api/common/tests/AbstractBeTest;", "", "testName", "", "user", "Looo/jtc/uaa/User;", "preExecution", "Lkotlin/Function0;", "postExecution", "Lkotlin/Function1;", "steps", "Looo/jtc/api/common/steps/AbstractEntitySteps;", "expectedHttpCode", "", "expectedCode", "expectedMessage", "testBody", "(Ljava/lang/String;Looo/jtc/uaa/User;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Looo/jtc/api/common/steps/AbstractEntitySteps;IILjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "box-tests"})
public class ServerErrorTestTemplate<T extends ooo.jtc.interfaces.IEntityDto, U extends ooo.jtc.interfaces.UpdateIEntityDto<T>> extends ooo.jtc.api.common.tests.AbstractBeTest<T, kotlin.Unit> {
    
    public ServerErrorTestTemplate(@org.jetbrains.annotations.NotNull()
    java.lang.String testName, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends T> preExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> postExecution, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.steps.AbstractEntitySteps<T, U> steps, int expectedHttpCode, int expectedCode, @org.jetbrains.annotations.NotNull()
    java.lang.String expectedMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> testBody) {
        super(null, null, null, null, null, null);
    }
}