package ooo.jtc.dictionaries.okopf;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class OkopfBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public OkopfBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public OkopfBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public OkopfBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public OkopfBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public OkopfBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public OkopfBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Okopf create() {
    return new Okopf(id, version, code, description, createdAt, deletedAt);
  }

  public static OkopfBuilder builder() {
    return new OkopfBuilder();
  }
}
