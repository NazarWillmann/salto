package ooo.jtc.api.dictionaries.branchcustomer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u001c\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\f\u001a\u00020\bH\u0007J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004J\u001a\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\bH\u0007J&\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00142\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007\u00a8\u0006\u0016"}, d2 = {"Looo/jtc/api/dictionaries/branchcustomer/BranchCustomerPrepareSteps;", "", "()V", "createBranchCustomer", "Looo/jtc/dictionaries/branchcustomer/BranchCustomerDto;", "dtoForCreate", "ensureBranchAndCustomerAreRelated", "branchId", "Ljava/util/UUID;", "customerId", "getBranchCustomerDtoForCreate", "idBranch", "idCustomer", "customerUser", "Looo/jtc/uaa/User;", "getBranchCustomerDtoForUpdate", "createdDto", "getBranchCustomerRelationIds", "", "isBranchAndCustomerAreRelated", "Lkotlin/Pair;", "", "box-tests"})
public final class BranchCustomerPrepareSteps {
    public static final ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps INSTANCE = null;
    
    /**
     * Подготовка для кейса: Клиента ЮЛ банка [idCustomer] (клиентского пользователя [customerUser])
     * привязываем к непривязанному (к этому Клиенту ЮЛ) Подразделению.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c DTO \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u0441\u0432\u044f\u0437\u0438 \u041a\u043b\u0438\u0435\u043d\u0442\u0430 \u042e\u041b ({idCustomer}) \u0441 \u043d\u0435 \u0441\u0432\u044f\u0437\u0430\u043d\u043d\u044b\u043c \u0441 \u043d\u0438\u043c \u041f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435\u043c")
    public final ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto getBranchCustomerDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User customerUser, @org.jetbrains.annotations.NotNull()
    java.util.UUID idCustomer) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto getBranchCustomerDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID idBranch, @org.jetbrains.annotations.NotNull()
    java.util.UUID idCustomer) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto getBranchCustomerDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u0440\u043e\u0432\u0435\u0440\u0438\u0442\u044c, \u0447\u0442\u043e \u041f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435 [{branchId}] \u0438 \u041a\u043b\u0438\u0435\u043d\u0442 \u042e\u041b [{customerId}] \u0441\u0432\u044f\u0437\u0430\u043d\u044b")
    public final kotlin.Pair<java.lang.Boolean, ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto> isBranchAndCustomerAreRelated(@org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 id \u0441\u0432\u044f\u0437\u0435\u0439 \u043c\u0435\u0436\u0434\u0443 \u041f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u044f\u043c\u0438 \u0431\u0430\u043d\u043a\u0430 \u0438 \u041a\u043b\u0438\u0435\u043d\u0442\u043e\u043c \u042e\u041b \'{customerId}\'")
    public final java.util.List<java.util.UUID> getBranchCustomerRelationIds(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    /**
     * Check if customer with provided id is related to branch with provided id.
     * Create relation if it doesn't exist.
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0423\u0434\u043e\u0441\u0442\u043e\u0432\u0435\u0440\u0438\u0442\u044c\u0441\u044f, \u0447\u0442\u043e \u041f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0435 [{branchId}] \u0438 \u041a\u043b\u0438\u0435\u043d\u0442 \u042e\u041b [{customerId}] \u0441\u0432\u044f\u0437\u0430\u043d\u044b")
    public final ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto ensureBranchAndCustomerAreRelated(@org.jetbrains.annotations.NotNull()
    java.util.UUID branchId, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0441\u0432\u044f\u0437\u044c \u041a\u043b\u0438\u0435\u043d\u0442\u0430 \u042e\u041b [{dtoForCreate.customerId}] \u0438 \u041f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u044f [{dtoForCreate.branchId}] ")
    public final ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto createBranchCustomer(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto dtoForCreate) {
        return null;
    }
    
    private BranchCustomerPrepareSteps() {
        super();
    }
}