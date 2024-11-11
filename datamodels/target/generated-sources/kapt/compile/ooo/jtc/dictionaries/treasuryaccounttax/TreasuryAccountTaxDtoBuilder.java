package ooo.jtc.dictionaries.treasuryaccounttax;

import java.lang.String;
import java.util.UUID;

public final class TreasuryAccountTaxDtoBuilder {
  private UUID id;

  private int version;

  private String tofk;

  private String account;

  private String bankName;

  private String bic;

  private String utraAccount;

  private String accountType;

  public TreasuryAccountTaxDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setTofk(String tofk) {
    this.tofk = tofk;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setUtraAccount(String utraAccount) {
    this.utraAccount = utraAccount;
    return this;
  }

  public TreasuryAccountTaxDtoBuilder setAccountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  public TreasuryAccountTaxDto create() {
    return new TreasuryAccountTaxDto(id, version, tofk, account, bankName, bic, utraAccount, accountType);
  }

  public static TreasuryAccountTaxDtoBuilder builder() {
    return new TreasuryAccountTaxDtoBuilder();
  }
}
