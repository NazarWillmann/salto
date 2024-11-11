package ooo.jtc.dictionaries.paymentpriority

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import org.mapstruct.Mapper

@Mapper
interface PaymentPriorityMapper : AbstractDtoMapper<PaymentPriority, PaymentPriorityDto>

@Mapper
interface PaymentPriorityViewMapper : AbstractViewMapper<PaymentPriorityDto, PaymentPriorityView>