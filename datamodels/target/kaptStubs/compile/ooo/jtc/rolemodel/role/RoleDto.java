package ooo.jtc.rolemodel.role;

import java.lang.System;

/**
 * Wrapper for UAA's [ooo.jtc.uaa.scope.dto.ScopeDto]
 * with additional 'privilegeGroups' list (of [ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto])
 * and with [ooo.jtc.uaa.resource.dto.ResourceDto] without 'scope's (i.e. 'role's)
 */
@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\bH\u00c6\u0003J\t\u0010/\u001a\u00020\bH\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0003Ji\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u00c6\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u000107H\u00d6\u0003J\t\u00108\u001a\u00020\u0005H\u00d6\u0001J\b\u00109\u001a\u00020:H\u0016J\t\u0010;\u001a\u00020\bH\u00d6\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*\u00a8\u0006<"}, d2 = {"Looo/jtc/rolemodel/role/RoleDto;", "Looo/jtc/interfaces/UpdateIEntityDto;", "id", "Ljava/util/UUID;", "version", "", "resourceId", "name", "", "uiName", "description", "resource", "Looo/jtc/uaa/resource/dto/ResourceDto;", "privilegeGroups", "", "Looo/jtc/rolemodel/privilegegroup/PrivilegeGroupDto;", "(Ljava/util/UUID;ILjava/util/UUID;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Looo/jtc/uaa/resource/dto/ResourceDto;Ljava/util/List;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "()Ljava/util/UUID;", "setId", "(Ljava/util/UUID;)V", "getName", "setName", "getPrivilegeGroups", "()Ljava/util/List;", "setPrivilegeGroups", "(Ljava/util/List;)V", "getResource", "()Looo/jtc/uaa/resource/dto/ResourceDto;", "setResource", "(Looo/jtc/uaa/resource/dto/ResourceDto;)V", "getResourceId", "setResourceId", "getUiName", "setUiName", "getVersion", "()I", "setVersion", "(I)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "toModel", "Looo/jtc/rolemodel/role/Role;", "toString", "datamodels"})
@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(value = com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@ooo.jtc.annotations.EntityName(name = "\u0420\u043e\u043b\u044c")
@com.github.pozo.KotlinBuilder()
public final class RoleDto implements ooo.jtc.interfaces.UpdateIEntityDto<ooo.jtc.rolemodel.role.RoleDto> {
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID id;
    private int version;
    @org.jetbrains.annotations.Nullable()
    private java.util.UUID resourceId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String uiName;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String description;
    @org.jetbrains.annotations.Nullable()
    private ooo.jtc.uaa.resource.dto.ResourceDto resource;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> privilegeGroups;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public ooo.jtc.rolemodel.role.Role toModel() {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID getResourceId() {
        return null;
    }
    
    public final void setResourceId(@org.jetbrains.annotations.Nullable()
    java.util.UUID p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.uaa.resource.dto.ResourceDto getResource() {
        return null;
    }
    
    public final void setResource(@org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.resource.dto.ResourceDto p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> getPrivilegeGroups() {
        return null;
    }
    
    public final void setPrivilegeGroups(@org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> p0) {
    }
    
    public RoleDto(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.Nullable()
    java.util.UUID resourceId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String uiName, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.resource.dto.ResourceDto resource, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> privilegeGroups) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.UUID component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final ooo.jtc.uaa.resource.dto.ResourceDto component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> component8() {
        return null;
    }
    
    /**
     * Wrapper for UAA's [ooo.jtc.uaa.scope.dto.ScopeDto]
     * with additional 'privilegeGroups' list (of [ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto])
     * and with [ooo.jtc.uaa.resource.dto.ResourceDto] without 'scope's (i.e. 'role's)
     */
    @org.jetbrains.annotations.NotNull()
    public final ooo.jtc.rolemodel.role.RoleDto copy(@org.jetbrains.annotations.Nullable()
    java.util.UUID id, int version, @org.jetbrains.annotations.Nullable()
    java.util.UUID resourceId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String uiName, @org.jetbrains.annotations.Nullable()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    ooo.jtc.uaa.resource.dto.ResourceDto resource, @org.jetbrains.annotations.Nullable()
    java.util.List<ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto> privilegeGroups) {
        return null;
    }
    
    /**
     * Wrapper for UAA's [ooo.jtc.uaa.scope.dto.ScopeDto]
     * with additional 'privilegeGroups' list (of [ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto])
     * and with [ooo.jtc.uaa.resource.dto.ResourceDto] without 'scope's (i.e. 'role's)
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * Wrapper for UAA's [ooo.jtc.uaa.scope.dto.ScopeDto]
     * with additional 'privilegeGroups' list (of [ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto])
     * and with [ooo.jtc.uaa.resource.dto.ResourceDto] without 'scope's (i.e. 'role's)
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * Wrapper for UAA's [ooo.jtc.uaa.scope.dto.ScopeDto]
     * with additional 'privilegeGroups' list (of [ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto])
     * and with [ooo.jtc.uaa.resource.dto.ResourceDto] without 'scope's (i.e. 'role's)
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}