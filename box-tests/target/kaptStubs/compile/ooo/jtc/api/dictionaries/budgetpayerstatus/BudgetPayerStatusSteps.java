package ooo.jtc.api.dictionaries.budgetpayerstatus;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0007\u00a8\u0006\f"}, d2 = {"Looo/jtc/api/dictionaries/budgetpayerstatus/BudgetPayerStatusSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/dictionaries/budgetpayerstatus/BudgetPayerStatusDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "deleteByCodeAndDescription", "", "code", "", "description", "Companion", "box-tests"})
public final class BudgetPayerStatusSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto, ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto> {
    public static final ooo.jtc.api.dictionaries.budgetpayerstatus.BudgetPayerStatusSteps.Companion Companion = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c {this.entityName} \u043f\u043e \u043a\u043e\u0434\u0443 ({code}) \u0438 \u043e\u043f\u0438\u0441\u0430\u043d\u0438\u044e ({description})")
    public final void deleteByCodeAndDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String code, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
    }
    
    public BudgetPayerStatusSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Looo/jtc/api/dictionaries/budgetpayerstatus/BudgetPayerStatusSteps$Companion;", "", "()V", "checkDefaultEntity", "", "actualEntity", "Looo/jtc/dictionaries/budgetpayerstatus/BudgetPayerStatus;", "expectedEntity", "box-tests"})
    public static final class Companion {
        
        @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u043a\u0430 \u043f\u0440\u0435\u0434\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u043d\u043e\u0439 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0438 \'\u041f\u043e\u043a\u0430\u0437\u0430\u0442\u0435\u043b\u044c \u0441\u0442\u0430\u0442\u0443\u0441\u0430 \u043f\u043b\u0430\u0442\u0435\u043b\u044c\u0449\u0438\u043a\u0430\'")
        public final void checkDefaultEntity(@org.jetbrains.annotations.NotNull()
        ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatus actualEntity, @org.jetbrains.annotations.NotNull()
        ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatus expectedEntity) {
        }
        
        private Companion() {
            super();
        }
    }
}