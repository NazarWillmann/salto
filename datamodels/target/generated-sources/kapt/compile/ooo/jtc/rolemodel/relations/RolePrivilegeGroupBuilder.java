package ooo.jtc.rolemodel.relations;

import java.lang.String;
import java.util.UUID;

public final class RolePrivilegeGroupBuilder {
  private UUID idGroup;

  private String roleName;

  public RolePrivilegeGroupBuilder setIdGroup(UUID idGroup) {
    this.idGroup = idGroup;
    return this;
  }

  public RolePrivilegeGroupBuilder setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }

  public RolePrivilegeGroup create() {
    return new RolePrivilegeGroup(idGroup, roleName);
  }

  public static RolePrivilegeGroupBuilder builder() {
    return new RolePrivilegeGroupBuilder();
  }
}
