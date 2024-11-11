package ooo.jtc.testdata.dictionaries.country

import ooo.jtc.api.common.controls.IControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.api.common.controls.MessageType.EMPTY_OR_SPACES
import ooo.jtc.api.common.controls.MessageType.LENGTH_MAX
import ooo.jtc.api.common.controls.MessageType.SYMBOLS_DELETE
import ooo.jtc.api.common.controls.MessageType.NAME_UNIQUE
import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.documents.ControlCheckResult.INVALID
import ooo.jtc.documents.ControlCheckResult.WARNING

//https://confluence.jtc.ooo/pages/viewpage.action?pageId=21731888
enum class CountryControls(
    override val fieldName: String,
    override val messageType: MessageType,
    override val resultStatus: ControlCheckResult,
    override var additionalParams: Map<String, String>? = mapOf(),
    override val controlEntityName: String = "country"
) : IControls {
    SHORT_NAME_NOT_EMPTY("shortName", EMPTY_OR_SPACES, INVALID),
    SHORT_NAME_MAX_LENGTH("shortName", LENGTH_MAX, INVALID),
    SHORT_NAME_AVAILABLE_SYMBOLS("shortName", SYMBOLS_DELETE, WARNING),
    SHORT_NAME_UNIQUE("shortName", NAME_UNIQUE, INVALID),

    FULL_NAME_NOT_EMPTY("fullName", EMPTY_OR_SPACES, INVALID),
    FULL_NAME_MAX_LENGTH("fullName", LENGTH_MAX, INVALID),
    FULL_NAME_AVAILABLE_SYMBOLS("fullName", SYMBOLS_DELETE, WARNING),
    FULL_NAME_UNIQUE("fullName", NAME_UNIQUE, INVALID),

    INT_NAME_NOT_EMPTY("intName", EMPTY_OR_SPACES, INVALID),
    INT_NAME_MAX_LENGTH("intName", LENGTH_MAX, INVALID),
    INT_NAME_AVAILABLE_SYMBOLS("intName", SYMBOLS_DELETE, WARNING),
    INT_NAME_UNIQUE("intName", NAME_UNIQUE, INVALID),

    DIGIT_CODE_NOT_EMPTY("digitCode", EMPTY_OR_SPACES, INVALID),
    DIGIT_CODE_MAX_LENGTH("digitCode", LENGTH_MAX, INVALID),
    DIGIT_CODE_AVAILABLE_SYMBOLS("digitCode", SYMBOLS_DELETE, INVALID),
    DIGIT_CODE_UNIQUE("digitCode", NAME_UNIQUE, INVALID),

    ALPHA_2_CODE_NOT_EMPTY("alpha2Code", EMPTY_OR_SPACES, INVALID),
    ALPHA_2_CODE_MAX_LENGTH("alpha2Code", LENGTH_MAX, INVALID),
    ALPHA_2_CODE_AVAILABLE_SYMBOLS("alpha2Code", SYMBOLS_DELETE, INVALID),
    ALPHA_2_CODE_UNIQUE("alpha2Code", NAME_UNIQUE, INVALID),

    ALPHA_3_CODE_NOT_EMPTY("alpha3Code", EMPTY_OR_SPACES, INVALID),
    ALPHA_3_CODE_MAX_LENGTH("alpha3Code", LENGTH_MAX, INVALID),
    ALPHA_3_CODE_AVAILABLE_SYMBOLS("alpha3Code", SYMBOLS_DELETE, INVALID),
    ALPHA_3_CODE_UNIQUE("alpha3Code", NAME_UNIQUE, INVALID),
    ;
}