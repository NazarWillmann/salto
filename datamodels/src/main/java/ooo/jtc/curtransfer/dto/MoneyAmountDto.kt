package ooo.jtc.curtransfer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.dictionaries.currency.ReducedCurrencyDto
import java.math.BigDecimal

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class MoneyAmountDto(
    var amount: BigDecimal,
    var currency: ReducedCurrencyDto
)
