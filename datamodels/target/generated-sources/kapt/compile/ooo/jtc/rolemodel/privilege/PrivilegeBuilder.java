package ooo.jtc.rolemodel.privilege;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;
import ooo.jtc.rolemodel.accessobject.AccessObject;

public final class PrivilegeBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private UUID accessObjectId;

  private AccessObject accessObject;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public PrivilegeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PrivilegeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PrivilegeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public PrivilegeBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public PrivilegeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PrivilegeBuilder setAccessObjectId(UUID accessObjectId) {
    this.accessObjectId = accessObjectId;
    return this;
  }

  public PrivilegeBuilder setAccessObject(AccessObject accessObject) {
    this.accessObject = accessObject;
    return this;
  }

  public PrivilegeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PrivilegeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Privilege create() {
    return new Privilege(id, version, name, uiName, description, accessObjectId, accessObject, createdAt, deletedAt);
  }

  public static PrivilegeBuilder builder() {
    return new PrivilegeBuilder();
  }
}
