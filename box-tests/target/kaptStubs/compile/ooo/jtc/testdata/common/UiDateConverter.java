package ooo.jtc.testdata.common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\u000b"}, d2 = {"Looo/jtc/testdata/common/UiDateConverter;", "", "()V", "convertCreatedAtDateTime", "Ljava/time/LocalDateTime;", "s", "", "convertToUiDate", "date", "Ljava/time/ZonedDateTime;", "toMskTime", "box-tests"})
public final class UiDateConverter {
    public static final ooo.jtc.testdata.common.UiDateConverter INSTANCE = null;
    
    /**
     * Convert "Документ создан 15.07.2020 в 08:23" to LocalDateTime.
     * Convert "Документ создан сегодня в 08:23" to LocalDateTime.
     * Convert "Документ создан вчера в 08:23" to LocalDateTime.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime convertCreatedAtDateTime(@org.jetbrains.annotations.NotNull()
    java.lang.String s) {
        return null;
    }
    
    /**
     * Convert from ZonedDateTime.now() to "сегодня в 12:50".
     * Convert from ZonedDateTime.now().minusDays(1) to "вчера в 12:50".
     * Convert from ZonedDateTime.now().minusDays(2) to "01.12.2020 в 12:50".
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String convertToUiDate(@org.jetbrains.annotations.NotNull()
    java.time.ZonedDateTime date) {
        return null;
    }
    
    /**
     * Convert server time (05:00) to local (MSK) time (08:00)
     */
    private final java.time.LocalDateTime toMskTime(java.time.ZonedDateTime date) {
        return null;
    }
    
    private UiDateConverter() {
        super();
    }
}