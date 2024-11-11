package ooo.jtc.dictionaries.budgetreasoncode

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import org.mapstruct.Mapper

@Mapper
interface BudgetReasonCodeMapper : AbstractDtoMapper<BudgetReasonCode, BudgetReasonCodeDto>

@Mapper
interface BudgetReasonCodeViewMapper : AbstractViewMapper<BudgetReasonCodeDto, BudgetReasonCodeView>