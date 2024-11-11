package ooo.jtc.api.common.steps

import io.qameta.allure.Step
import ooo.jtc.core.api.responseAs
import ooo.jtc.generic.GenericListResponseDto
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.testdata.Service
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import java.util.UUID

abstract class AbstractBlockableDictionarySteps<T : IEntityDto, U : UpdateIEntityDto<T>>(
    user: User,
    service: Service = Services.DICTIONARY,
    entity: Class<T>,
    dictionaryName: String
): AbstractDictionarySteps<T, U>(user, service, entity, dictionaryName) {

    @Step("Заблокировать '{this.entityName}'")
    fun blockSingle(id: UUID): GenericListResponseDto<T> {
        return stepApi.send(
            method = {
                body(mapOf("entityIds" to listOf(id)))
                post("$servicePath/Block")
            }
        ).responseAs(responseListType)
    }

    @Step("Заблокировать список '{this.entityName}'")
    fun block(ids: List<UUID>): GenericListResponseDto<T> {
        return stepApi.send(
            method = {
                body(mapOf("entityIds" to ids))
                post("$servicePath/Block")
            }
        ).responseAs(responseListType)
    }

    @Step("Разблокировать '{this.entityName}'")
    fun unblockSingle(id: UUID): GenericListResponseDto<T> {
        return stepApi.send(
            method = {
                body(mapOf("entityIds" to listOf(id)))
                post("$servicePath/Unblock")
            }
        ).responseAs(responseListType)
    }

    @Step("Разблокировать список '{this.entityName}'")
    fun unblock(ids: List<UUID>): GenericListResponseDto<T> {
        return stepApi.send(
            method = {
                body(mapOf("entityIds" to ids))
                post("$servicePath/Unblock")
            }
        ).responseAs(responseListType)
    }
}