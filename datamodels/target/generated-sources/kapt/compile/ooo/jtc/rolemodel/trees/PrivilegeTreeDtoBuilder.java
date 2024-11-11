package ooo.jtc.rolemodel.trees;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.rolemodel.privilegegroup.PrivilegeGroupDto;

public final class PrivilegeTreeDtoBuilder {
  private UUID id;

  private String name;

  private String uiName;

  private String description;

  private boolean included;

  private boolean includedDirect;

  private PrivilegeGroupDto includedViaGroup;

  public PrivilegeTreeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PrivilegeTreeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public PrivilegeTreeDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public PrivilegeTreeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PrivilegeTreeDtoBuilder setIncluded(boolean included) {
    this.included = included;
    return this;
  }

  public PrivilegeTreeDtoBuilder setIncludedDirect(boolean includedDirect) {
    this.includedDirect = includedDirect;
    return this;
  }

  public PrivilegeTreeDtoBuilder setIncludedViaGroup(PrivilegeGroupDto includedViaGroup) {
    this.includedViaGroup = includedViaGroup;
    return this;
  }

  public PrivilegeTreeDto create() {
    return new PrivilegeTreeDto(id, name, uiName, description, included, includedDirect, includedViaGroup);
  }

  public static PrivilegeTreeDtoBuilder builder() {
    return new PrivilegeTreeDtoBuilder();
  }
}
