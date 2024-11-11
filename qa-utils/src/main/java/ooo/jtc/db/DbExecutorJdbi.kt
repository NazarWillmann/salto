package ooo.jtc.db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin
import org.jdbi.v3.core.mapper.RowMapper
import java.sql.SQLException
import javax.sql.DataSource

class DbExecutorJdbi(private val dbSchema: DbSchema, private val dbConnectionInfo: DbConnectionInfo) {
    private val dbType = "postgresql"

    val jdbi: Jdbi by lazy {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:$dbType://${dbConnectionInfo.host}:${dbConnectionInfo.port}/${dbSchema.dbSchemaName}"
        config.username = dbConnectionInfo.user
        config.password = dbConnectionInfo.password
        config.maximumPoolSize = 1

        val dataSource: DataSource = HikariDataSource(config)
        val jdbiConnection = Jdbi.create(dataSource)
        jdbiConnection.installPlugin(KotlinPlugin())
        jdbiConnection.setSqlLogger(DbSqlLogger())
        jdbiConnection
    }


    fun execSql(sql: String): List<MutableMap<String, Any>> {
        return jdbi.withHandle<List<MutableMap<String, Any>>, SQLException> { it.createQuery(sql).mapToMap().list() }
    }

    fun execute(sql: String) {
        jdbi.useHandle<Exception> { it.execute(sql) }
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Any?> select(
        table: String, fields: String = "*", where: String = "",
        extracting: List<MutableMap<String, Any>>.() -> T = {
            val list = mutableListOf<MutableMap<String, Any>>()
            list.addAll(this)
            this as T
        }
    ): T {

        //todo таблицы можно вынести enum и сделать префиксом после RUPAYMENT.db.table.rupayment.select()
        val condition: String = if (where.isNotBlank()) "WHERE $where" else ""

        val sql = "SELECT $fields from $table $condition".trim()
        return execSql(sql).extracting()
    }

    fun <T : Any> selectFirst(sql: String, modelClass: Class<T>): T {
        return jdbi.withHandle<List<T>, SQLException> { it.createQuery(sql).mapTo(modelClass).toList() }[0]
    }

    fun <T : Any> execSql(sql: String, modelClass: Class<T>): List<T> {
        return jdbi.withHandle<List<T>, SQLException> { it.createQuery(sql).mapTo(modelClass).toList() }
    }

    fun <T : Any> execSql(sql: String, modelClass: Class<T>, mapper: RowMapper<T>): List<T> {
        return jdbi
            .registerRowMapper(mapper)
            .withHandle<List<T>, SQLException> { it.createQuery(sql).mapTo(modelClass).toList() }
    }

    fun <T : Any?> execSql(sql: String, extracting: List<MutableMap<String, Any>>.() -> T): T {
        return execSql(sql).extracting()
    }
}