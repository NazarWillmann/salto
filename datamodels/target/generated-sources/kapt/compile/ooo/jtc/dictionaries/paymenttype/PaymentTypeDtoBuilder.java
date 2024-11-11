package ooo.jtc.dictionaries.paymenttype;

import java.lang.String;
import java.util.UUID;

public final class PaymentTypeDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public PaymentTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PaymentTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PaymentTypeDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public PaymentTypeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PaymentTypeDto create() {
    return new PaymentTypeDto(id, version, code, description);
  }

  public static PaymentTypeDtoBuilder builder() {
    return new PaymentTypeDtoBuilder();
  }
}
