package ooo.jtc.curtransfer.model

enum class CurTrUrgencyType(val value: String) {
    NORMAL("Normal"),
    URGENT("Urgent"),
    ;
}

enum class CurTrRateType(val value: String) {
    BANK_RATE("BankRate"),
    USER_RATE("UserRate"),
    ;
}

enum class CurTrChargeType {
    OUR,
    BEN, //beneficiary
    SHA, //shared
    ;
}