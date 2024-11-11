package ooo.jtc.testdata.dictionaries.codevo

import ooo.jtc.api.common.controls.IControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.documents.ControlCheckResult

//https://confluence.jtc.ooo/pages/viewpage.action?pageId=12919256
enum class CodeVoControls(
    override val fieldName: String,
    override val messageType: MessageType,
    override val resultStatus: ControlCheckResult,
    override var additionalParams: Map<String, String>? = mapOf()
) : IControls {
    CODE_EMPTY("code", MessageType.EMPTY_OR_SPACES, ControlCheckResult.INVALID),
    CODE_MAX_LENGTH("code", MessageType.LENGTH_MAX, ControlCheckResult.INVALID),
    CODE_AVAILABLE_SYMBOLS("code", MessageType.SYMBOLS_DELETE, ControlCheckResult.INVALID),
    DESCRIPTION_EMPTY("description", MessageType.EMPTY_OR_SPACES, ControlCheckResult.INVALID),
    ;

    override val controlEntityName = "codeVo"
}