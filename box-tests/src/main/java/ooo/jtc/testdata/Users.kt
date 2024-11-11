package ooo.jtc.testdata


import ooo.jtc.api.platform.crypto.certificate.CertificatePrepareSteps.certFileByName
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.testdata.common.random
import ooo.jtc.testdata.uaa.user.FindStoredUserBy
import ooo.jtc.uaa.User
import java.io.File


object Users {
    val client by lazy { FindStoredUserBy.CLIENT_USER.random().invokeAuth() }
    val secondClient by lazy { FindStoredUserBy.CLIENT_SECOND_USER.random().invokeAuth() }
    val individual by lazy { FindStoredUserBy.INDIVIDUAL_USER.random().invokeAuth() }
    val autotest by lazy { FindStoredUserBy.AUTOTEST_USER.random().invokeAuth() }
    val bankAdmin by lazy { FindStoredUserBy.BANK_ADMIN_USER.random().invokeAuth() }
    val bankOperator by lazy { FindStoredUserBy.BANK_OPERATOR_USER.random().invokeAuth() }
    val superBankOperator by lazy { FindStoredUserBy.SUPER_BANK_OPERATOR.random().invokeAuth() }
    val securityAdmin by lazy { FindStoredUserBy.SECURITY_ADMIN_USER.random().invokeAuth() }
    val systemSecurityAdmin by lazy { FindStoredUserBy.SYSTEM_SECURITY_USER.random().invokeAuth() }
    val systemBankOperator by lazy { FindStoredUserBy.SYSTEM_BANK_OPERATOR_USER.random().invokeAuth() }
    val superUser by lazy { FindStoredUserBy.BRANCHES_ALMIGHTY.random().invokeAuth() }
}

/**
 * Link between user and his certificate.
 * All certificates stores in resource/[ooo.jtc.api.platform.crypto.certificate.CertificatePrepareSteps.CERTIFICATE_DIR].
 * @param user - function that returns some [User]. Usually from [Users].
 * @param certFile - function that returns certificate file.
 */
enum class UserCertificate(val user: () -> User, val certFile: () -> File) {
    AT_OPERATOR_CERT({ Users.bankOperator }, { certFileByName("SALTO_operator_at_05_pem.cer") })
    ;

    companion object {
        fun getCertFilesByUser(user: User): List<File> {
            return values().filter { it.user() == user }.map { it.certFile() }
        }
    }
}