package ooo.jtc.dictionaries.account;

import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.accountype.AccountType;
import ooo.jtc.dictionaries.common.extid.ExtId;

public final class AccountBuilder {
  private UUID id;

  private int version;

  private UUID branchCustomerId;

  private UUID branchIndividualId;

  private String accountNumber;

  private String accountKind;

  private UUID accountTypeId;

  private String state;

  private String name;

  private Timestamp reserveBeginDate;

  private Timestamp reserveEndDate;

  private Timestamp openDate;

  private Timestamp closeDate;

  private String currencyAlphaCode;

  private String currencyDigitCode;

  private boolean isMarkInfo;

  private String description;

  private BigDecimal actualBalance;

  private BigDecimal planBalance;

  private BigDecimal blockedAmount;

  private BigDecimal cardAmount;

  private Timestamp actualDate;

  private boolean isBlock;

  private UUID blockUserId;

  private Timestamp blockDate;

  private UUID customerId;

  private UUID branchId;

  private UUID individualId;

  private AccountType accountType;

  private List<ExtId> extIds;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public AccountBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccountBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccountBuilder setBranchCustomerId(UUID branchCustomerId) {
    this.branchCustomerId = branchCustomerId;
    return this;
  }

  public AccountBuilder setBranchIndividualId(UUID branchIndividualId) {
    this.branchIndividualId = branchIndividualId;
    return this;
  }

  public AccountBuilder setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public AccountBuilder setAccountKind(String accountKind) {
    this.accountKind = accountKind;
    return this;
  }

  public AccountBuilder setAccountTypeId(UUID accountTypeId) {
    this.accountTypeId = accountTypeId;
    return this;
  }

  public AccountBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public AccountBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccountBuilder setReserveBeginDate(Timestamp reserveBeginDate) {
    this.reserveBeginDate = reserveBeginDate;
    return this;
  }

  public AccountBuilder setReserveEndDate(Timestamp reserveEndDate) {
    this.reserveEndDate = reserveEndDate;
    return this;
  }

  public AccountBuilder setOpenDate(Timestamp openDate) {
    this.openDate = openDate;
    return this;
  }

  public AccountBuilder setCloseDate(Timestamp closeDate) {
    this.closeDate = closeDate;
    return this;
  }

  public AccountBuilder setCurrencyAlphaCode(String currencyAlphaCode) {
    this.currencyAlphaCode = currencyAlphaCode;
    return this;
  }

  public AccountBuilder setCurrencyDigitCode(String currencyDigitCode) {
    this.currencyDigitCode = currencyDigitCode;
    return this;
  }

  public AccountBuilder setIsMarkInfo(boolean isMarkInfo) {
    this.isMarkInfo = isMarkInfo;
    return this;
  }

  public AccountBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccountBuilder setActualBalance(BigDecimal actualBalance) {
    this.actualBalance = actualBalance;
    return this;
  }

  public AccountBuilder setPlanBalance(BigDecimal planBalance) {
    this.planBalance = planBalance;
    return this;
  }

  public AccountBuilder setBlockedAmount(BigDecimal blockedAmount) {
    this.blockedAmount = blockedAmount;
    return this;
  }

  public AccountBuilder setCardAmount(BigDecimal cardAmount) {
    this.cardAmount = cardAmount;
    return this;
  }

  public AccountBuilder setActualDate(Timestamp actualDate) {
    this.actualDate = actualDate;
    return this;
  }

  public AccountBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public AccountBuilder setBlockUserId(UUID blockUserId) {
    this.blockUserId = blockUserId;
    return this;
  }

  public AccountBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public AccountBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public AccountBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public AccountBuilder setIndividualId(UUID individualId) {
    this.individualId = individualId;
    return this;
  }

  public AccountBuilder setAccountType(AccountType accountType) {
    this.accountType = accountType;
    return this;
  }

  public AccountBuilder setExtIds(List<ExtId> extIds) {
    this.extIds = extIds;
    return this;
  }

  public AccountBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public AccountBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Account create() {
    return new Account(id, version, branchCustomerId, branchIndividualId, accountNumber, accountKind, accountTypeId, state, name, reserveBeginDate, reserveEndDate, openDate, closeDate, currencyAlphaCode, currencyDigitCode, isMarkInfo, description, actualBalance, planBalance, blockedAmount, cardAmount, actualDate, isBlock, blockUserId, blockDate, customerId, branchId, individualId, accountType, extIds, createdAt, deletedAt);
  }

  public static AccountBuilder builder() {
    return new AccountBuilder();
  }
}
