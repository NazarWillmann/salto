package ooo.jtc.dictionaries.locationtype;

import java.lang.String;
import java.util.UUID;

public final class LocationTypeDtoBuilder {
  private UUID id;

  private int version;

  private String locationType;

  private String name;

  private String nameShort;

  public LocationTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LocationTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LocationTypeDtoBuilder setLocationType(String locationType) {
    this.locationType = locationType;
    return this;
  }

  public LocationTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public LocationTypeDtoBuilder setNameShort(String nameShort) {
    this.nameShort = nameShort;
    return this;
  }

  public LocationTypeDto create() {
    return new LocationTypeDto(id, version, locationType, name, nameShort);
  }

  public static LocationTypeDtoBuilder builder() {
    return new LocationTypeDtoBuilder();
  }
}
