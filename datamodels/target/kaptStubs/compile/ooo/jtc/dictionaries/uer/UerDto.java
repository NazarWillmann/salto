package ooo.jtc.dictionaries.uer;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\u000bJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\tH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J=\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u00d6\u0003J\t\u0010(\u001a\u00020\u0005H\u00d6\u0001J\b\u0010)\u001a\u00020*H\u0016J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006,"}, d2 = {"Looo/jtc/dictionaries/uer/UerDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "uer", "", "bankType", "Looo/jtc/dictionaries/bankru/BankType;", "description", "(Ljava/util/UUID;ILjava/lang/String;Looo/jtc/dictionaries/bankru/BankType;Ljava/lang/String;)V", "getBankType", "()Looo/jtc/dictionaries/bankru/BankType;", "setBankType", "(Looo/jtc/dictionaries/bankru/BankType;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getUer", "setUer", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toModel", "Looo/jtc/dictionaries/uer/Uer;", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@com.github.pozo.KotlinBuilder()
@ooo.jtc.annotations.EntityName(name = "\u0423\u0447\u0430\u0441\u0442\u0438\u0435 \u0432 \u044d\u043b\u0435\u043a\u0442\u0440\u043e\u043d\u043d\u044b\u0445 \u0440\u0430\u0441\u0447\u0435\u0442\u0430\u0445")
public final class UerDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.dictionaries.uer.UerDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uer;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.dictionaries.bankru.BankType bankType;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String description;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.dictionaries.uer.Uer toModel() {
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
    public final java.lang.String getUer() {
        return null;
    }
    
    public final void setUer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankru.BankType getBankType() {
        return null;
    }
    
    public final void setBankType(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankru.BankType p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public UerDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String uer, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankru.BankType bankType, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
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
    public final ooo.jtc.dictionaries.bankru.BankType component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.uer.UerDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String uer, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankru.BankType bankType, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
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