package ooo.jtc.generic.pageparams

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonValue

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class FilterData(
    var field: String? = null,
    var predicate: Predicate? = null,
    var value: Any? = null,
    var operands: List<Operand>? = null,
    var type: OperandType? = null
)

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Operand(
    var field: String? = null,
    var predicate: Predicate? = null,
    var type: OperandType? = null,
    var value: Any? = null,
    var operands: List<Operand>? = null
) {
    constructor(filterData: FilterData) : this(
        field = filterData.field,
        predicate = filterData.predicate,
        type = filterData.type,
        value = filterData.value,
        operands = filterData.operands
    )
}

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Filter(var data: FilterData)

enum class OperandType(@get:JsonValue var value: String) {
    AND("and"),
    OR("or"),
    CONDITION("condition")
}

enum class Predicate(@get:JsonValue var value: String) {
    CONTAINS("contains"),
    GE("ge"),
    LE("le"),
    EQ("eq")
}

fun FilterData.toFilter(): Filter {
    return Filter(this)
}

fun FilterData.toParams(sort: List<Sort> = listOf(), paging: Paging = defaultPaging): Params {
    return Params(Filter(this), sort = sort, paging = paging)
}

fun FilterData.toPageRequest(): GetPageRequest {
    return GetPageRequest(Params(Filter(this)))
}

fun FilterData.and(anotherOperand: FilterData): FilterData {
    return if (operands != null) {
        operands = operands!!.toMutableList().apply { add(Operand(anotherOperand)) }
        this
    } else {
        FilterData(
            operands = listOf(Operand(this), Operand(anotherOperand)),
            type = OperandType.AND
        )
    }
}

fun FilterData.or(anotherOperand: FilterData): FilterData {
    return if (operands != null) {
        operands = operands!!.toMutableList().apply { add(Operand(anotherOperand)) }
        this
    } else {
        FilterData(
            operands = listOf(Operand(this), Operand(anotherOperand)),
            type = OperandType.OR
        )
    }
}


fun Filter.toParams(sort: List<Sort> = listOf(), paging: Paging = defaultPaging): Params {
    return Params(filter = this, sort = sort, paging = paging)
}

fun Filter.toPageRequest(): GetPageRequest {
    return GetPageRequest(Params(this))
}