package ooo.jtc.generic.print

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.extensions.getOrException

/**
 * Relation between a status [T] and a stamp result [stampResult] at print form.
 */
interface StampResult<out T : IDocumentStatus<*>> {
    val stampResult: String
    val statuses: List<T>
}

inline fun <reified S : IDocumentStatus<*>, reified T : StampResult<*>> Array<T>.getStampResult(status: S): String =
    this.find { it.statuses.contains(status) }.getOrException("Status '$status' not found in $this").stampResult