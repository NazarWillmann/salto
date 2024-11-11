package ooo.jtc.dictionaries.contractorpayment;

import java.lang.String;
import java.util.UUID;

public final class ContractorPaymentDtoBuilder {
  private UUID id;

  private int version;

  private UUID contractorId;

  private String account;

  private String bankName;

  private String bankAddress;

  private String corrAccount;

  private String bic;

  private boolean isDefault;

  public ContractorPaymentDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorPaymentDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorPaymentDtoBuilder setContractorId(UUID contractorId) {
    this.contractorId = contractorId;
    return this;
  }

  public ContractorPaymentDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public ContractorPaymentDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public ContractorPaymentDtoBuilder setBankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
    return this;
  }

  public ContractorPaymentDtoBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public ContractorPaymentDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public ContractorPaymentDtoBuilder setIsDefault(boolean isDefault) {
    this.isDefault = isDefault;
    return this;
  }

  public ContractorPaymentDto create() {
    return new ContractorPaymentDto(id, version, contractorId, account, bankName, bankAddress, corrAccount, bic, isDefault);
  }

  public static ContractorPaymentDtoBuilder builder() {
    return new ContractorPaymentDtoBuilder();
  }
}
