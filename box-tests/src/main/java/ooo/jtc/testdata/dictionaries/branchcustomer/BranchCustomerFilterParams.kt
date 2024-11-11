package ooo.jtc.testdata.dictionaries.branchcustomer

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto

enum class BranchCustomerFilterParams(
    override var field: String,
    override var fieldDataProvider: (BranchCustomerDto) -> Any
) : IFilterParams<BranchCustomerDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    ;

}