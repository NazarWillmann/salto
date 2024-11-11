package ooo.jtc.api.dictionaries.bankbic

import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.tests.AbstractTest
import ooo.jtc.asserts.assertObjectsEqual
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.bankbic.BankBicDto
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.testdata.dictionaries.bankbic.BankBicData
import ooo.jtc.testdata.dictionaries.bankbic.BankBicFilterParams
import ooo.jtc.testdata.dictionaries.bankbic.BankBicSortingParams
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.BANK_BIC}\" (bankBic)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class BankBicFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class BankBicFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class BankBicFolderFiltration
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class BankBicFolderOther

private const val BIC_MAIN_AGGREGATE_TASK = "JTCSALTO-2144"     //JTCSALTO-2144 - Проект Salto: Release 1 > Рублевое РКО. Справочники > Общесистемные справочники > Справочники БИК РФ (Целевой в соответствии с ED807)
private const val BIC_DOMAIN_AGGREGATE_TASK = "JTCSALTO-2145"   //  JTCSALTO-2145 - ... > Реквизитный состав
private const val BIC_DOMAIN_AN_TASK = "JTCSALTO-2146"          //      JTCSALTO-2146 - ... > ANALITICS. Разработка требований
private const val BIC_DOMAIN_BE_TASK = "JTCSALTO-2147"          //      JTCSALTO-2147 - ... > BE. Реализация
private const val BIC_UC_AGGREGATE_TASK = "JTCSALTO-2149"       //  JTCSALTO-2149 - ... > Функции (UC)
private const val BIC_UC_AN_TASK = "JTCSALTO-2150"              //      JTCSALTO-2150 - ... > ANALITICS. Разработка требований
private const val BIC_UC_BE_TASK = "JTCSALTO-2151"              //      JTCSALTO-2151 - ... > BE. Реализация
private const val BIC_UC_AT_TASK = "JTCSALTO-2153"              //      JTCSALTO-2153 - ... > Тестирование (Написание автотестов, прочие работы тестирования)

@TaskIds([
    Tm4jEpic.EPIC_R_RKO_DICTIONARY, Tm4jStoryAT.AT_STORY_COMMON_DICTIONARIES_CHANGES,
    BIC_MAIN_AGGREGATE_TASK,
    BIC_DOMAIN_AGGREGATE_TASK, BIC_DOMAIN_AN_TASK, BIC_DOMAIN_BE_TASK,
    BIC_UC_AGGREGATE_TASK, BIC_UC_AN_TASK, BIC_UC_BE_TASK, BIC_UC_AT_TASK
]) annotation class BankBicTaskIdsCommon
//@formatter:on

@BankBicTaskIdsCommon
@BankBicFolderCrud
@ComponentDictionary
@HighPriority
class BankBicGetTest(user: User) :
    GetTestTemplate<BankBicDto>(
        preExecution = { BankBicData.randomOrException(fromCache = false).toDto() },
        steps = BankBicSteps(user)
    )

@BankBicTaskIdsCommon
@BankBicFolderCrud
@ComponentDictionary
@HighPriority
class BankBicGetPageTest(user: User) :
    GetPageTestTemplate<BankBicDto>(
        steps = BankBicSteps(user)
    )

@BankBicTaskIdsCommon
@BankBicFolderCrud
@ComponentDictionary
@HighPriority
class BankBicImportTest(
    val bankUser: User,
    val steps: BankBicSteps = BankBicSteps(bankUser)
) : AbstractTest<Any, Any>(
    name = "'${DictionaryNames.BANK_BIC}'. Импорт справочника пользователем [${bankUser.userType}]"
) {

    override fun execution(preconditionResult: Any?) {
        val bankBicsForImport = BankBicPrepareSteps.prepareBankBicsForImport(amount = 10)
        val serializedXmlFile = BankBicPrepareSteps.prepareTempFileForBankBicImport(bankBicsForImport)
        val importResponse = steps.importBankBic(serializedXmlFile)

        assertThat(
            "Несовпадает количество отправленных и импортированных записей",
            bankBicsForImport.size == importResponse.data.getOrException("No 'data' in /Import response!").total
        )

        val bankBicsInDB = steps.getPageAll()
        assertThat(
            "Несовпадает количество отправленных записей и записей в БД",
            bankBicsForImport.size == bankBicsInDB.size.getOrException("No 'size' in /Get response!")
        )

        //expectedData w/ accounts and restrictions
        val expBankBicDtos = bankBicsForImport.map { it.toBankBicDto() }.sortedBy { it.bic }
        //actualData w/o accounts and restrictions, but w/ ids and non-zero version
        val actBankBicDtos = bankBicsInDB.page.getOrException()
            .map { steps.getById(it.id!!).data.getOrException() } // w/ accounts and restrictions
            .map { it.apply {
                id = null
                version = 0
                accounts?.forEach { acc ->
                    acc.id = null
                    acc.restrictions?.forEach { accRestr -> accRestr.id = null }
                }
                restrictions?.forEach { restr -> restr.id = null }
            } }
            .sortedBy { it.bic }
        for (i in expBankBicDtos.indices) {
            assertObjectsEqual(expBankBicDtos[i], actBankBicDtos[i])
        }
    }
}

@BankBicTaskIdsCommon
@BankBicFolderOther
@ComponentDictionary
@NormalPriority
class BankBicFindByBicTest(
    val bankUser: User,
    val steps: BankBicSteps = BankBicSteps(bankUser)
) : AbstractTest<Any, Any>(
    name = "'${DictionaryNames.BANK_BIC}'. Получение инф. о Банке по его БИК [${bankUser.userType}]",
    preExecution = { BankBicData.get(fromCache = false).random().toDto() }
) {

    override fun execution(preconditionResult: Any?) {
        val bankBicDto = preconditionResult as BankBicDto
        val bankFoundByBicResponse = steps.findByBic(bankBicDto.bic)
            .list.getOrException("No result(list) in response for /FindByBic")

        assertThat(
            "В БД оказалось больше одной записи для уникального поля",
            1 == bankFoundByBicResponse.size
        )

        assertObjectsEqual(bankBicDto, bankFoundByBicResponse[0])
    }
}

@BankBicTaskIdsCommon
@BankBicFolderSorting
@ComponentDictionary
@LowPriority
class BankBicSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<BankBicDto, BankBicSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = BankBicSteps(user),
    clazz = BankBicSortingParams::class.java
)

@BankBicTaskIdsCommon
@BankBicFolderFiltration
@ComponentDictionary
@NormalPriority
class BankBicFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> BankBicDto)?,
    filterRequestFunction: (BankBicDto?) -> FilterData
) : FiltrationTestTemplate<BankBicDto, BankBicFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = BankBicSteps(user),
    clazz = BankBicFilterParams::class.java,
    preExecution = preExecution
)