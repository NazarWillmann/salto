package ooo.jtc.api.dictionaries.branchcustomer

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.dictionaries.branchcustomer.BranchCustomerDto
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.uaa.User

class BranchCustomerSteps(user: User = superUser) :
    AbstractDictionarySteps<BranchCustomerDto, BranchCustomerDto>(
        user = user,
        entity = BranchCustomerDto::class.java,
        dictionaryName = "branchCustomer"
    )