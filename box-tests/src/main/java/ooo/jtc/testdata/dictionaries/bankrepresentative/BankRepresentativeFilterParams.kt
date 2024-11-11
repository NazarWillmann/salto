package ooo.jtc.testdata.dictionaries.bankrepresentative

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.core.TestConstants.MIN_ZONED_DATE
import ooo.jtc.core.TestConstants.NON_EXISTENT_ID
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeDto

enum class BankRepresentativeFilterParams(
    override var field: String,
    override var fieldDataProvider: (BankRepresentativeDto) -> Any
) : IFilterParams<BankRepresentativeDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BANK_ID("bankId", fieldDataProvider = { it.bankId!! }),
    USER_ID("userId", fieldDataProvider = { it.userId!! }),
    IS_BLOCKED("block.isBlock", fieldDataProvider = { it.block.isBlock }),
    BLOCK_DATE("block.blockDate", fieldDataProvider = { it.block.blockDate ?: MIN_ZONED_DATE }),
    BLOCK_USER("block.blockUser", fieldDataProvider = { it.block.blockUser ?: NON_EXISTENT_ID }),
    POSITION("position", fieldDataProvider = { it.position!! }),
    EMAIL("email", fieldDataProvider = { it.email!! }),
    PHONE("phone", fieldDataProvider = { it.phone!! }),
    ;
}