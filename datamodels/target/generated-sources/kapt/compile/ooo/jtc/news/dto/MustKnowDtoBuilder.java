package ooo.jtc.news.dto;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class MustKnowDtoBuilder {
  private UUID id;

  private UUID documentId;

  private UUID userId;

  private UUID customerId;

  private String customerName;

  private String inn;

  private String fio;

  private ZonedDateTime knowAt;

  private UUID mailingId;

  public MustKnowDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public MustKnowDtoBuilder setDocumentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  public MustKnowDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public MustKnowDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public MustKnowDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public MustKnowDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public MustKnowDtoBuilder setFio(String fio) {
    this.fio = fio;
    return this;
  }

  public MustKnowDtoBuilder setKnowAt(ZonedDateTime knowAt) {
    this.knowAt = knowAt;
    return this;
  }

  public MustKnowDtoBuilder setMailingId(UUID mailingId) {
    this.mailingId = mailingId;
    return this;
  }

  public MustKnowDto create() {
    return new MustKnowDto(id, documentId, userId, customerId, customerName, inn, fio, knowAt, mailingId);
  }

  public static MustKnowDtoBuilder builder() {
    return new MustKnowDtoBuilder();
  }
}
