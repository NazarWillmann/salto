package ooo.jtc.ui.common.pages;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Looo/jtc/ui/common/pages/ApplicationPageType;", "", "uiName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getUiName", "()Ljava/lang/String;", "isBank", "", "isClient", "CLIENT_PAGE", "BANK_PAGE", "box-tests"})
public enum ApplicationPageType {
    /*public static final*/ CLIENT_PAGE /* = new CLIENT_PAGE(null) */,
    /*public static final*/ BANK_PAGE /* = new BANK_PAGE(null) */;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String uiName = null;
    
    public final boolean isBank() {
        return false;
    }
    
    public final boolean isClient() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUiName() {
        return null;
    }
    
    ApplicationPageType(java.lang.String uiName) {
    }
}