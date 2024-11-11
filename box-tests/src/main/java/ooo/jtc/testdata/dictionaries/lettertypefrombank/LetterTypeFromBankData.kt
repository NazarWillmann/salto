package ooo.jtc.testdata.dictionaries.lettertypefrombank

import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankPrepareSteps
import ooo.jtc.api.dictionaries.lettertypefrombank.LetterTypeFromBankSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_UNDERSCORE
import ooo.jtc.dictionaries.lettertypefrombank.LetterTypeFromBank
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * LetterTypeFromBank data, that loaded from testDataProvider as [LetterTypeFromBankData] in [LetterTypeFromBank] format.
 */
object LetterTypeFromBankData : TestData<LetterTypeFromBank>(LetterTypeFromBank::class.java) {
    override var atMarkerPredicate: (LetterTypeFromBank) -> Boolean = { it.code.endsWith(AT_POSTFIX_UNDERSCORE) }
    override val dbDataConsumer = { Services.LETTER.db.execSql("SELECT * FROM type_letter_from_bank") }
    override val dataFileName = "typeLetterFromBank.json"

    override var createRecord: (() -> LetterTypeFromBank)? = null
        get() = { LetterTypeFromBankPrepareSteps.createLetterTypeFromBankDto().toModel() }

    override var removeRecord: ((LetterTypeFromBank) -> Unit)? = { LetterTypeFromBankSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [LetterTypeFromBank] in [LetterTypeFromBankData]
 */
enum class FindLetterTypeFromBankBy(override var predicate: (LetterTypeFromBank) -> Boolean) :
    FindEntityBy<LetterTypeFromBank, LetterTypeFromBankData> {

    AT_CREATED(LetterTypeFromBankData.atMarkerPredicate),
    ;
}