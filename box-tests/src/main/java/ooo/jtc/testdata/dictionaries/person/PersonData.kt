package ooo.jtc.testdata.dictionaries.person

import io.qameta.allure.Step
import ooo.jtc.api.dictionaries.person.PersonPrepareSteps.getPersonDtoForCreate
import ooo.jtc.api.dictionaries.person.PersonSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.person.Person
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.uaa.User

object PersonData : TestDataAT<Person>(Person::class.java) {
    override var atMarkerPredicate: (Person) -> Boolean = { it.lastName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM person") }
    override val dataFileName: String = "person.json"

    fun searchBy(user: User): List<Person> =
        get { it.id == user.uaaUserId }

    @Step("Найти или создать запись ${DictionaryNames.PERSON}")
    fun getOrCreate(
        personUser: User,
    ): Person {
        //TODO Sergeyev [2021.08.27]: create persons only by user creation
        //this will be deleted
        return getOrCreate(
            { searchBy(personUser) },
            { PersonSteps(Users.superUser).create(getPersonDtoForCreate(personUser)).data!!.toModel() }
        )
    }
}