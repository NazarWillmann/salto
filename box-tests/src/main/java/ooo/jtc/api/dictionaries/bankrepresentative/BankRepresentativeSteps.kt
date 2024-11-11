package ooo.jtc.api.dictionaries.bankrepresentative

import ooo.jtc.api.common.steps.AbstractBlockableDictionarySteps
import ooo.jtc.dictionaries.bankrepresentative.BankRepresentativeDto
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.uaa.User

class BankRepresentativeSteps(user: User = superUser) :
    AbstractBlockableDictionarySteps<BankRepresentativeDto, BankRepresentativeDto>(
        user = user,
        entity = BankRepresentativeDto::class.java,
        dictionaryName = "bankRepresentative"
    )