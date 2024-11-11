package ooo.jtc.dictionaries.customerkpp;

import java.lang.String;
import java.util.UUID;

public final class CustomerKppDtoBuilder {
  private UUID id;

  private int version;

  private String unitName;

  private String kpp;

  private boolean isDefault;

  public CustomerKppDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerKppDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerKppDtoBuilder setUnitName(String unitName) {
    this.unitName = unitName;
    return this;
  }

  public CustomerKppDtoBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public CustomerKppDtoBuilder setIsDefault(boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public CustomerKppDto create() {
    return new CustomerKppDto(id, version, unitName, kpp, isDefault);
  }

  public static CustomerKppDtoBuilder builder() {
    return new CustomerKppDtoBuilder();
  }
}
