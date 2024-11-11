package ooo.jtc.be.news.publication

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_PUBLICATION_OTHER
import ooo.jtc.api.news.publication.PublicationCopyTest
import ooo.jtc.api.news.publication.PublicationNegativeAvailabilityTest
import ooo.jtc.api.news.publication.PublicationPositiveAvailabilityTest
import ooo.jtc.api.news.publication.PublicationPreFillTest
import ooo.jtc.api.news.publication.PublicationPrepareSteps
import ooo.jtc.api.news.publication.PublicationSteps
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.DocumentNames
import ooo.jtc.news.PublicationStatus
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.dictionaries.branch.BranchData
import ooo.jtc.testdata.dictionaries.customer.CustomerData
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CORRESPONDENCE)
@Story(TestStoryCorrespondence.CORRESPONDENCE_PUBLICATION_OTHER)
@DisplayName("API '${DocumentNames.PUBLICATION}' other suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_PUBLICATION_OTHER
class PublicationOtherTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4851") annotation class T4851
@Tag("JTCSALTO-T4852") annotation class T4852
@Tag("JTCSALTO-T4863") annotation class T4863
@Tag("JTCSALTO-T4864") annotation class T4864
@Tag("JTCSALTO-T4865") annotation class T4865
@Tag("JTCSALTO-T4866") annotation class T4866
@Tag("JTCSALTO-T4936") annotation class T4936
@Tag("JTCSALTO-T4937") annotation class T4937
@Tag("JTCSALTO-T4938") annotation class T4938
@Tag("JTCSALTO-T4939") annotation class T4939
@Tag("JTCSALTO-T4940") annotation class T4940
@Tag("JTCSALTO-T4941") annotation class T4941
//@formatter:on
//endregion

    private val atBankOperator by lazy { Users.bankOperator }
    private val systemBankOperator by lazy { Users.systemBankOperator }
    private val superBankOperator by lazy { Users.superBankOperator }
    private val firstClientUser by lazy { Users.client }
    private val secondClientUser by lazy { Users.secondClient }

    @TestFactory
    @T4851 //'Публикация'. Получение предзаполненного документа (пользователь с одним подразделением) [BANK]
    @T4852 //'Публикация'. Получение предзаполненного документа (пользователь со многими подразделениями) [BANK]
    internal fun publicationPreFillTests(): List<DynamicTest> {
        val multiBranchBankUser = atBankOperator
        val singleBranchBankUser = systemBankOperator
        return EntityTestGenerator.generate(
            listOf(
                PublicationPreFillTest(singleBranchBankUser, " (пользователь с одним подразделением)").withId(T4851::class),
                PublicationPreFillTest(multiBranchBankUser, " (пользователь со многими подразделениями)").withId(T4852::class),
            )
        )
    }

    @TestFactory
    @T4863 //'Публикация'. Копирование (без вложений, без адресатов) документа [BANK]
    @T4864 //'Публикация'. Копирование (без вложений, с адресатами) документа [BANK]
    @T4865 //'Публикация'. Копирование (с вложениями, без адресатов) документа [BANK]
    @T4866 //'Публикация'. Копирование (с вложениями, с адресатами) документа [BANK]
    internal fun publicationCopyTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationCopyTest(atBankOperator, withAttachments = false, withReceivers = false).withId(T4863::class),
                PublicationCopyTest(atBankOperator, withAttachments = false, withReceivers = true).withId(T4864::class),
                PublicationCopyTest(atBankOperator, withAttachments = true, withReceivers = false).withId(T4865::class),
                PublicationCopyTest(atBankOperator, withAttachments = true, withReceivers = true).withId(T4866::class)
            )
        )
    }

    @TestFactory
    @T4936 //'Публикация'. Проверка доступности документа банковскому суперпользователю при создании обычным оператором [BANK]
    @T4937 //'Публикация'. Проверка доступности документа клиентскому пользователю при создании публикации для доступного Клиента [CLIENT]
    @T4938 //'Публикация'. Проверка доступности документа клиентскому пользователю при создании публикации для доступного подразделения [CLIENT]
    internal fun publicationPositiveAvailabilityTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationPositiveAvailabilityTest(
                    user = superBankOperator,
                    nameDetails = " банковскому суперпользователю при создании обычным оператором",
                    preExecution = { PublicationPrepareSteps.createPublicationDto(creatorBankUser = atBankOperator) }
                ).withId(T4936::class),
                PublicationPositiveAvailabilityTest(
                    user = firstClientUser,
                    nameDetails = " клиентскому пользователю при создании публикации для доступного Клиента",
                    preExecution = {
                        val prepDto = PublicationPrepareSteps.getClientSpecificPublicationDtoForCreate(
                            relatedBankUser = atBankOperator,
                            receiverClientUser = firstClientUser
                        ).apply { startAt = null }
                        PublicationPrepareSteps.createPublicationInStatus(
                            creatorBankUser = atBankOperator,
                            receiverClientUser = firstClientUser,
                            dtoForCreate = prepDto,
                            status = PublicationStatus.MANUALLY_POSTED
                        ).toClientDto()
                    }
                ).withId(T4937::class),
                PublicationPositiveAvailabilityTest(
                    user = firstClientUser,
                    nameDetails = " клиентскому пользователю при создании публикации для доступного подразделения",
                    preExecution = {
                        val pblDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(
                            relatedBankUser = atBankOperator,
                            receiverClientUser = firstClientUser
                        ).apply { startAt = null }
                        PublicationPrepareSteps.createPublicationInStatus(
                            creatorBankUser = atBankOperator,
                            receiverClientUser = firstClientUser,
                            dtoForCreate = pblDto,
                            status = PublicationStatus.MANUALLY_POSTED
                        ).toClientDto()
                    }
                ).withId(T4938::class),
            )
        )
    }

    @TestFactory
    @T4939 //'Публикация'. Проверка недоступности документа обычному оператору для чужого подразделения при создании суперпользователем [BANK]
    @T4940 //'Публикация'. Проверка недоступности документа клиентскому пользователю при создании публикации для чужого Клиента [CLIENT]
    @T4941 //'Публикация'. Проверка недоступности документа клиентскому пользователю при создании публикации для чужого подразделения [CLIENT]
    internal fun publicationNegativeAvailabilityTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationNegativeAvailabilityTest(
                    user = atBankOperator,
                    nameDetails = " обычному оператору для чужого подразделения при создании суперпользователем",
                    preExecution = {
                        val availableToTestUserBranchesIds = BranchData.searchBy(atBankOperator).map { it.id!! }
                        val unavailableToTestUserBranchId = BranchData.find { !availableToTestUserBranchesIds.contains(it.id!!) }.id!!
                        val pblDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(
                            relatedBankUser = superBankOperator,
                            branchId = unavailableToTestUserBranchId
                        )
                        PublicationSteps(superBankOperator).create(pblDto).data.getOrException()
                    }
                ).withId(T4939::class),
                PublicationNegativeAvailabilityTest(
                    user = secondClientUser,
                    nameDetails = " клиентскому пользователю при создании публикации для чужого Клиента",
                    preExecution = {
                        val availableForCreationCustomersIds = CustomerData.searchBy(firstClientUser).map { it.id!! }
                        val availableToTestUserCustomersIds = CustomerData.searchBy(secondClientUser).map { it.id!! }
                        val unavailableToTestUserCustomerId = availableForCreationCustomersIds
                            .first { !availableToTestUserCustomersIds.contains(it) }
                        val pblDto = PublicationPrepareSteps.getClientSpecificPublicationDtoForCreate(
                            relatedBankUser = atBankOperator,
                            customerIds = listOf(unavailableToTestUserCustomerId)
                        ).apply { startAt = null }
                        PublicationPrepareSteps.createPublicationInStatus(
                            creatorBankUser = atBankOperator,
                            receiverClientUser = firstClientUser,
                            dtoForCreate = pblDto,
                            status = PublicationStatus.MANUALLY_POSTED
                        ).toClientDto()
                    }
                ).withId(T4940::class),
                PublicationNegativeAvailabilityTest(
                    user = secondClientUser,
                    nameDetails = " клиентскому пользователю при создании публикации для чужого подразделения",
                    preExecution = {
                        val availableForCreationBranchesIds = BranchData.searchBy(firstClientUser).map { it.id!! }
                        val availableToTestUserBranchesIds = BranchData.searchBy(secondClientUser).map { it.id!! }
                        val unavailableToTestUserBranchId = availableForCreationBranchesIds
                            .first { !availableToTestUserBranchesIds.contains(it) }
                        val pblDto = PublicationPrepareSteps.getGeneralPublicationDtoForCreate(
                            relatedBankUser = atBankOperator,
                            branchId = unavailableToTestUserBranchId
                        ).apply { startAt = null }
                        PublicationPrepareSteps.createPublicationInStatus(
                            creatorBankUser = atBankOperator,
                            receiverClientUser = firstClientUser,
                            dtoForCreate = pblDto,
                            status = PublicationStatus.MANUALLY_POSTED
                        ).toClientDto()
                    }
                ).withId(T4941::class),
            )
        )
    }
}
