package ooo.jtc.core.kexensions

import io.qameta.allure.Step
import io.restassured.internal.RestAssuredResponseImpl
import io.restassured.response.Response
import java.io.File

@Step("Извлечь из ответа содержимое в виде массива байт")
fun Response.getContentAsByteArray(): ByteArray {
    return (this.body as RestAssuredResponseImpl).content as ByteArray
}

/**
 * Store [Response] as file.
 * !!Important: use forward slash "/" in path, for creating correct directory.
 * @param filePath - path to file. e.g. "target/downloads/test.txt"
 */
fun Response.asFile(filePath: String): File {
    val byteContent = this.body().asByteArray()

    File(filePath.substringBeforeLast("/")).mkdir()
    val file = File(filePath)
    file.writeBytes(byteContent)
    return file
}