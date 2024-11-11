package ooo.jtc.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0002J\n\u0010\u0012\u001a\u00020\u0007*\u00020\u0013R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Looo/jtc/ui/UiHelper;", "", "()V", "REGEX_MXBEAN_NAME", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "uiCurrentDate", "", "getUiCurrentDate", "()Ljava/lang/String;", "getDownloadedFile", "Ljava/io/File;", "fileName", "getDownloadedFileLocal", "downloadsFolder", "getDownloadedFileRemote", "getSelenideFileDownloadFolder", "pid", "toUi", "Ljava/time/LocalDate;", "box-tests"})
public final class UiHelper {
    private static final java.util.regex.Pattern REGEX_MXBEAN_NAME = null;
    public static final ooo.jtc.ui.UiHelper INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUiCurrentDate() {
        return null;
    }
    
    /**
     * Return downloaded through UI tests file by [fileName].
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File getDownloadedFile(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    private final java.io.File getDownloadedFileLocal(java.lang.String downloadsFolder, java.lang.String fileName) {
        return null;
    }
    
    private final java.io.File getDownloadedFileRemote(java.lang.String downloadsFolder, java.lang.String fileName) {
        return null;
    }
    
    /**
     * Search folder inside [downloadsFolder] by pid and current thread.
     * @see [com.codeborne.selenide.impl.FileNamer.generateFileName]
     */
    private final java.io.File getSelenideFileDownloadFolder(java.lang.String downloadsFolder) {
        return null;
    }
    
    private final java.lang.String pid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String toUi(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate $this$toUi) {
        return null;
    }
    
    private UiHelper() {
        super();
    }
}