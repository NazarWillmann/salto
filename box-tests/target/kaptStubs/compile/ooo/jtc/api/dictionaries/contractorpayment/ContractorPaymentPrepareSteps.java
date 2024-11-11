package ooo.jtc.api.dictionaries.contractorpayment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0007J$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/api/dictionaries/contractorpayment/ContractorPaymentPrepareSteps;", "", "()V", "cleanAtCreated", "", "createContractorPaymentDto", "Looo/jtc/dictionaries/contractorpayment/ContractorPaymentDto;", "contractorId", "Ljava/util/UUID;", "dtoForCreate", "user", "Looo/jtc/uaa/User;", "getContractorPaymentDtoForCreate", "balanceAccount", "Looo/jtc/testdata/dictionaries/account/BalanceAccount;", "isDefault", "", "getContractorPaymentDtoForUpdate", "Looo/jtc/dictionaries/contractorpayment/ContractorPaymentUpdateRequest;", "createdDto", "box-tests"})
public final class ContractorPaymentPrepareSteps {
    public static final ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 ContractorPayment \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto getContractorPaymentDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, boolean isDefault) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0442\u0435\u0441\u0442\u043e\u0432\u043e\u0435 DTO \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \'\u041f\u043b\u0430\u0442\u0435\u0436\u043d\u044b\u0435 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430\' ")
    public final ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto getContractorPaymentDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID contractorId, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.dictionaries.account.BalanceAccount balanceAccount, boolean isDefault) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0442\u0435\u0441\u0442\u043e\u0432\u043e\u0435 DTO \u0434\u043b\u044f \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u044f \'\u041f\u043b\u0430\u0442\u0435\u0436\u043d\u044b\u0435 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430\' ")
    public final ooo.jtc.dictionaries.contractorpayment.ContractorPaymentUpdateRequest getContractorPaymentDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto createdDto, boolean isDefault) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u041f\u043b\u0430\u0442\u0435\u0436\u043d\u044b\u0435 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430 \u0434\u043b\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f {user.login}")
    public final ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto createContractorPaymentDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u041f\u043b\u0430\u0442\u0435\u0436\u043d\u044b\u0435 \u0440\u0435\u043a\u0432\u0438\u0437\u0438\u0442\u044b \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430 \u0434\u043b\u044f \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430 [{contractorId}]")
    public final ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto createContractorPaymentDto(@org.jetbrains.annotations.NotNull()
    java.util.UUID contractorId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto createContractorPaymentDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto dtoForCreate) {
        return null;
    }
    
    private ContractorPaymentPrepareSteps() {
        super();
    }
}