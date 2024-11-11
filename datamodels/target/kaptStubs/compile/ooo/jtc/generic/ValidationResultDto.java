package ooo.jtc.generic;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0012\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Looo/jtc/generic/ValidationResultDto;", "", "groupResults", "", "Looo/jtc/generic/GroupResult;", "result", "Looo/jtc/documents/ControlCheckResult;", "checks", "Looo/jtc/generic/CheckResult;", "(Ljava/util/List;Looo/jtc/documents/ControlCheckResult;Ljava/util/List;)V", "getChecks", "()Ljava/util/List;", "getGroupResults", "getResult", "()Looo/jtc/documents/ControlCheckResult;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
public final class ValidationResultDto {
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<ooo.jtc.generic.GroupResult> groupResults = null;
    @org.jetbrains.annotations.Nullable()
    private final ooo.jtc.documents.ControlCheckResult result = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<ooo.jtc.generic.CheckResult> checks = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.generic.GroupResult> getGroupResults() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.documents.ControlCheckResult getResult() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.generic.CheckResult> getChecks() {
        return null;
    }
    
    public ValidationResultDto(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.generic.GroupResult> groupResults, @org.jetbrains.annotations.Nullable()
    ooo.jtc.documents.ControlCheckResult result, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.generic.CheckResult> checks) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.generic.GroupResult> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.documents.ControlCheckResult component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.generic.CheckResult> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.generic.ValidationResultDto copy(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.generic.GroupResult> groupResults, @org.jetbrains.annotations.Nullable()
    ooo.jtc.documents.ControlCheckResult result, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.generic.CheckResult> checks) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}