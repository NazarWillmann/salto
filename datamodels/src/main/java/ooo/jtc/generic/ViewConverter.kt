package ooo.jtc.generic

import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.string
import org.mapstruct.Named
import java.math.BigDecimal
import java.time.LocalDate

const val VIEW_CONVERTER = "ViewConverter"
const val LOCALDATE_TO_STRING = "LocalDateToString"
const val AMOUNT_TO_STRING = "AmountToString"
const val MASK_ACCOUNT = "MaskAccount"

@Named(VIEW_CONVERTER)
class ViewConverter {

    @Named(LOCALDATE_TO_STRING)
    fun localDateToString(source: LocalDate?): String {
        return source?.string(DOTS_DATE_FORMAT).orEmpty()
    }

    @Named(AMOUNT_TO_STRING)
    fun amountToString(source: BigDecimal?): String {
        return source?.let { amount(it).toPlainString() } ?: ""
    }

    @Named(MASK_ACCOUNT)
    fun maskAccount(source: String?): String {
        return if (!source.isNullOrEmpty()) {
            StringBuilder(source).insert(5, ".").insert(9, ".").insert(11, ".").toString()
        } else {
            ""
        }
    }
}