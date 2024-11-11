package ooo.jtc.rupayment.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.UUID;
import ooo.jtc.rupayment.model.BudgetType;
import ooo.jtc.rupayment.model.UserPaymentType;

public final class RuPaymentDtoBuilder {
  private UUID id;

  private int version;

  private String documentNumber;

  private LocalDate documentDate;

  private UUID customerId;

  private String status;

  private UUID branchId;

  private PayerDto payer;

  private ReceiverDto receiver;

  private BudgetDto budget;

  private PaymentGroundDto paymentGround;

  private BigDecimal amount;

  private String operationType;

  private String priority;

  private String uinUip;

  private UserPaymentType userPaymentType;

  private String channel;

  private Integer incomeTypeCode;

  private BigDecimal amountRecovery;

  private String transferTermCode;

  private String transferTermDescription;

  private Boolean isFavorites;

  private Boolean isReceived;

  private Boolean isExecuted;

  private Boolean isDeclined;

  private ZonedDateTime createdAt;

  private BudgetType budgetType;

  public RuPaymentDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RuPaymentDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public RuPaymentDtoBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public RuPaymentDtoBuilder setDocumentDate(LocalDate documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public RuPaymentDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public RuPaymentDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public RuPaymentDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public RuPaymentDtoBuilder setPayer(PayerDto payer) {
    this.payer = payer;
    return this;
  }

  public RuPaymentDtoBuilder setReceiver(ReceiverDto receiver) {
    this.receiver = receiver;
    return this;
  }

  public RuPaymentDtoBuilder setBudget(BudgetDto budget) {
    this.budget = budget;
    return this;
  }

  public RuPaymentDtoBuilder setPaymentGround(PaymentGroundDto paymentGround) {
    this.paymentGround = paymentGround;
    return this;
  }

  public RuPaymentDtoBuilder setAmount(BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  public RuPaymentDtoBuilder setOperationType(String operationType) {
    this.operationType = operationType;
    return this;
  }

  public RuPaymentDtoBuilder setPriority(String priority) {
    this.priority = priority;
    return this;
  }

  public RuPaymentDtoBuilder setUinUip(String uinUip) {
    this.uinUip = uinUip;
    return this;
  }

  public RuPaymentDtoBuilder setUserPaymentType(UserPaymentType userPaymentType) {
    this.userPaymentType = userPaymentType;
    return this;
  }

  public RuPaymentDtoBuilder setChannel(String channel) {
    this.channel = channel;
    return this;
  }

  public RuPaymentDtoBuilder setIncomeTypeCode(Integer incomeTypeCode) {
    this.incomeTypeCode = incomeTypeCode;
    return this;
  }

  public RuPaymentDtoBuilder setAmountRecovery(BigDecimal amountRecovery) {
    this.amountRecovery = amountRecovery;
    return this;
  }

  public RuPaymentDtoBuilder setTransferTermCode(String transferTermCode) {
    this.transferTermCode = transferTermCode;
    return this;
  }

  public RuPaymentDtoBuilder setTransferTermDescription(String transferTermDescription) {
    this.transferTermDescription = transferTermDescription;
    return this;
  }

  public RuPaymentDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public RuPaymentDtoBuilder setIsReceived(Boolean isReceived) {
    this.isReceived = isReceived;
    return this;
  }

  public RuPaymentDtoBuilder setIsExecuted(Boolean isExecuted) {
    this.isExecuted = isExecuted;
    return this;
  }

  public RuPaymentDtoBuilder setIsDeclined(Boolean isDeclined) {
    this.isDeclined = isDeclined;
    return this;
  }

  public RuPaymentDtoBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public RuPaymentDtoBuilder setBudgetType(BudgetType budgetType) {
    this.budgetType = budgetType;
    return this;
  }

  public RuPaymentDto create() {
    return new RuPaymentDto(id, version, documentNumber, documentDate, customerId, status, branchId, payer, receiver, budget, paymentGround, amount, operationType, priority, uinUip, userPaymentType, channel, incomeTypeCode, amountRecovery, transferTermCode, transferTermDescription, isFavorites, isReceived, isExecuted, isDeclined, createdAt, budgetType);
  }

  public static RuPaymentDtoBuilder builder() {
    return new RuPaymentDtoBuilder();
  }
}
