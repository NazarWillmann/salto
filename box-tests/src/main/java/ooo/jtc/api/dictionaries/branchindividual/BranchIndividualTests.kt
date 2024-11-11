package ooo.jtc.api.dictionaries.branchindividual

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.dictionaries.branchindividual.BranchIndividualPrepareSteps.getBranchIndividualDtoForCreate
import ooo.jtc.dictionaries.branchindividual.BranchIndividualDto
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

// TODO Khatmullin [2021.06.07] Tests not implemented cos of changes in nested entity
class BranchIndividualCreateTest(user: User = Users.superUser) :
    CreateTestTemplate<BranchIndividualDto>(
        preExecution = { getBranchIndividualDtoForCreate() },
        steps = BranchIndividualSteps(user)
    )
