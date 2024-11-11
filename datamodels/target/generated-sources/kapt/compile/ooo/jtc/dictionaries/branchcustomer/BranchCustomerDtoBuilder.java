package ooo.jtc.dictionaries.branchcustomer;

import java.util.UUID;
import ooo.jtc.dictionaries.branch.BranchDto;
import ooo.jtc.dictionaries.customer.CustomerDto;

public final class BranchCustomerDtoBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID branchId;

  private BranchDto branch;

  private CustomerDto customer;

  public BranchCustomerDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchCustomerDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchCustomerDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public BranchCustomerDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public BranchCustomerDtoBuilder setBranch(BranchDto branch) {
    this.branch = branch;
    return this;
  }

  public BranchCustomerDtoBuilder setCustomer(CustomerDto customer) {
    this.customer = customer;
    return this;
  }

  public BranchCustomerDto create() {
    return new BranchCustomerDto(id, version, customerId, branchId, branch, customer);
  }

  public static BranchCustomerDtoBuilder builder() {
    return new BranchCustomerDtoBuilder();
  }
}
