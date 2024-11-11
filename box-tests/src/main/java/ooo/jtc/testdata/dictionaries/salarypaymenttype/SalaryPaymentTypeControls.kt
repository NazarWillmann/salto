package ooo.jtc.testdata.dictionaries.salarypaymenttype

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.IControls.Companion.getForbiddenSymbolsMessage
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.random.RandomData

val invalidCode = RandomData.builder()
    .withLatinAlphabet()
    .withSpecialCharacters()
    .withRussianAlphabet()
    .build()
    .random(minLength = 1, maxLength = 2)
val invalidCodeMessage = getForbiddenSymbolsMessage(invalidCode)

val invalidName = RandomData.builder()
    .withLatinAlphabet()
    .withDigits()
    .build()
    .random(minLength = 10, maxLength = 60 - AT_PREFIX_RUS.length)
val invalidNameMessage = getForbiddenSymbolsMessage(invalidName)

enum class SalaryPaymentTypeControls(
    override val resultStatus: ControlCheckResult = ControlCheckResult.INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType = GroupType.MAIN,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType = ControlType.UNKNOWN,
    override val checkEntityName: String = "payment.type",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    NAME_NOT_EMPTY(
        checkFieldName = "name",
        checkMessage = MessageType.EMPTY
    ),
    NAME_MAX_LENGTH(
        checkFieldName = "name",
        checkMessage = MessageType.LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "60"
        )
    ),
    NAME_ALLOWED_SYMBOLS(
        checkFieldName = "name",
        checkMessage = MessageType.SYMBOLS_DELETE,
        additionalParams = mapOf(
            "symbols" to invalidNameMessage
        )
    ),
    INCOME_TYPE_CODE_VALUE_RANGE(
        checkFieldName = "incomeTypeCode",
        checkMessage = MessageType.OUT_OF_RANGE,
        additionalParams = mapOf(
            "start" to "1",
            "end" to "9",
        )
    ),
    CODE_NOT_EMPTY(
        checkFieldName = "code",
        checkMessage = MessageType.EMPTY
    ),
    CODE_MAX_LENGTH(
        checkFieldName = "code",
        checkMessage = MessageType.LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "2"
        )
    ),
    CODE_ALLOWED_SYMBOLS(
        checkFieldName = "code",
        checkMessage = MessageType.SYMBOLS_DELETE,
        additionalParams = mapOf(
            "symbols" to invalidCodeMessage
        )
    )
}