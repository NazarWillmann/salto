package ooo.jtc.testdata.letters.tobank

import ooo.jtc.core.selenide.scrollIntoView
import ooo.jtc.documents.getDescriptionByStatus
import ooo.jtc.extensions.DOTS_DATE_FORMAT
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus
import ooo.jtc.testdata.common.UiDateConverter.convertCreatedAtDateTime
import ooo.jtc.uaa.UserType
import ooo.jtc.ui.interfaces.UiFiltrationParam
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerFilterClient
import ooo.jtc.ui.pages.documents.lettertobank.sections.LetterToBankScrollerRowClient
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.containsStringIgnoringCase
import org.hamcrest.Matchers.empty
import org.hamcrest.Matchers.not
import java.time.format.DateTimeFormatter.ofPattern

enum class UiLetterToBankFiltrationParamsClient(
    override val fpName: String,
    override val fillFilterFields: (LetterToBankScrollerFilterClient, LetterToBankDto) -> Unit,
    override val checkFilteredValue: (LetterToBankScrollerRowClient, LetterToBankDto) -> Unit
) : UiFiltrationParam<LetterToBankDto, LetterToBankScrollerFilterClient, LetterToBankScrollerRowClient> {
    DOCUMENT_NUMBER(fpName = "Номер документа",
        fillFilterFields = { f, dto -> f.documentNumber.value = dto.documentNumber.takeLast(2) },
        checkFilteredValue = { row, dto ->
            assertThat(row.documentNumber.text, containsStringIgnoringCase(dto.documentNumber.takeLast(2)))
        }
    ),
    CONTACT_NAME(fpName = "ФИО",
        fillFilterFields = { f, dto -> f.contactName.value = dto.contactName!!.takeLast(13) },
        checkFilteredValue = { row, dto ->
            row.expand()
            assertThat(row.contactName.scrollIntoView().text, containsStringIgnoringCase(dto.contactName!!.takeLast(13)))
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
    CLIENT_STATUS(fpName = "Статус",
        fillFilterFields = { f, dto ->
            val searchStatus = LetterToBankStatus.values.getDescriptionByStatus(dto.status!!, UserType.CLIENT)
            f.status.select(searchStatus)
        },
        checkFilteredValue = { row, dto ->
            val expStatus = LetterToBankStatus.values.getDescriptionByStatus(dto.status!!, UserType.CLIENT)
            assertThat(row.status.text, Matchers.equalTo(expStatus))
        }
    ),
    BANK_RECEIVER(fpName = "Получатель",
        fillFilterFields = { f, dto -> f.branchId.select(dto.branchName!!) },
        checkFilteredValue = { row, dto ->
            row.expand()
            assertThat(row.branchName.scrollIntoView().text, containsStringIgnoringCase(dto.branchName!!))
        }
    ),
    CONTACT_PHONE(fpName = "Телефон",
        fillFilterFields = { f, dto -> f.contactPhone.value = dto.contactPhone!!.takeLast(6) },
        checkFilteredValue = { row, dto ->
            row.expand()
            assertThat(row.contactName.scrollIntoView().text, containsStringIgnoringCase(dto.contactPhone!!.takeLast(6)))
        }
    ),
    FILE_NAME(fpName = "Имя файла-вложения",
        fillFilterFields = { f, dto -> f.fileName.value = dto.attachments!![0].fileName.takeLast(7) },
        checkFilteredValue = { row, dto ->
            row.expand()
            val expName = dto.attachments!![0].fileName.takeLast(7)
            val actAttachNames = row.attachments.joinToString("") { it.text }
            assertThat("$actAttachNames не содержит $expName",actAttachNames, Matchers.containsString(expName))
        }
    ),

    IS_HAS_ATTACH(fpName = "есть файлы-вложения",
        fillFilterFields = { f, _ -> f.isHasAttach.check() },
        checkFilteredValue = { row, _ ->
            row.expand()
            assertThat(row.attachments, not(empty()))
        }
    ),
    CREATED_AT(fpName = "Дата создания",
        fillFilterFields = { f, dto ->
            val createdAt = dto.createdAt!!
            f.createDateFrom.value = createdAt.minusDays(3).format(ofPattern(DOTS_DATE_FORMAT))
            f.createDateTo.value = createdAt.plusDays(3).format(ofPattern(DOTS_DATE_FORMAT))
        },
        checkFilteredValue = { row, dto ->
            row.expand()
            val act = convertCreatedAtDateTime(row.createdAt.scrollIntoView().text).toLocalDate()
            val exp = dto.createdAt!!.toLocalDate()
            assertThat(act, Matchers.greaterThanOrEqualTo(exp))
        }
    )
    ;
}