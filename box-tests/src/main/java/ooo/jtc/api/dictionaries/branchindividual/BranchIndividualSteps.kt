package ooo.jtc.api.dictionaries.branchindividual

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.branchindividual.BranchIndividualDto
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.uaa.User

class BranchIndividualSteps(user: User = superUser) :
    AbstractDictionarySteps<BranchIndividualDto, BranchIndividualDto>(
        user = user,
        entity = BranchIndividualDto::class.java,
        dictionaryName = "branchIndividual"
    )