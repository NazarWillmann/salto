package ooo.jtc.testdata.dictionaries.ndspercent

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.ndspercent.NdsPercentDto

enum class NdsPercentSortingParams(
    override var field: String,
    override var fieldDataProvider: (NdsPercentDto) -> Any?
) : ISortingParams<NdsPercentDto> {
    ID("id", fieldDataProvider = { it.id }),
    PERCENT("percent", fieldDataProvider = { it.percent }),
    IS_DEFAULT_RU_PAYMENT("isDefaultRuPayment", fieldDataProvider = { it.isDefaultRuPayment }),
    ;

}