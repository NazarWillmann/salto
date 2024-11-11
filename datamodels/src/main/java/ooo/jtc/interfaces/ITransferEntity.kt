package ooo.jtc.interfaces

/**
 * ITransferEntity prepare IEntityDto for transfer by REST
 */
interface ITransferEntity : IEntity {

    fun toDto(): IEntityDto

}