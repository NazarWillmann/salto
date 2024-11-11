package ooo.jtc.uaa.resource.mapper

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.uaa.resource.dto.ResourceDto
import ooo.jtc.uaa.resource.model.Resource
import org.mapstruct.Mapper

@Mapper
interface ResourceMapper : AbstractDtoMapper<Resource, ResourceDto>