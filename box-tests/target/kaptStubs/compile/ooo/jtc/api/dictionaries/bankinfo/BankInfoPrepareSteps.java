package ooo.jtc.api.dictionaries.bankinfo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007J!\u0010\u0013\u001a\u00020\u00112\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u0015\"\u00020\u000fH\u0007\u00a2\u0006\u0002\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0003J\b\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020\u0011H\u0007J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u0011J\b\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010\'\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u000e\u0010(\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u000fJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Looo/jtc/api/dictionaries/bankinfo/BankInfoPrepareSteps;", "", "()V", "aBankInfoSteps", "Looo/jtc/api/dictionaries/bankinfo/BankInfoSteps;", "getABankInfoSteps", "()Looo/jtc/api/dictionaries/bankinfo/BankInfoSteps;", "aBankInfoSteps$delegate", "Lkotlin/Lazy;", "aBankRepresentativeSteps", "Looo/jtc/api/dictionaries/bankrepresentative/BankRepresentativeSteps;", "getABankRepresentativeSteps", "()Looo/jtc/api/dictionaries/bankrepresentative/BankRepresentativeSteps;", "aBankRepresentativeSteps$delegate", "almightyUser", "Looo/jtc/uaa/User;", "createBankInfoDto", "Looo/jtc/dictionaries/bankinfo/BankInfoDto;", "dtoForCreate", "createBankInfoWithBankRepresentative", "bankUsers", "", "([Looo/jtc/uaa/User;)Looo/jtc/dictionaries/bankinfo/BankInfoDto;", "deleteBankInfoAndRelatedEntities", "", "bankId", "Ljava/util/UUID;", "deleteAtOnly", "", "ensureBankUserIsRelatedToBank", "bankUser", "getBankInfoApplicationUrlDtoForCreate", "Looo/jtc/dictionaries/bankinfo/applicationurl/BankInfoApplicationUrlDto;", "getBankInfoDtoForCreate", "getBankInfoDtoForUpdate", "createdDto", "getBankInfoSocialUrlDtoForCreate", "Looo/jtc/dictionaries/bankinfo/socialurl/BankInfoSocialUrlDto;", "isUserRelatedToBank", "user", "retrieveBankUser", "retrieveClientUser", "box-tests"})
public final class BankInfoPrepareSteps {
    private static final ooo.jtc.uaa.User almightyUser = null;
    private static final kotlin.Lazy aBankInfoSteps$delegate = null;
    private static final kotlin.Lazy aBankRepresentativeSteps$delegate = null;
    public static final ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps INSTANCE = null;
    
    private final ooo.jtc.api.dictionaries.bankinfo.BankInfoSteps getABankInfoSteps() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeSteps getABankRepresentativeSteps() {
        return null;
    }
    
    /**
     * Retrieve default client user for working with Bank(Info)
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Retrieve default bank user for working with Bank(Info)
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \'BankInfoDto\' \u043a \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044e")
    public final ooo.jtc.dictionaries.bankinfo.BankInfoDto getBankInfoDtoForCreate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankinfo.BankInfoDto getBankInfoDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankinfo.BankInfoDto createdDto) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0441\u0432\u044f\u0437\u0430\u043d \u043b\u0438 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \'{user.login}\' \u0441 \u0431\u0430\u043d\u043a\u043e\u043c [{bankId}]")
    public final boolean isUserRelatedToBank(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.util.UUID bankId) {
        return false;
    }
    
    /**
     * Check if provided bank [bankUser] is related to bank with provided [bankId].
     * Create relation if it doesn't exist.
     */
    @io.qameta.allure.Step(value = "\u0423\u0434\u043e\u0441\u0442\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0441\u044f, \u0447\u0442\u043e \u0431\u0430\u043d\u043a\u043e\u0432\u0441\u043a\u0438\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \'{bankUser.login}\' \u0441\u0432\u044f\u0437\u0430\u043d \u0441 \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435\u043c [{bankId}]")
    private final void ensureBankUserIsRelatedToBank(ooo.jtc.uaa.User bankUser, java.util.UUID bankId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \'\u0411\u0430\u043d\u043a\' \u0441 \u043f\u0440\u0438\u0432\u044f\u0437\u043a\u043e\u0439 \u043a \u0431\u0430\u043d\u043a\u043e\u0432\u0441\u043a\u0438\u043c \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f\u043c {bankUsers}")
    public final ooo.jtc.dictionaries.bankinfo.BankInfoDto createBankInfoWithBankRepresentative(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User... bankUsers) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \'\u0411\u0430\u043d\u043a\'")
    public final ooo.jtc.dictionaries.bankinfo.BankInfoDto createBankInfoDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankinfo.BankInfoDto dtoForCreate) {
        return null;
    }
    
    /**
     * Delete Bank and related entities:
     * * Branches - all related to provided Bank
     * * Customer-/BranchRepresentatives - for all Branches and Customers, related to provided Bank;
     * * BranchCustomer - all records, related to provided Bank;
     * * Customers - all previously related to provided Bank;
     * * BankRepresentatives - all related to provided Bank.
     *
     *
     * (!)WARNINGS(!)
     *
     * This method does NOT check for Customer relations to other Banks/Branches.
     * Use only when you know what you're doing.
     * DO NOT USE THIS if test-created branch has relation to non-test-created data!
     *
     * @param bankId  id of a BankInfo with related entities
     */
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0411\u0430\u043d\u043a \u0441\u043e \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u044b\u043c\u0438 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044f\u043c\u0438 (\u041f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u044f, \u041a\u043b\u0438\u0435\u043d\u0442\u044b \u0438 \u0441\u0432\u044f\u0437\u0438 \u0441 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f\u043c\u0438)")
    public final void deleteBankInfoAndRelatedEntities(@org.jetbrains.annotations.NotNull()
    java.util.UUID bankId, boolean deleteAtOnly) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \'BankInfoApplicationUrlDto\' \u043a \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044e")
    public final ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlDto getBankInfoApplicationUrlDtoForCreate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \'BankInfoSocialUrlDto\' \u043a \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044e")
    public final ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlDto getBankInfoSocialUrlDtoForCreate() {
        return null;
    }
    
    private BankInfoPrepareSteps() {
        super();
    }
}