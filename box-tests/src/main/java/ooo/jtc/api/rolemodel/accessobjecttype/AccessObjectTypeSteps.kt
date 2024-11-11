package ooo.jtc.api.rolemodel.accessobjecttype

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.rolemodel.accessobjecttype.AccessObjectTypeDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.util.*

class AccessObjectTypeSteps(user: User = Users.autotest) : AbstractDictionarySteps<AccessObjectTypeDto, AccessObjectTypeDto>(
    user = user,
    entity = AccessObjectTypeDto::class.java,
    service = Services.DOMAIN_CONTROLLER,
    dictionaryName = "accessObjectType"
) {
    override fun create(entity: AccessObjectTypeDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<AccessObjectTypeDto> {
        throw RuntimeException("This is read-only entity")
    }

    override fun update(entity: AccessObjectTypeDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<AccessObjectTypeDto> {
        throw RuntimeException("This is read-only entity")
    }

    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<AccessObjectTypeDto> {
        throw RuntimeException("This is read-only entity")
    }
}