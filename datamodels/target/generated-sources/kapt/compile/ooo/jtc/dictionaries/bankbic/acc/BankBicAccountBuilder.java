package ooo.jtc.dictionaries.bankbic.acc;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.bankbic.acc.restr.BankBicAccRestriction;

public final class BankBicAccountBuilder {
  private UUID id;

  private int version;

  private UUID bicId;

  private String account;

  private String accountType;

  private String accountBic;

  private LocalDate dateIn;

  private LocalDate dateOut;

  private String status;

  private List<BankBicAccRestriction> restrictions;

  public BankBicAccountBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicAccountBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicAccountBuilder setBicId(UUID bicId) {
    this.bicId = bicId;
    return this;
  }

  public BankBicAccountBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public BankBicAccountBuilder setAccountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  public BankBicAccountBuilder setAccountBic(String accountBic) {
    this.accountBic = accountBic;
    return this;
  }

  public BankBicAccountBuilder setDateIn(LocalDate dateIn) {
    this.dateIn = dateIn;
    return this;
  }

  public BankBicAccountBuilder setDateOut(LocalDate dateOut) {
    this.dateOut = dateOut;
    return this;
  }

  public BankBicAccountBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public BankBicAccountBuilder setRestrictions(List<BankBicAccRestriction> restrictions) {
    this.restrictions = restrictions;
    return this;
  }

  public BankBicAccount create() {
    return new BankBicAccount(id, version, bicId, account, accountType, accountBic, dateIn, dateOut, status, restrictions);
  }

  public static BankBicAccountBuilder builder() {
    return new BankBicAccountBuilder();
  }
}
