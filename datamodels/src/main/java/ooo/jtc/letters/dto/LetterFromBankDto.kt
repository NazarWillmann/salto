package ooo.jtc.letters.dto

import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.documents.SignatureDto
import ooo.jtc.extensions.toStringAsJson
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.Mappers
import ooo.jtc.generic.attachments.AttachmentDto
import ooo.jtc.interfaces.IWithAttachments
import ooo.jtc.interfaces.UpdateIDocument
import ooo.jtc.letters.LetterFromBankView
import java.time.LocalDate
import java.time.ZonedDateTime
import java.util.*

@KotlinBuilder
@EntityName(DocumentNames.LETTER_FROM_BANK)
@JsonInclude(JsonInclude.Include.NON_NULL)
//https://confluence.jtc.ooo/pages/viewpage.action?pageId=19170999
data class LetterFromBankDto(
    override var id: UUID?,
    override var version: Int,
    override var documentNumber: String,
    override var documentDate: LocalDate,
    override var customerId: UUID?,
    override var status: String?,
    var createdAt: ZonedDateTime? = null,
    var modifiedAt: ZonedDateTime? = null,
    var customerName: String?,
    var branchId: UUID?,
    var branchName: String?,
    var contactName: String?,
    var contactPhone: String?,
    var docType: String?,
    var docTypeDescription: String?,
    var docTheme: String?,          //ТЗ Бэк: без ограничений по длине/символам; БД: до 4000 символов; ТЗ фронт: до 255 (мягко)
    var docText: String?,           //ТЗ Бэк: без ограничений; БД: без ограничений; ТЗ фронт: до 2000 (мягко)
    var letterToBankId: UUID? = null,
    @JvmField var isFavorites: Boolean?,
    @JvmField var isHasAttach: Boolean?,
    override var attachments: List<AttachmentDto>?,
    var sendDate: ZonedDateTime? = null,
    var signatures: List<SignatureDto>? = null
) : UpdateIDocument<LetterFromBankDto>, IWithAttachments<AttachmentDto> {

    fun toView(): LetterFromBankView = Mappers.letterFromBankViewMapper.toView(this)

    override fun toString(): String {
        return toStringAsJson(DocumentNames.LETTER_FROM_BANK, this)
    }
}