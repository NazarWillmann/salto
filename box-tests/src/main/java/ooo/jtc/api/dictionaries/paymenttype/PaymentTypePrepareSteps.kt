package ooo.jtc.api.dictionaries.paymenttype

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.paymenttype.PaymentTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.paymenttype.FindPaymentTypeBy
import ooo.jtc.testdata.dictionaries.paymenttype.PaymentTypeData
import java.util.*

object PaymentTypePrepareSteps {

    @Step("Удалить созданные автотестами данные PaymentType из БД")
    fun cleanAtCreated() {
        FindPaymentTypeBy.AT_CREATED.get().forEach { payType ->
            PaymentTypeData.removeRecord?.let { it(payType) }
        }
    }

    val availablePaymentTypeCodes by lazy {
        PaymentTypeData.generateUniqueValues(consume = { it.code }, generate = { Random().nextInt(10).toString() })
    }

    fun getPaymentTypeDtoForCreate() = PaymentTypeDto(
        id = null,
        version = 0,
        code = availablePaymentTypeCodes.remove(),
        description = RandomData("[а-яА-Яa-zA-Z0-9 ]*").random(1, 4) + AT_POSTFIX
    )

    fun getPaymentTypeDtoForUpdate(createdDto: PaymentTypeDto): PaymentTypeDto {
        availablePaymentTypeCodes.add(createdDto.code!!)

        return PaymentTypeDto(
            createdDto.id, createdDto.version,
            availablePaymentTypeCodes.remove(),
            "updated ${createdDto.description}"
        )
    }

    @Step("Создать ${DictionaryNames.PAYMENT_TYPE}")
    fun createPaymentTypeDto(dtoForCreate: PaymentTypeDto = getPaymentTypeDtoForCreate()): PaymentTypeDto {
        return PaymentTypeSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}