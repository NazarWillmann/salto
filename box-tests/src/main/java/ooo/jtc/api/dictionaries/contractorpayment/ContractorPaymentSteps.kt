package ooo.jtc.api.dictionaries.contractorpayment

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentUpdateRequest
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User

class ContractorPaymentSteps(user: User) :
    AbstractDictionarySteps<ContractorPaymentDto, ContractorPaymentUpdateRequest>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = ContractorPaymentDto::class.java,
        dictionaryName = "contractorPayment"
    )