package ooo.jtc.interfaces

import com.fasterxml.jackson.annotation.JsonIgnore
import ooo.jtc.annotations.EntityName

interface IEntityDto : Identifiable {

    @JsonIgnore
    fun getEntityName(): String {
        val annotation = this.javaClass.annotations.find { it.annotationClass == EntityName::class }
        return if (annotation != null) (annotation as EntityName).name else javaClass.simpleName
    }

    @JsonIgnore
    fun toModel(): ITransferEntity {
        throw RuntimeException("Mapping from ${this::class.simpleName} to related Entity not supported")
    }
}

/**
 * Interface-marker.
 * Mark Dto which uses for update [T] Dto.
 */
interface UpdateIEntityDto<T : IEntityDto> : IEntityDto

inline fun <reified T : IEntityDto> T?.getOrException(message: String = "Entity '${this?.getEntityName() ?: T::class.java.simpleName}' not created"): T {
    return this ?: throw RuntimeException(message)
}
