package ooo.jtc.annotations

import ooo.jtc.interfaces.IEntity

/**
 * Marker annotation for not required fields of [IEntity] in tests.
 */

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class NotRequiredForTest