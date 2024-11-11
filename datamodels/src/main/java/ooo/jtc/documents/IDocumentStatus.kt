package ooo.jtc.documents

import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.OperandType
import ooo.jtc.generic.pageparams.Predicate
import ooo.jtc.interfaces.IDocument
import ooo.jtc.uaa.User
import ooo.jtc.uaa.UserType

interface IDocumentStatus<out T : IDocument> {
    val statusClient: String
    val descriptionClient: String
    val statusBank: String
    val descriptionBank: String

    companion object {
        const val NOT_AVAILABLE: String = "-"
    }

    fun getUserStatus(userType: UserType): String =
        if (UserType.CLIENT == userType) this.statusClient else this.statusBank

    fun getDescription(userType: UserType): String =
        if (UserType.CLIENT == userType) this.descriptionClient else this.descriptionBank

    fun asFilterData(user: User): FilterData {
        val statusValue = getUserStatus(user.userType)
        return FilterData(field = "status", predicate = Predicate.EQ, value = statusValue, type = OperandType.CONDITION)
    }
}

fun IDocumentStatus<*>.getBankOrClientStatus(): String {
    return if (IDocumentStatus.NOT_AVAILABLE != this.descriptionBank) this.statusBank
    else this.statusClient
}

fun IDocumentStatus<*>.getBankOrClientDescription(): String {
    return if (IDocumentStatus.NOT_AVAILABLE != this.descriptionBank) this.descriptionBank
    else this.descriptionClient
}

fun <T : IDocumentStatus<*>> Array<T>.bankAvailableStatuses(): List<T> = this.filter { it.descriptionBank != IDocumentStatus.NOT_AVAILABLE }
fun <T : IDocumentStatus<*>> Array<T>.clientAvailableStatuses(): List<T> = this.filter { it.descriptionClient != IDocumentStatus.NOT_AVAILABLE }

fun <T : IDocumentStatus<*>> Array<T>.getByClientStatus(clientStatus: String): T {
    return this.firstOrNull { clientStatus == it.statusClient }
        ?: this.firstOrNull { clientStatus == it.statusBank }
        ?: throw RuntimeException("Status '$clientStatus' not found in $this")
}

fun <T : IDocumentStatus<*>> Array<T>.getByBankStatus(bankStatus: String): T {
    return this.firstOrNull { bankStatus == it.statusBank }
        ?: this.firstOrNull { bankStatus == it.statusClient }
        ?: throw RuntimeException("Status '$bankStatus' not found in $this")
}

fun <T : IDocumentStatus<*>> Array<T>.getDescriptionByStatus(status: String, userType: UserType): String {
    return if (UserType.CLIENT == userType) {
        getByClientStatus(status).descriptionClient
    } else {
        getByBankStatus(status).getBankOrClientDescription()
    }
}