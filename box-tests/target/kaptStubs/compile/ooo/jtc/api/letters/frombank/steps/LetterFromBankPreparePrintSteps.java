package ooo.jtc.api.letters.frombank.steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0003J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J,\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u0018\u001a\u00020\u0014H\u0007\u00a8\u0006\u0019"}, d2 = {"Looo/jtc/api/letters/frombank/steps/LetterFromBankPreparePrintSteps;", "", "()V", "getExpSignatureInfoForLFB", "", "", "letterFromBank", "Looo/jtc/letters/dto/LetterFromBankDto;", "printingUser", "Looo/jtc/uaa/User;", "getExpStampDataForLFB", "getPrintTableContentForLFB", "userType", "Looo/jtc/uaa/UserType;", "getStatusSpecificStampData", "preparePrintExpContent", "docsToPrint", "withSignatures", "", "preparePrintFileNameRegexMultipleDocs", "Lkotlin/text/Regex;", "preparePrintFileNameSingleDoc", "docToPrint", "preparePrintTableExpContent", "preparePrintTableFileNameRegex", "box-tests"})
public final class LetterFromBankPreparePrintSteps {
    public static final ooo.jtc.api.letters.frombank.steps.LetterFromBankPreparePrintSteps INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u043e\u0435 \u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435 \u0444\u0430\u0439\u043b\u0430 \u043f\u0435\u0447\u0430\u0442\u043d\u043e\u0439 \u0444\u043e\u0440\u043c\u044b (\u043e\u0434\u0438\u043d \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442)")
    public final java.lang.String preparePrintFileNameSingleDoc(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.dto.LetterFromBankDto docToPrint) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u043e\u0435 \u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435 \u0444\u0430\u0439\u043b\u0430 \u043f\u0435\u0447\u0430\u0442\u043d\u043e\u0439 \u0444\u043e\u0440\u043c\u044b \u0440\u0435\u0435\u0441\u0442\u0440\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
    public final kotlin.text.Regex preparePrintTableFileNameRegex() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u043e\u0435 \u043d\u0430\u0438\u043c\u0435\u043d\u043e\u0432\u0430\u043d\u0438\u0435 \u0444\u0430\u0439\u043b\u0430 \u043f\u0435\u0447\u0430\u0442\u043d\u043e\u0439 \u0444\u043e\u0440\u043c\u044b (\u043d\u0435\u0441\u043a\u043e\u043b\u044c\u043a\u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432)")
    public final kotlin.text.Regex preparePrintFileNameRegexMultipleDocs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u0443\u044e \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u043f\u0435\u0447\u0430\u0442\u043d\u043e\u0439 \u0444\u043e\u0440\u043c\u044b \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430")
    public final java.util.List<java.lang.String> preparePrintExpContent(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.letters.dto.LetterFromBankDto> docsToPrint, boolean withSignatures, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User printingUser) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u0443\u044e \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u0448\u0442\u0430\u043c\u043f\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 [{letterFromBank.id}] \u0432 \u0435\u0433\u043e \u043f\u0435\u0447\u0430\u0442\u043d\u043e\u0439 \u0444\u043e\u0440\u043c\u0435")
    private final java.util.List<java.lang.String> getExpStampDataForLFB(ooo.jtc.letters.dto.LetterFromBankDto letterFromBank, ooo.jtc.uaa.User printingUser) {
        return null;
    }
    
    private final java.util.List<java.lang.String> getStatusSpecificStampData(ooo.jtc.letters.dto.LetterFromBankDto letterFromBank, ooo.jtc.uaa.User printingUser) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u0443\u044e \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u043e \u043f\u043e\u0434\u043f\u0438\u0441\u044f\u0445 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 [{letterFromBank.id}] \u0432 \u0435\u0433\u043e \u043f\u0435\u0447\u0430\u0442\u043d\u043e\u0439 \u0444\u043e\u0440\u043c\u0435")
    private final java.util.List<java.lang.String> getExpSignatureInfoForLFB(ooo.jtc.letters.dto.LetterFromBankDto letterFromBank, ooo.jtc.uaa.User printingUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u0443\u044e \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u0440\u0435\u0435\u0441\u0442\u0440\u0430 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
    public final java.util.List<java.lang.String> preparePrintTableExpContent(@org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.letters.dto.LetterFromBankDto> docsToPrint, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u0435\u043c\u0443\u044e \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044e \u043e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0435 \u0432 \u0440\u0435\u0435\u0441\u0442\u0440\u0435 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432")
    private final java.util.List<java.lang.String> getPrintTableContentForLFB(ooo.jtc.letters.dto.LetterFromBankDto letterFromBank, ooo.jtc.uaa.UserType userType) {
        return null;
    }
    
    private LetterFromBankPreparePrintSteps() {
        super();
    }
}