package ooo.jtc.api.dictionaries.treasuryaccounttax

import io.qameta.allure.Step
import ooo.jtc.api.common.checks.Checks
import ooo.jtc.api.common.steps.AbstractDictionarySteps
import ooo.jtc.core.api.CoreApi
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTax
import ooo.jtc.dictionaries.treasuryaccounttax.TreasuryAccountTaxDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.Filter
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.GetPageRequest
import ooo.jtc.generic.pageparams.OperandType.CONDITION
import ooo.jtc.generic.pageparams.Paging
import ooo.jtc.generic.pageparams.Params
import ooo.jtc.generic.pageparams.Predicate.EQ
import ooo.jtc.testdata.Services
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.notNullValue
import tools.FileUtils.UPLOAD_DIR
import tools.FileUtils.getResourceAsFile

class TreasuryAccountTaxSteps(user: User) :
    AbstractDictionarySteps<TreasuryAccountTaxDto, TreasuryAccountTaxDto>(
        user = user,
        service = Services.RKO_DICTIONARY,
        entity = TreasuryAccountTaxDto::class.java,
        dictionaryName = "treasuryaccounttax"
    ) {

    companion object {

        @Step("Проверка предзаполненной сущности '${DictionaryNames.TREASURY_ACCOUNT_TAX}'")
        fun checkDefaultEntity(actualEntity: TreasuryAccountTax, expectedEntity: TreasuryAccountTax) {
            checkEntity(actualEntity, expectedEntity)
        }

        fun checkEntity(actualEntity: TreasuryAccountTax, expectedEntity: TreasuryAccountTax) {
            Checks.checkFieldValue("ТОФК", actualEntity.tofk, expectedEntity.tofk)
            Checks.checkFieldValue("Казначейский счет", actualEntity.account, expectedEntity.account)
            Checks.checkFieldValue("Наименование банка", actualEntity.bankName, expectedEntity.bankName)
            Checks.checkFieldValue("БИК", actualEntity.bic, expectedEntity.bic)
            Checks.checkFieldValue("Банковский счет, входящий в ЕКС", actualEntity.utraAccount, expectedEntity.utraAccount)
        }
    }

    @Step("Импорт справочника '${DictionaryNames.TREASURY_ACCOUNT_TAX}' (csv-файл)")
    fun importTreasuryAccountTax() {
        uploadApi.send(
            method = {
                multiPart(getResourceAsFile(path = "$UPLOAD_DIR/treasury_account_tax.csv"))
                post("$servicePath/ImportTreasuryAccountTax")
            },
            check = CoreApi.defaultStatusCheck(withCheckResponseCode = true, statusCode = 200)
        )
    }


    @Step("Проверка импортируемой сущности '${DictionaryNames.TREASURY_ACCOUNT_TAX}'")
    fun checkImportedEntity() {
        val expectedEntity = TreasuryAccountTax(
            tofk = "АТ ТОФК 33528b73-8aa8-493c-969f-1449699e194b",
            account = "00000000000000000001",
            bankName = "АТ Наименование структурного подразделения ЦБ РФ//АТ Наименование ТОФК г. Москва",
            bic = "000000001",
            utraAccount = "00000000000000000002"
        )
        val importedEntity = getPage(
            getPageRequest = GetPageRequest(
                params = Params(
                    filter = Filter(
                        FilterData(
                            field = "tofk",
                            predicate = EQ,
                            value = expectedEntity.tofk,
                            type = CONDITION
                        )
                    ),
                    paging = Paging(offset = 0, limit = 1)
                )
            )
        ).page?.get(0)
        assertThat("Импортируемая сущность не найдена", importedEntity, notNullValue())
        checkEntity(importedEntity!!.toModel(), expectedEntity)
    }
}