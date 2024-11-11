package ooo.jtc.api.rupayment.prepare;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000bH\u0007J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bJ(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J,\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!H\u0007J!\u0010\"\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0000\u00a2\u0006\u0002\b#J\u0010\u0010$\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0002J\u009f\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\'2\b\b\u0002\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u00020\'2\b\b\u0002\u00104\u001a\u00020\'2\b\b\u0002\u00105\u001a\u00020\'2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010+2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:H\u0000\u00a2\u0006\u0004\b;\u0010<J\u00a9\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\'2\b\b\u0002\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\b\b\u0002\u0010/\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u00103\u001a\u00020\'2\b\b\u0002\u00104\u001a\u00020\'2\b\b\u0002\u00105\u001a\u00020\'2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u00106\u001a\u0004\u0018\u0001072\n\b\u0002\u00108\u001a\u0004\u0018\u00010+2\n\b\u0002\u00109\u001a\u0004\u0018\u00010:H\u0002\u00a2\u0006\u0002\u0010AJ\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001aJ!\u0010B\u001a\u00020\u001c2\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020E0D\"\u00020EH\u0007\u00a2\u0006\u0002\u0010FJ\u0010\u0010G\u001a\u00020H2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Looo/jtc/api/rupayment/prepare/RuPaymentPrepareSteps;", "", "()V", "usedRuPaymentIds", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/UUID;", "cleanAtCreated", "", "user", "Looo/jtc/uaa/User;", "createRuPaymentDto", "Looo/jtc/rupayment/dto/RuPaymentDto;", "clientUser", "dtoForCreate", "createSentRuPaymentDto", "deleteRuPayment", "ruPaymentId", "getBudgetRuPaymentDto", "budgetType", "Looo/jtc/rupayment/model/BudgetType;", "getDtoForUpdate", "ruPaymentDto", "getNonBudgetRuPaymentDto", "balanceAccount", "Looo/jtc/testdata/dictionaries/account/BalanceAccount;", "userPaymentType", "Looo/jtc/rupayment/model/UserPaymentType;", "forOrganization", "", "getOrCreateRuPaymentDto", "searchParams", "Looo/jtc/generic/pageparams/Params;", "createFunction", "Lkotlin/Function0;", "getOtherRuPaymentDto", "getOtherRuPaymentDto$box_tests", "getOwnAccountsRuPaymentDto", "getRuPaymentDto", "documentNumber", "", "documentDate", "Ljava/time/LocalDate;", "amount", "Ljava/math/BigDecimal;", "payerAccount", "Looo/jtc/dictionaries/account/Account;", "receiverAccount", "paymentGround", "Looo/jtc/rupayment/dto/PaymentGroundDto;", "budget", "Looo/jtc/rupayment/dto/BudgetDto;", "operationType", "priority", "uinUip", "incomeTypeCode", "", "amountRecovery", "transferTerm", "Looo/jtc/dictionaries/transferterm/TransferTerm;", "getRuPaymentDto$box_tests", "(Ljava/lang/String;Ljava/time/LocalDate;Ljava/math/BigDecimal;Looo/jtc/dictionaries/account/Account;Looo/jtc/dictionaries/account/Account;Looo/jtc/rupayment/dto/PaymentGroundDto;Looo/jtc/rupayment/dto/BudgetDto;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/rupayment/model/UserPaymentType;Ljava/lang/Integer;Ljava/math/BigDecimal;Looo/jtc/dictionaries/transferterm/TransferTerm;)Looo/jtc/rupayment/dto/RuPaymentDto;", "payer", "Looo/jtc/rupayment/dto/PayerDto;", "receiver", "Looo/jtc/rupayment/dto/ReceiverDto;", "(Ljava/lang/String;Ljava/time/LocalDate;Ljava/math/BigDecimal;Looo/jtc/rupayment/dto/PayerDto;Looo/jtc/rupayment/dto/ReceiverDto;Looo/jtc/rupayment/dto/PaymentGroundDto;Looo/jtc/rupayment/dto/BudgetDto;Looo/jtc/rupayment/model/BudgetType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/rupayment/model/UserPaymentType;Ljava/lang/Integer;Ljava/math/BigDecimal;Looo/jtc/dictionaries/transferterm/TransferTerm;)Looo/jtc/rupayment/dto/RuPaymentDto;", "hasRuPaymentsInStatuses", "statuses", "", "Looo/jtc/rupayment/model/RuPaymentStatus;", "([Looo/jtc/rupayment/model/RuPaymentStatus;)Z", "preparePreFilled", "Looo/jtc/rupayment/dto/RuPaymentPreFilledForUserPaymentType;", "box-tests"})
public final class RuPaymentPrepareSteps {
    
    /**
     * Collects used in tests ruPayment ids.
     */
    private static final java.util.concurrent.CopyOnWriteArrayList<java.util.UUID> usedRuPaymentIds = null;
    public static final ooo.jtc.api.rupayment.prepare.RuPaymentPrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\"\u0423\u0434\u0430\u043b\u0438\u0442\u044c\" \u043f\u043b\u0430\u0442\u0451\u0436\u043a\u0438, \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 (\u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \'{user.login}\')")
    public final void cleanAtCreated(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \'\u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f\'")
    public final ooo.jtc.rupayment.dto.RuPaymentDto getOrCreateRuPaymentDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params searchParams, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.rupayment.dto.RuPaymentDto> createFunction) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.RuPaymentDto getRuPaymentDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c \u043d\u0430\u043b\u0438\u0447\u0438\u0435 \u0432 \u0441\u0438\u0441\u0442\u0435\u043c\u0435 \u0437\u0430\u043f\u0438\u0441\u0435\u0439 \u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f \u0432 \u043e\u0434\u043d\u043e\u043c \u0438\u0437 \u0441\u0442\u0430\u0442\u0443\u0441\u043e\u0432")
    public final boolean hasRuPaymentsInStatuses(@org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.model.RuPaymentStatus... statuses) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f")
    public final ooo.jtc.rupayment.dto.RuPaymentDto createRuPaymentDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.dto.RuPaymentDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c, \u043f\u043e\u0434\u043f\u0438\u0441\u0430\u0442\u044c \u0438 \u043e\u0442\u043f\u0440\u0430\u0432\u0438\u0442\u044c \u0432 \u0431\u0430\u043d\u043a \u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f")
    public final ooo.jtc.rupayment.dto.RuPaymentDto createSentRuPaymentDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.dto.RuPaymentDto dtoForCreate) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \'\u0420\u0443\u0431\u043b\u0435\u0432\u043e\u0435 \u041f\u041f\'")
    public final void deleteRuPayment(@org.jetbrains.annotations.NotNull()
    java.util.UUID ruPaymentId, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u043e\u0431\u044a\u0435\u043a\u0442 \u0434\u043b\u044f \u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0438 \u043f\u0440\u0435\u0434\u0437\u0430\u043f\u043e\u043b\u043d\u0435\u043d\u0438\u044f ({userPaymentType})")
    public final ooo.jtc.rupayment.dto.RuPaymentPreFilledForUserPaymentType preparePreFilled(@org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType) {
        return null;
    }
    
    private final ooo.jtc.rupayment.dto.RuPaymentDto getRuPaymentDto(java.lang.String documentNumber, java.time.LocalDate documentDate, java.math.BigDecimal amount, ooo.jtc.rupayment.dto.PayerDto payer, ooo.jtc.rupayment.dto.ReceiverDto receiver, ooo.jtc.rupayment.dto.PaymentGroundDto paymentGround, ooo.jtc.rupayment.dto.BudgetDto budget, ooo.jtc.rupayment.model.BudgetType budgetType, java.lang.String operationType, java.lang.String priority, java.lang.String uinUip, ooo.jtc.rupayment.model.UserPaymentType userPaymentType, java.lang.Integer incomeTypeCode, java.math.BigDecimal amountRecovery, ooo.jtc.dictionaries.transferterm.TransferTerm transferTerm) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.RuPaymentDto getRuPaymentDto$box_tests(@org.jetbrains.annotations.NotNull()
    java.lang.String documentNumber, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate documentDate, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal amount, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.account.Account payerAccount, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.account.Account receiverAccount, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.dto.PaymentGroundDto paymentGround, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.dto.BudgetDto budget, @org.jetbrains.annotations.NotNull()
    java.lang.String operationType, @org.jetbrains.annotations.NotNull()
    java.lang.String priority, @org.jetbrains.annotations.NotNull()
    java.lang.String uinUip, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.model.UserPaymentType userPaymentType, @org.jetbrains.annotations.Nullable()
    java.lang.Integer incomeTypeCode, @org.jetbrains.annotations.Nullable()
    java.math.BigDecimal amountRecovery, @org.jetbrains.annotations.Nullable()
    ooo.jtc.dictionaries.transferterm.TransferTerm transferTerm) {
        return null;
    }
    
    /**
     * Create non budget RuPayment
     */
    private final ooo.jtc.rupayment.dto.RuPaymentDto getNonBudgetRuPaymentDto(ooo.jtc.uaa.User user, ooo.jtc.testdata.dictionaries.account.BalanceAccount balanceAccount, ooo.jtc.rupayment.model.UserPaymentType userPaymentType, boolean forOrganization) {
        return null;
    }
    
    /**
     * Create budget RuPayment
     */
    private final ooo.jtc.rupayment.dto.RuPaymentDto getBudgetRuPaymentDto(ooo.jtc.uaa.User user, ooo.jtc.rupayment.model.BudgetType budgetType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.RuPaymentDto getDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.rupayment.dto.RuPaymentDto ruPaymentDto) {
        return null;
    }
    
    /**
     * Create other budget RuPayment
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rupayment.dto.RuPaymentDto getOtherRuPaymentDto$box_tests(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.Nullable()
    ooo.jtc.rupayment.model.BudgetType budgetType) {
        return null;
    }
    
    /**
     * Payment between accounts on same customer. Try found customer with two acc's, if not found, create id.
     */
    private final ooo.jtc.rupayment.dto.RuPaymentDto getOwnAccountsRuPaymentDto(ooo.jtc.uaa.User user) {
        return null;
    }
    
    private RuPaymentPrepareSteps() {
        super();
    }
}