package ooo.jtc.api.common.templates.entity

import ooo.jtc.api.common.steps.AbstractBlockableDictionarySteps
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.core.TestConstants
import ooo.jtc.core.TestConstants.PARAM_OBJECT_TYPE
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.extensions.getOrException
import ooo.jtc.interfaces.IEntityDto
import ooo.jtc.interfaces.IWithBlock
import ooo.jtc.interfaces.UpdateIEntityDto
import org.hamcrest.MatcherAssert.assertThat
import java.time.ZonedDateTime

/**
 * Basic test template for entity blocking.
 */
open class BlockingTestTemplate<T : IEntityDto>(
    var steps: AbstractBlockableDictionarySteps<T, out UpdateIEntityDto<T>>,
    override var preExecution: (() -> T)? = null,
    override var postExecution: ((T) -> Unit)? = null,
    override val testPostExecution: ((T) -> Unit)? = null
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution) {

    override fun name(): String = "'${steps.entityName}'. Блокировка [${steps.user.userType}]"

    override fun execution(preconditionResult: T?) {
        val branchRepresDto = preconditionResult!!
        testResult = branchRepresDto

        val expBlockDateBefore = ZonedDateTime.now().minusSeconds(TestConstants.ACCEPTABLE_TIME_LAG_SECONDS / 2)
        val blockResponse = steps.blockSingle(branchRepresDto.id!!)
        val actResult = blockResponse.list.getOrException().first() as IWithBlock
        val expBlockDateAfter = ZonedDateTime.now().plusSeconds(TestConstants.ACCEPTABLE_TIME_LAG_SECONDS / 2)

        assertThat("Сущность не была заблокирована", actResult.block.isBlock)
        assertThat("Не указана дата блокировки", null != actResult.block.blockDate)
        assertThat(
            "Дата блокировки указана некорретно",
            actResult.block.blockDate!!.isAfter(expBlockDateBefore)
                    && actResult.block.blockDate!!.isBefore(expBlockDateAfter)
        )
        assertThat("Не указан пользователь блокировки", null != actResult.block.blockUser)
        assertThat("Заблокировавший пользователь указан некорректно", steps.user.uaaUserId == actResult.block.blockUser!!)
    }

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Блокируемый объект" to preconditionResult!!
        )
    }
}

/**
 * Basic test template for entity unblocking.
 */
open class UnblockingTestTemplate<T : IEntityDto>(
    var steps: AbstractBlockableDictionarySteps<T, out UpdateIEntityDto<T>>,
    override var preExecution: (() -> T)? = null,
    override var postExecution: ((T) -> Unit)? = null,
    override val testPostExecution: ((T) -> Unit)? = null
) : AbstractTest<T, T>(preExecution = preExecution, postExecution = postExecution, testPostExecution = testPostExecution) {

    override fun name(): String = "'${steps.entityName}'. Разблокировка [${steps.user.userType}]"

    override fun execution(preconditionResult: T?) {
        val blockedBankRepresDto = preconditionResult!!
        testResult = blockedBankRepresDto

        val unblockResponse = steps.unblockSingle(blockedBankRepresDto.id!!)
        val actResult = unblockResponse.list.getOrException().first() as IWithBlock

        assertThat("Сущность не была разблокирована", !actResult.block.isBlock)
        assertThat("Не очищена дата блокировки", null == actResult.block.blockDate)
        assertThat("Не очищен пользователь блокировки", null == actResult.block.blockUser)
    }

    override fun params(): Map<String, Any> {
        return mapOf(
            PARAM_USER to steps.user,
            PARAM_OBJECT_TYPE to steps.entityName,
            "Разблокируемый объект" to preconditionResult!!
        )
    }
}