package ooo.jtc.api.rupayment.tests;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B=\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0002\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/rupayment/tests/RuPaymentFiltrationTest;", "Looo/jtc/api/common/templates/entity/FiltrationTestTemplate;", "Looo/jtc/rupayment/dto/RuPaymentDto;", "Looo/jtc/testdata/rupayment/RuPaymentFilterParams;", "", "name", "", "user", "Looo/jtc/uaa/User;", "preExecution", "Lkotlin/Function0;", "filterRequestFunction", "Lkotlin/Function1;", "Looo/jtc/generic/pageparams/FilterData;", "(Ljava/lang/String;Looo/jtc/uaa/User;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "getUser", "()Looo/jtc/uaa/User;", "setUser", "(Looo/jtc/uaa/User;)V", "box-tests"})
@ooo.jtc.core.tm4j.NormalPriority()
@ooo.jtc.core.tm4j.ComponentRuPayment()
@RuPaymentFolderFiltration()
@ooo.jtc.core.tm4j.TaskIds(value = {"JTCSALTO-26", "JTCSALTO-710"})
public final class RuPaymentFiltrationTest extends ooo.jtc.api.common.templates.entity.FiltrationTestTemplate<ooo.jtc.rupayment.dto.RuPaymentDto, ooo.jtc.testdata.rupayment.RuPaymentFilterParams, java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.uaa.User user;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User getUser() {
        return null;
    }
    
    public final void setUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User p0) {
    }
    
    public RuPaymentFiltrationTest(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<ooo.jtc.rupayment.dto.RuPaymentDto> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.rupayment.dto.RuPaymentDto, ooo.jtc.generic.pageparams.FilterData> filterRequestFunction) {
        super(null, null, null, null, null, null);
    }
}