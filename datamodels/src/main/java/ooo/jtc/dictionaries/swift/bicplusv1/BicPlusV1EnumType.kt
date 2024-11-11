package ooo.jtc.dictionaries.swift.bicplusv1

enum class BicPlusEventType(val value: String) {
    BIC_ISSUED("BIC ISSUED"),
    BIC_EXPIRED("BIC EXPIRED"),
    BIC_CONNECTIVITY_CHANGED("BIC CONNECTIVITY CHANGED"),
    BIC_SUSPENDED("BIC SUSPENDED"),
    BIC_LEGAL_NAME_CHANGED("BIC LEGAL NAME CHANGED"),
    BIC_INSTITUTION_NAME_CHANGED("BIC INSTITUTION NAME CHANGED"),
    BIC_ADDRESS_CHANGED("BIC ADDRESS CHANGED"),
    FIN_SERVICE_CODE_CHANGED("FIN SERVICE CODE CHANGED"),
    ;

    companion object {
        fun ofString(string: String): BicPlusEventType =
            values().first { it.value == string }
    }
}

enum class BicPlusEntityType(val value: String) {
    LEGAL_ENTITY("Legal Entity"),
    BRANCH("Branch"),
    OPERATIONAL("Operational"),
    ;
}

enum class BicPlusModificationFlagType {
    A, // (add)
    M, // (modify)
    D, // (delete)
    ;
}

enum class BicPlusYesNoType(val bool: Boolean) {
    Y(true), // yes
    N(false), // no
    ;
}
