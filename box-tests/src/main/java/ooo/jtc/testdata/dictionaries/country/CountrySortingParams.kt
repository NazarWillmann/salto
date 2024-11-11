package ooo.jtc.testdata.dictionaries.country

import ooo.jtc.api.common.sorting.ISortingParams
import ooo.jtc.dictionaries.country.CountryDto

enum class CountrySortingParams(
    override var field: String,
    override var fieldDataProvider: (CountryDto) -> Any?
) : ISortingParams<CountryDto> {
    ID("id", fieldDataProvider = { it.id!! }),
    DIGIT_CODE("digitCode", fieldDataProvider = { it.digitCode }),
    ALPHA_2_CODE("alpha2Code", fieldDataProvider = { it.alpha2Code }),
    ALPHA_3_CODE("alpha3Code", fieldDataProvider = { it.alpha3Code }),
    SHORT_NAME("shortName", fieldDataProvider = { it.shortName }),
    FULL_NAME("fullName", fieldDataProvider = { it.fullName }),
    INT_NAME("intNameIso", fieldDataProvider = { it.intNameIso!! }),
    ;
}