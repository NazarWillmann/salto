package ooo.jtc.news.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.documents.getByBankStatus
import ooo.jtc.extensions.toStringAsJson
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.IWithAttachments
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.news.PublicationStatus
import java.time.Instant
import java.time.LocalDate
import java.util.UUID

@KotlinBuilder
@EntityName(DocumentNames.PUBLICATION)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PublicationDto(
    override var id: UUID?,
    override var version: Int,
    override var documentDate: LocalDate,
    override var documentNumber: String,
    override var status: String?,
    override var customerId: UUID? = null,          // remove from IDocument?
    var createdAt: Instant?,
    var branchId: UUID?,
    var branchName: String?,
    var description: String?,
    var publicationType: String?,                   // any of PublicationType enum
    var targetType: String?,                        // any of PublicationTargetType enum
    var isMustKnow: Boolean?,
    var isImportant: Boolean?,
    var startAt: Instant?,
    var postedAt: Instant? = null,
    var isFavorites: Boolean?,
    var endAt: Instant?,
    var mailingChannel: PublicationMailingChannel?, // any of PublicationMailingChannel enum
    var header: String?,
    var text: String?,
    var link: String?,
    var linkText: String?,
    var picture: UUID?,
    var isHasAttach: Boolean?,
    var isForAllBranches: Boolean?,
    override var attachments: List<NewsAttachmentDto>?,
    var attachName: String? = null,
    var customers: List<ReceiverCustomerDto>?,
    var mustKnows: List<MustKnowDto>?,
    var totalReceiverCustomers: Int?,
    var totalMustKnows: Int?
) : UpdateIDocument<PublicationDto>, IWithAttachments<NewsAttachmentDto> {

    override fun toString(): String {
        return toStringAsJson(DocumentNames.PUBLICATION, this)
    }

    /**
     * Reduced DTO is used on bank scroller page and in several API responses (i.e. '/post')
     * Has [customers] and [mustKnows] set to [null]
     */
    fun toReducedDto(): PublicationDto {
        return this.copy(
            customers = null,
            mustKnows = null
        )
    }

    /**
     * Publications on client side have less fields
     */
    fun toClientDto(): PublicationDto {
        val clientStatus = PublicationStatus.values.getByBankStatus(this.status!!).statusClient
        return this.copy(
            postedAt = null, //TODO Sergeyev [2020.12.09]: bug?
            status = clientStatus,
            branchId = null,
            branchName = null,
            totalMustKnows = null,
            totalReceiverCustomers = null
        )
    }
}

enum class PublicationType(val type: String) {
    NEWS("BankNews"),
    OFFER("SpecialOffer"),
    TARIFF("Tariff"),
    OTHER("Other"),
    ;
}

enum class PublicationTargetType(val type: String) {
    GENERAL("General"),
    DIRECT("Direct"),
    ;
}

enum class PublicationMailingChannel {
    WEB,
    MOBILE,
    ALL,
    ;
}