package ooo.jtc.rolemodel.trees;

import java.util.List;

public final class RoleTreeDtoBuilder {
  private List<ResourceRoleTreeDto> resources;

  public RoleTreeDtoBuilder setResources(List<ResourceRoleTreeDto> resources) {
    this.resources = resources;
    return this;
  }

  public RoleTreeDto create() {
    return new RoleTreeDto(resources);
  }

  public static RoleTreeDtoBuilder builder() {
    return new RoleTreeDtoBuilder();
  }
}
