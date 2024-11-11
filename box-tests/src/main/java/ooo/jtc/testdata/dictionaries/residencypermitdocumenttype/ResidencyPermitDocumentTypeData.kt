package ooo.jtc.testdata.dictionaries.residencypermitdocumenttype

import ooo.jtc.api.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypePrepareSteps.getResidencyPermitDocumentTypeForInsert
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData

object ResidencyPermitDocumentTypeData : TestData<ResidencyPermitDocumentType>(ResidencyPermitDocumentType::class.java) {
    override var atMarkerPredicate: (ResidencyPermitDocumentType) -> Boolean = { it.name.startsWith(AT_PREFIX_RUS) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM residency_permit_document_type") }
    override val dataFileName: String = "residencyPermitDocumentType.json"

    override var createRecord: (() -> ResidencyPermitDocumentType)? = null
        get() = {
            val insertedEntity = getResidencyPermitDocumentTypeForInsert()
            insertedEntity.version = 1
            Services.DICTIONARY.db.execute(
                """INSERT INTO residency_permit_document_type 
                    |        (id, name, system_name, created_at, deleted_at, version) 
                    |    VALUES ('${insertedEntity.id}', '${insertedEntity.name}', '${insertedEntity.systemName}', 
                    |        NULL, NULL, ${insertedEntity.version});""".trimMargin()
            )
            insertedEntity
        }

    override var removeRecord: ((ResidencyPermitDocumentType) -> Unit)? = { removeEntity ->
        Services.DICTIONARY.db.execute(
            """DELETE FROM residency_permit_document_type
            |    WHERE id = '${removeEntity.id}';""".trimMargin()
        )
    }
}