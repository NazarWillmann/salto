package tools

import java.io.File

/**
 * Utility function. Collect all test tags for CI job.
 */
class TagCollector {

    //@org.junit.Test
    fun tagCollector() {
        val path = System.getProperty("user.dir") + "/src/test/java/ooo/jtc/"

        val rootDir = File(path)
        val tagFiles = rootDir.walkTopDown().filter { it.isFile && it.name.endsWith("Tags.kt") }

        val tags = tagFiles.map { file ->
            val list = file.readLines()
                .filter { it.contains("@Tag") }
                .map { line ->
                    line.replace(".*@Tag\\(\"(.*)\"\\).*".toRegex(), "$1")
                }
            list
        }.toList().flatten().sorted()
        println(tags.joinToString(",\n", "return [\n\"NONE:selected\",\n", "\n]", transform = { "\"$it\"" }))
    }

}