package ooo.jtc.generic.parsers

import io.qameta.allure.Step
import ooo.jtc.extensions.string
import ooo.jtc.logging.LoggerDelegate
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.sql.Timestamp
import java.time.LocalDateTime

object XlsxParser : FormatParser() {
    override val log by LoggerDelegate()

    @Step("Получить содержимое XLS как список строк")
    override fun parse(byteArray: ByteArray): List<String> {
        val contentInStrings: MutableList<String> = mutableListOf()
        val xls = XSSFWorkbook(byteArray.inputStream())

        for (i in 0 until xls.numberOfSheets) {
            // aww, sheet, here we go again
            val sheet = xls.getSheetAt(i)
            val sheetContent = getDataFromSheet(sheet)
            contentInStrings.addAll(sheetContent)
        }
        return contentInStrings
    }

    private fun getDataFromSheet(sheet: XSSFSheet): List<String> {
        val sheetContent = mutableListOf<String>()
        val rowIterator = sheet.rowIterator()
        while (rowIterator.hasNext()) {
            val currentRow = rowIterator.next()
            val cellIterator = currentRow.cellIterator()
            while (cellIterator.hasNext()) {
                val cell = cellIterator.next()
                when (cell.cellTypeEnum) {
                    CellType.NUMERIC -> sheetContent.add(
                        if (DateUtil.isCellDateFormatted(cell)) getDateCellValueInFormat(cell)
                        else cell.numericCellValue.toString()
                    )
                    CellType.STRING -> sheetContent.add(cell.stringCellValue)
                    CellType.BOOLEAN -> sheetContent.add(cell.booleanCellValue.toString())
                    else -> throw RuntimeException("Another cell type: ${cell.cellTypeEnum}")
                }
            }
        }
        return sheetContent
    }

    private fun getDateCellValueInFormat(cell: Cell): String {
        val formatString = cell.cellStyle.dataFormatString
        val date: LocalDateTime = Timestamp(cell.dateCellValue.time).toLocalDateTime()
        return date.string(formatString)
    }
}