package ooo.jtc.interfaces;

import java.lang.System;

/**
 * Abstract dto <-> view mapper.
 *
 * @param <D> D - DTO object type
 * @param <V> V - entity object type
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H&\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00028\u00012\u0006\u0010\b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\t"}, d2 = {"Looo/jtc/interfaces/AbstractViewMapper;", "D", "V", "", "toDto", "view", "(Ljava/lang/Object;)Ljava/lang/Object;", "toView", "dto", "datamodels"})
public abstract interface AbstractViewMapper<D extends java.lang.Object, V extends java.lang.Object> {
    
    /**
     * Map Entity to View.
     *
     * @param dto DTO
     * @return View
     */
    public abstract V toView(D dto);
    
    /**
     * Map View to Dto.
     *
     * @param view View
     * @return D dto
     */
    public abstract D toDto(V view);
}