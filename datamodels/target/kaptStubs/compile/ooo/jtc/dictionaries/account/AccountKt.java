package ooo.jtc.dictionaries.account;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u00a8\u0006\u0004"}, d2 = {"isResidentAccount", "", "accountNumber", "", "datamodels"})
public final class AccountKt {
    
    /**
     * Means that an account belongs to a resident.
     * Based on https://confluence.jtc.ooo/pages/viewpage.action?pageId=4336938 point 08.6.1
     */
    public static final boolean isResidentAccount(@org.jetbrains.annotations.NotNull()
    java.lang.String accountNumber) {
        return false;
    }
}