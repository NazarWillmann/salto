package ooo.jtc.be.dictionaries

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_DICTIONARY_TRANSFER_TERM
import ooo.jtc.api.dictionaries.transferterm.TransferTermControlTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermCreateTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermDefaultsTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermDeleteTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermFiltrationTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermGetPageTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermGetTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermPrepareSteps.generateWithPrefix
import ooo.jtc.api.dictionaries.transferterm.TransferTermPrepareSteps.getTransferTermDtoForCreate
import ooo.jtc.api.dictionaries.transferterm.TransferTermSortingTest
import ooo.jtc.api.dictionaries.transferterm.TransferTermSteps
import ooo.jtc.api.dictionaries.transferterm.TransferTermUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestConstants.AT_PREFIX_RUS
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_EXPECT
import ooo.jtc.core.TestConstants.CONTROL_INVALID_CHARS_REQUEST
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.dictionaries.transferterm.TransferTerm
import ooo.jtc.extensions.randomSubstringPf
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.random.RandomData
import ooo.jtc.testdata.Users.bankAdmin
import ooo.jtc.testdata.Users.client
import ooo.jtc.testdata.common.TestDataScope
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.CODE_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.CODE_MAX_LENGTH
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.CODE_NOT_EMPTY
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.DESCRIPTION_ALLOWED_SYMBOLS
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.DESCRIPTION_MAX_LENGTH
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.DESCRIPTION_NOT_EMPTY
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermControls.TRANSFER_TERM_UNIQUE
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermData
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermFilterParams
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermSortingParams.CODE
import ooo.jtc.testdata.dictionaries.transferterm.TransferTermSortingParams.DESCRIPTION
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
@Story(DictionaryNames.TRANSFER_TERM)
@DisplayName("API '${DictionaryNames.TRANSFER_TERM}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_DICTIONARY_TRANSFER_TERM
@TestInstance(PER_CLASS)
class TransferTermTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T6615") annotation class T6615
@Tag("JTCSALTO-T6616") annotation class T6616
@Tag("JTCSALTO-T6617") annotation class T6617
@Tag("JTCSALTO-T6618") annotation class T6618
@Tag("JTCSALTO-T6619") annotation class T6619
@Tag("JTCSALTO-T6620") annotation class T6620
@Tag("JTCSALTO-T6621") annotation class T6621
@Tag("JTCSALTO-T6622") annotation class T6622
@Tag("JTCSALTO-T6623") annotation class T6623
@Tag("JTCSALTO-T6624") annotation class T6624
@Tag("JTCSALTO-T6625") annotation class T6625
@Tag("JTCSALTO-T6626") annotation class T6626
@Tag("JTCSALTO-T6627") annotation class T6627
@Tag("JTCSALTO-T6628") annotation class T6628
@Tag("JTCSALTO-T6629") annotation class T6629
@Tag("JTCSALTO-T6630") annotation class T6630
@Tag("JTCSALTO-T6631") annotation class T6631
@Tag("JTCSALTO-T6632") annotation class T6632
@Tag("JTCSALTO-T6633") annotation class T6633
@Tag("JTCSALTO-T6634") annotation class T6634
@Tag("JTCSALTO-T6635") annotation class T6635
@Tag("JTCSALTO-T6636") annotation class T6636
@Tag("JTCSALTO-T6637") annotation class T6637
@Tag("JTCSALTO-T6638") annotation class T6638
@Tag("JTCSALTO-T6639") annotation class T6639
@Tag("JTCSALTO-T6640") annotation class T6640
@Tag("JTCSALTO-T6641") annotation class T6641
@Tag("JTCSALTO-T6642") annotation class T6642
@Tag("JTCSALTO-T6643") annotation class T6643
@Tag("JTCSALTO-T6685") annotation class T6685
@Tag("JTCSALTO-T6686") annotation class T6686
@Tag("JTCSALTO-T6687") annotation class T6687
@Tag("JTCSALTO-T6688") annotation class T6688
@Tag("JTCSALTO-T6689") annotation class T6689
@Tag("JTCSALTO-T6857") annotation class T6857
//@formatter:on
//endregion


    private lateinit var testDataScope: TestDataScope<TransferTerm>

    @BeforeAll
    fun prepareTransferTermTestData() {
        TransferTermData.cleanAtCreated()
        testDataScope = TransferTermData.withRequiredFields(requiredDataCount = 6)
    }

    @AfterAll
    fun cleanTransferTermTestData() {
        testDataScope.removeGenerated()
    }

    @TestFactory
    @T6637 //'Условие перевода'. CRUD: Создаем запись от пользователя [BANK]
    @T6638 //'Условие перевода'. CRUD: Получаем запись по id от пользователя [CLIENT]
    @T6639 //'Условие перевода'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6640 //'Условие перевода'. CRUD: Получаем страницу записей от пользователя [CLIENT]
    @T6641 //'Условие перевода'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T6642 //'Условие перевода'. CRUD: Обновляем запись от пользователя [BANK]
    @T6643 //'Условие перевода'. CRUD: Удаляем запись от пользователя [BANK]
    internal fun transferTermCrudTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TransferTermCreateTest(user = bankAdmin).withId(T6637::class),
                TransferTermGetTest(user = client).withId(T6638::class),
                TransferTermGetTest(user = bankAdmin).withId(T6639::class),
                TransferTermGetPageTest(user = client).withId(T6640::class),
                TransferTermGetPageTest(user = bankAdmin).withId(T6641::class),
                TransferTermUpdateTest(user = bankAdmin).withId(T6642::class),
                TransferTermDeleteTest(user = bankAdmin).withId(T6643::class)
            )
        )
    }

    @TestFactory
    @T6685 //'Условие перевода'. Контроль: кода на непустоту (null) [BANK]
    @T6686 //'Условие перевода'. Контроль: кода на непустоту (пустая строка) [BANK]
    @T6687 //'Условие перевода'. Контроль: кода на непустоту (пробельные символы) [BANK]
    @T6623 //'Условие перевода'. Контроль: длины кода [BANK]
    @T6624 //'Условие перевода'. Контроль: кода на допустимые символы [BANK]
    @T6625 //'Условие перевода'. Контроль: описания на непустоту (null) [BANK]
    @T6688 //'Условие перевода'. Контроль: описания на непустоту (пустая строка) [BANK]
    @T6689 //'Условие перевода'. Контроль: описания на непустоту (пробельные символы) [BANK]
    @T6626 //'Условие перевода'. Контроль: длины описания [BANK]
    @T6627 //'Условие перевода'. Контроль: описания на допустимые символы [BANK]
    @T6628 //'Условие перевода'. Контроль: уникальности записи [BANK]
    internal fun transferTermControlTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TransferTermControlTest(
                    testName = "кода на непустоту (null)",
                    preExecution = { getTransferTermDtoForCreate().apply { code = null } },
                    control = CODE_NOT_EMPTY
                ).withId(T6685::class),
                TransferTermControlTest(
                    testName = "кода на непустоту (пустая строка)",
                    preExecution = { getTransferTermDtoForCreate().apply { code = "" } },
                    control = CODE_NOT_EMPTY
                ).withId(T6686::class),
                TransferTermControlTest(
                    testName = "кода на непустоту (пробельные символы)",
                    preExecution = { getTransferTermDtoForCreate().apply { code = RandomData.getEmptyString(length = 5) } },
                    control = CODE_NOT_EMPTY
                ).withId(T6687::class),
                TransferTermControlTest(
                    testName = "длины кода",
                    preExecution = { getTransferTermDtoForCreate().apply { code = generateWithPrefix(length = 36) } },
                    control = CODE_MAX_LENGTH
                ).withId(T6623::class),
                TransferTermControlTest(
                    testName = "кода на допустимые символы",
                    preExecution = { getTransferTermDtoForCreate().apply { code = AT_PREFIX_RUS + CONTROL_INVALID_CHARS_REQUEST } },
                    control = CODE_ALLOWED_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T6624::class),
                TransferTermControlTest(
                    testName = "описания на непустоту (null)",
                    preExecution = { getTransferTermDtoForCreate().apply { description = null } },
                    control = DESCRIPTION_NOT_EMPTY
                ).withId(T6625::class),
                TransferTermControlTest(
                    testName = "описания на непустоту (пустая строка)",
                    preExecution = { getTransferTermDtoForCreate().apply { description = "" } },
                    control = DESCRIPTION_NOT_EMPTY
                ).withId(T6688::class),
                TransferTermControlTest(
                    testName = "описания на непустоту (пробельные символы)",
                    preExecution = { getTransferTermDtoForCreate().apply { description = RandomData.getEmptyString(length = 5) } },
                    control = DESCRIPTION_NOT_EMPTY
                ).withId(T6689::class),
                TransferTermControlTest(
                    testName = "длины описания",
                    preExecution = { getTransferTermDtoForCreate().apply { description = generateWithPrefix(length = 256) } },
                    control = DESCRIPTION_MAX_LENGTH
                ).withId(T6626::class),
                TransferTermControlTest(
                    testName = "описания на допустимые символы",
                    preExecution = { getTransferTermDtoForCreate().apply { description = AT_PREFIX_RUS + CONTROL_INVALID_CHARS_REQUEST } },
                    control = DESCRIPTION_ALLOWED_SYMBOLS.withParams("symbols" to CONTROL_INVALID_CHARS_EXPECT)
                ).withId(T6627::class),
                TransferTermControlTest(
                    testName = "уникальности записи",
                    preExecution = {
                        val existingTransferTerm = testDataScope.all.last().toDto()
                        existingTransferTerm.id = null
                        existingTransferTerm.version = 0
                        existingTransferTerm
                    },
                    control = TRANSFER_TERM_UNIQUE
                ).withId(T6628::class)
            )
        )
    }

    @TestFactory
    @T6629 //'Условие перевода'. Сортировка по полю 'code, ASC' [CLIENT]
    @T6630 //'Условие перевода'. Сортировка по полю 'code, DESC' [CLIENT]
    @T6631 //'Условие перевода'. Сортировка по полю 'description, ASC' [CLIENT]
    @T6632 //'Условие перевода'. Сортировка по полю 'description, DESC' [CLIENT]
    @T6633 //'Условие перевода'. Сортировка по полю 'code, ASC' [BANK]
    @T6634 //'Условие перевода'. Сортировка по полю 'code, DESC' [BANK]
    @T6635 //'Условие перевода'. Сортировка по полю 'description, ASC' [BANK]
    @T6636 //'Условие перевода'. Сортировка по полю 'description, DESC' [BANK]
    internal fun transferTermSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TransferTermSortingTest(user = client, sortRequestFunction = CODE::asc).withId(T6629::class),
                TransferTermSortingTest(user = client, sortRequestFunction = CODE::desc).withId(T6630::class),
                TransferTermSortingTest(user = client, sortRequestFunction = DESCRIPTION::asc).withId(T6631::class),
                TransferTermSortingTest(user = client, sortRequestFunction = DESCRIPTION::desc).withId(T6632::class),
                TransferTermSortingTest(user = bankAdmin, sortRequestFunction = CODE::asc).withId(T6633::class),
                TransferTermSortingTest(user = bankAdmin, sortRequestFunction = CODE::desc).withId(T6634::class),
                TransferTermSortingTest(user = bankAdmin, sortRequestFunction = DESCRIPTION::asc).withId(T6635::class),
                TransferTermSortingTest(user = bankAdmin, sortRequestFunction = DESCRIPTION::desc).withId(T6636::class)
            )
        )
    }

    @TestFactory
    @T6615 //'Условие перевода'. Фильтрация по полю 'code' (eq) [CLIENT]
    @T6616 //'Условие перевода'. Фильтрация по полю 'code' (contains) [CLIENT]
    @T6617 //'Условие перевода'. Фильтрация по полю 'description' (eq) [CLIENT]
    @T6618 //'Условие перевода'. Фильтрация по полю 'description' (contains) [CLIENT]
    @T6619 //'Условие перевода'. Фильтрация по полю 'code' (eq) [BANK]
    @T6620 //'Условие перевода'. Фильтрация по полю 'code' (contains) [BANK]
    @T6621 //'Условие перевода'. Фильтрация по полю 'description' (eq) [BANK]
    @T6622 //'Условие перевода'. Фильтрация по полю 'description' (contains) [BANK]
    internal fun transferTermFiltrationTests(): List<DynamicTest> {
        val dataForFilter = testDataScope.all.random().toDto()
        return EntityTestGenerator.generate(
            listOf(
                TransferTermFiltrationTest(
                    name = "code equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.CODE.eq(it!!.code!!) }
                ).withId(T6615::class),
                TransferTermFiltrationTest(
                    name = "code contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }
                ).withId(T6616::class),
                TransferTermFiltrationTest(
                    name = "description equals",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.DESCRIPTION.eq(it!!.description!!) }
                ).withId(T6617::class),
                TransferTermFiltrationTest(
                    name = "description contains",
                    user = client,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }
                ).withId(T6618::class),
                TransferTermFiltrationTest(
                    name = "code equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.CODE.eq(it!!.code!!) }
                ).withId(T6619::class),
                TransferTermFiltrationTest(
                    name = "code contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.CODE.contains(it!!.code!!.randomSubstringPf()) }
                ).withId(T6620::class),
                TransferTermFiltrationTest(
                    name = "description equals",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.DESCRIPTION.eq(it!!.description!!) }
                ).withId(T6621::class),
                TransferTermFiltrationTest(
                    name = "description contains",
                    user = bankAdmin,
                    filterDto = dataForFilter,
                    filterRequestFunction = { TransferTermFilterParams.DESCRIPTION.contains(it!!.description!!.randomSubstringPf()) }
                ).withId(T6622::class)
            )
        )
    }

    @TestFactory
    @T6857 //'Условие перевода'. Наполнение
    internal fun transferTermDefaultsTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                TransferTermDefaultsTest(
                    testBody = {
                        val actualEntities = testDataScope.consumed
                        val expectedEntities = getExpectedDefaultEntities()
                        expectedEntities.forEach { expectedEntity ->
                            try {
                                val actualEntity = actualEntities.first { it.code == expectedEntity.code }
                                TransferTermSteps.checkDefaultEntity(actualEntity, expectedEntity)
                            } catch (e: NoSuchElementException) {
                                throw RuntimeException("Условие перевода со следующим кодом не найдено: '${expectedEntity.code}'")
                            }
                        }
                    }
                ).withId(T6857::class)
            )
        )
    }

    private fun getExpectedDefaultEntities(): List<TransferTerm> {
        return listOf(
            TransferTerm(code = "A1", description = "Приоритетный платеж"),
            TransferTerm(code = "A2", description = "Платеж в счет кредитных средств"),
            TransferTerm(code = "A3", description = "Платеж по оплате кредита"),
            TransferTerm(code = "R1", description = "Перечисление в рамках услуги «Материальный пулинг»"),
            TransferTerm(code = "R2", description = "Перевод рублей во внеоперационное время")
        )
    }
}