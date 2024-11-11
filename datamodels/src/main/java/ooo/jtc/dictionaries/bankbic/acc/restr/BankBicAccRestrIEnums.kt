package ooo.jtc.dictionaries.bankbic.acc.restr

import ooo.jtc.dictionaries.bankbic.innerenum.IIEnum
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto

enum class BankBicAccRestrCodeIEnum(override val value: String, override val description: String): IIEnum {
    LMRS("LMRS", "Временное сохранение счета с его функционированием в ограниченном режиме"),
    URRS("URRS", "Ограничение предоставления сервиса срочного перевода"),
    CLRS("CLRS", "Закрытие счета"),
    FPRS("FPRS", "Приостановление предоставления сервиса быстрых платежей"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}