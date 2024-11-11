package ooo.jtc.letters.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.extensions.toStringAsJson
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.attachments.AttachmentDto
import ooo.jtc.interfaces.IWithAttachments
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.letters.LetterToBankView
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@EntityName(DocumentNames.LETTER_TO_BANK)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class LetterToBankDto(
    override var id: UUID?,
    override var version: Int,
    override var documentNumber: String,
    override var documentDate: LocalDate,
    override var customerId: UUID?,
    override var status: String?,
    var receiveDate: ZonedDateTime? = null,
    var executionDate: ZonedDateTime? = null,
    var executionMessage: String? = null,
    var createdAt: ZonedDateTime? = null,
    var modifiedAt: ZonedDateTime? = null,
    var customerName: String?,
    var branchId: UUID?,
    var branchName: String?,
    var contactName: String?,
    var contactPhone: String?,
    var docType: String?,
    var docTypeDescription: String?,
    var docTheme: String?,
    var docText: String?,
    var letterFromBankId: UUID? = null,
    @JvmField var isFavorites: Boolean?,
    @JvmField var isHasAttach: Boolean?,
    override var attachments: List<AttachmentDto>?
) : UpdateIDocument<LetterToBankDto>, IWithAttachments<AttachmentDto> {

    fun toView(): LetterToBankView {
        return Mappers.letterToBankViewMapper.toView(this)
    }

    override fun toString(): String {
        return toStringAsJson(DocumentNames.LETTER_TO_BANK, this)
    }
}