package ooo.jtc.api.dictionaries.agreement;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J2\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/api/dictionaries/agreement/AgreementSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/agreement/AgreementDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "activateOrDeactivateAgreement", "Looo/jtc/generic/GenericResponseDto;", "id", "Ljava/util/UUID;", "isActivate", "", "withCheckResponseCode", "statusCode", "", "checkDefaultEntity", "", "actualEntity", "Looo/jtc/dictionaries/agreement/Agreement;", "expectedEntity", "box-tests"})
public final class AgreementSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.agreement.AgreementDto, ooo.jtc.dictionaries.agreement.AgreementDto> {
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u043a\u0430 \u043f\u0440\u0435\u0434\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u043d\u043e\u0439 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0438 \'\u0421\u043e\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435\'")
    public final void checkDefaultEntity(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.agreement.Agreement actualEntity, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.agreement.Agreement expectedEntity) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0410\u043a\u0442\u0438\u0432\u0430\u0446\u0438\u044f \'\u0421\u043e\u0433\u043b\u0430\u0448\u0435\u043d\u0438\u0435\'")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.dictionaries.agreement.AgreementDto> activateOrDeactivateAgreement(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean isActivate, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public AgreementSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
}