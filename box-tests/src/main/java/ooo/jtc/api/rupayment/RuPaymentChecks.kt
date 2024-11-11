package ooo.jtc.api.rupayment

import io.qameta.allure.Step
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.rupayment.dto.RuPaymentPreFilledForUserPaymentType

object RuPaymentChecks {

    @Step("Проверить, что получено корректно предзаполненное ПП для типа {expPreFilledDto.userPaymentType}")
    fun checkPreFillForUserPaymentType(expPreFilledDto: RuPaymentPreFilledForUserPaymentType, actPreFilledDto: RuPaymentDto) {
        assertObjectsEqual(expPreFilledDto, actPreFilledDto)
    }
}