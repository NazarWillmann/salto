package ooo.jtc.dictionaries.agreement

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.time.Instant
import java.time.LocalDate
import java.util.*

@KotlinBuilder
data class Agreement(
    override var id: UUID?,
    override var version: Int,

    var agreementDate: LocalDate?,
    var agreementNumber: String?,
    var agreementType: AgreementType?,
    var endDate: LocalDate?,
    var description: String?,
    @JsonProperty("id_customer")
    var customerId: UUID,
    var customerShortName: String?,
    var customerFullName: String?,
    var status: String,

    @NotRequiredForTest @JsonProperty("created_at") var createdAt: Instant?,
    @NotRequiredForTest @JsonProperty("deleted_at") var deletedAt: Instant?
): ITransferEntity{

    @JsonIgnore
    @NotRequiredForTest
    override val entityName: String = DictionaryNames.AGREEMENT

    override fun toDto(): AgreementDto = Mappers.agreementMapper.toDto(this)
}