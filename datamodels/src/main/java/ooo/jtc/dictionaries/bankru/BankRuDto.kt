package ooo.jtc.dictionaries.bankru

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.controlcode.ControlCodeDto
import ooo.jtc.dictionaries.locationtype.LocationTypeDto
import ooo.jtc.dictionaries.uer.UerDto
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@EntityName("Банк России")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankRuDto(
    override var id: UUID?,
    override var version: Int,
    var bic: String,            // up to  9 symbols (digits only)
    var bankName: String,       // up to 45 symbols
    var corrAccount: String?,   // up to 20 symbols (digits only)
    var address: String?,       // up to 30 symbols
    var zip: String,            // up to  6 symbols (digits only)
    var location: String?,      // up to 25 symbols
    var phone: String?,         // up to 25 symbols
    var regNumber: String?,     // up to  9 symbols
    var controlDate: ZonedDateTime?,

    @JsonProperty("locationTypeId") var idLocationType: UUID?,
    @JsonProperty("controlCodeId") var idControlCode: UUID?,
    @JsonProperty("uerId") var idUer: UUID,

    var locationType: LocationTypeDto?,
    var controlCode: ControlCodeDto?,
    var uer: UerDto?
) : UpdateIEntityDto<BankRuDto> {

    override fun toModel(): BankRu = Mappers.bankRuMapper.toDomainModel(this)

    @get:JsonIgnore
    val isRkc: Boolean
        get() = this.toModel().isRkc
}