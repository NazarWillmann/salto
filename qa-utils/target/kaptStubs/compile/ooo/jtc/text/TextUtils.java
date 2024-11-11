package ooo.jtc.text;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Looo/jtc/text/TextUtils;", "", "()V", "declensionByDigit", "", "number", "", "form1", "form234", "form567890", "qa-utils"})
public final class TextUtils {
    public static final ooo.jtc.text.TextUtils INSTANCE = null;
    
    /**
     * Returns one of declension form ([form1]||[form234]||[form567890]) of a word by last digit in [number].
     * e.g. declensionByDigit(2, form1="голубь", form234="голубя", form567890="голубей") => "голубя"
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"MoveVariableDeclarationIntoWhen"})
    public final java.lang.String declensionByDigit(int number, @org.jetbrains.annotations.NotNull()
    java.lang.String form1, @org.jetbrains.annotations.NotNull()
    java.lang.String form234, @org.jetbrains.annotations.NotNull()
    java.lang.String form567890) {
        return null;
    }
    
    private TextUtils() {
        super();
    }
}