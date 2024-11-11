package ooo.jtc.api.common.steps

import ooo.jtc.core.api.CoreApi
import ooo.jtc.core.applicationProperties
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.testdata.Service
import ooo.jtc.uaa.User

/**
 * Steps for REST API executing.
 * [service] Service information
 *
 */
abstract class AbstractApiSteps(user: User, var service: Service) : AbstractSteps(user) {

    /**
     * Base service endpoint
     */
    protected open val servicePath: String by lazy { service.baseEndpoint + "/" + user.userType.pathPrefix }

    /**
     * Object for executing REST queries by authorized user
     */
    val authorizedApi: CoreApi
        get() = CoreApi(applicationProperties.server.api.host, service.port, reAuthorize = reAuthorize)
            .withDomain(user.domain)
            .withBearerAuth(user.bearer!!)
            .withLanguage(applicationProperties.i18nLocale)

    /**
     * Object for executing REST queries by unAuthorized user
     */
    val unAuthorizedApi
        get() = CoreApi(applicationProperties.server.api.host, service.port)
            .withLanguage(applicationProperties.i18nLocale)

    /**
     * Object for executing upload REST queries by authorized user
     */
    val uploadApi: CoreApi
        get() = CoreApi(
            applicationProperties.server.api.host,
            service.port,
            contentType = null,
            contentTypeStr = "multipart/form-data",
            reAuthorize = { user.invokeAuth(newToken = true) }
        )
            .withDomain(user.domain)
            .withBearerAuth(user.bearer!!)
            .withLanguage(applicationProperties.i18nLocale)

    private val reAuthorize = {
        user.bearer = null
        user.invokeAuth()
    }
}