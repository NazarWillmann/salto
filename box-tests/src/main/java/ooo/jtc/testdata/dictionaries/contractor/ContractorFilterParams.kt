package ooo.jtc.testdata.dictionaries.contractor

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.contractor.ContractorDto

enum class ContractorFilterParams(
    override var field: String,
    override var fieldDataProvider: (ContractorDto) -> Any
) : IFilterParams<ContractorDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    NAME("name", fieldDataProvider = { it.name }),
    INN("inn", fieldDataProvider = { it.inn ?: "" }),
    KPP("kpp", fieldDataProvider = { it.kpp ?: "" }),
    DESCRIPTION("description", fieldDataProvider = { it.description ?: "" }),
    //TODO A.Stykalin [16.06.2020] ждем описания всех требований https://jira.jtc.ooo/browse/JTCSALTO-820
    // для списка контрагентов https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170465
    //IS_FAVORITE("isFavorites", fieldDataProvider = { it.isFavorites?: false }),
    ;
}
