package ooo.jtc.api.dictionaries.timezone

import ooo.jtc.api.common.templates.entity.CreateTestTemplate
import ooo.jtc.api.common.templates.entity.DeleteTestTemplate
import ooo.jtc.api.common.templates.entity.FiltrationTestTemplate
import ooo.jtc.api.common.templates.entity.GetPageTestTemplate
import ooo.jtc.api.common.templates.entity.GetTestTemplate
import ooo.jtc.api.common.templates.entity.SortingTestTemplate
import ooo.jtc.api.common.templates.entity.UpdateTestTemplate
import ooo.jtc.api.common.tests.UnitBeTest
import ooo.jtc.api.dictionaries.timezone.TimezonePrepareSteps.getTimezoneDtoForCreate
import ooo.jtc.api.dictionaries.timezone.TimezonePrepareSteps.getTimezoneDtoForUpdate
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.tm4j.ComponentDictionary
import ooo.jtc.core.tm4j.Folder
import ooo.jtc.core.tm4j.FolderPrefix
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.core.tm4j.LowPriority
import ooo.jtc.core.tm4j.NormalPriority
import ooo.jtc.core.tm4j.SubFolder
import ooo.jtc.core.tm4j.TaskIds
import ooo.jtc.core.tm4j.Tm4jEpic.EPIC_R_RKO_DICTIONARY
import ooo.jtc.core.tm4j.Tm4jStoryAT
import ooo.jtc.dictionaries.timezone.TimezoneDto
import ooo.jtc.generic.DictionaryNames
import ooo.jtc.generic.pageparams.FilterData
import ooo.jtc.generic.pageparams.Sort
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.timezone.TimezoneData
import ooo.jtc.testdata.dictionaries.timezone.TimezoneFilterParams
import ooo.jtc.testdata.dictionaries.timezone.TimezoneSortingParams
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers

//@formatter:off
private const val baseFolder ="${FolderPrefix.DICTIONARY} \"${DictionaryNames.TIME_ZONE}\" (timezone)"
@Folder("$baseFolder/${SubFolder.CRUD}")       annotation class TimezoneFolderCrud
@Folder("$baseFolder/${SubFolder.SORTING}")    annotation class TimezoneFolderSorting
@Folder("$baseFolder/${SubFolder.FILTRATION}") annotation class TimezoneFolderFiltration
@Folder("$baseFolder/${SubFolder.CONTROLS}")   annotation class TimezoneFolderControls
@Folder("$baseFolder/${SubFolder.OTHER}")      annotation class TimezoneFolderOther

@TaskIds([EPIC_R_RKO_DICTIONARY,"JTCSALTO-397",Tm4jStoryAT.AT_STORY_R_RKO_DICTIONARY,"JTCSALTO-1153"]) annotation class TimezoneTaskIdsCommon
//@formatter:on

@TimezoneTaskIdsCommon
@TimezoneFolderCrud
@ComponentDictionary
@HighPriority
class TimezoneCreateTest(user: User = Users.bankAdmin) :
    CreateTestTemplate<TimezoneDto>(
        preExecution = { getTimezoneDtoForCreate() },
        steps = TimezoneSteps(user)
    )

@TimezoneTaskIdsCommon
@TimezoneFolderCrud
@ComponentDictionary
@HighPriority
class TimezoneGetTest(user: User) :
    GetTestTemplate<TimezoneDto>(
        preExecution = { TimezoneData.randomOrException().toDto() },
        steps = TimezoneSteps(user)
    )

@TimezoneTaskIdsCommon
@TimezoneFolderCrud
@ComponentDictionary
@HighPriority
class TimezoneGetPageTest(user: User) :
    GetPageTestTemplate<TimezoneDto>(
        steps = TimezoneSteps(user)
    )

@TimezoneTaskIdsCommon
@TimezoneFolderCrud
@ComponentDictionary
@HighPriority
class TimezoneDeleteTest(user: User = Users.bankAdmin) :
    DeleteTestTemplate<TimezoneDto>(
        preExecution = {
            val createdResponse = TimezoneSteps(user).create(getTimezoneDtoForCreate())
            createdResponse.data!!
        },
        steps = TimezoneSteps(user)
    )

@TimezoneTaskIdsCommon
@TimezoneFolderCrud
@ComponentDictionary
@HighPriority
class TimezoneUpdateTest(user: User = Users.bankAdmin) :
    UpdateTestTemplate<TimezoneDto, TimezoneDto>(
        preExecution = {
            val createdDto = TimezoneSteps(user).create(getTimezoneDtoForCreate()).data!!
            getTimezoneDtoForUpdate(createdDto)
        },
        steps = TimezoneSteps(user)
    )


@TimezoneTaskIdsCommon
@TimezoneFolderSorting
@ComponentDictionary
@LowPriority
class TimezoneSortingTest(
    user: User,
    sortRequestFunction: () -> List<Sort>
) : SortingTestTemplate<TimezoneDto, TimezoneSortingParams, Any>(
    sortList = sortRequestFunction.invoke(),
    steps = TimezoneSteps(user),
    clazz = TimezoneSortingParams::class.java
)

@TimezoneTaskIdsCommon
@TimezoneFolderFiltration
@ComponentDictionary
@NormalPriority
class TimezoneFiltrationTest(
    name: String,
    user: User,
    preExecution: (() -> TimezoneDto)?,
    filterRequestFunction: (TimezoneDto?) -> FilterData
) : FiltrationTestTemplate<TimezoneDto, TimezoneFilterParams, Any>(
    name = name,
    filterRequestFunction = filterRequestFunction,
    steps = TimezoneSteps(user),
    clazz = TimezoneFilterParams::class.java,
    preExecution = preExecution
)

@TimezoneTaskIdsCommon
@TimezoneFolderOther
@ComponentDictionary
@NormalPriority
class TimezoneGetByNameTest(
    user: User,
    timeZone: TimezoneDto = TimezoneData.randomOrException().toDto()
) : UnitBeTest(
    name = "'${DictionaryNames.TIME_ZONE}'. Получение часового пояса по его наименованию [${user.userType}]",
    params = { mapOf(PARAM_USER  to user , "Таймзона" to timeZone) },
    testBody = {
        val response = TimezoneSteps(user).getTimezoneByName(timeZone.name)
        val actResult = response.data!!
        "Проверить, что в ответе вернулся часовой пояс с ожидаемым наименованием '${timeZone.name}'" {
            MatcherAssert.assertThat("Наименование отличается от ожидаемого", actResult.name, Matchers.equalTo(timeZone.name))
            MatcherAssert.assertThat("В ответе не та запись, что ожидается", actResult.id!!, Matchers.equalTo(timeZone.id!!))
        }
    }
)

@TimezoneTaskIdsCommon
@TimezoneFolderOther
@ComponentDictionary
@NormalPriority
class TimezoneGetByShiftTest(
    user: User,
    timeZone: TimezoneDto = TimezoneData.randomOrException().toDto()
) : UnitBeTest(
    name = "'${DictionaryNames.TIME_ZONE}'. Получение списка часовых поясов по сдвигу [${user.userType}]",
    params = { mapOf(PARAM_USER to user, "Таймзона" to timeZone) },
    testBody = {
        val response = TimezoneSteps(user).getTimezonesByShift(timeZone.shift)
        val actResult = response.list!!
        "Проверить, что в ответе вернулся часовой пояс с ожидаемым сдвигом '${timeZone.shift}'" {
            MatcherAssert.assertThat("Ответ пуст", response.list, Matchers.not(Matchers.empty()))
            val allExistingTimezones = TimezoneSteps(user).getPage().page!!
            val expResult = allExistingTimezones.filter { timeZone.shift == it.shift }
            MatcherAssert.assertThat("Количество часовых поясов не совпадает с ожидаемым", actResult.size, Matchers.equalTo(expResult.size))
            MatcherAssert.assertThat("Сдвиг отличается от ожидаемого", actResult, Matchers.contains(Matchers.hasProperty("name", Matchers.`is`(timeZone.name)))
            )
        }
    }
)