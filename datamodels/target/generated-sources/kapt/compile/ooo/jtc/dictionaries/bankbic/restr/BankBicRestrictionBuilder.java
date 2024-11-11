package ooo.jtc.dictionaries.bankbic.restr;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;

public final class BankBicRestrictionBuilder {
  private UUID id;

  private int version;

  private UUID bicId;

  private String restrictionCode;

  private LocalDate restrictionDate;

  public BankBicRestrictionBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicRestrictionBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicRestrictionBuilder setBicId(UUID bicId) {
    this.bicId = bicId;
    return this;
  }

  public BankBicRestrictionBuilder setRestrictionCode(String restrictionCode) {
    this.restrictionCode = restrictionCode;
    return this;
  }

  public BankBicRestrictionBuilder setRestrictionDate(LocalDate restrictionDate) {
    this.restrictionDate = restrictionDate;
    return this;
  }

  public BankBicRestriction create() {
    return new BankBicRestriction(id, version, bicId, restrictionCode, restrictionDate);
  }

  public static BankBicRestrictionBuilder builder() {
    return new BankBicRestrictionBuilder();
  }
}
