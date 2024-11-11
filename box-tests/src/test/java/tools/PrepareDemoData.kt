package tools

import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createLetterFromBankInStatus
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankInStatus
import ooo.jtc.api.rupayment.prepare.RuPaymentTemplates
import ooo.jtc.core.kexensions.invokeAuth
import ooo.jtc.dictionaries.branch.Branch
import ooo.jtc.dictionaries.customer.Customer
import ooo.jtc.letters.dto.LetterFromBankDto
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterFromBankStatus
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import ooo.jtc.testdata.uaa.user.StoredUserData
import ooo.jtc.uaa.User
import org.junit.jupiter.api.Test

/**
 * Methods for stand preparation.
 * Creating documents (Letters To-/FromBank, RuPayment) in different statuses for non-AT-created user.
 */
object PrepareDemoData {
    private val clientUser: User by lazy { StoredUserData.getByLogin("client").invokeAuth() }
    private val operatorUser: User by lazy { Users.systemBankOperator }
    private val customer: Customer by lazy { CustomerData.searchBy(clientUser, seekAtCreated = false).random() }
    //Sergeyev: считаем, что все подразделения, доступные client, доступны operator
    private val branch: Branch by lazy { BranchData.searchBy(clientUser, seekAtCreated = false).random() }

    @Test
    fun prepareLettersToBankDocuments() {
        val letterOfStatus: (LetterToBankStatus) -> LetterToBankDto = { status ->
            createLetterToBankInStatus(
                creatorClientUser = clientUser, receiverBankUser = operatorUser, status = status,
                dtoForCreate = LetterToBankPrepareSteps.getLetterToBankDtoForCreate(
                    customerId = customer.id!!, customerName = customer.shortName,
                    branchId = branch.id!!,     branchName = branch.shortName
                )
            )
        }
        //@formatter:off
        val neededStatuses = mapOf(
            LetterToBankStatus.DRAFT                to 2,
            LetterToBankStatus.NEW                  to 2,
            //LetterToBankStatus.PARTLY_SIGNED        to 1,
            LetterToBankStatus.SIGNED               to 2,
            LetterToBankStatus.DELIVERED            to 1,
            LetterToBankStatus.FOR_RECEIVING        to 2,
            LetterToBankStatus.RECEIVING_ERROR      to 2,
            LetterToBankStatus.RECEIVED             to 2,
            LetterToBankStatus.WRONG_ESIGNATURE     to 1,
            LetterToBankStatus.DETAILS_ERROR        to 1,
            LetterToBankStatus.IN_PROCESSING        to 2,
            LetterToBankStatus.RECALLED             to 2,
            LetterToBankStatus.PROCESSED            to 3
        )
        //@formatter:on

        neededStatuses.forEach { pairStatusAmount ->
            repeat(
                times = pairStatusAmount.value,
                action = { letterOfStatus(pairStatusAmount.key) }
            )
        }
    }

    @Test
    fun prepareLettersFromBankData() {
        val letterOfStatus: (LetterFromBankStatus) -> LetterFromBankDto = { status ->
            createLetterFromBankInStatus(
                creatorBankUser = operatorUser, receiverClientUser = clientUser, status = status,
                dtoForCreate = LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate(
                    customerId = customer.id!!, customerName = customer.shortName,
                    branchId = branch.id!!,     branchName = branch.shortName
                )
            )
        }

        //@formatter:off
        val neededStatuses = mapOf(
            LetterFromBankStatus.DRAFT                to 2,
            LetterFromBankStatus.NEW                  to 2,
            LetterFromBankStatus.SIGNED               to 2,
            LetterFromBankStatus.WRONG_ESIGNATURE     to 1,
            LetterFromBankStatus.DETAILS_ERROR        to 1,
            LetterFromBankStatus.DELIVERED            to 3
        )
        //@formatter:on

        neededStatuses.forEach { pairStatusAmount ->
            repeat(
                times = pairStatusAmount.value,
                action = { letterOfStatus(pairStatusAmount.key) }
            )
        }
    }

    @Test
    fun prepareRuPaymentData() {
        var rpBusinessDraft: RuPaymentDto = RuPaymentTemplates.getBusinessRuPayment()
        var rpPersonDraft: RuPaymentDto = RuPaymentTemplates.getPersonRuPayment()
        var rpBudgetDraft: RuPaymentDto = RuPaymentTemplates.getBudgetRuPayment()
        var rpTaxDraft: RuPaymentDto = RuPaymentTemplates.getTaxRuPayment()
        var rpCustomDraft: RuPaymentDto = RuPaymentTemplates.getCustomRuPayment()
        var rpOwnAccountsDraft: RuPaymentDto = RuPaymentTemplates.getOwnAccountsRuPayment()
        var rpOtherCustomDraft: RuPaymentDto = RuPaymentTemplates.getOtherCustomRuPayment()
        var rpOtherTaxDraft: RuPaymentDto = RuPaymentTemplates.getOtherTaxRuPayment()
        var rpOtherOtherDraft: RuPaymentDto = RuPaymentTemplates.getOtherOtherRuPayment()
        var rpOtherNoneDraft: RuPaymentDto = RuPaymentTemplates.getOtherRuPayment()
    }
}