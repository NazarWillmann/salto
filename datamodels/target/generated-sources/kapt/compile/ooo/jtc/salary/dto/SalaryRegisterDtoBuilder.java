package ooo.jtc.salary.dto;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public final class SalaryRegisterDtoBuilder {
  private UUID id;

  private int version;

  private String status;

  private LocalDate documentDate;

  private String documentNumber;

  private UUID customerId;

  private String createdAt;

  private String modifiedAt;

  private String schemeVersion;

  private String channel;

  private String customerName;

  private UUID branchId;

  private String branchName;

  private String receiveDate;

  private String executionDate;

  private String executionMessage;

  private boolean isFavorites;

  private List<SalaryRegisterPayrollDto> payrolls;

  private UUID userId;

  private String customerInn;

  private String customerOkpo;

  private String accountDebet;

  private UUID accountId;

  private String official;

  private String officialPhone;

  private String periodMonth;

  private String periodYear;

  private String amount;

  private String currencyCode;

  private int recordsTotal;

  private String payDocumentNumber;

  private LocalDate payDocumentDate;

  private String payDocumentGround;

  private String paymentId;

  public SalaryRegisterDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryRegisterDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryRegisterDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public SalaryRegisterDtoBuilder setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public SalaryRegisterDtoBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public SalaryRegisterDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public SalaryRegisterDtoBuilder setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public SalaryRegisterDtoBuilder setModifiedAt(String modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

  public SalaryRegisterDtoBuilder setSchemeVersion(String schemeVersion) {
    this.schemeVersion = schemeVersion;
    return this;
  }

  public SalaryRegisterDtoBuilder setChannel(String channel) {
    this.channel = channel;
    return this;
  }

  public SalaryRegisterDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public SalaryRegisterDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public SalaryRegisterDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public SalaryRegisterDtoBuilder setReceiveDate(String receiveDate) {
    this.receiveDate = receiveDate;
    return this;
  }

  public SalaryRegisterDtoBuilder setExecutionDate(String executionDate) {
    this.executionDate = executionDate;
    return this;
  }

  public SalaryRegisterDtoBuilder setExecutionMessage(String executionMessage) {
    this.executionMessage = executionMessage;
    return this;
  }

  public SalaryRegisterDtoBuilder setIsFavorites(boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public SalaryRegisterDtoBuilder setPayrolls(List<SalaryRegisterPayrollDto> payrolls) {
    this.payrolls = payrolls;
    return this;
  }

  public SalaryRegisterDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public SalaryRegisterDtoBuilder setCustomerInn(String customerInn) {
    this.customerInn = customerInn;
    return this;
  }

  public SalaryRegisterDtoBuilder setCustomerOkpo(String customerOkpo) {
    this.customerOkpo = customerOkpo;
    return this;
  }

  public SalaryRegisterDtoBuilder setAccountDebet(String accountDebet) {
    this.accountDebet = accountDebet;
    return this;
  }

  public SalaryRegisterDtoBuilder setAccountId(UUID accountId) {
    this.accountId = accountId;
    return this;
  }

  public SalaryRegisterDtoBuilder setOfficial(String official) {
    this.official = official;
    return this;
  }

  public SalaryRegisterDtoBuilder setOfficialPhone(String officialPhone) {
    this.officialPhone = officialPhone;
    return this;
  }

  public SalaryRegisterDtoBuilder setPeriodMonth(String periodMonth) {
    this.periodMonth = periodMonth;
    return this;
  }

  public SalaryRegisterDtoBuilder setPeriodYear(String periodYear) {
    this.periodYear = periodYear;
    return this;
  }

  public SalaryRegisterDtoBuilder setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public SalaryRegisterDtoBuilder setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }

  public SalaryRegisterDtoBuilder setRecordsTotal(int recordsTotal) {
    this.recordsTotal = recordsTotal;
    return this;
  }

  public SalaryRegisterDtoBuilder setPayDocumentNumber(String payDocumentNumber) {
    this.payDocumentNumber = payDocumentNumber;
    return this;
  }

  public SalaryRegisterDtoBuilder setPayDocumentDate(LocalDate payDocumentDate) {
    this.payDocumentDate = payDocumentDate;
    return this;
  }

  public SalaryRegisterDtoBuilder setPayDocumentGround(String payDocumentGround) {
    this.payDocumentGround = payDocumentGround;
    return this;
  }

  public SalaryRegisterDtoBuilder setPaymentId(String paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  public SalaryRegisterDto create() {
    return new SalaryRegisterDto(id, version, status, documentDate, documentNumber, customerId, createdAt, modifiedAt, schemeVersion, channel, customerName, branchId, branchName, receiveDate, executionDate, executionMessage, isFavorites, payrolls, userId, customerInn, customerOkpo, accountDebet, accountId, official, officialPhone, periodMonth, periodYear, amount, currencyCode, recordsTotal, payDocumentNumber, payDocumentDate, payDocumentGround, paymentId);
  }

  public static SalaryRegisterDtoBuilder builder() {
    return new SalaryRegisterDtoBuilder();
  }
}
