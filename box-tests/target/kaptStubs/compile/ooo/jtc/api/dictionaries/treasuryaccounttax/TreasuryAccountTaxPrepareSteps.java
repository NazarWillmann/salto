package ooo.jtc.api.dictionaries.treasuryaccounttax;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u001c\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2 = {"Looo/jtc/api/dictionaries/treasuryaccounttax/TreasuryAccountTaxPrepareSteps;", "", "()V", "ACCOUNT_CODE", "", "ACCOUNT_CURRENCY", "ACCOUNT_PREFIX", "bankAccountDateIn", "Ljava/time/LocalDate;", "bankBic", "Looo/jtc/dictionaries/bankbic/BankBic;", "getBankBic", "()Looo/jtc/dictionaries/bankbic/BankBic;", "bankBic$delegate", "Lkotlin/Lazy;", "createBankBicAccount", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccount;", "accountType", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccAccountTypeIEnum;", "status", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccStatusIEnum;", "deleteBankBicAccounts", "", "getTreasuryAccountTaxDtoForCreate", "Looo/jtc/dictionaries/treasuryaccounttax/TreasuryAccountTaxDto;", "textFieldGenerator", "Looo/jtc/random/RandomData;", "utraAccount", "getTreasuryAccountTaxDtoForUpdate", "createdDto", "box-tests"})
public final class TreasuryAccountTaxPrepareSteps {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACCOUNT_CODE = "03100";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACCOUNT_CURRENCY = "643";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACCOUNT_PREFIX = "03100643";
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy bankBic$delegate = null;
    private static final java.time.LocalDate bankAccountDateIn = null;
    public static final ooo.jtc.api.dictionaries.treasuryaccounttax.TreasuryAccountTaxPrepareSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.BankBic getBankBic() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto getTreasuryAccountTaxDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.random.RandomData textFieldGenerator, @org.jetbrains.annotations.Nullable()
    java.lang.String utraAccount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto getTreasuryAccountTaxDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.acc.BankBicAccount createBankBicAccount(@org.jetbrains.annotations.Nullable()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccAccountTypeIEnum accountType, @org.jetbrains.annotations.Nullable()
    ooo.jtc.dictionaries.bankbic.acc.BankBicAccStatusIEnum status) {
        return null;
    }
    
    public final void deleteBankBicAccounts() {
    }
    
    private TreasuryAccountTaxPrepareSteps() {
        super();
    }
}