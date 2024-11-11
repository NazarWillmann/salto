package ooo.jtc.testdata.news.mailgroup

import ooo.jtc.news.mailgroup.MailGroupReceiverCustomer
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.FindEntityBy
import ooo.jtc.testdata.common.TestDataAT

/**
 * MailGroupCustomer (ReceiverCustomer) dictionary data, that loaded from testDataProvider as [MailGroupCustomerData] in [MailGroupReceiverCustomer] format.
 */
object MailGroupCustomerData : TestDataAT<MailGroupReceiverCustomer>(MailGroupReceiverCustomer::class.java) {
    override var atMarkerPredicate: (MailGroupReceiverCustomer) -> Boolean = { customer ->
        MailGroupData.get()
            .filter { it.id!! == customer.idMailGroup }
            .all(MailGroupData.atMarkerPredicate)
    }
    override val dbDataConsumer = { Services.NEWS.db.execSql("SELECT * FROM receiver_customer_mail_group") }
    override val dataFileName = "mailGroupCustomers.json"

    override var removeRecord: ((MailGroupReceiverCustomer) -> Unit)? = { throw RuntimeException("This data should not be deleted like that") }
}

/**
 * Enum for searching [MailGroupReceiverCustomer] in [MailGroupCustomerData]
 */
enum class FindMailGroupCustomerBy(override var predicate: (MailGroupReceiverCustomer) -> Boolean) :
    FindEntityBy<MailGroupReceiverCustomer, MailGroupCustomerData> {

    AT_CREATED(MailGroupCustomerData.atMarkerPredicate),
    ;
}