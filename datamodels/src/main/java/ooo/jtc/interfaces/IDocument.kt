package ooo.jtc.interfaces

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.OperandType
import ooo.jtc.generic.pageparams.Predicate
import java.time.LocalDate
import java.util.*

interface IDocument : IEntityDto {

    var documentNumber: String

    var documentDate: LocalDate

    //TODO A.Stykalin [24.07.2020] а точно ли nullable?
    var customerId: UUID?

    var status: String?

    fun isInStatus(vararg statuses: String): Boolean = this.status in statuses

    fun isInStatus(vararg statuses: IDocumentStatus<IDocument>): Boolean {
        return (this.status in statuses.map { it.statusBank }
                || this.status in statuses.map { it.statusClient })
    }
}

val recentDocFilterData = FilterData(
    field = "documentDate",
    predicate = Predicate.GE,
    value = LocalDate.now().minusDays(2),
    type = OperandType.CONDITION
)

/**
 * Interface-marker.
 * Mark Document which uses for update [T] Document.
 */
interface UpdateIDocument<T : IDocument> : IDocument, UpdateIEntityDto<T>