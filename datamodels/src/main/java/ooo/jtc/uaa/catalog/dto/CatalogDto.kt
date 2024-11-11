package ooo.jtc.uaa.catalog.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.UaaNames
import ooo.jtc.interfaces.ITransferEntity
import ooo.jtc.interfaces.UpdateIEntityDto
import ooo.jtc.uaa.catalog.model.Catalog
import ooo.jtc.uaa.catalog.model.UserCatalogKind
import java.util.*

@KotlinBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@EntityName(UaaNames.CATALOG)
data class CatalogDto(
    override var id: UUID?,
    override var version: Int,
    val catalogType: String,
    val catalogKind: UserCatalogKind,
    val name: String,
    val title: String?,
    val appearance: String?,
    val description: String?,
    var mfa: List<UserCatalogMfaDto>?,
    val enabled: Boolean
) : UpdateIEntityDto<CatalogDto> {
        override fun toModel(): Catalog = Mappers.catalogMapper.toDomainModel(this)
    }

