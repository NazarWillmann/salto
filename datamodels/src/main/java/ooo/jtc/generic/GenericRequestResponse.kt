package ooo.jtc.generic

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import ooo.jtc.documents.ControlCheckResult


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
open class GenericDto<T>(open val data: T?)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
class GenericDtoWrapperDto<T>(val dto: T?)

/**
 * Generic wrapper for Dictionaries requests.
 * [failOnInvalid] - means how service will handle errors:
 * true - response status 500 with system error message
 * false - response 200 with control validationResult (default)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class DictionaryWrapperDto<T>(override var data: T?, var failOnInvalid: Boolean = false) : GenericDto<T>(data)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class DocumentWrapperDto<T>(override var data: T?, var saveInvalidAsDraft: Boolean = true) : GenericDto<T>(data)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenericPageResponseDto<T>(val page: List<T>? = null, val size: Int? = null)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenericListResponseDto<T>(val list: List<T>? = null)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenericBatchResponseDto<T>(
    val list: List<BatchGenericResponseDto<T>>? = null
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenericBatchProcessResponseDto<T>(
    val documentResults: List<BatchGenericResponseDto<T>>? = null
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenericResponseDto<T>(
    override val data: T? = null,
    val validationResult: ValidationResultDto? = null,
    val code: Int? = null,
    val message: String? = null
) : GenericDto<T>(data)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class MetadataResponseDto(val filteringFields: List<String>)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Count(
    val count: Int
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class BatchGenericResponseDto<T>(
    val id: UUID,
    val dto: T? = null,
    val errorCode: Int? = null,
    val error: String? = null
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class EntityAndListResponseDto<E, L>(
    val entity: E,
    val list: List<L>
)

//region control DTOs
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ValidationResultDto(
    val groupResults: List<GroupResult>?,
    val result: ControlCheckResult?,
    val checks: List<CheckResult>?
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GroupResult(
    val controlResults: List<ControlResult>,
    val id: String?,
    val name: String?,
    val result: ControlCheckResult
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class ControlResult(
    val checkResults: List<CheckResult>,
    val id: String?,
    val level: String?,
    val message: String?,
    val name: String?,
    val result: ControlCheckResult
)

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CheckResult(
    val fieldName: String?,
    val message: CheckMessage?,
    val subResults: List<ValidationResultDto>?,
    val result: ControlCheckResult
)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class CheckMessage(
    val message: String,
    val params: Map<String, String>
)
//endregion