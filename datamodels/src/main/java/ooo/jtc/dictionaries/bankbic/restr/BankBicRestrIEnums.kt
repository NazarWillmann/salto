package ooo.jtc.dictionaries.bankbic.restr

import ooo.jtc.dictionaries.bankbic.innerenum.IIEnum
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto

enum class BankBicRestrCodeIEnum(override val value: String, override val description: String): IIEnum {
    URRS("URRS", "Ограничение предоставления сервиса срочного перевода"),
    LWRS("LWRS", "Отзыв (аннулирование) лицензии"),
    MRTR("MRTR", "Мораторий на удовлетворение требований кредиторов"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}