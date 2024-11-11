package ooo.jtc.api.rolemodel.product

import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.generic.RoleModelNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.rolemodel.product.ProductDto
import ooo.jtc.testdata.rolemodel.product.ProductData
import ooo.jtc.testdata.rolemodel.product.ProductFilterParams
import ooo.jtc.testdata.rolemodel.product.ProductSortingParams

//@formatter:off
private const val baseFolder = "${FolderPrefix.DICTIONARY}\"${RoleModelNames.PRODUCT}\" (product)"

@Folder("$baseFolder/${SubFolder.CRUD}")
annotation class ProductCrud

//Khatmullin [2021.08.13]: Только чтение https://confluence.jtc.ooo/pages/viewpage.action?pageId=31262632
@Folder("${baseFolder}/${SubFolder.FILTRATION}")
annotation class ProductFilter

@Folder("${baseFolder}/${SubFolder.SORTING}")
annotation class ProductSorting

private const val AT_STORY_ROLEMODEL_AN = "JTCSALTO-3914"   // > Аналитика (уточнение требований)
private const val AT_STORY_ROLEMODEL_AT = "JTCSALTO-3917"   // > Тестирование (автотесты)
private const val AT_STORY_ROLEMODEL_DEV = "JTCSALTO-3482"  // > Разработка бэк (по уточнённым требованиям)

@TaskIds([Tm4jStoryAT.AT_STORY_ROLEMODEL, AT_STORY_ROLEMODEL_AN, AT_STORY_ROLEMODEL_AT, AT_STORY_ROLEMODEL_DEV])
annotation class ProductTaskIdsCommon
//@formatter:on

@ProductTaskIdsCommon
@ProductCrud
@ComponentDictionary
@HighPriority
class ProductGetTest : GetTestTemplate<ProductDto>(
    preExecution = { ProductData.randomOrException().toDto() },
    steps = ProductSteps()
)

@ProductTaskIdsCommon
@ProductCrud
@ComponentDictionary
@HighPriority
class ProductGetPageTest :
    GetPageTestTemplate<ProductDto>(
        steps = ProductSteps()
    )

@ProductTaskIdsCommon
@ProductSorting
@ComponentDictionary
@NormalPriority
class ProductSortingTest(sortRequestFunction: () -> List<Sort>) :
    SortingTestTemplate<ProductDto, ProductSortingParams, Any>(
        sortList = sortRequestFunction.invoke(),
        steps = ProductSteps(),
        clazz = ProductSortingParams::class.java
    )

@ProductTaskIdsCommon
@ProductFilter
@ComponentDictionary
@NormalPriority
class ProductFilterTest(
    name: String,
    preExecution: (() -> ProductDto),
    filterRequestFunction: (ProductDto?) -> FilterData
) : FiltrationTestTemplate<ProductDto, ProductFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = ProductSteps(),
    clazz = ProductFilterParams::class.java,
    preExecution = preExecution
)