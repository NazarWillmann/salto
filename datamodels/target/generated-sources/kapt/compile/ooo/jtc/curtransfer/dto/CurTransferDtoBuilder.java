package ooo.jtc.curtransfer.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import ooo.jtc.curtransfer.model.CurTrChargeType;

public final class CurTransferDtoBuilder {
  private UUID id;

  private int version;

  private String documentNumber;

  private LocalDate documentDate;

  private UUID customerId;

  private String status;

  private ZonedDateTime createdAt;

  private ZonedDateTime modifiedAt;

  private ZonedDateTime receiveDate;

  private ZonedDateTime executionDate;

  private Boolean isFavorites;

  private String messageFromBank;

  private String customerName;

  private UUID branchId;

  private String branchName;

  private MoneyAmountDto debit;

  private LocalDate valueDate;

  private String urgency;

  private MoneyAmountDto transfer;

  private String rateType;

  private Integer rate;

  private CurTrPayerDto payer;

  private CurTrPayerBankDto payerBank;

  private CurTrBeneficiaryDto beneficiary;

  private CurTrBeneficiaryBankDto beneficiaryBank;

  private CurTrIntermediaryBankDto intermediaryBank;

  private String paymentInformation;

  private CurTrChargeType chargeType;

  private String chargeAccount;

  private String chargeBic;

  private String paymentAddInformation;

  private String contactName;

  private String contactPhone;

  private List<CurRegulationInfoDto> regulationInfos;

  private Boolean isReceived;

  private Boolean isExecuted;

  private Boolean isDeclined;

  private Boolean isNotReceived;

  private Boolean isRecalled;

  public CurTransferDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CurTransferDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CurTransferDtoBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public CurTransferDtoBuilder setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public CurTransferDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public CurTransferDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public CurTransferDtoBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CurTransferDtoBuilder setModifiedAt(ZonedDateTime modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

  public CurTransferDtoBuilder setReceiveDate(ZonedDateTime receiveDate) {
    this.receiveDate = receiveDate;
    return this;
  }

  public CurTransferDtoBuilder setExecutionDate(ZonedDateTime executionDate) {
    this.executionDate = executionDate;
    return this;
  }

  public CurTransferDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public CurTransferDtoBuilder setMessageFromBank(String messageFromBank) {
    this.messageFromBank = messageFromBank;
    return this;
  }

  public CurTransferDtoBuilder setCustomerName(String customerName) {
    this.customerName = customerName;
    return this;
  }

  public CurTransferDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public CurTransferDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public CurTransferDtoBuilder setDebit(MoneyAmountDto debit) {
    this.debit = debit;
    return this;
  }

  public CurTransferDtoBuilder setValueDate(LocalDate valueDate) {
    this.valueDate = valueDate;
    return this;
  }

  public CurTransferDtoBuilder setUrgency(String urgency) {
    this.urgency = urgency;
    return this;
  }

  public CurTransferDtoBuilder setTransfer(MoneyAmountDto transfer) {
    this.transfer = transfer;
    return this;
  }

  public CurTransferDtoBuilder setRateType(String rateType) {
    this.rateType = rateType;
    return this;
  }

  public CurTransferDtoBuilder setRate(Integer rate) {
    this.rate = rate;
    return this;
  }

  public CurTransferDtoBuilder setPayer(CurTrPayerDto payer) {
    this.payer = payer;
    return this;
  }

  public CurTransferDtoBuilder setPayerBank(CurTrPayerBankDto payerBank) {
    this.payerBank = payerBank;
    return this;
  }

  public CurTransferDtoBuilder setBeneficiary(CurTrBeneficiaryDto beneficiary) {
    this.beneficiary = beneficiary;
    return this;
  }

  public CurTransferDtoBuilder setBeneficiaryBank(CurTrBeneficiaryBankDto beneficiaryBank) {
    this.beneficiaryBank = beneficiaryBank;
    return this;
  }

  public CurTransferDtoBuilder setIntermediaryBank(CurTrIntermediaryBankDto intermediaryBank) {
    this.intermediaryBank = intermediaryBank;
    return this;
  }

  public CurTransferDtoBuilder setPaymentInformation(String paymentInformation) {
    this.paymentInformation = paymentInformation;
    return this;
  }

  public CurTransferDtoBuilder setChargeType(CurTrChargeType chargeType) {
    this.chargeType = chargeType;
    return this;
  }

  public CurTransferDtoBuilder setChargeAccount(String chargeAccount) {
    this.chargeAccount = chargeAccount;
    return this;
  }

  public CurTransferDtoBuilder setChargeBic(String chargeBic) {
    this.chargeBic = chargeBic;
    return this;
  }

  public CurTransferDtoBuilder setPaymentAddInformation(String paymentAddInformation) {
    this.paymentAddInformation = paymentAddInformation;
    return this;
  }

  public CurTransferDtoBuilder setContactName(String contactName) {
    this.contactName = contactName;
    return this;
  }

  public CurTransferDtoBuilder setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
    return this;
  }

  public CurTransferDtoBuilder setRegulationInfos(List<CurRegulationInfoDto> regulationInfos) {
    this.regulationInfos = regulationInfos;
    return this;
  }

  public CurTransferDtoBuilder setIsReceived(Boolean isReceived) {
    this.isReceived = isReceived;
    return this;
  }

  public CurTransferDtoBuilder setIsExecuted(Boolean isExecuted) {
    this.isExecuted = isExecuted;
    return this;
  }

  public CurTransferDtoBuilder setIsDeclined(Boolean isDeclined) {
    this.isDeclined = isDeclined;
    return this;
  }

  public CurTransferDtoBuilder setIsNotReceived(Boolean isNotReceived) {
    this.isNotReceived = isNotReceived;
    return this;
  }

  public CurTransferDtoBuilder setIsRecalled(Boolean isRecalled) {
    this.isRecalled = isRecalled;
    return this;
  }

  public CurTransferDto create() {
    return new CurTransferDto(id, version, documentNumber, documentDate, customerId, status, createdAt, modifiedAt, receiveDate, executionDate, isFavorites, messageFromBank, customerName, branchId, branchName, debit, valueDate, urgency, transfer, rateType, rate, payer, payerBank, beneficiary, beneficiaryBank, intermediaryBank, paymentInformation, chargeType, chargeAccount, chargeBic, paymentAddInformation, contactName, contactPhone, regulationInfos, isReceived, isExecuted, isDeclined, isNotReceived, isRecalled);
  }

  public static CurTransferDtoBuilder builder() {
    return new CurTransferDtoBuilder();
  }
}
