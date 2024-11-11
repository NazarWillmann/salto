package ooo.jtc.dictionaries.budgetpayerstatus

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import org.mapstruct.Mapper

@Mapper
interface BudgetPayerStatusMapper : AbstractDtoMapper<BudgetPayerStatus, BudgetPayerStatusDto>


@Mapper
interface BudgetPayerStatusViewMapper : AbstractViewMapper<BudgetPayerStatusDto, BudgetPayerStatusView>