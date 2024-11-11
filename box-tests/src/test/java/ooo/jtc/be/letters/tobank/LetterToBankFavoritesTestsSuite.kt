package ooo.jtc.be.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_TO_BANK_FAVORITES
import ooo.jtc.api.letters.tobank.tests.LetterToBankAddToFavoritesTest
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankAvailableToUser
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.createLetterToBankDto
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getLetterToBankDtoForCreate
import ooo.jtc.api.letters.tobank.steps.LetterToBankPrepareSteps.getOrCreateLetterToBankDto
import ooo.jtc.api.letters.tobank.tests.LetterToBankRemoveFromFavoritesTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.LetterToBankFilterParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_FAVORITES)
@DisplayName("API '${DocumentNames.LETTER_TO_BANK}' favorites suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_TO_BANK_FAVORITES
class LetterToBankFavoritesTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1974") annotation class T1974
@Tag("JTCSALTO-T1973") annotation class T1973
@Tag("JTCSALTO-T3928") annotation class T3928
@Tag("JTCSALTO-T3929") annotation class T3929
//@formatter:on
//endregion

    @TestFactory
    @T1973 //'Письмо в Банк'. Добавить в избранное [CLIENT]
    @T1974 //'Письмо в Банк'. Удалить из избранного [CLIENT]
    @T3928 //'Письмо в Банк': Добавить в избранное [BANK]
    @T3929 //'Письмо в Банк': Удалить из избранного [BANK]
    internal fun letterToBankFavoriteTests(): List<DynamicTest> {
        val clientUser = Users.client
        val bankUser = Users.bankOperator

        val pageRequestFavorites = { LetterToBankFilterParams.IS_FAVORITES.eq(true).toPageRequest() }
        val notFavoriteDto = getLetterToBankDtoForCreate(clientUser, bankUser).apply { this.isFavorites = false }
        val favoriteDto = getLetterToBankDtoForCreate(clientUser, bankUser).apply { this.isFavorites = true }

        return EntityTestGenerator.generate(
                listOf(
                        LetterToBankAddToFavoritesTest(
                                user = clientUser,
                                preExecution = {
                                    getOrCreateLetterToBankDto(
                                            searchingUser = clientUser,
                                            additionalFilter = { !it.isFavorites!! },
                                            createLtbFunc = { createLetterToBankDto(clientUser, notFavoriteDto) }
                                    ).id!!
                                }
                        ).withId(T1973::class),
                        LetterToBankAddToFavoritesTest(
                                user = bankUser,
                                preExecution = {
                                    getOrCreateLetterToBankDto(
                                            searchingUser = bankUser,
                                            creatorClientUser = clientUser,
                                            additionalFilter = { !it.isFavorites!! },
                                            createLtbFunc = { createLetterToBankAvailableToUser(bankUser, clientUser, notFavoriteDto) }
                                    ).id!!
                                }
                        ).withId(T3928::class),
                        LetterToBankRemoveFromFavoritesTest(
                                user = clientUser,
                                preExecution = {
                                    getOrCreateLetterToBankDto(
                                            searchingUser = clientUser,
                                            getPageRequest = pageRequestFavorites,
                                            createLtbFunc = { createLetterToBankDto(clientUser, favoriteDto) }
                                    ).id!!
                                }
                        ).withId(T1974::class),
                        LetterToBankRemoveFromFavoritesTest(
                                user = bankUser,
                                preExecution = {
                                    getOrCreateLetterToBankDto(
                                            searchingUser = bankUser,
                                            creatorClientUser = clientUser,
                                            getPageRequest = pageRequestFavorites,
                                            createLtbFunc = { createLetterToBankAvailableToUser(bankUser, clientUser, favoriteDto) }
                                    ).id!!
                                }
                        ).withId(T3929::class)
                )
        )
    }
}