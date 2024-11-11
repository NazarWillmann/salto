package ooo.jtc.api.common.checks

import io.qameta.allure.Step
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo

object Checks {

    @Step("Проверка поля '{fieldName}'")
    fun checkFieldValue(fieldName: String, actual: Any?, expected: Any?) {
        assertThat("Фактическое значение поля '$fieldName' не совпадает с ожидаемым.", actual, equalTo(expected))
    }
}