package ooo.jtc.testdata.dictionaries.branchrepresentative

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentativeDto

enum class BranchRepresentativeSortingParams(
    override var field: String,
    override var fieldDataProvider: (BranchRepresentativeDto) -> Any?
) : ISortingParams<BranchRepresentativeDto> {
    ID("id", fieldDataProvider = { it.id }),
    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),
    USER_ID("userId", fieldDataProvider = { it.userId }),
    IS_BLOCKED("block.isBlock", fieldDataProvider = { it.block.isBlock }),
    BLOCK_DATE("block.blockDate", fieldDataProvider = { it.block.blockDate }),
    BLOCK_USER("block.blockUser", fieldDataProvider = { it.block.blockUser }),
    POSITION("position", fieldDataProvider = { it.position }),
    EMAIL("email", fieldDataProvider = { it.email }),
    PHONE("phone", fieldDataProvider = { it.phone }),
    ;
}