package ooo.jtc.testdata.dictionaries.timezone

import ooo.jtc.api.dictionaries.timezone.TimezonePrepareSteps
import ooo.jtc.api.dictionaries.timezone.TimezoneSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.timezone.Timezone
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * TimezoneData data, that loaded from testDataProvider as [TimezoneData] in [Timezone] format.
 */
object TimezoneData : TestData<Timezone>(Timezone::class.java) {
    override var atMarkerPredicate: (Timezone) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM time_zone") }
    override val dataFileName = "timeZone.json"

    override var createRecord: (() -> Timezone)? = null
        get() = { TimezonePrepareSteps.createTimezoneDto().toModel() }

    override var removeRecord: ((Timezone) -> Unit)? = { TimezoneSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [Timezone] in [TimezoneData]
 */
enum class FindTimezoneBy(override var predicate: (Timezone) -> Boolean) :
    FindEntityBy<Timezone, TimezoneData> {

    AT_CREATED(TimezoneData.atMarkerPredicate),
    ;
}