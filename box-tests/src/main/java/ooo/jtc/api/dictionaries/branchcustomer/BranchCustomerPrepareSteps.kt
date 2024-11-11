package ooo.jtc.api.dictionaries.branchcustomer

import io.qameta.allure.Step
import ooo.jtc.allure.attachToAllure
import ooo.jtc.api.common.filter.IFilterParams.Companion.and
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.extensions.ifNotEmpty
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerFilterParams
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.uaa.User
import java.util.*

object BranchCustomerPrepareSteps {

    /**
     * Подготовка для кейса: Клиента ЮЛ банка [idCustomer] (клиентского пользователя [customerUser])
     * привязываем к непривязанному (к этому Клиенту ЮЛ) Подразделению.
     */
    @Step("Подготовить DTO для создания связи Клиента ЮЛ ({idCustomer}) с не связанным с ним Подразделением")
    fun getBranchCustomerDtoForCreate(
        customerUser: User = client,
        idCustomer: UUID = CustomerData.getOrCreate(customerUser).id!!
    ): BranchCustomerDto {
        customerUser.checkIsClientUser("Для создания связи от банковского пользователя, используйте функцию с передечей `idBranch`.")
        val linkedBranches = BranchCustomerData.searchByCustomersIds(idCustomer)
        val linkedBranchesIds = linkedBranches.map { it.branchId }.distinct()

        val unlinkedBranchIds = BranchData.get { it.id !in linkedBranchesIds }.map { it.id!! }

        var availableBranchId = unlinkedBranchIds.ifNotEmpty { it.random() }

        if (unlinkedBranchIds.isEmpty()) {
            val linkedBranchCustomer = linkedBranches.random()
            BranchCustomerSteps().delete(linkedBranchCustomer.id!!)
            availableBranchId = linkedBranchCustomer.branchId
        }

        return getBranchCustomerDtoForCreate(availableBranchId!!, idCustomer).attachToAllure("result")
    }

    fun getBranchCustomerDtoForCreate(
        idBranch: UUID,
        idCustomer: UUID
    ): BranchCustomerDto {
        return BranchCustomerDto(
            id = null,
            version = 0,

            // not unique, even in pair with customerId, but limited to available to current user
            branchId = idBranch,
            customerId = idCustomer
        )
    }

    fun getBranchCustomerDtoForUpdate(createdDto: BranchCustomerDto) =
        BranchCustomerDto(
            createdDto.id, createdDto.version,
            branchId = BranchData.get { it.id != createdDto.branchId }.random().id!!,
            customerId = createdDto.customerId
        )


    @Step("Проверить, что Подразделение [{branchId}] и Клиент ЮЛ [{customerId}] связаны")
    fun isBranchAndCustomerAreRelated(branchId: UUID, customerId: UUID): Pair<Boolean, BranchCustomerDto?> {
        val pageParamsWithFilter = GetPageRequest()
        pageParamsWithFilter.params.filter = Filter(
            and(
                { BranchCustomerFilterParams.BRANCH_ID.eq(branchId) },
                { BranchCustomerFilterParams.CUSTOMER_ID.eq(customerId) }
            )
        )

        val getPageResponse = BranchCustomerSteps().getPage(pageParamsWithFilter)

        val isRelated = 0 < getPageResponse.size!!
        val relatedDto = getPageResponse.page?.ifNotEmpty { it.random() }
        return Pair(isRelated, relatedDto)
    }

    @Step("Найти id связей между Подразделениями банка и Клиентом ЮЛ '{customerId}'")
    fun getBranchCustomerRelationIds(customerId: UUID): List<UUID?>? {
        val pageRequest = BranchCustomerFilterParams.CUSTOMER_ID.eq(customerId).toPageRequest()
        return BranchCustomerSteps().getPage(getPageRequest = pageRequest).page?.map { it.id }
    }

    /**
     * Check if customer with provided id is related to branch with provided id.
     * Create relation if it doesn't exist.
     */
    @Step("Удостовериться, что Подразделение [{branchId}] и Клиент ЮЛ [{customerId}] связаны")
    fun ensureBranchAndCustomerAreRelated(branchId: UUID, customerId: UUID): BranchCustomerDto {
        val steps = BranchCustomerSteps()
        val checkResult = isBranchAndCustomerAreRelated(branchId, customerId)
        if (checkResult.first)
            return checkResult.second!!

        val branchCustomerDto = getBranchCustomerDtoForCreate(branchId, customerId)
        return steps.create(branchCustomerDto).data
            ?: throw RuntimeException("Ошибка при создании связи Подразделения '$branchId' и Клиента ЮЛ банка '$customerId'")
    }

    @Step("Создать связь Клиента ЮЛ [{dtoForCreate.customerId}] и Подразделения [{dtoForCreate.branchId}] ")
    fun createBranchCustomer(dtoForCreate: BranchCustomerDto = getBranchCustomerDtoForCreate()): BranchCustomerDto {
        return BranchCustomerSteps().create(dtoForCreate).data.getOrException()
    }
}