package ooo.jtc.api.rolemodel.role

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.rolemodel.role.RoleDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.rolemodel.role.RoleData
import ooo.jtc.testdata.uaa.resource.ResourceData

object RolePrepareSteps {

    @Step("Удалить созданные автотестами данные Role из БД")
    fun cleanAtCreated() {
        RoleData.get()
            .filter { RoleData.atMarkerPredicate(it) }
            .forEach { role -> RoleData.removeRecord?.let { it(role) } }
    }

    @Step("Подготовить тестовый '${RoleModelNames.ROLE}' по умолчанию")
    fun prepareRoleDtoForCreate(): RoleDto {
        val existingResource = ResourceData.randomOrException()
        val rand = digits.random(5, 7)
        return RoleDto(
            id = null,
            version = 0,
            name = "Test Role $rand${TestConstants.AT_POSTFIX}",
            uiName = "UI Test Role $rand",
            description = "Role for AT $rand",
            resourceId = existingResource.id!!,
            resource = null,
            privilegeGroups = emptyList()
        )
    }

    @Step("Подготовить '${RoleModelNames.ROLE}' для обновления")
    fun prepareRoleDtoForUpdate(createdDto: RoleDto): RoleDto {
        return createdDto.copy(
            //Sergeyev [2021.08.09]: ignored by back-end; approved by analytics
//            name = "Upd. ${createdDto.name}",
//            resourceId = ResourceData.get().map { it.id }.randomAnother(createdDto.resourceId),
            uiName = "Upd. ${createdDto.uiName}",
            description = "Updated description for ${createdDto.description}"
        )
    }

    fun createRoleDto(): RoleDto {
        return RoleSteps(Users.securityAdmin).create(prepareRoleDtoForCreate())
            .data.getOrException()
    }
}