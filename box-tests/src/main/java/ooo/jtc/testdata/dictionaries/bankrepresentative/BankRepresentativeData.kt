package ooo.jtc.testdata.dictionaries.bankrepresentative

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps.createBankRepresentativeDto
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativePrepareSteps.getBankRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.bankrepresentative.BankRepresentativeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.dictionaries.bankinfo.BankInfo
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentative
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoData
import ooo.jtc.uaa.User
import java.util.UUID

/**
 * Bank representatives data, that loaded from testDataProvider as [BankRepresentativeData] in [BankRepresentative] format.
 */
object BankRepresentativeData : TestDataAT<BankRepresentative>(BankRepresentative::class.java) {
    override var atMarkerPredicate: (BankRepresentative) -> Boolean = { it.position?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_representative") }
    override val dataFileName = "bankRepresentative.json"

    override var removeRecord: ((BankRepresentative) -> Unit)? = { BankRepresentativeSteps(Users.superUser).delete(it.id!!) }

    /**
     * Find [BankRepresentative] records related to [bankUser].
     *
     * Calling this with client user will always result in an exception
     */
    fun searchBy(bankUser: User): List<BankRepresentative> {
        bankUser.checkIsBankUser()
        return get { bankUser.uaaUserId!! == it.userId }
    }

    /**
     * Find a single [BankRepresentative] record for
     * bankUser (by specified [bankUserId]) and bankInfo (by specified [bankInfoId]).
     *
     * @return a list with one or zero entries
     */
    fun searchBy(bankUserId: UUID, bankInfoId: UUID): List<BankRepresentative> {
        return get(predicate = { (bankUserId == it.userId) && (bankInfoId == it.bankId) })
    }

    /**
     * [bankUser] - user for creating relation with [bankInfo]
     */
    @Step("Найти в БД или создать запись '${DictionaryNames.BANK_REPRESENTATIVE}' для пользователя {bankUser.login}")
    fun getOrCreate(
        bankUser: User,
        bankInfo: BankInfo = BankInfoData.getOrCreate { BankInfoPrepareSteps.createBankInfoWithBankRepresentative(bankUser).toModel() }
    ): BankRepresentative {
        return getOrCreate(
            consumer = { searchBy(bankUser).filter(FindBankRepresentativeBy.NON_BLOCKED.predicate) },
            provider = {
                val newRepresentative = createBankRepresentativeDto(getBankRepresentativeDtoForCreate(bankUser.uaaUserId!!, bankInfo.id!!))
                bankUser.invokeAuth(newToken = true)
                newRepresentative.toModel()
            }
        ).attachToAllure()
    }
}

/**
 * Enum for searching [BankRepresentative] in [BankRepresentativeData]
 */
enum class FindBankRepresentativeBy(override var predicate: (BankRepresentative) -> Boolean) :
    FindEntityBy<BankRepresentative, BankRepresentativeData> {

    AT_CREATED(BankRepresentativeData.atMarkerPredicate),
    BLOCKED({ it.isBlock }),
    NON_BLOCKED({ !it.isBlock }),
    ;
}