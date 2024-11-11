package ooo.jtc.dictionaries.okfs;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class OkfsBuilder {
  private UUID id;

  private int version;

  private String code;

  private String parentCode;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public OkfsBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public OkfsBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public OkfsBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public OkfsBuilder setParentCode(String parentCode) {
    this.parentCode = parentCode;
    return this;
  }

  public OkfsBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public OkfsBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public OkfsBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Okfs create() {
    return new Okfs(id, version, code, parentCode, description, createdAt, deletedAt);
  }

  public static OkfsBuilder builder() {
    return new OkfsBuilder();
  }
}
