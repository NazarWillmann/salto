package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_CODEVO
import ooo.jtc.api.dictionaries.codevo.CodeVoControlTest
import ooo.jtc.api.dictionaries.codevo.CodeVoCreateTest
import ooo.jtc.api.dictionaries.codevo.CodeVoDeleteTest
import ooo.jtc.api.dictionaries.codevo.CodeVoFilterTests
import ooo.jtc.api.dictionaries.codevo.CodeVoGetPageTest
import ooo.jtc.api.dictionaries.codevo.CodeVoGetTest
import ooo.jtc.api.dictionaries.codevo.CodeVoPrepareSteps.getCodeVoDtoForCreate
import ooo.jtc.api.dictionaries.codevo.CodeVoSortingTest
import ooo.jtc.api.dictionaries.codevo.CodeVoUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.CONTROL_NOT_IMPLEMENTED
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.codevo.CodeVo
import ooo.jtc.dictionaries.codevo.CodeVoDto
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.codevo.CodeVoControls
import ooo.jtc.testdata.dictionaries.codevo.CodeVoData
import ooo.jtc.testdata.dictionaries.codevo.CodeVoFilterParams
import ooo.jtc.testdata.dictionaries.codevo.CodeVoSortingParams.CODE
import ooo.jtc.testdata.dictionaries.codevo.CodeVoSortingParams.DESCRIPTION
import ooo.jtc.testdata.dictionaries.codevo.CodeVoSortingParams.ID
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Disabled
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
@Story(DictionaryNames.CODE_VO)
@DisplayName("API '${DictionaryNames.CODE_VO}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_CODEVO
@TestInstance(PER_CLASS)
class CodeVoTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T1763") annotation class T1763
@Tag("JTCSALTO-T1765") annotation class T1765
@Tag("JTCSALTO-T1768") annotation class T1768
@Tag("JTCSALTO-T1769") annotation class T1769
@Tag("JTCSALTO-T1771") annotation class T1771
@Tag("JTCSALTO-T1773") annotation class T1773
@Tag("JTCSALTO-T1774") annotation class T1774
@Tag("JTCSALTO-T1775") annotation class T1775
@Tag("JTCSALTO-T1776") annotation class T1776
@Tag("JTCSALTO-T1777") annotation class T1777
@Tag("JTCSALTO-T1778") annotation class T1778
@Tag("JTCSALTO-T1779") annotation class T1779
@Tag("JTCSALTO-T1780") annotation class T1780
@Tag("JTCSALTO-T1781") annotation class T1781
@Tag("JTCSALTO-T1782") annotation class T1782
@Tag("JTCSALTO-T1783") annotation class T1783
@Tag("JTCSALTO-T1784") annotation class T1784
@Tag("JTCSALTO-T1785") annotation class T1785
@Tag("JTCSALTO-T1786") annotation class T1786
@Tag("JTCSALTO-T1787") annotation class T1787
@Tag("JTCSALTO-T1788") annotation class T1788
@Tag("JTCSALTO-T1789") annotation class T1789
@Tag("JTCSALTO-T1790") annotation class T1790
@Tag("JTCSALTO-T1791") annotation class T1791
@Tag("JTCSALTO-T1792") annotation class T1792
@Tag("JTCSALTO-T1793") annotation class T1793
@Tag("JTCSALTO-T1794") annotation class T1794
@Tag("JTCSALTO-T1795") annotation class T1795
@Tag("JTCSALTO-T1796") annotation class T1796
@Tag("JTCSALTO-T5308") annotation class T5308
@Tag("JTCSALTO-T5309") annotation class T5309
@Tag("JTCSALTO-T5310") annotation class T5310
@Tag("JTCSALTO-T5311") annotation class T5311
@Tag("JTCSALTO-T5312") annotation class T5312
@Tag("JTCSALTO-T5313") annotation class T5313
@Tag("JTCSALTO-T5314") annotation class T5314
@Tag("JTCSALTO-T5315") annotation class T5315
@Tag("JTCSALTO-T5316") annotation class T5316
//@formatter:on
//endregion

    private val clientUser = Users.client
    private val bankUser = Users.bankAdmin
    private lateinit var dataForFilter: CodeVoDto
    private lateinit var testDataScope: TestDataScope<CodeVo>

    @BeforeAll
    fun prepareTestData() {
        testDataScope = CodeVoData.withRequiredFields()
        dataForFilter = testDataScope.all.random().toDto()
    }

    @AfterAll
    fun cleanTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T1765 //'Код вида ВО'. CRUD: Получаем запись по id от пользователя [BANK]
    @T1768 //'Код вида ВО'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T1769 //'Код вида ВО'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T1771 //'Код вида ВО'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T1773 //'Код вида ВО'. CRUD: Обновляем запись от пользователя [BANK]
    @T1774 //'Код вида ВО'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun codeVoCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                CodeVoCreateTest().withId(T1763::class),
                CodeVoGetTest(user = clientUser).withId(T1768::class),
                CodeVoGetTest(user = bankUser).withId(T1765::class),
                CodeVoGetPageTest(user = clientUser).withId(T1769::class),
                CodeVoGetPageTest(user = bankUser).withId(T1771::class),
                CodeVoDeleteTest().withId(T1774::class),
                CodeVoUpdateTest().withId(T1773::class)
            )
        )
    }

    @TestFactory
    @T1775 //'Код вида ВО'. Сортировка по полю 'description, DESC' [CLIENT]
    @T1776 //'Код вида ВО'. Сортировка по полю 'description, ASC' [CLIENT]
    @T1777 //'Код вида ВО'. Сортировка по полю 'code, ASC' [CLIENT]
    @T1778 //'Код вида ВО'. Сортировка по полю 'code, DESC' [CLIENT]
    @T1779 //'Код вида ВО'. Сортировка по полю 'id, ASC' [CLIENT]
    @T1780 //'Код вида ВО'. Сортировка по полю 'id, DESC' [CLIENT]
    internal fun codeVoSortingClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                CodeVoSortingTest(user) { ID.asc() }.withId(T1779::class),
                CodeVoSortingTest(user) { CODE.asc() }.withId(T1777::class),
                CodeVoSortingTest(user) { DESCRIPTION.asc() }.withId(T1776::class),

                CodeVoSortingTest(user) { ID.desc() }.withId(T1780::class),
                CodeVoSortingTest(user) { CODE.desc() }.withId(T1778::class),
                CodeVoSortingTest(user) { DESCRIPTION.desc() }.withId(T1775::class)
            )
        )
    }

    @TestFactory
    @T1781 //'Код вида ВО'. Сортировка по полю 'id, ASC' [BANK]
    @T1782 //'Код вида ВО'. Сортировка по полю 'code, DESC' [BANK]
    @T1788 //'Код вида ВО'. Сортировка по полю 'description, DESC' [BANK]
    @T1793 //'Код вида ВО'. Сортировка по полю 'code, ASC' [BANK]
    @T1792 //'Код вида ВО'. Сортировка по полю 'description, ASC' [BANK]
    @T1795 //'Код вида ВО'. Сортировка по полю 'id, DESC' [BANK]
    internal fun codeVoSortingBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                CodeVoSortingTest(user, ID::asc).withId(T1781::class),
                CodeVoSortingTest(user, CODE::asc).withId(T1793::class),
                CodeVoSortingTest(user, DESCRIPTION::asc).withId(T1792::class),

                CodeVoSortingTest(user, ID::desc).withId(T1795::class),
                CodeVoSortingTest(user, CODE::desc).withId(T1782::class),
                CodeVoSortingTest(user, DESCRIPTION::desc).withId(T1788::class)
            )
        )
    }

    @TestFactory
    @T1783 //'Код вида ВО'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T1785 //'Код вида ВО'. Фильтрация по полю 'id' (eq) [CLIENT]
    @T1787 //'Код вида ВО'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T1789 //'Код вида ВО'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T1790 //'Код вида ВО'. Фильтрация по полю 'description' (eq) [CLIENT]
    internal fun codeVoFiltrationClientTests(): List<DynamicTest> {
        val user = clientUser
        return EntityTestGenerator.generate(
            listOf(
                CodeVoFilterTests("id equals", user, { dataForFilter },
                    { CodeVoFilterParams.ID.eq(it!!.id!!) }).withId(T1785::class),
                CodeVoFilterTests("code equals", user, { dataForFilter },
                    { CodeVoFilterParams.CODE.eq(it!!.code!!) }).withId(T1787::class),
                CodeVoFilterTests("code contains", user, { dataForFilter },
                    { CodeVoFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1789::class),
                CodeVoFilterTests("description equals", user, { dataForFilter },
                    { CodeVoFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1790::class),
                CodeVoFilterTests("description contains", user, { dataForFilter },
                    { CodeVoFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1783::class)
            )
        )
    }

    @TestFactory
    @T1786 //'Код вида ВО'. Фильтрация по полю 'id' (eq) [BANK]
    @T1791 //'Код вида ВО'. Фильтрация по полю 'code' (eq) [BANK]
    @T1796 //'Код вида ВО'. Фильтрация по полю 'code' (contains) [BANK]
    @T1794 //'Код вида ВО'. Фильтрация по полю 'description' (eq) [BANK]
    @T1784 //'Код вида ВО'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun codeVoFiltrationBankTests(): List<DynamicTest> {
        val user = bankUser
        return EntityTestGenerator.generate(
            listOf(
                CodeVoFilterTests("id equals", user, { dataForFilter },
                    { CodeVoFilterParams.ID.eq(it!!.id!!) }).withId(T1786::class),
                CodeVoFilterTests("code equals", user, { dataForFilter },
                    { CodeVoFilterParams.CODE.eq(it!!.code!!) }).withId(T1791::class),
                CodeVoFilterTests("code contains", user, { dataForFilter },
                    { CodeVoFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }).withId(T1796::class),
                CodeVoFilterTests("description equals", user, { dataForFilter },
                    { CodeVoFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T1794::class),
                CodeVoFilterTests("description contains", user, { dataForFilter },
                    { CodeVoFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }).withId(T1784::class)
            )
        )
    }

    @TestFactory
    @Disabled(CONTROL_NOT_IMPLEMENTED)
    @T5308 //'Код вида ВО'. Контроль: кода вида валютной операции на непустоту (null) [BANK]
    @T5309 //'Код вида ВО'. Контроль: кода вида валютной операции на непустоту (empty) [BANK]
    @T5310 //'Код вида ВО'. Контроль: кода вида валютной операции на непустоту (spaces) [BANK]
    @T5311 //'Код вида ВО'. Контроль: длины кода вида валютной операции (меньше требуемого значения) [BANK]
    @T5312 //'Код вида ВО'. Контроль: длины кода вида валютной операции (больше требуемого значения) [BANK]
    @T5313 //'Код вида ВО'. Контроль: кода вида валютной операции на допустимые символы [BANK]
    @T5314 //'Код вида ВО'. Контроль: описания кода вида валютной операции на непустоту (null) [BANK]
    @T5315 //'Код вида ВО'. Контроль: описания кода вида валютной операции на непустоту (empty) [BANK]
    @T5316 //'Код вида ВО'. Контроль: описания кода вида валютной операции на непустоту (spaces) [BANK]
    internal fun codeVoControlTests(): List<DynamicTest> {
        val getDto = { getCodeVoDtoForCreate() }
        return EntityTestGenerator.generate(
            listOf(
                CodeVoControlTest(
                    testName = "кода вида валютной операции на непустоту (null)",
                    preExecution = { getDto.invoke().copy(code = null) },
                    control = CodeVoControls.CODE_EMPTY
                ).withId(T5308::class),
                CodeVoControlTest(
                    testName = "кода вида валютной операции на непустоту (empty)",
                    preExecution = { getDto.invoke().copy(code = "") },
                    control = CodeVoControls.CODE_EMPTY
                ).withId(T5309::class),
                CodeVoControlTest(
                    testName = "кода вида валютной операции на непустоту (spaces)",
                    preExecution = { getDto.invoke().copy(code = "    ") },
                    control = CodeVoControls.CODE_EMPTY
                ).withId(T5310::class),
                CodeVoControlTest(
                    testName = "длины кода вида валютной операции (меньше требуемого значения)",
                    preExecution = { getDto.invoke().copy(code = digits.random(1, 4)) },
                    control = CodeVoControls.CODE_MAX_LENGTH.withParams("length" to "5")
                ).withId(T5311::class),
                CodeVoControlTest(
                    testName = "длины кода вида валютной операции (больше требуемого значения)",
                    preExecution = { getDto.invoke().copy(code = digits.random(6, 20)) },
                    control = CodeVoControls.CODE_MAX_LENGTH.withParams("length" to "5")
                ).withId(T5312::class),
                CodeVoControlTest(
                    testName = "кода вида валютной операции на допустимые символы",
                    preExecution = { getDto.invoke().copy(code = "G1Я!") },
                    control = CodeVoControls.CODE_AVAILABLE_SYMBOLS.withParams("symbols" to "G;Я;!")
                ).withId(T5313::class),

                CodeVoControlTest(
                    testName = "описания кода вида валютной операции на непустоту (null)",
                    preExecution = { getDto.invoke().copy(description = null) },
                    control = CodeVoControls.DESCRIPTION_EMPTY
                ).withId(T5314::class),
                CodeVoControlTest(
                    testName = "описания кода вида валютной операции на непустоту (empty)",
                    preExecution = { getDto.invoke().copy(description = "") },
                    control = CodeVoControls.DESCRIPTION_EMPTY
                ).withId(T5315::class),
                CodeVoControlTest(
                    testName = "описания кода вида валютной операции на непустоту (spaces)",
                    preExecution = { getDto.invoke().copy(description = "    ") },
                    control = CodeVoControls.DESCRIPTION_EMPTY
                ).withId(T5316::class)
            )
        )
    }
}