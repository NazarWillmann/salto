package ooo.jtc.rolemodel.trees;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto;

public final class GroupTreeDtoBuilder {
  private UUID id;

  private String name;

  private String description;

  private boolean included;

  private boolean includedDirect;

  private List<PrivilegeGroupDto> groups;

  public GroupTreeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public GroupTreeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public GroupTreeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public GroupTreeDtoBuilder setIncluded(boolean included) {
    this.included = included;
    return this;
  }

  public GroupTreeDtoBuilder setIncludedDirect(boolean includedDirect) {
    this.includedDirect = includedDirect;
    return this;
  }

  public GroupTreeDtoBuilder setGroups(List<PrivilegeGroupDto> groups) {
    this.groups = groups;
    return this;
  }

  public GroupTreeDto create() {
    return new GroupTreeDto(id, name, description, included, includedDirect, groups);
  }

  public static GroupTreeDtoBuilder builder() {
    return new GroupTreeDtoBuilder();
  }
}
