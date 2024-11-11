package ooo.jtc.testdata.dictionaries.customerrepresentative

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.core.TestConstants.MIN_ZONED_DATE
import ooo.jtc.core.TestConstants.NON_EXISTENT_ID
import ooo.jtc.dictionaries.customerrepresentative.CustomerRepresentativeDto

enum class CustomerRepresentativeSortingParams(
    override var field: String,
    override var fieldDataProvider: (CustomerRepresentativeDto) -> Any?
) : ISortingParams<CustomerRepresentativeDto> {
    ID("id", fieldDataProvider = { it.id }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    USER_ID("userId", fieldDataProvider = { it.userId }),
    IS_BLOCKED("block.isBlock", fieldDataProvider = { it.block.isBlock }),
    BLOCK_DATE("block.blockDate", fieldDataProvider = { it.block.blockDate }),
    BLOCK_USER("block.blockUser", fieldDataProvider = { it.block.blockUser }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    POSITION("position", fieldDataProvider = { it.position }),
    EMAIL("email", fieldDataProvider = { it.email }),
    PHONE("phone", fieldDataProvider = { it.phone }),
    ;
}