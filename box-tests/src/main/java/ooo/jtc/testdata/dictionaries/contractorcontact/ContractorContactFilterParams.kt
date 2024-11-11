package ooo.jtc.testdata.dictionaries.contractorcontact

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto

enum class ContractorContactFilterParams(
    override var field: String,
    override var fieldDataProvider: (ContractorContactDto) -> Any
) : IFilterParams<ContractorContactDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    NAME("name", fieldDataProvider = { it.name }),
    EMAIL("email", fieldDataProvider = { it.email!! }),
    COMMENT("comment", fieldDataProvider = { it.comment!! }),
    POSITION("position", fieldDataProvider = { it.position!! }),
    TELEPHONE("telephone", fieldDataProvider = { it.telephone!! }),
    CONTRACTOR_ID("contractorId", fieldDataProvider = { it.contractorId }),
    ;
}