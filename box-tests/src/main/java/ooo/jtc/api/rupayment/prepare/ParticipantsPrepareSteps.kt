package ooo.jtc.api.rupayment.prepare

import ooo.jtc.api.rupayment.prepare.BankDtoPrepareSteps.getBankDto
import ooo.jtc.dictionaries.account.Account
import ooo.jtc.dictionaries.contractor.Contractor
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.random.RandomRequisites
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.rupayment.dto.PayerDto
import ooo.jtc.rupayment.dto.ReceiverDto
import ooo.jtc.testdata.common.random
import ooo.jtc.testdata.dictionaries.account.BalanceAccount
import ooo.jtc.testdata.dictionaries.account.checkAccountAnyOf
import ooo.jtc.testdata.dictionaries.bankru.BankRuData
import ooo.jtc.testdata.dictionaries.bankru.FindBankRuBy
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.dictionaries.currency.DefaultCurrency
import ooo.jtc.testdata.dictionaries.customer.CustomerData

object ParticipantsPrepareSteps {

    /**
     * Create [PayerDto] based on provided [Account] data
     */
    fun getPayerDto(account: Account): PayerDto {
        val branch = BranchData.searchBy(account)
        val customer = CustomerData.searchBy(account)

        return PayerDto(
            inn = customer.inn,
            name = customer.shortName,
            kpp = if(customer.kpp.isEmpty()) ""  else customer.kpp.first().kpp,
            account = account.accountNumber,
            bank = getBankDto(branch)
        )
    }


    /**
     * Create [ReceiverDto] based on provided [Account] data
     */
    fun getReceiverDto(account: Account): ReceiverDto {
        val branch = BranchData.searchBy(account)
        val customer = CustomerData.searchBy(account)

        return ReceiverDto(
            inn = customer.inn,
            name = customer.shortName,
            kpp = if(customer.kpp.isEmpty()) ""  else customer.kpp.first().kpp,
            account = account.accountNumber,
            bank = getBankDto(branch)
        )
    }

    /**
     * Create [ReceiverDto] based on provided [Contractor] and [ContractorPayment] data
     */
    fun getReceiverDto(contractor: Contractor, contractorPayment : ContractorPayment): ReceiverDto {

        return ReceiverDto(
            inn = contractor.inn,
            name = contractor.name,
            kpp = contractor.kpp,
            account = contractorPayment.account,
            bank = getBankDto(
            bankRu = BankRuData.searchBy(contractorPayment.bic!!)
            )
        )
    }

    /**
     * Create random [ReceiverDto]:
     * - bank - randomly chosen from non-Rkc banks in [BankRuData]
     * - account (number) - generated, based on bank
     * - customerName - generated
     * - customerKpp - null
     * - (customer) innKio - generated, based on accountNumber and [isBudgetPayment] value
     */
    fun getRandomReceiverDto(isBudgetPayment: Boolean = false): ReceiverDto {
        val bankRu = FindBankRuBy.NON_RKC.random()
        val balanceAccount = listOf(
            BalanceAccount.N_40702, BalanceAccount.N_40703,
            BalanceAccount.N_40802, BalanceAccount.N_40807
        ).random()
        val receiverAccNumber = RandomRequisites.generateAccountNumber(
            balanceAccount.value,
            DefaultCurrency.RUR.digitCode,
            bankRu.bic
        )
        val receiverInnKio = generateReceiverInn(receiverAccNumber, isBudgetPayment)

        return ReceiverDto(
            inn = receiverInnKio,
            name = "${regexWord.random(15, 20)}_AT",
            account = receiverAccNumber,
            bank = getBankDto(bankRu)
        )
    }

    /**
     * Generate innKio that should successfully pass BE-controls
     *
     * Based on
     * https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336972
     * https://confluence.jtc.ooo/pages/viewpage.action?pageId=4337051
     */
    private fun generateReceiverInn(receiverAccNumber: String?, isBudgetPayment: Boolean = false): String {
        if (listOf(BalanceAccount.N_40802, BalanceAccount.N_40817).checkAccountAnyOf(receiverAccNumber))
            return RandomRequisites.generateInnForIp()
        if (isBudgetPayment || listOf(
                BalanceAccount.N_40702,
                BalanceAccount.N_40703,
                BalanceAccount.N_40807
            ).checkAccountAnyOf(receiverAccNumber)
        )
            return RandomRequisites.generateInnForUl()
        throw RuntimeException("Can't decide which inn length is needed" +
                "(receiverAccount: $receiverAccNumber, isBudgetPayment: $isBudgetPayment)")
    }
}