package ooo.jtc.api.common.controls

import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.generic.CheckResult
import ooo.jtc.generic.ControlResult
import ooo.jtc.generic.GroupResult

interface INestedDictionaryControls : INestedControls {

    override fun prepareNecessaryGroupResult(
        groupCheckResult: ControlCheckResult,
        groupType: GroupType,
        groupNestedResults: List<ControlResult>
    ): GroupResult {
        return GroupResult(
            result = groupCheckResult,
            id = null,
            name = groupType.name,
            controlResults = groupNestedResults
        )
    }

    override fun prepareNecessaryControlResult(
        controlCheckResult: ControlCheckResult,
        controlType: ControlType,
        controlNestedResults: List<CheckResult>
    ): ControlResult {
        return ControlResult(
            result = controlCheckResult,
            id = null,
            message = null,///controlMessage
            level = null,///controlType.severityLevel
            name = controlType.name,
            checkResults = controlNestedResults
        )
    }
}