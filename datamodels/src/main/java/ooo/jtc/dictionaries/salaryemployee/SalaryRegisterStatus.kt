package ooo.jtc.dictionaries.salaryemployee

import ooo.jtc.documents.IDocumentStatus
import ooo.jtc.salary.dto.SalaryRegisterDto

enum class SalaryRegisterStatus(
    override val statusClient: String,
    override val descriptionClient: String,
    override val statusBank: String = statusClient,
    override val descriptionBank: String = descriptionClient
) : IDocumentStatus<SalaryRegisterDto> {
    // 'hidden' statuses
    DELETED("Deleted", IDocumentStatus.NOT_AVAILABLE),

    DRAFT(
        "Draft", "Черновик",
        "Draft", IDocumentStatus.NOT_AVAILABLE
    ),
    NEW(
        "New", "На подпись",
        "New", IDocumentStatus.NOT_AVAILABLE);
}
