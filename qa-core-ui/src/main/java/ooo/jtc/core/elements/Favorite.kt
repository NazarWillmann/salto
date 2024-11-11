package ooo.jtc.core.elements

import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.container.SContainer
import ooo.jtc.scripts.repeat
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers

/**
 * Элемент управления Избранное.
 * Представляет одновременно и общую кнопку 'Избранное' в топе на скроллере,
 * и кнопку-звезддочку в строке скроллера.
 * Взаимодействие происходит на основе контекста от которого ищется этот элемент.
 * Элемент добавляется через добавление интерфейса [WithFavoriteStar] к компоненту приложения.
 * e.g. - [ooo.jtc.ui.common.pages.DocumentScrollerPage]
 */
class Favorite(sElement: SelenideElement) : SContainer(sElement = sElement) {

    private val isFavorite: Boolean
        get() {
            val attr = this.`$x`(".//*[@id]").attr("id")
            return attr == "Fill"
        }


    @Step("Отметить {this.sName}")
    fun mark() {
        if (!isFavorite) click(ignoreStep = true)
    }

    @Step("Снять отметку с {this.sName}")
    fun unMark() {
        if (isFavorite) click(ignoreStep = true)
    }

    @Step("Проверить, что элемент управления Избранным выделен")
    fun checkIsMarked() {
        repeat({ isFavorite }, { it }, 2).also { println("FavoriteIsMarked: $it") }
        assertThat("элемент управления Избранным не выделен", isFavorite, Matchers.equalTo(true))
    }

    @Step("Проверить, что элемент управления Избранным не выделен")
    fun checkNotMarked() {
        repeat({ isFavorite }, { !it }, 2).also { println("FavoriteIsMarked: $it") }
        assertThat("элемент управления Избранным выделен", isFavorite, Matchers.equalTo(false))
    }
}

