package ooo.jtc

import ooo.jtc.text.TextUtils
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test

class TextUtilsTests {

    @Test
    fun shouldDeclensionByDigitCorrect() {
        val result = TextUtils.declensionByDigit(11, form1 = "голубь", form234 = "голубя", form567890 = "голубей")
        assertThat(result, equalTo("голубей"))
    }

}