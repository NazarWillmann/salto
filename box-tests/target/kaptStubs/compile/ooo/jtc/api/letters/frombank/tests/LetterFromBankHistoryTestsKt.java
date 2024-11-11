package ooo.jtc.api.letters.frombank.tests;

import java.lang.System;

@kotlin.Suppress(names = {"ClassName"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\tH\u0002\u00a8\u0006\n"}, d2 = {"historyTestBlock", "Looo/jtc/letters/dto/LetterFromBankDto;", "userSteps", "Looo/jtc/api/letters/frombank/steps/LetterFromBankSteps;", "startingLetter", "expHistoryEntries", "", "Looo/jtc/documents/DocHistoryResponseDto;", "letterChangeFunc", "Lkotlin/Function1;", "box-tests"})
public final class LetterFromBankHistoryTestsKt {
    
    /**
     * Common history test block
     *
     * @param userSteps - authorized steps. Used for calling [getHistory()]-request
     * @param startingLetter - LetterFromBank before change
     * @param expHistoryEntries - list of expected entries in [getHistory()]-response
     * @param letterChangeFunc - LetterFromBank change function (creation, update, signing, etc.)
     * @return LetterFromBank after change
     */
    private static final ooo.jtc.letters.dto.LetterFromBankDto historyTestBlock(ooo.jtc.api.letters.frombank.steps.LetterFromBankSteps userSteps, ooo.jtc.letters.dto.LetterFromBankDto startingLetter, java.util.List<ooo.jtc.documents.DocHistoryResponseDto> expHistoryEntries, kotlin.jvm.functions.Function1<? super ooo.jtc.letters.dto.LetterFromBankDto, ooo.jtc.letters.dto.LetterFromBankDto> letterChangeFunc) {
        return null;
    }
}