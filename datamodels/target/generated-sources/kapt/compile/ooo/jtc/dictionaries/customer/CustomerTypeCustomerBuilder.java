package ooo.jtc.dictionaries.customer;

import java.util.UUID;

public final class CustomerTypeCustomerBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID customerTypeId;

  public CustomerTypeCustomerBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerTypeCustomerBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerTypeCustomerBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public CustomerTypeCustomerBuilder setCustomerTypeId(UUID customerTypeId) {
    this.customerTypeId = customerTypeId;
    return this;
  }

  public CustomerTypeCustomer create() {
    return new CustomerTypeCustomer(id, version, customerId, customerTypeId);
  }

  public static CustomerTypeCustomerBuilder builder() {
    return new CustomerTypeCustomerBuilder();
  }
}
