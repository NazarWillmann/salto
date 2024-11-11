package ooo.jtc.dictionaries.ground;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class GroundBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID contractorId;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public GroundBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public GroundBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public GroundBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public GroundBuilder setContractorId(UUID contractorId) {
    this.contractorId = contractorId;
    return this;
  }

  public GroundBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public GroundBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public GroundBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Ground create() {
    return new Ground(id, version, customerId, contractorId, description, createdAt, deletedAt);
  }

  public static GroundBuilder builder() {
    return new GroundBuilder();
  }
}
