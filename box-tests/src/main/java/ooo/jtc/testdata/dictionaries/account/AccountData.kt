package ooo.jtc.testdata.dictionaries.account

import ooo.jtc.api.dictionaries.account.AccountPrepareSteps
import ooo.jtc.api.dictionaries.account.AccountSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.currency.DefaultCurrency
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.generic.ZERO_AMOUNT
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT
import ooo.jtc.testdata.common.all
import ooo.jtc.testdata.dictionaries.accounttype.AccountTypeData
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData
import ooo.jtc.testdata.dictionaries.branchindividal.BranchIndividualData
import ooo.jtc.uaa.User

/**
 * Account data, that loaded from testDataProvider as [AccountData] in [Account] format.
 */
object AccountData : TestDataAT<Account>(Account::class.java) {
    override var atMarkerPredicate: (Account) -> Boolean = { it.name?.endsWith(AT_POSTFIX) ?: false }
    override val dataFileName = "account.json"
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM account") }

    override var removeRecord: ((Account) -> Unit)? = { AccountPrepareSteps.deleteUnusedAccount(it.id!!) }

    private val branchCustomer by lazy { BranchCustomerData.get() }
    private val branchIndividual by lazy { BranchIndividualData.get() }
    private val accountType by lazy { AccountTypeData.get() }
    private val accountExtId by lazy { AccountExtIdData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbAccountMap ->
            dbAccountMap.apply {
                if (null != dbAccountMap["id_branch_customer"]) {
                    val brCust = branchCustomer.first { it.id!! == dbAccountMap["id_branch_customer"] }
                    dbAccountMap["branchId"] = brCust.branchId.toString()
                    dbAccountMap["customerId"] = brCust.customerId.toString()
                } else if (null != dbAccountMap["id_branch_individual"]) {
                    val brInd = branchIndividual.first { it.id!! == dbAccountMap["id_branch_individual"] }
                    dbAccountMap["branchId"] = brInd.branchId.toString()
                    dbAccountMap["individualId"] = brInd.individualId.toString()
                }

                dbAccountMap["accountType"] = accountType
                    .first { it.id!! == dbAccountMap["id_account_type"] }
                dbAccountMap["extIds"] = accountExtId
                    .filter { it.ownerId == dbAccountMap["id"] }
            }
        }

    fun searchBy(accountNumber: String): Account {
        return get { it.accountNumber == accountNumber }.first()
    }

    fun searchBy(customer: Customer): List<Account> {
        val branchCustomers = BranchCustomerData.get { customer.id == it.customerId }
        return AccountData.get { account -> branchCustomers.map { it.id }.contains(account.branchCustomerId) }
    }

    fun searchBy(user: User): List<Account> {
        val availableBrCustIds = BranchCustomerData.searchBy(user).map { it.id!! }
        return AccountData.get { it.branchCustomerId in availableBrCustIds }
    }

    fun getOrCreateForRuPayment(
        user: User,
        customer: Customer,
        isResident: Boolean = true,
        additionalFilter: (Account) -> Boolean = { true }
    ): Account =
        getOrCreate(
            consumer = {
                searchBy(customer)
                    .filter { it.isResident == isResident }
                    .filter(additionalFilter)
                    .filter { FindAccountBy.RUPAYMENT_VALID.predicate(it) }
            },
            provider = {
                val prepareDto = AccountPrepareSteps.getRuPaymentValidAccountDto(user = user, customerId = customer.id!!)
                AccountSteps(Users.superUser).create(prepareDto)
                prepareDto.toModel()
            })
}

/**
 * Enum for searching [Account] in [AccountData]
 */
enum class FindAccountBy(override var predicate: (Account) -> Boolean) :
    FindEntityBy<Account, AccountData> {

    AT_CREATED(AccountData.atMarkerPredicate),

    NOT_BLOCKED({ !it.isBlock }),
    NOT_INFO({ !it.isMarkInfo }),
    RUR_ACC({ it.currencyDigitCode == DefaultCurrency.RUR.digitCode }),
    KIND_PASSIVE({ it.accountKind == AccountKind.PASSIVE }),
    STATE_OPEN({ it.state == AccountState.OPEN }),
    //TODO Sergeyev [2021.02.02]: this
    //TYPE_CURRENT({ it.accountType?.systemName == AccountTypeTag.CURRENT }),
    ACTUAL_BALANCE_POSITIVE({ acc -> acc.actualBalance.let { ZERO_AMOUNT < it } }),

    RUPAYMENT_VALID(
        listOf(
            NOT_BLOCKED, NOT_INFO, RUR_ACC, KIND_PASSIVE, STATE_OPEN, ACTUAL_BALANCE_POSITIVE//, TYPE_CURRENT
        ).all()
    ),
    ;
}

/**
 * AccountActivePassive for account.
 * Признак счета.
 *
 * @author Aleksandr_Stykalin
 */
object AccountKind {
    const val PASSIVE = "passive"
    const val ACTIVE = "active"
}

object AccountState {
    const val OPEN = "open"
    const val CLOSE = "close"
    const val RESERVE = "reserve"
}

/**
 * http://www.garant.ru/products/ipo/prime/doc/70103380/
 */
enum class BalanceAccount(
    val value: String,
    val description: String,
    val accountKind: String
) {
    N_30232("30232", "Незавершенные расчеты с операторами услуг платежной инфраструктуры", AccountKind.PASSIVE),
    N_40101(
        "40101",
        "Доходы, распределяемые органами Федерального казначейства между бюджетами бюджетной системы Российской Федерации",
        AccountKind.PASSIVE
    ),
    N_40701("40701", "Финансовые организации", AccountKind.PASSIVE),
    N_40702("40702", "Коммерческие организации", AccountKind.PASSIVE),
    N_40703("40703", "Некоммерческие организации", AccountKind.PASSIVE),
    N_40802("40802", "Физические лица - индивидуальные предприниматели", AccountKind.PASSIVE),
    N_40807("40807", "Юридические лица - нерезиденты", AccountKind.PASSIVE),
    N_40817("40817", "Физические лица", AccountKind.PASSIVE),
    N_42101("42101", "Депозиты негосударственных коммерческих организаций: до востребования", AccountKind.ACTIVE),
    N_42102("42102", "Депозиты негосударственных коммерческих организаций: на срок до 30 дней", AccountKind.ACTIVE),
    N_42201("42201", "Депозиты негосударственных некоммерческих организаций: до востребования", AccountKind.ACTIVE),
    ;

    /**
     * Checks if provided [accountNumber] is of this [BalanceAccount] type
     */
    fun isAccountBelong(accountNumber: String?): Boolean {
        return accountNumber?.let { accNum ->
            accNum.take(5) == this.value
        } ?: false
    }
}

fun List<BalanceAccount>.checkAccountAnyOf(accountNumber: String?): Boolean =
    this.any { it.isAccountBelong(accountNumber) }

/**
 * https://ru.wikipedia.org/wiki/Корреспондентский_счёт
 * https://1fin.ru/?id=281&t=1602
 */
enum class CorrAccount(val value: String, val description: String) {
    N_30101("30101", "корреспондентский счёт банка"),// на основе данных в БД
    NOSTRO("30110", "Счет банка-респондента, открытый в банке-корреспонденте (наш счёт в их банке)"),
    LORO("30109", "Счет, открываемый банком-корреспондентом банку-респонденту (их счёт в нашем банке)"),
    ;
}

