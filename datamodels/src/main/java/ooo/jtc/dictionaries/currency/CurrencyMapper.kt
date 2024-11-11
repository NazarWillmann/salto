package ooo.jtc.dictionaries.currency

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface CurrencyMapper : AbstractDtoMapper<Currency, CurrencyDto>