@file:Suppress("UNCHECKED_CAST")

package ooo.jtc.api.common.filter

import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Operand
import ooo.jtc.generic.pageparams.OperandType
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.interfaces.IEntityDto

/**
 * Entity filtering params
 * Filtration rules by default https://confluence.jtc.ooo/pages/viewpage.action?pageId=12912916
 */
interface IFilterParams<T : IEntityDto> {

    /**
     * Field name for filtering
     */
    var field: String

    /**
     * Method for retrieve field data from dto
     */
    var fieldDataProvider: (T) -> Any


    private fun prepFilterData(predicate: Predicate, value: Any): FilterData =
        FilterData(
            field = field,
            predicate = predicate,
            type = OperandType.CONDITION,
            value = value
        )

    /**
     * Creating Filter Data that find entities when [field] contains [value]
     */
    fun contains(value: Any): FilterData = prepFilterData(Predicate.CONTAINS, value)

    /**
     * Creating Filter Data that find entities when [field] equals [value]
     */
    fun eq(value: Any): FilterData = prepFilterData(Predicate.EQ, value)

    /**
     * Creating Filter Data that find entities when [field] ge [value]
     */
    fun ge(value: Any): FilterData = prepFilterData(Predicate.GE, value)

    /**
     * Creating Filter Data that find entities when [field] le [value]
     */
    fun le(value: Any): FilterData = prepFilterData(Predicate.LE, value)

    companion object {

        /**
         * Find Filter params in enum by field name.
         */
        fun <E : IEntityDto, T : IFilterParams<E>> findByFiledName(
            fieldName: String,
            iFilterParamsClass: Class<T>
        ): IFilterParams<E> {
            return iFilterParamsClass.enumConstants.first { it.field == fieldName }
        }

        /**
         * Join any operands with AND predicate
         */
        fun and(vararg operands: () -> FilterData): FilterData {
            return FilterData(
                operands = operands.map { it.invoke() }.map { Operand(it) },
                type = OperandType.AND
            )
        }

        /**
         * Join any operands with OR predicate
         */
        fun or(vararg operands: () -> FilterData): FilterData {
            return FilterData(
                operands = operands.map { it.invoke() }.map { Operand(it) },
                type = OperandType.OR
            )
        }

    }

}
