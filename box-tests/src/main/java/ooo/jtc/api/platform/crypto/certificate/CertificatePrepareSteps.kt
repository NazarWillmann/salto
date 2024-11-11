package ooo.jtc.api.platform.crypto.certificate

import io.qameta.allure.Step
import ooo.jtc.crypto.CertificateDto
import ooo.jtc.crypto.CertificateState
import ooo.jtc.crypto.CertificateType
import ooo.jtc.crypto.CryptoUtils
import ooo.jtc.generic.CryptoNames
import ooo.jtc.uaa.User
import java.io.File
import java.util.*

object CertificatePrepareSteps {

    private const val CERTIFICATE_DIR = "/crypto"
    val certFileByName: (String) -> File = { File(this::class.java.getResource("$CERTIFICATE_DIR/$it").toURI()) }

    @Step("Подготовить ${CryptoNames.CERTIFICATE} DTO на основе сертификата {x509CertFile}")
    fun getCertificateDtoByFilePath(cryptoProfileId: UUID? = null, x509CertFile: File): CertificateDto {
        val certData = CryptoUtils.getStringFromPemFile(x509CertFile).toByteArray()
        val certificate = CryptoUtils.getCertFromPem(certData)
        val encodedCertData = Base64.getEncoder().encodeToString(certData)
        val validFrom = certificate.notBefore.toInstant()
        val validTo = certificate.notAfter.toInstant()
        val commonName = CryptoUtils.getCommonName(certificate)
        val thumbprint = CryptoUtils.getThumbprint(certificate)
        val serialNumber = CryptoUtils.getSerialNumber(certificate)

        return CertificateDto(
            id = null, version = 0,
            certificateData = encodedCertData,
            serialNumber = serialNumber,
            thumbprint = thumbprint,
            userName = commonName,
            validFrom = validFrom,
            validTo = validTo,
            state = CertificateState.ENABLED,
            certificateType = CertificateType.WORKING,
            cryptoProfileId = cryptoProfileId
        )
    }

    @Step("Получить доступный пользователю '{user.login}' сертификат по отпечатку [{thumbprint}]")
    fun getCertificateByThumbprint(user: User, thumbprint: String): CertificateDto {
        val certificates = CertificateSteps(user).getPageAll()
            .page!!
        //TODO Sergeyev [2020.12.15]: filter by available to user
        val certificate = certificates
            .find { it.thumbprint == thumbprint }
        return certificate
            ?: throw RuntimeException("User '${user.login}' doesn't have linked certificate with thumbprint [$thumbprint]")
    }
}