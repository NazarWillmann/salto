package ooo.jtc.testdata.dictionaries.branchcustomer

import io.qameta.allure.Step
import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.api.dictionaries.branch.BranchPrepareSteps
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.api.dictionaries.customer.CustomerPrepareSteps.isUserRelatedToCustomer
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.branchcustomer.BranchCustomer
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.interfaces.getOrException
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.testdata.dictionaries.customerrepresentative.CustomerRepresentativeData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType
import java.util.UUID

/**
 * BranchCustomer data, that loaded from testDataProvider as [BranchCustomerData] in [BranchCustomer] format.
 */
object BranchCustomerData : TestDataAT<BranchCustomer>(BranchCustomer::class.java) {
    override var atMarkerPredicate: (BranchCustomer) -> Boolean = { bc ->
        bc.branchId in BranchData.get(false, predicate = BranchData.atMarkerPredicate).map { it.id!! }
                || bc.customerId in CustomerData.get(false, predicate = CustomerData.atMarkerPredicate).map { it.id!! }
    }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM branch_customer") }
    override val dataFileName: String = "branchCustomer.json"

    fun searchByBranchesIds(vararg branchesIds: UUID) = get { it.branchId in branchesIds }

    fun searchByCustomersIds(vararg customersIds: UUID) = get { it.customerId in customersIds }

    fun searchBy(branchId: UUID, customerId: UUID) = get { branchId == it.branchId && customerId == it.customerId }

    fun searchBy(user: User, seekAtCreated: Boolean? = null): List<BranchCustomer> {
        return if (UserType.BANK == user.userType) {
            val availableBranchesIds = BranchRepresentativeData.searchBy(user).map { it.branchId!! }
            get(fromCache = false, seekAtCreated = seekAtCreated) { it.branchId in availableBranchesIds }
        } else {
            val availableCustomersIds = CustomerRepresentativeData.searchBy(user).map { it.customerId!! }
            get(fromCache = false, seekAtCreated = seekAtCreated) { it.customerId in availableCustomersIds }
        }
    }

    fun getOrCreate(branchId: UUID, customerId: UUID) =
        getOrCreate(
            consumer = { searchBy(branchId, customerId) },
            provider = {
                BranchCustomerSteps().create(
                    getBranchCustomerDtoForCreate(branchId, customerId)
                ).data.getOrException().toModel()
            }
        )

    @Step("Получить id связей 'Клиент-Банк', общих для пользователей ({clientUser.login}, {bankUser.login})")
    fun getCommonBranchCustomersIds(clientUser: User, bankUser: User, withBlockedCustomers: Boolean = false): Set<UUID>? {
        val availableToClientUser = searchBy(clientUser).map { it.id!! }
        val availableToBankUser = if (withBlockedCustomers) {
            searchBy(bankUser).map { it.id!! }
        } else {
            val blockedCustomersIds = CustomerData.get(fromCache = false) { it.isBlock }.map { it.id!! }
            searchBy(bankUser)
                .filter { it.customerId !in blockedCustomersIds }
                .map { it.id!! }
        }
        return availableToClientUser.intersect(availableToBankUser).ifEmpty { null }
    }

    @Step("Найти существующую или создать новую связь 'Клиент-Банк', общую для пользователей ({clientUser.login}, {bankUser.login})")
    fun getOrCreateCommonBranchCustomer(clientUser: User, bankUser: User): BranchCustomer {
        clientUser.checkIsClientUser()
        bankUser.checkIsBankUser()

        return getCommonBranchCustomersIds(clientUser, bankUser)
            ?.let { byId(it.random()) }
            ?: {
                val clientUserCustomerId = CustomerData.getOrCreate(clientUser).id!!
                val bankUserBranchId = BranchData.getOrCreate(
                    consumer = { BranchData.searchBy(bankUser) },
                    provider = { BranchPrepareSteps.createBranchWithRelatedEntitiesForUsers(bankUser).toModel() }
                ).id!!

                if (isUserRelatedToCustomer(bankUser, clientUserCustomerId)) {
                    // на случай, если в рамках текущего скоупа тестов уже создавалась связь
                    val filter = Filter(IFilterParams.and(
                        { BranchCustomerFilterParams.BRANCH_ID.eq(bankUserBranchId) },
                        { BranchCustomerFilterParams.CUSTOMER_ID.eq(clientUserCustomerId) }
                    ))
                    BranchCustomerSteps().getPage(GetPageRequest(Params(filter = filter))).page!!.first().toModel()
                } else {
                    val brCustForCreate = getBranchCustomerDtoForCreate(bankUserBranchId, clientUserCustomerId)
                    BranchCustomerSteps().create(brCustForCreate).data.getOrException().toModel()
                }
            }.invoke()
    }
}
