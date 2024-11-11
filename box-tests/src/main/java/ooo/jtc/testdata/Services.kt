@file:Suppress("UNCHECKED_CAST")

package ooo.jtc.testdata

import ooo.jtc.core.ServiceInfo
import ooo.jtc.core.applicationProperties
import ooo.jtc.db.DbConnectionInfo
import ooo.jtc.db.DbExecutorJdbi
import ooo.jtc.db.DbSchema

/**
 * Service information, created from service info [ServiceInfo] and [DbSchema]
 */
class Service(serviceInfo: ServiceInfo, var dbSchema: DbSchema) {

    var baseEndpoint: String = serviceInfo.baseEndpoint.orEmpty()

    var port: Int = serviceInfo.port

    val db by lazy { dbSchema.getDbConnect() }
}

/**
 * Object storing services
 */
object Services {

    val CRYPTO: Service = Service(applicationProperties.services.crypto, DbSchemas.CRYPTO)
    val CUR_RKO: Service = Service(applicationProperties.services.curRko, DbSchemas.CUR_RKO)
    val DICTIONARY: Service = Service(applicationProperties.services.dictionary, DbSchemas.DICTIONARY)
    val DOMAIN_CONTROLLER: Service = Service(applicationProperties.services.domainController, DbSchemas.SECURITY)
    val FS_SYSTEM: Service = Service(applicationProperties.services.fsSystem, DbSchemas.FS_SYSTEM)
    val LETTER: Service = Service(applicationProperties.services.letter, DbSchemas.LETTER)
    val NEWS: Service = Service(applicationProperties.services.news, DbSchemas.NEWS)
    val OAUTH: Service = Service(applicationProperties.services.oauth, DbSchemas.UAA)
    val RKO_DICTIONARY: Service = Service(applicationProperties.services.rkoDictionary, DbSchemas.RU_RKO)
    val RKO_RU_PAYMENT: Service = Service(applicationProperties.services.rkoRupayment, DbSchemas.RU_RKO)
    val RKO_STATEMENT: Service = Service(applicationProperties.services.rkoStatement, DbSchemas.RU_RKO)
    val SALARY: Service = Service(applicationProperties.services.salary, DbSchemas.SALARY)
    val SIGN: Service = Service(applicationProperties.services.sign, DbSchemas.SIGN)
    val UAA: Service = Service(applicationProperties.services.uaa, DbSchemas.UAA)
    val UAA_MANAGEMENT: Service = Service(applicationProperties.services.uaaManagement, DbSchemas.UAA)
}

enum class DbSchemas(override val dbSchemaName: String) : DbSchema {
    ACC_RSRV("salto_account_reservation_dev"),
    CRYPTO("salto_crypto_dev"),
    CUR_RKO("salto_currko_dev"),
    DICTIONARY("salto_dictionary_dev"),
    FS_SYSTEM("salto_fs_dev"),
    GATEWAY("salto_gateway_dev"),
    LETTER("salto_letter_dev"),
    NEWS("salto_news_dev"),
    PAY_CONTROL("salto_pay_control_dev"),
    RU_RKO("salto_rurko_dev"),
    SALARY("salto_salary_dev"),
    SECURITY("salto_security_dev"),
    SIGN("salto_sign_dev"),
    SKELETON("salto_skeleton_dev"),
    SMS_CONFIRM("salto_sms_confirm_dev"),
    TASK("salto_task_dev"),
    UAA("salto_uaa_dev"),
    ;
}


fun DbSchema.getDbConnect() : DbExecutorJdbi = DbExecutorJdbi(
    this, DbConnectionInfo(
        host = applicationProperties.db.host,
        port = applicationProperties.db.port,
        user = applicationProperties.db.user,
        password = applicationProperties.db.password
    )
)