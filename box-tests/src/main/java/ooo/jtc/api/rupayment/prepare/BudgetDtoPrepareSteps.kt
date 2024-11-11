package ooo.jtc.api.rupayment.prepare

import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.string
import ooo.jtc.random.nextLocalDate
import ooo.jtc.rupayment.dto.BudgetDto
import ooo.jtc.rupayment.model.BudgetType
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusData
import ooo.jtc.testdata.dictionaries.budgetreasoncode.BudgetReasonCodeData
import ooo.jtc.testdata.dictionaries.kbk.KbkData
import kotlin.random.Random

object BudgetDtoPrepareSteps {

    fun getBudgetDto(budgetType: BudgetType): BudgetDto {
        val randomNumber = { Random.nextInt(until = 99999999).toString() }
        val commonBudgetDto = BudgetDto(
            budgetType = budgetType,
            payerStatus = BudgetPayerStatusData.get().random().code,
            kbk = KbkData.get().random().code,
            oktmo = randomNumber.invoke(),
            reasonDocumentNumber = randomNumber.invoke()
        )
        return when (budgetType) {
            BudgetType.CUSTOM -> {
                commonBudgetDto.apply {
                    reasonCode = BudgetReasonCodeData.searchBy(budgetType).random().code
                    budgetField107 = randomNumber.invoke()
                    reasonDocumentNumber = randomNumber.invoke()
                }
            }
            BudgetType.OTHER -> {
                commonBudgetDto
            }
            BudgetType.TAX -> {
                commonBudgetDto.apply {
                    reasonCode = BudgetReasonCodeData.searchBy(budgetType).random().code
                    budgetField107 = Random.nextLocalDate(maxMinusDays = 100).string(expectedFormat = DOTS_DATE_FORMAT)
                    reasonDocumentNumber = randomNumber.invoke()
                }
            }
        }

    }
}