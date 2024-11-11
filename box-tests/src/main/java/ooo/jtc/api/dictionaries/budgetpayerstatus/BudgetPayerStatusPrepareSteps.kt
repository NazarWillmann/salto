package ooo.jtc.api.dictionaries.budgetpayerstatus

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.budgetpayerstatus.BudgetPayerStatusDto
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.BudgetPayerStatusData
import ooo.jtc.testdata.dictionaries.budgetpayerstatus.FindBudgetPayerStatusBy
import java.util.concurrent.BlockingQueue
import kotlin.random.Random

object BudgetPayerStatusPrepareSteps {

    @Step("Удалить созданные автотестами данные BudgetPayerStatus из БД")
    fun cleanAtCreated() {
        FindBudgetPayerStatusBy.AT_CREATED.get().forEach { bps ->
            BudgetPayerStatusData.removeRecord?.let { it(bps) }
        }
    }

    val availableCodes: BlockingQueue<String?> by lazy {
        val defaultMaxExistingCode = 31
        val maxAvailableCodes = 100
        BudgetPayerStatusData.generateUniqueValues(
            consume = { it.code },
            generate = { Random.nextInt(defaultMaxExistingCode, maxAvailableCodes).toString() }
        )
    }

    fun getBudgetPayerStatusDtoForCreate(): BudgetPayerStatusDto {
        return getBudgetPayerStatusDtoForCreate(code = availableCodes.remove())
    }

    fun getBudgetPayerStatusDtoForCreate(code: String?): BudgetPayerStatusDto {
        return BudgetPayerStatusDto(
            id = null,
            version = 0,
            code = code,
            description = RandomData("[А-Яа-я№ ]*").random(length = 50).trim() + AT_POSTFIX_RUS_PARENTHESES
        )
    }

    fun getBudgetPayerStatusDtoForUpdate(createdDto: BudgetPayerStatusDto): BudgetPayerStatusDto {
        availableCodes.put(createdDto.code!!)

        return BudgetPayerStatusDto(
            createdDto.id,
            createdDto.version,
            availableCodes.remove(),
            "Обновлённый ${createdDto.description}"
        )
    }

    fun deleteWithCodeRetrieval(dto: BudgetPayerStatusDto) {
        availableCodes.add(dto.code!!)
        BudgetPayerStatusSteps(Users.bankAdmin).delete(dto.id!!)
    }
}