package ooo.jtc.dictionaries.treasuryaccounttax;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class TreasuryAccountTaxBuilder {
  private UUID id;

  private int version;

  private String tofk;

  private String account;

  private String bankName;

  private String bic;

  private String utraAccount;

  private String accountType;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public TreasuryAccountTaxBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TreasuryAccountTaxBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public TreasuryAccountTaxBuilder setTofk(String tofk) {
    this.tofk = tofk;
    return this;
  }

  public TreasuryAccountTaxBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public TreasuryAccountTaxBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public TreasuryAccountTaxBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public TreasuryAccountTaxBuilder setUtraAccount(String utraAccount) {
    this.utraAccount = utraAccount;
    return this;
  }

  public TreasuryAccountTaxBuilder setAccountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  public TreasuryAccountTaxBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public TreasuryAccountTaxBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public TreasuryAccountTax create() {
    return new TreasuryAccountTax(id, version, tofk, account, bankName, bic, utraAccount, accountType, createdAt, deletedAt);
  }

  public static TreasuryAccountTaxBuilder builder() {
    return new TreasuryAccountTaxBuilder();
  }
}
