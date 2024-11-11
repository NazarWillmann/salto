package ooo.jtc.generic.print

interface IPrintExportFormat {
    val format: PrintExportFormat
    val description: String
}

enum class PrintExportFormat {
    HTML, PDF, RTF,         // print
    CSV, XLSX, XML,         // export
    ;

    companion object {
        const val maxLength = 4
        const val minLength = 3
    }
}

data class PrintExportFormatDto(
    var value: PrintExportFormat,
    var ui: String
)