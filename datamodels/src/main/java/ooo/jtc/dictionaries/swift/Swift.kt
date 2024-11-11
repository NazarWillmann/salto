package ooo.jtc.dictionaries.swift

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.Mappers
import ooo.jtc.interfaces.ITransferEntity
import java.sql.Timestamp
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
data class Swift(
    override var id: UUID?,
    override var version: Int,
    var swift: String,
    @JsonProperty("institution_type") var institutionType: SwiftInstType,
    @JsonProperty("date_actual") var dateActual: LocalDate,
    val name: String,
    val city: String?,
    val address1: String?,
    val address2: String?,
    val address3: String?,
    val address4: String?,
    @JsonProperty("branch_name") val branchName: String?,
    @JsonProperty("branch_city") val branchCity: String?,
    @JsonProperty("branch_address1") val branchAddress1: String?,
    @JsonProperty("branch_address2") val branchAddress2: String?,
    @JsonProperty("branch_address3") val branchAddress3: String?,
    @JsonProperty("branch_address4") val branchAddress4: String?,
    @JsonProperty("country_alpha2_code") val countryAlpha2Code: String,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?
) : ITransferEntity {

    @JsonIgnore
    @NotRequiredForTest
    override val entityName = DictionaryNames.SWIFT

    override fun toDto(): SwiftDto = Mappers.swiftMapper.toDto(this)
}