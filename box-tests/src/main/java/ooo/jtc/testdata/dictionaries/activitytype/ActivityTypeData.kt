package ooo.jtc.testdata.dictionaries.activitytype

import ooo.jtc.api.dictionaries.activitytype.ActivityTypePrepareSteps
import ooo.jtc.api.dictionaries.activitytype.ActivityTypeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.activitytype.ActivityType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * ActivityTypeData data, that loaded from testDataProvider as [ActivityTypeData] in [ActivityType] format.
 */
object ActivityTypeData : TestData<ActivityType>(ActivityType::class.java) {
    override var atMarkerPredicate: (ActivityType) -> Boolean = { it.description.endsWith(AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM activity_type") }
    override val dataFileName = "activityType.json"

    override var createRecord: (() -> ActivityType)? = null
        get() = {
            val preparedDto = ActivityTypePrepareSteps.getActivityTypeDtoForCreate()
            ActivityTypeSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((ActivityType) -> Unit)? = { ActivityTypeSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [ActivityType] in [ActivityTypeData]
 */
enum class FindActivityTypeBy(override var predicate: (ActivityType) -> Boolean) :
    FindEntityBy<ActivityType, ActivityTypeData> {

    AT_CREATED(ActivityTypeData.atMarkerPredicate),
    ;
}
