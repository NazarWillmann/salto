package ooo.jtc.interfaces

/**
 * Abstract dto <-> domain model mapper.
 *
 * @param <D> D - DTO object type
 * @param <E> E - entity object type
 */
interface AbstractDtoMapper<E, D> {
    /**
     * Map Entity to Domain model.
     *
     * @param dto DTO
     * @return Domain model
     */
    fun toDomainModel(dto: D): E

    /**
     * Map Domain model to Dto.
     *
     * @param domainModel Domain model
     * @return D dto
     */
    fun toDto(domainModel: E): D

}