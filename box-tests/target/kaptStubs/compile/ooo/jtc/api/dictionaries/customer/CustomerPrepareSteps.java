package ooo.jtc.api.dictionaries.customer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\'\u001a\u00020(H\u0007J\u00c2\u0001\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020#2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020*2\b\b\u0002\u0010/\u001a\u00020-2\u0014\b\u0002\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000203012\b\b\u0002\u00104\u001a\u00020-2\u0014\b\u0002\u00105\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u000206012\b\b\u0002\u00107\u001a\u00020-2\b\b\u0002\u00108\u001a\u00020-2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020;0:2\b\b\u0002\u0010<\u001a\u00020-2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020>0:2\b\b\u0002\u0010?\u001a\u00020-2\u0014\b\u0002\u0010@\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020A01H\u0007J\u0012\u0010B\u001a\u00020*2\b\b\u0002\u0010C\u001a\u00020*H\u0007J\u001a\u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020#2\b\b\u0002\u0010F\u001a\u00020*H\u0007J\u001a\u0010G\u001a\u00020(2\u0006\u0010H\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020-H\u0007J$\u0010J\u001a\u00020(2\u0006\u0010K\u001a\u00020#2\u0006\u0010H\u001a\u0002022\n\b\u0002\u0010L\u001a\u0004\u0018\u000102H\u0007J\u0018\u0010M\u001a\u00020(2\u0006\u0010N\u001a\u00020#2\u0006\u0010H\u001a\u000202H\u0007J\b\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u00020PH\u0002J\u0010\u0010R\u001a\u00020P2\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010U\u001a\u00020P2\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010V\u001a\u00020P2\u0006\u0010S\u001a\u00020TH\u0002J\b\u0010W\u001a\u00020PH\u0002J\u0010\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u00020-H\u0002J0\u0010Z\u001a\u00020*2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010Y\u001a\u00020-2\b\b\u0002\u0010[\u001a\u00020-H\u0007J\u000e\u0010\\\u001a\u00020*2\u0006\u0010]\u001a\u00020*J\u0006\u0010^\u001a\u00020>J7\u0010_\u001a\u0002H`\"\u0004\b\u0000\u0010`2\u0006\u0010a\u001a\u00020T2\f\u0010b\u001a\b\u0012\u0004\u0012\u0002H`0:2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002H`0:H\u0002\u00a2\u0006\u0002\u0010dJ\u0018\u0010e\u001a\u00020-2\u0006\u0010E\u001a\u00020#2\u0006\u0010H\u001a\u000202H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b$\u0010%\u00a8\u0006f"}, d2 = {"Looo/jtc/api/dictionaries/customer/CustomerPrepareSteps;", "", "()V", "aAccountSteps", "Looo/jtc/api/dictionaries/account/AccountSteps;", "getAAccountSteps", "()Looo/jtc/api/dictionaries/account/AccountSteps;", "aAccountSteps$delegate", "Lkotlin/Lazy;", "aBranchCustomerSteps", "Looo/jtc/api/dictionaries/branchcustomer/BranchCustomerSteps;", "getABranchCustomerSteps", "()Looo/jtc/api/dictionaries/branchcustomer/BranchCustomerSteps;", "aBranchCustomerSteps$delegate", "aBranchRepresentativeSteps", "Looo/jtc/api/dictionaries/branchrepresentative/BranchRepresentativeSteps;", "getABranchRepresentativeSteps", "()Looo/jtc/api/dictionaries/branchrepresentative/BranchRepresentativeSteps;", "aBranchRepresentativeSteps$delegate", "aClientRepresentativeSteps", "Looo/jtc/api/dictionaries/customerrepresentative/CustomerRepresentativeSteps;", "getAClientRepresentativeSteps", "()Looo/jtc/api/dictionaries/customerrepresentative/CustomerRepresentativeSteps;", "aClientRepresentativeSteps$delegate", "aCustomerSteps", "Looo/jtc/api/dictionaries/customer/CustomerSteps;", "getACustomerSteps", "()Looo/jtc/api/dictionaries/customer/CustomerSteps;", "aCustomerSteps$delegate", "aGroundSteps", "Looo/jtc/api/dictionaries/ground/GroundSteps;", "getAGroundSteps", "()Looo/jtc/api/dictionaries/ground/GroundSteps;", "aGroundSteps$delegate", "almightyUser", "Looo/jtc/uaa/User;", "getAlmightyUser", "()Looo/jtc/uaa/User;", "almightyUser$delegate", "cleanAtCreated", "", "createCustomerDto", "Looo/jtc/dictionaries/customer/CustomerDto;", "customerUser", "forUi", "", "customerForCreate", "withBranchCustomer", "createBranchCustomer", "Lkotlin/Function1;", "Ljava/util/UUID;", "Looo/jtc/dictionaries/branchcustomer/BranchCustomerDto;", "withCustomerRepresentative", "createCustomerRepresentative", "Looo/jtc/dictionaries/customerrepresentative/CustomerRepresentativeDto;", "withLocAddress", "withRegAddress", "prepareAddress", "Lkotlin/Function0;", "Looo/jtc/dictionaries/common/address/AddressDto;", "withKpp", "prepareCustomerKpp", "Looo/jtc/dictionaries/customerkpp/CustomerKppDto;", "withAccount", "createAccount", "Looo/jtc/dictionaries/account/AccountDto;", "createCustomerWithNoRelations", "customerForCreation", "createCustomerWithRelationsForUser", "user", "customerDto", "deleteCustomerAndRelatedEntitiesIfPossible", "customerId", "deleteAtOnly", "ensureBankUserIsRelatedToCustomer", "bankUser", "branchId", "ensureClientUserIsRelatedToCustomer", "clientUser", "generateDescription", "", "generateFullName", "generateInn", "customerType", "Looo/jtc/dictionaries/customertype/CustomerType;", "generateOgrn", "generateOkpo", "generateShortName", "getCountryDigitCode", "isResident", "getCustomerDtoForCreate", "isBlock", "getCustomerDtoForUpdate", "createdDto", "getCustomerKppDto", "getForCustomerType", "T", "cType", "ipFunc", "otherFunc", "(Looo/jtc/dictionaries/customertype/CustomerType;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isUserRelatedToCustomer", "box-tests"})
public final class CustomerPrepareSteps {
    private static final kotlin.Lazy almightyUser$delegate = null;
    private static final kotlin.Lazy aGroundSteps$delegate = null;
    private static final kotlin.Lazy aAccountSteps$delegate = null;
    private static final kotlin.Lazy aCustomerSteps$delegate = null;
    private static final kotlin.Lazy aBranchCustomerSteps$delegate = null;
    private static final kotlin.Lazy aBranchRepresentativeSteps$delegate = null;
    private static final kotlin.Lazy aClientRepresentativeSteps$delegate = null;
    public static final ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps INSTANCE = null;
    
    private final ooo.jtc.uaa.User getAlmightyUser() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.ground.GroundSteps getAGroundSteps() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.account.AccountSteps getAAccountSteps() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.customer.CustomerSteps getACustomerSteps() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps getABranchCustomerSteps() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeSteps getABranchRepresentativeSteps() {
        return null;
    }
    
    private final ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeSteps getAClientRepresentativeSteps() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0412\u0421\u0415 \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 Customer")
    public final void cleanAtCreated() {
    }
    
    private final <T extends java.lang.Object>T getForCustomerType(ooo.jtc.dictionaries.customertype.CustomerType cType, kotlin.jvm.functions.Function0<? extends T> ipFunc, kotlin.jvm.functions.Function0<? extends T> otherFunc) {
        return null;
    }
    
    private final java.lang.String getCountryDigitCode(boolean isResident) {
        return null;
    }
    
    private final java.lang.String generateInn(ooo.jtc.dictionaries.customertype.CustomerType customerType) {
        return null;
    }
    
    private final java.lang.String generateOkpo(ooo.jtc.dictionaries.customertype.CustomerType customerType) {
        return null;
    }
    
    private final java.lang.String generateOgrn(ooo.jtc.dictionaries.customertype.CustomerType customerType) {
        return null;
    }
    
    private final java.lang.String generateDescription() {
        return null;
    }
    
    private final java.lang.String generateFullName() {
        return null;
    }
    
    private final java.lang.String generateShortName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c DTO \'\u041a\u043b\u0438\u0435\u043d\u0442 \u0431\u0430\u043d\u043a\u0430\' \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f")
    public final ooo.jtc.dictionaries.customer.CustomerDto getCustomerDtoForCreate(boolean forUi, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customertype.CustomerType customerType, boolean isResident, boolean isBlock) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customer.CustomerDto getCustomerDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customer.CustomerDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customerkpp.CustomerKppDto getCustomerKppDto() {
        return null;
    }
    
    /**
     * Create new customer and necessary related entities. Namely, BranchCustomer, and
     * * for a bank user: BankRepresentative
     * * for a client user: ClientRepresentative
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044e, \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u0443\u044e \u0441 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0435\u043c \'{user.login}\'")
    public final ooo.jtc.dictionaries.customer.CustomerDto createCustomerWithRelationsForUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customer.CustomerDto customerDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044e, \u043d\u0435 \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u0443\u044e \u043d\u0438 \u0441 \u043e\u0434\u043d\u0438\u043c \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0435\u043c")
    public final ooo.jtc.dictionaries.customer.CustomerDto createCustomerWithNoRelations(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customer.CustomerDto customerForCreation) {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0441\u0432\u044f\u0437\u0430\u043d \u043b\u0438 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \'{user.login}\' \u0441 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0435\u0439 [{customerId}]")
    public final boolean isUserRelatedToCustomer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return false;
    }
    
    /**
     * Check if provided bank user is related to customer with provided id (through branch with providedId, if specified).
     * Create relation if it doesn't exist.
     *
     * @param bankUser   - user, that has to be related to customer
     * @param customerId - customer, that has to be related to user
     * @param branchId   - if specified, - branch, that will be used to link bankUser to customer
     */
    @io.qameta.allure.Step(value = "\u0423\u0434\u043e\u0441\u0442\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0441\u044f, \u0447\u0442\u043e \u0431\u0430\u043d\u043a\u043e\u0432\u0441\u043a\u0438\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \'{bankUser.login}\' \u0441\u0432\u044f\u0437\u0430\u043d \u0441 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0435\u0439 [{customerId}] (\u0447\u0435\u0440\u0435\u0437 \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435 [{branchId}])")
    public final void ensureBankUserIsRelatedToCustomer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User bankUser, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId) {
    }
    
    /**
     * Check if provided client user is related to customer with provided id (through branch with providedId, if specified).
     * Create relation if it doesn't exist.
     *
     * @param clientUser - user, that has to be related to customer
     * @param customerId - customer, that has to be related to user
     */
    @io.qameta.allure.Step(value = "\u0423\u0434\u043e\u0441\u0442\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0441\u044f, \u0447\u0442\u043e \u043a\u043b\u0438\u0435\u043d\u0442\u0441\u043a\u0438\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044c \'{clientUser.login}\' \u0441\u0432\u044f\u0437\u0430\u043d \u0441 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0435\u0439 [{customerId}]")
    public final void ensureClientUserIsRelatedToCustomer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User clientUser, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041a\u043b\u0438\u0435\u043d\u0442 \u0431\u0430\u043d\u043a\u0430")
    public final ooo.jtc.dictionaries.customer.CustomerDto createCustomerDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User customerUser, boolean forUi, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.customer.CustomerDto customerForCreate, boolean withBranchCustomer, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.UUID, ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto> createBranchCustomer, boolean withCustomerRepresentative, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.UUID, ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto> createCustomerRepresentative, boolean withLocAddress, boolean withRegAddress, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.dictionaries.common.address.AddressDto> prepareAddress, boolean withKpp, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.dictionaries.customerkpp.CustomerKppDto> prepareCustomerKpp, boolean withAccount, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.UUID, ooo.jtc.dictionaries.account.AccountDto> createAccount) {
        return null;
    }
    
    /**
     * Delete Customer and related entities:
     * * Contractor - all related to provided Customer (and all Contractor data);
     * * Account - all accounts, related to provided Customer;
     * * CustomerRepresentative - for all Customers, related to provided Customer;
     * * BranchCustomer - all records, related to provided Customer.
     *
     *
     * (!)WARNINGS(!)
     *
     * This method wasn't properly tested yet. Use with caution!
     *
     * @param customerId id of a customer (with related entities)
     */
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u044e [{customerId}] \u0438 \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u044b\u0435 \u0441 \u043d\u0435\u044e \u0434\u0430\u043d\u043d\u044b\u0435, \u0435\u0441\u043b\u0438 \u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e (\u043d\u0435\u0442 \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u044b\u0445 \u041f\u041f, \u043f\u0438\u0441\u0435\u043c, ...)")
    public final void deleteCustomerAndRelatedEntitiesIfPossible(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, boolean deleteAtOnly) {
    }
    
    private CustomerPrepareSteps() {
        super();
    }
}