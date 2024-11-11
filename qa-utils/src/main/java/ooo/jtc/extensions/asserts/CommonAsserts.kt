@file:Suppress("UNUSED_PARAMETER")

package ooo.jtc.extensions.asserts

import io.qameta.allure.Step
import ooo.jtc.aspectj.IgnoreHamcrestAllureStep
import ooo.jtc.extensions.ellipsis
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*


/**
 * Check two object equals.
 *
 * @param compareWith - Object to compare
 * @param stepName - hint message
 */
@Step("{stepName}")
@IgnoreHamcrestAllureStep
fun <T> T.assertEq(compareWith: T, stepName: String = "$this is equals to $compareWith") {
    assertThat(this, equalTo(compareWith))
}

/**
 * Check object is not null.
 *
 * Also, if it's a list, a map or a string - check that it's not empty
 *
 * @param stepName - hint message
 */
@Suppress("UNCHECKED_CAST")
@Step("{stepName}")
@IgnoreHamcrestAllureStep
fun <T> T.assertIsNotEmpty(stepName: String = "Проверить, что ${this.toString().ellipsis(30)} не пуст") {
    assertThat(this, notNullValue())
    assertThat(this.toString(), not(`is`(emptyString())))
    when (this) {
        is Collection<*> -> assertThat(this, not(emptyCollectionOf(Any::class.java)))
        is Map<*, *> -> assertThat(this as Map<Any?, Any?>, not(emptyMap()))
    }


}