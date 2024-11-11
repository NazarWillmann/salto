package ooo.jtc.dictionaries.bankbic.innerenum;

import java.lang.String;

public final class ValDescIEnumDtoBuilder {
  private String value;

  private String description;

  public ValDescIEnumDtoBuilder setValue(String value) {
    this.value = value;
    return this;
  }

  public ValDescIEnumDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ValDescIEnumDto create() {
    return new ValDescIEnumDto(value, description);
  }

  public static ValDescIEnumDtoBuilder builder() {
    return new ValDescIEnumDtoBuilder();
  }
}
