package ooo.jtc.be.curtransfer

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.BE_CUR_TRANSFER_CRUD
import ooo.jtc.api.curtransfer.tests.BankCurTransferGetPageTest
import ooo.jtc.api.curtransfer.tests.BankCurTransferGetTest
import ooo.jtc.api.curtransfer.tests.ClientCurTransferCreateTest
import ooo.jtc.api.curtransfer.tests.ClientCurTransferDeleteTest
import ooo.jtc.api.curtransfer.tests.ClientCurTransferGetPageTest
import ooo.jtc.api.curtransfer.tests.ClientCurTransferGetTest
import ooo.jtc.api.curtransfer.tests.ClientCurTransferUpdateTest
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryCurTransfer
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.API)
@Feature(TestFeature.CUR_TRANSFER)
@Story(TestStoryCurTransfer.CUR_TRANSFER_CRUD)
@DisplayName("API '${DocumentNames.CUR_TRANSFER}' CRUD suite")
@Execution(ExecutionMode.CONCURRENT)
@BE_CUR_TRANSFER_CRUD
class CurTransferCrudTestsSuite {

    private val clientUser = Users.client
    private val bankUser = Users.bankOperator

    @TestFactory
    internal fun curTransferCrudClientTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                ClientCurTransferCreateTest(clientUser),
                ClientCurTransferGetTest(clientUser),
                ClientCurTransferGetPageTest(clientUser),
                ClientCurTransferUpdateTest(clientUser),
                ClientCurTransferDeleteTest(clientUser)
            )
        )
    }

    //TODO Sergeyev [2021.01.25]: hidden until sign/send-methods are ready
    //@TestFactory
    internal fun curTransferCrudBankTests(): List<DynamicTest> {
        return EntityTestGenerator.generate(
            listOf(
                BankCurTransferGetTest(bankUser),
                BankCurTransferGetPageTest(bankUser)
            )
        )
    }
}