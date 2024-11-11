package ooo.jtc.core.tm4j;

import java.lang.System;

/**
 * Test result dto for update test case in TM4J run.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u00c6\u0003J\t\u00107\u001a\u00020\u0012H\u00c6\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0017\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bH\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\u0011\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH\u00c6\u0003J\u00a8\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u00c6\u0001\u00a2\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010E\u001a\u00020\fH\u00d6\u0001J\t\u0010F\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0015\"\u0004\b%\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010*\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u0006G"}, d2 = {"Looo/jtc/core/tm4j/Tm4jTestResult;", "", "actualEndDate", "", "actualStartDate", "assignedTo", "comment", "customFields", "", "environment", "executedBy", "executionTime", "", "issueLinks", "", "scriptResults", "Looo/jtc/core/tm4j/StepResult;", "status", "Looo/jtc/core/tm4j/Tm4jStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Looo/jtc/core/tm4j/Tm4jStatus;)V", "getActualEndDate", "()Ljava/lang/String;", "setActualEndDate", "(Ljava/lang/String;)V", "getActualStartDate", "setActualStartDate", "getAssignedTo", "setAssignedTo", "getComment", "setComment", "getCustomFields", "()Ljava/util/Map;", "setCustomFields", "(Ljava/util/Map;)V", "getEnvironment", "setEnvironment", "getExecutedBy", "setExecutedBy", "getExecutionTime", "()Ljava/lang/Integer;", "setExecutionTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIssueLinks", "()Ljava/util/List;", "setIssueLinks", "(Ljava/util/List;)V", "getScriptResults", "setScriptResults", "getStatus", "()Looo/jtc/core/tm4j/Tm4jStatus;", "setStatus", "(Looo/jtc/core/tm4j/Tm4jStatus;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Looo/jtc/core/tm4j/Tm4jStatus;)Looo/jtc/core/tm4j/Tm4jTestResult;", "equals", "", "other", "hashCode", "toString", "box-tests"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public final class Tm4jTestResult {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String actualEndDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String actualStartDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String assignedTo;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String comment;
    @org.jetbrains.annotations.Nullable()
    private java.util.Map<java.lang.String, ? extends java.lang.Object> customFields;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String environment;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String executedBy;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer executionTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> issueLinks;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.core.tm4j.StepResult> scriptResults;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.core.tm4j.Tm4jStatus status;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActualEndDate() {
        return null;
    }
    
    public final void setActualEndDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getActualStartDate() {
        return null;
    }
    
    public final void setActualStartDate(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAssignedTo() {
        return null;
    }
    
    public final void setAssignedTo(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getComment() {
        return null;
    }
    
    public final void setComment(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, java.lang.Object> getCustomFields() {
        return null;
    }
    
    public final void setCustomFields(@org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getEnvironment() {
        return null;
    }
    
    public final void setEnvironment(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getExecutedBy() {
        return null;
    }
    
    public final void setExecutedBy(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getExecutionTime() {
        return null;
    }
    
    public final void setExecutionTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getIssueLinks() {
        return null;
    }
    
    public final void setIssueLinks(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.core.tm4j.StepResult> getScriptResults() {
        return null;
    }
    
    public final void setScriptResults(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.core.tm4j.StepResult> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.Tm4jStatus getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jStatus p0) {
    }
    
    public Tm4jTestResult(@org.jetbrains.annotations.Nullable()
    java.lang.String actualEndDate, @org.jetbrains.annotations.Nullable()
    java.lang.String actualStartDate, @org.jetbrains.annotations.Nullable()
    java.lang.String assignedTo, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> customFields, @org.jetbrains.annotations.Nullable()
    java.lang.String environment, @org.jetbrains.annotations.Nullable()
    java.lang.String executedBy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer executionTime, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> issueLinks, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.core.tm4j.StepResult> scriptResults, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jStatus status) {
        super();
    }
    
    public Tm4jTestResult() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, java.lang.Object> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.core.tm4j.StepResult> component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.Tm4jStatus component11() {
        return null;
    }
    
    /**
     * Test result dto for update test case in TM4J run.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.Tm4jTestResult copy(@org.jetbrains.annotations.Nullable()
    java.lang.String actualEndDate, @org.jetbrains.annotations.Nullable()
    java.lang.String actualStartDate, @org.jetbrains.annotations.Nullable()
    java.lang.String assignedTo, @org.jetbrains.annotations.Nullable()
    java.lang.String comment, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> customFields, @org.jetbrains.annotations.Nullable()
    java.lang.String environment, @org.jetbrains.annotations.Nullable()
    java.lang.String executedBy, @org.jetbrains.annotations.Nullable()
    java.lang.Integer executionTime, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> issueLinks, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.core.tm4j.StepResult> scriptResults, @org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jStatus status) {
        return null;
    }
    
    /**
     * Test result dto for update test case in TM4J run.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Test result dto for update test case in TM4J run.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Test result dto for update test case in TM4J run.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}