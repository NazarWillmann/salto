package ooo.jtc.core.kexensions

import io.qameta.allure.Step
import ooo.jtc.letters.LetterFromBankView
import ooo.jtc.letters.LetterToBankView
import ooo.jtc.testdata.dictionaries.branchcustomer.BranchCustomerData

/**
 * Check if a customer has more than one branch relations
 */
@Step("Уточнить в одном ли подразделении обслуживается клиент")
fun LetterToBankView.hasCustomerMultiBranch(): Boolean {
    val branchCustomerList = BranchCustomerData.searchByCustomersIds(this.customerId)
    return branchCustomerList.size > 1
}

@Step("Уточнить в одном ли подразделении обслуживается клиент")
fun LetterFromBankView.hasUserMultiBranch(): Boolean {
    val branchCustomerList = BranchCustomerData.searchByCustomersIds(this.customerId)
    return branchCustomerList.size > 1
}