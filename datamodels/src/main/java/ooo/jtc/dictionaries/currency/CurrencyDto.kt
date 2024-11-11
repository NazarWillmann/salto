package ooo.jtc.dictionaries.currency

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.UUID

@EntityName(DictionaryNames.CURRENCY)
@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CurrencyDto(
    override var id: UUID?,
    override var version: Int,
    val digitCode: String,  // unique, up to 3 symbols (digits only)
    val alphaCode: String,  // unique, up to 3 symbols
    val name: String,       // up to 255 symbols
    val nameInOkv: String,  // up to 255 symbols
    val minorUnitCount: Int
) : UpdateIEntityDto<CurrencyDto> {

    override fun toModel(): Currency = Mappers.currencyMapper.toDomainModel(this)

    fun toReducedCurrencyDto(): ReducedCurrencyDto = ReducedCurrencyDto(digitCode, alphaCode)
}

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class ReducedCurrencyDto(
    val digitCode: String,  // unique, up to 3 symbols (digits only)
    val alphaCode: String,  // unique, up to 3 symbols
) {
    companion object {
        fun ofDefaultCurrency(enumCurr: DefaultCurrency): ReducedCurrencyDto {
            return ReducedCurrencyDto(
                digitCode = enumCurr.digitCode,
                alphaCode = enumCurr.alphaCode
            )
        }
    }
}

/**
 * Frequently used currencies
 */
enum class DefaultCurrency(
    val digitCode: String,
    val alphaCode: String,
    val currencyName: String
) {
    USD("840", "USD", "Доллар США"),
    EUR("978", "EUR", "Евро"),
    RUB("643", "RUB", "Российский рубль"),
    RUR("810", "RUR", "Российский рубль")
}