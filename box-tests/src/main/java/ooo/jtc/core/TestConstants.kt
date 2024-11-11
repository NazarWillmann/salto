package ooo.jtc.core

import ooo.jtc.text.TextUtils
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.util.UUID

/**
 * Regexp constants for [com.mifmif.common.regex.Generex]
 */
object RegexpConst {
    const val LAT_RUS_NUM = "[\\x20-\\x7Eа-яА-Я]*№" //символы с кодами 32-126, А-Я, а-я, №
    const val UPPER_LAT = "[A-Z]*"
    const val UPPER_LAT_NUM_UND = "[0-9A-Z_]*"
    const val UPPER_LAT_NUM_SPC = "[0-9A-Z ]*"
    const val UI_EVENT_TIME_REGEX = "(сегодня|вчера|\\d{2}.\\d{2}.\\d{4}) в \\d{2}:\\d{2}"
}

object TestConstants {
    const val AT = "AT"
    const val AT_RUS = "АТ"
    const val AT_PREFIX = "AT "
    const val AT_PREFIX_RUS = "АТ "
    const val AT_POSTFIX = " AT"
    const val AT_POSTFIX_UNDERSCORE = "_AT"
    const val AT_POSTFIX_RUS = " АТ"
    const val AT_POSTFIX_RUS_PARENTHESES = " (Ат)"
    const val LT = "_LT"
    const val AT_NUM = "00047"
    const val AT_PERCENTAGE = 91.0

    const val PARAM_USER = "Пользователь"
    const val PARAM_OBJECT_TYPE = "Тип объекта"

    const val AT_USERS_FILE_PATH = "/AT_Users.json"
    const val SMS_CODE_FOR_SIGN_DOCUMENTS = "0000"
    const val REPEAT_LIMIT_SEC = 65L
    const val REPEAT_DELAY_MS = 750L
    const val CONTROL_INVALID_CHARS_REQUEST = "☺ゑї"
    const val CONTROL_INVALID_CHARS_EXPECT = "☺;ゑ;ї"
    const val SORT_CONTROL_IGNORE = "■☺☻♣◘•○"
    const val ACCEPTABLE_TIME_LAG_SECONDS = 10L
    const val DOC_DATE_ACCEPTABLE_PAST_DAYS = 10L
    const val DOC_DATE_ACCEPTABLE_FUTURE_DAYS = 0L
    val TECH_USER_ID: UUID = UUID.fromString("ec52e666-a046-4053-8af2-63b07a974dd3")
    val NON_EXISTENT_ID: UUID = UUID.fromString("00000000-0000-0000-0000-000000000000")
    val MIN_ZONED_DATE: ZonedDateTime = ZonedDateTime.of(LocalDateTime.MIN, ZoneId.of("Z"))

    const val PRE_EXECUTION_ERROR_MSG = "Ошибка при подготовке данных для предусловия"
    val documentWordFormFunc: (Int) -> String = { TextUtils.declensionByDigit(it, "документ", "документа", "документов") }
    val documentWordFormGenitiveFunc: (Int) -> String = { if (it == 1) "документа" else "документов" }
}

object ServiceErrors {
    const val DESERIALIZE_ERROR = "Error in deserialize of operation request for operation %s: DecodingFailure at %s:"
    const val PSQL_EXCEPTION = "org.postgresql.util.PSQLException: ERROR: "
    const val VARCHAR_VALUE_TOO_LONG = "value too long for type character varying(%d)"
    const val UNIQUE_CONSTRAINT_VIOLATION = "duplicate key value violates unique constraint \"%s\""
}

object TestTemplateConstants {
    const val PARAM_CUSTOMER_ID = "ID клиента (customer_id)"
    const val PARAM_DOC_VIEW = "Document view"
    const val PARAM_OBJECT = "Данные для проверки"
}

object DocumentConstants {
    const val ERROR_MSG_SENDING_TO_BANK = "Ошибка при отправке в Банк"
    const val ERROR_MSG_BANK_GET_BY_ID = "Ошибка при получении документа на стороне Банка"
    const val ERROR_MSG_CLIENT_GET_BY_ID = "Ошибка при получении документа на стороне Клиента"
    const val ERROR_MSG_DOC_IS_NOT_SIGNED = "Документ не был подписан"
}

object LetterToBankLifecycleConstants {
    const val AT_RECALL_MSG = "AT-recalled"
    const val AT_PROCESS_MSG = "AT-processed"
    const val DEFAULT_RECALL_MSG = "Документ отозван. Обработка документа прекращена"
    const val DEFAULT_PROCESS_MSG = "Документ обработан в банке"

    const val RECEIVE_TICKET_SUCCESS_MSG = "Документ успешно прошел проверки подписи (подписей) и корректности" +
            " заполнения реквизитов документа. Документ принят в обработку в банке"
    const val RECEIVE_TICKET_FAILURE_DETAILS_MSG =
        "Документ не прошел проверку корректности заполнения реквизитов документа при приеме в банке. В приеме документа в обработку отказано"
    const val RECEIVE_TICKET_FAILURE_ESIGN_MSG =
        "Документ не прошел проверку подписи (подписей) под документом при приеме в банке. В приеме документа в обработку отказано"
    const val EXECUTION_TICKET_SUCCESS_MSG = DEFAULT_PROCESS_MSG
}

object LetterFromBankLifecycleConstants {
    const val RECEIVE_TICKET_SUCCESS_MSG =
        "Документ успешно прошел проверки подписей и корректности заполнения реквизитов. Документ отправлен Клиенту"
    const val RECEIVE_TICKET_FAILURE_DETAILS_MSG =
        "Документ не прошел проверку корректности заполнения реквизитов документа при отправке Клиенту. Отправка документа прекращена"
    const val RECEIVE_TICKET_FAILURE_ESIGN_MSG =
        "Документ не прошел проверку подписей под документом при отправке Клиенту. Отправка документа прекращена"
}