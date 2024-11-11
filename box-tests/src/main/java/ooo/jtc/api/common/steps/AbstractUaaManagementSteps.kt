package ooo.jtc.api.common.steps

import ooo.jtc.generic.GenericDto
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.testdata.Service
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import ooo.jtc.uaa.resource.model.Audience


abstract class AbstractUaaManagementSteps<T : IEntityDto, U : UpdateIEntityDto<T>>(
    user: User = Users.autotest.apply { this.domain = Audience.MANAGEMENT_UAA.value },
    service: Service = Services.UAA_MANAGEMENT,
    var entity: Class<T>,
    val managementName: String
) : AbstractEntitySteps<T, U>(user, service, entity) {

    override fun <T, R : GenericDto<T>> requestDtoWrapper(entity: T): GenericDto<T> = GenericDto(entity)

    override val servicePath: String by lazy { """${service.baseEndpoint}/$managementName""" }

}