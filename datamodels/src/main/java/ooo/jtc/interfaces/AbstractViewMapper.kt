package ooo.jtc.interfaces

/**
 * Abstract dto <-> view mapper.
 *
 * @param <D> D - DTO object type
 * @param <V> V - entity object type
 */
interface AbstractViewMapper<D, V> {
    /**
     * Map Entity to View.
     *
     * @param dto DTO
     * @return View
     */
    fun toView(dto: D): V

    /**
     * Map View to Dto.
     *
     * @param view View
     * @return D dto
     */
    fun toDto(view: V): D

}