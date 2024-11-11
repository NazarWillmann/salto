package ooo.jtc.letters

import com.github.pozo.KotlinBuilder
import ooo.jtc.generic.attachments.AttachmentDto
import ooo.jtc.interfaces.IDocumentView
import java.io.File
import java.util.*

@KotlinBuilder
data class LetterFromBankView(
    override var id: UUID?,
    override var customerId: UUID,
    override var documentNumber: String,
    override var documentDate: String,
    override var statusSystem: String,
    override var statusClient: String,
    override var statusBank: String,

    var customerName: String,
    var createdAt: String,
    var branchName: String,
    var contactName: String,
    var contactPhone: String,
    var docType: String,
    var docTypeDescription: String,
    var docTheme: String,
    var docText: String,

    var branchId: UUID?,
    var letterToBankId: UUID?,
    @JvmField var isFavorites: Boolean?,
    @JvmField var isHasAttach: Boolean?,
    var attachments: List<AttachmentDto>?,
    var attachmentFiles: List<File>?
) : IDocumentView {
    override val searchField: String
        get() = docTheme

    fun withAttachmentFiles(list: List<File>): LetterFromBankView {
        this.attachmentFiles = list
        return this
    }
}