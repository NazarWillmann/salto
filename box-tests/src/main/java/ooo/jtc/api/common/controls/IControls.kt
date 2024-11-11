package ooo.jtc.api.common.controls

import ooo.jtc.documents.ControlCheckResult
import ooo.jtc.generic.CheckMessage
import ooo.jtc.generic.CheckResult

interface IControls {

    val fieldName: String?
    val messageType: MessageType
    val resultStatus: ControlCheckResult
    val controlEntityName: String
    var additionalParams: Map<String, String>?

    companion object {

        fun getForbiddenSymbolsMessage(forbiddenSymbols: String, exclusions: String? = null): String {
            return forbiddenSymbols.asSequence()
                .distinct()
                .filter { if (exclusions == null) true else !exclusions.contains(it) }
                .joinToString(";")
        }
    }

    fun getFieldEntity(): String = "[[${controlEntityName}.$fieldName]]"

    fun withParams(additionalParams: Map<String, String>): IControls {
        this.additionalParams = additionalParams
        return this
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : IControls> withParams(vararg additionalParams: Pair<String, String>): T {
        this.additionalParams = mapOf(*additionalParams)
        return this as T
    }

    fun getCheckResult(): CheckResult {
        val fieldEntity = getFieldEntity()
        return prepareCheckResult(
            fieldName, messageType, fieldEntity, resultStatus, additionalParams = additionalParams ?: mapOf()
        )
    }

    /**
     * Utility function for prepare [CheckResult].
     */
    private fun prepareCheckResult(
        fieldName: String?,
        messageType: MessageType,
        fieldEntity: String,
        resultStatus: ControlCheckResult,
        additionalParams: Map<String, String>
    ): CheckResult {
        val params = mutableMapOf("fieldName" to fieldEntity)
        params.putAll(additionalParams)
        return CheckResult(
            fieldName,
            CheckMessage(messageType.message, params),
            subResults = null,
            resultStatus
        )
    }
}