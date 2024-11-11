package ooo.jtc.ui.rupayment

import com.codeborne.selenide.Condition
import ooo.jtc.api.rupayment.RuPaymentSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.core.TestConstants.SMS_CODE_FOR_SIGN_DOCUMENTS
import ooo.jtc.core.container.should
import ooo.jtc.core.elements.AllElements.elementByText
import ooo.jtc.core.elements.AllElements.textButton
import ooo.jtc.extensions.getOrException
import ooo.jtc.generic.Mappers
import ooo.jtc.rupayment.RuPaymentView
import ooo.jtc.rupayment.dto.RuPaymentDto
import ooo.jtc.rupayment.model.UserPaymentType
import ooo.jtc.testdata.Users
import ooo.jtc.uaa.User
import ooo.jtc.ui.application.ClientApplication.ruPaymentScrollerPage
import ooo.jtc.ui.common.sections.CommonSections.modalConfirmRemoving
import ooo.jtc.ui.common.sections.CommonSections.modalSendDocument
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.pages.documents.rupayment.forms.BudgetRuPaymentEditPage
import ooo.jtc.ui.pages.documents.rupayment.forms.CreatePaymentPage
import ooo.jtc.ui.pages.documents.rupayment.forms.CustomRuPaymentEditPage
import ooo.jtc.ui.pages.documents.rupayment.forms.OrganizationRuPaymentEditPage
import ooo.jtc.ui.pages.documents.rupayment.forms.OtherRuPaymentEditPage
import ooo.jtc.ui.pages.documents.rupayment.forms.PersonRuPaymentEditPage
import ooo.jtc.ui.pages.documents.rupayment.forms.TaxRuPaymentEditPage
import ooo.jtc.ui.pages.documents.rupayment.scroller.RuPaymentScrollerCategory.FOR_SEND
import ooo.jtc.ui.pages.documents.rupayment.scroller.RuPaymentScrollerCategory.FOR_SIGNATURE
import ooo.jtc.ui.pages.documents.rupayment.sections.RuPaymentModalSignDocument

object RuPaymentTests {

    class UiRuPaymentCreateTest(name: String, user: User = Users.client, ruPaymentDto: RuPaymentDto) : AbstractUiTest<RuPaymentView, Unit>(
        name = name,
        params = { mapOf(PARAM_USER to user, "РПП" to it!!) },
        preExecution = { Mappers.ruPaymentViewMapper.toView(ruPaymentDto) },
        testBody = {
            ruPaymentScrollerPage.openScrollerBy(user, it!!.customerId)
            ruPaymentScrollerPage.textButton["Создать платеж"].click()
            val createRuPaymentPage = ruPaymentScrollerPage.createPaymentModalWindow.selectRuPaymentType(it)
            createRuPaymentPage.fill(it)
            createRuPaymentPage.save.click()
            ruPaymentScrollerPage.elementByText["Документ успешно сохранён"] should Condition.visible
        }
    )

    class UiRuPaymentCopyTest(name: String, user: User = Users.client, ruPaymentDto: RuPaymentDto) : AbstractUiTest<RuPaymentView, Unit>(
        name = name,
        params = { mapOf(PARAM_USER to user, "РПП" to it!!) },
        preExecution = { Mappers.ruPaymentViewMapper.toView(RuPaymentSteps(user).create(ruPaymentDto).data!!) },
        testBody = {
            val editRuPaymentPage = getRuPaymentEditPage(it!!)
            editRuPaymentPage openScrollerBy user
            editRuPaymentPage.textButton["Повторить"].click()
            editRuPaymentPage.checkEditFromFilledCorrect(it)
        }
    )


    class UiRuPaymentSignTest(name: String, user: User = Users.client, ruPaymentDto: RuPaymentDto) : AbstractUiTest<RuPaymentView, Unit>(
        name = name,
        params = { mapOf(PARAM_USER to user, "РПП" to it!!) },
        preExecution = { Mappers.ruPaymentViewMapper.toView(RuPaymentSteps(user).create(ruPaymentDto).data!!) },
        testBody = {
            ruPaymentScrollerPage openScrollerBy user
            ruPaymentScrollerPage.sidebarMenu.selectCustomer(it!!.payerName)
            ruPaymentScrollerPage.openTab(FOR_SIGNATURE)
            val row = ruPaymentScrollerPage.scroller.getRowById(it.id!!, it.documentNumber)
            row.moreButtonMenu.click()
            row.moreButtonMenu.item["Подписать"].click()
            val modalSignDocument = RuPaymentModalSignDocument()
            modalSignDocument.code should Condition.visible
            modalSignDocument.signBtn should Condition.visible
            modalSignDocument.cancelBtn should Condition.visible
            modalSignDocument.code.value = SMS_CODE_FOR_SIGN_DOCUMENTS
            modalSignDocument.signBtn.click()
            modalSignDocument.elementByText["Успешно подписано"]
            modalSignDocument.elementByText[it.amountAntie] should Condition.visible
            modalSignDocument.elementByText["Подписан"] should Condition.visible
            modalSignDocument.closeButton should Condition.visible
        }
    )

    class UiRuPaymentDeleteTest(name: String, user: User = Users.client, ruPaymentDto: RuPaymentDto) : AbstractUiTest<RuPaymentView, Unit>(
        name = name,
        params = { mapOf(PARAM_USER to user, "РПП" to it!!) },
        preExecution = { Mappers.ruPaymentViewMapper.toView(RuPaymentSteps(user).create(ruPaymentDto).data!!) },
        testBody = {
            ruPaymentScrollerPage openScrollerBy user
            ruPaymentScrollerPage.sidebarMenu.selectCustomer(it!!.payerName)
            ruPaymentScrollerPage.openTab(FOR_SIGNATURE)
            val row = ruPaymentScrollerPage.scroller.getRowById(it.id!!, it.documentNumber)
            row.moreButtonMenu.click()
            row.moreButtonMenu.item["Удалить"].click()
            modalConfirmRemoving should Condition.visible
            modalConfirmRemoving.confirm should Condition.visible
            modalConfirmRemoving.decline should Condition.visible
            modalConfirmRemoving.confirm.click()
            ruPaymentScrollerPage.elementByText["Документ №${it.documentNumber} был успешно удален"] should Condition.visible
        }
    )

    class UiRuPaymentSendTest(name: String, user: User = Users.client, ruPaymentDto: RuPaymentDto) : AbstractUiTest<RuPaymentView, Unit>(
        name = name,
        params = { mapOf(PARAM_USER to user, "РПП" to it!!) },
        preExecution = {
            val steps = RuPaymentSteps(user)
            val createdRuPaymentDto = steps.create(ruPaymentDto).data!!
            val sentRuPaymentDto = steps.signDocumentBySms(createdRuPaymentDto).data
                .getOrException("Подписание прошло неудачно")
            Mappers.ruPaymentViewMapper.toView(sentRuPaymentDto)
        },
        testBody = {
            ruPaymentScrollerPage openScrollerBy user
            ruPaymentScrollerPage.sidebarMenu.selectCustomer(it!!.payerName)
            ruPaymentScrollerPage.openTab(FOR_SEND)
            val row = ruPaymentScrollerPage.scroller.getRowById(it.id!!, it.documentNumber)
            row.moreButtonMenu.click()
            row.moreButtonMenu.item["Отправить"].click()
            modalSendDocument should Condition.visible
            modalSendDocument.elementByText[it.amountAntie] should Condition.visible
            modalSendDocument.elementByText["Принят в обработку"] should Condition.visible
        }
    )

    private fun getRuPaymentEditPage(view: RuPaymentView): CreatePaymentPage =
        when (view.userPaymentType!!) {
            UserPaymentType.BUDGET -> BudgetRuPaymentEditPage(view.id!!)
            UserPaymentType.BUSINESS -> OrganizationRuPaymentEditPage(view.id!!)
            UserPaymentType.CUSTOM -> CustomRuPaymentEditPage(view.id!!)
            UserPaymentType.OTHER -> OtherRuPaymentEditPage(view.id!!)
            UserPaymentType.OWNACCOUNTS -> OrganizationRuPaymentEditPage(view.id!!)
            UserPaymentType.PERSON -> PersonRuPaymentEditPage(view.id!!)
            UserPaymentType.TAX -> TaxRuPaymentEditPage(view.id!!)
        }
}