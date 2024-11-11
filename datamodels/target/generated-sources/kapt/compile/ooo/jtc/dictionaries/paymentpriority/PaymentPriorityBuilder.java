package ooo.jtc.dictionaries.paymentpriority;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class PaymentPriorityBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public PaymentPriorityBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PaymentPriorityBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PaymentPriorityBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public PaymentPriorityBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PaymentPriorityBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PaymentPriorityBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public PaymentPriority create() {
    return new PaymentPriority(id, version, code, description, createdAt, deletedAt);
  }

  public static PaymentPriorityBuilder builder() {
    return new PaymentPriorityBuilder();
  }
}
