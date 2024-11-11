package ooo.jtc.api.common.steps

import ooo.jtc.uaa.User


/**
 * Abstract steps. All implementations must have user as [User] for executing REST queries
 */
abstract class AbstractSteps(var user: User)