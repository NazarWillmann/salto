package ooo.jtc.rolemodel.accessobjecttype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class AccessObjectTypeBuilder {
  private UUID id;

  private int version;

  private String name;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public AccessObjectTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccessObjectTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccessObjectTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccessObjectTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public AccessObjectTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public AccessObjectType create() {
    return new AccessObjectType(id, version, name, createdAt, deletedAt);
  }

  public static AccessObjectTypeBuilder builder() {
    return new AccessObjectTypeBuilder();
  }
}
