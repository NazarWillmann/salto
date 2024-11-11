package ooo.jtc.dictionaries.stmntoperationtype

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import org.mapstruct.Mapper

@Mapper
interface StatementOperationTypeMapper : AbstractDtoMapper<StatementOperationType, StatementOperationTypeDto>

@Mapper
interface StatementOperationTypeViewMapper : AbstractViewMapper<StatementOperationTypeDto, StatementOperationTypeView>