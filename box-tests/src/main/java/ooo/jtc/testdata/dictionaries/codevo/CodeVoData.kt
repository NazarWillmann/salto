package ooo.jtc.testdata.dictionaries.codevo

import ooo.jtc.api.dictionaries.codevo.CodeVoPrepareSteps
import ooo.jtc.api.dictionaries.codevo.CodeVoSteps
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.codevo.CodeVo
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestData

/**
 * CodeVoData data, that loaded from testDataProvider as [CodeVoData] in [CodeVo] format.
 */
object CodeVoData : TestData<CodeVo>(CodeVo::class.java) {
    override var atMarkerPredicate: (CodeVo) -> Boolean = { it.description!!.endsWith(AT_POSTFIX_RUS_PARENTHESES) }
    override val dbDataConsumer = { Services.DICTIONARY.db.execSql("SELECT * FROM code_vo") }
    override val dataFileName = "codeVo.json"

    override var createRecord: (() -> CodeVo)? = null
        get() = {
            val preparedDto = CodeVoPrepareSteps.getCodeVoDtoForCreate()
            CodeVoSteps(Users.bankAdmin).create(preparedDto).data!!.toModel()
        }

    override var removeRecord: ((CodeVo) -> Unit)? = { CodeVoSteps(Users.superUser).delete(it.id!!) }
}


/**
 * Enum for searching [CodeVo] in [CodeVoData]
 */
enum class FindCodeVoBy(override var predicate: (CodeVo) -> Boolean) :
    FindEntityBy<CodeVo, CodeVoData> {

    AT_CREATED(CodeVoData.atMarkerPredicate),
    ;
}
