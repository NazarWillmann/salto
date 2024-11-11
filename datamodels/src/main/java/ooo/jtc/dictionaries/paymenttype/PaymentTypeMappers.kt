package ooo.jtc.dictionaries.paymenttype

import ooo.jtc.interfaces.AbstractDtoMapper
import ooo.jtc.interfaces.AbstractViewMapper
import ooo.jtc.uaa.user.dto.UaaUserDto
import ooo.jtc.uaa.user.model.UaaUser
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper
interface PaymentTypeMapper : AbstractDtoMapper<PaymentType, PaymentTypeDto>

@Mapper
interface PaymentTypeViewMapper : AbstractViewMapper<PaymentTypeDto, PaymentTypeView>