package ooo.jtc.dictionaries.region;

import java.lang.String;
import java.util.UUID;

public final class RuRegionDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String name;

  public RuRegionDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RuRegionDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public RuRegionDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public RuRegionDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public RuRegionDto create() {
    return new RuRegionDto(id, version, code, name);
  }

  public static RuRegionDtoBuilder builder() {
    return new RuRegionDtoBuilder();
  }
}
