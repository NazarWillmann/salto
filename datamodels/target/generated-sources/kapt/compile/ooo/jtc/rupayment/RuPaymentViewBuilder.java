package ooo.jtc.rupayment;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.rupayment.model.BudgetType;
import ooo.jtc.rupayment.model.UserPaymentType;

public final class RuPaymentViewBuilder {
  private UUID id;

  private UUID customerId;

  private String documentNumber;

  private String documentDate;

  private String statusSystem;

  private String statusClient;

  private String statusBank;

  private String receiverName;

  private String receiverInn;

  private String receiverKpp;

  private String receiverBankBic;

  private String receiverBankName;

  private String receiverBankCorrAccount;

  private String receiverBankMaskedCorrAccount;

  private String receiverAccount;

  private String receiverMaskedAccount;

  private String payerAccount;

  private String payerMaskedAccount;

  private String payerHiddenMaskedAccount;

  private String payerName;

  private String payerInn;

  private String payerKpp;

  private String amount;

  private String amountMasked;

  private String amountAntie;

  private String paymentGroundDescription;

  private String nds;

  private String priority;

  private UserPaymentType userPaymentType;

  private String budgetPayerStatus;

  private String budgetKbk;

  private String budgetOktmo;

  private String budgetReasonCode;

  private String budgetBudgetField107;

  private String budgetReasonDocumentNumber;

  private String budgetReasonDocumentDate;

  private BudgetType budgetType;

  public RuPaymentViewBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RuPaymentViewBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public RuPaymentViewBuilder setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
    return this;
  }

  public RuPaymentViewBuilder setDocumentDate(String documentDate) {
    this.documentDate = documentDate;
    return this;
  }

  public RuPaymentViewBuilder setStatusSystem(String statusSystem) {
    this.statusSystem = statusSystem;
    return this;
  }

  public RuPaymentViewBuilder setStatusClient(String statusClient) {
    this.statusClient = statusClient;
    return this;
  }

  public RuPaymentViewBuilder setStatusBank(String statusBank) {
    this.statusBank = statusBank;
    return this;
  }

  public RuPaymentViewBuilder setReceiverName(String receiverName) {
    this.receiverName = receiverName;
    return this;
  }

  public RuPaymentViewBuilder setReceiverInn(String receiverInn) {
    this.receiverInn = receiverInn;
    return this;
  }

  public RuPaymentViewBuilder setReceiverKpp(String receiverKpp) {
    this.receiverKpp = receiverKpp;
    return this;
  }

  public RuPaymentViewBuilder setReceiverBankBic(String receiverBankBic) {
    this.receiverBankBic = receiverBankBic;
    return this;
  }

  public RuPaymentViewBuilder setReceiverBankName(String receiverBankName) {
    this.receiverBankName = receiverBankName;
    return this;
  }

  public RuPaymentViewBuilder setReceiverBankCorrAccount(String receiverBankCorrAccount) {
    this.receiverBankCorrAccount = receiverBankCorrAccount;
    return this;
  }

  public RuPaymentViewBuilder setReceiverBankMaskedCorrAccount(
      String receiverBankMaskedCorrAccount) {
    this.receiverBankMaskedCorrAccount = receiverBankMaskedCorrAccount;
    return this;
  }

  public RuPaymentViewBuilder setReceiverAccount(String receiverAccount) {
    this.receiverAccount = receiverAccount;
    return this;
  }

  public RuPaymentViewBuilder setReceiverMaskedAccount(String receiverMaskedAccount) {
    this.receiverMaskedAccount = receiverMaskedAccount;
    return this;
  }

  public RuPaymentViewBuilder setPayerAccount(String payerAccount) {
    this.payerAccount = payerAccount;
    return this;
  }

  public RuPaymentViewBuilder setPayerMaskedAccount(String payerMaskedAccount) {
    this.payerMaskedAccount = payerMaskedAccount;
    return this;
  }

  public RuPaymentViewBuilder setPayerHiddenMaskedAccount(String payerHiddenMaskedAccount) {
    this.payerHiddenMaskedAccount = payerHiddenMaskedAccount;
    return this;
  }

  public RuPaymentViewBuilder setPayerName(String payerName) {
    this.payerName = payerName;
    return this;
  }

  public RuPaymentViewBuilder setPayerInn(String payerInn) {
    this.payerInn = payerInn;
    return this;
  }

  public RuPaymentViewBuilder setPayerKpp(String payerKpp) {
    this.payerKpp = payerKpp;
    return this;
  }

  public RuPaymentViewBuilder setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public RuPaymentViewBuilder setAmountMasked(String amountMasked) {
    this.amountMasked = amountMasked;
    return this;
  }

  public RuPaymentViewBuilder setAmountAntie(String amountAntie) {
    this.amountAntie = amountAntie;
    return this;
  }

  public RuPaymentViewBuilder setPaymentGroundDescription(String paymentGroundDescription) {
    this.paymentGroundDescription = paymentGroundDescription;
    return this;
  }

  public RuPaymentViewBuilder setNds(String nds) {
    this.nds = nds;
    return this;
  }

  public RuPaymentViewBuilder setPriority(String priority) {
    this.priority = priority;
    return this;
  }

  public RuPaymentViewBuilder setUserPaymentType(UserPaymentType userPaymentType) {
    this.userPaymentType = userPaymentType;
    return this;
  }

  public RuPaymentViewBuilder setBudgetPayerStatus(String budgetPayerStatus) {
    this.budgetPayerStatus = budgetPayerStatus;
    return this;
  }

  public RuPaymentViewBuilder setBudgetKbk(String budgetKbk) {
    this.budgetKbk = budgetKbk;
    return this;
  }

  public RuPaymentViewBuilder setBudgetOktmo(String budgetOktmo) {
    this.budgetOktmo = budgetOktmo;
    return this;
  }

  public RuPaymentViewBuilder setBudgetReasonCode(String budgetReasonCode) {
    this.budgetReasonCode = budgetReasonCode;
    return this;
  }

  public RuPaymentViewBuilder setBudgetBudgetField107(String budgetBudgetField107) {
    this.budgetBudgetField107 = budgetBudgetField107;
    return this;
  }

  public RuPaymentViewBuilder setBudgetReasonDocumentNumber(String budgetReasonDocumentNumber) {
    this.budgetReasonDocumentNumber = budgetReasonDocumentNumber;
    return this;
  }

  public RuPaymentViewBuilder setBudgetReasonDocumentDate(String budgetReasonDocumentDate) {
    this.budgetReasonDocumentDate = budgetReasonDocumentDate;
    return this;
  }

  public RuPaymentViewBuilder setBudgetType(BudgetType budgetType) {
    this.budgetType = budgetType;
    return this;
  }

  public RuPaymentView create() {
    return new RuPaymentView(id, customerId, documentNumber, documentDate, statusSystem, statusClient, statusBank, receiverName, receiverInn, receiverKpp, receiverBankBic, receiverBankName, receiverBankCorrAccount, receiverBankMaskedCorrAccount, receiverAccount, receiverMaskedAccount, payerAccount, payerMaskedAccount, payerHiddenMaskedAccount, payerName, payerInn, payerKpp, amount, amountMasked, amountAntie, paymentGroundDescription, nds, priority, userPaymentType, budgetPayerStatus, budgetKbk, budgetOktmo, budgetReasonCode, budgetBudgetField107, budgetReasonDocumentNumber, budgetReasonDocumentDate, budgetType);
  }

  public static RuPaymentViewBuilder builder() {
    return new RuPaymentViewBuilder();
  }
}
