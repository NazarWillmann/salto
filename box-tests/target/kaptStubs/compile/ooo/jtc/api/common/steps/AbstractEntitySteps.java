package ooo.jtc.api.common.steps;

import java.lang.System;

/**
 * Base class for implements base steps for [IEntityDto]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u000e\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B#\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u00a2\u0006\u0002\u0010\fJ \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0017J/\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010\r\u001a\u00028\u00002\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017\u00a2\u0006\u0002\u0010/J*\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00101\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017J*\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u00101\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017J\u001c\u00103\u001a\u0002042\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0007J\u001c\u00105\u001a\u0002062\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017J,\u00107\u001a\b\u0012\u0004\u0012\u00028\u0000082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017J6\u0010;\u001a\b\u0012\u0004\u0012\u00028\u0000082\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020.2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0007J \u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0017J1\u0010>\u001a\b\u0012\u0004\u0012\u0002H\u00010?\"\u0004\b\u0002\u0010\u0001\"\u000e\b\u0003\u0010@*\b\u0012\u0004\u0012\u0002H\u00010?2\u0006\u0010\r\u001a\u0002H\u0001H&\u00a2\u0006\u0002\u0010AJ$\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017J/\u0010D\u001a\b\u0012\u0004\u0012\u00028\u00000\'2\u0006\u0010\r\u001a\u00028\u00012\b\b\u0002\u0010*\u001a\u00020+2\b\b\u0002\u0010-\u001a\u00020.H\u0017\u00a2\u0006\u0002\u0010ER\u0012\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u0015X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R\u001a\u0010 \u001a\u00020!X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006F"}, d2 = {"Looo/jtc/api/common/steps/AbstractEntitySteps;", "T", "Looo/jtc/interfaces/IEntityDto;", "U", "Looo/jtc/interfaces/UpdateIEntityDto;", "Looo/jtc/api/common/steps/AbstractApiSteps;", "user", "Looo/jtc/uaa/User;", "service", "Looo/jtc/testdata/Service;", "entityClass", "Ljava/lang/Class;", "(Looo/jtc/uaa/User;Looo/jtc/testdata/Service;Ljava/lang/Class;)V", "entity", "entityName", "", "getEntityName", "()Ljava/lang/String;", "setEntityName", "(Ljava/lang/String;)V", "responseListType", "Lcom/fasterxml/jackson/databind/JavaType;", "getResponseListType", "()Lcom/fasterxml/jackson/databind/JavaType;", "setResponseListType", "(Lcom/fasterxml/jackson/databind/JavaType;)V", "responsePageType", "getResponsePageType", "setResponsePageType", "responseType", "getResponseType", "setResponseType", "stepApi", "Looo/jtc/core/api/CoreApi;", "getStepApi", "()Looo/jtc/core/api/CoreApi;", "setStepApi", "(Looo/jtc/core/api/CoreApi;)V", "addToFavorites", "Looo/jtc/generic/GenericResponseDto;", "entityId", "Ljava/util/UUID;", "withCheckResponseCode", "", "create", "statusCode", "", "(Looo/jtc/interfaces/IEntityDto;ZI)Looo/jtc/generic/GenericResponseDto;", "delete", "id", "getById", "getControlSettingsDescription", "Lcom/jayway/jsonpath/DocumentContext;", "getMetadata", "Looo/jtc/generic/MetadataResponseDto;", "getPage", "Looo/jtc/generic/GenericPageResponseDto;", "getPageRequest", "Looo/jtc/generic/pageparams/GetPageRequest;", "getPageAll", "limit", "removeFromFavorites", "requestDtoWrapper", "Looo/jtc/generic/GenericDto;", "R", "(Ljava/lang/Object;)Looo/jtc/generic/GenericDto;", "setControlSettings", "body", "update", "(Looo/jtc/interfaces/UpdateIEntityDto;ZI)Looo/jtc/generic/GenericResponseDto;", "box-tests"})
public abstract class AbstractEntitySteps<T extends ooo.jtc.interfaces.IEntityDto, U extends ooo.jtc.interfaces.UpdateIEntityDto<T>> extends ooo.jtc.api.common.steps.AbstractApiSteps {
    @org.jetbrains.annotations.NotNull()
    private com.fasterxml.jackson.databind.JavaType responseType;
    @org.jetbrains.annotations.NotNull()
    private com.fasterxml.jackson.databind.JavaType responseListType;
    @org.jetbrains.annotations.NotNull()
    private com.fasterxml.jackson.databind.JavaType responsePageType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String entityName;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.api.CoreApi stepApi;
    private java.lang.Class<?> entity;
    
    @org.jetbrains.annotations.NotNull()
    public abstract <T extends java.lang.Object, R extends ooo.jtc.generic.GenericDto<T>>ooo.jtc.generic.GenericDto<T> requestDtoWrapper(T entity);
    
    @org.jetbrains.annotations.NotNull()
    protected final com.fasterxml.jackson.databind.JavaType getResponseType() {
        return null;
    }
    
    protected final void setResponseType(@org.jetbrains.annotations.NotNull()
    com.fasterxml.jackson.databind.JavaType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.fasterxml.jackson.databind.JavaType getResponseListType() {
        return null;
    }
    
    protected final void setResponseListType(@org.jetbrains.annotations.NotNull()
    com.fasterxml.jackson.databind.JavaType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.fasterxml.jackson.databind.JavaType getResponsePageType() {
        return null;
    }
    
    protected final void setResponsePageType(@org.jetbrains.annotations.NotNull()
    com.fasterxml.jackson.databind.JavaType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEntityName() {
        return null;
    }
    
    public final void setEntityName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final ooo.jtc.core.api.CoreApi getStepApi() {
        return null;
    }
    
    protected final void setStepApi(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.api.CoreApi p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \'{this.entityName}\'")
    public ooo.jtc.generic.GenericResponseDto<T> create(@org.jetbrains.annotations.NotNull()
    T entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \'{this.entityName}\' \u043f\u043e id={id}")
    public ooo.jtc.generic.GenericResponseDto<T> getById(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \'{this.entityName}\'")
    public ooo.jtc.generic.GenericPageResponseDto<T> getPage(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest getPageRequest, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0432\u0441\u0435\u0445 \u0437\u0430\u043f\u0438\u0441\u0435\u0439 \'{this.entityName}\'")
    public final ooo.jtc.generic.GenericPageResponseDto<T> getPageAll(@org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.GetPageRequest getPageRequest, int limit, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0437\u043c\u0435\u043d\u0438\u0442\u044c \'{this.entityName}\' \u0441 id = {entity.id}")
    public ooo.jtc.generic.GenericResponseDto<T> update(@org.jetbrains.annotations.NotNull()
    U entity, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \'{this.entityName}\' \u043f\u043e id={id}")
    public ooo.jtc.generic.GenericResponseDto<T> delete(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c Metadata \u0434\u043b\u044f \'{this.entityName}\'")
    public ooo.jtc.generic.MetadataResponseDto getMetadata(boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u0435\u0439 \u0434\u043b\u044f \'{this.entityName}\'")
    public final com.jayway.jsonpath.DocumentContext getControlSettingsDescription(boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0420\u0435\u0434\u0430\u043a\u0442\u0438\u0440\u043e\u0432\u0430\u0442\u044c \u043d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438 \u043a\u043e\u043d\u0442\u0440\u043e\u043b\u0435\u0439 \u0434\u043b\u044f \'{this.entityName}\'")
    public com.jayway.jsonpath.DocumentContext setControlSettings(@org.jetbrains.annotations.NotNull()
    java.lang.String body, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0432 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0435 {this.entityName} [{entityId}]")
    public ooo.jtc.generic.GenericResponseDto<T> addToFavorites(@org.jetbrains.annotations.NotNull()
    java.util.UUID entityId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0438\u0437 \u0438\u0437\u0431\u0440\u0430\u043d\u043d\u043e\u0433\u043e {this.entityName} [{entityId}]")
    public ooo.jtc.generic.GenericResponseDto<T> removeFromFavorites(@org.jetbrains.annotations.NotNull()
    java.util.UUID entityId, boolean withCheckResponseCode) {
        return null;
    }
    
    public AbstractEntitySteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    ooo.jtc.testdata.Service service, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> entityClass) {
        super(null, null);
    }
}