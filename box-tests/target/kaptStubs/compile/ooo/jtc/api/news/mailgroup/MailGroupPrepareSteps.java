package ooo.jtc.api.news.mailgroup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007J*\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bJ \u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J`\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0014\b\u0002\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00192\u000e\b\u0002\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00162\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006J\u000e\u0010 \u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u0006\u00a8\u0006!"}, d2 = {"Looo/jtc/api/news/mailgroup/MailGroupPrepareSteps;", "", "()V", "createMailGroup", "Looo/jtc/news/mailgroup/MailGroupDto;", "creatorBankUser", "Looo/jtc/uaa/User;", "receiverClientUser", "dtoForCreate", "getGeneralMailGroupDtoForCreate", "customerIds", "", "Ljava/util/UUID;", "getMailGroupDtoForCreate", "branchId", "branchName", "", "getMailGroupDtoForUpdate", "mailGroupDto", "getOrCreateDifferentMailGroupDtoList", "searchingUser", "getPageRequest", "Lkotlin/Function0;", "Looo/jtc/generic/pageparams/GetPageRequest;", "additionalFilter", "Lkotlin/Function1;", "", "createDocFunc", "amount", "", "retrieveBankUser", "user", "retrieveClientUser", "box-tests"})
public final class MailGroupPrepareSteps {
    public static final ooo.jtc.api.news.mailgroup.MailGroupPrepareSteps INSTANCE = null;
    
    /**
     * Retrieve (MailGroup) client user.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Retrieve (MailGroup) bank user.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.mailgroup.MailGroupDto getGeneralMailGroupDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.Nullable()
    java.util.List<java.util.UUID> customerIds) {
        return null;
    }
    
    private final ooo.jtc.news.mailgroup.MailGroupDto getMailGroupDtoForCreate(java.util.UUID branchId, java.lang.String branchName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u044c \'\u0413\u0440\u0443\u043f\u043f\u0430 \u0440\u0430\u0441\u0441\u044b\u043b\u043a\u0438 \u041a\u043b\u0438\u0435\u043d\u0442\u043e\u0432\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u0443\u044e \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f\u043c {creatorBankUser.login}, {receiverClientUser.login}")
    public final ooo.jtc.news.mailgroup.MailGroupDto createMailGroup(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.mailgroup.MailGroupDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043d\u0430\u0431\u043e\u0440 \u0440\u0430\u0437\u043d\u044b\u0445 \u0441\u0443\u0449\u043d\u043e\u0441\u0442\u0435\u0439 \'\u0413\u0440\u0443\u043f\u043f\u0430 \u0440\u0430\u0441\u0441\u044b\u043b\u043a\u0438 \u041a\u043b\u0438\u0435\u043d\u0442\u043e\u0432\' \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0438\u0445 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final java.util.List<ooo.jtc.news.mailgroup.MailGroupDto> getOrCreateDifferentMailGroupDtoList(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.news.mailgroup.MailGroupDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.news.mailgroup.MailGroupDto> createDocFunc, long amount) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.mailgroup.MailGroupDto getMailGroupDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.news.mailgroup.MailGroupDto mailGroupDto) {
        return null;
    }
    
    private MailGroupPrepareSteps() {
        super();
    }
}