package ooo.jtc.api.common.checks

import io.qameta.allure.Step
import ooo.jtc.api.common.controls.ControlLevel
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

object ControlChecks {

    @Step("Проверка значения уровня контроля по умолчанию")
    fun checkDefaultControlLevel(reason: String, actual: ControlLevel, expected: ControlLevel) {
        assertThat(reason, actual, equalTo(expected))
    }

    @Step("Проверить, что результат валидации равен '{expectedValidationResult}'")
    fun checkValidationResult(actualValidationResult: String, expectedValidationResult: String) {
        assertThat(
            "Фактический результат валидации сущности не соответствует ожидаемому",
            actualValidationResult,
            equalTo(expectedValidationResult)
        )
    }
}