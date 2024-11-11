package ooo.jtc.api.dictionaries.bankbic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0017\u001a\u00020\u0013H\u0007J$\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00102\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0010H\u0007J\b\u0010\u001e\u001a\u00020\u0004H\u0007J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f\u00a8\u0006!"}, d2 = {"Looo/jtc/api/dictionaries/bankbic/BankBicPrepareSteps;", "", "()V", "ED807_FULL_XML", "Ljava/io/File;", "getED807_FULL_XML", "()Ljava/io/File;", "ED807_FULL_XML$delegate", "Lkotlin/Lazy;", "ED807_SAMPLES", "Looo/jtc/dictionaries/bankbic/ed807/ED807Xml;", "getED807_SAMPLES", "()Looo/jtc/dictionaries/bankbic/ed807/ED807Xml;", "ED807_SAMPLES$delegate", "getEmptyED807Xml", "getRandomED807Entries", "", "Looo/jtc/dictionaries/bankbic/ed807/ED807BicNode;", "amount", "", "prepareAtBankBicDto", "Looo/jtc/dictionaries/bankbic/BankBicDto;", "prepareBankBicsForImport", "withAtRecordsAmount", "prepareBicPaymentDetails", "Looo/jtc/dictionaries/branch/paymentdetails/BicPaymentDetailsDto;", "bankBicData", "Looo/jtc/dictionaries/bankbic/BankBic;", "bicAccountData", "Looo/jtc/dictionaries/bankbic/acc/BankBicAccount;", "prepareSamplesForBankBicImport", "prepareTempFileForBankBicImport", "bankBicEntriesForImport", "box-tests"})
public final class BankBicPrepareSteps {
    private static final kotlin.Lazy ED807_FULL_XML$delegate = null;
    private static final kotlin.Lazy ED807_SAMPLES$delegate = null;
    public static final ooo.jtc.api.dictionaries.bankbic.BankBicPrepareSteps INSTANCE = null;
    
    private final java.io.File getED807_FULL_XML() {
        return null;
    }
    
    private final ooo.jtc.dictionaries.bankbic.ed807.ED807Xml getED807_SAMPLES() {
        return null;
    }
    
    private final ooo.jtc.dictionaries.bankbic.ed807.ED807Xml getEmptyED807Xml() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<ooo.jtc.dictionaries.bankbic.ed807.ED807BicNode> getRandomED807Entries(int amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.BankBicDto prepareAtBankBicDto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File prepareTempFileForBankBicImport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0437\u0430\u043f\u0438\u0441\u0438 \u0411\u0418\u041a \u0420\u0424 \u0434\u043b\u044f \u0438\u043c\u043f\u043e\u0440\u0442\u0430")
    public final java.util.List<ooo.jtc.dictionaries.bankbic.ed807.ED807BicNode> prepareBankBicsForImport(int amount, int withAtRecordsAmount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.io.File prepareTempFileForBankBicImport(int amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0432\u0440\u0435\u043c\u0435\u043d\u043d\u044b\u0439 \u0444\u0430\u0439\u043b \u0438\u043c\u043f\u043e\u0440\u0442\u0430")
    public final java.io.File prepareTempFileForBankBicImport(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.bankbic.ed807.ED807BicNode> bankBicEntriesForImport) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0434\u043b\u044f \u0438\u043c\u043f\u043e\u0440\u0442\u0430 \u0444\u0430\u0439\u043b \u043f\u0440\u0438\u043c\u0435\u0440\u0430")
    public final java.io.File prepareSamplesForBankBicImport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c Bic Payment Details")
    public final ooo.jtc.dictionaries.branch.paymentdetails.BicPaymentDetailsDto prepareBicPaymentDetails(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.bankbic.BankBic> bankBicData, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.dictionaries.bankbic.acc.BankBicAccount> bicAccountData) {
        return null;
    }
    
    private BankBicPrepareSteps() {
        super();
    }
}