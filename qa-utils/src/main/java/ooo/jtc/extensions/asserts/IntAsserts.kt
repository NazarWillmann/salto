package ooo.jtc.extensions.asserts

import ooo.jtc.aspectj.IgnoreHamcrestAllureStep
import org.hamcrest.MatcherAssert.assertThat


/**
 * Check than it greater than other Int value
 *
 * @param varName - param name, using in description
 * @param compareWith - value for compare
 * @param message - hint message
 */
@IgnoreHamcrestAllureStep
fun Int.checkGreater(varName: String, compareWith: Int = 0, message: String = "$varName ($this) не меньше чем $compareWith"): Int {
    assertThat(message, this.compareTo(compareWith) == 1)
    return this
}