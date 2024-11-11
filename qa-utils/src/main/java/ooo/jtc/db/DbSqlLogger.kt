package ooo.jtc.db

import io.qameta.allure.Allure
import ooo.jtc.logging.LoggerDelegate
import org.jdbi.v3.core.statement.SqlLogger
import org.jdbi.v3.core.statement.StatementContext

class DbSqlLogger : SqlLogger {
    private val log by LoggerDelegate()

    override fun logBeforeExecution(context: StatementContext) {
        Allure.step("Выполнение запроса к БД") { ->
            log.info("SQL Request: ${context.renderedSql}")
            Allure.addAttachment("SQL Request", context.renderedSql)
        }
    }
}