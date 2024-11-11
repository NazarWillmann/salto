package ooo.jtc.core.runner

import ooo.jtc.core.applicationProperties

object TagsUtils {

    /**
     * TmsIds from system property `tags`.
     * Used to filter tests being run.
     * Should contains project prefix.
     */
    val idsFromTagsProperty
        get() = if (System.getProperty("tags").isNullOrEmpty()) emptyList()
        else System.getProperty("tags").split(",").toList().filter { it.contains(applicationProperties.tms.project) }


}