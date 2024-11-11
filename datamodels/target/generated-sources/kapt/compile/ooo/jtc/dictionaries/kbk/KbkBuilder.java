package ooo.jtc.dictionaries.kbk;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class KbkBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public KbkBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public KbkBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public KbkBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public KbkBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public KbkBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public KbkBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Kbk create() {
    return new Kbk(id, version, code, description, createdAt, deletedAt);
  }

  public static KbkBuilder builder() {
    return new KbkBuilder();
  }
}
