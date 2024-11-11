package ooo.jtc.testdata.dictionaries.agreement

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.agreement.AgreementDto

enum class AgreementFilterParams(
    override var field: String,
    override var fieldDataProvider: (AgreementDto) -> Any
) : IFilterParams<AgreementDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    AGREEMENT_DATE("agreementDate", fieldDataProvider = { it.agreementDate!! }),
    AGREEMENT_NUMBER("agreementNumber", fieldDataProvider = { it.agreementNumber!! }),
    AGREEMENT_TYPE("agreementType", fieldDataProvider = { it.agreementType!! }),
    END_DATE("endDate", fieldDataProvider = { it.endDate!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId!! }),
    STATUS("status", fieldDataProvider = { it.status!! }),
    ;
}