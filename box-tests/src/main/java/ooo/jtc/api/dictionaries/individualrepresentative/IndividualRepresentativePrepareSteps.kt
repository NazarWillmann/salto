package ooo.jtc.api.dictionaries.individualrepresentative

import ooo.jtc.api.dictionaries.individual.IndividualSteps
import ooo.jtc.core.TestConstants
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.common.BlockingInfoDto
import ooo.jtc.dictionaries.individualrepresentative.IndividualRepresentativeDto
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.testdata.dictionaries.individual.IndividualData
import ooo.jtc.uaa.User
import java.util.*

object IndividualRepresentativePrepareSteps {

    fun getIndividualRepresentativeDtoForCreate(
        individualUser: User = Users.individual
    ): IndividualRepresentativeDto {
        individualUser.checkIsClientUser()
        val individualDto = IndividualData.getOrCreate(individualUser).toDto()
        val randomAvailableIndividualId = IndividualSteps(superUser).create(individualDto).data!!.id!!
        return getIndividualRepresentativeDtoForCreate(individualUser.uaaUserId!!, randomAvailableIndividualId)
    }

    fun getIndividualRepresentativeDtoForCreate(uaaUserId: UUID, individualId: UUID, forUi: Boolean = true): IndividualRepresentativeDto {
        val descNumber = digits.random(10, 10)
        return IndividualRepresentativeDto(
            id = null,
            version = 0,
            individualId = individualId,
            userId = uaaUserId,
            block = BlockingInfoDto(isBlock = false),
            description = "desc$descNumber${TestConstants.AT_POSTFIX}"
        )
    }
}