package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CONTRACTOR
import ooo.jtc.api.dictionaries.contactor.AddContractorToFavoritesTest
import ooo.jtc.api.dictionaries.contactor.ContractorCreateTest
import ooo.jtc.api.dictionaries.contactor.ContractorDeleteTest
import ooo.jtc.api.dictionaries.contactor.ContractorFiltrationTest
import ooo.jtc.api.dictionaries.contactor.ContractorGetPageTest
import ooo.jtc.api.dictionaries.contactor.ContractorGetTest
import ooo.jtc.api.dictionaries.contactor.ContractorPrepareSteps
import ooo.jtc.api.dictionaries.contactor.ContractorSortingTest
import ooo.jtc.api.dictionaries.contactor.ContractorUpdateTest
import ooo.jtc.api.dictionaries.contactor.ContractorUpdateWithRelatedTest
import ooo.jtc.api.dictionaries.contactor.RemoveContractorFromFavoritesTest
import ooo.jtc.api.dictionaries.contactor.UpdateContractorInfoTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.contractor.Contractor
import ooo.jtc.dictionaries.contractor.ContractorDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.contractor.ContractorData
import ooo.jtc.testdata.dictionaries.contractor.ContractorFilterParams
import ooo.jtc.testdata.dictionaries.contractor.ContractorSortingParams
import ooo.jtc.uaa.User
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.CONTRACTOR)
@DisplayName("API '${DictionaryNames.CONTRACTOR}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CONTRACTOR
@TestInstance(PER_CLASS)
class ContractorTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3255") annotation class T3255
@Tag("JTCSALTO-T3256") annotation class T3256
@Tag("JTCSALTO-T3257") annotation class T3257
@Tag("JTCSALTO-T3258") annotation class T3258
@Tag("JTCSALTO-T3259") annotation class T3259
@Tag("JTCSALTO-T3260") annotation class T3260
@Tag("JTCSALTO-T3261") annotation class T3261
@Tag("JTCSALTO-T3262") annotation class T3262
@Tag("JTCSALTO-T3263") annotation class T3263
@Tag("JTCSALTO-T3264") annotation class T3264
@Tag("JTCSALTO-T3265") annotation class T3265
@Tag("JTCSALTO-T3266") annotation class T3266
@Tag("JTCSALTO-T3267") annotation class T3267
@Tag("JTCSALTO-T3268") annotation class T3268
@Tag("JTCSALTO-T3269") annotation class T3269
@Tag("JTCSALTO-T3270") annotation class T3270
@Tag("JTCSALTO-T3271") annotation class T3271
@Tag("JTCSALTO-T3272") annotation class T3272
@Tag("JTCSALTO-T3273") annotation class T3273
@Tag("JTCSALTO-T3274") annotation class T3274
@Tag("JTCSALTO-T3275") annotation class T3275
@Tag("JTCSALTO-T3276") annotation class T3276
@Tag("JTCSALTO-T3277") annotation class T3277
@Tag("JTCSALTO-T3278") annotation class T3278
@Tag("JTCSALTO-T3279") annotation class T3279
@Tag("JTCSALTO-T3280") annotation class T3280
@Tag("JTCSALTO-T3281") annotation class T3281
@Tag("JTCSALTO-T3282") annotation class T3282
@Tag("JTCSALTO-T3283") annotation class T3283
@Tag("JTCSALTO-T3284") annotation class T3284
@Tag("JTCSALTO-T3285") annotation class T3285
@Tag("JTCSALTO-T3286") annotation class T3286
@Tag("JTCSALTO-T3287") annotation class T3287
@Tag("JTCSALTO-T3288") annotation class T3288
@Tag("JTCSALTO-T3289") annotation class T3289
@Tag("JTCSALTO-T3290") annotation class T3290
@Tag("JTCSALTO-T3291") annotation class T3291
@Tag("JTCSALTO-T3292") annotation class T3292
@Tag("JTCSALTO-T3293") annotation class T3293
@Tag("JTCSALTO-T3294") annotation class T3294
@Tag("JTCSALTO-T3295") annotation class T3295
@Tag("JTCSALTO-T3296") annotation class T3296
@Tag("JTCSALTO-T3297") annotation class T3297
@Tag("JTCSALTO-T3298") annotation class T3298
@Tag("JTCSALTO-T3299") annotation class T3299
@Tag("JTCSALTO-T3300") annotation class T3300
@Tag("JTCSALTO-T3301") annotation class T3301
@Tag("JTCSALTO-T3302") annotation class T3302
@Tag("JTCSALTO-T3303") annotation class T3303
@Tag("JTCSALTO-T3304") annotation class T3304
@Tag("JTCSALTO-T3305") annotation class T3305
@Tag("JTCSALTO-T3306") annotation class T3306
@Tag("JTCSALTO-T3307") annotation class T3307
@Tag("JTCSALTO-T3308") annotation class T3308
@Tag("JTCSALTO-T3309") annotation class T3309
@Tag("JTCSALTO-T3310") annotation class T3310
@Tag("JTCSALTO-T3311") annotation class T3311
@Tag("JTCSALTO-T3312") annotation class T3312
@Tag("JTCSALTO-T3313") annotation class T3313
@Tag("JTCSALTO-T3314") annotation class T3314
@Tag("JTCSALTO-T3315") annotation class T3315
@Tag("JTCSALTO-T3316") annotation class T3316
@Tag("JTCSALTO-T3317") annotation class T3317
@Tag("JTCSALTO-T3318") annotation class T3318
@Tag("JTCSALTO-T3319") annotation class T3319
@Tag("JTCSALTO-T3320") annotation class T3320
//@formatter:on
//endregion


    private val clientUser = Users.client
    private val adminUser = Users.bankAdmin
    private lateinit var clientTestDataScope: TestDataScope<Contractor>
    private lateinit var bankTestDataScope: TestDataScope<Contractor>

    @BeforeAll
    fun prepareTestData() {
        val availableToClient = ContractorData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = ContractorData.withRequiredFields(
            additionalFilter = { it.id!! in availableToClient },
            customCreator = { ContractorPrepareSteps.createContractorDto(clientUser).toModel() }
        )
        val availableToBank = ContractorData.searchBy(adminUser).map { it.id!! }
        bankTestDataScope = ContractorData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBank },
            customCreator = { ContractorPrepareSteps.createContractorDto(adminUser).toModel() }
        )
    }

    @AfterAll
    fun cleanTestData() {
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

    @TestFactory
    @T3314 //'Контрагент'. CRUD: Создаем запись от пользователя [CLIENT]
    @T3315 //'Контрагент'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3316 //'Контрагент'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3317 //'Контрагент'. CRUD: Обновляем запись от пользователя [CLIENT]
    @T3320 //'Контрагент'. CRUD: Обновляем запись (с вложенными сущностями) от пользователя [CLIENT]
    @T3318 //'Контрагент'. CRUD: Удаляем запись от пользователя [CLIENT]
    internal fun contractorCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ContractorCreateTest(clientUser).withId(T3314::class),
                ContractorGetTest(clientUser).withId(T3315::class),
                ContractorGetPageTest(clientUser).withId(T3316::class),
                ContractorUpdateTest(clientUser).withId(T3317::class),
                ContractorUpdateWithRelatedTest(clientUser).withId(T3320::class),
                ContractorDeleteTest(clientUser).withId(T3318::class)
            )
        )
    }

    @TestFactory
    @T3265 //'Контрагент'. CRUD: Создаем запись от пользователя [BANK]
    @T3266 //'Контрагент'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3267 //'Контрагент'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3268 //'Контрагент'. CRUD: Обновляем запись от пользователя [BANK]
    @T3319 //'Контрагент'. CRUD: Обновляем запись (с вложенными сущностями) от пользователя [BANK]
    @T3269 //'Контрагент'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun contractorCrudBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ContractorCreateTest(adminUser).withId(T3265::class),
                ContractorGetTest(adminUser).withId(T3266::class),
                ContractorGetPageTest(adminUser).withId(T3267::class),
                ContractorUpdateTest(adminUser).withId(T3268::class),
                ContractorUpdateWithRelatedTest(adminUser).withId(T3319::class),
                ContractorDeleteTest(adminUser).withId(T3269::class)
            )
        )
    }

    @TestFactory
    @T3270 //'Контрагент'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3271 //'Контрагент'. Сортировка по полю 'customerId, ASC' [CLIENT]
    @T3272 //'Контрагент'. Сортировка по полю 'name, ASC' [CLIENT]
    @T3273 //'Контрагент'. Сортировка по полю 'innKio, ASC' [CLIENT]
    @T3274 //'Контрагент'. Сортировка по полю 'kpp, ASC' [CLIENT]
    @T3275 //'Контрагент'. Сортировка по полю 'description, ASC' [CLIENT]
    @T3276 //'Контрагент'. Сортировка по полю 'isFavorites, ASC' [CLIENT]

    @T3277 //'Контрагент'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3278 //'Контрагент'. Сортировка по полю 'customerId, DESC' [CLIENT]
    @T3279 //'Контрагент'. Сортировка по полю 'name, DESC' [CLIENT]
    @T3280 //'Контрагент'. Сортировка по полю 'innKio, DESC' [CLIENT]
    @T3281 //'Контрагент'. Сортировка по полю 'kpp, DESC' [CLIENT]
    @T3282 //'Контрагент'. Сортировка по полю 'description, DESC' [CLIENT]
    @T3283 //'Контрагент'. Сортировка по полю 'isFavorites, DESC' [CLIENT]
    internal fun contractorSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorSortingTest(user, ContractorSortingParams.ID::asc).withId(T3270::class),
                ContractorSortingTest(user, ContractorSortingParams.CUSTOMER_ID::asc).withId(T3271::class),
                ContractorSortingTest(user, ContractorSortingParams.NAME::asc).withId(T3272::class),
                ContractorSortingTest(user, ContractorSortingParams.INN::asc).withId(T3273::class),
                ContractorSortingTest(user, ContractorSortingParams.KPP::asc).withId(T3274::class),
                ContractorSortingTest(user, ContractorSortingParams.DESCRIPTION::asc).withId(T3275::class),
                ContractorSortingTest(user, ContractorSortingParams.IS_FAVORITE::asc).withId(T3276::class),

                ContractorSortingTest(user, ContractorSortingParams.ID::desc).withId(T3277::class),
                ContractorSortingTest(user, ContractorSortingParams.CUSTOMER_ID::desc).withId(T3278::class),
                ContractorSortingTest(user, ContractorSortingParams.NAME::desc).withId(T3279::class),
                ContractorSortingTest(user, ContractorSortingParams.INN::desc).withId(T3280::class),
                ContractorSortingTest(user, ContractorSortingParams.KPP::desc).withId(T3281::class),
                ContractorSortingTest(user, ContractorSortingParams.DESCRIPTION::desc).withId(T3282::class),
                ContractorSortingTest(user, ContractorSortingParams.IS_FAVORITE::desc).withId(T3283::class)
            )
        )
    }

    @TestFactory
    @T3284 //'Контрагент'. Сортировка по полю 'id, ASC' [BANK]
    @T3285 //'Контрагент'. Сортировка по полю 'customerId, ASC' [BANK]
    @T3286 //'Контрагент'. Сортировка по полю 'name, ASC' [BANK]
    @T3287 //'Контрагент'. Сортировка по полю 'innKio, ASC' [BANK]
    @T3288 //'Контрагент'. Сортировка по полю 'kpp, ASC' [BANK]
    @T3289 //'Контрагент'. Сортировка по полю 'description, ASC' [BANK]
    @T3290 //'Контрагент'. Сортировка по полю 'isFavorites, ASC' [BANK]

    @T3291 //'Контрагент'. Сортировка по полю 'id, DESC' [BANK]
    @T3292 //'Контрагент'. Сортировка по полю 'customerId, DESC' [BANK]
    @T3293 //'Контрагент'. Сортировка по полю 'name, DESC' [BANK]
    @T3294 //'Контрагент'. Сортировка по полю 'innKio, DESC' [BANK]
    @T3295 //'Контрагент'. Сортировка по полю 'kpp, DESC' [BANK]
    @T3296 //'Контрагент'. Сортировка по полю 'description, DESC' [BANK]
    @T3297 //'Контрагент'. Сортировка по полю 'isFavorites, DESC' [BANK]
    internal fun contractorSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorSortingTest(user, ContractorSortingParams.ID::asc).withId(T3284::class),
                ContractorSortingTest(user, ContractorSortingParams.CUSTOMER_ID::asc).withId(T3285::class),
                ContractorSortingTest(user, ContractorSortingParams.NAME::asc).withId(T3286::class),
                ContractorSortingTest(user, ContractorSortingParams.INN::asc).withId(T3287::class),
                ContractorSortingTest(user, ContractorSortingParams.KPP::asc).withId(T3288::class),
                ContractorSortingTest(user, ContractorSortingParams.DESCRIPTION::asc).withId(T3289::class),
                ContractorSortingTest(user, ContractorSortingParams.IS_FAVORITE::asc).withId(T3290::class),

                ContractorSortingTest(user, ContractorSortingParams.ID::desc).withId(T3291::class),
                ContractorSortingTest(user, ContractorSortingParams.CUSTOMER_ID::desc).withId(T3292::class),
                ContractorSortingTest(user, ContractorSortingParams.NAME::desc).withId(T3293::class),
                ContractorSortingTest(user, ContractorSortingParams.INN::desc).withId(T3294::class),
                ContractorSortingTest(user, ContractorSortingParams.KPP::desc).withId(T3295::class),
                ContractorSortingTest(user, ContractorSortingParams.DESCRIPTION::desc).withId(T3296::class),
                ContractorSortingTest(user, ContractorSortingParams.IS_FAVORITE::desc).withId(T3297::class)
            )
        )
    }


    private val clientDataForFilter by lazy { clientTestDataScope.all.random().toDto() }
    private val adminDataForFilter by lazy { bankTestDataScope.all.random().toDto() }

    private fun getDataForFilter(user: User): ContractorDto {
        return when (user) {
            clientUser -> clientDataForFilter
            adminUser -> adminDataForFilter
            else -> throw RuntimeException("Unexpected user '${user.login}'[${user.userType}]")
        }
    }

    @TestFactory
    @T3255 //'Контрагент'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3256 //'Контрагент'. Фильтрация по полю 'customerId' (eq) [CLIENT]
    @T3257 //'Контрагент'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T3258 //'Контрагент'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T3259 //'Контрагент'. Фильтрация по полю 'innKio' (eq) [CLIENT]
    @T3260 //'Контрагент'. Фильтрация по полю 'innKio' (contains) [CLIENT]
    @T3261 //'Контрагент'. Фильтрация по полю 'kpp' (eq) [CLIENT]
    @T3262 //'Контрагент'. Фильтрация по полю 'kpp' (contains) [CLIENT]
    @T3263 //'Контрагент'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T3264 //'Контрагент'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun contractorFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.ID.eq(it!!.id!!) }).withId(T3255::class),
                ContractorFiltrationTest("customerId equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.CUSTOMER_ID.eq(it!!.customerId) }).withId(T3256::class),

                ContractorFiltrationTest("name equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.NAME.eq(it!!.name) }).withId(T3257::class),
                ContractorFiltrationTest("name contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3258::class),
                ContractorFiltrationTest("inn equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.INN.eq(it!!.inn ?: "") }).withId(T3259::class),
                ContractorFiltrationTest("inn contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.INN.contains((it!!.inn ?: "").randomSubstringPf()) }).withId(T3260::class),
                ContractorFiltrationTest("kpp equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.KPP.eq(it!!.kpp ?: "") }).withId(T3261::class),
                ContractorFiltrationTest("kpp contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.KPP.contains((it!!.kpp ?: "").randomSubstringPf()) }).withId(T3262::class),
                ContractorFiltrationTest("description equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.DESCRIPTION.eq(it!!.description ?: "") }).withId(T3263::class),
                ContractorFiltrationTest("description contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.DESCRIPTION.contains((it!!.description ?: "").randomSubstringPf()) }).withId(T3264::class)

                //TODO A.Stykalin [16.06.2020] ждем описания всех требований. ссылки см. в [ContractorFiltrationTest]
//                ContractorFiltrationTest("isFavorites equals", user, { getDataForFilter(user) },
//                    { ContractorFilterParams.IS_FAVORITE.eq(true) })
            )
        )
    }

    @TestFactory
    @T3304 //'Контрагент'. Фильтрация по полю 'id' (eq) [BANK]
    @T3305 //'Контрагент'. Фильтрация по полю 'customerId' (eq) [BANK]
    @T3306 //'Контрагент'. Фильтрация по полю 'name' (eq) [BANK]
    @T3307 //'Контрагент'. Фильтрация по полю 'name' (contains) [BANK]
    @T3308 //'Контрагент'. Фильтрация по полю 'innKio' (eq) [BANK]
    @T3309 //'Контрагент'. Фильтрация по полю 'innKio' (contains) [BANK]
    @T3310 //'Контрагент'. Фильтрация по полю 'kpp' (eq) [BANK]
    @T3311 //'Контрагент'. Фильтрация по полю 'kpp' (contains) [BANK]
    @T3312 //'Контрагент'. Фильтрация по полю 'description' (eq) [BANK]
    @T3313 //'Контрагент'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun contractorFiltrationBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorFiltrationTest("id equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.ID.eq(it!!.id!!) }).withId(T3304::class),
                ContractorFiltrationTest("customerId equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.CUSTOMER_ID.eq(it!!.customerId) }).withId(T3305::class),

                ContractorFiltrationTest("name equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.NAME.eq(it!!.name) }).withId(T3306::class),
                ContractorFiltrationTest("name contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3307::class),
                ContractorFiltrationTest("inn equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.INN.eq(it!!.inn ?: "") }).withId(T3308::class),
                ContractorFiltrationTest("inn contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.INN.contains((it!!.inn ?: "").randomSubstringPf()) }).withId(T3309::class),
                ContractorFiltrationTest("kpp equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.KPP.eq(it!!.kpp ?: "") }).withId(T3310::class),
                ContractorFiltrationTest("kpp contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.KPP.contains((it!!.kpp ?: "").randomSubstringPf()) }).withId(T3311::class),
                ContractorFiltrationTest("description equals", user, { getDataForFilter(user) },
                    { ContractorFilterParams.DESCRIPTION.eq(it!!.description ?: "") }).withId(T3312::class),
                ContractorFiltrationTest("description contains", user, { getDataForFilter(user) },
                    { ContractorFilterParams.DESCRIPTION.contains((it!!.description ?: "").randomSubstringPf()) }).withId(T3313::class)

                //TODO A.Stykalin [16.06.2020] джем описания всех требований. ссылки см. в [ContractorFiltrationTest]
//                ContractorFiltrationTest("isFavorites equals", user, { getDataForFilter(user) },
//                    { ContractorFilterParams.IS_FAVORITE.eq(true) })
            )
        )
    }

    @TestFactory
    @T3298 //'Контрагент'. Добавить контрагента в список избранных пользователя [CLIENT]
    @T3299 //'Контрагент'. Исключить контрагента из списка избранных пользователя [CLIENT]
    @T3300 //'Контрагент'. Изменить информацию о контрагенте [CLIENT]
    @T3301 //'Контрагент'. Добавить контрагента в список избранных пользователя [BANK]
    @T3302 //'Контрагент'. Исключить контрагента из списка избранных пользователя [BANK]
    @T3303 //'Контрагент'. Изменить информацию о контрагенте [BANK]
    internal fun contractorOtherTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                AddContractorToFavoritesTest(clientUser).withId(T3298::class),
                RemoveContractorFromFavoritesTest(clientUser).withId(T3299::class),
                UpdateContractorInfoTest(clientUser).withId(T3300::class),

                AddContractorToFavoritesTest(adminUser).withId(T3301::class),
                RemoveContractorFromFavoritesTest(adminUser).withId(T3302::class),
                UpdateContractorInfoTest(adminUser).withId(T3303::class)
            )
        )
    }
}