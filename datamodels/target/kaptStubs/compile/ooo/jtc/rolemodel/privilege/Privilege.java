package ooo.jtc.rolemodel.privilege;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\u0007H\u00c6\u0003J\t\u00101\u001a\u00020\u0007H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J\t\u00103\u001a\u00020\u0003H\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Jk\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001J\u0013\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u00d6\u0003J\t\u0010<\u001a\u00020\u0005H\u00d6\u0001J\b\u0010=\u001a\u00020>H\u0016J\t\u0010?\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R \u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u00078\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010%R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001e\"\u0004\b\'\u0010 R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006@"}, d2 = {"Looo/jtc/rolemodel/privilege/Privilege;", "Looo/jtc/interfaces/ITransferEntity;", "id", "Ljava/util/UUID;", "version", "", "name", "", "uiName", "description", "accessObjectId", "accessObject", "Looo/jtc/rolemodel/accessobject/AccessObject;", "createdAt", "Ljava/sql/Timestamp;", "deletedAt", "(Ljava/util/UUID;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/UUID;Looo/jtc/rolemodel/accessobject/AccessObject;Ljava/sql/Timestamp;Ljava/sql/Timestamp;)V", "getAccessObject", "()Looo/jtc/rolemodel/accessobject/AccessObject;", "setAccessObject", "(Looo/jtc/rolemodel/accessobject/AccessObject;)V", "getAccessObjectId", "()Ljava/util/UUID;", "getCreatedAt", "()Ljava/sql/Timestamp;", "setCreatedAt", "(Ljava/sql/Timestamp;)V", "getDeletedAt", "setDeletedAt", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "entityName", "getEntityName", "getId", "setId", "(Ljava/util/UUID;)V", "getName", "setName", "getUiName", "setUiName", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toDto", "Looo/jtc/rolemodel/privilege/PrivilegeDto;", "toString", "datamodels"})
@com.github.pozo.KotlinBuilder()
public final class Privilege implements ooo.jtc.interfaces.ITransferEntity {
    @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonIgnore()
    @ooo.jtc.annotations.NotRequiredForTest()
    private final java.lang.String entityName = "\u041f\u0440\u0438\u0432\u0438\u043b\u0435\u0433\u0438\u044f";
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uiName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description;
    @org.jetbrains.annotations.NotNull()
    private final java.util.UUID accessObjectId = null;
    @org.jetbrains.annotations.NotNull()
    private ooo.jtc.rolemodel.accessobject.AccessObject accessObject;
    @org.jetbrains.annotations.Nullable()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.sql.Timestamp createdAt;
    @org.jetbrains.annotations.Nullable()
    @ooo.jtc.annotations.NotRequiredForTest()
    private java.sql.Timestamp deletedAt;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getEntityName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.rolemodel.privilege.PrivilegeDto toDto() {
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
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUiName() {
        return null;
    }
    
    public final void setUiName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID getAccessObjectId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rolemodel.accessobject.AccessObject getAccessObject() {
        return null;
    }
    
    public final void setAccessObject(@org.jetbrains.annotations.NotNull()
    ooo.jtc.rolemodel.accessobject.AccessObject p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getCreatedAt() {
        return null;
    }
    
    public final void setCreatedAt(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp getDeletedAt() {
        return null;
    }
    
    public final void setDeletedAt(@org.jetbrains.annotations.Nullable()
    java.sql.Timestamp p0) {
    }
    
    public Privilege(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ui_name")
    java.lang.String uiName, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id_access_object")
    java.util.UUID accessObjectId, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rolemodel.accessobject.AccessObject accessObject, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "created_at")
    java.sql.Timestamp createdAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deleted_at")
    java.sql.Timestamp deletedAt) {
        super();
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.UUID component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rolemodel.accessobject.AccessObject component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.sql.Timestamp component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rolemodel.privilege.Privilege copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "ui_name")
    java.lang.String uiName, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "id_access_object")
    java.util.UUID accessObjectId, @org.jetbrains.annotations.NotNull()
    ooo.jtc.rolemodel.accessobject.AccessObject accessObject, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "created_at")
    java.sql.Timestamp createdAt, @org.jetbrains.annotations.Nullable()
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deleted_at")
    java.sql.Timestamp deletedAt) {
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