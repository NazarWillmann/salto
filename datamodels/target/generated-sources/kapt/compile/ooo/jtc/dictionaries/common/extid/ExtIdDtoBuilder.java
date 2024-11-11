package ooo.jtc.dictionaries.common.extid;

import java.lang.String;
import java.util.UUID;

public final class ExtIdDtoBuilder {
  private UUID id;

  private int version;

  private UUID ownerId;

  private UUID extSystemId;

  private String externalId;

  public ExtIdDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ExtIdDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ExtIdDtoBuilder setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  public ExtIdDtoBuilder setExtSystemId(UUID extSystemId) {
    this.extSystemId = extSystemId;
    return this;
  }

  public ExtIdDtoBuilder setExternalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  public ExtIdDto create() {
    return new ExtIdDto(id, version, ownerId, extSystemId, externalId);
  }

  public static ExtIdDtoBuilder builder() {
    return new ExtIdDtoBuilder();
  }
}
