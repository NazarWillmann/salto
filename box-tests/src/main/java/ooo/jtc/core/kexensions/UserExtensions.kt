package ooo.jtc.core.kexensions

import ooo.jtc.allure.systemStep
import ooo.jtc.api.uaa.steps.AuthorizationSteps
import ooo.jtc.crypto.CryptoUtils
import ooo.jtc.testdata.UserCertificate
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.uaa.MfaType
import ooo.jtc.uaa.User
import ooo.jtc.uaa.catalog.model.DefaultCatalog
import ooo.jtc.uaa.catalog.model.DefaultCatalog.AUTH0
import ooo.jtc.uaa.catalog.model.DefaultCatalog.BANK
import ooo.jtc.uaa.catalog.model.DefaultCatalog.CLIENT
import ooo.jtc.uaa.catalog.model.DefaultCatalog.GOOGLE
import ooo.jtc.uaa.catalog.model.DefaultCatalog.INDIVIDUAL
import ooo.jtc.uaa.catalog.model.DefaultCatalog.LDAP
import ooo.jtc.uaa.catalog.model.DefaultCatalog.TECHNICAL
import ooo.jtc.uaa.resource.model.Audience
import ooo.jtc.uaa.user.dto.UserDetails
import java.util.*

@Synchronized
fun <T : User> T.invokeAuth(
    mfaType: MfaType = MfaType.SMS,
    defaultCatalog: DefaultCatalog = DefaultCatalog.getById(this.catalogId),
    newToken: Boolean = false

) = "Авторизация пользователя ${this.login}" systemStep {
    when (defaultCatalog) {
        BANK -> AuthorizationSteps(this.apply { this.domain = Audience.BANK.value }).authorizeByBank(newToken)
        CLIENT -> AuthorizationSteps(this.apply { this.domain = Audience.CUSTOMER.value }).authorizeByClient(mfaType, newToken)
        INDIVIDUAL, TECHNICAL, GOOGLE, AUTH0, LDAP -> throw NotImplementedError()
    }
}

fun <T : User> T.checkIsBankUser(message: String = "Provided user (${this.login}) is not a bank user") {
    if (!this.isBank) throw RuntimeException(message)
}

fun <T : User> T.checkIsClientUser(message: String = "Provided user (${this.login}) is not a client user") {
    if (!this.isClient) throw RuntimeException(message)
}

//TODO A.Stykalin [09.10.2020] Локализовать проблемные кейсы, когда нужно использовать разных пользователей
fun <T : User> T.retrieveClientUser(): User = if (this.isClient) this else Users.client

fun <T : User> T.retrieveBankUser(): User = if (this.isBank) this else Users.bankOperator

fun <T : User> T.getFio(): String {
    val details = this.userDetails!!
    return details.getFio()
}

fun UserDetails.getFio(): String {
    return "${this.lastName ?: ""} ${this.firstName ?: ""} ${this.middleName ?: ""}".trim()
}

fun <T : User> T.getClientRepresentativePhone(customerId: UUID): String? {
    return CustomerRepresentativeData.searchBy(this).find { it.customerId == customerId }?.phone
}

fun <T : User> T.getBankRepresentativePhone(branchId: UUID): String? {
    return BranchRepresentativeData.searchBy(this).find { it.branchId == branchId }?.phone
}

fun <T : User> T.getAvailableCNList(): List<String> {
    return UserCertificate.getCertFilesByUser(this).map { x509CertFile ->
        val certData = CryptoUtils.getStringFromPemFile(x509CertFile).toByteArray()
        val certificate = CryptoUtils.getCertFromPem(certData)
        CryptoUtils.getCommonName(certificate)
    }
}