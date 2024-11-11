package ooo.jtc.dictionaries.common.extid;

import java.lang.String;
import java.util.UUID;

public final class ExtIdBuilder {
  private UUID id;

  private int version;

  private UUID ownerId;

  private UUID extSystemId;

  private String externalId;

  public ExtIdBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ExtIdBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ExtIdBuilder setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  public ExtIdBuilder setExtSystemId(UUID extSystemId) {
    this.extSystemId = extSystemId;
    return this;
  }

  public ExtIdBuilder setExternalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  public ExtId create() {
    return new ExtId(id, version, ownerId, extSystemId, externalId);
  }

  public static ExtIdBuilder builder() {
    return new ExtIdBuilder();
  }
}
