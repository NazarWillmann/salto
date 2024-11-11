package ooo.jtc.rolemodel.privilegegroup;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.rolemodel.privilege.Privilege;

public final class PrivilegeGroupBuilder {
  private UUID id;

  private int version;

  private String name;

  private String description;

  private List<PrivilegeGroup> groups;

  private List<Privilege> privileges;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public PrivilegeGroupBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PrivilegeGroupBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PrivilegeGroupBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public PrivilegeGroupBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PrivilegeGroupBuilder setGroups(List<PrivilegeGroup> groups) {
    this.groups = groups;
    return this;
  }

  public PrivilegeGroupBuilder setPrivileges(List<Privilege> privileges) {
    this.privileges = privileges;
    return this;
  }

  public PrivilegeGroupBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PrivilegeGroupBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public PrivilegeGroup create() {
    return new PrivilegeGroup(id, version, name, description, groups, privileges, createdAt, deletedAt);
  }

  public static PrivilegeGroupBuilder builder() {
    return new PrivilegeGroupBuilder();
  }
}
