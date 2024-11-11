package ooo.jtc.api.dictionaries.bankru

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.bankru.BankRuDto
import ooo.jtc.extensions.ofUTC
import ooo.jtc.extensions.truncToSeconds
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.bankru.BankRuData
import ooo.jtc.testdata.dictionaries.bankru.FindBankRuBy
import ooo.jtc.testdata.dictionaries.controlcode.ControlCodeData
import ooo.jtc.testdata.dictionaries.locationtype.LocationTypeData
import ooo.jtc.testdata.dictionaries.uer.UerData
import java.time.ZonedDateTime

object BankRuPrepareSteps {

    @Step("Удалить созданные автотестами данные BankRu из БД")
    fun cleanAtCreated() {
        FindBankRuBy.AT_CREATED.get().forEach { bankRu ->
            BankRuData.removeRecord?.let { it(bankRu) }
        }
    }

    fun getValidBankRuDtoForCreate(): BankRuDto {
        val rndLocTypeId = LocationTypeData.randomOrException().id!!
        val rndCtrlCodeId = ControlCodeData.randomOrException().id!!
        val rndUerId = UerData.randomOrException().id!!

        return BankRuDto(
            id = null,
            version = 0,
            bic = digits.random(6, 9),                    // up to  9 symbols (digits only)
            zip = digits.random(6, 6),                    // up to  6 symbols (digits only)
            corrAccount = digits.random(20, 20),          // up to 20 symbols (digits only)
            bankName = "bankName ${regexWord.random(15, 20)}$AT_POSTFIX",// up to 45 symbols
            address = "Address " + regexWord.random(10, 12),    // up to 30 symbols
            location = "Location " + regexWord.random(6, 8),    // up to 25 symbols
            phone = "Phone " + digits.random(7, 10),      // up to 25 symbols
            regNumber = "r№${digits.random(2, 3)}$AT_POSTFIX",    // up to  9 symbols
            controlDate = ZonedDateTime.now().ofUTC().truncToSeconds(),

            idLocationType = rndLocTypeId,
            idControlCode = rndCtrlCodeId,
            idUer = rndUerId,

            // при создании могут не указываться
            locationType = null,
            controlCode = null,
            uer = null
        )
    }

    fun getBankRuDtoForUpdate(createdDto: BankRuDto): BankRuDto {
        val rndLocTypeId = LocationTypeData.randomOrException().id!!
        val rndCtrlCodeId = ControlCodeData.randomOrException().id!!
        val rndUerId = UerData.randomOrException().id!!

        return BankRuDto(
            id = createdDto.id,
            version = createdDto.version,
            bic = createdDto.bic,
            zip = createdDto.zip,
            corrAccount = createdDto.corrAccount,
            bankName = "updated ${createdDto.bankName}",
            location = "updated ${createdDto.location}",
            address = "updated ${createdDto.address}",
            phone = "U${createdDto.phone}",
            regNumber = "U${createdDto.regNumber}",
            controlDate = createdDto.controlDate?.minusDays(2),

            idLocationType = rndLocTypeId,
            idControlCode = rndCtrlCodeId,
            idUer = rndUerId,

            // при обновлении могут не указываться
            locationType = null,
            controlCode = null,
            uer = null
        )
    }
}