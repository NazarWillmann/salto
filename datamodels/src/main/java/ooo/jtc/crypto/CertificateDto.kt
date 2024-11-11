package ooo.jtc.crypto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.CryptoNames
import ooo.jtc.interfaces.UpdateIEntityDto
import java.time.Instant
import java.util.*

@KotlinBuilder
@EntityName(CryptoNames.CERTIFICATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CertificateDto(
    override var id: UUID?,
    override var version: Int,
    var certificateData: String,
    var serialNumber: String,
    var thumbprint: String,
    var userName: String,
    var validFrom: Instant,
    var validTo: Instant,
    var state: String,
    var certificateType: String,
    var cryptoProfileId: UUID? // при отправке должно быть заполнено
) : UpdateIEntityDto<CertificateDto>

object CertificateState {
    const val ENABLED = "Enabled" // "State ставь только Enabled. Он проверяется что он такой" Константин Волченко
    const val DISABLED = "Disabled"
    const val FORBIDDEN = "Forbidden"
    const val TRANSITION = "Transition"
}

object CertificateType {
    const val CRL = "CRL"
    const val ROOT = "Root"
    const val WORKING = "Working" // "CertificateType сейчас используется только Working" Константин Волченко
    const val INTERMEDIATE = "Intermediate"
    const val TECHNOLOGICAL = "Technological"
}