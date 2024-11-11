package ooo.jtc.testdata.dictionaries.customer

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.customer.CustomerDto

enum class CustomerSortingParams(
    override var field: String,
    override var fieldDataProvider: (CustomerDto) -> Any?
) : ISortingParams<CustomerDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    INN("inn", fieldDataProvider = { it.inn }),
    OKPO("okpo", fieldDataProvider = { it.okpo!! }),
    IS_BLOCKED("block.isBlock", fieldDataProvider = { it.block.isBlock }),
    FULL_NAME("fullName", fieldDataProvider = { it.fullName }),
    SHORT_NAME("shortName", fieldDataProvider = { it.shortName }),
    IS_RESIDENT("isResident", fieldDataProvider = { it.isResident }),
//    CUSTOMER_TYPE_ID("customerTypeId", fieldDataProvider = { it.customerTypeId }),

    OGRN("ogrn", fieldDataProvider = { it.ogrn }),
//    OKTMO("oktmo", fieldDataProvider = { it.oktmo ?: "" }),
//    OKVED("okved", fieldDataProvider = { it.okved ?: "" }),
    EMAIL("email", fieldDataProvider = { it.email }),
    PHONE("phone", fieldDataProvider = { it.phone }),
    OGRN_DATE("ogrnDate", fieldDataProvider = { it.ogrnDate }),

    ;
}