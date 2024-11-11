package ooo.jtc.dictionaries.ground;

import java.lang.String;
import java.util.UUID;

public final class GroundUpdateRequestBuilder {
  private UUID id;

  private int version;

  private String description;

  public GroundUpdateRequestBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public GroundUpdateRequestBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public GroundUpdateRequestBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public GroundUpdateRequest create() {
    return new GroundUpdateRequest(id, version, description);
  }

  public static GroundUpdateRequestBuilder builder() {
    return new GroundUpdateRequestBuilder();
  }
}
