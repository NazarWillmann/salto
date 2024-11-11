package ooo.jtc.generic.print

import ooo.jtc.generic.pageparams.Params
import java.util.*

/** Document(s) print request general fields */
interface PrintRequest {
    var format: PrintExportFormat
    var locale: String // "RU", "EN"
}


/**
 * Print request: print document(s) by ids
 */
data class PrintByIdsRequestDto(
    override var format: PrintExportFormat = PrintExportFormat.HTML,
    override var locale: String = "RU",
    var ids: List<UUID>,
    var params: PrintParams = PrintParams()
) : PrintRequest

/**
 * Print request: print document(s) by filter
 */
data class PrintByFilterRequestDto(
    override var format: PrintExportFormat = PrintExportFormat.HTML,
    override var locale: String = "RU",
    var filter: Params
) : PrintRequest


/**
 * Print request: print list of document(s) by ids
 */
data class PrintTableByIdsRequestDto(
    override var format: PrintExportFormat = PrintExportFormat.HTML,
    override var locale: String = "RU",
    var ids: List<UUID>
) : PrintRequest

/**
 * Print request: print list of document(s) by filter
 */
data class PrintTableByFilterRequestDto(
    override var format: PrintExportFormat = PrintExportFormat.HTML,
    override var locale: String = "RU",
    var filter: Params
) : PrintRequest

data class PrintParams(
    var needSignInfo: Boolean = true
)