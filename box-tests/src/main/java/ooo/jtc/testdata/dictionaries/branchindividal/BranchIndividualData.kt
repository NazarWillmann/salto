package ooo.jtc.testdata.dictionaries.branchindividal

import ooo.jtc.dictionaries.branchindividual.BranchIndividual
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.individual.IndividualData
import java.util.UUID

/**
 * BranchIndividual data, that loaded from testDataProvider as [BranchIndividualData] in [BranchIndividual] format.
 */
object BranchIndividualData : TestDataAT<BranchIndividual>(BranchIndividual::class.java) {
    override var atMarkerPredicate: (BranchIndividual) -> Boolean = { bc ->
        bc.branchId in BranchData.get(false, predicate = BranchData.atMarkerPredicate).map { it.id!! }
                || bc.individualId in IndividualData.get(false, predicate = IndividualData.atMarkerPredicate).map { it.id!! }
    }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM branch_individual") }
    override val dataFileName: String = "branchIndividual.json"

    fun searchByBranchesIds(vararg branchesIds: UUID) = get { it.branchId in branchesIds }

    fun searchByIndividualsIds(vararg individualsIds: UUID) = get { it.individualId in individualsIds }

    fun searchBy(branchId: UUID, individualId: UUID) = get { branchId == it.branchId && individualId == it.individualId }

    /* TODO Sergeyev [2021.02.16]: WiP
    fun searchBy(user: User): List<BranchIndividual> {
        return if (UserType.BANK == user.userType) {
            val availableBranchesIds = BranchRepresentativeData.searchBy(user).map { it.branchId!! }
            get { it.branchId in availableBranchesIds }
        } else {
            val availableIndividualsIds = IndividualRepresentativeData.searchBy(user).map { it.individualId!! }
            get { it.individualId in availableIndividualsIds }
        }
    }

    fun getOrCreate(branchId: UUID, customerId: UUID) =
        getOrCreate(
            consumer = { searchBy(branchId, customerId) },
            provider = {
                BranchIndividualSteps().create(
                    getBranchIndividualDtoForCreate(branchId, customerId)
                ).data.getOrException().toModel()
            }
        )

    @Step("Получить id связей 'Клиент-Банк', общих для пользователей ({clientUser.login}, {bankUser.login})")
    fun getCommonBranchIndividualsIds(clientUser: User, bankUser: User, withBlockedIndividuals: Boolean = false): Set<UUID>? {
        val availableToClientUser = searchBy(clientUser).map { it.id!! }
        val availableToBankUser = if (withBlockedIndividuals) {
            searchBy(bankUser).map { it.id!! }
        } else {
            val blockedIndividualsIds = IndividualData.get { it.isBlock }.map { it.id!! }
            searchBy(bankUser)
                .filter { it.individualId !in blockedIndividualsIds }
                .map { it.id!! }
        }
        return availableToClientUser.intersect(availableToBankUser).ifEmpty { null }
    }

    @Step("Найти существующую или создать новую связь 'Клиент-Банк', общую для пользователей ({clientUser.login}, {bankUser.login})")
    fun getOrCreateCommonBranchIndividual(clientUser: User, bankUser: User): BranchIndividual {
        clientUser.checkIsClientUser()
        bankUser.checkIsBankUser()

        return getCommonBranchIndividualsIds(clientUser, bankUser)
            ?.let { byId(it.random()) }
            ?: {
                val clientUserIndividualId = IndividualData.getOrCreate(clientUser).id!!
                val bankUserBranchId = BranchData.getOrCreate(
                    consumer = { BranchData.searchBy(bankUser) },
                    provider = { BranchPrepareSteps.createBranchWithRelatedEntitiesForUsers(bankUser).toModel() }
                ).id!!

                if (isUserRelatedToIndividual(bankUser, clientUserIndividualId)) {
                    // на случай, если в рамках текущего скоупа тестов уже создавалась связь
                    val filter = Filter(IFilterParams.and(
                        { BranchIndividualFilterParams.BRANCH_ID.eq(bankUserBranchId) },
                        { BranchIndividualFilterParams.INDIVIDUAL_ID.eq(clientUserIndividualId) }
                    ))
                    BranchIndividualSteps().getPage(GetPageRequest(Params(filter = filter))).page!!.first().toModel()
                } else {
                    val brIndForCreate = getBranchIndividualDtoForCreate(bankUserBranchId, clientUserIndividualId)
                    BranchIndividualSteps().create(brIndForCreate).data.getOrException().toModel()
                }
            }.invoke()
    }*/
}
