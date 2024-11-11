package ooo.jtc.api.common.controls;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010(\u001a\u00020\u0003H\u0002J\b\u0010)\u001a\u00020*H\u0016J(\u0010+\u001a\u00020,2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0002J&\u0010-\u001a\u00020.2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,00H\u0016J&\u00101\u001a\u0002022\u0006\u0010\u001e\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\f\u00103\u001a\b\u0012\u0004\u0012\u00020.00H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0000X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0005R\u0012\u0010\u0015\u001a\u00020\u0016X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R(\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u0005\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012R\u0012\u0010 \u001a\u00020!X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0012\u0010&\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\'\u0010\u0012\u00a8\u00064"}, d2 = {"Looo/jtc/api/common/controls/INestedControls;", "Looo/jtc/api/common/controls/IControls;", "checkEntityName", "", "getCheckEntityName", "()Ljava/lang/String;", "checkFieldName", "getCheckFieldName", "checkMessage", "Looo/jtc/api/common/controls/MessageType;", "getCheckMessage", "()Looo/jtc/api/common/controls/MessageType;", "checkSubResults", "getCheckSubResults", "()Looo/jtc/api/common/controls/INestedControls;", "controlCheckResult", "Looo/jtc/documents/ControlCheckResult;", "getControlCheckResult", "()Looo/jtc/documents/ControlCheckResult;", "controlEntityName", "getControlEntityName", "controlType", "Looo/jtc/api/common/controls/ControlType;", "getControlType", "()Looo/jtc/api/common/controls/ControlType;", "value", "fieldName", "getFieldName", "setFieldName", "(Ljava/lang/String;)V", "groupCheckResult", "getGroupCheckResult", "groupType", "Looo/jtc/api/common/controls/GroupType;", "getGroupType", "()Looo/jtc/api/common/controls/GroupType;", "messageType", "getMessageType", "resultStatus", "getResultStatus", "getEntityFieldName", "getInfoForChecks", "Looo/jtc/generic/ValidationResultDto;", "prepareNecessaryCheckResult", "Looo/jtc/generic/CheckResult;", "prepareNecessaryControlResult", "Looo/jtc/generic/ControlResult;", "controlNestedResults", "", "prepareNecessaryGroupResult", "Looo/jtc/generic/GroupResult;", "groupNestedResults", "box-tests"})
public abstract interface INestedControls extends ooo.jtc.api.common.controls.IControls {
    
    /**
     * Expected [ValidationResultDto] 'result'
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract ooo.jtc.documents.ControlCheckResult getResultStatus();
    
    /**
     * Expected [GroupResult] 'result'
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.documents.ControlCheckResult getGroupCheckResult();
    
    /**
     * Expected [GroupResult] type
     * It's used to locate [GroupResult] for test by 'id'
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.api.common.controls.GroupType getGroupType();
    
    /**
     * Expected [ControlCheckResult] 'result'
     * It's partially used for overall validation
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.documents.ControlCheckResult getControlCheckResult();
    
    /**
     * Expected [ControlCheckResult] type
     * It's used to locate [ControlCheckResult] for test by 'id'.
     * Also it may be used for regulating expected [controlCheckResult] and, (!)MAYBE(!), [groupCheckResult] and [resultStatus] (validation result)
     */
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.api.common.controls.ControlType getControlType();
    
    /**
     * Supplementary field.
     * It's used in computing expected [additionalParams]'s "fieldName"
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getCheckEntityName();
    
    /**
     * Expected [CheckResult] 'fieldName'
     * It's used for validation
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getCheckFieldName();
    
    /**
     * Expected [CheckResult] 'message' string
     * It's used to locate [CheckResult] for test
     */
    @org.jetbrains.annotations.Nullable()
    public abstract ooo.jtc.api.common.controls.MessageType getCheckMessage();
    
    /**
     * Expected [CheckResult] 'subResults' list; [null] by default
     * It's used in cases of nested entities check
     */
    @org.jetbrains.annotations.Nullable()
    public abstract ooo.jtc.api.common.controls.INestedControls getCheckSubResults();
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public abstract java.lang.String getFieldName();
    
    public abstract void setFieldName(@org.jetbrains.annotations.Nullable()
    java.lang.String value);
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract java.lang.String getControlEntityName();
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract ooo.jtc.api.common.controls.MessageType getMessageType();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.ValidationResultDto getInfoForChecks();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.GroupResult prepareNecessaryGroupResult(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.ControlCheckResult groupCheckResult, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.controls.GroupType groupType, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.ControlResult> groupNestedResults);
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.ControlResult prepareNecessaryControlResult(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.ControlCheckResult controlCheckResult, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.controls.ControlType controlType, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.CheckResult> controlNestedResults);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public static java.lang.String getFieldName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
        
        public static void setFieldName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this, @org.jetbrains.annotations.Nullable()
        java.lang.String value) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static java.lang.String getControlEntityName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.api.common.controls.MessageType getMessageType(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.generic.ValidationResultDto getInfoForChecks(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.generic.GroupResult prepareNecessaryGroupResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.ControlCheckResult groupCheckResult, @org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.GroupType groupType, @org.jetbrains.annotations.NotNull()
        java.util.List<ooo.jtc.generic.ControlResult> groupNestedResults) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.generic.ControlResult prepareNecessaryControlResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.ControlCheckResult controlCheckResult, @org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.ControlType controlType, @org.jetbrains.annotations.NotNull()
        java.util.List<ooo.jtc.generic.CheckResult> controlNestedResults) {
            return null;
        }
        
        private static ooo.jtc.generic.CheckResult prepareNecessaryCheckResult(ooo.jtc.api.common.controls.INestedControls $this, java.lang.String checkFieldName, ooo.jtc.api.common.controls.MessageType checkMessage, ooo.jtc.api.common.controls.INestedControls checkSubResults) {
            return null;
        }
        
        private static java.lang.String getEntityFieldName(ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static java.lang.String getFieldEntity(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.api.common.controls.IControls withParams(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> additionalParams) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @java.lang.Override()
        public static <T extends ooo.jtc.api.common.controls.IControls>T withParams(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this, @org.jetbrains.annotations.NotNull()
        kotlin.Pair<java.lang.String, java.lang.String>... additionalParams) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.generic.CheckResult getCheckResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedControls $this) {
            return null;
        }
    }
}