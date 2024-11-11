package ooo.jtc.rolemodel.role;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto;
import ooo.jtc.uaa.resource.dto.ResourceDto;

public final class RoleDtoBuilder {
  private UUID id;

  private int version;

  private UUID resourceId;

  private String name;

  private String uiName;

  private String description;

  private ResourceDto resource;

  private List<PrivilegeGroupDto> privilegeGroups;

  public RoleDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RoleDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public RoleDtoBuilder setResourceId(UUID resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public RoleDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public RoleDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public RoleDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public RoleDtoBuilder setResource(ResourceDto resource) {
    this.resource = resource;
    return this;
  }

  public RoleDtoBuilder setPrivilegeGroups(List<PrivilegeGroupDto> privilegeGroups) {
    this.privilegeGroups = privilegeGroups;
    return this;
  }

  public RoleDto create() {
    return new RoleDto(id, version, resourceId, name, uiName, description, resource, privilegeGroups);
  }

  public static RoleDtoBuilder builder() {
    return new RoleDtoBuilder();
  }
}
