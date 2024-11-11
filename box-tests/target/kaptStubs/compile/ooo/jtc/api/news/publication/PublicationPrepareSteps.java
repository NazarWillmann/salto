package ooo.jtc.api.news.publication;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\fH\u0007J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0003J\"\u0010&\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J,\u0010*\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020,H\u0007J\"\u0010-\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J\"\u0010.\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J\"\u0010/\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J\"\u00100\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J\"\u00101\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J\"\u00102\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J$\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u00020\u00192\b\b\u0002\u0010\'\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J&\u00105\u001a\u00020\u00052\b\b\u0002\u0010\'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J,\u00106\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010)\u001a\u00020\u0005H\u0007J,\u00107\u001a\u00020\u00052\u0006\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010+\u001a\u00020,H\u0007J,\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00192\f\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\f2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020!0\fJ(\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00192\b\b\u0002\u0010(\u001a\u00020\u00192\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020!0\fJ*\u0010=\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00192\n\b\u0002\u0010>\u001a\u0004\u0018\u00010;2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020!0\fJ&\u0010=\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\u00192\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020!0\fJ\u001e\u0010?\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u00192\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u00020!0\fJ`\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010A\u001a\u00020\u00192\b\b\u0002\u0010\'\u001a\u00020\u00192\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0014\b\u0002\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020F0\u000b2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050C2\b\b\u0002\u0010H\u001a\u00020,H\u0007JP\u0010I\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u00192\b\b\u0002\u0010\'\u001a\u00020\u00192\u000e\b\u0002\u0010B\u001a\b\u0012\u0004\u0012\u00020D0C2\u0014\b\u0002\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020F0\u000b2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00050CH\u0007J0\u0010J\u001a\u00020\u00052\n\b\u0002\u0010>\u001a\u0004\u0018\u00010;2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020F2\u0006\u0010N\u001a\u00020OH\u0002J\u000e\u0010P\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005J\u000e\u0010Q\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019J\u000e\u0010R\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u0019R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R)\u0010\n\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\u0010\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR,\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00050\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006S"}, d2 = {"Looo/jtc/api/news/publication/PublicationPrepareSteps;", "", "()V", "docChecks", "Looo/jtc/api/common/checks/ApiDocumentChecks;", "Looo/jtc/news/dto/PublicationDto;", "getDocChecks", "()Looo/jtc/api/common/checks/ApiDocumentChecks;", "docChecks$delegate", "Lkotlin/Lazy;", "prepareAttachmentsForComparison", "Lkotlin/Function1;", "", "Looo/jtc/news/dto/NewsAttachmentDto;", "getPrepareAttachmentsForComparison", "()Lkotlin/jvm/functions/Function1;", "prepareCustomersForComparison", "Looo/jtc/news/dto/ReceiverCustomerDto;", "getPrepareCustomersForComparison", "removeAttachmentsTokens", "Lkotlin/ParameterName;", "name", "publication", "getRemoveAttachmentsTokens", "superUser", "Looo/jtc/uaa/User;", "getSuperUser", "()Looo/jtc/uaa/User;", "superUser$delegate", "addAttachmentsToDto", "pblDto", "creatorUser", "files", "Ljava/io/File;", "changePublicationStatus_DIRTY", "publDto", "status", "Looo/jtc/news/PublicationStatus;", "createAutoFinishErrorPublication_DIRTY", "creatorBankUser", "receiverClientUser", "dtoForCreate", "createAutoFinishedPublication", "seconds", "", "createAutoPostErrorPublication_DIRTY", "createAutoPostedPublication", "createDraftPublication", "createManuallyFinishedPublication", "createManuallyPostedPublication", "createNewPublication", "createPublicationAvailableToUser", "user", "createPublicationDto", "createPublicationInStatus", "createWaitingForAutoPostPublication", "getClientSpecificPublicationDtoForCreate", "relatedBankUser", "customerIds", "Ljava/util/UUID;", "attachments", "getGeneralPublicationDtoForCreate", "branchId", "getGlobalGeneralPublicationDtoForCreate", "getOrCreateDifferentPublicationDtoList", "searchingUser", "getPageRequest", "Lkotlin/Function0;", "Looo/jtc/generic/pageparams/GetPageRequest;", "additionalFilter", "", "createDocFunc", "amount", "getOrCreatePublicationDto", "getPublicationDtoForCreate", "branchName", "", "isForAllBranches", "targetType", "Looo/jtc/news/dto/PublicationTargetType;", "getPublicationDtoForUpdate", "retrieveBankUser", "retrieveClientUser", "box-tests"})
public final class PublicationPrepareSteps {
    private static final kotlin.Lazy docChecks$delegate = null;
    private static final kotlin.Lazy superUser$delegate = null;
    
    /**
     * Null all attachments' [accessToken]s from Publication for proper DTO comparison
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<ooo.jtc.news.dto.PublicationDto, ooo.jtc.news.dto.PublicationDto> removeAttachmentsTokens = null;
    
    /**
     * Prepare list of publication attachments for comparison
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.util.List<ooo.jtc.news.dto.NewsAttachmentDto>, java.util.List<ooo.jtc.news.dto.NewsAttachmentDto>> prepareAttachmentsForComparison = null;
    
    /**
     * Prepare list of publication receiver customers for comparison
     */
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.jvm.functions.Function1<java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto>, java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto>> prepareCustomersForComparison = null;
    public static final ooo.jtc.api.news.publication.PublicationPrepareSteps INSTANCE = null;
    
    private final ooo.jtc.api.common.checks.ApiDocumentChecks<ooo.jtc.news.dto.PublicationDto> getDocChecks() {
        return null;
    }
    
    private final ooo.jtc.uaa.User getSuperUser() {
        return null;
    }
    
    /**
     * Retrieve (Publication) client user.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveClientUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    /**
     * Retrieve (Publication) bank user.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.uaa.User retrieveBankUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final ooo.jtc.news.dto.PublicationDto getOrCreatePublicationDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.news.dto.PublicationDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.news.dto.PublicationDto> createDocFunc) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041d\u0430\u0439\u0442\u0438 \u043d\u0430\u0431\u043e\u0440 \u0440\u0430\u0437\u043d\u044b\u0445 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u043e\u0432 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\' \u0438\u043b\u0438 \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0438\u0445 \u043d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e\u0435 \u043a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e, \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u043e\u0435 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {searchingUser.login}")
    public final java.util.List<ooo.jtc.news.dto.PublicationDto> getOrCreateDifferentPublicationDtoList(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User searchingUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.generic.pageparams.GetPageRequest> getPageRequest, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ooo.jtc.news.dto.PublicationDto, java.lang.Boolean> additionalFilter, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<ooo.jtc.news.dto.PublicationDto> createDocFunc, long amount) {
        return null;
    }
    
    /**
     * Method for preparing [PublicationTargetType.GENERAL] publication.
     * For all branches and thus - all customers ([isForAllBranches] = [true])
     * N.B.: creating user must be a 'superuser'
     *
     * @param relatedBankUser       bank (super-)user, who can create this publication and will have access to it afterwards
     * @param attachments           list of attachments for publication
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto getGlobalGeneralPublicationDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User relatedBankUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    /**
     * Method for preparing [PublicationTargetType.GENERAL] publication.
     * For a single branch and thus - all related to the branch customers ([isForAllBranches] = [false])
     *
     * (!) WARNING (!)
     * Possible changes to branch/customer/branchCustomer dictionaries
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param branchId              branch, available to [relatedBankUser]. If not specified, or not available to provided
     * user - publication will be created for random available branch. [null] by default
     * @param attachments           list of attachments for publication
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto getGeneralPublicationDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User relatedBankUser, @org.jetbrains.annotations.Nullable()
    java.util.UUID branchId, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    /**
     * Method for preparing [PublicationTargetType.GENERAL] publication.
     * For a single branch, available to both provided users
     *
     * (!) WARNING (!)
     * Possible changes to branch/customer/branchCustomer dictionaries
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param receiverClientUser    customer user, who will have access to this publication
     * @param attachments           list of attachments for publication
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto getGeneralPublicationDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User relatedBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    /**
     * Method for preparing [PublicationTargetType.DIRECT] publication.
     * For any single customer, available to both provided users.
     *
     * (!) WARNING (!)
     * Possible changes to branch/customer/branchCustomer dictionaries
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param receiverClientUser    customer user, who will have access to this publication
     * @param attachments           list of attachments for publication
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto getClientSpecificPublicationDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User relatedBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    /**
     * Method for preparing [PublicationTargetType.DIRECT] publication.
     * For specified non-empty list (1+) customers, available to both users AND linked to
     * at least one common branch, available for provided [relatedBankUser]
     *
     * @param relatedBankUser       bank (operator) user, who can create this publication and will have access to it afterwards
     * @param customerIds           non-empty list of targeted customers.
     * All users, related to these customers will have access to this publication. Customers must be
     * - available to both provided users
     * - linked to at least one common branch
     * @param attachments           list of attachments for publication
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto getClientSpecificPublicationDtoForCreate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User relatedBankUser, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> customerIds, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> attachments) {
        return null;
    }
    
    private final ooo.jtc.news.dto.PublicationDto getPublicationDtoForCreate(java.util.UUID branchId, java.lang.String branchName, boolean isForAllBranches, ooo.jtc.news.dto.PublicationTargetType targetType) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.news.dto.PublicationDto getPublicationDtoForUpdate(@org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto pblDto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432\u043b\u043e\u0436\u0435\u043d\u0438\u044f \u043a DTO \u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u0438 [{pblDto.id}]")
    public final ooo.jtc.news.dto.PublicationDto addAttachmentsToDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto pblDto, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorUser, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends java.io.File> files) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044f\u043c {creatorBankUser.login}, {receiverClientUser.login}")
    public final ooo.jtc.news.dto.PublicationDto createPublicationDto(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\', \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0439 \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u044e {user.login}")
    public final ooo.jtc.news.dto.PublicationDto createPublicationAvailableToUser(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\' \u0432 \u0441\u0442\u0430\u0442\u0443\u0441\u0435 \'{status}\' \u0434\u043b\u044f \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0435\u0439 {creatorBankUser.login}, {receiverClientUser.login}")
    public final ooo.jtc.news.dto.PublicationDto createPublicationInStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.PublicationStatus status, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0447\u0435\u0440\u043d\u043e\u0432\u0438\u043a \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createDraftPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043d\u043e\u0432\u044b\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createNewPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    /**
     * For publication to be manually posted it must have [startAt] = [null]
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0440\u0430\u0437\u043c\u0435\u0449\u0451\u043d\u043d\u044b\u0439 \u0432\u0440\u0443\u0447\u043d\u0443\u044e \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createManuallyPostedPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    /**
     * For publication to await for automatic posting it must have non-null [startAt] and its value must be greater that current time on server.
     *
     * Publication will be automatically posted in
     * @param seconds
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u0436\u0438\u0434\u0430\u044e\u0449\u0438\u0439 \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u043e\u0433\u043e \u0440\u0430\u0437\u043c\u0435\u0449\u0435\u043d\u0438\u044f \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createWaitingForAutoPostPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate, long seconds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0440\u0430\u0437\u043c\u0435\u0449\u0451\u043d\u043d\u044b\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createAutoPostedPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    /**
     * For publication to await for automatic posting it must have non-null [endAt] and its value must be equal or less that current time on server.
     *
     * After posting publication will be automatically finished in
     * @param seconds
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0437\u0430\u0432\u0435\u0440\u0448\u0451\u043d\u043d\u044b\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createAutoFinishedPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate, long seconds) {
        return null;
    }
    
    /**
     * For publication to have the possibility to be 'finished' manually it either:
     * - must have [endAt] = [null] and be successfully posted or
     * - be in status [AUTO_FINISH_ERROR]
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0430\u0432\u0442\u043e\u043c\u0430\u0442\u0438\u0447\u0435\u0441\u043a\u0438 \u0437\u0430\u0432\u0435\u0440\u0448\u0451\u043d\u043d\u044b\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createManuallyFinishedPublication(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0440\u0430\u0437\u043c\u0435\u0449\u0451\u043d\u043d\u044b\u0439 \u0441 \u043e\u0448\u0438\u0431\u043a\u043e\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createAutoPostErrorPublication_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u0437\u0430\u0432\u0435\u0440\u0448\u0451\u043d\u043d\u044b\u0439 \u0441 \u043e\u0448\u0438\u0431\u043a\u043e\u0439 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442 \'\u041f\u0443\u0431\u043b\u0438\u043a\u0430\u0446\u0438\u044f\'")
    public final ooo.jtc.news.dto.PublicationDto createAutoFinishErrorPublication_DIRTY(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User creatorBankUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User receiverClientUser, @org.jetbrains.annotations.NotNull()
    ooo.jtc.news.dto.PublicationDto dtoForCreate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<ooo.jtc.news.dto.PublicationDto, ooo.jtc.news.dto.PublicationDto> getRemoveAttachmentsTokens() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.util.List<ooo.jtc.news.dto.NewsAttachmentDto>, java.util.List<ooo.jtc.news.dto.NewsAttachmentDto>> getPrepareAttachmentsForComparison() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto>, java.util.List<ooo.jtc.news.dto.ReceiverCustomerDto>> getPrepareCustomersForComparison() {
        return null;
    }
    
    @io.qameta.allure.Step(value = "\u041d\u0430\u043f\u0440\u044f\u043c\u0443\u044e \u0432 \u0411\u0414 \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0441\u0442\u0430\u0442\u0443\u0441 \u0434\u043e\u043a\u0443\u043c\u0435\u043d\u0442\u0430 [{publDto.id}] \u043d\u0430 \'status\'")
    private final ooo.jtc.news.dto.PublicationDto changePublicationStatus_DIRTY(ooo.jtc.news.dto.PublicationDto publDto, ooo.jtc.news.PublicationStatus status) {
        return null;
    }
    
    private PublicationPrepareSteps() {
        super();
    }
}