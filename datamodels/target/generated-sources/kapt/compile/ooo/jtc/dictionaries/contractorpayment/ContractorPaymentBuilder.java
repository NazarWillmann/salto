package ooo.jtc.dictionaries.contractorpayment;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ContractorPaymentBuilder {
  private UUID id;

  private int version;

  private UUID contractorId;

  private String bankName;

  private String bankAddress;

  private String corrAccount;

  private boolean isDefault;

  private String account;

  private String bic;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ContractorPaymentBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorPaymentBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorPaymentBuilder setContractorId(UUID contractorId) {
    this.contractorId = contractorId;
    return this;
  }

  public ContractorPaymentBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public ContractorPaymentBuilder setBankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
    return this;
  }

  public ContractorPaymentBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public ContractorPaymentBuilder setIsDefault(boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public ContractorPaymentBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public ContractorPaymentBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public ContractorPaymentBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ContractorPaymentBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public ContractorPayment create() {
    return new ContractorPayment(id, version, contractorId, bankName, bankAddress, corrAccount, isDefault, account, bic, createdAt, deletedAt);
  }

  public static ContractorPaymentBuilder builder() {
    return new ContractorPaymentBuilder();
  }
}
