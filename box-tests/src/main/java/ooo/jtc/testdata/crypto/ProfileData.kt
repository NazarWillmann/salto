package ooo.jtc.testdata.crypto

import ooo.jtc.crypto.Profile
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestData
import ooo.jtc.uaa.User

/**
 * Profile data, that loaded from testDataProvider as [ProfileData] in [Profile] format.
 */
object ProfileData : TestData<Profile>(Profile::class.java) {
    // Sergeyev [2020.08.29]: sensitive data! No profiles should be deleted by autotests; only manually
    override var atMarkerPredicate: (Profile) -> Boolean = { false }
    override val dbDataConsumer = { Services.CRYPTO.db.execSql("SELECT * FROM crypto_profile") }
    override val dataFileName = "profile.json"

    override var createRecord: (() -> Profile)? = null
        get() = throw RuntimeException("This is sensitive data and should be handled manually!")

    override var removeRecord: ((Profile) -> Unit)? = null
        get() = throw RuntimeException("This is sensitive data and should be handled manually!")

    fun searchBy(user: User): Profile {
        return get { user.uaaUserId == it.userId }.ifEmpty {
            throw RuntimeException("No profile found for user '${user.uaaUserId}'")
        }.first()
    }
}
