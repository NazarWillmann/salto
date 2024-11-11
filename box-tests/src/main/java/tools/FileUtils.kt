package tools

import java.io.File

object FileUtils {

    const val UPLOAD_DIR = "/upload"

    fun getResourceAsFile(path: String): File {
        return File(this::class.java.getResource(path).toURI())
    }
}