package ooo.jtc.dictionaries.branch

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface BranchMapper : AbstractDtoMapper<Branch, BranchDto>