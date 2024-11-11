package ooo.jtc.uaa.scope.mapper

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.uaa.scope.dto.ScopeDto
import ooo.jtc.uaa.scope.model.Scope
import org.mapstruct.Mapper


@Mapper
interface ScopeMapper : AbstractDtoMapper<Scope, ScopeDto>