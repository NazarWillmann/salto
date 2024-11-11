package ooo.jtc.ui.common.sections.tabs


import com.codeborne.selenide.Condition
import com.codeborne.selenide.Condition.enabled
import com.codeborne.selenide.Condition.exactText
import com.codeborne.selenide.Condition.visible
import com.codeborne.selenide.Selectors
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import ooo.jtc.core.RegexpConst
import ooo.jtc.core.elements.AllElements.listElements
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.kexensions.getFio
import ooo.jtc.uaa.User

@ElementType("Закладка 'Подписи'")
interface SignatureTab<T : TabSection<T>, R : SignatureRow> : TabSection<T> {

    override val tabName: String

    val createRow: (SelenideElement) -> R

    val signatureRows: List<R> get() = getContext().listElements("[role='row']") { createRow(it) }


    @Step("Проверить отображение верного сообщения для статуса 'Черновик'")
    fun checkMessageForDraft() {
        val expMessage = "Документ еще не подписан. Внесите в документ необходимые корректировки и подготовьте его к подписи"
        element(Selectors.ByText(expMessage)).should(visible)
    }

    @Step("Проверить отображение верного сообщения для статуса 'На подпись'")
    fun checkMessageForNew() {
        val expMessage = "Документ еще не подписан"
        element(Selectors.ByText(expMessage)).should(visible)
        getContext().textButton["Подписать"].shouldBe(enabled)
    }

    @Step("Проверить отображение сведений о подписи для статуса выше 'Отправлен'")
    fun checkInfoForDeliveredPlus(expSignToolText: String = "Одноразовый пароль (sms)") {
        signatureRows.forEach {
            it.eventTime.should(Condition.matchText(RegexpConst.UI_EVENT_TIME_REGEX))
            it.userName.should(visible)
            it.signToolType.should(exactText(expSignToolText))
        }
    }

    @Step("Проверить отображение сведений о подписи для статуса 'Подписан/Частично подписан'")
    fun checkInfoForSigned(expSignToolText: String = "Одноразовый пароль (sms)") {
        signatureRows.forEach {
            it.eventTime.should(Condition.matchText(RegexpConst.UI_EVENT_TIME_REGEX))
            it.userName.should(visible)
            it.signToolType.should(exactText(expSignToolText))
            it.unSignBtn.should(enabled)
        }
    }

    fun getRowByUser(user: User): R {
        return signatureRows.find { it.userName.text == user.getFio() } ?: throw RuntimeException("Signed row for user (${user.getFio()}) not found.")
    }

    @Step("Выбрать действие снять подпись пользователя '{user.login}'")
    fun makeUnSignActionByUser(user: User) {
        val signedRow = getRowByUser(user)
        signedRow.unSignBtn.click(false)
    }

}

