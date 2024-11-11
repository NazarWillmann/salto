package ooo.jtc.api.rolemodel.accessobject

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.rolemodel.accessobject.AccessObjectDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.util.*

class AccessObjectSteps(user: User = Users.autotest) : AbstractDictionarySteps<AccessObjectDto, AccessObjectDto>(
    user = user,
    entity = AccessObjectDto::class.java,
    service = Services.DOMAIN_CONTROLLER,
    dictionaryName = "accessObject"
){
    override fun create(entity: AccessObjectDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<AccessObjectDto> {
        throw RuntimeException("This is read-only entity")
    }
    override fun update(entity: AccessObjectDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<AccessObjectDto> {
        throw RuntimeException("This is read-only entity")
    }
    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<AccessObjectDto> {
        throw RuntimeException("This is read-only entity")
    }
}