package ooo.jtc.dictionaries.controlcode;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ControlCodeBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ControlCodeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ControlCodeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ControlCodeBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public ControlCodeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ControlCodeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ControlCodeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public ControlCode create() {
    return new ControlCode(id, version, code, description, createdAt, deletedAt);
  }

  public static ControlCodeBuilder builder() {
    return new ControlCodeBuilder();
  }
}
