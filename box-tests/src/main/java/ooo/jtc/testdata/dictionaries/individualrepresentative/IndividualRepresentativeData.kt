package ooo.jtc.testdata.dictionaries.individualrepresentative

import ooo.jtc.core.TestConstants
import ooo.jtc.core.kexensions.checkIsClientUser
import ooo.jtc.dictionaries.individualrepresentative.IndividualRepresentative
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.uaa.User

object IndividualRepresentativeData : TestDataAT<IndividualRepresentative>(IndividualRepresentative::class.java) {
    override var atMarkerPredicate: (IndividualRepresentative) -> Boolean = { it.description?.endsWith(TestConstants.AT_POSTFIX) ?: false }

    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM individual_representative") }
    override val dataFileName: String = "individualRepresentative.json"

    fun searchBy(user: User): List<IndividualRepresentative> {
        user.checkIsClientUser()
        return get { user.uaaUserId!! == it.userId }
    }

}