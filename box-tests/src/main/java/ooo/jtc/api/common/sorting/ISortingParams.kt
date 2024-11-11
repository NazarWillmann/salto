package ooo.jtc.api.common.sorting

import ooo.jtc.generic.pageparams.Direction
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.interfaces.IEntityDto

/**
 * Entity sorting params
 */
interface ISortingParams<T : IEntityDto> {

    /**
     * Field name for sorting
     */
    var field: String

    var fieldDataProvider: (T) -> Any?

    /**
     * Set sorting asc
     */
    fun asc(): List<Sort> = listOf(Sort(field = field, direction = Direction.ASC))

    /**
     * Set sorting desc
     */
    fun desc(): List<Sort> = listOf(Sort(field = field, direction = Direction.DESC))


    companion object {

        /**
         * Find Sorting params in enum by field name.
         */
        fun <E : IEntityDto, T : ISortingParams<E>> findByFiledName(fieldName: String, iFilterParamsClass: Class<T>): ISortingParams<E> {
            return iFilterParamsClass.enumConstants.first { it.field == fieldName }
        }

        /**
         * Join any operands with AND predicate
         */
        fun and(vararg operands: () -> List<Sort>): List<Sort> {
            val result: MutableList<Sort> = mutableListOf()
            operands.forEach { result.addAll(it.invoke()) }
            return result
        }

    }

}
