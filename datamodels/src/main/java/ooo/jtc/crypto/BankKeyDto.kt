package ooo.jtc.crypto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.CryptoNames
import ooo.jtc.interfaces.UpdateIEntityDto
import java.util.*

@KotlinBuilder
@EntityName(CryptoNames.BANK_KEY)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BankKeyDto(
    override var id: UUID?,
    override var version: Int,
    var profileType: ProfileType,
    var userId: UUID,
    var storageName: String?,
    var storagePassword: String?,
    var alias: String?,
    var keyPassword: String?,
    var keyParameters: List<Any>
) : UpdateIEntityDto<BankKeyDto>