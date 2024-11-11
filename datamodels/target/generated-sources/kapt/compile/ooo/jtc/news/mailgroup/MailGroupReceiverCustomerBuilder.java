package ooo.jtc.news.mailgroup;

import java.lang.String;
import java.util.UUID;

public final class MailGroupReceiverCustomerBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private String customerName;

  private String inn;

  private UUID idMailGroup;

  public MailGroupReceiverCustomerBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public MailGroupReceiverCustomerBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public MailGroupReceiverCustomerBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public MailGroupReceiverCustomerBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public MailGroupReceiverCustomerBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public MailGroupReceiverCustomerBuilder setIdMailGroup(UUID idMailGroup) {
    this.idMailGroup = idMailGroup;
    return this;
  }

  public MailGroupReceiverCustomer create() {
    return new MailGroupReceiverCustomer(id, version, customerId, customerName, inn, idMailGroup);
  }

  public static MailGroupReceiverCustomerBuilder builder() {
    return new MailGroupReceiverCustomerBuilder();
  }
}
