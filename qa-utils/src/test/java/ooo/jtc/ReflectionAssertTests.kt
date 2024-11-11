package ooo.jtc

import ooo.jtc.asserts.assertObjectsEqual
import org.junit.jupiter.api.Test


class ReflectionAssertTests {

    data class Person(val name: String?, val age: Int, val version: Long)

    @Test
    fun shouldEqualsObjectsTest() {
        val personOne = Person(null, 25, 0L)
        val personTwo = Person("One", 25, 0L)
        println(personOne == personTwo)
        assertObjectsEqual(personTwo, personOne)
    }
}