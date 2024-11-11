package ooo.jtc.letters.model

import ooo.jtc.generic.DocumentAction
import ooo.jtc.generic.LocResourceRepository.i18nLetterToBank
import ooo.jtc.letters.dto.LetterToBankDto
import ooo.jtc.letters.model.LetterToBankStatus.DELIVERED
import ooo.jtc.letters.model.LetterToBankStatus.DETAILS_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.DRAFT
import ooo.jtc.letters.model.LetterToBankStatus.FOR_RECEIVING
import ooo.jtc.letters.model.LetterToBankStatus.IN_PROCESSING
import ooo.jtc.letters.model.LetterToBankStatus.NEW
import ooo.jtc.letters.model.LetterToBankStatus.PARTLY_SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.PROCESSED
import ooo.jtc.letters.model.LetterToBankStatus.RECALLED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVED
import ooo.jtc.letters.model.LetterToBankStatus.RECEIVING_ERROR
import ooo.jtc.letters.model.LetterToBankStatus.SIGNED
import ooo.jtc.letters.model.LetterToBankStatus.WRONG_ESIGNATURE

// Действия добавлены согласно ТЗ (2020.07.23) https://confluence.jtc.ooo/pages/viewpage.action?pageId=21725513 п. 5.2
// src/main/resources/i18n/letter-to-bank-ru.json
enum class LetterToBankActions(
    override val actionName: String,
    override val statuses: List<LetterToBankStatus>,
    override val title: String,
    override val i18nMap: Map<String, String>
) : DocumentAction<LetterToBankDto> {
    VIEW(
        "View",
        listOf(
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.view]]",
        i18nLetterToBank
    ),
    EDIT("Edit", listOf(DRAFT, NEW), "[[document.LetterToBank.action.edit]]", i18nLetterToBank),
    COPY(
        "Copy",
        listOf(
            NEW,
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.copy]]",
        i18nLetterToBank
    ),
    DELETE("Delete", listOf(DRAFT, NEW), "[[document.LetterToBank.action.delete]]", i18nLetterToBank),
    PRINT(
        "Print",
        listOf(
            DRAFT,
            NEW,
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.print]]",
        i18nLetterToBank
    ),
    PRINT_REGISTER(
        "Print",
        listOf(
            DRAFT,
            NEW,
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.printRegister]]",
        i18nLetterToBank
    ),
    EXPORT(
        "Export",
        listOf(
            DRAFT,
            NEW,
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.export]]",
        i18nLetterToBank
    ),
    VIEW_HISTORY(
        "ViewHistory",
        listOf(
            DRAFT,
            NEW,
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.viewHistory]]",
        i18nLetterToBank
    ),
    SIGN("Sign", listOf(NEW, PARTLY_SIGNED), "[[document.LetterToBank.action.sign]]", i18nLetterToBank),
    SIGN_AND_SEND("SignAndSend", listOf(NEW, PARTLY_SIGNED), "[[document.LetterToBank.action.signAndSend]]", i18nLetterToBank),
    UNSIGN("Unsign", listOf(NEW, PARTLY_SIGNED), "[[document.LetterToBank.action.unsign]]", i18nLetterToBank),
    VALIDATE_SIGN(
        "ValidateSign",
        listOf(
            PARTLY_SIGNED,
            SIGNED,
            DELIVERED,
            FOR_RECEIVING,
            RECEIVING_ERROR,
            RECEIVED,
            IN_PROCESSING,
            WRONG_ESIGNATURE,
            DETAILS_ERROR,
            RECALLED,
            PROCESSED
        ),
        "[[document.LetterToBank.action.validateSign]]",
        i18nLetterToBank
    ),
    SEND("Send", listOf(SIGNED), "[[document.LetterToBank.action.unsign]]", i18nLetterToBank)
    ;

    companion object {
        fun getActionsBy(status: LetterToBankStatus): List<LetterToBankActions> {
            return values().filter { status in it.statuses }
        }

        fun getActionsUiTextBy(status: LetterToBankStatus): List<String> {
            return values().filter { status in it.statuses }.map { it.getUiName() }
        }
    }
}