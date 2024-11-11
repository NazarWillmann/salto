package tools

import com.fasterxml.jackson.databind.JsonNode
import io.qameta.allure.Step
import ooo.jtc.UTILS_CREATE_AT_USERS
import ooo.jtc.UTILS_CREATE_LT_USERS
import ooo.jtc.api.dictionaries.bankbic.BankBicPrepareSteps
import ooo.jtc.api.dictionaries.bankbic.BankBicSteps
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps
import ooo.jtc.api.dictionaries.swift.SwiftPrepareSteps
import ooo.jtc.api.dictionaries.swift.SwiftSteps
import ooo.jtc.api.platform.crypto.certificate.CertificatePrepareSteps
import ooo.jtc.api.platform.crypto.certificate.CertificateSteps
import ooo.jtc.api.platform.crypto.profile.ProfilePrepareSteps
import ooo.jtc.api.platform.crypto.profile.ProfileSteps
import ooo.jtc.api.uaa.prepare.PrepareUaaUserData
import ooo.jtc.api.uaa.steps.UaaUserSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.string
import ooo.jtc.logging.LoggerDelegate
import ooo.jtc.scripts.soft
import ooo.jtc.serialization.SerializationUtils.OBJECT_MAPPER
import ooo.jtc.serialization.convertToMap
import ooo.jtc.sign.SignToolType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.UserCertificate
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoData
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.uaa.catalog.CatalogData
import ooo.jtc.testdata.uaa.scope.ScopeData
import ooo.jtc.testdata.uaa.user.StoredUserData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import ooo.jtc.uaa.user.dto.UserDetails
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File
import java.time.LocalDate
import java.util.*

object UserCreator {
    private val log by LoggerDelegate()
    private val existingUsers: MutableList<String> by lazy { StoredUserData.get().map { it.login }.toMutableList() }

    private val usersFilePath = System.getProperty("usersFilePath", TestConstants.AT_USERS_FILE_PATH)
    private val usersFile = File(this::class.java.getResource(usersFilePath).toURI())
    private val usersNode = OBJECT_MAPPER.readTree(usersFile)

    @Test
    @DisplayName("Создать пользователей для автотестов")
    @UTILS_CREATE_AT_USERS
    fun createUsersAT() {
        uploadBankBicData()
        uploadSwifts()
        //TODO Sergeyev [2021.03.30]: create branches through BankBics (different printing(!!! ?here) result):
        // - w/o accounts;
        // - w/o ACTIVE acc;
        // - w/ single active acc;
        // - w/ multiple active accs

        listOf(
            "admin_AT",
            "operator_AT",
            "super_operator_AT",
            "security_AT",
            // Sergeyev [2020.12.18]: creating client users (i.e. their customers) before creating bank users will lead to error
            "client_AT",
            "client_second_AT",
            "individual_AT"
        ).forEach { userLogin ->
            val loggedUser = createUserAT(userLogin, forLT = false)
            loggedUser?.let { addSigningToolToUser(it) }
        }

        listOf(
            "super_operator_AT"
        ).forEach { userLogin ->
            val user: User = StoredUserData.getByLogin(userLogin)
            upgradeBankUserToSuperUser(user)
        }
    }

    @Test
    @DisplayName("Создать пользователей для нагрузочного тестирования")
    @UTILS_CREATE_LT_USERS
    fun createUsersLT() {
        uploadBankBicData()
        uploadSwifts()

        val isNotFromAtFile = TestConstants.AT_USERS_FILE_PATH != usersFilePath
        val loadTestingUsers = usersNode.convertToMap().keys
            .filter { isNotFromAtFile || it.endsWith(TestConstants.LT) }
        loadTestingUsers.forEach { userLogin ->
            val loggedUser = createUserAT(userLogin, forLT = true)
            loggedUser?.let { addSigningToolToUser(it) }
        }
    }

    //region Extra actions
    //createUsersAT() includes these actions. Run these only if you understand what are you doing.
    private fun addSigningToolToUser(user: User) {
        when (user.userType) {
            UserType.CLIENT -> createSignToolForUser(user.uaaUserId!!)
            UserType.BANK -> soft {
                val existingCertificates = UserCertificate.values()
                    .filter { it.user().login == user.login }
                existingCertificates.forEach {
                    val x509CertFile = it.certFile()
                    addCertificateSignToolToUser(user, x509CertFile)
                }
            }
        }
    }

    /**
     * Use this when bankUser should be a "super-user" (has access to all branches)
     */
    //@Test
    private fun upgradeBankUserToSuperUser(bankUser: User) {
        bankUser.checkIsBankUser()
        val existingBankInfos = BankInfoData.get(fromCache = false)
        existingBankInfos.forEach { bankInfo ->
            BankRepresentativeData.getOrCreate(
                consumer = { BankRepresentativeData.searchBy(bankUser.uaaUserId!!, bankInfo.id!!) },
                provider = { BankRepresentativePrepareSteps.createBankRepresentativeDto(bankUser.uaaUserId!!, bankInfo.id!!).toModel() }
            )
        }
    }

    private fun uploadBankBicData() {
        val bicsFromSample = BankBicPrepareSteps.prepareSamplesForBankBicImport()
        BankBicSteps(Users.superUser).importBankBic(bicsFromSample)
    }

    private fun uploadSwifts() {
        val swifts = SwiftPrepareSteps.prepareTempFileForSwiftImport(SwiftPrepareSteps.prepareSwiftsForImportInUserCreator())
        SwiftSteps(Users.superUser).importSwift(swifts)
    }

    /**
     * Create certificate-related signTool (with profile and certificate) for list of users.
     */
    @Test
    internal fun addCertificateSignToolToTargetUser() {
        listOf(
            UserCertificate.AT_OPERATOR_CERT
        ).forEach {
            val targetUser = it.user()
            val x509CertFile = it.certFile()
            addCertificateSignToolToUser(targetUser, x509CertFile)
        }
    }

    @Test
    @DisplayName("Создать организации (клиентов) для клиентских АТ-пользователей")
    fun addCustomersToClientAT() {
        listOf(
            Users.client,
            Users.secondClient
        ).forEach {
            createCustomers(it, 1)
        }
    }

    private fun createUserAT(login: String, forLT: Boolean): User? {
        if (login in existingUsers) {
            log.info("User '$login' already exists")
            return null
        }

        val userNode: JsonNode? = usersNode.findValue(login)
        userNode ?: throw NoSuchElementException("User ($login) not found in $usersFile")

        val pwd = userNode["password"].asText()
        val catalogName = userNode["catalog"].asText()
        val userDetails = OBJECT_MAPPER.convertValue(userNode["userDetails"], UserDetails::class.java)
        val nodeScopes = userNode["scopes"].asSequence().map { it.asText() }

        val scopeList = ScopeData.get { it.name in nodeScopes }
        val dto = PrepareUaaUserData.prepareUaaUserDtoForCreate(scopes = scopeList.map { it.id }, userDetails = userDetails)

        val uaaUserId = UaaUserSteps().create(dto).data?.id!!

        val id = UUID.randomUUID()
        val currentDate = LocalDate.now().string()
        val idCatalog = CatalogData.find { it.name == catalogName }.id!!
        //TODO A.Stykalin [22.05.2020] replace sql-creation to rest-creation, when it will be available
        val sql = """INSERT INTO public.cat_stored_user 
    |                   (id,    id_catalog,   id_user,  login, pwd_data, pwd_attempts, enabled, force_pwd_change, created_at, deleted_at, version)
    |           VALUES  ('$id', '$idCatalog', '$uaaUserId', '$login', '$pwd',   0, TRUE, FALSE, '$currentDate 00:00:00.000000', NULL, 0)""".trimMargin()
        Services.UAA.db.execute(sql)

        val storedUser = StoredUserData.getByLogin(login)
        val loggedUser = storedUser.invokeAuth()
        if ("client" == catalogName) {
            if (forLT) createCustomersForLT(loggedUser, 1)
            else createCustomers(loggedUser, 1)
        }

        existingUsers.add(login)
        log.info("User ($login) successfully created")
        return loggedUser
    }

    private fun createCustomers(user: User, customerCount: Int) {
        for (i in 0 until customerCount) {
            CustomerPrepareSteps.createCustomerDto(
                customerUser = user,
                withBranchCustomer = true,
                withLocAddress = true,
                withRegAddress = true,
                withKpp = false,
                withCustomerRepresentative = true,
                withAccount = true
            )
        }
    }

    private fun createCustomersForLT(user: User, customerCount: Int) {
        for (i in 0 until customerCount) {
            CustomerPrepareSteps.createCustomerDto(
                customerUser = user,
                withBranchCustomer = true,
                createBranchCustomer = { customerId: UUID ->
                    val branch = BranchData.getOrCreate(
                        consumer = { BranchData.searchBy(user) },
                        provider = { BranchPrepareSteps.createBranchWithBranchRepresentative(Users.systemBankOperator).toModel() }
                    )
                    BranchCustomerPrepareSteps.ensureBranchAndCustomerAreRelated(branchId = branch.id!!, customerId = customerId)
                },
                withLocAddress = true,
                withRegAddress = true,
                withKpp = true,
                withCustomerRepresentative = true,
                withAccount = true
            )
        }
    }

    /**
     * @param uaaUserId user UAA id; sign tool will be created for specified user
     * @param toolType  enum (Sms/Crypto/CryptoAuto); sign tool type
     * @param idRef     related entity id:
     *              SMS - null
     *              Crypto - salto_crypto_dev.certificate.id
     *              CryptoAuto - salto_crypto_dev.bank_key.id
     */
    @Step("Создать для пользователя средство подписи")
    private fun createSignToolForUser(
        uaaUserId: UUID,
        toolType: SignToolType = SignToolType.SMS,
        idRef: UUID? = null
    ) {
        //TODO Sergeyev [2020.09.01]: API is ready. Rewrite this
        // Swagger: http://sandbox.jtc.ooo:9100/swagger/index.html => /swagger/sign.json
        val signToolId = UUID.randomUUID()
        val idRefStr: String = idRef?.let { "'$idRef'" } ?: "NULL"
        val signToolForUser = """INSERT INTO public.sign_tool 
        |                   (id, tool_type, enabled, id_user, id_kind, id_ref, created_at, deleted_at, version)
        |           VALUES  ('$signToolId', '${toolType.type}', TRUE, '$uaaUserId', 'e2fd9473-9148-4bcb-996e-4237ad0a02ab', $idRefStr, '2020-01-01 00:00:00.000000', NULL, 0)"""
            .trimMargin()
        Services.SIGN.db.execute(signToolForUser)
    }

    @Test
    internal fun addSignToolsForClientUsers() {
        listOf(
            Users.client,
            Users.secondClient
        ).forEach {
            createSignToolForUser(it.uaaUserId!!)
        }
    }

    /**
     * Create certificate-related signTool (with profile and certificate) for [targetUser].
     * //TODO Sergeyev [2020.11.03]: more detailed J-/KDoc for signTools interaction
     */
    @Step("Добавить сертификат пользователю {targetUser}")
    private fun addCertificateSignToolToUser(targetUser: User, x509CertFile: File) {
        val bankAdmin by lazy { Users.bankAdmin }

        val profileForCreate = ProfilePrepareSteps.getProfileDtoForUserForCreate(targetUser)
        val createdProfile = ProfileSteps(bankAdmin).create(profileForCreate)
        val userProfile = createdProfile
            .data.getOrException("Error while creating profile for user '${targetUser.login}'")

        val userProfileId = userProfile.id!!

        val certForCreate = CertificatePrepareSteps.getCertificateDtoByFilePath(
            cryptoProfileId = userProfileId,
            x509CertFile = x509CertFile
        )

        val createdCertificate = CertificateSteps(bankAdmin).create(certForCreate)
            .data.getOrException("Error while creating certificate for user '${targetUser.login}'")

        // If there is a signTool for a targetUser, then you can just
        // 1) comment this \/ and
        // 2) UPDATE existing signTool's [id_ref] manually
        //TODO Sergeyev [2020.11.02]: improve (update by bool value)
        createSignToolForUser(targetUser.uaaUserId!!, SignToolType.CRYPTO, createdCertificate.id!!)
    }
    //endregion
}