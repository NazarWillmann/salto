package ooo.jtc.testdata.dictionaries.stmntoperationtype

import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypePrepareSteps
import ooo.jtc.api.dictionaries.stmntoperationtype.StatementOperationTypeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * StatementOperationTypeData data, that loaded from testDataProvider as [StatementOperationTypeData] in [StatementOperationType] format.
 */
object StatementOperationTypeData : TestData<StatementOperationType>(StatementOperationType::class.java) {
    override var atMarkerPredicate: (StatementOperationType) -> Boolean = { it.description.endsWith(AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.RKO_DICTIONARY.db.execSql("SELECT * FROM statement_ops_type") }
    override val dataFileName = "statementOperationType.json"

    override var createRecord: (() -> StatementOperationType)? = null
        get() = { StatementOperationTypePrepareSteps.createStatementOperationTypeDto().toModel() }

    override var removeRecord: ((StatementOperationType) -> Unit)? = { StatementOperationTypeSteps(Users.superUser).delete(it.id!!) }
}

/**
 * Enum for searching [StatementOperationType] in [StatementOperationTypeData]
 */
enum class FindStatementOperationTypeBy(override var predicate: (StatementOperationType) -> Boolean) :
    FindEntityBy<StatementOperationType, StatementOperationTypeData> {

    AT_CREATED(StatementOperationTypeData.atMarkerPredicate),
    ;
}