package ooo.jtc.api.dictionaries.customer

import io.qameta.allure.Step
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerDtoForCreate
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerPrepareSteps.getBranchCustomerRelationIds
import ooo.jtc.api.dictionaries.branchcustomer.BranchCustomerSteps
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativePrepareSteps.getCustomerRepresentativeIds
import ooo.jtc.api.dictionaries.customerrepresentative.CustomerRepresentativeSteps
import ooo.jtc.dictionaries.customer.CustomerDto
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.uaa.User
import java.util.*

class CustomerSteps(user: User) :
    AbstractDictionarySteps<CustomerDto, CustomerDto>(
        user = user,
        entity = CustomerDto::class.java,
        dictionaryName = "customer"
    ) {

    @Step("Создать {this.entityName}: со связанным подразделением BranchCustomer")
    override fun create(
        entity: CustomerDto,
        withCheckResponseCode: Boolean,
        statusCode: Int
    ): GenericResponseDto<CustomerDto> {
        val response = super.create(entity, withCheckResponseCode, statusCode)
        response.validationResult?.let {
            if (ControlCheckResult.INVALID == it.result)
                throw RuntimeException("Error: creating Customer failed. Check validationResult for more info.")
        }
        "Создать связь созданного клиента банка с доступным пользователю подразделением" {// необходимо для дальнейшего обращения к клиенту в системе
            val availableToUserBranch = BranchData.searchBy(user).map { it.id!! }.random()
            val branchCustomerDto = getBranchCustomerDtoForCreate(availableToUserBranch, response.data!!.id!!)
            BranchCustomerSteps().create(branchCustomerDto)
        }
        return response
    }

    @Step("Удалить '{this.entityName}' по id={id} с проверкой представителей")
    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<CustomerDto> {
        //delete all representatives for customer
        val clientRepresentativeIds = getCustomerRepresentativeIds(id)
        clientRepresentativeIds?.let { ids ->
            val crSteps = CustomerRepresentativeSteps()
            ids.forEach { it?.let { crSteps.delete(it) } }
        }

        //delete customer branch relations
        val branchCustomerRelationIds = getBranchCustomerRelationIds(id)
        branchCustomerRelationIds?.let { ids ->
            val bcSteps = BranchCustomerSteps()
            ids.forEach { it?.let { bcSteps.delete(it) } }
        }

        return super.delete(id, withCheckResponseCode, statusCode)
    }

    fun createWithoutBranchCustomer(
        entity: CustomerDto,
        withCheckResponseCode: Boolean = true,
        statusCode: Int = 200
    ): GenericResponseDto<CustomerDto> {
        val response = super.create(entity, withCheckResponseCode, statusCode)
        response.validationResult?.let {
            if (ControlCheckResult.INVALID == it.result)
                throw RuntimeException("Error: creating Customer failed. Check validationResult for more info.")
        }
        return response
    }
}