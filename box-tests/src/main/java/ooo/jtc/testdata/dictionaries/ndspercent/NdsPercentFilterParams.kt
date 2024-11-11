package ooo.jtc.testdata.dictionaries.ndspercent

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.ndspercent.NdsPercentDto

enum class NdsPercentFilterParams(
    override var field: String,
    override var fieldDataProvider: (NdsPercentDto) -> Any
) : IFilterParams<NdsPercentDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    PERCENT("percent", fieldDataProvider = { it.percent }),
    IS_DEFAULT_RU_PAYMENT("isDefaultRuPayment", fieldDataProvider = { it.isDefaultRuPayment }),
    ;

}