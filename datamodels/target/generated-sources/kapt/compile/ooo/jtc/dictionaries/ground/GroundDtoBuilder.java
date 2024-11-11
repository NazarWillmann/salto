package ooo.jtc.dictionaries.ground;

import java.lang.String;
import java.util.UUID;

public final class GroundDtoBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID contractorId;

  private String description;

  public GroundDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public GroundDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public GroundDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public GroundDtoBuilder setContractorId(UUID contractorId) {
    this.contractorId = contractorId;
    return this;
  }

  public GroundDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public GroundDto create() {
    return new GroundDto(id, version, customerId, contractorId, description);
  }

  public static GroundDtoBuilder builder() {
    return new GroundDtoBuilder();
  }
}
