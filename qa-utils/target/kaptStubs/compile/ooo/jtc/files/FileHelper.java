package ooo.jtc.files;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ,\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u000e"}, d2 = {"Looo/jtc/files/FileHelper;", "", "()V", "createSingleTempFile", "Ljava/io/File;", "fileName", "", "fileExt", "content", "", "createTempFiles", "", "qty", "", "qa-utils"})
public final class FileHelper {
    public static final ooo.jtc.files.FileHelper INSTANCE = null;
    
    /**
     * Creates a list of temp files which will deletes at the end of program.
     * @param fileName - `prefix` of file name
     * @param fileExt - `suffix` of file name. Extension.
     * @param qty - size of list. Also appends to [fileName].
     * @param content - content of each file.
     * !NB: just before file extension system generates a random number,
     * e.g. `fileName = "hello", fileExt = ".txt", qty = 1` => <fileName>_<qty>_<randomNumber><fileExt> => hello_1_3457235834534.txt
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.io.File> createTempFiles(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.lang.String fileExt, int qty, @org.jetbrains.annotations.NotNull()
    byte[] content) {
        return null;
    }
    
    /**
     * Creates single temporary file (will be deleted at the end of program).
     * @param fileName - `prefix` of file name
     * @param fileExt - `suffix` of file name. Extension.
     * @param content - content of file.
     * !NB: just before file extension system generates a random number,
     * e.g. `fileName = "hello", fileExt = ".txt"` => <fileName>_<randomNumber><fileExt> => hello_3457235834534.txt
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File createSingleTempFile(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.lang.String fileExt, @org.jetbrains.annotations.NotNull()
    byte[] content) {
        return null;
    }
    
    private FileHelper() {
        super();
    }
}