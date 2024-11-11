package ooo.jtc.dictionaries.bankbic.acc.restr;

import java.time.LocalDate;
import java.util.UUID;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;

public final class BankBicAccRestrictionDtoBuilder {
  private UUID id;

  private int version;

  private ValDescIEnumDto restrictionCode;

  private LocalDate restrictionDate;

  public BankBicAccRestrictionDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicAccRestrictionDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicAccRestrictionDtoBuilder setRestrictionCode(ValDescIEnumDto restrictionCode) {
    this.restrictionCode = restrictionCode;
    return this;
  }

  public BankBicAccRestrictionDtoBuilder setRestrictionDate(LocalDate restrictionDate) {
    this.restrictionDate = restrictionDate;
    return this;
  }

  public BankBicAccRestrictionDto create() {
    return new BankBicAccRestrictionDto(id, version, restrictionCode, restrictionDate);
  }

  public static BankBicAccRestrictionDtoBuilder builder() {
    return new BankBicAccRestrictionDtoBuilder();
  }
}
