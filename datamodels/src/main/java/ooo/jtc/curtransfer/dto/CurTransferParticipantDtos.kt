package ooo.jtc.curtransfer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.dictionaries.country.ReducedCountryDto


interface CurTransferParticipantDto{
    val name: String?
    val country: ReducedCountryDto
    val city: String?
    val address: String?
}

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurTrPayerDto(
    override val name: String? = null,
    val account: String,
    val inn: String? = null,
    override val country: ReducedCountryDto = ReducedCountryDto(),
    override val city: String? = null,
    override val address: String? = null
) : CurTransferParticipantDto

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurTrPayerBankDto(
    override val name: String? = null,
    val swift: String? = null,
    override val country: ReducedCountryDto = ReducedCountryDto(),
    override val city: String? = null,
    override val address: String? = null
) : CurTransferParticipantDto

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurTrBeneficiaryDto(
    override val name: String? = null,
    val account: String? = null,
    override val country: ReducedCountryDto = ReducedCountryDto(),
    override val city: String? = null,
    override val address: String? = null
) : CurTransferParticipantDto

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurTrBeneficiaryBankDto(
    override val name: String? = null,
    val account: String? = null,
    val swift: String? = null,
    override val country: ReducedCountryDto = ReducedCountryDto(),
    override val city: String? = null,
    override val address: String? = null,
    val clearingCode: String? = null
) : CurTransferParticipantDto

@KotlinBuilder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CurTrIntermediaryBankDto(
    override val name: String? = null,
    val swift: String? = null,
    override val country: ReducedCountryDto = ReducedCountryDto(),
    override val city: String? = null,
    override val address: String? = null,
    val clearingCode: String? = null
) : CurTransferParticipantDto
