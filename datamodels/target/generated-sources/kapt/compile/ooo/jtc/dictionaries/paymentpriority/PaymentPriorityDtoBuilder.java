package ooo.jtc.dictionaries.paymentpriority;

import java.lang.String;
import java.util.UUID;

public final class PaymentPriorityDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public PaymentPriorityDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PaymentPriorityDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PaymentPriorityDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public PaymentPriorityDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PaymentPriorityDto create() {
    return new PaymentPriorityDto(id, version, code, description);
  }

  public static PaymentPriorityDtoBuilder builder() {
    return new PaymentPriorityDtoBuilder();
  }
}
