package ooo.jtc.testdata.dictionaries.bankbic

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.bankbic.BankBicDto

enum class BankBicSortingParams(
    override var field: String,
    override var fieldDataProvider: (BankBicDto) -> Any?
) : ISortingParams<BankBicDto> {
    ID("id", fieldDataProvider = { it.id }),
    BIC("bic", { it.bic }),
    COUNTRY_2_ALPHA_CODE("countryAlpha2Code", { it.countryAlpha2Code }),
    ZIP("zip", { it.zip }),
    LOCATION_TYPE("locationType", { it.locationType }),
    LOCATION("location", { it.location }),
    ADDRESS("address", { it.address }),
    PARENT_BIC("parentBic", { it.parentBic }),
    PART_TRANSF_TYPE("participantTransferType", { it.participantTransferType.value }),
    PART_TYPE("participantType", { it.participantType.value }),
    ALLOWED_SERVICES("allowedServices", { it.allowedServices.value }),
    DATE_IN("dateIn", { it.dateIn }),
    DATE_OUT("dateOut", { it.dateOut }),
    STATUS("status", { it.status.value }),

    // NESTED: accounts: List<BankBicAccountDto>?
    // NESTED: restrictions: List<BankBicRestrictionDto>?
    ;
}
