package ooo.jtc.api.rolemodel.privilege

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.rolemodel.privilege.PrivilegeDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.util.*

class PrivilegeSteps(user: User = Users.autotest) : AbstractDictionarySteps<PrivilegeDto, PrivilegeDto>(
    user = user,
    entity = PrivilegeDto::class.java,
    service = Services.DOMAIN_CONTROLLER,
    dictionaryName = "privilege"
) {
    override fun create(entity: PrivilegeDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<PrivilegeDto> {
        throw RuntimeException("This is read-only entity")
    }
    override fun update(entity: PrivilegeDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<PrivilegeDto> {
        throw RuntimeException("This is read-only entity")
    }
    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<PrivilegeDto> {
        throw RuntimeException("This is read-only entity")
    }
}