package ooo.jtc.generic.parsers

import io.qameta.allure.Step
import ooo.jtc.logging.LoggerDelegate
import org.w3c.dom.Document
import org.w3c.dom.Node
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory

object XmlParser : FormatParser() {
    override val log by LoggerDelegate()

    @Step("Получить содержимое XML как список строк")
    override fun parse(byteArray: ByteArray): List<String> {
        val content = mutableListOf<String>()
        val xmlBuilder: DocumentBuilder= DocumentBuilderFactory.newInstance().newDocumentBuilder()
        val xmlDocument: Document = xmlBuilder.parse(byteArray.inputStream())

        val xmlRoot: Node = xmlDocument.documentElement

        // scan all xmlRoot children to extract their text values
        getNodeTextValues(xmlRoot, content)

        return content
    }

    /**
     * (!) Recursive function (!)
     * Used to get all text values of provided [source] XML node.
     *
     * @param source - XML node.
     * @param destination - mutable list of string. It will contain all of [source] fields' text values.
     * @param recursionDepth - recursion depth of current iteration. Starts at [0].
     * @param recursionDepthLimit - depth limit for this recursive function. Default value is [5].
     */
    private fun getNodeTextValues(
        source: Node,
        destination: MutableList<String>,
        recursionDepth: Int = 0,
        recursionDepthLimit: Int = 5
    ) {
        if (recursionDepth > recursionDepthLimit)
            throw RuntimeException(
                "Recursive function 'getNodeTextValues()' has exceeded depth limit of '$recursionDepthLimit'"
            )


        if (Node.TEXT_NODE == source.nodeType) {
            destination.add(source.textContent)
        } else {
            val childNodeList = source.childNodes
            for (i in 0 until childNodeList.length) {
                val childNode = childNodeList.item(i)
                getNodeTextValues(childNode, destination, recursionDepth + 1)
            }
        }
    }
}