package ooo.jtc.core.tm4j

import java.util.*

data class TmsTestSuite(
    /**
     * Set of all tags for suite.
     */
    var classTags: MutableSet<String> = mutableSetOf(),

    /**
     * Map of the test method and linked with it tags.
     */
    var methodTagsMap: HashMap<String, MutableSet<String>> = HashMap()
)