package ooo.jtc.testdata.dictionaries.individual

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.individual.IndividualPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.common.address.Address
import ooo.jtc.dictionaries.common.address.ForeignAddress
import ooo.jtc.dictionaries.common.address.RuAddress
import ooo.jtc.dictionaries.individual.Individual
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.account.AccountData
import ooo.jtc.testdata.dictionaries.branchindividal.BranchIndividualData
import ooo.jtc.testdata.dictionaries.person.PersonData
import ooo.jtc.uaa.User
import java.util.*

/**
 * Individual data, that loaded from testDataProvider as [IndividualData] in [Individual] format.
 */
object IndividualData : TestDataAT<Individual>(Individual::class.java) {

    override var atMarkerPredicate: (Individual) -> Boolean = { it.description?.endsWith(AT_POSTFIX) ?: false }

    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM individual") }
    override val dataFileName: String = "individual.json"

    //override var removeRecord: ((Individual) -> Unit)? = { IndividualPrepareSteps.deleteIndividualAndRelatedEntitiesIfPossible(it.id!!) }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbIndividualInfoMap ->
            dbIndividualInfoMap.apply {

                val addressRegistration = Address(
                    addressType = dbIndividualInfoMap["add_reg_address_type"] as String,
                    ruAddress = RuAddress(
                        countryDigitCode = dbIndividualInfoMap["add_reg_russian_country_digit_code"] as String?,
                        index = dbIndividualInfoMap["add_reg_russian_c_index"] as String?,
                        regionCode = dbIndividualInfoMap["add_reg_russian_region_code"] as String?,
                        district = dbIndividualInfoMap["add_reg_russian_district"] as String?,
                        city = dbIndividualInfoMap["add_reg_russian_city"] as String?,
                        inhabitedLocality = dbIndividualInfoMap["add_reg_russian_inhabited_locality"] as String?,
                        street = dbIndividualInfoMap["add_reg_russian_street"] as String?,
                        houseNumber = dbIndividualInfoMap["add_reg_russian_house_number"] as String?,
                        housingNumber = dbIndividualInfoMap["add_reg_russian_housing_number"] as String?,
                        buildingNumber = dbIndividualInfoMap["add_reg_russian_building_number"] as String?,
                        apartmentNumber = dbIndividualInfoMap["add_reg_russian_apartment_number"] as String?,
                        roomNumber = dbIndividualInfoMap["add_reg_russian_room_number"] as String?,
                        fullAddress = dbIndividualInfoMap["add_reg_russian_full_address"] as String?,
                    ),
                    foreignAddress = ForeignAddress(
                        countryDigitCode = dbIndividualInfoMap["add_reg_foreign_country_digit_code"] as String?,
                        index = dbIndividualInfoMap["add_reg_foreign_c_index"] as String?,
                        state = dbIndividualInfoMap["add_reg_foreign_state"] as String?,
                        city = dbIndividualInfoMap["add_reg_foreign_city"] as String?,
                        address = dbIndividualInfoMap["add_reg_foreign_district"] as String?,
                    )
                )
                dbIndividualInfoMap["addressRegistration"] = addressRegistration

                val addressLocation = Address(
                    addressType = dbIndividualInfoMap["add_loc_address_type"] as String,
                    ruAddress = RuAddress(
                        countryDigitCode = dbIndividualInfoMap["add_loc_russian_country_digit_code"] as String?,
                        index = dbIndividualInfoMap["add_loc_russian_c_index"] as String?,
                        regionCode = dbIndividualInfoMap["add_loc_russian_region_code"] as String?,
                        district = dbIndividualInfoMap["add_loc_russian_district"] as String?,
                        city = dbIndividualInfoMap["add_loc_russian_city"] as String?,
                        inhabitedLocality = dbIndividualInfoMap["add_loc_russian_inhabited_locality"] as String?,
                        street = dbIndividualInfoMap["add_loc_russian_street"] as String?,
                        houseNumber = dbIndividualInfoMap["add_loc_russian_house_number"] as String?,
                        housingNumber = dbIndividualInfoMap["add_loc_russian_housing_number"] as String?,
                        buildingNumber = dbIndividualInfoMap["add_loc_russian_building_number"] as String?,
                        apartmentNumber = dbIndividualInfoMap["add_loc_russian_apartment_number"] as String?,
                        roomNumber = dbIndividualInfoMap["add_loc_russian_room_number"] as String?,
                        fullAddress = dbIndividualInfoMap["add_loc_russian_full_address"] as String?,
                    ),
                    foreignAddress = ForeignAddress(
                        countryDigitCode = dbIndividualInfoMap["add_loc_foreign_country_digit_code"] as String?,
                        index = dbIndividualInfoMap["add_loc_foreign_c_index"] as String?,
                        state = dbIndividualInfoMap["add_loc_foreign_state"] as String?,
                        city = dbIndividualInfoMap["add_loc_foreign_city"] as String?,
                        address = dbIndividualInfoMap["add_loc_foreign_district"] as String?,
                    )
                )
                dbIndividualInfoMap["addressLocation"] = addressLocation
            }
        }

    fun searchBy(account: Account): Individual {
        val accountBranchIndividual = BranchIndividualData.get { account.branchIndividualId == it.id }.first()
        val accountIndividualId = accountBranchIndividual.individualId
        return get { accountIndividualId == it.id }.first()
    }

    fun searchBy(accountNumber: String): Individual = searchBy(AccountData.searchBy(accountNumber))

    fun searchBy(vararg branchesIds: UUID): List<Individual> {
        val relatedIndividualsIds = BranchIndividualData.searchByBranchesIds(*branchesIds).map { it.individualId }
        return get { it.id!! in relatedIndividualsIds }
    }

    /*
     * Find available Individuals for user.
     * * Individual is available to BANK USER if Individual's id is present in BranchIndividual record,
     * (related to BankRepresentative record,) related to user
     * * Individual is available to CLIENT USER if Individual's id is present in ClientRepresentative record, related to user
     *
     */
    // fun searchBy(user: User): List<Individual> {
    //     val availableIndividualsIds: List<UUID> =
    //         when (user.userType) {
    //             UserType.BANK -> {
    //                 val availableBranchesIds = BranchRepresentativeData.searchBy(user).map { it.branchId!! }
    //                 BranchIndividualData.searchByBranchesIds(*availableBranchesIds.toTypedArray()).map { it.individualId }
    //             }
    //             UserType.CLIENT -> IndividualRepresentativeData.searchBy(user).map { it.individualId }
    //             else -> throw RuntimeException("Unexpected user type: ${user.userType}")
    //         }

    //     return get { it.id!! in availableIndividualsIds }
    //         .filter(atMarkerPredicate)
    // }
    //TODO Khatmullin [2021.05.31] temporary solution before the implementation of links
    fun searchBy(user: User): List<Individual> {
        val personIds = PersonData.searchBy(user).map { it.id }
        return get { it.personId in personIds }
    }

    @Step("Найти или создать запись ${DictionaryNames.INDIVIDUAL} для {user.login}")
    fun getOrCreate(
        user: User,
        personUser: User = Users.individual,
        additionalFilter: (Individual) -> Boolean = { true }
    ): Individual {
        return getOrCreate(
            { searchBy(user).filter(additionalFilter) },
            { IndividualPrepareSteps.createIndividualDto(user, personUser).toModel() }
        )
    }

    // @Step("Получить id клиентов банка, с которыми связаны каждый из пользователей ({firstUser.login}, {secondUser.login})")
    // fun getCommonIndividualsIds(firstUser: User, secondUser: User): Set<UUID>? {
    //     val firstIndividualIds = searchBy(firstUser).map { it.id!! }
    //     val secondIndividualIds = searchBy(secondUser).map { it.id!! }
    //     return firstIndividualIds.intersect(secondIndividualIds).ifEmpty { null }
    // }

    //  @Step("Найти существующего клиента банка, общего для пользователей ({firstUser.login}, {secondUser.login}), или создать нового")
    //  fun getOrCreateCommonIndividualsId(firstUser: User, secondUser: User): UUID {
    //      return getCommonIndividualsIds(firstUser, secondUser)?.random()
    //          ?: {
    //              val clientRelatedIndividual = getOrCreate(firstUser)
    //              if (secondUser.isClient) {
    //                  IndividualPrepareSteps.ensureClientUserIsRelatedToIndividual(secondUser, clientRelatedIndividual.id!!)
    //              } else {
    //                  IndividualPrepareSteps.ensureBankUserIsRelatedToIndividual(secondUser, clientRelatedIndividual.id!!)
    //              }
    //              clientRelatedIndividual.id!!
    //          }.invoke()
    //  }
}