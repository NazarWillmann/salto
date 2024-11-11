package ooo.jtc.api.dictionaries.ndscalculation

import io.qameta.allure.Step
import ooo.jtc.core.RegexpConst.LAT_RUS_NUM
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.ndscalculation.NdsCalculationDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.ndscalculation.FindNdsCalculationBy
import ooo.jtc.testdata.dictionaries.ndscalculation.NdsCalculationData
import java.util.concurrent.BlockingQueue
import kotlin.random.Random

object NdsCalculationPrepareSteps {

    @Step("Удалить созданные автотестами данные NdsCalculation из БД")
    fun cleanAtCreated() {
        FindNdsCalculationBy.AT_CREATED.get().forEach { ndsCalc ->
            NdsCalculationData.removeRecord?.let { it(ndsCalc) }
        }
    }

    val ndsCalcAvailableCodes: BlockingQueue<Int> by lazy {
        val defaultMaxExistingCode = 10
        val maxAvailableCodes = 100
        NdsCalculationData.generateUniqueValues(
            consume = { it.code },
            generate = { Random.nextInt(defaultMaxExistingCode, maxAvailableCodes) }
        )
    }

    fun getNdsCalculationDtoForCreate(forUi: Boolean = true): NdsCalculationDto {
        val description = if (forUi) "НДС для автотеста" else RandomData(LAT_RUS_NUM).random(10, 120)
        val template = if (forUi) "В том числе НДС <процентная ставка НДС>% - <сумма НДС>" else RandomData(LAT_RUS_NUM).random(130, 200)
        return NdsCalculationDto(
            id = null,
            version = 0,
            code = ndsCalcAvailableCodes.remove(),
            description = description + AT_POSTFIX,// up to 255 symbols
            template = template,       // up to 255 symbols
            isDefaultRuPayment = false
        )
    }

    fun getNdsCalculationDtoForUpdate(createdDto: NdsCalculationDto): NdsCalculationDto {
        ndsCalcAvailableCodes.add(createdDto.code)
        return NdsCalculationDto(
            createdDto.id, createdDto.version,
            code = ndsCalcAvailableCodes.remove(),
            description = "UPDTD DSCRPTN ${createdDto.description}",
            template = "Updated template ${createdDto.template}",
            isDefaultRuPayment = createdDto.isDefaultRuPayment
        )
    }

    @Step("Создать ${DictionaryNames.NDS_CALCULATION}")
    fun createNdsCalculationDto(dtoForCreate: NdsCalculationDto = getNdsCalculationDtoForCreate()): NdsCalculationDto {
        return NdsCalculationSteps(Users.bankAdmin).create(dtoForCreate).data.getOrException()
    }
}