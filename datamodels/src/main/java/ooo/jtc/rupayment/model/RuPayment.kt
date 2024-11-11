package ooo.jtc.rupayment.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.github.pozo.KotlinBuilder
import ooo.jtc.annotations.EntityName
import ooo.jtc.generic.DocumentNames
import java.math.BigDecimal
import java.sql.Timestamp
import java.time.LocalDate
import java.util.*

@KotlinBuilder
@EntityName(DocumentNames.RU_PAYMENT)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class RuPayment(
    var id: UUID? = null,
    var id_Customer: UUID? = null,
    var id_Branch: UUID? = null,
    var document_Number: String? = null,
    var document_Number_Sort: String? = null,
    var receive_Date: LocalDate? = null,
    var document_Date: LocalDate? = null,
    var client_Status: String? = null,
    var bank_Status: String? = null,
    var channel: String? = null,
    var created_At: Timestamp? = null,
    var deleted_At: Timestamp? = null,
    var modified_At: Timestamp? = null,
    var version: Long = 0,
    var status: String? = null,
    var scheme_Version: Long = 0,
    var cpm: String? = null,
    var debit_Date: LocalDate? = null,
    var expected_Execution_Date: LocalDate? = null,
    var sign_Check_Message: String? = null,
    var execution_Message: String? = null,
    var id_Execution_User: UUID? = null,
    var execution_Date: LocalDate? = null,
    var receive_Message: String? = null,
    var id_Receiver_User: UUID? = null,
    var customer_Name: String? = null,
    var branch_Name: String? = null,
    var payment_Type: String? = null,
    var payment_Type_Code: String? = null,
    var amount: String? = null,
    var uin_Uip: String? = null,
    var operation_Type: String? = null,
    var payment_Priority: String? = null,
    var ground_Operation_Code: String? = null,
    var ground_Description: String? = null,
    var ground_Nds_Calculation: Long = 0,
    var ground_Nds_Percent: String? = null,
    var ground_Nds: String? = null,
    var commission: String? = null,
    var commission_Type: String? = null,
    var note_From_Receiver: String? = null,
    var payment_Code: Long = 0,
    var income_Type_Code: Int? = null,
    var user_Payment_Type: String? = null,
    var payer_Name: String? = null,
    var payer_Account: String? = null,
    var payer_Inn: String? = null,
    var payer_Kpp: String? = null,
    var payer_Bank_Name: String? = null,
    var payer_Bank_Address: String? = null,
    var payer_Bank_Bic: String? = null,
    var payer_Bank_Corr_Account: String? = null,
    var receiver_Name: String? = null,
    var receiver_Account: String? = null,
    var receiver_Inn: String? = null,
    var receiver_Kpp: String? = null,
    var receiver_Bank_Name: String? = null,
    var receiver_Bank_Address: String? = null,
    var receiver_Bank_Bic: String? = null,
    var receiver_Bank_Corr_Account: String? = null,
    var budget_Type: String? = null,
    var budget_Payer_Status: String? = null,
    var budget_Kbk: String? = null,
    var budget_Oktmo: String? = null,
    var budget_Reason_Code: String? = null,
    var budget_Field_107: String? = null,
    var budget_Reason_Date: String? = null,
    var budget_Reason_Number: String? = null,
    var budget_Customs_Code: String? = null,
    var amount_Recovery: BigDecimal? = null,
    var transfer_Term_Code: String? = null,
    var transfer_Term_Description: String? = null,
    var id_Import: UUID? = null
)