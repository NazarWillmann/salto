package ooo.jtc.api.dictionaries.individual

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.dictionaries.individual.IndividualPrepareSteps.getIndividualDtoForCreate
import ooo.jtc.api.dictionaries.person.PersonSteps
import ooo.jtc.dictionaries.individual.IndividualDto
import ooo.jtc.uaa.User

class IndividualCreateTest(bankCreatorUser: User, individualUser: User) :
    CreateTestTemplate<IndividualDto>(
        preExecution = { getIndividualDtoForCreate(individualUser) },
        steps = IndividualSteps(bankCreatorUser),
        preCheckingHandlingAct = { it.apply { identityDocuments = emptyList() } },
        testPostExecution = {
            IndividualSteps(bankCreatorUser).delete(it.id!!)
            PersonSteps(bankCreatorUser).delete(it.person!!.id!!)
        }
    )

class IndividualDeleteTest(bankCreatorUser: User, individualUser: User) :
    DeleteTestTemplate<IndividualDto>(
        preExecution = {
            val createdResponse = IndividualSteps(bankCreatorUser).create(getIndividualDtoForCreate(individualUser))
            createdResponse.data!!
        },
        steps = IndividualSteps(bankCreatorUser),
        preCheckingHandling = {
            it.apply {
                person = null
                identityDocuments = emptyList()
            }
        },
        postExecution = { PersonSteps(bankCreatorUser).delete(it.person!!.id!!) }
    )

class IndividualUpdateTest(bankCreatorUser: User, individualUser: User) :
    UpdateTestTemplate<IndividualDto, IndividualDto>(
        preExecution = {
            val createdResponse = IndividualSteps(bankCreatorUser).create(getIndividualDtoForCreate(individualUser))
            createdResponse.data!!
        },
        steps = IndividualSteps(bankCreatorUser),
        preCheckingHandling = {
            it.apply {
                identityDocuments = emptyList()
            }
        },
        postExecution = {
            IndividualSteps(bankCreatorUser).delete(it.id!!)
            PersonSteps(bankCreatorUser).delete(it.person!!.id!!)
        }
    )