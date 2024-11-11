package ooo.jtc.api.common.controls

import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.generic.CheckMessage
import ooo.jtc.generic.CheckResult
import ooo.jtc.generic.ControlResult
import ooo.jtc.generic.GroupResult
import ooo.jtc.generic.ValidationResultDto

interface INestedControls : IControls {
    //region Declaration
    /**
     * Expected [ValidationResultDto] 'result'
     */
    override val resultStatus: ControlCheckResult

    /**
     * Expected [GroupResult] 'result'
     */
    val groupCheckResult: ControlCheckResult

    /**
     * Expected [GroupResult] type
     * It's used to locate [GroupResult] for test by 'id'
     */
    val groupType: GroupType

    /**
     * Expected [ControlCheckResult] 'result'
     * It's partially used for overall validation
     */
    val controlCheckResult: ControlCheckResult

    /**
     * Expected [ControlCheckResult] type
     * It's used to locate [ControlCheckResult] for test by 'id'.
     * Also it may be used for regulating expected [controlCheckResult] and, (!)MAYBE(!), [groupCheckResult] and [resultStatus] (validation result)
     */
    val controlType: ControlType

    /**
     * Supplementary field.
     * It's used in computing expected [additionalParams]'s "fieldName"
     */
    val checkEntityName: String

    /**
     * Expected [CheckResult] 'fieldName'
     * It's used for validation
     */
    val checkFieldName: String?

    /**
     * Expected [CheckResult] 'message' string
     * It's used to locate [CheckResult] for test
     */
    val checkMessage: MessageType?

    /**
     * Expected [CheckResult] 'subResults' list; [null] by default
     * It's used in cases of nested entities check
     */
    val checkSubResults: INestedControls?

    //region hiding overrides; TODO Sergeyev [2021.03.29]: improve
    override var fieldName: String?
        get() = checkFieldName
        set(value) {} //do nothing
    override val controlEntityName: String
        get() = checkEntityName
    override val messageType: MessageType
        get() = checkMessage ?: MessageType.STUB
    //endregion
    //endregion

    //region Utility methods
    fun getInfoForChecks(): ValidationResultDto {
        val preparedCheckResult = prepareNecessaryCheckResult(
            this.checkFieldName,
            this.checkMessage,
            this.checkSubResults
        )
        val preparedControlCheckResult = prepareNecessaryControlResult(
            this.controlCheckResult,
            this.controlType,
            listOf(preparedCheckResult)
        )
        val preparedGroupResult = prepareNecessaryGroupResult(
            this.groupCheckResult,
            this.groupType,
            listOf(preparedControlCheckResult)
        )

        return ValidationResultDto(
            result = this.resultStatus,
            groupResults = listOf(preparedGroupResult),
            checks = null
        )
    }

    fun prepareNecessaryGroupResult(
        groupCheckResult: ControlCheckResult,
        groupType: GroupType,

        groupNestedResults: List<ControlResult>
    ): GroupResult {
        return GroupResult(
            result = groupCheckResult,
            id = groupType.id,
            name = groupType.cname,
            controlResults = groupNestedResults
        )
    }

    fun prepareNecessaryControlResult(
        controlCheckResult: ControlCheckResult,
        controlType: ControlType,
        //controlMessage: MessageType,

        controlNestedResults: List<CheckResult>
    ): ControlResult {
        //TODO? Sergeyev [2021.03.27]: check message and level (should - yes; need - ?)

        return ControlResult(
            result = controlCheckResult,
            id = controlType.id,
            message = null,///controlMessage
            level = null,///controlType.severityLevel
            name = null,
            checkResults = controlNestedResults
        )
    }

    private fun prepareNecessaryCheckResult(
        checkFieldName: String?,
        checkMessage: MessageType?,
        checkSubResults: INestedControls? = null
    ): CheckResult {
        val preparedCheckMessage = checkMessage?.let {
            val params = if (checkFieldName == null || checkEntityName.isBlank())
                mutableMapOf()
            else
                mutableMapOf("fieldName" to getEntityFieldName())
            additionalParams?.let { params.putAll(additionalParams!!) }

            CheckMessage(checkMessage.message, params)
        }
        val preparedSubResult = checkSubResults?.let { listOf(it.getInfoForChecks()) }

        /* Sergeyev [2021.03.29]:
         * A single check may result only in two options: VALID/INVALID.
         * As we check only failed checks, there should always be an INVALID result */
        return CheckResult(
            result = ControlCheckResult.INVALID,
            fieldName = checkFieldName,
            message = preparedCheckMessage,
            subResults = preparedSubResult
        )
    }

    private fun getEntityFieldName(): String = "[[${checkEntityName}.$checkFieldName]]"
    //endregion
}