package ooo.jtc.rolemodel.accessobject

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface AccessObjectMapper : AbstractDtoMapper<AccessObject, AccessObjectDto>
