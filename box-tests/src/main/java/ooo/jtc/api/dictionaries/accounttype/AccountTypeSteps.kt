package ooo.jtc.api.dictionaries.accounttype

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.accountype.AccountTypeDto
import ooo.jtc.uaa.User

class AccountTypeSteps(user: User) :
    AbstractDictionarySteps<AccountTypeDto, AccountTypeDto>(
        user = user,
        entity = AccountTypeDto::class.java,
        dictionaryName = "accountType"
    )