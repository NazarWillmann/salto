package ooo.jtc.dictionaries.bankbic.acc

import ooo.jtc.dictionaries.bankbic.innerenum.IIEnum
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto

enum class BankBicAccAccountTypeIEnum(override val value: String, override val description: String): IIEnum {
    CBRA("CBRA", "Счет Банка России"),
    CRSA("CRSA", "Корреспондентский счет (субсчет)"),
    BANA("BANA", "Банковский счет, не являющийся корреспондентским счетом (субсчетом) или единым казначейским счетом"),
    TRSA("TRSA", "Счет территориального органа Федерального казначейства"),
    TRUA("TRUA", "Счет доверительного управления"),
    CLAC("CLAC", "Клиринговый счет"),
    UTRA("UTRA", "Единый казначейский счет"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}

enum class BankBicAccStatusIEnum(override val value: String, override val description: String): IIEnum {
    ACTIVE("ACAC", "Действующий"),
    DELETED("ACDL", "Удаленный"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}