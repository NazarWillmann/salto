package ooo.jtc.api.common.tests;

import java.lang.System;

/**
 * Base abstract test.
 * Test must implement
 *     test name generating;
 *     test body in execution() method;
 *
 * Test may get
 *     preExecution (empty by default) function;
 *     postExecution (empty by default) function;
 *     testPostExecution (empty by default) function;
 *     params as [Map] (empty by default)
 *
 *     TR  - class of test execution result
 *     PR  - class of test preExecution result
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002BQ\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u00a2\u0006\u0002\u0010\fJ\u0017\u0010=\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00018\u0000H&\u00a2\u0006\u0002\u0010(J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020?H\u0016J\n\u0010@\u001a\u0004\u0018\u00010\u000eH\u0002J\n\u0010A\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010B\u001a\u0004\u0018\u00010+H\u0002J\u0010\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020\u0005H\u0016J\u0016\u0010F\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010G\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0013\u001a\u00020\u0005J&\u0010G\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\"\b\b\u0002\u0010H*\u00020I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HH0KJ\u0018\u0010L\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010M\u001a\u00020\u0005H\u0016J(\u0010L\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\"\b\b\u0002\u0010H*\u00020I2\f\u0010N\u001a\b\u0012\u0004\u0012\u0002HH0KH\u0016J\'\u0010O\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050P\"\u00020\u0005\u00a2\u0006\u0002\u0010QJ\u0016\u0010R\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010*\u001a\u00020+J\'\u0010S\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0012\u00100\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050P\"\u00020\u0005\u00a2\u0006\u0002\u0010QJ&\u0010S\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0000\"\b\b\u0002\u0010H*\u00020I2\f\u0010T\u001a\b\u0012\u0004\u0012\u0002HH0KR\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\"\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001e\u0010$\u001a\u0004\u0018\u00018\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u001e\u0010*\u001a\u0004\u0018\u00010+8FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00100\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001018FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u001e\u00107\u001a\u0004\u0018\u00018\u0001X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010)\u001a\u0004\b8\u0010&\"\u0004\b9\u0010(R\u001c\u0010:\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0015\"\u0004\b<\u0010\u0017\u00a8\u0006U"}, d2 = {"Looo/jtc/api/common/tests/AbstractTest;", "PR", "", "TR", "name", "", "preExecution", "Lkotlin/Function0;", "postExecution", "Lkotlin/Function1;", "", "testPostExecution", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "component", "Looo/jtc/core/tm4j/Tm4jComponent;", "getComponent", "()Looo/jtc/core/tm4j/Tm4jComponent;", "setComponent", "(Looo/jtc/core/tm4j/Tm4jComponent;)V", "folder", "getFolder", "()Ljava/lang/String;", "setFolder", "(Ljava/lang/String;)V", "issues", "", "getIssues", "()Ljava/util/List;", "setIssues", "(Ljava/util/List;)V", "getName", "setName", "getPostExecution", "()Lkotlin/jvm/functions/Function1;", "getPreExecution", "()Lkotlin/jvm/functions/Function0;", "preconditionResult", "getPreconditionResult", "()Ljava/lang/Object;", "setPreconditionResult", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "priority", "Looo/jtc/core/tm4j/Tm4jPriority;", "getPriority", "()Looo/jtc/core/tm4j/Tm4jPriority;", "setPriority", "(Looo/jtc/core/tm4j/Tm4jPriority;)V", "taskIds", "", "getTaskIds", "()Ljava/util/Set;", "setTaskIds", "(Ljava/util/Set;)V", "getTestPostExecution", "testResult", "getTestResult", "setTestResult", "tmsId", "getTmsId", "setTmsId", "execution", "params", "", "retrieveComponent", "retrieveFolder", "retrievePriority", "retrieveTaskIds", "", "toString", "withComponent", "withFolder", "T", "", "folderClass", "Lkotlin/reflect/KClass;", "withId", "id", "kClass", "withIssues", "", "([Ljava/lang/String;)Looo/jtc/api/common/tests/AbstractTest;", "withPriority", "withTaskIds", "taskIdsClass", "box-tests"})
public abstract class AbstractTest<PR extends java.lang.Object, TR extends java.lang.Object> {
    
    /**
     * Result object of [preExecution] function.
     * !Necessary for [postExecution].
     */
    @org.jetbrains.annotations.Nullable()
    private PR preconditionResult;
    
    /**
     * Result object of test (i.e. [execution] function).
     * !Necessary for [testPostExecution].
     */
    @org.jetbrains.annotations.Nullable()
    private TR testResult;
    
    /**
     * Test case ID from TMS (Tm4j).
     * Binds test case and autotest.
     */
    @org.jetbrains.annotations.Nullable()
    private java.lang.String tmsId;
    
    /**
     * List of development task ids.
     * For creating test coverage and traceability.
     *
     * Initialized by annotation [TaskIds] over the test class
     * or by [withTaskIds] function inside TestFactory method.
     */
    @org.jetbrains.annotations.Nullable()
    private java.util.Set<java.lang.String> taskIds;
    
    /**
     * List of bug ids.
     */
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> issues;
    
    /**
     * [Tm4jComponent]
     */
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.core.tm4j.Tm4jComponent component;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.core.tm4j.Tm4jPriority priority;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String folder;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function0<PR> preExecution = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<PR, kotlin.Unit> postExecution = null;
    @org.jetbrains.annotations.Nullable()
    private final kotlin.jvm.functions.Function1<TR, kotlin.Unit> testPostExecution = null;
    
    @org.jetbrains.annotations.Nullable()
    public final PR getPreconditionResult() {
        return null;
    }
    
    public final void setPreconditionResult(@org.jetbrains.annotations.Nullable()
    PR p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final TR getTestResult() {
        return null;
    }
    
    public final void setTestResult(@org.jetbrains.annotations.Nullable()
    TR p0) {
    }
    
    public abstract void execution(@org.jetbrains.annotations.Nullable()
    PR preconditionResult);
    
    @org.jetbrains.annotations.NotNull()
    public java.util.Map<java.lang.String, java.lang.Object> params() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String name() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getTmsId() {
        return null;
    }
    
    public final void setTmsId(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Set<java.lang.String> getTaskIds() {
        return null;
    }
    
    public final void setTaskIds(@org.jetbrains.annotations.Nullable()
    java.util.Set<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getIssues() {
        return null;
    }
    
    public final void setIssues(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.core.tm4j.Tm4jComponent getComponent() {
        return null;
    }
    
    public final void setComponent(@org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.Tm4jComponent p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.core.tm4j.Tm4jPriority getPriority() {
        return null;
    }
    
    public final void setPriority(@org.jetbrains.annotations.Nullable()
    ooo.jtc.core.tm4j.Tm4jPriority p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFolder() {
        return null;
    }
    
    public final void setFolder(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    /**
     * Adding tms id in test.
     */
    @org.jetbrains.annotations.NotNull()
    public ooo.jtc.api.common.tests.AbstractTest<?, ?> withId(@org.jetbrains.annotations.NotNull()
    java.lang.String id) {
        return null;
    }
    
    /**
     * Adding tms id from annotation in test.
     */
    @org.jetbrains.annotations.NotNull()
    public <T extends java.lang.annotation.Annotation>ooo.jtc.api.common.tests.AbstractTest<?, ?> withId(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<T> kClass) {
        return null;
    }
    
    /**
     * Adding issues ids in test.
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.tests.AbstractTest<?, ?> withIssues(@org.jetbrains.annotations.NotNull()
    java.lang.String... issues) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.tests.AbstractTest<?, ?> withTaskIds(@org.jetbrains.annotations.NotNull()
    java.lang.String... taskIds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.annotation.Annotation>ooo.jtc.api.common.tests.AbstractTest<?, ?> withTaskIds(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<T> taskIdsClass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.tests.AbstractTest<?, ?> withComponent(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jComponent component) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.tests.AbstractTest<?, ?> withPriority(@org.jetbrains.annotations.NotNull()
    ooo.jtc.core.tm4j.Tm4jPriority priority) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.api.common.tests.AbstractTest<?, ?> withFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String folder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final <T extends java.lang.annotation.Annotation>ooo.jtc.api.common.tests.AbstractTest<?, ?> withFolder(@org.jetbrains.annotations.NotNull()
    kotlin.reflect.KClass<T> folderClass) {
        return null;
    }
    
    private final java.util.List<java.lang.String> retrieveTaskIds() {
        return null;
    }
    
    private final ooo.jtc.core.tm4j.Tm4jComponent retrieveComponent() {
        return null;
    }
    
    private final ooo.jtc.core.tm4j.Tm4jPriority retrievePriority() {
        return null;
    }
    
    private final java.lang.String retrieveFolder() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getName() {
        return null;
    }
    
    public void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public kotlin.jvm.functions.Function0<PR> getPreExecution() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public kotlin.jvm.functions.Function1<PR, kotlin.Unit> getPostExecution() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public kotlin.jvm.functions.Function1<TR, kotlin.Unit> getTestPostExecution() {
        return null;
    }
    
    public AbstractTest(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function0<? extends PR> preExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super PR, kotlin.Unit> postExecution, @org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super TR, kotlin.Unit> testPostExecution) {
        super();
    }
    
    public AbstractTest() {
        super();
    }
}