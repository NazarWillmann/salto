package ooo.jtc.dictionaries.customertype;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J3\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00d6\u0001J\b\u0010\u001f\u001a\u00020 H\u0016J\t\u0010!\u001a\u00020\u0007H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\""}, d2 = {"Looo/jtc/dictionaries/customertype/CustomerTypeDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "name", "", "systemName", "(Ljava/util/UUID;ILjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getName", "()Ljava/lang/String;", "getSystemName", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toModel", "Looo/jtc/dictionaries/customertype/CustomerType;", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u0422\u0438\u043f \u043a\u043b\u0438\u0435\u043d\u0442\u0430 \u042e\u041b")
@com.github.pozo.KotlinBuilder()
public final class CustomerTypeDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.dictionaries.customertype.CustomerTypeDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String systemName = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.dictionaries.customertype.CustomerType toModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.util.UUID getId() {
        return null;
    }
    
    @java.lang.Override()
    public void setId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @java.lang.Override()
    public int getVersion() {
        return 0;
    }
    
    @java.lang.Override()
    public void setVersion(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSystemName() {
        return null;
    }
    
    public CustomerTypeDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String systemName) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.customertype.CustomerTypeDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String systemName) {
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