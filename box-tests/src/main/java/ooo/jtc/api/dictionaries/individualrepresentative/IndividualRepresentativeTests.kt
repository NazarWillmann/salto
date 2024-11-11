package ooo.jtc.api.dictionaries.individualrepresentative

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.dictionaries.individual.IndividualSteps
import ooo.jtc.api.dictionaries.individualrepresentative.IndividualRepresentativePrepareSteps.getIndividualRepresentativeDtoForCreate
import ooo.jtc.api.dictionaries.person.PersonSteps
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.dictionaries.individualrepresentative.IndividualRepresentativeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.Users.superUser
import ooo.jtc.testdata.dictionaries.individual.IndividualData
import ooo.jtc.testdata.dictionaries.person.PersonData
import ooo.jtc.uaa.User

private const val baseFolder = "${FolderPrefix.DICTIONARY} \"${DictionaryNames.INDIVIDUAL_REPRESENTATIVE}\" (individualRepresentative)"


// TODO Khatmullin [2021.06.07] Tests not implemented cos of changes in nested entity
class IndividualRepresentativeCreateTest(
    createEntityForUser: User
) : CreateTestTemplate<IndividualRepresentativeDto>(
    steps = IndividualRepresentativeSteps(),
    preExecution = {
        val newIndividual = IndividualData.getOrCreate(createEntityForUser, createEntityForUser)
        getIndividualRepresentativeDtoForCreate(
            uaaUserId = createEntityForUser.uaaUserId!!,
            individualId = newIndividual.id!!
        )
    },
    postExecution = {
        IndividualRepresentativeSteps().delete(it.id!!)
    },
    testPostExecution = {
        PersonSteps().delete(PersonData.searchBy(Users.individual).first().id!!)
        IndividualSteps(superUser).delete(it.individualId)
    }
)