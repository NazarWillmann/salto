package ooo.jtc.dictionaries.bankbic

import ooo.jtc.dictionaries.bankbic.innerenum.BankBicAllowedServicesIEnumDto
import ooo.jtc.dictionaries.bankbic.innerenum.IIEnum
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto

enum class BankBicStatusesIEnum(override val value: String, override val description: String): IIEnum {
    ACTIVE("PSAC", "Действующий"),
    DELETED("PSDL", "Удаленный"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}

enum class BankBicParticipantTransferTypeIEnum(override val value: String, override val description: String): IIEnum {
    PTT_00 ("00", "Главное управление Банка России"),
    PTT_10 ("10", "Расчетно-кассовый центр"),
    PTT_12 ("12", "Отделение, отделение-национальный банк главного управления Банка России"),
    PTT_15 ("15", "Структурное подразделение центрального аппарата Банка России"),
    PTT_16 ("16", "Кассовый центр"),
    PTT_20 ("20", "Кредитная организация"),
    PTT_30 ("30", "Филиал кредитной организации"),
    PTT_40 ("40", "Полевое учреждение Банка России"),
    PTT_51 ("51", "Федеральное казначейство"),
    PTT_52 ("52", "Территориальный орган Федерального казначейства"),
    PTT_60 ("60", "Иностранный банк (иностранная кредитная организация)"),
    PTT_65 ("65", "Иностранный центральный (национальный) банк"),
    PTT_71 ("71", "Клиент кредитной организации, являющийся косвенным участником"),
    PTT_75 ("75", "Клиринговая организация"),
    PTT_78 ("78", "Внешняя платежная система"),
    PTT_90 ("90", "Конкурсный управляющий (ликвидатор, ликвидационная комиссия)"),
    PTT_99 ("99", "Клиент Банка России, не являющийся участником платежной системы"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}

enum class BankBicParticipantTypeIEnum(override val value: String, override val description: String): IIEnum {
    NON_PARTICIPANT("0", "Не участник обмена"),
    PARTICIPANT("1", "Участник обмена"),
    ;

    override fun toDto() = ValDescIEnumDto(value, description)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}

enum class BankBicAllowedServicesIEnum(
    override val value: String, override val description: String,
    val normalPays: Boolean = false, val urgentPays: Boolean = false, val quickPays: Boolean = false
): IIEnum {
    SERVICE_001("1", "Сервис несрочного перевода", normalPays = true),
    SERVICE_010("2", "Сервис срочного перевода", urgentPays = true),
    SERVICE_011("3", "Сервис несрочного перевода и срочного перевода", normalPays = true, urgentPays = true),
    SERVICE_100("4", "Сервис быстрых платежей", quickPays = true),
    SERVICE_111(
        "5", "Сервис срочного перевода, сервис несрочного перевода и сервис быстрых платежей",
        normalPays = true, urgentPays = true, quickPays = true
    ),
    SERVICE_110("6", "Сервис срочного перевода и сервис быстрых платежей", urgentPays = true, quickPays = true),
    SERVICE_101("7", "Сервис несрочного перевода и сервис быстрых платежей", normalPays = true, quickPays = true),
    ;

    override fun toDto() = BankBicAllowedServicesIEnumDto(value, description, normalPays, urgentPays, quickPays)

    companion object {
        fun ofStr(string: String) = values().first { it.value == string }.toDto()
    }
}