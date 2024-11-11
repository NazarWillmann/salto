package ooo.jtc.api.rolemodel.privilegegroup

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.rolemodel.privilegegroup.PrivilegeGroupData
import kotlin.random.Random

object PrivilegeGroupPrepareSteps {

    @Step("Удалить созданные автотестами данные PrivilegeGroup из БД")
    fun cleanAtCreated() {
        PrivilegeGroupData.get()
            .filter { PrivilegeGroupData.atMarkerPredicate(it) }
            .forEach { role -> PrivilegeGroupData.removeRecord?.let { it(role) } }
    }

    @Step("Подготовить тестовый '${RoleModelNames.PRIVILEGE_GROUP}' по умолчанию")
    fun preparePrivilegeGroupDtoForCreate(): PrivilegeGroupDto {
       val rand = Random.nextInt(4999)
        return PrivilegeGroupDto(
            id = null,
            version = 0,
            name = "Test PrivilegeGroup $rand${TestConstants.AT_POSTFIX}",
            description = "PrivilegeGroup for AT $rand",
            groups = emptyList(),
            privileges = emptyList()
        )
    }

    @Step("Подготовить '${RoleModelNames.PRIVILEGE_GROUP}' для обновления")
    fun preparePrivilegeGroupDtoForUpdate(createdDto: PrivilegeGroupDto): PrivilegeGroupDto {
        return createdDto.copy(
            name = "Upd. ${createdDto.name}",
            description = "Updated description for ${createdDto.description}"
        )
    }

    fun createPrivilegeGroupDto(): PrivilegeGroupDto {
        return PrivilegeGroupSteps(Users.securityAdmin).create(preparePrivilegeGroupDtoForCreate())
            .data.getOrException()
    }
}