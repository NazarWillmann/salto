package ooo.jtc.testdata.dictionaries.ndscalculation

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.ndscalculation.NdsCalculationDto

enum class NdsCalculationFilterParams(
    override var field: String,
    override var fieldDataProvider: (NdsCalculationDto) -> Any
) : IFilterParams<NdsCalculationDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    CODE("code", fieldDataProvider = { it.code }),
    TEMPLATE("template", fieldDataProvider = { it.template!! }),
    DESCRIPTION("description", fieldDataProvider = { it.description }),
    IS_DEFAULT_RU_PAYMENT("isDefaultRuPayment", fieldDataProvider = { it.isDefaultRuPayment }),
    ;

}