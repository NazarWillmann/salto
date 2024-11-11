package ooo.jtc.api.dictionaries.residencypermitdocumenttype

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentType
import ooo.jtc.random.RandomData
import java.util.*

object ResidencyPermitDocumentTypePrepareSteps {

    fun getResidencyPermitDocumentTypeForInsert(): ResidencyPermitDocumentType {
        return ResidencyPermitDocumentType(
            id = UUID.randomUUID(),
            name = generateWithPrefix(),
            systemName = generateWithPrefix()
        )
    }

    val allowedChars by lazy {
        RandomData.builder()
            .withRussianAlphabet()
            .withDigits()
            .build()
    }

    private fun generateWithPrefix(): String {
        return allowedChars.random(length = 60, prefix = AT_PREFIX_RUS)
    }
}