package ooo.jtc.api.letters.tobank.tests;

import java.lang.System;

@kotlin.Suppress(names = {"ClassName"})
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a:\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"BANK_RECALL_MSG", "", "ERR_UPDATE_MSG_NEW2SIGNED", "docChecks", "Looo/jtc/api/common/checks/ApiDocumentChecks;", "Looo/jtc/letters/dto/LetterToBankDto;", "techUserId", "Ljava/util/UUID;", "historyTestBlock", "userSteps", "Looo/jtc/api/letters/tobank/steps/LetterToBankSteps;", "startingLtb", "expHistoryEntries", "", "Looo/jtc/documents/DocHistoryResponseDto;", "ltbChangeFunc", "Lkotlin/Function1;", "box-tests"})
public final class LetterToBankHistoryTestsKt {
    private static final ooo.jtc.api.common.checks.ApiDocumentChecks<ooo.jtc.letters.dto.LetterToBankDto> docChecks = null;
    private static final java.util.UUID techUserId = null;
    private static final java.lang.String ERR_UPDATE_MSG_NEW2SIGNED = "\u041e\u0431\u043d\u043e\u0432\u043b\u0435\u043d\u0438\u0435: \u041d\u043e\u0432\u044b\u0439-\u041f\u043e\u0434\u043f\u0438\u0441\u0430\u043d";
    private static final java.lang.String BANK_RECALL_MSG = "AT-recalled(History)";
    
    /**
     * Common history test block
     *
     * @param userSteps - authorized steps. Used for calling [getHistory()]-request
     * @param startingLtb - LetterToBank before change
     * @param expHistoryEntries - list of expected entries in [getHistory()]-response
     * @param ltbChangeFunc - LetterToBank change function (creation, update, signing, etc.)
     * @return LetterToBank after change
     */
    private static final ooo.jtc.letters.dto.LetterToBankDto historyTestBlock(ooo.jtc.api.letters.tobank.steps.LetterToBankSteps userSteps, ooo.jtc.letters.dto.LetterToBankDto startingLtb, java.util.List<ooo.jtc.documents.DocHistoryResponseDto> expHistoryEntries, kotlin.jvm.functions.Function1<? super ooo.jtc.letters.dto.LetterToBankDto, ooo.jtc.letters.dto.LetterToBankDto> ltbChangeFunc) {
        return null;
    }
}