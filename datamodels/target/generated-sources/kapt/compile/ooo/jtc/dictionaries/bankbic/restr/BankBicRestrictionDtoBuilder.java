package ooo.jtc.dictionaries.bankbic.restr;

import java.time.LocalDate;
import java.util.UUID;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;

public final class BankBicRestrictionDtoBuilder {
  private UUID id;

  private int version;

  private ValDescIEnumDto restrictionCode;

  private LocalDate restrictionDate;

  public BankBicRestrictionDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicRestrictionDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicRestrictionDtoBuilder setRestrictionCode(ValDescIEnumDto restrictionCode) {
    this.restrictionCode = restrictionCode;
    return this;
  }

  public BankBicRestrictionDtoBuilder setRestrictionDate(LocalDate restrictionDate) {
    this.restrictionDate = restrictionDate;
    return this;
  }

  public BankBicRestrictionDto create() {
    return new BankBicRestrictionDto(id, version, restrictionCode, restrictionDate);
  }

  public static BankBicRestrictionDtoBuilder builder() {
    return new BankBicRestrictionDtoBuilder();
  }
}
