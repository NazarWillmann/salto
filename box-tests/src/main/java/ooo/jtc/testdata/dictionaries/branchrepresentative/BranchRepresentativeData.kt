package ooo.jtc.testdata.dictionaries.branchrepresentative

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps.createBranchRepresentativeDto
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativePrepareSteps.getBranchRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.branchrepresentative.BranchRepresentativeSteps
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentative
import ooo.jtc.dictionaries.branch.Branch
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User

/**
 * Branch representatives data, that loaded from testDataProvider as [BranchRepresentativeData] in [BranchRepresentative] format.
 */
object BranchRepresentativeData : TestDataAT<BranchRepresentative>(BranchRepresentative::class.java) {
    override var atMarkerPredicate: (BranchRepresentative) -> Boolean = { it.position?.endsWith(AT_POSTFIX) ?: false }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM branch_representative") }
    override val dataFileName = "branchRepresentative.json"

    override var removeRecord: ((BranchRepresentative) -> Unit)? = { BranchRepresentativeSteps(Users.superUser).delete(it.id!!) }

    /**
     * Find [BranchRepresentative] records related to (bank) user.
     *
     * Calling this with client user will always result in an exception
     */
    fun searchBy(bankUser: User): List<BranchRepresentative> {
        bankUser.checkIsBankUser()
        return get { bankUser.uaaUserId!! == it.userId }
    }

    /**
     * Find the only one [BranchRepresentative] record for provided bankUser.
     *
     * @return the only one [BranchRepresentative] record OR [null], if there are multiple records or no records at all
     */
    fun getOnlyOneOrNull(bankUser: User): BranchRepresentative? =
        searchBy(bankUser).let { if (1 == it.size) it.first() else null }

    /**
     * [bankUser] bank user for creating relation with [branch]
     */
    @Step("Найти в БД или создать запись '${DictionaryNames.BRANCH_REPRESENTATIVE}' для пользователя {bankUser.login}")
    fun getOrCreate(
        bankUser: User,
        branch: Branch = BranchData.getOrCreate { BranchPrepareSteps.createBranchWithRelatedEntitiesForUsers(bankUser).toModel() }
    ): BranchRepresentative {
        return getOrCreate(
            consumer = { searchBy(bankUser) },
            provider = { createBranchRepresentativeDto(getBranchRepresentativeDtoForCreate(bankUser.uaaUserId!!, branch.id!!)).toModel() }
        ).attachToAllure()
    }

    @Step("Проверить, связан ли пользователь только с одним подразделением")
    fun checkIfUserHasOnlyOneBranch(bankUser: User): Boolean {
        val userBranches = searchBy(bankUser).map { it.branchId }.distinct()
        return (1 == userBranches.size)
    }
}

/**
 * Enum for searching [BranchRepresentative] in [BranchRepresentativeData]
 */
enum class FindBranchRepresentativeBy(override var predicate: (BranchRepresentative) -> Boolean) :
    FindEntityBy<BranchRepresentative, BranchRepresentativeData> {

    AT_CREATED(BranchRepresentativeData.atMarkerPredicate),
    BLOCKED({ it.isBlock }),
    ;
}