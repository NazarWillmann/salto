package ooo.jtc.rolemodel.relations;

import java.util.UUID;

public final class PrivilegeGroupPrivilegeGroupBuilder {
  private UUID idParent;

  private UUID idChild;

  public PrivilegeGroupPrivilegeGroupBuilder setIdParent(UUID idParent) {
    this.idParent = idParent;
    return this;
  }

  public PrivilegeGroupPrivilegeGroupBuilder setIdChild(UUID idChild) {
    this.idChild = idChild;
    return this;
  }

  public PrivilegeGroupPrivilegeGroup create() {
    return new PrivilegeGroupPrivilegeGroup(idParent, idChild);
  }

  public static PrivilegeGroupPrivilegeGroupBuilder builder() {
    return new PrivilegeGroupPrivilegeGroupBuilder();
  }
}
