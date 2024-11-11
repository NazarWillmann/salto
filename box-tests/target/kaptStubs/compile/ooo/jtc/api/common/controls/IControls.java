package ooo.jtc.api.common.controls;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000  2\u00020\u0001:\u0001 J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J>\u0010\u0019\u001a\u00020\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002JC\u0010\u001b\u001a\u0002H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00002*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001e0\u001d\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001eH\u0016\u00a2\u0006\u0002\u0010\u001fJ\u001c\u0010\u001b\u001a\u00020\u00002\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R&\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u000fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Looo/jtc/api/common/controls/IControls;", "", "additionalParams", "", "", "getAdditionalParams", "()Ljava/util/Map;", "setAdditionalParams", "(Ljava/util/Map;)V", "controlEntityName", "getControlEntityName", "()Ljava/lang/String;", "fieldName", "getFieldName", "messageType", "Looo/jtc/api/common/controls/MessageType;", "getMessageType", "()Looo/jtc/api/common/controls/MessageType;", "resultStatus", "Looo/jtc/documents/ControlCheckResult;", "getResultStatus", "()Looo/jtc/documents/ControlCheckResult;", "getCheckResult", "Looo/jtc/generic/CheckResult;", "getFieldEntity", "prepareCheckResult", "fieldEntity", "withParams", "T", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Looo/jtc/api/common/controls/IControls;", "Companion", "box-tests"})
public abstract interface IControls {
    public static final ooo.jtc.api.common.controls.IControls.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getFieldName();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.api.common.controls.MessageType getMessageType();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.documents.ControlCheckResult getResultStatus();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getControlEntityName();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.Map<java.lang.String, java.lang.String> getAdditionalParams();
    
    public abstract void setAdditionalParams(@org.jetbrains.annotations.Nullable()
    java.util.Map<java.lang.String, java.lang.String> p0);
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getFieldEntity();
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.api.common.controls.IControls withParams(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> additionalParams);
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    public abstract <T extends ooo.jtc.api.common.controls.IControls>T withParams(@org.jetbrains.annotations.NotNull()
    kotlin.Pair<java.lang.String, java.lang.String>... additionalParams);
    
    @org.jetbrains.annotations.NotNull()
    public abstract ooo.jtc.generic.CheckResult getCheckResult();
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 3)
    public final class DefaultImpls {
        
        @org.jetbrains.annotations.NotNull()
        public static java.lang.String getFieldEntity(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.IControls $this) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.api.common.controls.IControls withParams(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.IControls $this, @org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> additionalParams) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        public static <T extends ooo.jtc.api.common.controls.IControls>T withParams(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.IControls $this, @org.jetbrains.annotations.NotNull()
        kotlin.Pair<java.lang.String, java.lang.String>... additionalParams) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public static ooo.jtc.generic.CheckResult getCheckResult(@org.jetbrains.annotations.NotNull()
        ooo.jtc.api.common.controls.IControls $this) {
            return null;
        }
        
        /**
         * Utility function for prepare [CheckResult].
         */
        private static ooo.jtc.generic.CheckResult prepareCheckResult(ooo.jtc.api.common.controls.IControls $this, java.lang.String fieldName, ooo.jtc.api.common.controls.MessageType messageType, java.lang.String fieldEntity, ooo.jtc.documents.ControlCheckResult resultStatus, java.util.Map<java.lang.String, java.lang.String> additionalParams) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0007"}, d2 = {"Looo/jtc/api/common/controls/IControls$Companion;", "", "()V", "getForbiddenSymbolsMessage", "", "forbiddenSymbols", "exclusions", "box-tests"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getForbiddenSymbolsMessage(@org.jetbrains.annotations.NotNull()
        java.lang.String forbiddenSymbols, @org.jetbrains.annotations.Nullable()
        java.lang.String exclusions) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}