package ooo.jtc.rolemodel.privilegegroup;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.rolemodel.privilege.PrivilegeDto;

public final class PrivilegeGroupDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String description;

  private List<PrivilegeGroupDto> groups;

  private List<PrivilegeDto> privileges;

  public PrivilegeGroupDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PrivilegeGroupDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PrivilegeGroupDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public PrivilegeGroupDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PrivilegeGroupDtoBuilder setGroups(List<PrivilegeGroupDto> groups) {
    this.groups = groups;
    return this;
  }

  public PrivilegeGroupDtoBuilder setPrivileges(List<PrivilegeDto> privileges) {
    this.privileges = privileges;
    return this;
  }

  public PrivilegeGroupDto create() {
    return new PrivilegeGroupDto(id, version, name, description, groups, privileges);
  }

  public static PrivilegeGroupDtoBuilder builder() {
    return new PrivilegeGroupDtoBuilder();
  }
}
