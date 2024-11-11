package ooo.jtc.rolemodel.product

import ooo.jtc.interfaces.AbstractDtoMapper
import org.mapstruct.Mapper

@Mapper
interface ProductMapper : AbstractDtoMapper<Product, ProductDto>
