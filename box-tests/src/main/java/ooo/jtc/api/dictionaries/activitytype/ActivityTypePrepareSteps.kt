package ooo.jtc.api.dictionaries.activitytype

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants.AT_POSTFIX_RUS_PARENTHESES
import ooo.jtc.dictionaries.activitytype.ActivityTypeDto
import ooo.jtc.random.RandomData
import ooo.jtc.random.RandomData.Companion.digits
import ooo.jtc.testdata.common.get
import ooo.jtc.testdata.dictionaries.activitytype.ActivityTypeData
import ooo.jtc.testdata.dictionaries.activitytype.FindActivityTypeBy

object ActivityTypePrepareSteps {

    @Step("Удалить созданные автотестами данные ActivityType из БД")
    fun cleanAtCreated() {
        FindActivityTypeBy.AT_CREATED.get().forEach { actType ->
            ActivityTypeData.removeRecord?.let { it(actType) }
        }
    }

    fun getActivityTypeDtoForCreate() = ActivityTypeDto(
        id = null,
        version = 0,
        code = digits.random(5, 5),
        description = RandomData("[а-яА-Я0-9 ]*").random(20, 3899).trim() + AT_POSTFIX_RUS_PARENTHESES
    )

    fun getActivityTypeDtoForUpdate(createdDto: ActivityTypeDto) =
        ActivityTypeDto(
            createdDto.id, createdDto.version,
            code = digits.random(5, 5),
            description = "Обновл. ${createdDto.description}"
        )
}