package ooo.jtc.documents;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010#\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\tH\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012JH\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u000b2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001J\t\u0010-\u001a\u00020\tH\u00d6\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006."}, d2 = {"Looo/jtc/documents/DocHistoryResponseDto;", "", "version", "", "eventTime", "Ljava/time/ZonedDateTime;", "userId", "Ljava/util/UUID;", "targetStatus", "", "statusChanged", "", "(Ljava/lang/Integer;Ljava/time/ZonedDateTime;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/Boolean;)V", "getEventTime", "()Ljava/time/ZonedDateTime;", "setEventTime", "(Ljava/time/ZonedDateTime;)V", "getStatusChanged", "()Ljava/lang/Boolean;", "setStatusChanged", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getTargetStatus", "()Ljava/lang/String;", "setTargetStatus", "(Ljava/lang/String;)V", "getUserId", "()Ljava/util/UUID;", "setUserId", "(Ljava/util/UUID;)V", "getVersion", "()Ljava/lang/Integer;", "setVersion", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/time/ZonedDateTime;Ljava/util/UUID;Ljava/lang/String;Ljava/lang/Boolean;)Looo/jtc/documents/DocHistoryResponseDto;", "equals", "other", "hashCode", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.github.pozo.KotlinBuilder()
public final class DocHistoryResponseDto {
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer version;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime eventTime;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID userId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String targetStatus;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Boolean statusChanged;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getVersion() {
        return null;
    }
    
    public final void setVersion(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getEventTime() {
        return null;
    }
    
    public final void setEventTime(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getUserId() {
        return null;
    }
    
    public final void setUserId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTargetStatus() {
        return null;
    }
    
    public final void setTargetStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getStatusChanged() {
        return null;
    }
    
    public final void setStatusChanged(@org.jetbrains.annotations.Nullable()
    java.lang.Boolean p0) {
    }
    
    public DocHistoryResponseDto(@org.jetbrains.annotations.Nullable()
    java.lang.Integer version, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime eventTime, @org.jetbrains.annotations.Nullable()
    java.util.UUID userId, @org.jetbrains.annotations.NotNull()
    java.lang.String targetStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean statusChanged) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.documents.DocHistoryResponseDto copy(@org.jetbrains.annotations.Nullable()
    java.lang.Integer version, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime eventTime, @org.jetbrains.annotations.Nullable()
    java.util.UUID userId, @org.jetbrains.annotations.NotNull()
    java.lang.String targetStatus, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean statusChanged) {
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