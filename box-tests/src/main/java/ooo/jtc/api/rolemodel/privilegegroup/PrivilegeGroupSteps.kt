package ooo.jtc.api.rolemodel.privilegegroup

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

class PrivilegeGroupSteps(user: User = Users.systemSecurityAdmin) :
    AbstractDictionarySteps<PrivilegeGroupDto, PrivilegeGroupDto>(
        user = user,
        entity = PrivilegeGroupDto::class.java,
        service = Services.DOMAIN_CONTROLLER,
        dictionaryName = "privilegeGroup"
    )