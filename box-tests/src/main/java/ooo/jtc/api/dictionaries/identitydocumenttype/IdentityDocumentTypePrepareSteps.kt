package ooo.jtc.api.dictionaries.identitydocumenttype

import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentType
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto
import ooo.jtc.dictionaries.identitydocumenttype.UsageLimit
import ooo.jtc.random.RandomData.Companion.ruWords
import ooo.jtc.testdata.dictionaries.identitydocumenttype.IdentityDocumentTypeData
import java.util.UUID.randomUUID
import kotlin.random.Random

object IdentityDocumentTypePrepareSteps {

    val availableTypeCodes by lazy {
        IdentityDocumentTypeData.generateUniqueValues(consume = { it.typeCode }, generate = { (1..99).random().toString() })
    }

    fun getIdentityDocTypeDtoForInsert() = IdentityDocumentType(
        id = randomUUID(),
        version = 1,
        name = ruWords.random(length = 60, prefix = AT_PREFIX_RUS),
        systemName = ruWords.random(length = 60),
        usageLimit = UsageLimit.values().random(),
        typeCode = availableTypeCodes.remove(),
        isHidden = Random.nextBoolean(), // на текущий момент фильтрация по isHidden на BE не реализована
        createdAt = null,
        deletedAt = null
    )

    fun getIdentityDocTypeDtoForUpdate(createdDto: IdentityDocumentTypeDto): IdentityDocumentTypeDto {
        return IdentityDocumentTypeDto(
            id = createdDto.id,
            name = ruWords.random(length = 60, prefix = AT_PREFIX_RUS),
            isHidden = !createdDto.isHidden,
            version = createdDto.version
        )
    }

}