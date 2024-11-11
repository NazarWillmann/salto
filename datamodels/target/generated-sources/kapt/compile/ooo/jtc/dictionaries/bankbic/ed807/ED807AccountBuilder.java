package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;

public final class ED807AccountBuilder {
  private String account;

  private String regulationAccountType;

  private String ck;

  private String accountCbrBic;

  private LocalDate dateIn;

  private LocalDate dateOut;

  private String accountStatus;

  private List<ED807AccountRestriction> restrictionList;

  public ED807AccountBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public ED807AccountBuilder setRegulationAccountType(String regulationAccountType) {
    this.regulationAccountType = regulationAccountType;
    return this;
  }

  public ED807AccountBuilder setCk(String ck) {
    this.ck = ck;
    return this;
  }

  public ED807AccountBuilder setAccountCbrBic(String accountCbrBic) {
    this.accountCbrBic = accountCbrBic;
    return this;
  }

  public ED807AccountBuilder setDateIn(LocalDate dateIn) {
    this.dateIn = dateIn;
    return this;
  }

  public ED807AccountBuilder setDateOut(LocalDate dateOut) {
    this.dateOut = dateOut;
    return this;
  }

  public ED807AccountBuilder setAccountStatus(String accountStatus) {
    this.accountStatus = accountStatus;
    return this;
  }

  public ED807AccountBuilder setRestrictionList(List<ED807AccountRestriction> restrictionList) {
    this.restrictionList = restrictionList;
    return this;
  }

  public ED807Account create() {
    return new ED807Account(account, regulationAccountType, ck, accountCbrBic, dateIn, dateOut, accountStatus, restrictionList);
  }

  public static ED807AccountBuilder builder() {
    return new ED807AccountBuilder();
  }
}
