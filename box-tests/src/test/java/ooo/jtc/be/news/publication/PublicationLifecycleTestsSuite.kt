package ooo.jtc.be.news.publication

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_PUBLICATION_LIFECYCLE
import ooo.jtc.api.news.publication.PblLifecycleTest_AutoFinishError2ManuallyFinished
import ooo.jtc.api.news.publication.PblLifecycleTest_AutoPostError2ManuallyPosted
import ooo.jtc.api.news.publication.PblLifecycleTest_AutoPosted2ManuallyFinished
import ooo.jtc.api.news.publication.PblLifecycleTest_Draft2Draft
import ooo.jtc.api.news.publication.PblLifecycleTest_Draft2New
import ooo.jtc.api.news.publication.PblLifecycleTest_ManuallyPosted2AutoFinished
import ooo.jtc.api.news.publication.PblLifecycleTest_ManuallyPosted2ManuallyFinished
import ooo.jtc.api.news.publication.PblLifecycleTest_New2Draft
import ooo.jtc.api.news.publication.PblLifecycleTest_New2ManuallyPosted
import ooo.jtc.api.news.publication.PblLifecycleTest_New2New
import ooo.jtc.api.news.publication.PblLifecycleTest_New2WaitingForAutoPost
import ooo.jtc.api.news.publication.PblLifecycleTest_None2Draft
import ooo.jtc.api.news.publication.PblLifecycleTest_None2New
import ooo.jtc.api.news.publication.PblLifecycleTest_WaitingForAutoPost2AutoPosted
import ooo.jtc.api.news.publication.PblLifecycleTest_WaitingForAutoPost2New
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.Issues.JTCSALTO_3093
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCorrespondence
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
@Story(TestStoryCorrespondence.CORRESPONDENCE_PUBLICATION_LIFECYCLE)
@DisplayName("API '${DocumentNames.PUBLICATION}' lifecycle suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_PUBLICATION_LIFECYCLE
class PublicationLifecycleTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4913") annotation class T4913
@Tag("JTCSALTO-T4914") annotation class T4914
@Tag("JTCSALTO-T4915") annotation class T4915
@Tag("JTCSALTO-T4916") annotation class T4916
@Tag("JTCSALTO-T4917") annotation class T4917
@Tag("JTCSALTO-T4918") annotation class T4918
@Tag("JTCSALTO-T4919") annotation class T4919
@Tag("JTCSALTO-T4920") annotation class T4920
@Tag("JTCSALTO-T4921") annotation class T4921
@Tag("JTCSALTO-T4922") annotation class T4922
@Tag("JTCSALTO-T4923") annotation class T4923
@Tag("JTCSALTO-T4924") annotation class T4924
@Tag("JTCSALTO-T4925") annotation class T4925
@Tag("JTCSALTO-T4926") annotation class T4926
@Tag("JTCSALTO-T4927") annotation class T4927
@Tag("JTCSALTO-T4928") annotation class T4928
@Tag("JTCSALTO-T4929") annotation class T4929
@Tag("JTCSALTO-T4930") annotation class T4930
//@formatter:on
//endregion

    private val bankUser by lazy { Users.bankOperator }

    @TestFactory
    @T4913 //'Публикация'. Жизненный цикл. Проверка перехода none -> DRAFT [BANK]
    @T4914 //'Публикация'. Жизненный цикл. Проверка перехода none -> NEW [BANK]
    @T4915 //'Публикация'. Жизненный цикл. Проверка перехода DRAFT -> NEW [BANK]
    @T4916 //'Публикация'. Жизненный цикл. Проверка перехода DRAFT -> DRAFT [BANK]
    @T4917 //'Публикация'. Жизненный цикл. Проверка перехода NEW -> DRAFT [BANK]
    @T4918 //'Публикация'. Жизненный цикл. Проверка перехода NEW -> NEW [BANK]
    @T4919 //'Публикация'. Жизненный цикл. Проверка перехода NEW -> MANUALLY_POSTED [BANK]
    @T4920 //'Публикация'. Жизненный цикл. Проверка перехода NEW -> WAITING_FOR_AUTO_POST [BANK]
    @T4921 //'Публикация'. Жизненный цикл. Проверка перехода MANUALLY_POSTED -> MANUALLY_FINISHED [BANK]
    @T4922 //'Публикация'. Жизненный цикл. Проверка перехода WAITING_FOR_AUTO_POST -> AUTO_POSTED [BANK]
    @T4923 //'Публикация'. Жизненный цикл. Проверка перехода WAITING_FOR_AUTO_POST -> NEW [BANK]
    @T4925 //'Публикация'. Жизненный цикл. Проверка перехода AUTO_POSTED -> AUTO_FINISHED [BANK]
    @T4927 //'Публикация'. Жизненный цикл. Проверка перехода AUTO_POSTED -> MANUALLY_FINISHED [BANK]
    @T4928 //'Публикация'. Жизненный цикл. Проверка перехода AUTO_POST_ERROR -> MANUALLY_POSTED [BANK]
    @T4929 //'Публикация'. Жизненный цикл. Проверка перехода AUTO_FINISH_ERROR -> MANUALLY_FINISHED [BANK]
    @T4930 //'Публикация'. Жизненный цикл. Проверка перехода MANUALLY_POSTED -> AUTO_FINISHED [BANK]
    //@T4924 //'Публикация'. Жизненный цикл. Проверка перехода WAITING_FOR_AUTO_POST -> AUTO_POST_ERROR [BANK]
    //@T4926 //'Публикация'. Жизненный цикл. Проверка перехода AUTO_POSTED -> AUTO_FINISH_ERROR [BANK]
    internal fun publicationLifecycleTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                PblLifecycleTest_None2Draft(bankUser).withId(T4913::class),
                PblLifecycleTest_None2New(bankUser).withId(T4914::class),
                PblLifecycleTest_Draft2New(bankUser).withId(T4915::class),
                PblLifecycleTest_Draft2Draft(bankUser).withId(T4916::class),
                PblLifecycleTest_New2Draft(bankUser).withId(T4917::class),
                PblLifecycleTest_New2New(bankUser).withId(T4918::class),
                PblLifecycleTest_New2ManuallyPosted(bankUser).withId(T4919::class),
                PblLifecycleTest_New2WaitingForAutoPost(bankUser).withId(T4920::class),
                PblLifecycleTest_ManuallyPosted2ManuallyFinished(bankUser).withId(T4921::class),
                PblLifecycleTest_WaitingForAutoPost2AutoPosted(bankUser, secondsBeforePosting = 5).withId(T4922::class).withIssues(JTCSALTO_3093),
                PblLifecycleTest_WaitingForAutoPost2New(bankUser).withId(T4923::class),
//                PblLifecycleTest_AutoPosted2AutoFinished(bankUser, secondsBeforeFinishing = 10).withId(T4925::class),
                PblLifecycleTest_AutoPosted2ManuallyFinished(bankUser).withId(T4927::class).withIssues(JTCSALTO_3093),
                PblLifecycleTest_AutoPostError2ManuallyPosted(bankUser).withId(T4928::class),
                PblLifecycleTest_AutoFinishError2ManuallyFinished(bankUser).withId(T4929::class),
                PblLifecycleTest_ManuallyPosted2AutoFinished(bankUser, secondsBeforeFinishing = 10).withId(T4930::class).withIssues(JTCSALTO_3093),
//                [2020.12.11]: ошибочные статусы недостижимы стандартными средствами
//                PblLifecycleTest_WaitingForAutoPost2AutoPostError(bankUser).withId(T4924::class),
//                PblLifecycleTest_AutoPosted2AutoFinishError(bankUser).withId(T4926::class),
            )
        )
    }
}
