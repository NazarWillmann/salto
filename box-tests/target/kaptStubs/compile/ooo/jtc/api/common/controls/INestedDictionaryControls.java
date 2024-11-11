package ooo.jtc.api.common.controls;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J&\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016\u00a8\u0006\u0011"}, d2 = {"Looo/jtc/api/common/controls/INestedDictionaryControls;", "Looo/jtc/api/common/controls/INestedControls;", "prepareNecessaryControlResult", "Looo/jtc/generic/ControlResult;", "controlCheckResult", "Looo/jtc/documents/ControlCheckResult;", "controlType", "Looo/jtc/api/common/controls/ControlType;", "controlNestedResults", "", "Looo/jtc/generic/CheckResult;", "prepareNecessaryGroupResult", "Looo/jtc/generic/GroupResult;", "groupCheckResult", "groupType", "Looo/jtc/api/common/controls/GroupType;", "groupNestedResults", "box-tests"})
public abstract interface INestedDictionaryControls extends ooo.jtc.api.common.controls.INestedControls {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract ooo.jtc.generic.GroupResult prepareNecessaryGroupResult(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.ControlCheckResult groupCheckResult, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.controls.GroupType groupType, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.ControlResult> groupNestedResults);
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public abstract ooo.jtc.generic.ControlResult prepareNecessaryControlResult(@org.jetbrains.annotations.NotNull()
    ooo.jtc.documents.ControlCheckResult controlCheckResult, @org.jetbrains.annotations.NotNull()
    ooo.jtc.api.common.controls.ControlType controlType, @org.jetbrains.annotations.NotNull()
    java.util.List<ooo.jtc.generic.CheckResult> controlNestedResults);
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.generic.GroupResult prepareNecessaryGroupResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.ControlCheckResult groupCheckResult, @org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.GroupType groupType, @org.jetbrains.annotations.NotNull()
        java.util.List<ooo.jtc.generic.ControlResult> groupNestedResults) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.generic.ControlResult prepareNecessaryControlResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this, @org.jetbrains.annotations.NotNull()
        ooo.jtc.documents.ControlCheckResult controlCheckResult, @org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.ControlType controlType, @org.jetbrains.annotations.NotNull()
        java.util.List<ooo.jtc.generic.CheckResult> controlNestedResults) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public static java.lang.String getFieldName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this) {
            return null;
        }
        
        @java.lang.Override()
        public static void setFieldName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this, @org.jetbrains.annotations.Nullable()
        java.lang.String value) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static java.lang.String getControlEntityName(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.api.common.controls.MessageType getMessageType(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.generic.ValidationResultDto getInfoForChecks(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static java.lang.String getFieldEntity(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.api.common.controls.IControls withParams(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> additionalParams) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @java.lang.Override()
        public static <T extends ooo.jtc.api.common.controls.IControls>T withParams(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this, @org.jetbrains.annotations.NotNull()
        kotlin.Pair<java.lang.String, java.lang.String>... additionalParams) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public static ooo.jtc.generic.CheckResult getCheckResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.INestedDictionaryControls $this) {
            return null;
        }
    }
}