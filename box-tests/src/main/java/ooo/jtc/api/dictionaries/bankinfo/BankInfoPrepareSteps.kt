package ooo.jtc.api.dictionaries.bankinfo

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps.getBankRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.dictionaries.bankinfo.BankInfoDto
import ooo.jtc.dictionaries.bankinfo.applicationurl.ApplicationStoreType
import ooo.jtc.dictionaries.bankinfo.applicationurl.ApplicationType
import ooo.jtc.dictionaries.bankinfo.applicationurl.BankInfoApplicationUrlDto
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialType
import ooo.jtc.dictionaries.bankinfo.socialurl.BankInfoSocialUrlDto
import ooo.jtc.dictionaries.common.phoneinfo.PhoneInfoDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.random.RandomData.Companion.regexWords
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoData
import ooo.jtc.testdata.dictionaries.bankrepresentative.BankRepresentativeData
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User
import java.util.*

object BankInfoPrepareSteps {
    private val almightyUser = Users.superUser
    private val aBankInfoSteps by lazy { BankInfoSteps(almightyUser) }
    private val aBankRepresentativeSteps by lazy { BankRepresentativeSteps(almightyUser) }

    /** Retrieve default client user for working with Bank(Info) */
    fun retrieveClientUser(user: User): User =
        if (user.isClient) user else Users.client

    /** Retrieve default bank user for working with Bank(Info) */
    fun retrieveBankUser(user: User): User =
        if (user.isBank) user else Users.bankOperator

    @Step("Подготовить 'BankInfoDto' к созданию")
    fun getBankInfoDtoForCreate(): BankInfoDto {
        val shortName = regexWords.random(20, 40)
        val fullName = regexWords.random(90, 170)
        val licenseType = regexWord.random(10, 10)
        val licenseNumber = digits.random(9, 9)
        val atPhoneNumber = RandomRequisites.generatePhoneNumber()
        val website = "http://www." + regexWords.random(1, 5) + TestConstants.AT_POSTFIX + ".com"
        val uiSettings = mapOf("randomUiSetting1" to "strong")
        val applicationUrlDto = getBankInfoApplicationUrlDtoForCreate()
        val socialUrlDto = getBankInfoSocialUrlDtoForCreate()

        return BankInfoDto(
            id = null,
            version = 0,
            fullName = fullName + TestConstants.AT_POSTFIX,     // unique, up to 200 symbols
            shortName = shortName + TestConstants.AT_POSTFIX,   // unique, up to 50 symbols
            phoneSupports = listOf(PhoneInfoDto(phone = atPhoneNumber)),
            licenseType = licenseType,
            license = licenseNumber,
            inn = RandomRequisites.generateInnForUl(),
            logoFileId = UUID.randomUUID(),

            logoAccessToken = null,
            website = website,
            uiSettings = uiSettings,
            applicationUrls = listOf(applicationUrlDto),
            socialUrls = listOf(socialUrlDto),
            description = "desc${regexWord.random(10, 20)}${TestConstants.AT_POSTFIX}"
        )
    }

    fun getBankInfoDtoForUpdate(createdDto: BankInfoDto): BankInfoDto =
        createdDto.copy(
            shortName = "upd. ${createdDto.shortName}",
            fullName = "Updated ${createdDto.fullName}",
        )

    @Step("Проверить, связан ли пользователь '{user.login}' с банком [{bankId}]")
    fun isUserRelatedToBank(user: User, bankId: UUID): Boolean {
        /* [2021.02.09], Konstantin Volchenko:
         * В данный момент сущность (BankInfo) может быть только одна,
         * и ограничения видимости настроены именно исходя из этого.
         * Но физически мы не ограничиваем добавление туда более одной,
         * Так как в будущем планируем возможность иметь несколько банков в одной инсталляции.
         * Но это дело отдаленного будущего и правила видимости под этот кейс пока никто не прорабатывал.
         */
        //val response = BankInfoSteps(user).getById(bankId, false)
        //return (null != response.data)

        val existingUserRepresentatives = BankRepresentativeData.searchBy(user)
            .filter { bankId == it.bankId }
        return existingUserRepresentatives.isNotEmpty()
    }

    /**
     * Check if provided bank [bankUser] is related to bank with provided [bankId].
     * Create relation if it doesn't exist.
     */
    @Step("Удостовериться, что банковский пользователь '{bankUser.login}' связан с подразделением [{bankId}]")
    private fun ensureBankUserIsRelatedToBank(bankUser: User, bankId: UUID) {
        if (isUserRelatedToBank(bankUser, bankId))
            return

        val bankRepresentativeDto = getBankRepresentativeDtoForCreate(bankUser.uaaUserId!!, bankId)
        aBankRepresentativeSteps.create(bankRepresentativeDto)
    }

    @Step("Создать '${DictionaryNames.BANK_INFO}' с привязкой к банковским пользователям {bankUsers}")
    fun createBankInfoWithBankRepresentative(vararg bankUsers: User): BankInfoDto {
        bankUsers.forEach { it.checkIsBankUser() }

        // 1) create bank
        val createdBank = createBankInfoDto()

        // 2) create bankRepresentatives for provided bank users
        bankUsers.forEach { ensureBankUserIsRelatedToBank(it, createdBank.id!!) }
        return createdBank
    }

    @Step("Создать '${DictionaryNames.BANK_INFO}'")
    fun createBankInfoDto(
        dtoForCreate: BankInfoDto = getBankInfoDtoForCreate()
    ): BankInfoDto {
        return aBankInfoSteps.create(dtoForCreate).data
            .getOrException("Ошибка при создании нового '${DictionaryNames.BANK_INFO}'")
    }

    /**
     * Delete Bank and related entities:
     * * Branches - all related to provided Bank
     * * Customer-/BranchRepresentatives - for all Branches and Customers, related to provided Bank;
     * * BranchCustomer - all records, related to provided Bank;
     * * Customers - all previously related to provided Bank;
     * * BankRepresentatives - all related to provided Bank.
     *
     *
     * (!)WARNINGS(!)
     *
     * This method does NOT check for Customer relations to other Banks/Branches.
     * Use only when you know what you're doing.
     * DO NOT USE THIS if test-created branch has relation to non-test-created data!
     *
     * @param bankId  id of a BankInfo with related entities
     */
    @Step("Удалить Банк со связанными сущностями (Подразделения, Клиенты и связи с пользователями)")
    fun deleteBankInfoAndRelatedEntities(bankId: UUID, deleteAtOnly: Boolean = true) {
        val bankInfoDto = aBankInfoSteps.getById(bankId).data.getOrException()
        if (deleteAtOnly && !BankInfoData.atMarkerPredicate(bankInfoDto.toModel()))
            throw RuntimeException("This is not an AT-created branch")

        // 1) delete bankUsers' relations to bank
        val relatedBankRepresentatives = BankRepresentativeData.get { it.bankId!! == bankId }
        relatedBankRepresentatives.forEach { aBankRepresentativeSteps.delete(it.id!!) }

        // 2) delete related entities (branches, customers, related representatives)
        val relatedBranches = BranchData.get { it.bankId == bankId }
        if (relatedBranches.isNotEmpty())
            throw RuntimeException("Deleting Bank w/ Branches: needs more thought") //TODO Sergeyev [2021.02.04]: <-this + JDoc

        // 3) delete bank
        aBankInfoSteps.deleteOnlyBankInfo(bankId)
    }

    //region URL prepare steps
    @Step("Подготовить 'BankInfoApplicationUrlDto' к созданию")
    fun getBankInfoApplicationUrlDtoForCreate(): BankInfoApplicationUrlDto {
        val appType = ApplicationType.values().random().value
        val appStore = ApplicationStoreType.values().random().value
        val name = "Application [$appStore/$appType] N${digits.random(3, 7)}${TestConstants.AT_POSTFIX}"
        val downloadUrl = "http://www.$appStore.com/${regexWord.random(5, 10)}"

        return BankInfoApplicationUrlDto(
            name = name,
            appType = appType,
            storeType = appStore,
            downloadUrl = downloadUrl
        )
    }

    @Step("Подготовить 'BankInfoSocialUrlDto' к созданию")
    fun getBankInfoSocialUrlDtoForCreate(): BankInfoSocialUrlDto {
        val socialType = BankInfoSocialType.values().random().value
        val socialUrl = "http://www.$socialType.com/${regexWord.random(5, 10)}/${TestConstants.AT_POSTFIX}"

        return BankInfoSocialUrlDto(
            name = socialType + TestConstants.AT_POSTFIX,
            socialType = socialType,
            socialUrl = socialUrl
        )
    }
    //endregion
}