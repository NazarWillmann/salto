package ooo.jtc.core.elements

import ooo.jtc.core.container.SContext
import ooo.jtc.extensions.getOrException

interface Row : SContext {
    val id: String get() = getContext().attr("data-id").getOrException("Can't get `data-id` attribute in $sElement ")
}