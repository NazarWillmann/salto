package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CONTRACTORPAYMENT
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentCreateTest
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentDeleteTest
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentFiltrationTests
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentGetPageTest
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentGetTest
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentPrepareSteps
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentSortingTest
import ooo.jtc.api.dictionaries.contractorpayment.ContractorPaymentUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentData
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.ACCOUNT
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.BANK_ADDRESS
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.BANK_NAME
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.BIC
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.CONTRACTOR_ID
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.CORR_ACCOUNT
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.ID
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentFilterParams.IS_DEFAULT
import ooo.jtc.testdata.dictionaries.contractorpayment.ContractorPaymentSortingParams
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
@Story(DictionaryNames.CONTRACTOR_PAYMENT)
@DisplayName("API '${DictionaryNames.CONTRACTOR_PAYMENT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CONTRACTORPAYMENT
@TestInstance(PER_CLASS)
class ContractorPaymentTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3184") annotation class T3184
@Tag("JTCSALTO-T3185") annotation class T3185
@Tag("JTCSALTO-T3186") annotation class T3186
@Tag("JTCSALTO-T3187") annotation class T3187
@Tag("JTCSALTO-T3188") annotation class T3188
@Tag("JTCSALTO-T3189") annotation class T3189
@Tag("JTCSALTO-T3190") annotation class T3190
@Tag("JTCSALTO-T3191") annotation class T3191
@Tag("JTCSALTO-T3192") annotation class T3192
@Tag("JTCSALTO-T3193") annotation class T3193
@Tag("JTCSALTO-T3194") annotation class T3194
@Tag("JTCSALTO-T3195") annotation class T3195
@Tag("JTCSALTO-T3196") annotation class T3196
@Tag("JTCSALTO-T3197") annotation class T3197
@Tag("JTCSALTO-T3198") annotation class T3198
@Tag("JTCSALTO-T3199") annotation class T3199
@Tag("JTCSALTO-T3200") annotation class T3200
@Tag("JTCSALTO-T3201") annotation class T3201
@Tag("JTCSALTO-T3202") annotation class T3202
@Tag("JTCSALTO-T3203") annotation class T3203
@Tag("JTCSALTO-T3204") annotation class T3204
@Tag("JTCSALTO-T3205") annotation class T3205
@Tag("JTCSALTO-T3206") annotation class T3206
@Tag("JTCSALTO-T3207") annotation class T3207
@Tag("JTCSALTO-T3208") annotation class T3208
@Tag("JTCSALTO-T3209") annotation class T3209
@Tag("JTCSALTO-T3210") annotation class T3210
@Tag("JTCSALTO-T3211") annotation class T3211
@Tag("JTCSALTO-T3212") annotation class T3212
@Tag("JTCSALTO-T3213") annotation class T3213
@Tag("JTCSALTO-T3214") annotation class T3214
@Tag("JTCSALTO-T3215") annotation class T3215
@Tag("JTCSALTO-T3216") annotation class T3216
@Tag("JTCSALTO-T3217") annotation class T3217
@Tag("JTCSALTO-T3218") annotation class T3218
@Tag("JTCSALTO-T3219") annotation class T3219
@Tag("JTCSALTO-T3220") annotation class T3220
@Tag("JTCSALTO-T3221") annotation class T3221
@Tag("JTCSALTO-T3222") annotation class T3222
@Tag("JTCSALTO-T3223") annotation class T3223
@Tag("JTCSALTO-T3224") annotation class T3224
@Tag("JTCSALTO-T3225") annotation class T3225
@Tag("JTCSALTO-T3226") annotation class T3226
@Tag("JTCSALTO-T3227") annotation class T3227
@Tag("JTCSALTO-T3228") annotation class T3228
@Tag("JTCSALTO-T3229") annotation class T3229
@Tag("JTCSALTO-T3230") annotation class T3230
@Tag("JTCSALTO-T3231") annotation class T3231
@Tag("JTCSALTO-T3232") annotation class T3232
@Tag("JTCSALTO-T3233") annotation class T3233
@Tag("JTCSALTO-T3234") annotation class T3234
@Tag("JTCSALTO-T3235") annotation class T3235
@Tag("JTCSALTO-T3236") annotation class T3236
@Tag("JTCSALTO-T3237") annotation class T3237
@Tag("JTCSALTO-T3238") annotation class T3238
@Tag("JTCSALTO-T3239") annotation class T3239
@Tag("JTCSALTO-T3240") annotation class T3240
@Tag("JTCSALTO-T3241") annotation class T3241
@Tag("JTCSALTO-T3242") annotation class T3242
@Tag("JTCSALTO-T3243") annotation class T3243
@Tag("JTCSALTO-T3244") annotation class T3244
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val adminUser = Users.bankAdmin
    private lateinit var clientTestDataScope: TestDataScope<ContractorPayment>
    private lateinit var bankTestDataScope: TestDataScope<ContractorPayment>

    @BeforeAll
    fun prepareTestData() {
        val availableToClient = ContractorPaymentData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = ContractorPaymentData.withRequiredFields(
            additionalFilter = { it.id!! in availableToClient },
            customCreator = { ContractorPaymentPrepareSteps.createContractorPaymentDto(clientUser).toModel() }
        )
        val availableToBank = ContractorPaymentData.searchBy(adminUser).map { it.id!! }
        bankTestDataScope = ContractorPaymentData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBank },
            customCreator = { ContractorPaymentPrepareSteps.createContractorPaymentDto(adminUser).toModel() })
    }

    @AfterAll
    fun cleanTestData() {
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

    @TestFactory
    @T3210 //'Платежные реквизиты контрагента'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3211 //'Платежные реквизиты контрагента'. CRUD: Получаем страницу записей от пользователя [BANK]
    internal fun contractorPaymentCrudBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ContractorPaymentGetTest(adminUser).withId(T3210::class),
                ContractorPaymentGetPageTest(adminUser).withId(T3211::class)
            )
        )
    }

    @TestFactory
    @T3224 //'Платежные реквизиты контрагента'. CRUD: Создаем запись от пользователя [CLIENT]
    @T3225 //'Платежные реквизиты контрагента'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3226 //'Платежные реквизиты контрагента'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3227 //'Платежные реквизиты контрагента'. CRUD: Удаляем запись от пользователя [CLIENT]
    @T3228 //'Платежные реквизиты контрагента'. CRUD: Обновляем запись от пользователя [CLIENT]
    internal fun contractorPaymentCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ContractorPaymentCreateTest(clientUser).withId(T3224::class),
                ContractorPaymentGetTest(clientUser).withId(T3225::class),
                ContractorPaymentGetPageTest(clientUser).withId(T3226::class),
                ContractorPaymentDeleteTest(clientUser).withId(T3227::class),
                ContractorPaymentUpdateTest(clientUser).withId(T3228::class)
            )
        )
    }

    @TestFactory
    @T3229 //'Платежные реквизиты контрагента'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3230 //'Платежные реквизиты контрагента'. Сортировка по полю 'account, ASC' [CLIENT]
    @T3231 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankAddress, ASC' [CLIENT]
    @T3232 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankName, ASC' [CLIENT]
    @T3233 //'Платежные реквизиты контрагента'. Сортировка по полю 'bic, ASC' [CLIENT]
    @T3234 //'Платежные реквизиты контрагента'. Сортировка по полю 'contractorId, ASC' [CLIENT]
    @T3235 //'Платежные реквизиты контрагента'. Сортировка по полю 'corrAccount, ASC' [CLIENT]
    @T3236 //'Платежные реквизиты контрагента'. Сортировка по полю 'isDefault, ASC' [CLIENT]

    @T3237 //'Платежные реквизиты контрагента'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3238 //'Платежные реквизиты контрагента'. Сортировка по полю 'account, DESC' [CLIENT]
    @T3239 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankAddress, DESC' [CLIENT]
    @T3240 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankName, DESC' [CLIENT]
    @T3241 //'Платежные реквизиты контрагента'. Сортировка по полю 'bic, DESC' [CLIENT]
    @T3242 //'Платежные реквизиты контрагента'. Сортировка по полю 'contractorId, DESC' [CLIENT]
    @T3243 //'Платежные реквизиты контрагента'. Сортировка по полю 'corrAccount, DESC' [CLIENT]
    @T3244 //'Платежные реквизиты контрагента'. Сортировка по полю 'isDefault, DESC' [CLIENT]
    internal fun contractorPaymentSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ID::asc).withId(T3229::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ACCOUNT::asc).withId(T3230::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_ADDRESS::asc).withId(T3231::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_NAME::asc).withId(T3232::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BIC::asc).withId(T3233::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CONTRACTOR_ID::asc).withId(T3234::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CORR_ACCOUNT::asc).withId(T3235::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.IS_DEFAULT::asc).withId(T3236::class),

                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ID::desc).withId(T3237::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ACCOUNT::desc).withId(T3238::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_ADDRESS::desc).withId(T3239::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_NAME::desc).withId(T3240::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BIC::desc).withId(T3241::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CONTRACTOR_ID::desc).withId(T3242::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CORR_ACCOUNT::desc).withId(T3243::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.IS_DEFAULT::desc).withId(T3244::class)
            )
        )
    }

    @TestFactory
    @T3194 //'Платежные реквизиты контрагента'. Сортировка по полю 'id, ASC' [BANK]
    @T3195 //'Платежные реквизиты контрагента'. Сортировка по полю 'account, ASC' [BANK]
    @T3196 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankAddress, ASC' [BANK]
    @T3197 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankName, ASC' [BANK]
    @T3198 //'Платежные реквизиты контрагента'. Сортировка по полю 'bic, ASC' [BANK]
    @T3199 //'Платежные реквизиты контрагента'. Сортировка по полю 'contractorId, ASC' [BANK]
    @T3200 //'Платежные реквизиты контрагента'. Сортировка по полю 'corrAccount, ASC' [BANK]
    @T3201 //'Платежные реквизиты контрагента'. Сортировка по полю 'isDefault, ASC' [BANK]

    @T3202 //'Платежные реквизиты контрагента'. Сортировка по полю 'id, DESC' [BANK]
    @T3203 //'Платежные реквизиты контрагента'. Сортировка по полю 'account, DESC' [BANK]
    @T3204 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankAddress, DESC' [BANK]
    @T3205 //'Платежные реквизиты контрагента'. Сортировка по полю 'bankName, DESC' [BANK]
    @T3206 //'Платежные реквизиты контрагента'. Сортировка по полю 'bic, DESC' [BANK]
    @T3207 //'Платежные реквизиты контрагента'. Сортировка по полю 'contractorId, DESC' [BANK]
    @T3208 //'Платежные реквизиты контрагента'. Сортировка по полю 'corrAccount, DESC' [BANK]
    @T3209 //'Платежные реквизиты контрагента'. Сортировка по полю 'isDefault, DESC' [BANK]
    internal fun contractorPaymentSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ID::asc).withId(T3194::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ACCOUNT::asc).withId(T3195::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_ADDRESS::asc).withId(T3196::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_NAME::asc).withId(T3197::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BIC::asc).withId(T3198::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CONTRACTOR_ID::asc).withId(T3199::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CORR_ACCOUNT::asc).withId(T3200::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.IS_DEFAULT::asc).withId(T3201::class),

                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ID::desc).withId(T3202::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.ACCOUNT::desc).withId(T3203::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_ADDRESS::desc).withId(T3204::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BANK_NAME::desc).withId(T3205::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.BIC::desc).withId(T3206::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CONTRACTOR_ID::desc).withId(T3207::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.CORR_ACCOUNT::desc).withId(T3208::class),
                ContractorPaymentSortingTest(user, ContractorPaymentSortingParams.IS_DEFAULT::desc).withId(T3209::class)
            )
        )
    }

    private val clientDataForFilter by lazy { clientTestDataScope.all.random().toDto() }
    private val adminDataForFilter by lazy { bankTestDataScope.all.random().toDto() }

    private fun getDataForFilter(user: User): ContractorPaymentDto {
        return when (user) {
            clientUser -> clientDataForFilter
            adminUser -> adminDataForFilter
            else -> throw RuntimeException("Unexpected user '${user.login}'[${user.userType}]")
        }
    }

    @TestFactory
    @T3184 //'Платежные реквизиты контрагента'. Фильтрация по полю 'account' (eq) [CLIENT]
    @T3185 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bankAddress' (eq) [CLIENT]
    @T3186 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bankName' (eq) [CLIENT]
    @T3187 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bic' (eq) [CLIENT]
    @T3188 //'Платежные реквизиты контрагента'. Фильтрация по полю 'corrAccount' (eq) [CLIENT]
    @T3189 //'Платежные реквизиты контрагента'. Фильтрация по полю 'isDefault' (eq) [CLIENT]
    @T3190 //'Платежные реквизиты контрагента'. Фильтрация по полю 'account' (contains) [CLIENT]
    @T3191 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bankAddress' (contains) [CLIENT]
    @T3192 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bic' (contains) [CLIENT]
    @T3193 //'Платежные реквизиты контрагента'. Фильтрация по полю 'corrAccount' (contains) [CLIENT]
    internal fun contractorPaymentFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorPaymentFiltrationTests("account equals", user, { getDataForFilter(user) },
                    { ACCOUNT.eq(it!!.account) }).withId(T3184::class),
                ContractorPaymentFiltrationTests("bankAddress equals", user, { getDataForFilter(user) },
                    { BANK_ADDRESS.eq(it!!.bankAddress) }).withId(T3185::class),
                ContractorPaymentFiltrationTests("bankName equals", user, { getDataForFilter(user) },
                    { BANK_NAME.eq(it!!.bankName) }).withId(T3186::class),
                ContractorPaymentFiltrationTests("bic equals", user, { getDataForFilter(user) },
                    { BIC.eq(it!!.bic) }).withId(T3187::class),
                ContractorPaymentFiltrationTests("corrAccount equals", user, { getDataForFilter(user) },
                    { CORR_ACCOUNT.eq(it!!.corrAccount!!) }).withId(T3188::class),
                ContractorPaymentFiltrationTests("isDefault equals", user, { getDataForFilter(user) },
                    { IS_DEFAULT.eq(it!!.isDefault) }).withId(T3189::class),
                ContractorPaymentFiltrationTests("account contains", user, { getDataForFilter(user) },
                    { ACCOUNT.contains(it!!.account.randomSubstringPf()) }).withId(T3190::class),
                ContractorPaymentFiltrationTests("bankAddress contains", user, { getDataForFilter(user) },
                    { BANK_ADDRESS.contains(it!!.bankAddress.randomSubstringPf()) }).withId(T3191::class),
                ContractorPaymentFiltrationTests("bic contains", user, { getDataForFilter(user) },
                    { BIC.contains(it!!.bic.randomSubstringPf()) }).withId(T3192::class),
                ContractorPaymentFiltrationTests("corrAccount contains", user, { getDataForFilter(user) },
                    { CORR_ACCOUNT.contains(it!!.corrAccount!!.randomSubstringPf()) }).withId(T3193::class)
            )
        )
    }

    @TestFactory
    @T3212 //'Платежные реквизиты контрагента'. Фильтрация по полю 'account' (eq) [BANK]
    @T3213 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bankAddress' (eq) [BANK]
    @T3214 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bankName' (eq) [BANK]
    @T3215 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bic' (eq) [BANK]
    @T3216 //'Платежные реквизиты контрагента'. Фильтрация по полю 'corrAccount' (eq) [BANK]
    @T3217 //'Платежные реквизиты контрагента'. Фильтрация по полю 'isDefault' (eq) [BANK]
    @T3218 //'Платежные реквизиты контрагента'. Фильтрация по полю 'account' (contains) [BANK]
    @T3219 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bankAddress' (contains) [BANK]
    @T3220 //'Платежные реквизиты контрагента'. Фильтрация по полю 'bic' (contains) [BANK]
    @T3221 //'Платежные реквизиты контрагента'. Фильтрация по полю 'corrAccount' (contains) [BANK]
    @T3222 //'Платежные реквизиты контрагента'. Фильтрация по полю 'id' (eq) [BANK]
    @T3223 //'Платежные реквизиты контрагента'. Фильтрация по полю 'contractorId' (eq) [BANK]
    internal fun contractorPaymentFiltrationBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorPaymentFiltrationTests("account equals", user, { getDataForFilter(user) },
                    { ACCOUNT.eq(it!!.account) }).withId(T3212::class),
                ContractorPaymentFiltrationTests("bankAddress equals", user, { getDataForFilter(user) },
                    { BANK_ADDRESS.eq(it!!.bankAddress) }).withId(T3213::class),
                ContractorPaymentFiltrationTests("bankName equals", user, { getDataForFilter(user) },
                    { BANK_NAME.eq(it!!.bankName) }).withId(T3214::class),
                ContractorPaymentFiltrationTests("bic equals", user, { getDataForFilter(user) },
                    { BIC.eq(it!!.bic) }).withId(T3215::class),
                ContractorPaymentFiltrationTests("corrAccount equals", user, { getDataForFilter(user) },
                    { CORR_ACCOUNT.eq(it!!.corrAccount!!) }).withId(T3216::class),
                ContractorPaymentFiltrationTests("isDefault equals", user, { getDataForFilter(user) },
                    { IS_DEFAULT.eq(it!!.isDefault) }).withId(T3217::class),
                ContractorPaymentFiltrationTests("account contains", user, { getDataForFilter(user) },
                    { ACCOUNT.contains(it!!.account.randomSubstringPf()) }).withId(T3218::class),
                ContractorPaymentFiltrationTests("bankAddress contains", user, { getDataForFilter(user) },
                    { BANK_ADDRESS.contains(it!!.bankAddress.randomSubstringPf()) }).withId(T3219::class),
                ContractorPaymentFiltrationTests("bic contains", user, { getDataForFilter(user) },
                    { BIC.contains(it!!.bic.randomSubstringPf()) }).withId(T3220::class),
                ContractorPaymentFiltrationTests("corrAccount contains", user, { getDataForFilter(user) },
                    { CORR_ACCOUNT.contains(it!!.corrAccount!!.randomSubstringPf()) }).withId(T3221::class),
                ContractorPaymentFiltrationTests("id equals", user, { getDataForFilter(user) },
                    { ID.eq(it!!.id!!) }).withId(T3222::class),
                ContractorPaymentFiltrationTests("contractorId equals", user, { getDataForFilter(user) },
                    { CONTRACTOR_ID.eq(it!!.contractorId) }).withId(T3223::class)
            )
        )
    }
}