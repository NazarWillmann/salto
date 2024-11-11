package ooo.jtc.generic

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import ooo.jtc.extensions.getOrException
import java.util.concurrent.ConcurrentHashMap

object LocResourceRepository {
    val i18nLetterToBank: ConcurrentHashMap<String, String> by lazy { loadLocResAsMap("letter-to-bank") }

    /**
     * Load LocResources from file as Map by [fileNamePrefix]
     */
    private fun loadLocResAsMap(fileNamePrefix: String): ConcurrentHashMap<String, String> {
        val locale = System.getProperty("i18nLocale", "ru")
        val fileName = "/i18n/$fileNamePrefix-$locale.json"
        val src = LocResourceRepository::class.java.getResourceAsStream(fileName).getOrException("File resources$fileName not found.")
        val srcMap = ObjectMapper().readValue<Map<String, String>>(src)
        return ConcurrentHashMap(srcMap)
    }
} 