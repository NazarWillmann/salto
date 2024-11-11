package ooo.jtc.api.news.publication

import ooo.jtc.api.common.checks.ApiDocumentChecks
import ooo.jtc.api.common.tests.AbstractBeTest
import ooo.jtc.api.news.PublicationTaskIdsAvailability
import ooo.jtc.api.news.PublicationTaskIdsDocApi
import ooo.jtc.api.news.publication.PublicationPrepareSteps.prepareAttachmentsForComparison
import ooo.jtc.api.news.publication.PublicationPrepareSteps.prepareCustomersForComparison
import ooo.jtc.api.news.publication.PublicationPrepareSteps.removeAttachmentsTokens
import ooo.jtc.asserts.assertEqualList
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.tm4j.ComponentNews
import ooo.jtc.core.tm4j.HighPriority
import ooo.jtc.extensions.asserts.assertIsNotEmpty
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.news.dto.PublicationDto
import ooo.jtc.news.dto.PublicationTargetType
import ooo.jtc.scripts.invoke
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.branchrepresentative.BranchRepresentativeData
import ooo.jtc.uaa.User
import org.hamcrest.MatcherAssert.assertThat
import java.time.LocalDate

@PublicationTaskIdsDocApi
@PublicationFolderOther
@ComponentNews
@HighPriority
class PublicationPreFillTest(
    bankUser: User,
    nameDetails: String
) : AbstractBeTest<PublicationDto, Unit>(
    name = "'${DocumentNames.PUBLICATION}'. Получение предзаполненного документа$nameDetails [${bankUser.userType}]",
    params = { mapOf(PARAM_USER to bankUser) },
    testBody = {
        val errMsg: (String) -> String = { fieldName -> "Неожиданное значение $fieldName" }
        val response = PublicationSteps(bankUser).preFill()

        val actResult = response.data.getOrException("Получение предзаполненной публикации")
        "Проверить, что в предзаполненном документе вернулась ожидаемая информация" {
            // based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733818
            val expDocDate = LocalDate.now()
            val expTargetType = PublicationTargetType.GENERAL.type
            assertThat(errMsg("id"), null == actResult.id)                             //1.1
            assertThat(errMsg("documentNumber"), actResult.documentNumber.toInt() > 0)
            assertThat(errMsg("documentDate"), expDocDate == actResult.documentDate)   //1.3
            assertThat(errMsg("status"), null == actResult.status)                     //1.4
            assertThat(errMsg("description"), null == actResult.description)           //1.5
            assertThat(errMsg("publicationType"), null == actResult.publicationType)   //1.6
            assertThat(errMsg("targetType"), expTargetType == actResult.targetType)    //1.7
            assertThat(errMsg("isMustKnow"), false == actResult.isMustKnow)            //1.8
            assertThat(errMsg("isImportant"), false == actResult.isImportant)          //1.9
            assertThat(errMsg("startAt"), null == actResult.startAt)                   //1.10
            assertThat(errMsg("endAt"), null == actResult.endAt)                       //1.11
            assertThat(errMsg("channel"), null == actResult.mailingChannel)            //1.12
            assertThat(errMsg("isForAllBranches"), false == actResult.isForAllBranches)//1.13

            assertThat(errMsg("header"), null == actResult.header)                     //2.1
            assertThat(errMsg("text"), null == actResult.text)                         //2.2
            assertThat(errMsg("link"), null == actResult.link)                         //2.3
            assertThat(errMsg("linkText"), null == actResult.linkText)                 //2.4
            assertThat(errMsg("picture"), null == actResult.picture)                   //2.5

            assertThat(errMsg("createdAt"), null == actResult.createdAt)               //4.1
            assertThat(errMsg("isHasAttach"), false == actResult.isHasAttach)          //5.1

            //assertThat(errMsg("'канал продаж'"), null == actResult.<hiddenField>)    //4.2
            //assertThat(errMsg("attachName"), null == actResult.<hiddenField>)        //5.2

            //branch-dependent values
            val bankRepresentatives = BranchRepresentativeData.searchBy(bankUser)
            when (bankRepresentatives.size) {
                0 -> throw RuntimeException("Банковский пользователь не является представителем ни одного банка.")
                1 -> {
                    val expBranchId = bankRepresentatives.first().branchId!!
                    assertThat(errMsg("branchId"), expBranchId == actResult.branchId)
                    val expBranchName = BranchData.get { it.id == expBranchId }.first().shortName
                    assertThat(errMsg("branchName"), expBranchName == actResult.branchName)
                }
                else -> {
                    assertThat(errMsg("branchId"), null == actResult.branchId)
                    assertThat(errMsg("branchName"), null == actResult.branchName)
                }
            }
        }
    }
)

@PublicationTaskIdsDocApi
@PublicationFolderOther
@ComponentNews
@HighPriority
class PublicationCopyTest(
    bankUser: User,
    withAttachments: Boolean,
    withReceivers: Boolean
) : AbstractBeTest<PublicationDto, Unit>(
    name = "'${DocumentNames.PUBLICATION}'. Копирование" +
            " (${if (withAttachments) "с вложениями" else "без вложений"}," +
            " ${if (withReceivers) "с адресатами" else "без адресатов"})" +
            " документа [${bankUser.userType}]",
    params = { mapOf(PARAM_USER to bankUser, "Документ для копирования" to it!!) },
    preExecution = { PublicationPrepareSteps.getOrCreatePublicationDto(searchingUser = bankUser) },
    testBody = { publDto ->
        val origDto = publDto!!
        val errMsg: (String) -> String = { fieldName -> "Неожиданное значение $fieldName" }
        val response = PublicationSteps(bankUser).copy(origDto.id!!, withAttachments, withReceivers)

        val actResult = response.data.getOrException("Получение копии публикации")
        "Проверить, что в копии документа вернулась ожидаемая информация" {
            // based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=21733822
            val expDocDate = LocalDate.now()
            assertThat(errMsg("id"), null == actResult.id)                                  //1.1
            actResult.documentNumber.assertIsNotEmpty()                                 //1.2(+)
            assertThat(errMsg("documentDate"), expDocDate == actResult.documentDate)        //1.3
            assertThat(errMsg("status"), null == actResult.status)                          //1.4

            assertThat(errMsg("description"), origDto.description == actResult.description)             //1.5
            assertThat(errMsg("publicationType"), origDto.publicationType == actResult.publicationType) //1.6
            assertThat(errMsg("targetType"), origDto.targetType == actResult.targetType)                //1.7
            assertThat(errMsg("isMustKnow"), origDto.isMustKnow == actResult.isMustKnow)                //1.8
            assertThat(errMsg("isImportant"), origDto.isImportant == actResult.isImportant)             //1.9
            assertThat(errMsg("startAt"), origDto.startAt == actResult.startAt)                         //1.10
            assertThat(errMsg("endAt"), origDto.endAt == actResult.endAt)                               //1.11
            assertThat(errMsg("channel"), origDto.mailingChannel == actResult.mailingChannel)           //1.12
            assertThat(errMsg("isForAllBranches"), origDto.isForAllBranches == actResult.isForAllBranches)//1.13

            assertThat(errMsg("header"), origDto.header == actResult.header)                //2.1
            assertThat(errMsg("text"), origDto.text == actResult.text)                      //2.2
            assertThat(errMsg("link"), origDto.link == actResult.link)                      //2.3
            assertThat(errMsg("linkText"), origDto.linkText == actResult.linkText)          //2.4
            assertThat(errMsg("picture"), origDto.picture == actResult.picture)             //2.5

            val expBranchId = origDto.branchId!!
            val expBranchName = BranchData.get { it.id == expBranchId }.first().shortName
            assertThat(errMsg("branchId"), expBranchId == actResult.branchId)               //3.1
            assertThat(errMsg("branchName"), expBranchName == actResult.branchName)         //3.2

            assertThat(errMsg("createdAt"), null == actResult.createdAt)                    //4.1
            //assertThat(errMsg("'канал продаж'"), <hiddenField>)                           //4.2
            //assertThat(errMsg("attachName"), actResult.<hiddenField>)                     //5.2

            if (withAttachments && !(origDto.attachments.isNullOrEmpty())) {
                val expAttachments = prepareAttachmentsForComparison(origDto.attachments!!)
                val actAttachments = prepareAttachmentsForComparison(actResult.attachments!!)
                assertThat(errMsg("isHasAttach"), origDto.isHasAttach == actResult.isHasAttach)             //5.1(+)
                (errMsg("attachments")) { assertEqualList("attachments", expAttachments, actAttachments) }  //5.1(+)
            } else {
                assertThat(errMsg("isHasAttach"), false == actResult.isHasAttach)                           //5.1(-)
                assertThat(errMsg("attachments"), actResult.attachments.isNullOrEmpty())                    //5.1(-)
            }

            if (withReceivers && !(origDto.customers.isNullOrEmpty())) {
                val expCustomers = prepareCustomersForComparison(origDto.customers!!)
                val actCustomers = prepareCustomersForComparison(actResult.customers!!)
                (errMsg("customers")) { assertEqualList("customers", expCustomers, actCustomers) }
            } else {
                assertThat(errMsg("customers"), actResult.customers.isNullOrEmpty())
            }
        }
    }
)

@PublicationTaskIdsAvailability
@PublicationFolderOther
@ComponentNews
@HighPriority
class PublicationPositiveAvailabilityTest(
    user: User,
    override val preExecution: (() -> PublicationDto)?,
    nameDetails: String
) : AbstractBeTest<PublicationDto, Unit>(
    name = "'${DocumentNames.PUBLICATION}'. Проверка доступности документа$nameDetails [${user.userType}]",
    params = { mapOf(PARAM_USER to user, "Документ для проверки" to it!!) },
    testBody = { pblDto ->
        val response = PublicationSteps(user).getById(pblDto!!.id!!)

        val checks = ApiDocumentChecks<PublicationDto>()
        val pblDtoForComparison = removeAttachmentsTokens(pblDto)
        checks.checkConsumeEntity(pblDtoForComparison, response)
    }
)

@PublicationTaskIdsAvailability
@PublicationFolderOther
@ComponentNews
@HighPriority
class PublicationNegativeAvailabilityTest(
    user: User,
    override val preExecution: (() -> PublicationDto)?,
    nameDetails: String
) : AbstractBeTest<PublicationDto, Unit>(
    name = "'${DocumentNames.PUBLICATION}'. Проверка недоступности документа$nameDetails [${user.userType}]",
    params = { mapOf(PARAM_USER to user, "Документ для проверки" to it!!) },
    testBody = { pblDto ->
        val steps = PublicationSteps(user)
        val response = steps.getById(pblDto!!.id!!, statusCode = 500)

        val checks = ApiDocumentChecks<PublicationDto>()
        checks.checkNotFound(response)
    }
)