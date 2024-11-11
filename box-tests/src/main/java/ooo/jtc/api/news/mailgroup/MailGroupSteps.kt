package ooo.jtc.api.news.mailgroup

import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.news.mailgroup.MailGroupDto
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User

class MailGroupSteps(bankUser: User = Users.bankOperator) :
    AbstractDictionarySteps<MailGroupDto, MailGroupDto>(
        user = bankUser,
        service = Services.NEWS,
        entity = MailGroupDto::class.java,
        dictionaryName = DictionaryNames.MAIL_GROUP
    ) {
    override val servicePath by lazy { service.baseEndpoint + "/mailgroup/" + user.userType.pathPrefix }

}