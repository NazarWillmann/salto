package ooo.jtc.api.dictionaries.branch

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.branch.BranchDto
import ooo.jtc.uaa.User

class BranchSteps(user: User) :
        AbstractDictionarySteps<BranchDto, BranchDto>(
            user = user,
            entity = BranchDto::class.java,
            dictionaryName = "branch"
        )