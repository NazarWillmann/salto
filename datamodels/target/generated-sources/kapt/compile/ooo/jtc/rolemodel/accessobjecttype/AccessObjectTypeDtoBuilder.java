package ooo.jtc.rolemodel.accessobjecttype;

import java.lang.String;
import java.util.UUID;

public final class AccessObjectTypeDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  public AccessObjectTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccessObjectTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccessObjectTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccessObjectTypeDto create() {
    return new AccessObjectTypeDto(id, version, name);
  }

  public static AccessObjectTypeDtoBuilder builder() {
    return new AccessObjectTypeDtoBuilder();
  }
}
