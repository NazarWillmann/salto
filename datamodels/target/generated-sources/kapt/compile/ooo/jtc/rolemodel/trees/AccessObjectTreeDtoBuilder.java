package ooo.jtc.rolemodel.trees;

import java.lang.String;
import java.util.List;
import java.util.UUID;

public final class AccessObjectTreeDtoBuilder {
  private UUID id;

  private String name;

  private String uiName;

  private String description;

  private boolean included;

  private List<PrivilegeTreeDto> privileges;

  public AccessObjectTreeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccessObjectTreeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccessObjectTreeDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public AccessObjectTreeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccessObjectTreeDtoBuilder setIncluded(boolean included) {
    this.included = included;
    return this;
  }

  public AccessObjectTreeDtoBuilder setPrivileges(List<PrivilegeTreeDto> privileges) {
    this.privileges = privileges;
    return this;
  }

  public AccessObjectTreeDto create() {
    return new AccessObjectTreeDto(id, name, uiName, description, included, privileges);
  }

  public static AccessObjectTreeDtoBuilder builder() {
    return new AccessObjectTreeDtoBuilder();
  }
}
