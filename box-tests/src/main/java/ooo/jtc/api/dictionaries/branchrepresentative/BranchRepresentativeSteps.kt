package ooo.jtc.api.dictionaries.branchrepresentative

import ooo.jtc.api.common.steps.AbstractBlockableDictionarySteps
import ooo.jtc.dictionaries.branchrepresentative.BranchRepresentativeDto
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.uaa.User

class BranchRepresentativeSteps(user: User = superUser) :
    AbstractBlockableDictionarySteps<BranchRepresentativeDto, BranchRepresentativeDto>(
        user = user,
        entity = BranchRepresentativeDto::class.java,
        dictionaryName = "branchRepresentative"
    )