package ooo.jtc.rolemodel.role;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroup;

public final class RoleBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private UUID resourceId;

  private boolean needApprove;

  private List<PrivilegeGroup> privilegeGroups;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public RoleBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RoleBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public RoleBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public RoleBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public RoleBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleBuilder setResourceId(UUID resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public RoleBuilder setNeedApprove(boolean needApprove) {
    this.needApprove = needApprove;
    return this;
  }

  public RoleBuilder setPrivilegeGroups(List<PrivilegeGroup> privilegeGroups) {
    this.privilegeGroups = privilegeGroups;
    return this;
  }

  public RoleBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public RoleBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Role create() {
    return new Role(id, version, name, uiName, description, resourceId, needApprove, privilegeGroups, createdAt, deletedAt);
  }

  public static RoleBuilder builder() {
    return new RoleBuilder();
  }
}
