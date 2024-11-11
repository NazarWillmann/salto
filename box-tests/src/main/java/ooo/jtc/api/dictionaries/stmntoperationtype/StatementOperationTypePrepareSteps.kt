package ooo.jtc.api.dictionaries.stmntoperationtype

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.stmntoperationtype.StatementOperationTypeDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.stmntoperationtype.FindStatementOperationTypeBy
import ooo.jtc.testdata.dictionaries.stmntoperationtype.StatementOperationTypeData
import java.util.concurrent.BlockingQueue
import kotlin.random.Random

object StatementOperationTypePrepareSteps {

    @Step("Удалить созданные автотестами данные StatementOperationType из БД")
    fun cleanAtCreated() {
        FindStatementOperationTypeBy.AT_CREATED.get().forEach { sot ->
            StatementOperationTypeData.removeRecord?.let { it(sot) }
        }
    }

    val availableSotCodes: BlockingQueue<String> by lazy {
        val defaultMaxExistingCode = 20
        val maxAvailableCode = 100
        StatementOperationTypeData.generateUniqueValues(
            consume = { it.code },
            generate = { Random.nextInt(defaultMaxExistingCode, maxAvailableCode).toString() }
        )
    }


    fun getStatementOperationTypeDtoForCreate() =
        StatementOperationTypeDto(
            id = null,
            version = 0,
            code = availableSotCodes.remove(),
            description = RandomData("[а-яА-Я ]*").random(13, 16).trim() + AT_POSTFIX_RUS_PARENTHESES // up to 30 symbols, cyrillic
        )

    fun getStatementOperationTypeDtoForUpdate(createdDto: StatementOperationTypeDto): StatementOperationTypeDto {
        availableSotCodes.add(createdDto.code)
        return StatementOperationTypeDto(
            createdDto.id, createdDto.version,
            code = availableSotCodes.remove(),
            description = "Обновл. ${createdDto.description}"
        )
    }

    @Step("Создать ${DictionaryNames.STATEMENT_OPERATION_TYPE}")
    fun createStatementOperationTypeDto(
        dtoForCreate: StatementOperationTypeDto = getStatementOperationTypeDtoForCreate()
    ): StatementOperationTypeDto {
        return StatementOperationTypeSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}