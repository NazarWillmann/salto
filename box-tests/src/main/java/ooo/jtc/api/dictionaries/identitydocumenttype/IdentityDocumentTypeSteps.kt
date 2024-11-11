package ooo.jtc.api.dictionaries.identitydocumenttype

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentType
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.uaa.User

class IdentityDocumentTypeSteps(user: User) :
    AbstractDictionarySteps<IdentityDocumentTypeDto, IdentityDocumentTypeDto>(
        user = user,
        entity = IdentityDocumentTypeDto::class.java,
        dictionaryName = "identityDocumentType"
    ) {
    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.IDENTITY_DOC_TYPE}'")
        fun checkDefaultEntity(actualEntity: IdentityDocumentType, expectedEntity: IdentityDocumentType) {
            Checks.checkFieldValue("Наименование", actualEntity.name, expectedEntity.name)
            Checks.checkFieldValue("Системное наименование", actualEntity.systemName, expectedEntity.systemName)
            Checks.checkFieldValue("Ограничение использования", actualEntity.usageLimit, expectedEntity.usageLimit)
            Checks.checkFieldValue("Код вида документа", actualEntity.typeCode, expectedEntity.typeCode)
            Checks.checkFieldValue("Признак скрытой записи", actualEntity.isHidden, expectedEntity.isHidden)
        }
    }
}