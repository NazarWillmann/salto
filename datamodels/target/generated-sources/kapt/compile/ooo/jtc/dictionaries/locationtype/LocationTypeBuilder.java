package ooo.jtc.dictionaries.locationtype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class LocationTypeBuilder {
  private UUID id;

  private int version;

  private String locationType;

  private String name;

  private String nameShort;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public LocationTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LocationTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LocationTypeBuilder setLocationType(String locationType) {
    this.locationType = locationType;
    return this;
  }

  public LocationTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public LocationTypeBuilder setNameShort(String nameShort) {
    this.nameShort = nameShort;
    return this;
  }

  public LocationTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LocationTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public LocationType create() {
    return new LocationType(id, version, locationType, name, nameShort, createdAt, deletedAt);
  }

  public static LocationTypeBuilder builder() {
    return new LocationTypeBuilder();
  }
}
