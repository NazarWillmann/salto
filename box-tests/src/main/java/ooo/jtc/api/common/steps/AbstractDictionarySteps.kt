package ooo.jtc.api.common.steps

import ooo.jtc.generic.DictionaryWrapperDto
import ooo.jtc.generic.GenericDto
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.testdata.Service
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User


abstract class AbstractDictionarySteps<T : IEntityDto, U : UpdateIEntityDto<T>>(
    user: User,
    service: Service = Services.DICTIONARY,
    var entity: Class<T>,
    val dictionaryName: String
) : AbstractEntitySteps<T, U>(user, service, entity) {

    override fun <T, R : GenericDto<T>> requestDtoWrapper(entity: T): DictionaryWrapperDto<T> =
        DictionaryWrapperDto(entity, false)

    override val servicePath: String by lazy { """${service.baseEndpoint}/$dictionaryName/${user.userType.pathPrefix}""" }
}