package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.paymentpriority.PaymentPriorityPrepareSteps.getPaymentPriorityDtoForCreate
import ooo.jtc.api.dictionaries.paymentpriority.PaymentPrioritySteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.paymentpriority.PaymentPriorityView
import ooo.jtc.generic.Mappers.paymentPriorityViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.paymentPriorityFormPage
import ooo.jtc.ui.application.BankApplication.paymentPriorityScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiPaymentPriorityCreateTest : AbstractUiTest<PaymentPriorityView, PaymentPriorityView>(
        name = "Создание записи",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
        preExecution = { paymentPriorityViewMapper.toView(getPaymentPriorityDtoForCreate()) },
        testBody = { UiDictionaryTestsBody.createEntity(it!!, paymentPriorityScrollerPage, paymentPriorityFormPage) },
        postExecution = { PaymentPrioritySteps(Users.bankAdmin).deleteByCodeAndDescription(code = it.code, description = it.description) }
    )

    class UiPaymentPriorityDeleteTest : AbstractUiTest<List<PaymentPriorityView>, Unit>(
        name = "Групповое действие. Удалить-Удалить",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
        preExecution = {
            listOf(getPaymentPriorityDtoForCreate(), getPaymentPriorityDtoForCreate())
                .map { PaymentPrioritySteps(Users.bankAdmin).create(it).data!! }
                .map { paymentPriorityViewMapper.toView(it) }
        },
        testBody = { UiDictionaryTestsBody.deleteSomeEntities(it!!, paymentPriorityScrollerPage) }
    )