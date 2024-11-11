package ooo.jtc.testdata.salary

import ooo.jtc.api.common.sorting.ISortingParams

import ooo.jtc.salary.dto.SalaryRegisterDto

enum class SalaryRegisterSortingParams(
    override var field: String,
    override var fieldDataProvider: (SalaryRegisterDto) -> Any?
) : ISortingParams<SalaryRegisterDto> {
    //1)Salary register

    //1. general details of the document
    ID("id", fieldDataProvider = { it.id!! }),                                                  //1.1
    DOCUMENT_NUMBER("documentNumber", fieldDataProvider = { it.documentNumber }),               //1.2
    DOCUMENT_DATE("documentDate", fieldDataProvider = { it.documentDate }),                     //1.3
    STATUS("status", fieldDataProvider = { it.status!! }),                                      //1.4
    USER_ID("userId", fieldDataProvider = { it.userId }),                                     //1.5

    //2. info about the client for whom the document was created
    CUSTOMER_NAME("customerName", fieldDataProvider = { it.customerName ?: "" }),               //2.1
    CUSTOMER_INN("customerInn", fieldDataProvider = { it.customerInn }),                        //2.2
    CUSTOMER_OKPO("customerOkpo", fieldDataProvider = { it.customerOkpo }),                     //2.3
    CUSTOMER_ID("customerId", fieldDataProvider = { it.customerId!! }),                         //2.4
    ACCOUNT_DEBET("accountDebet", fieldDataProvider = { it.accountDebet }),                     //2.5
    ACCOUNT_ID("accountId", fieldDataProvider = { it.accountId }),                              //2.6

    //3. information about branch
    BRANCH_ID("branchId", fieldDataProvider = { it.branchId }),                                 //3.1
    BRANCH_NAME("branchName", fieldDataProvider = { it.branchName ?: "" }),                     //3.2

    //4. info about responsible person
    OFFICIAL("official", fieldDataProvider = { it.official }),                                  //4.1
    OFFICIAL_PHONE("officialPhone", fieldDataProvider = { it.officialPhone }),                  //4.2

    //5. info about the reporting period
    PERIOD_MONTH("periodMonth", fieldDataProvider = { it.periodMonth }),                        //5.1
    PERIOD_YEAR("periodYear", fieldDataProvider = { it.periodYear }),                           //5.2

    //6. summary info on the salary register
    AMOUNT("amount", fieldDataProvider = { it.amount }),                                        //6.1
    CURRENCY_CODE("currencyCode", fieldDataProvider = { it.currencyCode }),                     //6.2
    RECORDS_TOTAL("recordsTotal", fieldDataProvider = { it.recordsTotal }),                   //6.3

    //7. info about the doc "Payment order"
    PAY_DOCUMENT_NUMBER("payDocumentNumber", fieldDataProvider = { it.payDocumentNumber }),     //7.1
    PAY_DOCUMENT_DATE("payDocumentDate", fieldDataProvider = { it.payDocumentDate }),           //7.2
    PAY_DOCUMENT_GROUND("payDocumentGround", fieldDataProvider = { it.payDocumentGround }),     //7.3
    PAYMENT_ID("paymentId", fieldDataProvider = { it.paymentId }),                              //7.4

    //2) Salary payroll
    // todo Khatmullin 23.04.2021 not implemented yet

    //   EMPLOYEE_LAST_NAME("employeeLastName",fieldDataProvider = { it.payrolls.employeeLastName!! }),       //1.1
    //   EMPLOYEE_NAME("employeeName",fieldDataProvider = {it.payrolls.employeeName}),                        //1.2
    //   EMPLOYEE_SURNAME("employeeSurname",fieldDataProvider = {it.payrolls.employeeSurname}),               //1.3
    //   EMPLOYEE_INN("employeeInn",fieldDataProvider = {it.payrolls.employeeInn}),                           //1.4

    //   EMPLOYEE_AMOUNT("employeeAmount",fieldDataProvider = { it.payrolls.employeeAmount!! }),              //2.1

    //   EMPLOYEE_ACCOUNT("employeeAccount",fieldDataProvider = {it.payrolls.employeeAccount}),               //3.1
    //   EMPLOYEE_BANK_BIC("employeeBankAccount",fieldDataProvider = {it.payrolls.employeeBankBic}),          //3.2
    //   EMPLOYEE_BANK_ACCOUNT("",fieldDataProvider = {it.payrolls.employeeBankAccount}),                     //3.3
    //   EMPLOYEE_BANK_NAME("employeeBankName",fieldDataProvider = {it.payrolls.employeeBankName}),           //3.4
    //   EMPLOYEE_BANK_ADDRESS("employeeBankAddress",fieldDataProvider = {it.payrolls.employeeBankAddress}),  //3.5

    //   CHECK_RESULT("checkResult",fieldDataProvider = { it.payrolls.checkResult!! }),                       //4.1
    //   EMPLOYEE_COMMENTS("employeeComments",fieldDataProvider = {it.payrolls.employeeComments}),            //4.2
    //   SALARY_REGISTER_ID("salaryRegisterId",fieldDataProvider = {it.payrolls.salaryRegisterId}),           //4.3
    //   EMPLOYEE_ID("employeeId",fieldDataProvider = {it.payrolls.employeeId}),                              //4.4

}
