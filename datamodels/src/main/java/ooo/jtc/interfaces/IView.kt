package ooo.jtc.interfaces

import java.util.UUID


/**
 * Entity's representation on user interface.
 */
interface IEntityView {
    /**
     * Field for searching view on scroller.
     * Field must be a visible on scroller.
     */
    val searchField: String
}

/**
 * Entity's representation on user interface.
 */
interface IDocumentView : IEntityView {
    /**
     * Entity ID
     */
    var id: UUID?

    /**
     * Customer ID
     */
    var customerId: UUID

    var documentNumber: String

    var documentDate: String

    /**
     * Document system status. `DeliveredToBank`
     */
    var statusSystem: String

    /**
     * Document UI client status. `Отправлен`
     */
    var statusClient: String

    /**
     * Document UI bank status. `Доставлен`
     */
    var statusBank: String
}