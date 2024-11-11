package ooo.jtc.dictionaries.common;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J+\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Looo/jtc/dictionaries/common/BlockingInfoDto;", "", "isBlock", "", "blockUser", "Ljava/util/UUID;", "blockDate", "Ljava/time/ZonedDateTime;", "(ZLjava/util/UUID;Ljava/time/ZonedDateTime;)V", "getBlockDate", "()Ljava/time/ZonedDateTime;", "setBlockDate", "(Ljava/time/ZonedDateTime;)V", "getBlockUser", "()Ljava/util/UUID;", "setBlockUser", "(Ljava/util/UUID;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "datamodels"})
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u0418\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u044f \u043e \u0431\u043b\u043e\u043a\u0438\u0440\u043e\u0432\u043a\u0435")
@com.github.pozo.KotlinBuilder()
public final class BlockingInfoDto {
    public boolean isBlock;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID blockUser;
    @org.jetbrains.annotations.Nullable()
    private java.time.ZonedDateTime blockDate;
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getBlockUser() {
        return null;
    }
    
    public final void setBlockUser(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime getBlockDate() {
        return null;
    }
    
    public final void setBlockDate(@org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime p0) {
    }
    
    public BlockingInfoDto(boolean isBlock, @org.jetbrains.annotations.Nullable()
    java.util.UUID blockUser, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime blockDate) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.ZonedDateTime component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.common.BlockingInfoDto copy(boolean isBlock, @org.jetbrains.annotations.Nullable()
    java.util.UUID blockUser, @org.jetbrains.annotations.Nullable()
    java.time.ZonedDateTime blockDate) {
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