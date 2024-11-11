package ooo.jtc.testdata.dictionaries.branch

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.branch.BranchDto

enum class BranchFilterParams(
    override var field: String,
    override var fieldDataProvider: (BranchDto) -> Any
) : IFilterParams<BranchDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BIC("paymentDetailsBic.bic", fieldDataProvider = { it.paymentDetailsBic!!.bic!! }),
    UI_NAME("uiName", fieldDataProvider = { it.uiName }),
    FULL_NAME("fullName", fieldDataProvider = { it.fullName }),
    SHORT_NAME("shortName", fieldDataProvider = { it.shortName }),
    BRANCH_TYPE("branchType", fieldDataProvider = { it.branchType }),

    EMAIL("email", fieldDataProvider = { it.email!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    SWIFT("paymentDetailsSwift.swift", fieldDataProvider = { it.paymentDetailsSwift!!.swift!! }),
    BANK_ID("bankId", fieldDataProvider = { it.bankId!! }),
    PARENT_BRANCH_ID("parentBranchId", fieldDataProvider = { it.parentBranchId!! }),
    ;

    //Not present in /GetPage-response:
    //Nested object (empty)
    //    addresses
    //Nested lists (empty)
    //    phoneSupports
    //    extIds
}