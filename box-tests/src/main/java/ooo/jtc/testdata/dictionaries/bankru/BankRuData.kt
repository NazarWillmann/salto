package ooo.jtc.testdata.dictionaries.bankru

import ooo.jtc.api.dictionaries.bankru.BankRuPrepareSteps
import ooo.jtc.api.dictionaries.bankru.BankRuSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.bankru.BankRu
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeData
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeData
import ooo.jtc.testdata.dictionaries.uer.UerData

/**
 * BankRu data, that loaded from testDataProvider as [BankRuData] in [BankRu] format.
 */
object BankRuData : TestData<BankRu>(BankRu::class.java) {
    override var atMarkerPredicate: (BankRu) -> Boolean = { it.bankName.endsWith(AT_POSTFIX) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM bank_ru") }
    override val dataFileName = "bankRu.json"

    override var createRecord: (() -> BankRu)? = null
        get() = {
            val preparedDto = BankRuPrepareSteps.getValidBankRuDtoForCreate()
            val createdDto = BankRuSteps(Users.bankAdmin).create(preparedDto).data!!
            val fullCreatedDto = BankRuSteps(Users.bankAdmin).getById(createdDto.id!!).data!!
            fullCreatedDto.toModel()
        }

    override var removeRecord: ((BankRu) -> Unit)? = { BankRuSteps(Users.superUser).delete(it.id!!) }

    private val locationType by lazy { LocationTypeData.get() }
    private val controlCode by lazy { ControlCodeData.get() }
    private val uer by lazy { UerData.get() }

    override val dbResultPostProcessor: (MutableMap<String, Any>) -> MutableMap<String, Any> =
        { dbBankRuMap ->
            dbBankRuMap.apply {
                if (null != dbBankRuMap["id_location_type"])
                    dbBankRuMap["locationType"] = locationType
                        .first { it.id!! == dbBankRuMap["id_location_type"] }
                if (null != dbBankRuMap["id_control_code"])
                    dbBankRuMap["controlCode"] = controlCode
                        .first { it.id!! == dbBankRuMap["id_control_code"] }

                dbBankRuMap["uer"] = uer
                    .first { it.id!! == dbBankRuMap["id_uer"] }
            }
        }

    fun searchBy(bic: String): BankRu {
        return get { it.bic == bic }.ifEmpty { throw RuntimeException("No bank found for bic: $bic") }.first()
    }
}


/**
 * Enum for searching [BankRu] in [BankRuData]
 */
enum class FindBankRuBy(override var predicate: (BankRu) -> Boolean) :
    FindEntityBy<BankRu, BankRuData> {

    AT_CREATED(BankRuData.atMarkerPredicate),
    RKC({ it.isRkc }),
    NON_RKC({ !it.isRkc }),
    ;
}
