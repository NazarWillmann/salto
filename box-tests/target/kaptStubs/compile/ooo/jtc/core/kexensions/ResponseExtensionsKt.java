package ooo.jtc.core.kexensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0007\u00a8\u0006\u0007"}, d2 = {"asFile", "Ljava/io/File;", "Lio/restassured/response/Response;", "filePath", "", "getContentAsByteArray", "", "box-tests"})
public final class ResponseExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Step(value = "\u0418\u0437\u0432\u043b\u0435\u0447\u044c \u0438\u0437 \u043e\u0442\u0432\u0435\u0442\u0430 \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 \u0432 \u0432\u0438\u0434\u0435 \u043c\u0430\u0441\u0441\u0438\u0432\u0430 \u0431\u0430\u0439\u0442")
    public static final byte[] getContentAsByteArray(@org.jetbrains.annotations.NotNull()
    io.restassured.response.Response $this$getContentAsByteArray) {
        return null;
    }
    
    /**
     * Store [Response] as file.
     * !!Important: use forward slash "/" in path, for creating correct directory.
     * @param filePath - path to file. e.g. "target/downloads/test.txt"
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.io.File asFile(@org.jetbrains.annotations.NotNull()
    io.restassured.response.Response $this$asFile, @org.jetbrains.annotations.NotNull()
    java.lang.String filePath) {
        return null;
    }
}