package ooo.jtc.core.tm4j;

import java.lang.System;

/**
 * Test case dto for create and update in TM4J.
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b=\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u00c5\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0014H\u00c6\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0016H\u00c6\u0003J\u0017\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nH\u00c6\u0003J\u0011\u0010M\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u00c6\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u00ce\u0001\u0010Q\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00c6\u0001\u00a2\u0006\u0002\u0010RJ\u0013\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010V\u001a\u00020\u0007H\u00d6\u0001J\t\u0010W\u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B\u00a8\u0006X"}, d2 = {"Looo/jtc/core/tm4j/Tm4jTestCase;", "", "component", "", "customFields", "", "estimatedTime", "", "folder", "issueLinks", "", "labels", "", "name", "objective", "owner", "precondition", "priority", "projectKey", "status", "Looo/jtc/core/tm4j/Tm4jTestCaseStatus;", "testScript", "Looo/jtc/core/tm4j/TestScript;", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/core/tm4j/Tm4jTestCaseStatus;Looo/jtc/core/tm4j/TestScript;)V", "getComponent", "()Ljava/lang/String;", "setComponent", "(Ljava/lang/String;)V", "getCustomFields", "()Ljava/util/Map;", "setCustomFields", "(Ljava/util/Map;)V", "getEstimatedTime", "()Ljava/lang/Integer;", "setEstimatedTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getFolder", "setFolder", "getIssueLinks", "()Ljava/util/Set;", "setIssueLinks", "(Ljava/util/Set;)V", "getLabels", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", "getName", "setName", "getObjective", "setObjective", "getOwner", "setOwner", "getPrecondition", "setPrecondition", "getPriority", "setPriority", "getProjectKey", "setProjectKey", "getStatus", "()Looo/jtc/core/tm4j/Tm4jTestCaseStatus;", "setStatus", "(Looo/jtc/core/tm4j/Tm4jTestCaseStatus;)V", "getTestScript", "()Looo/jtc/core/tm4j/TestScript;", "setTestScript", "(Looo/jtc/core/tm4j/TestScript;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/Set;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/core/tm4j/Tm4jTestCaseStatus;Looo/jtc/core/tm4j/TestScript;)Looo/jtc/core/tm4j/Tm4jTestCase;", "equals", "", "other", "hashCode", "toString", "box-tests"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public final class Tm4jTestCase {
    @org.jetbrains.annotations.Nullable()
    private java.lang.String component;
    @org.jetbrains.annotations.Nullable()
    private java.util.Map<java.lang.String, ? extends java.lang.Object> customFields;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer estimatedTime;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String folder;
    @org.jetbrains.annotations.Nullable()
    private java.util.Set<java.lang.String> issueLinks;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<java.lang.String> labels;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String objective;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String owner;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String precondition;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String priority;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String projectKey;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.core.tm4j.Tm4jTestCaseStatus status;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.core.tm4j.TestScript testScript;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getComponent() {
        return null;
    }
    
    public final void setComponent(@org.jetbrains.annotations.Nullable()
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
    public final java.lang.Integer getEstimatedTime() {
        return null;
    }
    
    public final void setEstimatedTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFolder() {
        return null;
    }
    
    public final void setFolder(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Set<java.lang.String> getIssueLinks() {
        return null;
    }
    
    public final void setIssueLinks(@org.jetbrains.annotations.Nullable()
    java.util.Set<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getLabels() {
        return null;
    }
    
    public final void setLabels(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getObjective() {
        return null;
    }
    
    public final void setObjective(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOwner() {
        return null;
    }
    
    public final void setOwner(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPrecondition() {
        return null;
    }
    
    public final void setPrecondition(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProjectKey() {
        return null;
    }
    
    public final void setProjectKey(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.core.tm4j.Tm4jTestCaseStatus getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.Tm4jTestCaseStatus p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.core.tm4j.TestScript getTestScript() {
        return null;
    }
    
    public final void setTestScript(@org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.TestScript p0) {
    }
    
    public Tm4jTestCase(@org.jetbrains.annotations.Nullable()
    java.lang.String component, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> customFields, @org.jetbrains.annotations.Nullable()
    java.lang.Integer estimatedTime, @org.jetbrains.annotations.Nullable()
    java.lang.String folder, @org.jetbrains.annotations.Nullable()
    java.util.Set<java.lang.String> issueLinks, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> labels, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String objective, @org.jetbrains.annotations.Nullable()
    java.lang.String owner, @org.jetbrains.annotations.Nullable()
    java.lang.String precondition, @org.jetbrains.annotations.Nullable()
    java.lang.String priority, @org.jetbrains.annotations.Nullable()
    java.lang.String projectKey, @org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.Tm4jTestCaseStatus status, @org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.TestScript testScript) {
        super();
    }
    
    public Tm4jTestCase() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Map<java.lang.String, java.lang.Object> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Set<java.lang.String> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.core.tm4j.Tm4jTestCaseStatus component13() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.core.tm4j.TestScript component14() {
        return null;
    }
    
    /**
     * Test case dto for create and update in TM4J.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.core.tm4j.Tm4jTestCase copy(@org.jetbrains.annotations.Nullable()
    java.lang.String component, @org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, ? extends java.lang.Object> customFields, @org.jetbrains.annotations.Nullable()
    java.lang.Integer estimatedTime, @org.jetbrains.annotations.Nullable()
    java.lang.String folder, @org.jetbrains.annotations.Nullable()
    java.util.Set<java.lang.String> issueLinks, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> labels, @org.jetbrains.annotations.Nullable()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    java.lang.String objective, @org.jetbrains.annotations.Nullable()
    java.lang.String owner, @org.jetbrains.annotations.Nullable()
    java.lang.String precondition, @org.jetbrains.annotations.Nullable()
    java.lang.String priority, @org.jetbrains.annotations.Nullable()
    java.lang.String projectKey, @org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.Tm4jTestCaseStatus status, @org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.TestScript testScript) {
        return null;
    }
    
    /**
     * Test case dto for create and update in TM4J.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Test case dto for create and update in TM4J.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Test case dto for create and update in TM4J.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}