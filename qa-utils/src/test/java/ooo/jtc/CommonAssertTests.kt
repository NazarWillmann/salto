package ooo.jtc

import ooo.jtc.extensions.asserts.assertEq
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CommonAssertTests {

    @Test
    fun shouldPassAssertEq() {
        val expStr = "test"
        val actStr = "test"
        actStr.assertEq(expStr)
    }

    @Test
    fun shouldFailAssertEq() {
        val expStr = "test"
        val actStr = "notTest"
        Assertions.assertThrows(AssertionError::class.java) { actStr.assertEq(expStr) }
    }

    @Test
    fun shouldPassAssertIsNotEmptyString() {
        val expStr = "test"
        expStr.assertIsNotEmpty()
    }

    @Test
    fun shouldPassAssertIsNotEmptyInt() {
        val exp = 1
        exp.assertIsNotEmpty()
    }

    @Test
    fun shouldPassAssertIsNotEmptyList() {
        val exp = mutableListOf(1)
        exp.assertIsNotEmpty()
    }

    @Test
    fun shouldPassAssertIsNotEmptyMap() {
        val exp = mutableMapOf<Int, Any>(Pair(1, 1))
        exp.assertIsNotEmpty()
    }

    @Test
    fun shouldPassAssertIsNotEmptySet() {
        val exp = mutableSetOf("one", "two", "one")
        exp.assertIsNotEmpty()
    }

    @Test
    fun shouldFailAssertIsNotEmptyObject() {
        val expStr = null
        val error = Assertions.assertThrows(AssertionError::class.java) { expStr.assertIsNotEmpty() }
        assertTrue(error.message == "\nExpected: not null\n     but: was null")
    }

    @Test
    fun shouldFailAssertIsNotEmptyString() {
        val expStr = ""
        val error = Assertions.assertThrows(AssertionError::class.java) { expStr.assertIsNotEmpty() }
        assertTrue(error.message == "\nExpected: not is an empty string\n     but: was \"\"")
    }

    @Test
    fun shouldFailAssertIsNotEmptyList() {
        val exp = mutableListOf<Any>()
        val error = Assertions.assertThrows(AssertionError::class.java) { exp.assertIsNotEmpty() }
        assertTrue(error.message == "\nExpected: not an empty collection\n     but: was <[]>")
    }

    @Test
    fun shouldFailAssertIsNotEmptyMap() {
        val exp = mutableMapOf<Int, Any>()
        val error = Assertions.assertThrows(AssertionError::class.java) { exp.assertIsNotEmpty() }
        assertTrue(error.message == "\nExpected: not <{}>\n     but: was <{}>")
    }

    @Test
    fun shouldFailAssertIsNotEmptySet() {
        val exp = mutableSetOf<Any>()
        val error = Assertions.assertThrows(AssertionError::class.java) { exp.assertIsNotEmpty() }
        assertTrue(error.message == "\nExpected: not an empty collection\n     but: was <[]>")
    }

}