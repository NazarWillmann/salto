package ooo.jtc.testdata.dictionaries.bankbic

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.bankbic.BankBicDto
import ooo.jtc.core.TestConstants

enum class BankBicFilterParams(
    override var field: String,
    override var fieldDataProvider: (BankBicDto) -> Any
) : IFilterParams<BankBicDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    BIC("bic", { it.bic }),
    COUNTRY_2_ALPHA_CODE("countryAlpha2Code", { it.countryAlpha2Code ?: "" }),
    ZIP("zip", { it.zip ?: "" }),
    LOCATION_TYPE("locationType", { it.locationType ?: "" }),
    LOCATION("location", { it.location ?: "" }),
    ADDRESS("address", { it.address ?: "" }),
    PARENT_BIC("parentBic", { it.parentBic ?: TestConstants.NON_EXISTENT_ID}),
    PART_TRANSF_TYPE("participantTransferType", { it.participantTransferType }),
    PART_TYPE("participantType", { it.participantType }),
    ALLOWED_SERVICES("allowedServices", { it.allowedServices }),
    DATE_IN("dateIn", { it.dateIn }),
    DATE_OUT("dateOut", { it.dateOut ?: TestConstants.MIN_ZONED_DATE }),
    STATUS("status", { it.status }),

    // NESTED: accounts: List<BankBicAccountDto>?
    // NESTED: restrictions: List<BankBicRestrictionDto>?
    ;
}
