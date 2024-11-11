package ooo.jtc.rolemodel.privilege;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.rolemodel.accessobject.AccessObjectDto;

public final class PrivilegeDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private UUID accessObjectId;

  private AccessObjectDto accessObject;

  public PrivilegeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PrivilegeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PrivilegeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public PrivilegeDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public PrivilegeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PrivilegeDtoBuilder setAccessObjectId(UUID accessObjectId) {
    this.accessObjectId = accessObjectId;
    return this;
  }

  public PrivilegeDtoBuilder setAccessObject(AccessObjectDto accessObject) {
    this.accessObject = accessObject;
    return this;
  }

  public PrivilegeDto create() {
    return new PrivilegeDto(id, version, name, uiName, description, accessObjectId, accessObject);
  }

  public static PrivilegeDtoBuilder builder() {
    return new PrivilegeDtoBuilder();
  }
}
