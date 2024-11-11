package ooo.jtc.generic

import java.math.BigDecimal
import java.math.RoundingMode

private const val DEFAULT_SCALE: Int = 2

val ZERO_AMOUNT by lazy { amount(0.0) }

fun amount(string: String, scale: Int? = DEFAULT_SCALE, roundingMode: RoundingMode = RoundingMode.HALF_UP): BigDecimal {
    return BigDecimal(string).setScale(scale!!, roundingMode)
}

fun amount(double: Double, scale: Int? = DEFAULT_SCALE, roundingMode: RoundingMode = RoundingMode.HALF_UP): BigDecimal {
    return BigDecimal(double).setScale(scale!!, roundingMode)
}

fun amount(long: Long, scale: Int? = DEFAULT_SCALE, roundingMode: RoundingMode = RoundingMode.HALF_UP): BigDecimal {
    return BigDecimal(long).setScale(scale!!, roundingMode)
}

fun amount(bigDecimal: BigDecimal, scale: Int? = DEFAULT_SCALE, roundingMode: RoundingMode = RoundingMode.HALF_UP): BigDecimal {
    return bigDecimal.setScale(scale!!, roundingMode)
}