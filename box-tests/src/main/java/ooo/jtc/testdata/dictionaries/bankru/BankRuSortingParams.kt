package ooo.jtc.testdata.dictionaries.bankru

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.bankru.BankRuDto

enum class BankRuSortingParams(
    override var field: String,
    override var fieldDataProvider: (BankRuDto) -> Any?,
    var limit: Int = 100
) : ISortingParams<BankRuDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BIC("bic", fieldDataProvider = { it.bic }),
    ZIP("zip", fieldDataProvider = { it.zip }),
    PHONE("phone", fieldDataProvider = { it.phone }),
    ADDRESS("address", fieldDataProvider = { it.address }),
    LOCATION("location", fieldDataProvider = { it.location }),
    BANK_NAME("bankName", fieldDataProvider = { it.bankName }),
    REG_NUMBER("regNumber", fieldDataProvider = { it.regNumber }),
    CONTROL_DATE("controlDate", fieldDataProvider = { it.controlDate }, limit = 500),
    CORR_ACCOUNT("corrAccount", fieldDataProvider = { it.corrAccount }),

    LOCTYPE_ID("locationTypeId", fieldDataProvider = { it.idLocationType }),
    LOCTYPE_NESTED_ID("locationType.id", fieldDataProvider = { it.locationType?.id }),
    LOCTYPE_NESTED_TYPE("locationType.locationType", fieldDataProvider = { it.locationType?.locationType }),

    CTRLCODE_ID("controlCodeId", fieldDataProvider = { it.idControlCode }, limit = 500),
    CTRLCODE_NESTED_ID("controlCode.id", fieldDataProvider = { it.controlCode?.id }, limit = 500),
    CTRLCODE_NESTED_CODE("controlCode.code", fieldDataProvider = { it.controlCode?.code }, limit = 500),
    CTRLCODE_NESTED_DESCR("controlCode.description", fieldDataProvider = { it.controlCode?.description }, limit = 500),

    UER_ID("uerId", fieldDataProvider = { it.idUer }),
    UER_NESTED_ID("uer.id", fieldDataProvider = { it.uer!!.id }),
    UER_NESTED_UER("uer.uer", fieldDataProvider = { it.uer!!.uer }),
    UER_NESTED_BANKTYPE("uer.bankType", fieldDataProvider = { it.uer!!.bankType }),
    UER_NESTED_DESCR("uer.description", fieldDataProvider = { it.uer!!.description }),
    ;
}