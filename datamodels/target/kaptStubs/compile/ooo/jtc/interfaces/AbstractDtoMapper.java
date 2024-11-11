package ooo.jtc.interfaces;

import java.lang.System;

/**
 * Abstract dto <-> domain model mapper.
 *
 * @param <D> D - DTO object type
 * @param <E> E - entity object type
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\t"}, d2 = {"Looo/jtc/interfaces/AbstractDtoMapper;", "E", "D", "", "toDomainModel", "dto", "(Ljava/lang/Object;)Ljava/lang/Object;", "toDto", "domainModel", "datamodels"})
public abstract interface AbstractDtoMapper<E extends java.lang.Object, D extends java.lang.Object> {
    
    /**
     * Map Entity to Domain model.
     *
     * @param dto DTO
     * @return Domain model
     */
    public abstract E toDomainModel(D dto);
    
    /**
     * Map Domain model to Dto.
     *
     * @param domainModel Domain model
     * @return D dto
     */
    public abstract D toDto(E domainModel);
}