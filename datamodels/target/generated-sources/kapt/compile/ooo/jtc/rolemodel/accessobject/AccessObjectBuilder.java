package ooo.jtc.rolemodel.accessobject;

import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class AccessObjectBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private UUID objectTypeId;

  private UUID productId;

  private String path;

  private Boolean hasControls;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public AccessObjectBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccessObjectBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccessObjectBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccessObjectBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public AccessObjectBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccessObjectBuilder setObjectTypeId(UUID objectTypeId) {
    this.objectTypeId = objectTypeId;
    return this;
  }

  public AccessObjectBuilder setProductId(UUID productId) {
    this.productId = productId;
    return this;
  }

  public AccessObjectBuilder setPath(String path) {
    this.path = path;
    return this;
  }

  public AccessObjectBuilder setHasControls(Boolean hasControls) {
    this.hasControls = hasControls;
    return this;
  }

  public AccessObjectBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public AccessObjectBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public AccessObject create() {
    return new AccessObject(id, version, name, uiName, description, objectTypeId, productId, path, hasControls, createdAt, deletedAt);
  }

  public static AccessObjectBuilder builder() {
    return new AccessObjectBuilder();
  }
}
