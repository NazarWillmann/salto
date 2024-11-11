package ooo.jtc.dictionaries.bankbic.innerenum

import com.github.pozo.KotlinBuilder

/**
 * Interface InnerEnum
 * Enums, that implement this interface, are stored withing product code and no accessible by any means
 */
interface IIEnum {
    val value: String
    val description: String

    fun toDto(): IIEnumDto
}

interface IIEnumDto {
    var value: String
    var description: String
}

@KotlinBuilder
data class ValDescIEnumDto(
    override var value: String,
    override var description: String
) : IIEnumDto

@KotlinBuilder
data class BankBicAllowedServicesIEnumDto(
    override var value: String,
    override var description: String,
    var normalPays: Boolean,
    var urgentPays: Boolean,
    var quickPays: Boolean
) : IIEnumDto
