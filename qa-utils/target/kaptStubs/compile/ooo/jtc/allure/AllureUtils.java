package ooo.jtc.allure;

import java.lang.System;

/**
 * Объект со статическим утилитными функциями для работы с Allure.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J0\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\f\b\u0002\u0010\u0010\u001a\u00060\u000ej\u0002`\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J$\u0010\u0018\u001a\u00020\n2\b\b\u0002\u0010\u001b\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\fH\u0007J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\fH\u0007J\u0010\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0012J$\u0010$\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020(R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006\u00a8\u0006)"}, d2 = {"Looo/jtc/allure/AllureUtils;", "", "()V", "allureLifecycle", "Lio/qameta/allure/AllureLifecycle;", "getAllureLifecycle", "()Lio/qameta/allure/AllureLifecycle;", "aspectLifecycle", "getAspectLifecycle", "attach", "", "log", "Ljava/io/ByteArrayOutputStream;", "collectStepsLog", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "result", "offset", "", "steps", "", "Lio/qameta/allure/model/StepResult;", "failedStepsInAllure", "testName", "logFile", "file", "Ljava/io/File;", "fileName", "charset", "Ljava/nio/charset/Charset;", "logRequest", "stream", "logResponse", "removeStep", "", "stepId", "setStepStatus", "ex", "", "status", "Lio/qameta/allure/model/Status;", "qa-utils"})
public final class AllureUtils {
    
    /**
     * Жизненный цикл Allure, полученный из аспектов для шагов.
     */
    @org.jetbrains.annotations.NotNull()
    private static final io.qameta.allure.AllureLifecycle aspectLifecycle = null;
    
    /**
     * Жизненный цикл Allure.
     */
    @org.jetbrains.annotations.NotNull()
    private static final io.qameta.allure.AllureLifecycle allureLifecycle = null;
    public static final ooo.jtc.allure.AllureUtils INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.qameta.allure.AllureLifecycle getAspectLifecycle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.qameta.allure.AllureLifecycle getAllureLifecycle() {
        return null;
    }
    
    /**
     * Attach bytes in Allure as application/json, named as 'request'
     *
     * @param stream as [ByteArrayOutputStream]]
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Attachment(value = "request", type = "application/json")
    public final byte[] logRequest(@org.jetbrains.annotations.NotNull()
    java.io.ByteArrayOutputStream stream) {
        return null;
    }
    
    /**
     * Attach bytes in Allure as application/json, named as 'response'
     *
     * @param stream as [ByteArrayOutputStream]]
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Attachment(value = "response", type = "application/json")
    public final byte[] logResponse(@org.jetbrains.annotations.NotNull()
    java.io.ByteArrayOutputStream stream) {
        return null;
    }
    
    /**
     * Attach file in Allure as text/plain
     *
     * @param file as [File]]
     */
    @org.jetbrains.annotations.NotNull()
    @io.qameta.allure.Attachment(value = "{file}", type = "text/plain")
    public final byte[] logFile(@org.jetbrains.annotations.NotNull()
    java.io.File file) {
        return null;
    }
    
    /**
     * Attach string in Allure as text/plain
     *
     * @param fileName as [String]], default value is 'Attached'
     * @param attach as [String] - attached data
     * @param charset as [Charset]] - data charser, default value is 'UTF-8'
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNUSED_PARAMETER"})
    @io.qameta.allure.Attachment(value = "{fileName}", type = "text/plain")
    public final byte[] logFile(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.lang.String attach, @org.jetbrains.annotations.NotNull()
    java.nio.charset.Charset charset) {
        return null;
    }
    
    /**
     * Get byte array from logs for attaching to allure report.
     *
     * @param log - log as [ByteArrayOutputStream]
     * @return byte array
     */
    private final byte[] attach(java.io.ByteArrayOutputStream log) {
        return null;
    }
    
    /**
     * Set Allure steps status. Step doesn't stop there, it will steps in [StepLifecycleListener].
     *
     * @param stepId - Step id, current step by default
     * @param ex - exception, that throws into step execution
     * @param status - step Status
     */
    public final void setStepStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String stepId, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable ex, @org.jetbrains.annotations.NotNull()
    io.qameta.allure.model.Status status) {
    }
    
    /**
     * Remove step from allure report
     *
     * @param stepId as [String], default value is current step id.
     */
    public final void removeStep(@org.jetbrains.annotations.NotNull()
    java.lang.String stepId) {
    }
    
    /**
     * Collect all steps form test case into [StringBuilder] result.
     *
     * @param steps - List of [StepResult] from [AllureLifecycle]
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.StringBuilder collectStepsLog(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder result, @org.jetbrains.annotations.NotNull()
    java.lang.String offset, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends io.qameta.allure.model.StepResult> steps) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<io.qameta.allure.model.StepResult> failedStepsInAllure(@org.jetbrains.annotations.NotNull()
    java.lang.String testName) {
        return null;
    }
    
    private AllureUtils() {
        super();
    }
}