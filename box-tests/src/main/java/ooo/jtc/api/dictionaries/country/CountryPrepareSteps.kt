package ooo.jtc.api.dictionaries.country

import com.mifmif.common.regex.Generex
import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX
import ooo.jtc.dictionaries.country.CountryDto
import ooo.jtc.random.RandomData.Companion.regexWord
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.country.CountryData
import ooo.jtc.testdata.dictionaries.country.FindCountryBy
import java.util.concurrent.BlockingQueue

object CountryPrepareSteps {

    @Step("Удалить созданные автотестами данные Country из БД")
    fun cleanAtCreated() {
        FindCountryBy.AT_CREATED.get().forEach { country ->
            CountryData.removeRecord?.let { it(country) }
        }
    }

    val alpha2Codes: BlockingQueue<String> by lazy {
        CountryData.generateUniqueValues(consume = { it.alpha2Code }, generate = { Generex("[A-Z]*").random(2, 2) })
    }

    val alpha3Codes: BlockingQueue<String> by lazy {
        CountryData.generateUniqueValues(consume = { it.alpha3Code }, generate = { Generex("[A-Z]*").random(3, 3) })
    }

    val digitCodes: BlockingQueue<String> by lazy {
        CountryData.generateUniqueValues(consume = { it.digitCode }, generate = { regexWord.random(5, 7) })
    }

    fun retrieveUsedCodes(
        countryDto: CountryDto,
        retrieveAlpha2Code: Boolean = true,
        retrieveAlpha3Code: Boolean = true,
        retrieveDigitCode: Boolean = true
    ) {
        if (retrieveAlpha2Code) alpha2Codes.put(countryDto.alpha2Code)
        if (retrieveAlpha3Code) alpha3Codes.put(countryDto.alpha3Code)
        if (retrieveDigitCode) digitCodes.put(countryDto.digitCode)
    }

    fun getCountryDtoForCreate(): CountryDto {
        val alpha2Code = alpha2Codes.remove()
        val alpha3Code = alpha3Codes.remove()
        val digitCode = digitCodes.remove()
        return CountryDto(
            id = null,
            version = 0,
            digitCode = digitCode,
            alpha2Code = alpha2Code,
            alpha3Code = alpha3Code,
            shortName = "Country / $digitCode$AT_POSTFIX",
            fullName = "Test Country #$digitCode",
            intNameIso = "TeCoY$digitCode"
        )
    }

    fun getCountryDtoForUpdate(createdDto: CountryDto): CountryDto {
        val alpha2Code = alpha2Codes.remove()
        val alpha3Code = alpha3Codes.remove()
        val digitCode = digitCodes.remove()
        return createdDto.copy(
            digitCode = digitCode,
            alpha2Code = alpha2Code,
            alpha3Code = alpha3Code,
            shortName = "Upd. ${createdDto.shortName}",
            fullName = "Updated Test Country #$digitCode",
            intNameIso = "UpTeCoY$digitCode"
        )
    }
}