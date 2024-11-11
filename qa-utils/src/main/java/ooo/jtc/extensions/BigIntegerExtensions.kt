package ooo.jtc.extensions

import java.math.BigInteger

fun BigInteger.toHexString(): String = "%02x".format(this)
