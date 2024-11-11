package ooo.jtc.dictionaries.bankbic.innerenum;

import java.lang.String;

public final class BankBicAllowedServicesIEnumDtoBuilder {
  private String value;

  private String description;

  private boolean normalPays;

  private boolean urgentPays;

  private boolean quickPays;

  public BankBicAllowedServicesIEnumDtoBuilder setValue(String value) {
    this.value = value;
    return this;
  }

  public BankBicAllowedServicesIEnumDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BankBicAllowedServicesIEnumDtoBuilder setNormalPays(boolean normalPays) {
    this.normalPays = normalPays;
    return this;
  }

  public BankBicAllowedServicesIEnumDtoBuilder setUrgentPays(boolean urgentPays) {
    this.urgentPays = urgentPays;
    return this;
  }

  public BankBicAllowedServicesIEnumDtoBuilder setQuickPays(boolean quickPays) {
    this.quickPays = quickPays;
    return this;
  }

  public BankBicAllowedServicesIEnumDto create() {
    return new BankBicAllowedServicesIEnumDto(value, description, normalPays, urgentPays, quickPays);
  }

  public static BankBicAllowedServicesIEnumDtoBuilder builder() {
    return new BankBicAllowedServicesIEnumDtoBuilder();
  }
}
