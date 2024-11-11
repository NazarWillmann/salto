package ooo.jtc.api.rolemodel.role;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J>\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J>\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J\u001e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020\'2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016JB\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\'2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020 2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J\"\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J4\u00101\u001a\b\u0012\u0004\u0012\u00020\u0002022\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J(\u00105\u001a\f\u0012\u0004\u0012\u00020+\u0012\u0002\b\u0003062\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J:\u00107\u001a\b\u0012\u0004\u0012\u0002080/2\u0006\u0010$\u001a\u00020\u001c2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J:\u0010;\u001a\b\u0012\u0004\u0012\u00020<0/2\u0006\u0010$\u001a\u00020\u001c2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J(\u0010=\u001a\f\u0012\u0004\u0012\u00020+\u0012\u0002\b\u0003062\u0006\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001eH\u0002J\u001c\u0010>\u001a\u00020?2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J*\u0010@\u001a\f\u0012\u0004\u0012\u00020+\u0012\u0002\b\u0003062\u0006\u0010$\u001a\u00020\u001c2\u0006\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020 H\u0002J\u001e\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00020\'2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0016J>\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007J>\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010$\u001a\u00020\u001c2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"H\u0007R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u001b\u0010\u000f\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0010\u0010\tR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0013\u0010\tR\u001b\u0010\u0015\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0016\u0010\t\u00a8\u0006D"}, d2 = {"Looo/jtc/api/rolemodel/role/RoleSteps;", "Looo/jtc/api/common/steps/AbstractDictionarySteps;", "Looo/jtc/rolemodel/role/RoleDto;", "user", "Looo/jtc/uaa/User;", "(Looo/jtc/uaa/User;)V", "groupToRoleListType", "Lcom/fasterxml/jackson/databind/JavaType;", "getGroupToRoleListType", "()Lcom/fasterxml/jackson/databind/JavaType;", "groupToRoleListType$delegate", "Lkotlin/Lazy;", "groupTreeResponseType", "getGroupTreeResponseType", "groupTreeResponseType$delegate", "productTreeResponseType", "getProductTreeResponseType", "productTreeResponseType$delegate", "resourceListType", "getResourceListType", "resourceListType$delegate", "roleToGroupListType", "getRoleToGroupListType", "roleToGroupListType$delegate", "addPrivilegeGroupToRoles", "Looo/jtc/generic/EntityAndListResponseDto;", "Looo/jtc/rolemodel/privilegegroup/PrivilegeGroupDto;", "prGroupId", "Ljava/util/UUID;", "roleIdsList", "", "withCheckResponseCode", "", "statusCode", "", "addPrivilegeGroupsToRole", "roleId", "groupIdsList", "addToFavorites", "Looo/jtc/generic/GenericResponseDto;", "entityId", "createRoleCopy", "name", "", "copyGroups", "copyUsers", "getAvailableResources", "Looo/jtc/generic/GenericListResponseDto;", "Looo/jtc/uaa/resource/dto/ResourceDto;", "getContainingRolesForPrivilegeGroup", "Looo/jtc/generic/GenericPageResponseDto;", "additionalParams", "Looo/jtc/generic/pageparams/Params;", "getGroupIdToRoleIds", "", "getGroupTreeForRole", "Looo/jtc/rolemodel/trees/GroupTreeDto;", "showIncluded", "showNonIncluded", "getPrivilegeTreeForRole", "Looo/jtc/rolemodel/trees/ProductTreeDto;", "getRoleIdToGroupsIdsDto", "getRoleTree", "Looo/jtc/rolemodel/trees/RoleTreeDto;", "getTreeForRoleRequestDto", "removeFromFavorites", "removePrivilegeGroupFromRoles", "removePrivilegeGroupsFromRole", "box-tests"})
public final class RoleSteps extends ooo.jtc.api.common.steps.AbstractDictionarySteps<ooo.jtc.rolemodel.role.RoleDto, ooo.jtc.rolemodel.role.RoleDto> {
    private final kotlin.Lazy resourceListType$delegate = null;
    private final kotlin.Lazy groupToRoleListType$delegate = null;
    private final kotlin.Lazy roleToGroupListType$delegate = null;
    private final kotlin.Lazy groupTreeResponseType$delegate = null;
    private final kotlin.Lazy productTreeResponseType$delegate = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.rolemodel.role.RoleDto> addToFavorites(@org.jetbrains.annotations.NotNull()
    java.util.UUID entityId, boolean withCheckResponseCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.generic.GenericResponseDto<ooo.jtc.rolemodel.role.RoleDto> removeFromFavorites(@org.jetbrains.annotations.NotNull()
    java.util.UUID entityId, boolean withCheckResponseCode) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, ?> getTreeForRoleRequestDto(java.util.UUID roleId, boolean showIncluded, boolean showNonIncluded) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, ?> getRoleIdToGroupsIdsDto(java.util.UUID roleId, java.util.List<java.util.UUID> groupIdsList) {
        return null;
    }
    
    private final java.util.Map<java.lang.String, ?> getGroupIdToRoleIds(java.util.UUID prGroupId, java.util.List<java.util.UUID> roleIdsList) {
        return null;
    }
    
    private final com.fasterxml.jackson.databind.JavaType getResourceListType() {
        return null;
    }
    
    private final com.fasterxml.jackson.databind.JavaType getGroupToRoleListType() {
        return null;
    }
    
    private final com.fasterxml.jackson.databind.JavaType getRoleToGroupListType() {
        return null;
    }
    
    private final com.fasterxml.jackson.databind.JavaType getGroupTreeResponseType() {
        return null;
    }
    
    private final com.fasterxml.jackson.databind.JavaType getProductTreeResponseType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0413\u0440\u0443\u043f\u043f\u0443 \u043f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u0439 [{prGroupId}] \u0441\u043f\u0438\u0441\u043a\u0443 \u0420\u043e\u043b\u0435\u0439")
    public final ooo.jtc.generic.EntityAndListResponseDto<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto, ooo.jtc.rolemodel.role.RoleDto> addPrivilegeGroupToRoles(@org.jetbrains.annotations.NotNull()
    java.util.UUID prGroupId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> roleIdsList, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0414\u043e\u0431\u0430\u0432\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0413\u0440\u0443\u043f\u043f \u043f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u0439 \u0420\u043e\u043b\u0438 [{roleId}]")
    public final ooo.jtc.generic.EntityAndListResponseDto<ooo.jtc.rolemodel.role.RoleDto, ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> addPrivilegeGroupsToRole(@org.jetbrains.annotations.NotNull()
    java.util.UUID roleId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> groupIdsList, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0421\u043e\u0437\u0434\u0430\u0442\u044c \u043a\u043e\u043f\u0438\u044e \u0420\u043e\u043b\u0438 [{roleId}]")
    public final ooo.jtc.generic.GenericResponseDto<ooo.jtc.rolemodel.role.RoleDto> createRoleCopy(@org.jetbrains.annotations.NotNull()
    java.util.UUID roleId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, boolean copyGroups, boolean copyUsers, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u043e\u0441\u0442\u0443\u043f\u043d\u044b\u0435 \u0420\u0435\u0441\u0443\u0440\u0441\u044b")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.uaa.resource.dto.ResourceDto> getAvailableResources(boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0420\u043e\u043b\u0435\u0439, \u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u044e\u0449\u0438\u0445 \u0413\u0440\u0443\u043f\u043f\u0443 \u043f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u0439 [{prGroupId}]")
    public final ooo.jtc.generic.GenericPageResponseDto<ooo.jtc.rolemodel.role.RoleDto> getContainingRolesForPrivilegeGroup(@org.jetbrains.annotations.NotNull()
    java.util.UUID prGroupId, @org.jetbrains.annotations.NotNull()
    ooo.jtc.generic.pageparams.Params additionalParams, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u0435\u0440\u0435\u0432\u043e \u0413\u0440\u0443\u043f\u043f \u0434\u043b\u044f \u0420\u043e\u043b\u0438 [{roleId}]")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.rolemodel.trees.GroupTreeDto> getGroupTreeForRole(@org.jetbrains.annotations.NotNull()
    java.util.UUID roleId, boolean showIncluded, boolean showNonIncluded, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u0435\u0440\u0435\u0432\u043e \u041f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u0439 \u0434\u043b\u044f \u0420\u043e\u043b\u0438 [{roleId}]")
    public final ooo.jtc.generic.GenericListResponseDto<ooo.jtc.rolemodel.trees.ProductTreeDto> getPrivilegeTreeForRole(@org.jetbrains.annotations.NotNull()
    java.util.UUID roleId, boolean showIncluded, boolean showNonIncluded, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u041f\u043e\u043b\u0443\u0447\u0438\u0442\u044c \u0434\u0435\u0440\u0435\u0432\u043e \u0420\u043e\u043b\u0435\u0439")
    public final ooo.jtc.rolemodel.trees.RoleTreeDto getRoleTree(boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0413\u0440\u0443\u043f\u043f\u0443 \u043f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u0439 [{prGroupId}] \u0438\u0437 \u0441\u043f\u0438\u0441\u043a\u0430 \u0420\u043e\u043b\u0435\u0439")
    public final ooo.jtc.generic.EntityAndListResponseDto<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto, ooo.jtc.rolemodel.role.RoleDto> removePrivilegeGroupFromRoles(@org.jetbrains.annotations.NotNull()
    java.util.UUID prGroupId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> roleIdsList, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0423\u0434\u0430\u043b\u0438\u0442\u044c \u0441\u043f\u0438\u0441\u043e\u043a \u0413\u0440\u0443\u043f\u043f \u043f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u0439 \u0438\u0437 \u0420\u043e\u043b\u0438 [{roleId}]")
    public final ooo.jtc.generic.EntityAndListResponseDto<ooo.jtc.rolemodel.role.RoleDto, ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> removePrivilegeGroupsFromRole(@org.jetbrains.annotations.NotNull()
    java.util.UUID roleId, @org.jetbrains.annotations.NotNull()
    java.util.List<java.util.UUID> groupIdsList, boolean withCheckResponseCode, int statusCode) {
        return null;
    }
    
    public RoleSteps(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user) {
        super(null, null, null, null);
    }
    
    public RoleSteps() {
        super(null, null, null, null);
    }
}