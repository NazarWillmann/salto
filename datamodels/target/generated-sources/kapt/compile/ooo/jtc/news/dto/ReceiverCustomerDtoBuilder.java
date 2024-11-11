package ooo.jtc.news.dto;

import java.lang.String;
import java.util.UUID;

public final class ReceiverCustomerDtoBuilder {
  private UUID id;

  private int version;

  private UUID documentId;

  private UUID customerId;

  private String customerName;

  private String inn;

  public ReceiverCustomerDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ReceiverCustomerDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ReceiverCustomerDtoBuilder setDocumentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  public ReceiverCustomerDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public ReceiverCustomerDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public ReceiverCustomerDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public ReceiverCustomerDto create() {
    return new ReceiverCustomerDto(id, version, documentId, customerId, customerName, inn);
  }

  public static ReceiverCustomerDtoBuilder builder() {
    return new ReceiverCustomerDtoBuilder();
  }
}
