package ooo.jtc.dictionaries.codevo

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import org.mapstruct.Mapper

@Mapper
interface CodeVoMapper : AbstractDtoMapper<CodeVo, CodeVoDto>

@Mapper
interface CodeVOViewMapper : AbstractViewMapper<CodeVoDto, CodeVoView>