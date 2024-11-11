package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_BANKINFO
import ooo.jtc.api.dictionaries.bankinfo.BankInfoCreateTest
import ooo.jtc.api.dictionaries.bankinfo.BankInfoDeleteTest
import ooo.jtc.api.dictionaries.bankinfo.BankInfoFiltrationTest
import ooo.jtc.api.dictionaries.bankinfo.BankInfoGetPageTest
import ooo.jtc.api.dictionaries.bankinfo.BankInfoGetTest
import ooo.jtc.api.dictionaries.bankinfo.BankInfoPrepareSteps
import ooo.jtc.api.dictionaries.bankinfo.BankInfoSortingTest
import ooo.jtc.api.dictionaries.bankinfo.BankInfoUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.bankinfo.BankInfo
import ooo.jtc.dictionaries.bankinfo.BankInfoDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoData
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoFilterParams
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.ID
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.FULL_NAME
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.SHORT_NAME
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.LICENSE
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.LICENSE_TYPE
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.LOGO_FILE_ID
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.WEBSITE
import ooo.jtc.testdata.dictionaries.bankinfo.BankInfoSortingParams.DESCRIPTION
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.DICTIONARY)
@Story(DictionaryNames.BANK_INFO)
@DisplayName("API '${DictionaryNames.BANK_INFO}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_BANKINFO
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankInfoTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T5189") annotation class T5189
@Tag("JTCSALTO-T5190") annotation class T5190
@Tag("JTCSALTO-T5191") annotation class T5191
@Tag("JTCSALTO-T5192") annotation class T5192
@Tag("JTCSALTO-T5193") annotation class T5193
@Tag("JTCSALTO-T5194") annotation class T5194
@Tag("JTCSALTO-T5195") annotation class T5195
@Tag("JTCSALTO-T5196") annotation class T5196
@Tag("JTCSALTO-T5197") annotation class T5197
@Tag("JTCSALTO-T5198") annotation class T5198
@Tag("JTCSALTO-T5199") annotation class T5199
@Tag("JTCSALTO-T5200") annotation class T5200
@Tag("JTCSALTO-T5201") annotation class T5201
@Tag("JTCSALTO-T5202") annotation class T5202
@Tag("JTCSALTO-T5203") annotation class T5203
@Tag("JTCSALTO-T5204") annotation class T5204
@Tag("JTCSALTO-T5205") annotation class T5205
@Tag("JTCSALTO-T5206") annotation class T5206
@Tag("JTCSALTO-T5207") annotation class T5207
@Tag("JTCSALTO-T5208") annotation class T5208
@Tag("JTCSALTO-T5209") annotation class T5209
@Tag("JTCSALTO-T5210") annotation class T5210
@Tag("JTCSALTO-T5211") annotation class T5211
@Tag("JTCSALTO-T5212") annotation class T5212
@Tag("JTCSALTO-T5213") annotation class T5213
@Tag("JTCSALTO-T5214") annotation class T5214
@Tag("JTCSALTO-T5215") annotation class T5215
@Tag("JTCSALTO-T5216") annotation class T5216
@Tag("JTCSALTO-T5217") annotation class T5217
@Tag("JTCSALTO-T5218") annotation class T5218
@Tag("JTCSALTO-T5219") annotation class T5219
@Tag("JTCSALTO-T5220") annotation class T5220
@Tag("JTCSALTO-T5221") annotation class T5221
@Tag("JTCSALTO-T5222") annotation class T5222
@Tag("JTCSALTO-T5223") annotation class T5223
@Tag("JTCSALTO-T5224") annotation class T5224
@Tag("JTCSALTO-T5225") annotation class T5225
@Tag("JTCSALTO-T5226") annotation class T5226
@Tag("JTCSALTO-T5227") annotation class T5227
@Tag("JTCSALTO-T5228") annotation class T5228
@Tag("JTCSALTO-T5229") annotation class T5229
@Tag("JTCSALTO-T5230") annotation class T5230
@Tag("JTCSALTO-T5231") annotation class T5231
@Tag("JTCSALTO-T5232") annotation class T5232
@Tag("JTCSALTO-T5233") annotation class T5233
@Tag("JTCSALTO-T5234") annotation class T5234
@Tag("JTCSALTO-T5235") annotation class T5235
@Tag("JTCSALTO-T5236") annotation class T5236
@Tag("JTCSALTO-T5237") annotation class T5237
@Tag("JTCSALTO-T5238") annotation class T5238
@Tag("JTCSALTO-T5239") annotation class T5239
@Tag("JTCSALTO-T5240") annotation class T5240
@Tag("JTCSALTO-T5241") annotation class T5241
@Tag("JTCSALTO-T5242") annotation class T5242
@Tag("JTCSALTO-T5243") annotation class T5243
@Tag("JTCSALTO-T5244") annotation class T5244
@Tag("JTCSALTO-T5245") annotation class T5245
@Tag("JTCSALTO-T5246") annotation class T5246
@Tag("JTCSALTO-T5247") annotation class T5247
@Tag("JTCSALTO-T5248") annotation class T5248
@Tag("JTCSALTO-T5249") annotation class T5249
@Tag("JTCSALTO-T5250") annotation class T5250
@Tag("JTCSALTO-T5251") annotation class T5251
@Tag("JTCSALTO-T5252") annotation class T5252
@Tag("JTCSALTO-T5253") annotation class T5253
@Tag("JTCSALTO-T5254") annotation class T5254
@Tag("JTCSALTO-T5255") annotation class T5255
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator
    private val clientUser = Users.client
    private lateinit var dataForFilter: BankInfoDto
    private lateinit var testDataScope: TestDataScope<BankInfo>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = BankInfoData.withRequiredFields(
            customCreator = { BankInfoPrepareSteps.createBankInfoWithBankRepresentative(bankUser).toModel() }
        )
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T5189 //'Банк'. CRUD: Создаем запись от пользователя [BANK]
    @T5190 //'Банк'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T5191 //'Банк'. CRUD: Получаем запись по id от пользователя [BANK]
    @T5192 //'Банк'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T5193 //'Банк'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T5194 //'Банк'. CRUD: Удаляем запись от пользователя [BANK]
    @T5195 //'Банк'. CRUD: Обновляем запись от пользователя [BANK]
    internal fun crudTests(): List<DynamicTest> {
        val tests = listOf(
            BankInfoCreateTest().withId(T5189::class),
            BankInfoGetTest(user = clientUser).withId(T5190::class),
            BankInfoGetTest(user = bankUser).withId(T5191::class),
            BankInfoGetPageTest(user = clientUser).withId(T5192::class),
            BankInfoGetPageTest(user = bankUser).withId(T5193::class),
            BankInfoDeleteTest().withId(T5194::class),
            BankInfoUpdateTest().withId(T5195::class)
        )

        return EntityTestGenerator.generate(tests)
    }

    @TestFactory
    @T5226 //'Банк'. Сортировка по полю 'id, ASC' [CLIENT]
    @T5227 //'Банк'. Сортировка по полю 'fullName, ASC' [CLIENT]
    @T5228 //'Банк'. Сортировка по полю 'shortName, ASC' [CLIENT]
    @T5229 //'Банк'. Сортировка по полю 'license, ASC' [CLIENT]
    @T5230 //'Банк'. Сортировка по полю 'licenseType, ASC' [CLIENT]
    @T5231 //'Банк'. Сортировка по полю 'logoFileId, ASC' [CLIENT]
    @T5232 //'Банк'. Сортировка по полю 'website, ASC' [CLIENT]
    @T5233 //'Банк'. Сортировка по полю 'description, ASC' [CLIENT]

    @T5234 //'Банк'. Сортировка по полю 'id, DESC' [CLIENT]
    @T5235 //'Банк'. Сортировка по полю 'fullName, DESC' [CLIENT]
    @T5236 //'Банк'. Сортировка по полю 'shortName, DESC' [CLIENT]
    @T5237 //'Банк'. Сортировка по полю 'license, DESC' [CLIENT]
    @T5238 //'Банк'. Сортировка по полю 'licenseType, DESC' [CLIENT]
    @T5239 //'Банк'. Сортировка по полю 'logoFileId, DESC' [CLIENT]
    @T5240 //'Банк'. Сортировка по полю 'website, DESC' [CLIENT]
    @T5241 //'Банк'. Сортировка по полю 'description, DESC' [CLIENT]
    internal fun clientSortingTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankInfoSortingTest(user, ID::asc).withId(T5226::class),
                BankInfoSortingTest(user, FULL_NAME::asc).withId(T5227::class),
                BankInfoSortingTest(user, SHORT_NAME::asc).withId(T5228::class),
                BankInfoSortingTest(user, LICENSE::asc).withId(T5229::class),
                BankInfoSortingTest(user, LICENSE_TYPE::asc).withId(T5230::class),
                BankInfoSortingTest(user, LOGO_FILE_ID::asc).withId(T5231::class),
                BankInfoSortingTest(user, WEBSITE::asc).withId(T5232::class),
                BankInfoSortingTest(user, DESCRIPTION::asc).withId(T5233::class),

                BankInfoSortingTest(user, ID::desc).withId(T5234::class),
                BankInfoSortingTest(user, FULL_NAME::desc).withId(T5235::class),
                BankInfoSortingTest(user, SHORT_NAME::desc).withId(T5236::class),
                BankInfoSortingTest(user, LICENSE::desc).withId(T5237::class),
                BankInfoSortingTest(user, LICENSE_TYPE::desc).withId(T5238::class),
                BankInfoSortingTest(user, LOGO_FILE_ID::desc).withId(T5239::class),
                BankInfoSortingTest(user, WEBSITE::desc).withId(T5240::class),
                BankInfoSortingTest(user, DESCRIPTION::desc).withId(T5241::class)
            )
        )
    }

    @TestFactory
    @T5210 //'Банк'. Сортировка по полю 'id, ASC' [BANK]
    @T5211 //'Банк'. Сортировка по полю 'fullName, ASC' [BANK]
    @T5212 //'Банк'. Сортировка по полю 'shortName, ASC' [BANK]
    @T5213 //'Банк'. Сортировка по полю 'license, ASC' [BANK]
    @T5214 //'Банк'. Сортировка по полю 'licenseType, ASC' [BANK]
    @T5215 //'Банк'. Сортировка по полю 'logoFileId, ASC' [BANK]
    @T5216 //'Банк'. Сортировка по полю 'website, ASC' [BANK]
    @T5217 //'Банк'. Сортировка по полю 'description, ASC' [BANK]

    @T5218 //'Банк'. Сортировка по полю 'id, DESC' [BANK]
    @T5219 //'Банк'. Сортировка по полю 'fullName, DESC' [BANK]
    @T5220 //'Банк'. Сортировка по полю 'shortName, DESC' [BANK]
    @T5221 //'Банк'. Сортировка по полю 'license, DESC' [BANK]
    @T5222 //'Банк'. Сортировка по полю 'licenseType, DESC' [BANK]
    @T5223 //'Банк'. Сортировка по полю 'logoFileId, DESC' [BANK]
    @T5224 //'Банк'. Сортировка по полю 'website, DESC' [BANK]
    @T5225 //'Банк'. Сортировка по полю 'description, DESC' [BANK]
    internal fun bankSortingTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                BankInfoSortingTest(user, ID::asc).withId(T5210::class),
                BankInfoSortingTest(user, FULL_NAME::asc).withId(T5211::class),
                BankInfoSortingTest(user, SHORT_NAME::asc).withId(T5212::class),
                BankInfoSortingTest(user, LICENSE::asc).withId(T5213::class),
                BankInfoSortingTest(user, LICENSE_TYPE::asc).withId(T5214::class),
                BankInfoSortingTest(user, LOGO_FILE_ID::asc).withId(T5215::class),
                BankInfoSortingTest(user, WEBSITE::asc).withId(T5216::class),
                BankInfoSortingTest(user, DESCRIPTION::asc).withId(T5217::class),

                BankInfoSortingTest(user, ID::desc).withId(T5218::class),
                BankInfoSortingTest(user, FULL_NAME::desc).withId(T5219::class),
                BankInfoSortingTest(user, SHORT_NAME::desc).withId(T5220::class),
                BankInfoSortingTest(user, LICENSE::desc).withId(T5221::class),
                BankInfoSortingTest(user, LICENSE_TYPE::desc).withId(T5222::class),
                BankInfoSortingTest(user, LOGO_FILE_ID::desc).withId(T5223::class),
                BankInfoSortingTest(user, WEBSITE::desc).withId(T5224::class),
                BankInfoSortingTest(user, DESCRIPTION::desc).withId(T5225::class)
            )
        )
    }

    @TestFactory
    @T5242 //'Банк'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T5243 //'Банк'. Фильтрация по полю 'fullName' (eq) [CLIENT]
    @T5244 //'Банк'. Фильтрация по полю 'fullName' (contains) [CLIENT]
    @T5245 //'Банк'. Фильтрация по полю 'shortName' (eq) [CLIENT]
    @T5246 //'Банк'. Фильтрация по полю 'shortName' (contains) [CLIENT]
    @T5247 //'Банк'. Фильтрация по полю 'license' (eq) [CLIENT]
    @T5248 //'Банк'. Фильтрация по полю 'license' (contains) [CLIENT]
    @T5249 //'Банк'. Фильтрация по полю 'licenseType' (eq) [CLIENT]
    @T5250 //'Банк'. Фильтрация по полю 'licenseType' (contains) [CLIENT]
    @T5251 //'Банк'. Фильтрация по полю 'logoFileId' (eq) [CLIENT]
    @T5252 //'Банк'. Фильтрация по полю 'website' (eq) [CLIENT]
    @T5253 //'Банк'. Фильтрация по полю 'website' (contains) [CLIENT]
    @T5254 //'Банк'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T5255 //'Банк'. Фильтрация по полю 'description' (contains) [CLIENT]
    internal fun clientFiltrationTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                BankInfoFiltrationTest("id equals", user, { dataForFilter },
                    { BankInfoFilterParams.ID.eq(it!!.id!!) }).withId(T5242::class),
                BankInfoFiltrationTest("full name equals", user, { dataForFilter },
                    { BankInfoFilterParams.FULL_NAME.eq(it!!.fullName) }).withId(T5243::class),
                BankInfoFiltrationTest("full name contains", user, { dataForFilter },
                    { BankInfoFilterParams.FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T5244::class),
                BankInfoFiltrationTest("short name equals", user, { dataForFilter },
                    { BankInfoFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T5245::class),
                BankInfoFiltrationTest("short name contains", user, { dataForFilter },
                    { BankInfoFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T5246::class),
                BankInfoFiltrationTest("license equals", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE.eq(it!!.license) }).withId(T5247::class),
                BankInfoFiltrationTest("license contains", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE.contains(it!!.license.randomSubstringPf()) }).withId(T5248::class),
                BankInfoFiltrationTest("licenseType equals", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE_TYPE.eq(it!!.licenseType) }).withId(T5249::class),
                BankInfoFiltrationTest("licenseType contains", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE_TYPE.contains(it!!.licenseType.randomSubstringPf()) }).withId(T5250::class),
                BankInfoFiltrationTest("logo fileId equals", user, { dataForFilter },
                    { BankInfoFilterParams.LOGO_FILE_ID.eq(it!!.logoFileId!!) }).withId(T5251::class),
                BankInfoFiltrationTest("website equals", user, { dataForFilter },
                    { BankInfoFilterParams.WEBSITE.eq(it!!.website!!) }).withId(T5252::class),
                BankInfoFiltrationTest("website contains", user, { dataForFilter },
                    { BankInfoFilterParams.WEBSITE.contains(it!!.website!!.randomSubstringPf()) }).withId(T5253::class),
                BankInfoFiltrationTest("description equals", user, { dataForFilter },
                    { BankInfoFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T5254::class),
                BankInfoFiltrationTest("description contains", user, { dataForFilter },
                    { BankInfoFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T5255::class)
            )
        )
    }

    @TestFactory
    @T5196 //'Банк'. Фильтрация по полю 'id' (eq) [BANK]
    @T5197 //'Банк'. Фильтрация по полю 'fullName' (eq) [BANK]
    @T5198 //'Банк'. Фильтрация по полю 'fullName' (contains) [BANK]
    @T5199 //'Банк'. Фильтрация по полю 'shortName' (eq) [BANK]
    @T5200 //'Банк'. Фильтрация по полю 'shortName' (contains) [BANK]
    @T5201 //'Банк'. Фильтрация по полю 'license' (eq) [BANK]
    @T5202 //'Банк'. Фильтрация по полю 'license' (contains) [BANK]
    @T5203 //'Банк'. Фильтрация по полю 'licenseType' (eq) [BANK]
    @T5204 //'Банк'. Фильтрация по полю 'licenseType' (contains) [BANK]
    @T5205 //'Банк'. Фильтрация по полю 'logoFileId' (eq) [BANK]
    @T5206 //'Банк'. Фильтрация по полю 'website' (eq) [BANK]
    @T5207 //'Банк'. Фильтрация по полю 'website' (contains) [BANK]
    @T5208 //'Банк'. Фильтрация по полю 'description' (eq) [BANK]
    @T5209 //'Банк'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun bankFiltrationTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                BankInfoFiltrationTest("id equals", user, { dataForFilter },
                    { BankInfoFilterParams.ID.eq(it!!.id!!) }).withId(T5196::class),
                BankInfoFiltrationTest("full name equals", user, { dataForFilter },
                    { BankInfoFilterParams.FULL_NAME.eq(it!!.fullName) }).withId(T5197::class),
                BankInfoFiltrationTest("full name contains", user, { dataForFilter },
                    { BankInfoFilterParams.FULL_NAME.contains(it!!.fullName.randomSubstringPf()) }).withId(T5198::class),
                BankInfoFiltrationTest("short name equals", user, { dataForFilter },
                    { BankInfoFilterParams.SHORT_NAME.eq(it!!.shortName) }).withId(T5199::class),
                BankInfoFiltrationTest("short name contains", user, { dataForFilter },
                    { BankInfoFilterParams.SHORT_NAME.contains(it!!.shortName.randomSubstringPf()) }).withId(T5200::class),
                BankInfoFiltrationTest("license equals", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE.eq(it!!.license) }).withId(T5201::class),
                BankInfoFiltrationTest("license contains", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE.contains(it!!.license.randomSubstringPf()) }).withId(T5202::class),
                BankInfoFiltrationTest("licenseType equals", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE_TYPE.eq(it!!.licenseType) }).withId(T5203::class),
                BankInfoFiltrationTest("licenseType contains", user, { dataForFilter },
                    { BankInfoFilterParams.LICENSE_TYPE.contains(it!!.licenseType.randomSubstringPf()) }).withId(T5204::class),
                BankInfoFiltrationTest("logo fileId equals", user, { dataForFilter },
                    { BankInfoFilterParams.LOGO_FILE_ID.eq(it!!.logoFileId!!) }).withId(T5205::class),
                BankInfoFiltrationTest("website equals", user, { dataForFilter },
                    { BankInfoFilterParams.WEBSITE.eq(it!!.website!!) }).withId(T5206::class),
                BankInfoFiltrationTest("website contains", user, { dataForFilter },
                    { BankInfoFilterParams.WEBSITE.contains(it!!.website!!.randomSubstringPf()) }).withId(T5207::class),
                BankInfoFiltrationTest("description equals", user, { dataForFilter },
                    { BankInfoFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T5208::class),
                BankInfoFiltrationTest("description contains", user, { dataForFilter },
                    { BankInfoFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T5209::class)
            )
        )
    }
}