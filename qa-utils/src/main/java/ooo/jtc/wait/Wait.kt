package ooo.jtc.wait

import java.time.temporal.ChronoUnit

class Wait {

    companion object {

        const val DEFAULT_POLLING_RATE = 1L
        const val DEFAULT_TIMEOUT = 60L
        val DEFAULT_TEMPORAL_UNITS = ChronoUnit.SECONDS

        fun until(
            supplier: () -> Boolean,
            pollingRate: Long? = null,
            timeout: Long? = null,
            chronoUnits: ChronoUnit? = null
        ) {
            forCondition(supplier, condition = { it == true }, pollingRate, timeout, chronoUnits)
        }

        fun <T : Any> forResult(
            supplier: () -> T?,
            pollingRate: Long? = null,
            timeout: Long? = null,
            chronoUnits: ChronoUnit? = null
        ): T {
            return forCondition(supplier, condition = { it != null }, pollingRate, timeout, chronoUnits)
        }

        private fun <T : Any> forCondition(
            supplier: () -> T?,
            condition: (T?) -> Boolean,
            pollingRate: Long? = null,
            timeout: Long? = null,
            chronoUnits: ChronoUnit? = null
        ): T {
            val chronoUnitCoefficient = (chronoUnits?.duration?.toMillis() ?: DEFAULT_TEMPORAL_UNITS.duration.toMillis())
            val pollingRateMs = (pollingRate ?: DEFAULT_POLLING_RATE) * chronoUnitCoefficient
            val timeoutMs = (timeout ?: DEFAULT_TIMEOUT) * chronoUnitCoefficient
            val endTimeMs = System.currentTimeMillis() + timeoutMs
            var suppliedValue = supplier.invoke()
            var conditionMet = condition.invoke(suppliedValue)
            while (!conditionMet && System.currentTimeMillis() < endTimeMs) {
                if (pollingRateMs > 0) Thread.sleep(pollingRateMs)
                suppliedValue = supplier.invoke()
                conditionMet = condition.invoke(suppliedValue)
            }
            return if (conditionMet && suppliedValue != null)
                suppliedValue
            else
                throw RuntimeException("Ожидаемое условие не было выполнено в пределах ${(timeoutMs / 1000).toInt()} секунд(ы).")
        }
    }
}