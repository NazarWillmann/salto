package ooo.jtc.interfaces;

import java.lang.System;

/**
 * ITransferEntity prepare IEntityDto for transfer by REST
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Looo/jtc/interfaces/ITransferEntity;", "Looo/jtc/interfaces/IEntity;", "toDto", "Looo/jtc/interfaces/IEntityDto;", "datamodels"})
public abstract interface ITransferEntity extends ooo.jtc.interfaces.IEntity {
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.interfaces.IEntityDto toDto();
}