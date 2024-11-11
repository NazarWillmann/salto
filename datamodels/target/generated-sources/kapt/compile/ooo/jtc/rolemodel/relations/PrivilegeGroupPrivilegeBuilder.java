package ooo.jtc.rolemodel.relations;

import java.util.UUID;

public final class PrivilegeGroupPrivilegeBuilder {
  private UUID idGroup;

  private UUID idPrivilege;

  public PrivilegeGroupPrivilegeBuilder setIdGroup(UUID idGroup) {
    this.idGroup = idGroup;
    return this;
  }

  public PrivilegeGroupPrivilegeBuilder setIdPrivilege(UUID idPrivilege) {
    this.idPrivilege = idPrivilege;
    return this;
  }

  public PrivilegeGroupPrivilege create() {
    return new PrivilegeGroupPrivilege(idGroup, idPrivilege);
  }

  public static PrivilegeGroupPrivilegeBuilder builder() {
    return new PrivilegeGroupPrivilegeBuilder();
  }
}
