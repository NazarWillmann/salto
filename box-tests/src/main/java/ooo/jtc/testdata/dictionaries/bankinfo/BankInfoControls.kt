package ooo.jtc.testdata.dictionaries.bankinfo

import ooo.jtc.api.common.controls.ControlType
import ooo.jtc.api.common.controls.GroupType
import ooo.jtc.api.common.controls.INestedControls
import ooo.jtc.api.common.controls.INestedDictionaryControls
import ooo.jtc.api.common.controls.MessageType
import ooo.jtc.documents.ControlCheckResult

//enum class BankInfoControls(
//    override val resultStatus: ControlCheckResult,
//    override val groupCheckResult: ControlCheckResult = resultStatus,
//    override val groupType: GroupType,
//    override val controlCheckResult: ControlCheckResult = resultStatus,
//    override val controlType: ControlType,
//    override val checkEntityName: String = "bank.field",
//    override val checkFieldName: String,
//    override val checkMessage: MessageType?,
//    override var checkMessageParams: Map<String, String>? = mapOf(),
//    override val checkSubResults: INestedControls? = null
        //) : INestedDictionaryControls {
//    FULL_NAME_EMPTY(
//        resultStatus = ControlCheckResult.INVALID,
//        groupType = GroupType.FULL_NAME,
//        controlType = ControlType.FULL_NAME_NOT_EMPTY,
//        checkFieldName = "fullName",
//        checkMessage = MessageType.EMPTY
//    ),
  //  FULL_NAME_LENGTH(
  //      resultStatus = ControlCheckResult.INVALID,
  //      groupType = GroupType.FULL_NAME,
  //      controlType = ControlType.FULL_NAME_LENGTH,
  //      checkFieldName = "fullName",
  //      checkMessage = MessageType.MAX_LENGTH
  //  ),
  //  FULL_NAME_SYMBOLS(
  //      resultStatus = ControlCheckResult.INVALID,
  //      groupType = GroupType.FULL_NAME,
  //      controlType = ControlType.FULL_NAME_SYMBOLS,
  //      checkFieldName = "fullName",
  //      checkMessage = MessageType.SYMBOLS_DELETE
  //  ),
  //  SHORT_NAME_EMPTY(
  //      resultStatus = ControlCheckResult.INVALID,
  //      groupType = GroupType.SHORT_NAME,
  //      controlType = ControlType.SHORT_NAME_NOT_EMPTY,
  //      checkFieldName = "shortName",
  //      checkMessage = MessageType.EMPTY
  //  ),
  //  SHORT_NAME_LENGTH(
  //      resultStatus = ControlCheckResult.INVALID,
  //      groupType = GroupType.SHORT_NAME,
  //      controlType = ControlType.SHORT_NAME_LENGTH,
  //      checkFieldName = "shortName",
  //      checkMessage = MessageType.MAX_LENGTH
  //  ),
  //  SHORT_NAME_SYMBOLS(
  //      resultStatus = ControlCheckResult.INVALID,
  //      groupType = GroupType.SHORT_NAME,
  //      controlType = ControlType.SHORT_NAME_SYMBOLS,
  //      checkFieldName = "shortName",
  //      checkMessage = MessageType.SYMBOLS_DELETE
  //  ),
  //  LOGO_EMPTY(
  //      resultStatus = ControlCheckResult.INVALID,
  //      groupType = GroupType.LOGO,
  //      controlType = ControlType.LOGO_EMPTY,
  //      checkFieldName = "shortName",
  //      checkMessage = MessageType.SYMBOLS_DELETE
  //  )

