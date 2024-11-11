package ooo.jtc.dictionaries.bankbic.restr;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\tH\u00c6\u0003J3\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u00d6\u0003J\t\u0010$\u001a\u00020\u0005H\u00d6\u0001J\b\u0010%\u001a\u00020&H\u0016J\t\u0010\'\u001a\u00020(H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Looo/jtc/dictionaries/bankbic/restr/BankBicRestrictionDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "restrictionCode", "Looo/jtc/dictionaries/bankbic/innerenum/ValDescIEnumDto;", "restrictionDate", "Ljava/time/LocalDate;", "(Ljava/util/UUID;ILooo/jtc/dictionaries/bankbic/innerenum/ValDescIEnumDto;Ljava/time/LocalDate;)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getRestrictionCode", "()Looo/jtc/dictionaries/bankbic/innerenum/ValDescIEnumDto;", "setRestrictionCode", "(Looo/jtc/dictionaries/bankbic/innerenum/ValDescIEnumDto;)V", "getRestrictionDate", "()Ljava/time/LocalDate;", "setRestrictionDate", "(Ljava/time/LocalDate;)V", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toModel", "Looo/jtc/dictionaries/bankbic/restr/BankBicRestriction;", "toString", "", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u041e\u0433\u0440\u0430\u043d\u0438\u0447\u0435\u043d\u0438\u044f \u043d\u0430 \u0411\u0418\u041a \u0420\u0424")
@com.github.pozo.KotlinBuilder()
public final class BankBicRestrictionDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    @com.fasterxml.jackson.annotation.JsonIgnore()
    private int version;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto restrictionCode;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate restrictionDate;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction toModel() {
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
    public final ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto getRestrictionCode() {
        return null;
    }
    
    public final void setRestrictionCode(@org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getRestrictionDate() {
        return null;
    }
    
    public final void setRestrictionDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    public BankBicRestrictionDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto restrictionCode, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate restrictionDate) {
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
    public final ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto restrictionCode, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate restrictionDate) {
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