package ooo.jtc.ui.common.sections.modals

import io.qameta.allure.Step
import ooo.jtc.core.TestConstants
import ooo.jtc.core.container.withTitle
import ooo.jtc.core.elements.AllElements.dropdown
import ooo.jtc.core.elements.AllElements.input
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.core.elements.DocumentCounter
import ooo.jtc.core.elements.DocumentCounter.DocumentCounterType.INFO
import ooo.jtc.core.elements.ElementType
import ooo.jtc.core.elements.ModalWindow
import ooo.jtc.interfaces.IDocumentView
import ooo.jtc.sign.SignToolType

@ElementType("Форма подписания документа")
abstract class ModalSignDocument<V : IDocumentView> : ModalWindow() {

    override val headerText: String = "Подписать"

    val docCounter get() = DocumentCounter(parentElement = this, dataType = INFO)

    val signBtn get() = textButton["Подписать"]
    val cancelBtn get() = textButton["Отменить"]

    val closeButton get() = textButton["Закрыть"]
    val code get() = input["code"]
    val selectedCertificate get() = dropdown["selectedCertificate"].withTitle("Доступные сертификаты")

    abstract fun checkModalOpened(expDocCount: Int, expDocCounterText: String)

    abstract fun checkDocsPreview(expDocList: List<V>)

    //TODO A.Stykalin [15.10.2020] возможно придется убрать метод в конкретные реализации и нужно будет допиливать, если будет не заглушечный смс-код
    @Step("Подписать документ(-ы) [{signToolType.type}]")
    fun sign(signToolType: SignToolType, certUserName: String? = null) {
        when (signToolType) {
            SignToolType.SMS -> {
                val smsCode = TestConstants.SMS_CODE_FOR_SIGN_DOCUMENTS
                code.value = smsCode
                signBtn.click(false)
            }
            SignToolType.CRYPTO -> {
                if (certUserName == null) throw RuntimeException("certUserName is null. You can't sign document by CRYPTO without `certUserName`")
                selectedCertificate.select(certUserName)
                signBtn.click(false)
            }
            SignToolType.CRYPTO_AUTO -> TODO()
        }
    }
}