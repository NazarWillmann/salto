package examples

import ooo.jtc.asserts.assertEqualMaps
import ooo.jtc.serialization.convertToMap
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class AllureReflectionTests {
    data class AllureTestPerson(val name: String?, val age: Int, val address: Address, val version: Long)
    data class AllureTestPerson2(val name: String?, val age: Int, val version: Long)
    data class AllureTestPerson3(val name: String?, val age: Int, val address: Address)
    data class Address(val street: String, val version: Long)

    @Test
    fun shouldFailOnNullObjectTest() {
        val personOne = AllureTestPerson("One", 25, Address("first st.", 1L), 0L)
        val personTwo = AllureTestPerson2("One", 25, 0L)
        Assertions.assertThrows(
            AssertionError::class.java
        ) { assertEqualMaps(personOne.convertToMap(), personTwo.convertToMap()) }
    }

    @Test
    fun shouldFailOnNullFieldTest() {
        val personOne = AllureTestPerson("One", 25, Address("first st.", 1L), 0L)
        val personTwo = AllureTestPerson3("One", 25, Address("first st.", 1L))
        Assertions.assertThrows(
            AssertionError::class.java
        ) { assertEqualMaps(personOne.convertToMap(), personTwo.convertToMap()) }
    }


}