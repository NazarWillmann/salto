package tools

import ooo.jtc.core.tmsSuiteMap
import ooo.jtc.logging.LoggerDelegate
import java.io.File

object TmsTagWriter {
    private val log by LoggerDelegate()

    /**
     * Add TMS tags to the *TestSuite.
     */
    fun writeTmsTags() {
        log.info("Start adding created tags to tests...")
        log.info("tmsMap: $tmsSuiteMap")

        tmsSuiteMap.entries.forEach { entry ->
            val suitePath = System.getProperty("user.dir") + "/src/test/java/" + entry.key.replace(".", "/") + ".kt"
            log.info("Changing file: $suitePath")
            val suiteFile = File(suitePath)

            if (!suiteFile.exists()) {
                log.error("File not found by path: $suitePath")
                return
            }

            val suiteName: String = entry.key.substringAfterLast(".")
            val content = suiteFile.readText()
            val tmsTestSuite = entry.value

            var newContent = addSuiteTags(content, suiteName, tmsTestSuite.classTags)
            newContent = addTagsForMethods(newContent, tmsTestSuite.methodTagsMap)

            suiteFile.writeText(newContent)
            log.info("File $suitePath successfully changed.")
        }
        log.info("All created tags was successfully added.")
    }

    private fun addSuiteTags(content: String, suiteName: String, classTagsList: MutableSet<String>): String {
        val pattern = """//region Tags[\w|\W]*?//@formatter:off[\w|\W]*?(@Tag[\w|\W]*?)//@formatter:on[\w|\W]*?//endregion""".toRegex()
        //@formatter:on  insert here because IDEA "read" //@formatter:off from [pattern] :-)
        val match = pattern.find(content)
        val existClassTags = match?.groupValues?.get(1)?.split(System.lineSeparator())?.filterNot { it.isBlank() }
        existClassTags?.let { classTagsList.addAll(it) }
        val sortedSet = classTagsList.toSortedSet()
        val classTags = transformClassTags(sortedSet)
        return content
            .replace(pattern, "")
            .replace("$suiteName\\s?\\{".toRegex(), "$suiteName {\n $classTags")
    }


    private fun addTagsForMethods(content: String, methodTagsMap: java.util.HashMap<String, MutableSet<String>>): String {
        var newContent = content
        methodTagsMap.entries.forEach { entry ->
            val methodName = entry.key
            val methodTagSet = entry.value
            val methodTags = methodTagSet.joinToString("\n")
            log.info("Adding tags $methodTagSet for method '$methodName'")

            newContent = removeOldMethodTags(newContent, methodTagSet)
            val regexp = "(.* fun $methodName)".toRegex()
            newContent = newContent.replace(regexp, "$methodTags\n$1")
            log.info("Tags $methodTagSet for method '$methodName' successfully added")
        }
        return newContent
    }

    private fun removeOldMethodTags(content: String, methodTags: MutableSet<String>): String {
        var newContent = content
        methodTags.forEach { newContent = newContent.replace(it, "") }
        return newContent
    }

    private fun transformClassTags(classTags: MutableSet<String>): String {
        return "//region Tags\n//@formatter:off\n" + classTags.joinToString("\n") + "\n//@formatter:on\n//endregion"
    }
}