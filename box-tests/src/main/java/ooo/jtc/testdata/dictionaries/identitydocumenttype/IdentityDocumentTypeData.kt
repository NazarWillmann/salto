package ooo.jtc.testdata.dictionaries.identitydocumenttype

import ooo.jtc.api.dictionaries.identitydocumenttype.IdentityDocumentTypePrepareSteps
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

/**
 * IdentityDocumentTypeData data, that loaded from testDataProvider as [IdentityDocumentTypeData] in [IdentityDocumentType] format.
 */
object IdentityDocumentTypeData : TestData<IdentityDocumentType>(IdentityDocumentType::class.java) {
    override var atMarkerPredicate: (IdentityDocumentType) -> Boolean = { it.name.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM identity_doc_type") }
    override val dataFileName = "identityDocumentType.json"

    override var createRecord: (() -> IdentityDocumentType)? = null
        get() = {
            val insertedEntity = IdentityDocumentTypePrepareSteps.getIdentityDocTypeDtoForInsert()
            Services.DICTIONARY.db.execute(
                """INSERT INTO identity_doc_type 
                    |        (id, name, system_name, created_at, deleted_at, version, type_code, usage_limit, is_hidden) 
                    |    VALUES ('${insertedEntity.id}', '${insertedEntity.name}', '${insertedEntity.systemName}', 
                    |        TIMESTAMP '2019-01-01 00:00:00', NULL, ${insertedEntity.version}, ${insertedEntity.typeCode}, 
                    |        '${insertedEntity.usageLimit}', ${insertedEntity.isHidden});""".trimMargin()
            )
            insertedEntity
        }

    override var removeRecord: ((IdentityDocumentType) -> Unit)? = { removeEntity ->
        Services.DICTIONARY.db.execute(
            """DELETE FROM identity_doc_type
            |    WHERE id = '${removeEntity.id}';""".trimMargin()
        )
    }
}