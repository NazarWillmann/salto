package ooo.jtc.api.letters.tobank.tests;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\t\u0012 \u0010\n\u001a\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u000b\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Looo/jtc/api/letters/tobank/tests/LetterToBankBatchLifecycleTest;", "Looo/jtc/api/common/tests/AbstractBeTest;", "", "Looo/jtc/letters/dto/LetterToBankDto;", "user", "Looo/jtc/uaa/User;", "statusTransition", "", "preExecution", "Lkotlin/Function0;", "testBody", "Lkotlin/Function1;", "(Looo/jtc/uaa/User;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "box-tests"})
@ooo.jtc.core.tm4j.HighPriority()
@ooo.jtc.core.tm4j.ComponentFreeFormatDoc()
@LetterToBankFolderLifecycle()
@LetterToBankTaskIdsLifecycleApi()
public final class LetterToBankBatchLifecycleTest extends ooo.jtc.api.common.tests.AbstractBeTest<java.util.List<? extends ooo.jtc.letters.dto.LetterToBankDto>, java.util.List<? extends ooo.jtc.letters.dto.LetterToBankDto>> {
    
    public LetterToBankBatchLifecycleTest(@org.jetbrains.annotations.NotNull()
    ooo.jtc.uaa.User user, @org.jetbrains.annotations.NotNull()
    java.lang.String statusTransition, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<? extends java.util.List<ooo.jtc.letters.dto.LetterToBankDto>> preExecution, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.util.List<ooo.jtc.letters.dto.LetterToBankDto>, ? extends java.util.List<ooo.jtc.letters.dto.LetterToBankDto>> testBody) {
        super(null, null, null, null, null, null);
    }
}