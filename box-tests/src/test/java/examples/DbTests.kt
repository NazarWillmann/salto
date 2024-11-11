package examples

import ooo.jtc.testdata.Services
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import java.util.*


class DbTests {

    @Test
    fun getValueBySelectTest() {
        val actPayPriority = Services.RKO_RU_PAYMENT.db
            .select("RUPAYMENT", where = "document_number='14'", extracting = { this[0]["payment_priority"] }).toString()
        assertThat(actPayPriority, equalTo("4"))
    }

    @Test
    fun getValueFromListOfMapTest() {
        val expCustomerUUID = UUID.fromString("71cf2ac7-60df-4f17-afd4-b9a29b2e55df")
        val sql = "SELECT * FROM rupayment where id_customer='$expCustomerUUID'"
        val res = Services.RKO_RU_PAYMENT.db.execSql(sql) {
            this[0]["id_customer"]
        }.toString()
        assertThat(res, equalTo(expCustomerUUID.toString()))
    }

    @Test
    fun getValueBySqlTest() {
        val sql = "SELECT * FROM rupayment";
        val res = Services.RKO_RU_PAYMENT.db.execSql(sql)
        println(res)
    }
}