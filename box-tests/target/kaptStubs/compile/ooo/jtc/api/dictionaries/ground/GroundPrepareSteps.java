package ooo.jtc.api.dictionaries.ground;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u001c\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a8\u0006\u0013"}, d2 = {"Looo/jtc/api/dictionaries/ground/GroundPrepareSteps;", "", "()V", "cleanAtCreated", "", "createGroundDto", "Looo/jtc/dictionaries/ground/GroundDto;", "customerId", "Ljava/util/UUID;", "contractorId", "dtoForCreate", "user", "Looo/jtc/uaa/User;", "forContractor", "", "getDtoForUpdate", "Looo/jtc/dictionaries/ground/GroundUpdateRequest;", "createdDto", "getGroundDtoForCreate", "box-tests"})
public final class GroundPrepareSteps {
    public static final ooo.jtc.api.dictionaries.ground.GroundPrepareSteps INSTANCE = null;
    
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043e\u0437\u0434\u0430\u043d\u043d\u044b\u0435 \u0430\u0432\u0442\u043e\u0442\u0435\u0441\u0442\u0430\u043c\u0438 \u0434\u0430\u043d\u043d\u044b\u0435 Ground \u0438\u0437 \u0411\u0414")
    public final void cleanAtCreated() {
    }
    
    /**
     * Prepares GroundDto for random [user]-related Customer
     *
     * @param user          - user that will have access to prepared GroundDto after creation (through available Customer)
     * @param forContractor - boolean flag; set as [false] if you need a GroundDto related directly to [user]-related Customer
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.ground.GroundDto getGroundDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, boolean forContractor) {
        return null;
    }
    
    /**
     * Prepares GroundDto for specified [customerId] and specified [contractorId]
     *
     * @param customerId   - id of a customer to which prepared GroundDto will be related after creation
     * @param contractorId - id of a contractor to which prepared GroundDto will be related after creation;
     *                      Set as [null] if you need a GroundDto related directly to Customer
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0442\u0435\u0441\u0442\u043e\u0432\u043e\u0435 DTO \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u041d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043f\u043b\u0430\u0442\u0435\u0436\u0430 ")
    public final ooo.jtc.dictionaries.ground.GroundDto getGroundDtoForCreate(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID contractorId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u0434\u0433\u043e\u0442\u043e\u0432\u0438\u0442\u044c \u0442\u0435\u0441\u0442\u043e\u0432\u043e\u0435 DTO \u0434\u043b\u044f \u043e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u044f \u041d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043f\u043b\u0430\u0442\u0435\u0436\u0430 ")
    public final ooo.jtc.dictionaries.ground.GroundUpdateRequest getDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.ground.GroundDto createdDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043f\u043b\u0430\u0442\u0435\u0436\u0430 \u0434\u043b\u044f \u043b\u044e\u0431\u043e\u0439 \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0439 \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f {user.login}; \'\u0434\u043b\u044f \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430\' = {forContractor}")
    public final ooo.jtc.dictionaries.ground.GroundDto createGroundDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, boolean forContractor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u041d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043f\u043b\u0430\u0442\u0435\u0436\u0430 \u0434\u043b\u044f \u043e\u0440\u0433\u0430\u043d\u0438\u0437\u0430\u0446\u0438\u0438 [{customerId}] \u0438 \u043a\u043e\u043d\u0442\u0440\u0430\u0433\u0435\u043d\u0442\u0430 [{contractorId}]")
    public final ooo.jtc.dictionaries.ground.GroundDto createGroundDto(@org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID contractorId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.ground.GroundDto createGroundDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.ground.GroundDto dtoForCreate) {
        return null;
    }
    
    private GroundPrepareSteps() {
        super();
    }
}