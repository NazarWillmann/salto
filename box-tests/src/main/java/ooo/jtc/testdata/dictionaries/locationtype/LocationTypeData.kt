package ooo.jtc.testdata.dictionaries.locationtype

import ooo.jtc.api.dictionaries.locationtype.LocationTypePrepareSteps
import ooo.jtc.api.dictionaries.locationtype.LocationTypeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.locationtype.LocationType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * LocationType data, that loaded from testDataProvider as [LocationTypeData] in [LocationType] format.
 */
object LocationTypeData : TestData<LocationType>(LocationType::class.java) {
    override var atMarkerPredicate: (LocationType) -> Boolean = { it.name.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM location_type") }
    override val dataFileName = "locationType.json"

    override var createRecord: (() -> LocationType)? = null
        get() = { LocationTypePrepareSteps.createLocationTypeDto().toModel() }

    override var removeRecord: ((LocationType) -> Unit)? = { LocationTypeSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [LocationType] in [LocationTypeData]
 */
enum class FindLocationTypeBy(override var predicate: (LocationType) -> Boolean) :
    FindEntityBy<LocationType, LocationTypeData> {

    AT_CREATED(LocationTypeData.atMarkerPredicate),
    ;
}
