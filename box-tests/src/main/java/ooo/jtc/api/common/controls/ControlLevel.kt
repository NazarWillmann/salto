package ooo.jtc.api.common.controls

enum class ControlLevel(val value: String) {
    CRITICAL("Critical"),
    OFF("Off"),
    WARNING("Warning");

    companion object {
        fun findByValue(value: String): ControlLevel {
            return valueOf(value.toUpperCase())
        }
    }


}