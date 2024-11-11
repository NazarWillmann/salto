package ooo.jtc.testdata.dictionaries.lettertypetobank

import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankPrepareSteps
import ooo.jtc.api.dictionaries.lettertypetobank.LetterTypeToBankSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_UNDERSCORE
import ooo.jtc.dictionaries.lettertypetobank.LetterTypeToBank
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * LetterTypeToBank data, that loaded from testDataProvider as [LetterTypeToBankData] in [LetterTypeToBank] format.
 */
object LetterTypeToBankData : TestData<LetterTypeToBank>(LetterTypeToBank::class.java) {
    override var atMarkerPredicate: (LetterTypeToBank) -> Boolean = { it.code.endsWith(AT_POSTFIX_UNDERSCORE) }
    override val dbDataConsumer = { Services.LETTER.db.execSql("SELECT * FROM type_letter_to_bank") }
    override val dataFileName = "typeLetterToBank.json"

    override var createRecord: (() -> LetterTypeToBank)? = null
        get() = { LetterTypeToBankPrepareSteps.createLetterTypeToBankDto().toModel() }

    override var removeRecord: ((LetterTypeToBank) -> Unit)? = { LetterTypeToBankSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [LetterTypeToBank] in [LetterTypeToBankData]
 */
enum class FindLetterTypeToBankBy(override var predicate: (LetterTypeToBank) -> Boolean) :
    FindEntityBy<LetterTypeToBank, LetterTypeToBankData> {

    AT_CREATED(LetterTypeToBankData.atMarkerPredicate),
    ;
}