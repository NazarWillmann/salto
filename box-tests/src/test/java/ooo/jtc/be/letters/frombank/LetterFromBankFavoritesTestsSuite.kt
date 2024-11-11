package ooo.jtc.be.letters.frombank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_LETTER_FROM_BANK_FAVORITES
import ooo.jtc.api.letters.frombank.tests.LetterFromBankAddToFavoritesTest
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createLetterFromBankAvailableToUser
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.createLetterFromBankDto
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getLetterFromBankDtoForCreate
import ooo.jtc.api.letters.frombank.steps.LetterFromBankPrepareSteps.getOrCreateLetterFromBankDto
import ooo.jtc.api.letters.frombank.tests.LetterFromBankRemoveFromFavoritesTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterFromBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.generic.pageparams.toPageRequest
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.frombank.LetterFromBankFilterParams
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.LETTER_FROM_BANK)
@Story(TestStoryLetterFromBank.LETTER_FROM_BANK_FAVORITES)
@DisplayName("API '${DocumentNames.LETTER_FROM_BANK}' favorites suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_LETTER_FROM_BANK_FAVORITES
class LetterFromBankFavoritesTestsSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T4441") annotation class T4441
@Tag("JTCSALTO-T4442") annotation class T4442
@Tag("JTCSALTO-T4443") annotation class T4443
@Tag("JTCSALTO-T4444") annotation class T4444
//@formatter:on
//endregion

    @TestFactory

    @T4443 //'Письмо из Банка': Добавить в избранное [CLIENT]
    @T4441 //'Письмо из Банка': Добавить в избранное [BANK]
    @T4444 //'Письмо из Банка': Удалить из избранного [CLIENT]
    @T4442 //'Письмо из Банка': Удалить из избранного [BANK]
    internal fun letterFromBankFavoriteTests(): List<DynamicTest> {
        val clientUser = Users.client
        val bankUser = Users.bankOperator

        val pageRequestFavorites = { LetterFromBankFilterParams.IS_FAVORITES.eq(true).toPageRequest() }
        val notFavoriteDto = getLetterFromBankDtoForCreate(bankUser, clientUser).apply { this.isFavorites = false }
        val favoriteDto = getLetterFromBankDtoForCreate(bankUser, clientUser).apply { this.isFavorites = true }

        return EntityTestGenerator.generate(
                listOf(
                        LetterFromBankAddToFavoritesTest(
                                user = clientUser,
                                preExecution = {
                                    getOrCreateLetterFromBankDto(
                                            searchingUser = clientUser,
                                            creatorBankUser = bankUser,
                                            additionalFilter = { !it.isFavorites!! },
                                            createLfbFunc = { createLetterFromBankAvailableToUser(clientUser, bankUser, notFavoriteDto) }
                                    ).id!!
                                }
                        ).withId(T4443::class),
                        LetterFromBankAddToFavoritesTest(
                                user = bankUser,
                                preExecution = {
                                    getOrCreateLetterFromBankDto(
                                            searchingUser = bankUser,
                                            additionalFilter = { !it.isFavorites!! },
                                            createLfbFunc = { createLetterFromBankDto(bankUser, notFavoriteDto) }
                                    ).id!!
                                }
                        ).withId(T4441::class),
                        LetterFromBankRemoveFromFavoritesTest(
                                user = clientUser,
                                preExecution = {
                                    getOrCreateLetterFromBankDto(
                                            searchingUser = clientUser,
                                            creatorBankUser = bankUser,
                                            getPageRequest = pageRequestFavorites,
                                            createLfbFunc = { createLetterFromBankAvailableToUser(clientUser, bankUser, favoriteDto) }
                                    ).id!!
                                }
                        ).withId(T4444::class),
                        LetterFromBankRemoveFromFavoritesTest(
                                user = bankUser,
                                preExecution = {
                                    getOrCreateLetterFromBankDto(
                                            searchingUser = bankUser,
                                            getPageRequest = pageRequestFavorites,
                                            createLfbFunc = { createLetterFromBankDto(bankUser, favoriteDto) }
                                    ).id!!
                                }
                        ).withId(T4442::class)
                )
        )
    }
}