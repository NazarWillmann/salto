package ooo.jtc.aspectj

/**
 * Annotation disables logging of step assertThat () to the report
 */
@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class IgnoreHamcrestAllureStep