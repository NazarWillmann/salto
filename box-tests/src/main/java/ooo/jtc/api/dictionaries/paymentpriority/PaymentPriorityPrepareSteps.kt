package ooo.jtc.api.dictionaries.paymentpriority

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.paymentpriority.FindPaymentPriorityBy
import ooo.jtc.testdata.dictionaries.paymentpriority.PaymentPriorityData
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

object PaymentPriorityPrepareSteps {

    @Step("Удалить созданные автотестами данные PaymentPriority из БД")
    fun cleanAtCreated() {
        FindPaymentPriorityBy.AT_CREATED.get().forEach { payPr ->
            PaymentPriorityData.removeRecord?.let { it(payPr) }
        }
    }

    val availablePaymentPriorityCodes: BlockingQueue<String?>
        get() = run {
            val availableCodes = PaymentPriorityData.generateUniqueValues(consume = { it.code },
                generate = { "0123456789".toList().map { it.toString() }.random() })
            LinkedBlockingQueue(availableCodes)
        }

    fun getPaymentPriorityDtoForCreate() = PaymentPriorityDto(
        id = null,
        version = 0,
        code = availablePaymentPriorityCodes.remove(),
        description = RandomData("[а-яА-Я0-9 ]*").random(20, 3990).trim() + AT_POSTFIX_RUS_PARENTHESES
    )

    fun getPaymentPriorityDtoForUpdate(createdDto: PaymentPriorityDto) =
        PaymentPriorityDto(
            createdDto.id, createdDto.version,
            availablePaymentPriorityCodes.remove(),
            "updated ${createdDto.description}"
        )

    @Step("Создать ${DictionaryNames.PAYMENT_PRIORITY}")
    fun createPaymentPriorityDto(dtoForCreate: PaymentPriorityDto = getPaymentPriorityDtoForCreate()): PaymentPriorityDto {
        return PaymentPrioritySteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}