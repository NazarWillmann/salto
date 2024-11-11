package ooo.jtc.api.dictionaries.residencypermitdocumenttype

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentType
import ooo.jtc.dictionaries.residencypermitdocumenttype.ResidencyPermitDocumentTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class ResidencyPermitDocumentTypeSteps(user: User) :
    AbstractDictionarySteps<ResidencyPermitDocumentTypeDto, ResidencyPermitDocumentTypeDto>(
        user = user,
        service = Services.DICTIONARY,
        entity = ResidencyPermitDocumentTypeDto::class.java,
        dictionaryName = "residencyPermitDocumentType"
    ) {

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.RESIDENCY_PERMIT_DOCUMENT_TYPE}'")
        fun checkDefaultEntity(actualEntity: ResidencyPermitDocumentType, expectedEntity: ResidencyPermitDocumentType) {
            Checks.checkFieldValue("Наименование", actualEntity.name, expectedEntity.name)
            Checks.checkFieldValue("Системное наименование", actualEntity.systemName, expectedEntity.systemName)
        }
    }
}