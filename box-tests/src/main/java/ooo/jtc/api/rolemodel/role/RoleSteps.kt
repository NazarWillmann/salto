package ooo.jtc.api.rolemodel.role

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi.Companion.defaultStatusCheck
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.EntityAndListResponseDto
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.generic.GenericPageResponseDto
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.rolemodel.role.RoleDto
import ooo.jtc.rolemodel.trees.GroupTreeDto
import ooo.jtc.rolemodel.trees.ProductTreeDto
import ooo.jtc.rolemodel.trees.RoleTreeDto
import ooo.jtc.serialization.SerializationUtils
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import ooo.jtc.uaa.resource.dto.ResourceDto
import java.util.UUID

class RoleSteps(user: User = Users.systemSecurityAdmin) :
    AbstractDictionarySteps<RoleDto, RoleDto>(
        user = user,
        entity = RoleDto::class.java,
        service = Services.DOMAIN_CONTROLLER,
        dictionaryName = "role"
    ) {

// Sergeyev [2021.08.05]: domain-controller.role == uaa.scope ('oauth_scope')
    override fun addToFavorites(entityId: UUID, withCheckResponseCode: Boolean): GenericResponseDto<RoleDto> =
        throw RuntimeException("Not supported")
    override fun removeFromFavorites(entityId: UUID, withCheckResponseCode: Boolean): GenericResponseDto<RoleDto> =
        throw RuntimeException("Not supported")

    //region Some local request DTOs
    private fun getTreeForRoleRequestDto(
        roleId: UUID, showIncluded: Boolean, showNonIncluded: Boolean
    ): Map<String, *> = mapOf(
        "roleId" to roleId,
        "showIncluded" to showIncluded,
        "showNonIncluded" to showNonIncluded
    )
    private fun getRoleIdToGroupsIdsDto(
        roleId: UUID, groupIdsList: List<UUID>
    ): Map<String, *> = mapOf(
        "roleId" to roleId,
        "groups" to groupIdsList
    )
    private fun getGroupIdToRoleIds(
        prGroupId: UUID, roleIdsList: List<UUID>
    ): Map<String, *> = mapOf(
        "groupId" to prGroupId,
        "roles" to roleIdsList
    )
    //endregion

    //region Local response types
    private val resourceListType by lazy { SerializationUtils.constructType(GenericListResponseDto::class.java, ResourceDto::class.java) }
    private val groupToRoleListType by lazy {
        SerializationUtils.constructType(
            EntityAndListResponseDto::class.java,
            PrivilegeGroupDto::class.java, RoleDto::class.java
        )
    }
    private val roleToGroupListType by lazy {
        SerializationUtils.constructType(
            EntityAndListResponseDto::class.java,
            RoleDto::class.java, PrivilegeGroupDto::class.java
        )
    }
    private val groupTreeResponseType by lazy { SerializationUtils.constructType(GenericListResponseDto::class.java, GroupTreeDto::class.java) }
    private val productTreeResponseType by lazy { SerializationUtils.constructType(GenericListResponseDto::class.java, ProductTreeDto::class.java) }
    //endregion


    @Step("Добавить Группу привилегий [{prGroupId}] списку Ролей")
    fun addPrivilegeGroupToRoles(
        prGroupId: UUID, roleIdsList: List<UUID>,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): EntityAndListResponseDto<PrivilegeGroupDto, RoleDto> {
        return stepApi.send(
            method = {
                body(getGroupIdToRoleIds(prGroupId, roleIdsList))
                post("$servicePath/AddPrivilegeGroupToRoles")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(groupToRoleListType)
    }

    @Step("Добавить список Групп привилегий Роли [{roleId}]")
    fun addPrivilegeGroupsToRole(
        roleId: UUID, groupIdsList: List<UUID>,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): EntityAndListResponseDto<RoleDto, PrivilegeGroupDto> {
        return stepApi.send(
            method = {
                body(getRoleIdToGroupsIdsDto(roleId, groupIdsList))
                post("$servicePath/AddPrivilegeGroupsToRole")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(roleToGroupListType)
    }

    @Step("Создать копию Роли [{roleId}]")
    fun createRoleCopy(
        roleId: UUID, name: String, copyGroups: Boolean, copyUsers: Boolean,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): GenericResponseDto<RoleDto> {
        return stepApi.send(
            method = {
                body(
                    mapOf(
                        "roleId" to roleId,
                        "name" to name,
                        "copyGroups" to copyGroups,
                        "copyUsers" to copyUsers,
                    )
                )
                post("$servicePath/CreateRoleCopy")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responseType)
    }

    @Step("Получить доступные Ресурсы")
    fun getAvailableResources(withCheckResponseCode: Boolean = true, statusCode: Int = 200): GenericListResponseDto<ResourceDto> {
        return stepApi.send(
            method = {
                body("{}")
                post("$servicePath/GetAvailableResources")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(resourceListType)
    }

    @Step("Получить список Ролей, использующих Группу привилегий [{prGroupId}]")
    fun getContainingRolesForPrivilegeGroup(
        prGroupId: UUID, additionalParams: Params = Params(),
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): GenericPageResponseDto<RoleDto> {
        return stepApi.send(
            method = {
                body(mapOf("groupId" to prGroupId, "params" to additionalParams))
                post("$servicePath/GetContainingRolesForPrivilegeGroup")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(responsePageType)
    }

    @Step("Получить дерево Групп для Роли [{roleId}]")
    fun getGroupTreeForRole(
        roleId: UUID, showIncluded: Boolean, showNonIncluded: Boolean,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): GenericListResponseDto<GroupTreeDto> {
        return stepApi.send(
            method = {
                body(getTreeForRoleRequestDto(roleId, showIncluded, showNonIncluded))
                post("$servicePath/GetGroupTreeForRole")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(groupTreeResponseType)
    }

    @Step("Получить дерево Привилегий для Роли [{roleId}]")
    fun getPrivilegeTreeForRole(
        roleId: UUID, showIncluded: Boolean, showNonIncluded: Boolean,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): GenericListResponseDto<ProductTreeDto> {
        return stepApi.send(
            method = {
                body(getTreeForRoleRequestDto(roleId, showIncluded, showNonIncluded))
                post("$servicePath/GetPrivilegeTreeForRole")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(productTreeResponseType)
    }

    @Step("Получить дерево Ролей")
    fun getRoleTree(withCheckResponseCode: Boolean = true, statusCode: Int = 200): RoleTreeDto {
        return stepApi.send(
            method = {
                body("{}")
                post("$servicePath/GetRoleTree")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(RoleTreeDto::class.java)
    }

    @Step("Удалить Группу привилегий [{prGroupId}] из списка Ролей")
    fun removePrivilegeGroupFromRoles(
        prGroupId: UUID, roleIdsList: List<UUID>,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): EntityAndListResponseDto<PrivilegeGroupDto, RoleDto> {
        return stepApi.send(
            method = {
                body(getGroupIdToRoleIds(prGroupId, roleIdsList))
                post("$servicePath/RemovePrivilegeGroupFromRoles")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(groupToRoleListType)
    }

    @Step("Удалить список Групп привилегий из Роли [{roleId}]")
    fun removePrivilegeGroupsFromRole(
        roleId: UUID, groupIdsList: List<UUID>,
        withCheckResponseCode: Boolean = true, statusCode: Int = 200
    ): EntityAndListResponseDto<RoleDto, PrivilegeGroupDto> {
        return stepApi.send(
            method = {
                body(getRoleIdToGroupsIdsDto(roleId, groupIdsList))
                post("$servicePath/RemovePrivilegeGroupsFromRole")
            },
            check = defaultStatusCheck(withCheckResponseCode, statusCode)
        ).responseAs(roleToGroupListType)
    }
}