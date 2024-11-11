package ooo.jtc.dictionaries.salaryemployee

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.NotRequiredForTest
import ooo.jtc.interfaces.IEntity
import java.sql.Timestamp
import java.util.*

@KotlinBuilder
data class SalaryEmployeePaymentDetails(
    override var id: UUID?,
    override var version: Int,
    @JsonProperty("id_employee") var employeeId: UUID?,
    @NotRequiredForTest @JsonProperty("id_customer") var customerId: UUID?,
    var account: String?,
    var bic: String?,
    @JsonProperty("corr_account") var corrAccount: String?,
    @JsonProperty("bank_name")  var bankName: String?,
    @JsonProperty("bank_place") var bankPlace: String?,

    @NotRequiredForTest @JsonProperty("created_at") val createdAt: Timestamp?,
    @NotRequiredForTest @JsonProperty("deleted_at") val deletedAt: Timestamp?

): IEntity {
    @NotRequiredForTest
    @JsonIgnore
    override val entityName: String = "Связь Сотрудника зп проекта и его Платежных реквизитов"
}