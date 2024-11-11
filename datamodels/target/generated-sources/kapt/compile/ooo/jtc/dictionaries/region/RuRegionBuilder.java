package ooo.jtc.dictionaries.region;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class RuRegionBuilder {
  private UUID id;

  private int version;

  private String code;

  private String name;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public RuRegionBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RuRegionBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public RuRegionBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public RuRegionBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public RuRegionBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public RuRegionBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public RuRegion create() {
    return new RuRegion(id, version, code, name, createdAt, deletedAt);
  }

  public static RuRegionBuilder builder() {
    return new RuRegionBuilder();
  }
}
