package ooo.jtc.api.dictionaries.customertype

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.customertype.CustomerTypeDto
import ooo.jtc.uaa.User

class CustomerTypeSteps(user: User) :
    AbstractDictionarySteps<CustomerTypeDto, CustomerTypeDto>(
        user = user,
        entity = CustomerTypeDto::class.java,
        dictionaryName = "customerType"
    )