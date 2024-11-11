package ooo.jtc.testdata.dictionaries.account

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.account.AccountDto

enum class AccountSortingParams(
    override var field: String,
    override var fieldDataProvider: (AccountDto) -> Any?
) : ISortingParams<AccountDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name }),
    STATE("state", fieldDataProvider = { it.state }),
    ACC_KIND("accountKind", fieldDataProvider = { it.accountKind }),
    ACC_NUMBER("accountNumber", fieldDataProvider = { it.accountNumber }),
    CURRENCY_DIGIT_CODE("currencyDigitCode", fieldDataProvider = { it.currencyDigitCode }),

    ACTUAL_BALANCE("actualBalance", fieldDataProvider = { it.actualBalance }),
    PLAN_BALANCE("planBalance", fieldDataProvider = { it.planBalance }),
    CARD_AMOUNT("cardAmount", fieldDataProvider = { it.cardAmount }),
    BLOCKED_AMOUNT("blockedAmount", fieldDataProvider = { it.blockedAmount }),

    OPEN_DATE("openDate", fieldDataProvider = { it.openDate }),
    CLOSE_DATE("closeDate", fieldDataProvider = { it.closeDate }),
    ACTUAL_DATE("actualDate", fieldDataProvider = { it.actualDate }),

    IS_BLOCK("block.isBlock", fieldDataProvider = { it.block.isBlock }),
    BLOCK_DATE("block.blockDate", fieldDataProvider = { it.block.blockDate }),
    BLOCK_USER("block.blockUser", fieldDataProvider = { it.block.blockUser }),
    IS_MARK_INFO("isMarkInfo", fieldDataProvider = { it.isMarkInfo }),
    DESCRIPTION("description", fieldDataProvider = { it.description ?: "" }),

    BR_CUST_ID("branchCustomerId", fieldDataProvider = { it.branchCustomerId }),
    BR_CUST_NESTED_ID("branchCustomer.id", fieldDataProvider = { it.branchCustomerId }),
    BR_CUST_NESTED_BRANCH_ID("branchCustomer.branchId", fieldDataProvider = { it.branchId }),
    BR_CUST_NESTED_CUSTOMER_ID("branchCustomer.customerId", fieldDataProvider = { it.customerId }),

    ACC_TYPE_ID("accountTypeId", fieldDataProvider = { it.accountTypeId }),
    ACC_TYPE_NESTED_ID("accountType.id", fieldDataProvider = { it.accountType?.id!! }),
    ACC_TYPE_NESTED_FULL_NAME("accountType.fullName", fieldDataProvider = { it.accountType?.fullName }),
    ACC_TYPE_NESTED_SHORT_NAME("accountType.shortName", fieldDataProvider = { it.accountType?.shortName }),
    ACC_TYPE_NESTED_SYSTEM_NAME("accountType.systemName", fieldDataProvider = { it.accountType?.systemName }),
    ACC_TYPE_NESTED_DESCRIPTION("accountType.description", fieldDataProvider = { it.accountType?.description }),
    ;
}