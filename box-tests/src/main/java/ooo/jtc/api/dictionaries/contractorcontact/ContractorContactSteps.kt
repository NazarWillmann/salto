package ooo.jtc.api.dictionaries.contractorcontact

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class ContractorContactSteps(user: User) :
    AbstractDictionarySteps<ContractorContactDto, ContractorContactDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = ContractorContactDto::class.java,
        dictionaryName = "contractorContact"
    )