package ooo.jtc.extensions.asserts

import org.hamcrest.MatcherAssert.assertThat

/**
 * Check string is not empty
 *
 * @param varName - checking parameter name, using for description message
 * @param message - hint message
 *
 * @return same string after checking
 */
fun String.checkNotEmpty(varName: String, message: String = "$varName ($this) не должно быть пустым"): String {
    assertThat(message, this.isNotEmpty())
    return this
}