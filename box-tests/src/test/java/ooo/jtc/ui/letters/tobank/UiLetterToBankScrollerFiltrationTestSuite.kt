package ooo.jtc.ui.letters.tobank

import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import ooo.jtc.UI_LETTER_TO_BANK_SCROLLER_FILTRATION
import ooo.jtc.api.letters.tobank.LetterToBankPreExecutions
import ooo.jtc.core.EntityTestGenerator
import ooo.jtc.core.TestEpic
import ooo.jtc.core.TestFeature
import ooo.jtc.core.TestStoryLetterToBank
import ooo.jtc.generic.DocumentNames
import ooo.jtc.testdata.Users
import ooo.jtc.testdata.letters.tobank.UiLetterToBankFiltrationParamsBank
import ooo.jtc.testdata.letters.tobank.UiLetterToBankFiltrationParamsClient
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankFiltrationBankTest
import ooo.jtc.ui.letters.tobank.tests.UiLetterToBankFiltrationClientTest
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode

@Epic(TestEpic.UI)
@Feature(TestFeature.LETTER_TO_BANK)
@Story(TestStoryLetterToBank.LETTER_TO_BANK_FILTRATION)
@Execution(ExecutionMode.CONCURRENT)
@DisplayName("UI. ${DocumentNames.LETTER_TO_BANK} тесты на фильтрацию (скроллер)")
@UI_LETTER_TO_BANK_SCROLLER_FILTRATION
class UiLetterToBankScrollerFiltrationTestSuite {
    //region Tags
//@formatter:off
@Tag("JTCSALTO-T1657") annotation class T1657
@Tag("JTCSALTO-T1652") annotation class T1652
@Tag("JTCSALTO-T1656") annotation class T1656
@Tag("JTCSALTO-T1649") annotation class T1649
@Tag("JTCSALTO-T1653") annotation class T1653
@Tag("JTCSALTO-T1651") annotation class T1651
@Tag("JTCSALTO-T1655") annotation class T1655
@Tag("JTCSALTO-T1659") annotation class T1659
@Tag("JTCSALTO-T1654") annotation class T1654
@Tag("JTCSALTO-T1658") annotation class T1658

@Tag("JTCSALTO-T1722") annotation class T1722
@Tag("JTCSALTO-T1723") annotation class T1723
@Tag("JTCSALTO-T1724") annotation class T1724
@Tag("JTCSALTO-T1725") annotation class T1725
@Tag("JTCSALTO-T1726") annotation class T1726
@Tag("JTCSALTO-T1727") annotation class T1727
@Tag("JTCSALTO-T1728") annotation class T1728
@Tag("JTCSALTO-T1729") annotation class T1729
@Tag("JTCSALTO-T1730") annotation class T1730
@Tag("JTCSALTO-T1742") annotation class T1742
@Tag("JTCSALTO-T1743") annotation class T1743
@Tag("JTCSALTO-T3332") annotation class T3332
@Tag("JTCSALTO-T3333") annotation class T3333
//@formatter:on
//endregion

    @T1649 // Фильтрация по полю Номер документа
    @T1651 // Фильтрация по полю Статус
    @T1652 // Фильтрация по полю Дата создания
    @T1653 // Фильтрация по полю Получатель
    @T1654 // Фильтрация по полю Тема
    @T1655 // Фильтрация по полю Текст
    @T1656 // Фильтрация по полю Имя файла-вложения
    @T1657 // Фильтрация по полю "есть файлы-вложения"
    @T1658 // Фильтрация по полю ФИО
    @T1659 // Фильтрация по полю Телефон
    @TestFactory
    internal fun letterToBankScrollerFiltrationClientTests(): List<DynamicTest> {
        val clientUser = Users.client
        val commonDto = LetterToBankPreExecutions.LTBPreExecutionReceivedWithAttach(clientUser)
        return EntityTestGenerator.generate(
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.DOCUMENT_NUMBER, commonDto).withId(T1649::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.CLIENT_STATUS, commonDto).withId(T1651::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.CREATED_AT, commonDto).withId(T1652::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.DOC_THEME, commonDto).withId(T1654::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.DOC_TEXT, commonDto).withId(T1655::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.BANK_RECEIVER, commonDto).withId(T1653::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.FILE_NAME, commonDto).withId(T1656::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.IS_HAS_ATTACH, commonDto).withId(T1657::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.CONTACT_NAME, commonDto).withId(T1658::class),
            UiLetterToBankFiltrationClientTest(clientUser, UiLetterToBankFiltrationParamsClient.CONTACT_PHONE, commonDto).withId(T1659::class)
        )
    }


    //TODO A.Stykalin [20.10.2020] these TC not automated yet because the filtered value doesn't shown at scroller row
    // JTCSALTO-T1724	1.0	Фильтрация по полю Имя файла-вложения	NEED_AT
    // JTCSALTO-T1729	1.0	Фильтрация по полю Телефон	NEED_AT
    // JTCSALTO-T1731	1.0	Фильтрация по полю ФИО	NEED_AT
    // JTCSALTO-T1742	1.0	Фильтрация по полю дата Приема документа	NEED_AT
    // JTCSALTO-T1743	1.0	Фильтрация по полю дата Обработки документа	NEED_AT
    // JTCSALTO-T3333	1.0	Фильтрация по полю Наименование Клиента. Клиент не найден в списке Клиентов	NEED_AT
    @T1722 // Фильтрация по полю "есть файлы-вложения"
    @T1723 // Фильтрация по полю Дата документа
    @T1725 // Фильтрация по полю Номер документа
    @T1726 // Фильтрация по полю Наименование подразделения банка(Получатель)
    @T1727 // Фильтрация по полю Статус
    @T1728 // Фильтрация по полю Текст
    @T1730 // Фильтрация по полю Тема
    @T3332 // Фильтрация по полю Наименование Клиента
    @TestFactory
    internal fun letterToBankScrollerFiltrationBankTests(): List<DynamicTest> {
        val bankUser = Users.bankOperator
        val commonDto = LetterToBankPreExecutions.LTBPreExecutionReceivedWithAttach(bankUser)
        return EntityTestGenerator.generate(
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.IS_HAS_ATTACH, commonDto).withId(T1722::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.DOC_DATE, commonDto).withId(T1723::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.DOCUMENT_NUMBER, commonDto).withId(T1725::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.BRANCH_NAME, commonDto).withId(T1726::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.STATUS, commonDto).withId(T1727::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.DOC_TEXT, commonDto).withId(T1728::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.DOC_THEME, commonDto).withId(T1730::class),
            UiLetterToBankFiltrationBankTest(bankUser, UiLetterToBankFiltrationParamsBank.CUSTOMER_NAME, commonDto).withId(T3332::class),
        )
    }
}