package ooo.jtc.dictionaries.ground;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tH\u00c6\u0003JA\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u00c6\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u00d6\u0003J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001J\b\u0010&\u001a\u00020\'H\u0016J\t\u0010(\u001a\u00020\tH\u00d6\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006)"}, d2 = {"Looo/jtc/dictionaries/ground/GroundDto;", "Looo/jtc/interfaces/IEntityDto;", "id", "Ljava/util/UUID;", "version", "", "customerId", "contractorId", "description", "", "(Ljava/util/UUID;ILjava/util/UUID;Ljava/util/UUID;Ljava/lang/String;)V", "getContractorId", "()Ljava/util/UUID;", "setContractorId", "(Ljava/util/UUID;)V", "getCustomerId", "setCustomerId", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "setId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toModel", "Looo/jtc/dictionaries/ground/Ground;", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u041d\u0430\u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 \u043f\u043b\u0430\u0442\u0435\u0436\u0430")
@com.github.pozo.KotlinBuilder()
public final class GroundDto implements ooo.jtc.interfaces.IEntityDto {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.util.UUID customerId;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID contractorId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.dictionaries.ground.Ground toModel() {
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
    public final java.util.UUID getCustomerId() {
        return null;
    }
    
    public final void setCustomerId(@org.jetbrains.annotations.NotNull()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getContractorId() {
        return null;
    }
    
    public final void setContractorId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public GroundDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID contractorId, @org.jetbrains.annotations.Nullable()
    java.lang.String description) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
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
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.dictionaries.ground.GroundDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.util.UUID customerId, @org.jetbrains.annotations.Nullable()
    java.util.UUID contractorId, @org.jetbrains.annotations.Nullable()
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