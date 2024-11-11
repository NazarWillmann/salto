package ooo.jtc.dictionaries.bankbic.acc.restr;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;

public final class BankBicAccRestrictionBuilder {
  private UUID id;

  private int version;

  private UUID bicId;

  private UUID accountId;

  private String restrictionCode;

  private LocalDate restrictionDate;

  public BankBicAccRestrictionBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicAccRestrictionBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicAccRestrictionBuilder setBicId(UUID bicId) {
    this.bicId = bicId;
    return this;
  }

  public BankBicAccRestrictionBuilder setAccountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  public BankBicAccRestrictionBuilder setRestrictionCode(String restrictionCode) {
    this.restrictionCode = restrictionCode;
    return this;
  }

  public BankBicAccRestrictionBuilder setRestrictionDate(LocalDate restrictionDate) {
    this.restrictionDate = restrictionDate;
    return this;
  }

  public BankBicAccRestriction create() {
    return new BankBicAccRestriction(id, version, bicId, accountId, restrictionCode, restrictionDate);
  }

  public static BankBicAccRestrictionBuilder builder() {
    return new BankBicAccRestrictionBuilder();
  }
}
