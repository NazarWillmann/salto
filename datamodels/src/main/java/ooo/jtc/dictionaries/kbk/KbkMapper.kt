package ooo.jtc.dictionaries.kbk

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import org.mapstruct.Mapper

@Mapper
interface KbkMapper : AbstractDtoMapper<Kbk, KbkDto>

@Mapper
interface KbkViewMapper : AbstractViewMapper<KbkDto, KbkView>