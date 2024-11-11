package ooo.jtc.uaa.mfa.mapper

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.uaa.mfa.dto.MfaDto
import ooo.jtc.uaa.mfa.model.Mfa
import org.mapstruct.Mapper

@Mapper
interface MfaMapper : AbstractDtoMapper<Mfa, MfaDto>