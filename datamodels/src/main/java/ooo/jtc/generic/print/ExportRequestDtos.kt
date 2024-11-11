package ooo.jtc.generic.print

import ooo.jtc.generic.pageparams.Params
import java.util.*

/**
 * Export request: export document(s) by ids
 */
data class ExportByIdsRequestDto(
    var format: PrintExportFormat = PrintExportFormat.XLSX,
    var ids: List<UUID>
)

/**
 * Export request: export document(s) by filter
 */
data class ExportByFilterRequestDto(
    var format: PrintExportFormat = PrintExportFormat.XLSX,
    var params: Params
)

