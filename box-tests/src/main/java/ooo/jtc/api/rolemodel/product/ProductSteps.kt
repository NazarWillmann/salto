package ooo.jtc.api.rolemodel.product

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.generic.GenericResponseDto
import ooo.jtc.rolemodel.product.ProductDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.uaa.User
import java.util.*

class ProductSteps(user: User = bankAdmin) : AbstractDictionarySteps<ProductDto, ProductDto>(
    user = user,
    entity = ProductDto::class.java,
    service = Services.DOMAIN_CONTROLLER,
    dictionaryName = "product"
){
    override fun create(entity: ProductDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<ProductDto> {
        throw RuntimeException("This is read-only entity")
    }
    override fun update(entity: ProductDto, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<ProductDto> {
        throw RuntimeException("This is read-only entity")
    }
    override fun delete(id: UUID, withCheckResponseCode: Boolean, statusCode: Int): GenericResponseDto<ProductDto> {
        throw RuntimeException("This is read-only entity")
    }
}
