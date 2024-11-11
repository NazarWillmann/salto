package ooo.jtc.dictionaries.paymenttype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class PaymentTypeBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public PaymentTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PaymentTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PaymentTypeBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public PaymentTypeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PaymentTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PaymentTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public PaymentType create() {
    return new PaymentType(id, version, code, description, createdAt, deletedAt);
  }

  public static PaymentTypeBuilder builder() {
    return new PaymentTypeBuilder();
  }
}
