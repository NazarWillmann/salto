package ooo.jtc.testdata.dictionaries.agreement

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.agreement.AgreementDto
import java.time.LocalDate

enum class AgreementSortingParams(
    override var field: String,
    override var fieldDataProvider: (AgreementDto) -> Any?
) : ISortingParams<AgreementDto> {
    ID("id", fieldDataProvider = { it.id }),
    AGREEMENT_DATE("agreementDate", fieldDataProvider = { it.agreementDate?: LocalDate.MIN }),
    AGREEMENT_NUMBER("agreementNumber", fieldDataProvider = { it.agreementNumber!! }),
    AGREEMENT_TYPE("agreementType", fieldDataProvider = { it.agreementType!! }),
    END_DATE("endDate", fieldDataProvider = { it.endDate?: LocalDate.MIN }),
    DESCRIPTION("description", fieldDataProvider = { it.description!! }),
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId }),
    STATUS("status", fieldDataProvider = { it.status }),
    ;
}