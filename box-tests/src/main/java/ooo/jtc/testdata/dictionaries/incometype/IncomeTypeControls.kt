package ooo.jtc.testdata.dictionaries.incometype

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.ControlType.UNKNOWN
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.GroupType.MAIN
import ooo.jtc.api.common.controls.IControls.Companion.getForbiddenSymbolsMessage
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.random.RandomData

val invalidName = RandomData.builder()
    .withLatinAlphabet()
    .withDigits()
    .build()
    .random(minLength = 10, maxLength = 60 - AT_PREFIX_RUS.length)
private val invalidNameMessage = getForbiddenSymbolsMessage(invalidName)

val invalidDescription = RandomData.builder()
    .withLatinAlphabet()
    .withDigits()
    .build()
    .random(minLength = 10, maxLength = 255 - AT_PREFIX_RUS.length)
private val invalidDescriptionMessage = getForbiddenSymbolsMessage(invalidDescription)

enum class IncomeTypeControls(
    override val resultStatus: ControlCheckResult = INVALID,
    override val groupCheckResult: ControlCheckResult = resultStatus,
    override val groupType: GroupType = MAIN,
    override val controlCheckResult: ControlCheckResult = resultStatus,
    override val controlType: ControlType = UNKNOWN,
    override val checkEntityName: String = "income.type",
    override val checkFieldName: String,
    override val checkMessage: MessageType?,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val checkSubResults: INestedControls? = null
) : INestedControls {

    CODE_VALUE_RANGE(
        checkFieldName = "code",
        checkMessage = MessageType.OUT_OF_RANGE,
        additionalParams = mapOf(
            "start" to "1",
            "end" to "9",
        )
    ),
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
    DESCRIPTION_NOT_EMPTY(
        checkFieldName = "description",
        checkMessage = MessageType.EMPTY
    ),
    DESCRIPTION_MAX_LENGTH(
        checkFieldName = "description",
        checkMessage = MessageType.LENGTH_MAX,
        additionalParams = mapOf(
            "length" to "255"
        )
    ),
    DESCRIPTION_ALLOWED_SYMBOLS(
        checkFieldName = "description",
        checkMessage = MessageType.SYMBOLS_DELETE,
        additionalParams = mapOf(
            "symbols" to invalidDescriptionMessage
        )
    )
}