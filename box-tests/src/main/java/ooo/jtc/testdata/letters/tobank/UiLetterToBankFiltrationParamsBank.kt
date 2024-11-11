package ooo.jtc.testdata.letters.tobank

import com.codeborne.selenide.Condition
import ooo.jtc.core.container.should
import ooo.jtc.core.selenide.scrollIntoView
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.extensions.toDate
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.uaa.UserType
import ooo.jtc.ui.interfaces.UiFiltrationParam
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterBank
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerRowBank
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsStringIgnoringCase
import org.hamcrest.Matchers.equalTo
import java.time.format.DateTimeFormatter.ofPattern

enum class UiLetterToBankFiltrationParamsBank(
    override val fpName: String,
    override val fillFilterFields: (LetterToBankScrollerFilterBank, LetterToBankDto) -> Unit,
    override val checkFilteredValue: (LetterToBankScrollerRowBank, LetterToBankDto) -> Unit
) : UiFiltrationParam<LetterToBankDto, LetterToBankScrollerFilterBank, LetterToBankScrollerRowBank> {
    DOCUMENT_NUMBER(fpName = "Номер документа",
        fillFilterFields = { f, dto -> f.documentNumber.value = dto.documentNumber.takeLast(2) },
        checkFilteredValue = { row, dto ->
            assertThat(row.documentNumber.text, containsStringIgnoringCase(dto.documentNumber.takeLast(2)))
        }
    ),
    STATUS(fpName = "Статус",
        fillFilterFields = { f, dto ->
            val searchStatus = LetterToBankStatus.values.getDescriptionByStatus(dto.status!!, UserType.BANK)
            f.status.select(searchStatus)
        },
        checkFilteredValue = { row, dto ->
            val expStatus = LetterToBankStatus.values.getDescriptionByStatus(dto.status!!, UserType.CLIENT)
            assertThat(row.status.text, equalTo(expStatus))
        }
    ),
    CUSTOMER_NAME(fpName = "Наименование Клиента",
        fillFilterFields = { f, dto -> f.shortCustomerName.select(dto.customerName!!) },
        checkFilteredValue = { row, dto ->
            assertThat(row.customerName.text, containsStringIgnoringCase(dto.customerName!!))
        }
    ),
    BRANCH_NAME(fpName = "Наименование подразделения Банка",
        fillFilterFields = { f, dto -> f.branch.select(dto.branchName!!) },
        checkFilteredValue = { row, dto ->
            val actBranchName = row.branchName.text
            if (actBranchName.isBlank()) {
                val expStatus = LetterToBankStatus.values.getDescriptionByStatus(dto.status!!, UserType.CLIENT)
                assertThat(row.status.text, equalTo(expStatus))
            }
            assertThat(actBranchName, containsStringIgnoringCase(dto.branchName!!))
        }
    ),
    DOC_THEME(fpName = "Тема",
        fillFilterFields = { f, dto -> f.docTheme.value = dto.docTheme!!.takeLast(9) },
        checkFilteredValue = { row, dto ->
            assertThat(row.docTheme.text, containsStringIgnoringCase(dto.docTheme!!.takeLast(9)))
        }
    ),
    DOC_TEXT(fpName = "Текст",
        fillFilterFields = { f, dto -> f.docText.value = dto.docText!!.takeLast(15) },
        checkFilteredValue = { row, dto ->
            assertThat(row.docText.text, containsStringIgnoringCase(dto.docText!!.takeLast(15)))
        }
    ),
    IS_HAS_ATTACH(fpName = "есть файлы-вложения", //проверяем, что у каждой строки есть иконка вложения
        fillFilterFields = { f, _ -> f.isHasAttach.check() },
        checkFilteredValue = { row, _ -> row.attachIcon should Condition.visible }
    ),
    DOC_DATE(fpName = "Дата документа",
        fillFilterFields = { f, dto ->
            val documentDate = dto.documentDate
            f.docDateFrom.value = documentDate.minusDays(3).format(ofPattern(DOTS_DATE_FORMAT))
            f.docDateTo.value = documentDate.plusDays(3).format(ofPattern(DOTS_DATE_FORMAT))
        },
        checkFilteredValue = { row, dto ->
            val act = row.documentDate.scrollIntoView().text.toDate()
            val exp = dto.documentDate
            assertThat(act, Matchers.greaterThanOrEqualTo(exp))
        }
    )
    ;
}