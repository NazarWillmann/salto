package ooo.jtc.testdata.dictionaries.bankrepresentative

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.core.TestConstants.MIN_ZONED_DATE
import ooo.jtc.core.TestConstants.NON_EXISTENT_ID
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeDto

enum class BankRepresentativeSortingParams(
    override var field: String,
    override var fieldDataProvider: (BankRepresentativeDto) -> Any?
) : ISortingParams<BankRepresentativeDto> {
    ID("id", fieldDataProvider = { it.id }),
    BANK_ID("bankId", fieldDataProvider = { it.bankId }),
    USER_ID("userId", fieldDataProvider = { it.userId }),
    IS_BLOCKED("block.isBlock", fieldDataProvider = { it.block.isBlock }),
    BLOCK_DATE("block.blockDate", fieldDataProvider = { it.block.blockDate }),
    BLOCK_USER("block.blockUser", fieldDataProvider = { it.block.blockUser }),
    POSITION("position", fieldDataProvider = { it.position }),
    EMAIL("email", fieldDataProvider = { it.email }),
    PHONE("phone", fieldDataProvider = { it.phone }),
    ;
}