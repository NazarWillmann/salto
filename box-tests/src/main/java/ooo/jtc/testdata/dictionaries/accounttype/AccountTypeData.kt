package ooo.jtc.testdata.dictionaries.accounttype

import ooo.jtc.api.dictionaries.accounttype.AccountTypePrepareSteps.createAccountTypeDto
import ooo.jtc.api.dictionaries.accounttype.AccountTypeSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.accountype.AccountType
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * AccountType data, that loaded from testDataProvider as [AccountTypeData] in [AccountType] format.
 */
object AccountTypeData : TestData<AccountType>(AccountType::class.java) {
    override var atMarkerPredicate: (AccountType) -> Boolean = { it.systemName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM account_type") }
    override val dataFileName = "accountType.json"

    override var createRecord: (() -> AccountType)? = { createAccountTypeDto().toModel() }

    override var removeRecord: ((AccountType) -> Unit)? = { AccountTypeSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [AccountType] in [AccountTypeData]
 */
enum class FindAccountTypeBy(override var predicate: (AccountType) -> Boolean) : FindEntityBy<AccountType, AccountTypeData> {

    AT_CREATED(AccountTypeData.atMarkerPredicate),

    //TODO Sergeyev [2021.02.02]: !!!incorrect!!!
    CURRENT({ "current" == it.systemName }),
    DEPOSIT({ "deposit" == it.systemName }),
    LOAN({ "loan" == it.systemName })
}

/**
 * AccountTypeTag for account type.
 * Тип счёта.
 */
object AccountTypeTag {
    const val CURRENT = "current"
    const val DEPOSIT = "deposit"
    const val LOAN = "loan"
}