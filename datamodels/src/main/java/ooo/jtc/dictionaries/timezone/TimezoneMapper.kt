package ooo.jtc.dictionaries.timezone

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface TimezoneMapper : AbstractDtoMapper<Timezone, TimezoneDto>