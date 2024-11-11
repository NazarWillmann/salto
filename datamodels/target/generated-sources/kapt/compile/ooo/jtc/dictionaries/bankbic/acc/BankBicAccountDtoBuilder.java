package ooo.jtc.dictionaries.bankbic.acc;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestrictionDto;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;

public final class BankBicAccountDtoBuilder {
  private UUID id;

  private int version;

  private String account;

  private ValDescIEnumDto accountType;

  private String accountBic;

  private LocalDate dateIn;

  private LocalDate dateOut;

  private ValDescIEnumDto status;

  private List<BankBicAccRestrictionDto> restrictions;

  public BankBicAccountDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicAccountDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicAccountDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public BankBicAccountDtoBuilder setAccountType(ValDescIEnumDto accountType) {
    this.accountType = accountType;
    return this;
  }

  public BankBicAccountDtoBuilder setAccountBic(String accountBic) {
    this.accountBic = accountBic;
    return this;
  }

  public BankBicAccountDtoBuilder setDateIn(LocalDate dateIn) {
    this.dateIn = dateIn;
    return this;
  }

  public BankBicAccountDtoBuilder setDateOut(LocalDate dateOut) {
    this.dateOut = dateOut;
    return this;
  }

  public BankBicAccountDtoBuilder setStatus(ValDescIEnumDto status) {
    this.status = status;
    return this;
  }

  public BankBicAccountDtoBuilder setRestrictions(List<BankBicAccRestrictionDto> restrictions) {
    this.restrictions = restrictions;
    return this;
  }

  public BankBicAccountDto create() {
    return new BankBicAccountDto(id, version, account, accountType, accountBic, dateIn, dateOut, status, restrictions);
  }

  public static BankBicAccountDtoBuilder builder() {
    return new BankBicAccountDtoBuilder();
  }
}
