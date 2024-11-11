package ooo.jtc.ui.dictionaries.tests

import ooo.jtc.api.dictionaries.paymenttype.PaymentTypePrepareSteps.getPaymentTypeDtoForCreate
import ooo.jtc.api.dictionaries.paymenttype.PaymentTypeSteps
import ooo.jtc.core.TestConstants.PARAM_USER
import ooo.jtc.dictionaries.paymenttype.PaymentTypeView
import ooo.jtc.generic.Mappers.paymentTypeViewMapper
import ooo.jtc.testdata.Users
import ooo.jtc.ui.application.BankApplication.paymentTypeFormPage
import ooo.jtc.ui.application.BankApplication.paymentTypeScrollerPage
import ooo.jtc.ui.common.templates.AbstractUiTest
import ooo.jtc.ui.dictionaries.UiDictionaryTestsBody

class UiPaymentTypeCreateTest : AbstractUiTest<PaymentTypeView, PaymentTypeView>(
        name = "Создание записи",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект создания" to it!!) },
        preExecution = { paymentTypeViewMapper.toView(getPaymentTypeDtoForCreate()) },
        testBody = { UiDictionaryTestsBody.createEntity(it!!, paymentTypeScrollerPage, paymentTypeFormPage) },
        postExecution = { PaymentTypeSteps(Users.bankAdmin).deleteByCodeAndDescription(code = it.code, description = it.description) }
    )

    class UiPaymentTypeDeleteTest : AbstractUiTest<PaymentTypeView, Unit>(
        name = "Удаление записи",
        params = { mapOf(PARAM_USER to Users.bankAdmin, "Объект удаления" to it!!) },
        preExecution = {
            var forCreate = getPaymentTypeDtoForCreate()
            forCreate = PaymentTypeSteps(Users.bankAdmin).create(forCreate).data!!
            paymentTypeViewMapper.toView(forCreate)
        },
        testBody = { UiDictionaryTestsBody.deleteSomeEntities(listOf(it!!), paymentTypeScrollerPage) }
    )