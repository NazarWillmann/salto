package ooo.jtc.be.rolemodel

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Issue
import io.qameta.allure.Story
import ooo.jtc.BE_ROLEMODEL_PRODUCT
import ooo.jtc.api.rolemodel.product.ProductFilterTest
import ooo.jtc.api.rolemodel.product.ProductGetPageTest
import ooo.jtc.api.rolemodel.product.ProductGetTest
import ooo.jtc.api.rolemodel.product.ProductSortingTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.testdata.rolemodel.product.ProductData
import ooo.jtc.testdata.rolemodel.product.ProductFilterParams
import ooo.jtc.testdata.rolemodel.product.ProductSortingParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.ROLE_MODEL)
@Story(RoleModelNames.PRODUCT)
@DisplayName("API '${RoleModelNames.PRODUCT}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_ROLEMODEL_PRODUCT
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Issue(Issues.JTCSALTO_4386)
class ProductTestsSuite {
    //region Tags
//@formatter:off
    @Tag("JTCSALTO-T6014") annotation class T6014
    @Tag("JTCSALTO-T6015") annotation class T6015
    @Tag("JTCSALTO-T6080") annotation class T6080
    @Tag("JTCSALTO-T6081") annotation class T6081
    @Tag("JTCSALTO-T6082") annotation class T6082
    @Tag("JTCSALTO-T6083") annotation class T6083
    @Tag("JTCSALTO-T6084") annotation class T6084
    @Tag("JTCSALTO-T6085") annotation class T6085
    @Tag("JTCSALTO-T6086") annotation class T6086
    @Tag("JTCSALTO-T6087") annotation class T6087
    @Tag("JTCSALTO-T6088") annotation class T6088
    @Tag("JTCSALTO-T6089") annotation class T6089
    @Tag("JTCSALTO-T6090") annotation class T6090
    @Tag("JTCSALTO-T6091") annotation class T6091
    @Tag("JTCSALTO-T6092") annotation class T6092
    @Tag("JTCSALTO-T6124") annotation class T6124
    @Tag("JTCSALTO-T6125") annotation class T6125
//@formatter:on
//endregion

    @T6014 //'Продукт/Сервис Системы'. CRUD: Получаем запись по id от пользователя [BANK]
    @T6015 //'Продукт/Сервис Системы'. CRUD: Получаем страницу записей от пользователя [BANK]
    @TestFactory
    internal fun productReadTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ProductGetTest().withId(T6014::class),
                ProductGetPageTest().withId(T6015::class)
            )
        )
    }

    private val dataForFilter by lazy { ProductData.randomOrException().toDto() }

    @TestFactory
    @T6088 //'Продукт/Сервис Системы'. Фильтрация по полю 'description' (eq) [BANK]
    @T6091 //'Продукт/Сервис Системы'. Фильтрация по полю 'description' (contains) [BANK]
    @T6089 //'Продукт/Сервис Системы'. Фильтрация по полю 'id' (eq) [BANK]
    @T6092 //'Продукт/Сервис Системы'. Фильтрация по полю 'uiName' (contains) [BANK]
    @T6090 //'Продукт/Сервис Системы'. Фильтрация по полю 'name' (contains) [BANK]
    @T6124 //'Продукт/Сервис Системы'. Фильтрация по полю 'name' (eq) [BANK]
    @T6125 //'Продукт/Сервис Системы'. Фильтрация по полю 'uiName' (eq) [BANK]
    internal fun productFilterTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ProductFilterTest("id equals", { dataForFilter },
                    { ProductFilterParams.ID.eq(it!!.id!!) }).withId(T6089::class),
                ProductFilterTest("description equals", { dataForFilter },
                    { ProductFilterParams.DESCRIPTION.eq(it!!.description!!) }).withId(T6088::class),
                ProductFilterTest("description contains", { dataForFilter },
                    { ProductFilterParams.DESCRIPTION.contains(it!!.description!!) }).withId(T6091::class),
                ProductFilterTest("name contains", { dataForFilter },
                    { ProductFilterParams.NAME.contains(it!!.name) }).withId(T6090::class),
                ProductFilterTest("uiName contains", { dataForFilter },
                    { ProductFilterParams.UI_NAME.contains(it!!.uiName) }).withId(T6092::class),
                ProductFilterTest("name equals", { dataForFilter },
                    { ProductFilterParams.NAME.eq(it!!.name) }).withId(T6124::class),
                ProductFilterTest("uiName equals", { dataForFilter },
                    { ProductFilterParams.UI_NAME.eq(it!!.uiName) }).withId(T6125::class)
            )
        )
    }

    @TestFactory
    @T6080 //'Продукт/Сервис Системы'. Сортировка по полю 'description, ASC' [BANK]
    @T6084 //'Продукт/Сервис Системы'. Сортировка по полю 'id, DESC' [BANK]
    @T6082 //'Продукт/Сервис Системы'. Сортировка по полю 'uiName, ASC' [BANK]
    @T6083 //'Продукт/Сервис Системы'. Сортировка по полю 'name, ASC' [BANK]
    @T6085 //'Продукт/Сервис Системы'. Сортировка по полю 'id, ASC' [BANK]
    @T6081 //'Продукт/Сервис Системы'. Сортировка по полю 'description, DESC' [BANK]
    @T6087 //'Продукт/Сервис Системы'. Сортировка по полю 'name, DESC' [BANK]
    @T6086 //'Продукт/Сервис Системы'. Сортировка по полю 'uiName, DESC' [BANK]
    internal fun productSortingTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ProductSortingTest(ProductSortingParams.ID::asc).withId(T6085::class),
                ProductSortingTest(ProductSortingParams.DESCRIPTION::asc).withId(T6080::class),
                ProductSortingTest(ProductSortingParams.NAME::asc).withId(T6083::class),
                ProductSortingTest(ProductSortingParams.UI_NAME::asc).withId(T6082::class),
                ProductSortingTest(ProductSortingParams.ID::desc).withId(T6084::class),
                ProductSortingTest(ProductSortingParams.DESCRIPTION::desc).withId(T6081::class),
                ProductSortingTest(ProductSortingParams.NAME::desc).withId(T6087::class),
                ProductSortingTest(ProductSortingParams.UI_NAME::desc).withId(T6086::class)
            )
        )
    }
}