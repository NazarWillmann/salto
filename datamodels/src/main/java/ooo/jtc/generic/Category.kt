package ooo.jtc.generic

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.OperandType
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.interfaces.IDocument
import ooo.jtc.uaa.UserType

interface Category<out T: IDocument> {
    val category: String

    fun getStatuses(userType: UserType): List<IDocumentStatus<T>>
}

fun <T: IDocument> Category<T>.getFilterData() = FilterData(
    field = "category",
    predicate = Predicate.EQ,
    value = this.category,
    operands = null,
    type = OperandType.CONDITION
)

/** Generic category DTO */
@JsonIgnoreProperties(ignoreUnknown = true)
data class CategoryDto(
    var name: String,
    var desc: String
)

data class CategoryCountResponse(
    override val data: Map<String, Int>?
): GenericDto<Map<String, Int>>(data = data)

data class CategoryListResponse(
    override val data: List<CategoryDto>?
): GenericDto<List<CategoryDto>>(data = data)
