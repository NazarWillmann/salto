package ooo.jtc.core.kexensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"hasCustomerMultiBranch", "", "Looo/jtc/letters/LetterToBankView;", "hasUserMultiBranch", "Looo/jtc/letters/LetterFromBankView;", "box-tests"})
public final class DocViewExtensionsKt {
    
    /**
     * Check if a customer has more than one branch relations
     */
    @io.qameta.allure.Step(value = "\u0423\u0442\u043e\u0447\u043d\u0438\u0442\u044c \u0432 \u043e\u0434\u043d\u043e\u043c \u043b\u0438 \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0438 \u043e\u0431\u0441\u043b\u0443\u0436\u0438\u0432\u0430\u0435\u0442\u0441\u044f \u043a\u043b\u0438\u0435\u043d\u0442")
    public static final boolean hasCustomerMultiBranch(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterToBankView $this$hasCustomerMultiBranch) {
        return false;
    }
    
    @io.qameta.allure.Step(value = "\u0423\u0442\u043e\u0447\u043d\u0438\u0442\u044c \u0432 \u043e\u0434\u043d\u043e\u043c \u043b\u0438 \u043f\u043e\u0434\u0440\u0430\u0437\u0434\u0435\u043b\u0435\u043d\u0438\u0438 \u043e\u0431\u0441\u043b\u0443\u0436\u0438\u0432\u0430\u0435\u0442\u0441\u044f \u043a\u043b\u0438\u0435\u043d\u0442")
    public static final boolean hasUserMultiBranch(@org.jetbrains.annotations.NotNull()
    ooo.jtc.letters.LetterFromBankView $this$hasUserMultiBranch) {
        return false;
    }
}