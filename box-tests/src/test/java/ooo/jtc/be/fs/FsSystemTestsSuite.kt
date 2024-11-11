package ooo.jtc.be.fs

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_FS
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.api.platform.attachment.AttachmentDownloadTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryPlatform
import ooo.jtc.generic.FsNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Story(TestStoryPlatform.PLATFORM)
@Feature(TestFeature.ATTACHMENTS)
@DisplayName("API '${FsNames.FS_SYSTEM}' suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_FS
class FsSystemTestsSuite {

    @TestFactory
    internal fun attachmentTests(): List<DynamicTest> {
        val user = Users.client
        return EntityTestGenerator.generate(
            listOf(
                AttachmentDownloadTest(
                    user = user,
                    preExecution = { LetterToBankPreExecutions.LTBPreExecutionNewWithAttach.invoke(user).attachments!![0] }
                )
            )
        )
    }
}