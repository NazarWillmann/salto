package ooo.jtc.dictionaries.country

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface CountryMapper : AbstractDtoMapper<Country, CountryDto>