package ooo.jtc.be.news.publication

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_PUBLICATION_CRUD
import ooo.jtc.api.news.publication.PublicationCreateTest
import ooo.jtc.api.news.publication.PublicationDeleteTest
import ooo.jtc.api.news.publication.PublicationGetPageTest
import ooo.jtc.api.news.publication.PublicationGetTest
import ooo.jtc.api.news.publication.PublicationPrepareSteps.addAttachmentsToDto
import ooo.jtc.api.news.publication.PublicationPrepareSteps.getGeneralPublicationDtoForCreate
import ooo.jtc.api.news.publication.PublicationUpdateTest
import ooo.jtc.api.platform.attachment.AttachmentPrepareSteps.DEFAULT_ATTACH_FILE
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
import ooo.jtc.files.FileHelper
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CORRESPONDENCE)
@Story(TestStoryCorrespondence.CORRESPONDENCE_PUBLICATION_CRUD)
@DisplayName("API '${DocumentNames.PUBLICATION}' CRUD suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_PUBLICATION_CRUD
class PublicationCrudTestsSuite {
 //region Tags
//@formatter:off
@Tag("JTCSALTO-T4766") annotation class T4766
@Tag("JTCSALTO-T4767") annotation class T4767
@Tag("JTCSALTO-T4768") annotation class T4768
@Tag("JTCSALTO-T4769") annotation class T4769
@Tag("JTCSALTO-T4770") annotation class T4770
@Tag("JTCSALTO-T4853") annotation class T4853
@Tag("JTCSALTO-T4854") annotation class T4854
@Tag("JTCSALTO-T4855") annotation class T4855
//@formatter:on
//endregion

    private val bankUser = Users.bankOperator

    @TestFactory
    @T4766 //'Публикация'. CRUD: Создаем запись от пользователя [BANK]
    @T4767 //'Публикация'. CRUD: Получаем запись по id от пользователя [BANK]
    @T4768 //'Публикация'. CRUD: Получаем страницу записей от пользователя [BANK]
    @T4769 //'Публикация'. CRUD: Обновляем запись от пользователя [BANK]
    @T4770 //'Публикация'. CRUD: Удаляем документ от пользователя [BANK]
    internal fun publicationCrudBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationCreateTest(bankUser).withId(T4766::class),
                PublicationGetTest(bankUser).withId(T4767::class),
                PublicationGetPageTest(bankUser).withId(T4768::class),
                PublicationUpdateTest(bankUser).withId(T4769::class),
                PublicationDeleteTest(bankUser).withId(T4770::class),
            )
        )
    }

    @TestFactory
    @T4853 //'Публикация'. CRUD: Создаем запись от пользователя (с вложениями) [BANK]
    @T4854 //'Публикация'. CRUD: Обновляем запись от пользователя (добавление вложений) [BANK]
    @T4855 //'Публикация'. CRUD: Обновляем запись от пользователя (удаление вложений) [BANK]
    internal fun publicationAttachmentRelatedTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PublicationCreateTest(bankUser, nameDetails = " (с вложениями)",
                    dtoForCreation = {
                        val attachList = FileHelper.createTempFiles(
                            fileName = "PublicationAttach",
                            fileExt = "txt",
                            qty = 3,
                            content = "Publication AT attachment".toByteArray()
                        )
                        getGeneralPublicationDtoForCreate(bankUser, attachments = attachList)
                    }
                ).withId(T4853::class),
                PublicationUpdateTest(
                    bankUser, nameDetails = " (добавление вложений)",
                    dtoForCreation = { getGeneralPublicationDtoForCreate(relatedBankUser = bankUser) },
                    dtoForUpdate = { addAttachmentsToDto(it, bankUser, listOf(DEFAULT_ATTACH_FILE)) },
                    preCheckingHandling = { ltb -> ltb.apply { attachments?.forEach { it.dataHash = null } } }
                ).withId(T4854::class),
                PublicationUpdateTest(
                    bankUser, nameDetails = " (удаление вложений)",
                    dtoForCreation = { getGeneralPublicationDtoForCreate(bankUser, attachments = listOf(DEFAULT_ATTACH_FILE)) },
                    dtoForUpdate = {
                        it.apply { attachments = emptyList() }
                        it.apply { isHasAttach = false }
                    }
                ).withId(T4855::class)
            )
        )
    }
}