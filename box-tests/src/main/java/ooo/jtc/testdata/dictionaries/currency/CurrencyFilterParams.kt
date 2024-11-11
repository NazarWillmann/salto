package ooo.jtc.testdata.dictionaries.currency

import ooo.jtc.api.common.filter.IFilterParams
import ooo.jtc.dictionaries.currency.CurrencyDto

enum class CurrencyFilterParams(
    override var field: String,
    override var fieldDataProvider: (CurrencyDto) -> Any
) : IFilterParams<CurrencyDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DIGIT_CODE("digitCode", fieldDataProvider = { it.digitCode }),
    ALPHA_CODE("alphaCode", fieldDataProvider = { it.alphaCode }),
    NAME("name", fieldDataProvider = { it.name }),
    NAME_IN_OKV("nameInOkv", fieldDataProvider = { it.nameInOkv }),
    MINOR_UNIT_COUNT("minorUnitCount", fieldDataProvider = { it.minorUnitCount }),
    ;

}