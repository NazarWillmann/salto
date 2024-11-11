package ooo.jtc.dictionaries.account;

import java.lang.String;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.accountype.AccountTypeDto;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.extid.ExtIdDto;

public final class AccountDtoBuilder {
  private UUID id;

  private int version;

  private UUID branchCustomerId;

  private UUID customerId;

  private UUID branchIndividualId;

  private UUID individualId;

  private UUID branchId;

  private String accountNumber;

  private String accountKind;

  private UUID accountTypeId;

  private String state;

  private String name;

  private ZonedDateTime reserveBeginDate;

  private ZonedDateTime reserveEndDate;

  private ZonedDateTime openDate;

  private ZonedDateTime closeDate;

  private String currencyAlphaCode;

  private String currencyDigitCode;

  private boolean isMarkInfo;

  private BigDecimal actualBalance;

  private BigDecimal planBalance;

  private BigDecimal blockedAmount;

  private ZonedDateTime actualDate;

  private String description;

  private BigDecimal cardAmount;

  private BlockingInfoDto block;

  private List<ExtIdDto> extIds;

  private AccountTypeDto accountType;

  public AccountDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccountDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccountDtoBuilder setBranchCustomerId(UUID branchCustomerId) {
    this.branchCustomerId = branchCustomerId;
    return this;
  }

  public AccountDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public AccountDtoBuilder setBranchIndividualId(UUID branchIndividualId) {
    this.branchIndividualId = branchIndividualId;
    return this;
  }

  public AccountDtoBuilder setIndividualId(UUID individualId) {
    this.individualId = individualId;
    return this;
  }

  public AccountDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public AccountDtoBuilder setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  public AccountDtoBuilder setAccountKind(String accountKind) {
    this.accountKind = accountKind;
    return this;
  }

  public AccountDtoBuilder setAccountTypeId(UUID accountTypeId) {
    this.accountTypeId = accountTypeId;
    return this;
  }

  public AccountDtoBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public AccountDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public AccountDtoBuilder setReserveBeginDate(ZonedDateTime reserveBeginDate) {
    this.reserveBeginDate = reserveBeginDate;
    return this;
  }

  public AccountDtoBuilder setReserveEndDate(ZonedDateTime reserveEndDate) {
    this.reserveEndDate = reserveEndDate;
    return this;
  }

  public AccountDtoBuilder setOpenDate(ZonedDateTime openDate) {
    this.openDate = openDate;
    return this;
  }

  public AccountDtoBuilder setCloseDate(ZonedDateTime closeDate) {
    this.closeDate = closeDate;
    return this;
  }

  public AccountDtoBuilder setCurrencyAlphaCode(String currencyAlphaCode) {
    this.currencyAlphaCode = currencyAlphaCode;
    return this;
  }

  public AccountDtoBuilder setCurrencyDigitCode(String currencyDigitCode) {
    this.currencyDigitCode = currencyDigitCode;
    return this;
  }

  public AccountDtoBuilder setIsMarkInfo(boolean isMarkInfo) {
    this.isMarkInfo = isMarkInfo;
    return this;
  }

  public AccountDtoBuilder setActualBalance(BigDecimal actualBalance) {
    this.actualBalance = actualBalance;
    return this;
  }

  public AccountDtoBuilder setPlanBalance(BigDecimal planBalance) {
    this.planBalance = planBalance;
    return this;
  }

  public AccountDtoBuilder setBlockedAmount(BigDecimal blockedAmount) {
    this.blockedAmount = blockedAmount;
    return this;
  }

  public AccountDtoBuilder setActualDate(ZonedDateTime actualDate) {
    this.actualDate = actualDate;
    return this;
  }

  public AccountDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccountDtoBuilder setCardAmount(BigDecimal cardAmount) {
    this.cardAmount = cardAmount;
    return this;
  }

  public AccountDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public AccountDtoBuilder setExtIds(List<ExtIdDto> extIds) {
    this.extIds = extIds;
    return this;
  }

  public AccountDtoBuilder setAccountType(AccountTypeDto accountType) {
    this.accountType = accountType;
    return this;
  }

  public AccountDto create() {
    return new AccountDto(id, version, branchCustomerId, customerId, branchIndividualId, individualId, branchId, accountNumber, accountKind, accountTypeId, state, name, reserveBeginDate, reserveEndDate, openDate, closeDate, currencyAlphaCode, currencyDigitCode, isMarkInfo, actualBalance, planBalance, blockedAmount, actualDate, description, cardAmount, block, extIds, accountType);
  }

  public static AccountDtoBuilder builder() {
    return new AccountDtoBuilder();
  }
}
