@file:Suppress("ClassName")

package ooo.jtc.api.news.publication

import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.news.PublicationTaskIdsLifecycle
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.kexensions.checkIsBankUser
import ooo.jtc.core.tm4j.ComponentNews
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.generic.DocumentNames
import ooo.jtc.interfaces.getOrException
import ooo.jtc.news.PublicationStatus.AUTO_FINISHED
import ooo.jtc.news.PublicationStatus.AUTO_FINISH_ERROR
import ooo.jtc.news.PublicationStatus.AUTO_POSTED
import ooo.jtc.news.PublicationStatus.AUTO_POST_ERROR
import ooo.jtc.news.PublicationStatus.DRAFT
import ooo.jtc.news.PublicationStatus.MANUALLY_FINISHED
import ooo.jtc.news.PublicationStatus.MANUALLY_POSTED
import ooo.jtc.news.PublicationStatus.NEW
import ooo.jtc.news.PublicationStatus.WAITING_FOR_AUTO_POST
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import java.time.ZonedDateTime

private val docChecks = ApiDocumentChecks<PublicationDto>()
private const val ERROR_MSG_GET_BY_ID = "Ошибка при получении"

//TODO Sergeyev [2020.12.07]: !!! retroactive annotations
@PublicationTaskIdsLifecycle
@PublicationFolderLifecycle
@ComponentNews
@HighPriority
open class PublicationLifecycleTest(
    bankUser: User,
    statusTransition: String,
    preExecution: (() -> PublicationDto),
    testBody: (PublicationDto?) -> Unit
) : AbstractBeTest<PublicationDto, Unit>(
    name = "'${DocumentNames.PUBLICATION}'. Жизненный цикл. Проверка перехода $statusTransition [${bankUser.userType}]",
    preExecution = preExecution,
    params = { mapOf(PARAM_USER to bankUser, "'${DocumentNames.PUBLICATION}' в исходном статусе" to it!!) },
    testBody = testBody
)


class PblLifecycleTest_None2Draft(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "none -> DRAFT",
    preExecution = { PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!
        val response = PublicationSteps(bankUser).createWithoutCheck(documentDto)
        val actResult = response.data.getOrException()

        actResult.id.assertIsNotEmpty()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(DRAFT.statusBank)
        )
    }
)

class PblLifecycleTest_None2New(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "none -> NEW",
    preExecution = { PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!
        val response = PublicationSteps(bankUser).create(documentDto)
        val actResult = response.data.getOrException()

        actResult.id.assertIsNotEmpty()
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(NEW.statusBank)
        )
    }
)

class PblLifecycleTest_Draft2New(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "DRAFT -> NEW",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = DRAFT) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!
        val response = PublicationSteps(bankUser).update(documentDto)
        val actResult = response.data.getOrException()

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(NEW.statusBank)
        )
    }
)

class PblLifecycleTest_Draft2Draft(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "DRAFT -> DRAFT",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = DRAFT) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!
        val response = PublicationSteps(bankUser).updateWithoutCheck(documentDto)
        val actResult = response.data.getOrException()

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(DRAFT.statusBank)
        )
    }
)

class PblLifecycleTest_New2Draft(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "NEW -> DRAFT",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = NEW) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.apply { documentNumber = "" }
        val response = PublicationSteps(bankUser).update(documentDto)
        val actResult = response.data.getOrException()

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(DRAFT.statusBank)
        )
    }
)

class PblLifecycleTest_New2New(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "NEW -> NEW",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = NEW) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!
        val response = PublicationSteps(bankUser).update(documentDto)
        val actResult = response.data.getOrException()

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(NEW.statusBank)
        )
    }
)

class PblLifecycleTest_New2ManuallyPosted(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "NEW -> MANUALLY_POSTED",
    preExecution = {
        val prepDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser).apply { startAt = null }
        PublicationPrepareSteps.createPublicationInStatus(bankUser, status = NEW, dtoForCreate = prepDto)
    },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()
        val actResult = PublicationSteps(bankUser).postSingle(documentDto.id!!)

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(MANUALLY_POSTED.statusBank)
        )
    }
)

class PblLifecycleTest_New2WaitingForAutoPost(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "NEW -> WAITING_FOR_AUTO_POST",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = NEW) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()
        val actResult = PublicationSteps(bankUser).postSingle(documentDto.id!!)

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(WAITING_FOR_AUTO_POST.statusBank)
        )
    }
)

class PblLifecycleTest_ManuallyPosted2ManuallyFinished(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "MANUALLY_POSTED -> MANUALLY_FINISHED",
    preExecution = {
        val prepDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser).apply { startAt = null }
        PublicationPrepareSteps.createPublicationInStatus(bankUser, status = MANUALLY_POSTED, dtoForCreate = prepDto)
    },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()
        val actResult = PublicationSteps(bankUser).finishPostSingle(documentDto.id!!)

        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(MANUALLY_FINISHED.statusBank)
        )
    }
)

class PblLifecycleTest_WaitingForAutoPost2AutoPosted(bankUser: User, secondsBeforePosting: Long) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "WAITING_FOR_AUTO_POST -> AUTO_POSTED",
    preExecution = {
        PublicationPrepareSteps.createWaitingForAutoPostPublication(
            creatorBankUser = bankUser,
            receiverClientUser = Users.client,
            seconds = secondsBeforePosting
        )
    },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        Thread.sleep(1000 * secondsBeforePosting)
        val steps = PublicationSteps(bankUser)
        docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { steps.getById(documentDto.id!!).data.getOrException(ERROR_MSG_GET_BY_ID) },
            repeatLimitSec = secondsBeforePosting,
            preparedDto = documentDto,
            expStatuses = listOf(AUTO_POSTED.statusBank)
        )
    }
)

class PblLifecycleTest_WaitingForAutoPost2New(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "WAITING_FOR_AUTO_POST -> NEW",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = WAITING_FOR_AUTO_POST) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        val actResult = PublicationSteps(bankUser).cancelPostSingle(documentDto.id!!)
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(NEW.statusBank)
        )
    }
)

@Deprecated("Настройка 'Минимальная длительность размещения публикации' по умолчанию составляет 24 часа.")
class PblLifecycleTest_AutoPosted2AutoFinished(bankUser: User, secondsBeforeFinishing: Long) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "AUTO_POSTED -> AUTO_FINISHED",
    preExecution = {
        val prepDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser).apply {
            startAt = ZonedDateTime.now().plusSeconds(5).toInstant()
            endAt = ZonedDateTime.now().plusSeconds(secondsBeforeFinishing).toInstant()
        }
        PublicationPrepareSteps.createPublicationInStatus(bankUser, status = AUTO_POSTED, dtoForCreate = prepDto)
    },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        Thread.sleep(1000 * secondsBeforeFinishing)
        val steps = PublicationSteps(bankUser)
        docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { steps.getById(documentDto.id!!).data.getOrException(ERROR_MSG_GET_BY_ID) },
            repeatLimitSec = secondsBeforeFinishing,
            preparedDto = documentDto,
            expStatuses = listOf(AUTO_FINISHED.statusBank)
        )
    }
)

class PblLifecycleTest_AutoPosted2ManuallyFinished(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "AUTO_POSTED -> MANUALLY_FINISHED",
    preExecution = {
        val prepDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser).apply {
            val startAtDateTime = ZonedDateTime.now().plusSeconds(5)
            startAt = startAtDateTime.toInstant()
            endAt = startAtDateTime.plusDays(1).toInstant()
        }
        PublicationPrepareSteps.createPublicationInStatus(bankUser, status = AUTO_POSTED, dtoForCreate = prepDto)
    },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        val actResult = PublicationSteps(bankUser).finishPostSingle(documentDto.id!!)
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(MANUALLY_FINISHED.statusBank)
        )
    }
)

class PblLifecycleTest_AutoPostError2ManuallyPosted(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "AUTO_POST_ERROR -> MANUALLY_POSTED",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = AUTO_POST_ERROR) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        val actResult = PublicationSteps(bankUser).postFromErrorSingle(documentDto.id!!)
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(MANUALLY_POSTED.statusBank)
        )
    }
)

class PblLifecycleTest_AutoFinishError2ManuallyFinished(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "AUTO_FINISH_ERROR -> MANUALLY_FINISHED",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = AUTO_FINISH_ERROR) },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        val actResult = PublicationSteps(bankUser).finishPostFromErrorSingle(documentDto.id!!)
        docChecks.checkDocumentLifecycleTransition(
            documentDto, actResult,
            expStatuses = listOf(MANUALLY_FINISHED.statusBank)
        )
    }
)

class PblLifecycleTest_ManuallyPosted2AutoFinished(bankUser: User, secondsBeforeFinishing: Long) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "MANUALLY_POSTED -> AUTO_FINISHED",
    preExecution = {
        val prepDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(bankUser).apply {
            startAt = null
            endAt = ZonedDateTime.now().plusSeconds(secondsBeforeFinishing).toInstant()
        }
        PublicationPrepareSteps.createPublicationInStatus(bankUser, status = MANUALLY_POSTED, dtoForCreate = prepDto)
    },
    testBody = { pblDto ->
        bankUser.checkIsBankUser()
        val documentDto = pblDto!!.toReducedDto()

        Thread.sleep(1000 * secondsBeforeFinishing)
        val steps = PublicationSteps(bankUser)
        docChecks.repeatableCheckDocumentLifecycleTransition(
            getActResultFunc = { steps.getById(documentDto.id!!).data.getOrException(ERROR_MSG_GET_BY_ID) },
            repeatLimitSec = secondsBeforeFinishing,
            preparedDto = documentDto,
            expStatuses = listOf(AUTO_FINISHED.statusBank)
        )
    }
)

class PblLifecycleTest_WaitingForAutoPost2AutoPostError(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "WAITING_FOR_AUTO_POST -> AUTO_POST_ERROR",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = WAITING_FOR_AUTO_POST) },
    testBody = { throw RuntimeException("Unreachable status: AUTO_POST_ERROR") }
)

class PblLifecycleTest_AutoPosted2AutoFinishError(bankUser: User) : PublicationLifecycleTest(
    bankUser = bankUser, statusTransition = "AUTO_POSTED -> AUTO_FINISH_ERROR",
    preExecution = { PublicationPrepareSteps.createPublicationInStatus(bankUser, status = AUTO_POSTED) },
    testBody = { throw RuntimeException("Unreachable status: AUTO_FINISH_ERROR") }
)
