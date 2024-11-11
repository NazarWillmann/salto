package ooo.jtc.core;

import java.lang.System;

/**
 * Regexp constants for [com.mifmif.common.regex.Generex]
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Looo/jtc/core/RegexpConst;", "", "()V", "LAT_RUS_NUM", "", "UI_EVENT_TIME_REGEX", "UPPER_LAT", "UPPER_LAT_NUM_SPC", "UPPER_LAT_NUM_UND", "box-tests"})
public final class RegexpConst {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LAT_RUS_NUM = "[\\x20-\\x7E\u0430-\u044f\u0410-\u042f]*\u2116";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPPER_LAT = "[A-Z]*";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPPER_LAT_NUM_UND = "[0-9A-Z_]*";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UPPER_LAT_NUM_SPC = "[0-9A-Z ]*";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String UI_EVENT_TIME_REGEX = "(\u0441\u0435\u0433\u043e\u0434\u043d\u044f|\u0432\u0447\u0435\u0440\u0430|\\d{2}.\\d{2}.\\d{4}) \u0432 \\d{2}:\\d{2}";
    public static final ooo.jtc.core.RegexpConst INSTANCE = null;
    
    private RegexpConst() {
        super();
    }
}