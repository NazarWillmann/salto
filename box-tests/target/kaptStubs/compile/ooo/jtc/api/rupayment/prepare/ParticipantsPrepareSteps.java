package ooo.jtc.api.rupayment.prepare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/rupayment/prepare/ParticipantsPrepareSteps;", "", "()V", "generateReceiverInn", "", "receiverAccNumber", "isBudgetPayment", "", "getPayerDto", "Looo/jtc/rupayment/dto/PayerDto;", "account", "Looo/jtc/dictionaries/account/Account;", "getRandomReceiverDto", "Looo/jtc/rupayment/dto/ReceiverDto;", "getReceiverDto", "contractor", "Looo/jtc/dictionaries/contractor/Contractor;", "contractorPayment", "Looo/jtc/dictionaries/contractorpayment/ContractorPayment;", "box-tests"})
public final class ParticipantsPrepareSteps {
    public static final ooo.jtc.api.rupayment.prepare.ParticipantsPrepareSteps INSTANCE = null;
    
    /**
     * Create [PayerDto] based on provided [Account] data
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.PayerDto getPayerDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.account.Account account) {
        return null;
    }
    
    /**
     * Create [ReceiverDto] based on provided [Account] data
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.ReceiverDto getReceiverDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.account.Account account) {
        return null;
    }
    
    /**
     * Create [ReceiverDto] based on provided [Contractor] and [ContractorPayment] data
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.ReceiverDto getReceiverDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.contractor.Contractor contractor, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.contractorpayment.ContractorPayment contractorPayment) {
        return null;
    }
    
    /**
     * Create random [ReceiverDto]:
     * - bank - randomly chosen from non-Rkc banks in [BankRuData]
     * - account (number) - generated, based on bank
     * - customerName - generated
     * - customerKpp - null
     * - (customer) innKio - generated, based on accountNumber and [isBudgetPayment] value
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.ReceiverDto getRandomReceiverDto(boolean isBudgetPayment) {
        return null;
    }
    
    /**
     * Generate innKio that should successfully pass BE-controls
     *
     * Based on
     * https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336972
     * https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337051
     */
    private final java.lang.String generateReceiverInn(java.lang.String receiverAccNumber, boolean isBudgetPayment) {
        return null;
    }
    
    private ParticipantsPrepareSteps() {
        super();
    }
}