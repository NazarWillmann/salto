package ooo.jtc.dictionaries.codevo;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class CodeVoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public CodeVoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CodeVoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CodeVoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public CodeVoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CodeVoBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CodeVoBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public CodeVo create() {
    return new CodeVo(id, version, code, description, createdAt, deletedAt);
  }

  public static CodeVoBuilder builder() {
    return new CodeVoBuilder();
  }
}
