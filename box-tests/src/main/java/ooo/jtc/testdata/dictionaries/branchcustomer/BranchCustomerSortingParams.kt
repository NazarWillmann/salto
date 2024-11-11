package ooo.jtc.testdata.dictionaries.branchcustomer

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto

enum class BranchCustomerSortingParams(
    override var field: String,
    override var fieldDataProvider: (BranchCustomerDto) -> Any?
) : ISortingParams<BranchCustomerDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    ;

}