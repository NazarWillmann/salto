package ooo.jtc.testdata.dictionaries.swift

import ooo.jtc.core.TestConstants
import ooo.jtc.dictionaries.swift.Swift
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * Russian Federation Region data, that loaded from testDataProvider as [SwiftData] in [Swift] format.
 */
object SwiftData : TestData<Swift>(Swift::class.java) {
    override var atMarkerPredicate: (Swift) -> Boolean = { it.name.endsWith(TestConstants.AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM swift") }
    override val dataFileName = "swift.json"

    override var createRecord: (() -> Swift)? = null
        get() = { throw RuntimeException("SWIFT dictionary' contents can be changed only through import!") }

    override var removeRecord: ((Swift) -> Unit)? = null
        get() = { throw RuntimeException("SWIFT dictionary' contents can be changed only through import!") }
}

/**
 * Enum for searching [Swift] in [SwiftData]
 */
enum class FindSwiftBy(override var predicate: (Swift) -> Boolean) :
    FindEntityBy<Swift, SwiftData> {

    AT_CREATED(SwiftData.atMarkerPredicate),
    ;
}
