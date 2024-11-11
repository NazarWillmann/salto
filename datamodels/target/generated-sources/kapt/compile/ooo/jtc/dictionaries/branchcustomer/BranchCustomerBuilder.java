package ooo.jtc.dictionaries.branchcustomer;

import java.sql.Timestamp;
import java.util.UUID;

public final class BranchCustomerBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID branchId;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BranchCustomerBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchCustomerBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchCustomerBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public BranchCustomerBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public BranchCustomerBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BranchCustomerBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BranchCustomer create() {
    return new BranchCustomer(id, version, customerId, branchId, createdAt, deletedAt);
  }

  public static BranchCustomerBuilder builder() {
    return new BranchCustomerBuilder();
  }
}
