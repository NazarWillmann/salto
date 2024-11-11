package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CONTRACTORCONTACT
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactCreateTest
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactDeleteTest
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactFiltrationTests
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactGetPageTest
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactGetTest
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactPrepareSteps
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactSortingTest
import ooo.jtc.api.dictionaries.contractorcontact.ContractorContactUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.contractorcontact.ContractorContact
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactData
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactFilterParams
import ooo.jtc.testdata.dictionaries.contractorcontact.ContractorContactSortingParams
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
@Story(DictionaryNames.CONTRACTOR_CONTACT)
@DisplayName("API '${DictionaryNames.CONTRACTOR_CONTACT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CONTRACTORCONTACT
@TestInstance(PER_CLASS)
class ContractorContactTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T3123") annotation class T3123
@Tag("JTCSALTO-T3124") annotation class T3124
@Tag("JTCSALTO-T3125") annotation class T3125
@Tag("JTCSALTO-T3126") annotation class T3126
@Tag("JTCSALTO-T3127") annotation class T3127
@Tag("JTCSALTO-T3128") annotation class T3128
@Tag("JTCSALTO-T3129") annotation class T3129
@Tag("JTCSALTO-T3130") annotation class T3130
@Tag("JTCSALTO-T3131") annotation class T3131
@Tag("JTCSALTO-T3132") annotation class T3132
@Tag("JTCSALTO-T3133") annotation class T3133
@Tag("JTCSALTO-T3134") annotation class T3134
@Tag("JTCSALTO-T3135") annotation class T3135
@Tag("JTCSALTO-T3136") annotation class T3136
@Tag("JTCSALTO-T3137") annotation class T3137
@Tag("JTCSALTO-T3138") annotation class T3138
@Tag("JTCSALTO-T3139") annotation class T3139
@Tag("JTCSALTO-T3140") annotation class T3140
@Tag("JTCSALTO-T3141") annotation class T3141
@Tag("JTCSALTO-T3142") annotation class T3142
@Tag("JTCSALTO-T3143") annotation class T3143
@Tag("JTCSALTO-T3144") annotation class T3144
@Tag("JTCSALTO-T3145") annotation class T3145
@Tag("JTCSALTO-T3146") annotation class T3146
@Tag("JTCSALTO-T3147") annotation class T3147
@Tag("JTCSALTO-T3148") annotation class T3148
@Tag("JTCSALTO-T3149") annotation class T3149
@Tag("JTCSALTO-T3150") annotation class T3150
@Tag("JTCSALTO-T3151") annotation class T3151
@Tag("JTCSALTO-T3152") annotation class T3152
@Tag("JTCSALTO-T3153") annotation class T3153
@Tag("JTCSALTO-T3154") annotation class T3154
@Tag("JTCSALTO-T3155") annotation class T3155
@Tag("JTCSALTO-T3156") annotation class T3156
@Tag("JTCSALTO-T3157") annotation class T3157
@Tag("JTCSALTO-T3158") annotation class T3158
@Tag("JTCSALTO-T3159") annotation class T3159
@Tag("JTCSALTO-T3160") annotation class T3160
@Tag("JTCSALTO-T3161") annotation class T3161
@Tag("JTCSALTO-T3162") annotation class T3162
@Tag("JTCSALTO-T3163") annotation class T3163
@Tag("JTCSALTO-T3164") annotation class T3164
@Tag("JTCSALTO-T3165") annotation class T3165
@Tag("JTCSALTO-T3166") annotation class T3166
@Tag("JTCSALTO-T3167") annotation class T3167
@Tag("JTCSALTO-T3168") annotation class T3168
@Tag("JTCSALTO-T3169") annotation class T3169
@Tag("JTCSALTO-T3170") annotation class T3170
@Tag("JTCSALTO-T3171") annotation class T3171
@Tag("JTCSALTO-T3172") annotation class T3172
@Tag("JTCSALTO-T3173") annotation class T3173
@Tag("JTCSALTO-T3174") annotation class T3174
@Tag("JTCSALTO-T3175") annotation class T3175
@Tag("JTCSALTO-T3176") annotation class T3176
@Tag("JTCSALTO-T3177") annotation class T3177
@Tag("JTCSALTO-T3178") annotation class T3178
@Tag("JTCSALTO-T3179") annotation class T3179
@Tag("JTCSALTO-T3180") annotation class T3180
@Tag("JTCSALTO-T3181") annotation class T3181
@Tag("JTCSALTO-T3182") annotation class T3182
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val adminUser = Users.bankAdmin
    private lateinit var clientTestDataScope: TestDataScope<ContractorContact>
    private lateinit var bankTestDataScope: TestDataScope<ContractorContact>

    @BeforeAll
    fun prepareTestData() {
        val availableToClient = ContractorContactData.searchBy(clientUser).map { it.id!! }
        clientTestDataScope = ContractorContactData.withRequiredFields(
            additionalFilter = { it.id!! in availableToClient },
            customCreator = { ContractorContactPrepareSteps.createContractorContactDto(clientUser).toModel() }
        )
        val availableToBank = ContractorContactData.searchBy(adminUser).map { it.id!! }
        bankTestDataScope = ContractorContactData.withRequiredFields(
            additionalFilter = { it.id!! in availableToBank },
            customCreator = { ContractorContactPrepareSteps.createContractorContactDto(adminUser).toModel() })
    }

    @AfterAll
    fun cleanTestData() {
        clientTestDataScope.removeGenerated()
        bankTestDataScope.removeGenerated()
    }

    @TestFactory
    @T3137 //'Контактное лицо контрагента'. CRUD: Создаем запись от пользователя [BANK]
    @T3138 //'Контактное лицо контрагента'. CRUD: Получаем запись по id от пользователя [BANK]
    @T3139 //'Контактное лицо контрагента'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T3140 //'Контактное лицо контрагента'. CRUD: Удаляем запись от пользователя [BANK]
    @T3141 //'Контактное лицо контрагента'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun contractorContactCrudBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ContractorContactCreateTest(adminUser).withId(T3137::class),
                ContractorContactGetTest(adminUser).withId(T3138::class),
                ContractorContactGetPageTest(adminUser).withId(T3139::class),
                ContractorContactDeleteTest(adminUser).withId(T3140::class),
                ContractorContactUpdateTest(adminUser).withId(T3141::class)
            )
        )
    }

    @TestFactory
    @T3156 //'Контактное лицо контрагента'. CRUD: Создаем запись от пользователя [CLIENT]
    @T3157 //'Контактное лицо контрагента'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T3158 //'Контактное лицо контрагента'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T3159 //'Контактное лицо контрагента'. CRUD: Удаляем запись от пользователя [CLIENT]
    @T3160 //'Контактное лицо контрагента'. CRUD: Обновляем запись от пользователя [CLIENT]
    internal fun contractorContactCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ContractorContactCreateTest(clientUser).withId(T3156::class),
                ContractorContactGetTest(clientUser).withId(T3157::class),
                ContractorContactGetPageTest(clientUser).withId(T3158::class),
                ContractorContactDeleteTest(clientUser).withId(T3159::class),
                ContractorContactUpdateTest(clientUser).withId(T3160::class)
            )
        )
    }

    @TestFactory
    @T3123 //'Контактное лицо контрагента'. Сортировка по полю 'id, ASC' [CLIENT]
    @T3124 //'Контактное лицо контрагента'. Сортировка по полю 'name, ASC' [CLIENT]
    @T3125 //'Контактное лицо контрагента'. Сортировка по полю 'email, ASC' [CLIENT]
    @T3126 //'Контактное лицо контрагента'. Сортировка по полю 'comment, ASC' [CLIENT]
    @T3127 //'Контактное лицо контрагента'. Сортировка по полю 'position, ASC' [CLIENT]
    @T3128 //'Контактное лицо контрагента'. Сортировка по полю 'telephone, ASC' [CLIENT]
    @T3129 //'Контактное лицо контрагента'. Сортировка по полю 'contractorId, ASC' [CLIENT]

    @T3130 //'Контактное лицо контрагента'. Сортировка по полю 'id, DESC' [CLIENT]
    @T3131 //'Контактное лицо контрагента'. Сортировка по полю 'name, DESC' [CLIENT]
    @T3132 //'Контактное лицо контрагента'. Сортировка по полю 'email, DESC' [CLIENT]
    @T3133 //'Контактное лицо контрагента'. Сортировка по полю 'comment, DESC' [CLIENT]
    @T3134 //'Контактное лицо контрагента'. Сортировка по полю 'position, DESC' [CLIENT]
    @T3135 //'Контактное лицо контрагента'. Сортировка по полю 'telephone, DESC' [CLIENT]
    @T3136 //'Контактное лицо контрагента'. Сортировка по полю 'contractorId, DESC' [CLIENT]
    internal fun contractorContactSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorContactSortingTest(user, ContractorContactSortingParams.ID::asc).withId(T3123::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.NAME::asc).withId(T3124::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.EMAIL::asc).withId(T3125::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.COMMENT::asc).withId(T3126::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.POSITION::asc).withId(T3127::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.TELEPHONE::asc).withId(T3128::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.CONTRACTOR_ID::asc).withId(T3129::class),

                ContractorContactSortingTest(user, ContractorContactSortingParams.ID::desc).withId(T3130::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.NAME::desc).withId(T3131::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.EMAIL::desc).withId(T3132::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.COMMENT::desc).withId(T3133::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.POSITION::desc).withId(T3134::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.TELEPHONE::desc).withId(T3135::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.CONTRACTOR_ID::desc).withId(T3136::class)
            )
        )
    }

    @TestFactory
    @T3142 //'Контактное лицо контрагента'. Сортировка по полю 'id, ASC' [BANK]
    @T3143 //'Контактное лицо контрагента'. Сортировка по полю 'name, ASC' [BANK]
    @T3144 //'Контактное лицо контрагента'. Сортировка по полю 'email, ASC' [BANK]
    @T3145 //'Контактное лицо контрагента'. Сортировка по полю 'comment, ASC' [BANK]
    @T3146 //'Контактное лицо контрагента'. Сортировка по полю 'position, ASC' [BANK]
    @T3147 //'Контактное лицо контрагента'. Сортировка по полю 'telephone, ASC' [BANK]
    @T3148 //'Контактное лицо контрагента'. Сортировка по полю 'contractorId, ASC' [BANK]

    @T3149 //'Контактное лицо контрагента'. Сортировка по полю 'id, DESC' [BANK]
    @T3150 //'Контактное лицо контрагента'. Сортировка по полю 'name, DESC' [BANK]
    @T3151 //'Контактное лицо контрагента'. Сортировка по полю 'email, DESC' [BANK]
    @T3152 //'Контактное лицо контрагента'. Сортировка по полю 'comment, DESC' [BANK]
    @T3153 //'Контактное лицо контрагента'. Сортировка по полю 'position, DESC' [BANK]
    @T3154 //'Контактное лицо контрагента'. Сортировка по полю 'telephone, DESC' [BANK]
    @T3155 //'Контактное лицо контрагента'. Сортировка по полю 'contractorId, DESC' [BANK]
    internal fun contractorContactSortingBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorContactSortingTest(user, ContractorContactSortingParams.ID::asc).withId(T3142::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.NAME::asc).withId(T3143::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.EMAIL::asc).withId(T3144::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.COMMENT::asc).withId(T3145::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.POSITION::asc).withId(T3146::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.TELEPHONE::asc).withId(T3147::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.CONTRACTOR_ID::asc).withId(T3148::class),

                ContractorContactSortingTest(user, ContractorContactSortingParams.ID::desc).withId(T3149::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.NAME::desc).withId(T3150::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.EMAIL::desc).withId(T3151::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.COMMENT::desc).withId(T3152::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.POSITION::desc).withId(T3153::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.TELEPHONE::desc).withId(T3154::class),
                ContractorContactSortingTest(user, ContractorContactSortingParams.CONTRACTOR_ID::desc).withId(T3155::class)
            )
        )
    }

    private val clientDataForFilter by lazy { clientTestDataScope.all.random().toDto() }
    private val adminDataForFilter by lazy { bankTestDataScope.all.random().toDto() }

    private fun getDataForFilter(user: User): ContractorContactDto {
        return when (user) {
            clientUser -> clientDataForFilter
            adminUser -> adminDataForFilter
            else -> throw RuntimeException("Unexpected user '${user.login}'[${user.userType}]")
        }
    }

    @TestFactory
    @T3161 //'Контактное лицо контрагента'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T3162 //'Контактное лицо контрагента'. Фильтрация по полю 'name' (eq) [CLIENT]
    @T3163 //'Контактное лицо контрагента'. Фильтрация по полю 'name' (contains) [CLIENT]
    @T3164 //'Контактное лицо контрагента'. Фильтрация по полю 'email' (eq) [CLIENT]
    @T3165 //'Контактное лицо контрагента'. Фильтрация по полю 'email' (contains) [CLIENT]
    @T3166 //'Контактное лицо контрагента'. Фильтрация по полю 'position' (eq) [CLIENT]
    @T3167 //'Контактное лицо контрагента'. Фильтрация по полю 'position' (contains) [CLIENT]
    @T3168 //'Контактное лицо контрагента'. Фильтрация по полю 'telephone' (eq) [CLIENT]
    @T3169 //'Контактное лицо контрагента'. Фильтрация по полю 'telephone' (contains) [CLIENT]
    @T3170 //'Контактное лицо контрагента'. Фильтрация по полю 'comment' (eq) [CLIENT]
    @T3171 //'Контактное лицо контрагента'. Фильтрация по полю 'comment' (contains) [CLIENT]
    internal fun contractorContactFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorContactFiltrationTests("id equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.ID.eq(it!!.id!!) }).withId(T3161::class),
                ContractorContactFiltrationTests("name equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.NAME.eq(it!!.name) }).withId(T3162::class),
                ContractorContactFiltrationTests("name contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3163::class),

                ContractorContactFiltrationTests("email equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.EMAIL.eq(it!!.email!!) }).withId(T3164::class),
                ContractorContactFiltrationTests("email contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T3165::class),
                ContractorContactFiltrationTests("position equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.POSITION.eq(it!!.position!!) }).withId(T3166::class),
                ContractorContactFiltrationTests("position contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.POSITION.contains(it!!.position!!.randomSubstringPf()) }).withId(T3167::class),
                ContractorContactFiltrationTests("telephone equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.TELEPHONE.eq(it!!.telephone!!) }).withId(T3168::class),
                ContractorContactFiltrationTests("telephone contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.TELEPHONE.contains(it!!.telephone!!.randomSubstringPf()) }).withId(T3169::class),
                ContractorContactFiltrationTests("comment equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.COMMENT.eq(it!!.comment!!) }).withId(T3170::class),
                ContractorContactFiltrationTests("comment contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.COMMENT.contains(it!!.comment!!.randomSubstringPf()) }).withId(T3171::class)
            )
        )
    }

    @TestFactory
    @T3172 //'Контактное лицо контрагента'. Фильтрация по полю 'id' (eq) [BANK]
    @T3173 //'Контактное лицо контрагента'. Фильтрация по полю 'name' (eq) [BANK]
    @T3174 //'Контактное лицо контрагента'. Фильтрация по полю 'name' (contains) [BANK]
    @T3175 //'Контактное лицо контрагента'. Фильтрация по полю 'email' (eq) [BANK]
    @T3176 //'Контактное лицо контрагента'. Фильтрация по полю 'email' (contains) [BANK]
    @T3177 //'Контактное лицо контрагента'. Фильтрация по полю 'position' (eq) [BANK]
    @T3178 //'Контактное лицо контрагента'. Фильтрация по полю 'position' (contains) [BANK]
    @T3179 //'Контактное лицо контрагента'. Фильтрация по полю 'telephone' (eq) [BANK]
    @T3180 //'Контактное лицо контрагента'. Фильтрация по полю 'telephone' (contains) [BANK]
    @T3181 //'Контактное лицо контрагента'. Фильтрация по полю 'comment' (eq) [BANK]
    @T3182 //'Контактное лицо контрагента'. Фильтрация по полю 'comment' (contains) [BANK]
    internal fun contractorContactFiltrationBankTests(): List<DynamicTest> {
        val user = adminUser
        return EntityTestGenerator.generate(
            listOf(
                ContractorContactFiltrationTests("id equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.ID.eq(it!!.id!!) }).withId(T3172::class),
                ContractorContactFiltrationTests("name equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.NAME.eq(it!!.name) }).withId(T3173::class),
                ContractorContactFiltrationTests("name contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.NAME.contains(it!!.name.randomSubstringPf()) }).withId(T3174::class),

                ContractorContactFiltrationTests("email equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.EMAIL.eq(it!!.email!!) }).withId(T3175::class),
                ContractorContactFiltrationTests("email contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.EMAIL.contains(it!!.email!!.randomSubstringPf()) }).withId(T3176::class),
                ContractorContactFiltrationTests("position equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.POSITION.eq(it!!.position!!) }).withId(T3177::class),
                ContractorContactFiltrationTests("position contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.POSITION.contains(it!!.position!!.randomSubstringPf()) }).withId(T3178::class),
                ContractorContactFiltrationTests("telephone equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.TELEPHONE.eq(it!!.telephone!!) }).withId(T3179::class),
                ContractorContactFiltrationTests("telephone contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.TELEPHONE.contains(it!!.telephone!!.randomSubstringPf()) }).withId(T3180::class),
                ContractorContactFiltrationTests("comment equals", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.COMMENT.eq(it!!.comment!!) }).withId(T3181::class),
                ContractorContactFiltrationTests("comment contains", user, { getDataForFilter(user) },
                    { ContractorContactFilterParams.COMMENT.contains(it!!.comment!!.randomSubstringPf()) }).withId(T3182::class)
            )
        )
    }
}