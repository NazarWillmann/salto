package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_PERSON
import ooo.jtc.api.dictionaries.person.PersonFilterTest
import ooo.jtc.api.dictionaries.person.PersonGetPageTest
import ooo.jtc.api.dictionaries.person.PersonGetTest
import ooo.jtc.api.dictionaries.person.PersonSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.person.PersonDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.person.PersonData
import ooo.jtc.testdata.dictionaries.person.PersonSortingParams
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.BIRTHDATE
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.CATEGORY
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.EMAIL
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.EMAIL_CONFIRMED
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.FIRST_NAME
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.ID
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.LAST_NAME
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.MIDDLE_NAME
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.MOBILE_PHONE
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.PHONE_CONFIRMED
import ooo.jtc.testdata.dictionaries.person.PersonFilterParams.SEX
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
@Story(DictionaryNames.PERSON)
@DisplayName("API '${DictionaryNames.PERSON}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_PERSON
@TestInstance(PER_CLASS)
class PersonTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T6155") annotation class T6155
@Tag("JTCSALTO-T6156") annotation class T6156
@Tag("JTCSALTO-T6157") annotation class T6157
@Tag("JTCSALTO-T6158") annotation class T6158
@Tag("JTCSALTO-T6159") annotation class T6159
@Tag("JTCSALTO-T6160") annotation class T6160
@Tag("JTCSALTO-T6161") annotation class T6161
@Tag("JTCSALTO-T6162") annotation class T6162
@Tag("JTCSALTO-T6163") annotation class T6163
@Tag("JTCSALTO-T6164") annotation class T6164
@Tag("JTCSALTO-T6165") annotation class T6165
@Tag("JTCSALTO-T6166") annotation class T6166
@Tag("JTCSALTO-T6167") annotation class T6167
@Tag("JTCSALTO-T6168") annotation class T6168
@Tag("JTCSALTO-T6169") annotation class T6169
@Tag("JTCSALTO-T6170") annotation class T6170
@Tag("JTCSALTO-T6171") annotation class T6171
@Tag("JTCSALTO-T6172") annotation class T6172
@Tag("JTCSALTO-T6173") annotation class T6173
@Tag("JTCSALTO-T6174") annotation class T6174
@Tag("JTCSALTO-T6175") annotation class T6175
@Tag("JTCSALTO-T6176") annotation class T6176
@Tag("JTCSALTO-T6177") annotation class T6177
@Tag("JTCSALTO-T6178") annotation class T6178
@Tag("JTCSALTO-T6179") annotation class T6179
@Tag("JTCSALTO-T6180") annotation class T6180
@Tag("JTCSALTO-T6181") annotation class T6181
@Tag("JTCSALTO-T6182") annotation class T6182
@Tag("JTCSALTO-T6183") annotation class T6183
@Tag("JTCSALTO-T6184") annotation class T6184
@Tag("JTCSALTO-T6185") annotation class T6185
@Tag("JTCSALTO-T6186") annotation class T6186
@Tag("JTCSALTO-T6187") annotation class T6187
@Tag("JTCSALTO-T6188") annotation class T6188
@Tag("JTCSALTO-T6189") annotation class T6189
@Tag("JTCSALTO-T6190") annotation class T6190
@Tag("JTCSALTO-T6191") annotation class T6191
@Tag("JTCSALTO-T6192") annotation class T6192
@Tag("JTCSALTO-T6193") annotation class T6193
@Tag("JTCSALTO-T6194") annotation class T6194
@Tag("JTCSALTO-T6195") annotation class T6195
@Tag("JTCSALTO-T6196") annotation class T6196
@Tag("JTCSALTO-T6197") annotation class T6197
@Tag("JTCSALTO-T6198") annotation class T6198
//@formatter:on
//endregion

    private val bankUser = Users.superUser
    private lateinit var dataForFilter: PersonDto

    @BeforeAll
    fun prepareTestData() {
        dataForFilter = PersonData.get { (null != it.middleName) && (null != it.sex) }
            .random().toDto()
    }

    @TestFactory
    @T6155 //'Персона'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6156 //'Персона'. CRUD: Получаем страницу записей от пользователя [BANK]
    internal fun personCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PersonGetTest(bankUser).withId(T6155::class),
                PersonGetPageTest(bankUser).withId(T6156::class)
            )
        )
    }

    @TestFactory
    @T6157 //'Персона'. Сортировка по полю 'id, ASC' [BANK]
    @T6158 //'Персона'. Сортировка по полю 'personalData.firstName, ASC' [BANK]
    @T6159 //'Персона'. Сортировка по полю 'personalData.lastName, ASC' [BANK]
    @T6160 //'Персона'. Сортировка по полю 'personalData.middleName, ASC' [BANK]
    @T6161 //'Персона'. Сортировка по полю 'personalData.mobilePhone, ASC' [BANK]
    @T6162 //'Персона'. Сортировка по полю 'personalData.email, ASC' [BANK]
    @T6163 //'Персона'. Сортировка по полю 'birthdate, ASC' [BANK]
    @T6164 //'Персона'. Сортировка по полю 'description, ASC' [BANK]
    @T6165 //'Персона'. Сортировка по полю 'personalData.sex, ASC' [BANK]
    @T6166 //'Персона'. Сортировка по полю 'category, ASC' [BANK]
    @T6167 //'Персона'. Сортировка по полю 'emailConfirmed, ASC' [BANK]
    @T6168 //'Персона'. Сортировка по полю 'phoneConfirmed, ASC' [BANK]

    @T6169 //'Персона'. Сортировка по полю 'id, DESC' [BANK]
    @T6170 //'Персона'. Сортировка по полю 'personalData.firstName, DESC' [BANK]
    @T6171 //'Персона'. Сортировка по полю 'personalData.lastName, DESC' [BANK]
    @T6172 //'Персона'. Сортировка по полю 'personalData.middleName, DESC' [BANK]
    @T6173 //'Персона'. Сортировка по полю 'personalData.mobilePhone, DESC' [BANK]
    @T6174 //'Персона'. Сортировка по полю 'personalData.email, DESC' [BANK]
    @T6175 //'Персона'. Сортировка по полю 'birthdate, DESC' [BANK]
    @T6176 //'Персона'. Сортировка по полю 'description, DESC' [BANK]
    @T6177 //'Персона'. Сортировка по полю 'personalData.sex, DESC' [BANK]
    @T6178 //'Персона'. Сортировка по полю 'category, DESC' [BANK]
    @T6179 //'Персона'. Сортировка по полю 'emailConfirmed, DESC' [BANK]
    @T6180 //'Персона'. Сортировка по полю 'phoneConfirmed, DESC' [BANK]
    internal fun personSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PersonSortingTest(bankUser, PersonSortingParams.ID::asc).withId(T6157::class),
                PersonSortingTest(bankUser, PersonSortingParams.FIRST_NAME::asc).withId(T6158::class),
                PersonSortingTest(bankUser, PersonSortingParams.LAST_NAME::asc).withId(T6159::class),
                PersonSortingTest(bankUser, PersonSortingParams.MIDDLE_NAME::asc).withId(T6160::class),
                PersonSortingTest(bankUser, PersonSortingParams.MOBILE_PHONE::asc).withId(T6161::class),
                PersonSortingTest(bankUser, PersonSortingParams.EMAIL::asc).withId(T6162::class),
                PersonSortingTest(bankUser, PersonSortingParams.BIRTHDATE::asc).withId(T6163::class),
                PersonSortingTest(bankUser, PersonSortingParams.DESCRIPTION::asc).withId(T6164::class),
                PersonSortingTest(bankUser, PersonSortingParams.SEX::asc).withId(T6165::class),
                PersonSortingTest(bankUser, PersonSortingParams.CATEGORY::asc).withId(T6166::class),
                PersonSortingTest(bankUser, PersonSortingParams.EMAIL_CONFIRMED::asc).withId(T6167::class),
                PersonSortingTest(bankUser, PersonSortingParams.PHONE_CONFIRMED::asc).withId(T6168::class),

                PersonSortingTest(bankUser, PersonSortingParams.ID::desc).withId(T6169::class),
                PersonSortingTest(bankUser, PersonSortingParams.FIRST_NAME::desc).withId(T6170::class),
                PersonSortingTest(bankUser, PersonSortingParams.LAST_NAME::desc).withId(T6171::class),
                PersonSortingTest(bankUser, PersonSortingParams.MIDDLE_NAME::desc).withId(T6172::class),
                PersonSortingTest(bankUser, PersonSortingParams.MOBILE_PHONE::desc).withId(T6173::class),
                PersonSortingTest(bankUser, PersonSortingParams.EMAIL::desc).withId(T6174::class),
                PersonSortingTest(bankUser, PersonSortingParams.BIRTHDATE::desc).withId(T6175::class),
                PersonSortingTest(bankUser, PersonSortingParams.DESCRIPTION::desc).withId(T6176::class),
                PersonSortingTest(bankUser, PersonSortingParams.SEX::desc).withId(T6177::class),
                PersonSortingTest(bankUser, PersonSortingParams.CATEGORY::desc).withId(T6178::class),
                PersonSortingTest(bankUser, PersonSortingParams.EMAIL_CONFIRMED::desc).withId(T6179::class),
                PersonSortingTest(bankUser, PersonSortingParams.PHONE_CONFIRMED::desc).withId(T6180::class)
            )
        )
    }

    @TestFactory
    @T6181 //'Персона'. Фильтрация по полю 'id' (eq) [BANK]
    @T6182 //'Персона'. Фильтрация по полю 'personalData.firstName' (eq) [BANK]
    @T6183 //'Персона'. Фильтрация по полю 'personalData.firstName' (contains) [BANK]
    @T6184 //'Персона'. Фильтрация по полю 'personalData.lastName' (eq) [BANK]
    @T6185 //'Персона'. Фильтрация по полю 'personalData.lastName' (contains) [BANK]
    @T6186 //'Персона'. Фильтрация по полю 'personalData.middleName' (eq) [BANK]
    @T6187 //'Персона'. Фильтрация по полю 'personalData.middleName' (contains) [BANK]
    @T6188 //'Персона'. Фильтрация по полю 'personalData.mobilePhone' (eq) [BANK]
    @T6189 //'Персона'. Фильтрация по полю 'personalData.mobilePhone' (contains) [BANK]
    @T6190 //'Персона'. Фильтрация по полю 'personalData.email' (eq) [BANK]
    @T6191 //'Персона'. Фильтрация по полю 'personalData.email' (contains) [BANK]
    @T6192 //'Персона'. Фильтрация по полю 'personalData.sex' (eq) [BANK]
    @T6193 //'Персона'. Фильтрация по полю birthdate equals. [BANK]
    @T6194 //'Персона'. Фильтрация по полю 'description' (eq) [BANK]
    @T6195 //'Персона'. Фильтрация по полю 'description' (contains) [BANK]
    @T6196 //'Персона'. Фильтрация по полю 'category' (eq) [BANK]
    @T6197 //'Персона'. Фильтрация по полю 'emailConfirmed' (eq) [BANK]
    @T6198 //'Персона'. Фильтрация по полю 'phoneConfirmed' (eq) [BANK]
    internal fun personFiltrationTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PersonFilterTest("id equals", bankUser, {dataForFilter},
                    { ID.eq(it!!.id!!) }).withId(T6181::class),
                PersonFilterTest("personalData.firstName equals", bankUser, {dataForFilter},
                    { FIRST_NAME.eq(it!!.personalData.firstName) }).withId(T6182::class),
                PersonFilterTest("personalData.firstName equals", bankUser, {dataForFilter},
                    { FIRST_NAME.contains(it!!.personalData.firstName.randomSubstringPf()) }).withId(T6183::class),
                PersonFilterTest("personalData.lastName equals", bankUser, {dataForFilter},
                    { LAST_NAME.eq(it!!.personalData.lastName) }).withId(T6184::class),
                PersonFilterTest("personalData.lastName equals", bankUser, {dataForFilter},
                    { LAST_NAME.contains(it!!.personalData.lastName.randomSubstringPf()) }).withId(T6185::class),
                PersonFilterTest("personalData.middleName equals", bankUser, {dataForFilter},
                    { MIDDLE_NAME.eq(it!!.personalData.middleName!!) }).withId(T6186::class),
                PersonFilterTest("personalData.middleName equals", bankUser, {dataForFilter},
                    { MIDDLE_NAME.contains(it!!.personalData.middleName!!.randomSubstringPf()) }).withId(T6187::class),
                PersonFilterTest("personalData.mobilePhone equals", bankUser, {dataForFilter},
                    { MOBILE_PHONE.eq(it!!.personalData.mobilePhone!!) }).withId(T6188::class),
                PersonFilterTest("personalData.mobilePhone equals", bankUser, {dataForFilter},
                    { MOBILE_PHONE.contains(it!!.personalData.mobilePhone!!.randomSubstringPf()) }).withId(T6189::class),
                PersonFilterTest("personalData.email equals", bankUser, {dataForFilter},
                    { EMAIL.eq(it!!.personalData.email!!) }).withId(T6190::class),
                PersonFilterTest("personalData.email equals", bankUser, {dataForFilter},
                    { EMAIL.contains(it!!.personalData.email!!.randomSubstringPf()) }).withId(T6191::class),
                PersonFilterTest("personalData.sex equals", bankUser, {dataForFilter},
                    { SEX.eq(it!!.personalData.sex!!) }).withId(T6192::class),
                PersonFilterTest("personalData.birthdate equals", bankUser, {dataForFilter},
                    { BIRTHDATE.eq(it!!.personalData.birthdate!!) }).withId(T6193::class),
                PersonFilterTest("description equals", bankUser, {dataForFilter},
                    { DESCRIPTION.eq(it!!.description!!) }).withId(T6194::class),
                PersonFilterTest("description equals", bankUser, {dataForFilter},
                    { DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T6195::class),
                PersonFilterTest("category equals", bankUser, {dataForFilter},
                    { CATEGORY.eq(it!!.category!!) }).withId(T6196::class),
                PersonFilterTest("isConfirmedEmail equals", bankUser, {dataForFilter},
                    { EMAIL_CONFIRMED.eq(it!!.confirmedEmail) }).withId(T6197::class),
                PersonFilterTest("isConfirmedMobilePhone equals", bankUser, {dataForFilter},
                    { PHONE_CONFIRMED.eq(it!!.confirmedMobilePhone) }).withId(T6198::class)
            )
        )
    }
}