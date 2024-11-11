package ooo.jtc.rolemodel.trees;

import java.util.List;
import ooo.jtc.rolemodel.role.RoleDto;
import ooo.jtc.uaa.resource.dto.ResourceDto;

public final class ResourceRoleTreeDtoBuilder {
  private ResourceDto resource;

  private List<RoleDto> roles;

  public ResourceRoleTreeDtoBuilder setResource(ResourceDto resource) {
    this.resource = resource;
    return this;
  }

  public ResourceRoleTreeDtoBuilder setRoles(List<RoleDto> roles) {
    this.roles = roles;
    return this;
  }

  public ResourceRoleTreeDto create() {
    return new ResourceRoleTreeDto(resource, roles);
  }

  public static ResourceRoleTreeDtoBuilder builder() {
    return new ResourceRoleTreeDtoBuilder();
  }
}
