package ooo.jtc.dictionaries.branchindividual;

import java.sql.Timestamp;
import java.util.UUID;

public final class BranchIndividualBuilder {
  private UUID id;

  private int version;

  private UUID branchId;

  private UUID individualId;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BranchIndividualBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchIndividualBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchIndividualBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public BranchIndividualBuilder setIndividualId(UUID individualId) {
    this.individualId = individualId;
    return this;
  }

  public BranchIndividualBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BranchIndividualBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BranchIndividual create() {
    return new BranchIndividual(id, version, branchId, individualId, createdAt, deletedAt);
  }

  public static BranchIndividualBuilder builder() {
    return new BranchIndividualBuilder();
  }
}
