package ooo.jtc.testdata.dictionaries.salaryemloyee

import ooo.jtc.dictionaries.salaryemployee.SalaryEmployeePaymentDetails
import ooo.jtc.testdata.Services
import ooo.jtc.testdata.common.TestDataAT

object SalaryEmployeePaymentDetailsData : TestDataAT<SalaryEmployeePaymentDetails>(SalaryEmployeePaymentDetails::class.java){
    override var atMarkerPredicate: (SalaryEmployeePaymentDetails)-> Boolean = {false}
    override val dbDataConsumer = { Services.SALARY.db.execSql("SELECT * FROM payment_details") }
    override val dataFileName = "salaryEmployeePaymentDetails.json"

    override var removeRecord: ((SalaryEmployeePaymentDetails) -> Unit)? = null
        get() { throw RuntimeException("This should be deleted by deleting or updating Customer!") }
    }