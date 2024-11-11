package ooo.jtc.rupayment.model;

import java.lang.Integer;
import java.lang.String;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public final class RuPaymentBuilder {
  private UUID id;

  private UUID id_Customer;

  private UUID id_Branch;

  private String document_Number;

  private String document_Number_Sort;

  private LocalDate receive_Date;

  private LocalDate document_Date;

  private String client_Status;

  private String bank_Status;

  private String channel;

  private Timestamp created_At;

  private Timestamp deleted_At;

  private Timestamp modified_At;

  private long version;

  private String status;

  private long scheme_Version;

  private String cpm;

  private LocalDate debit_Date;

  private LocalDate expected_Execution_Date;

  private String sign_Check_Message;

  private String execution_Message;

  private UUID id_Execution_User;

  private LocalDate execution_Date;

  private String receive_Message;

  private UUID id_Receiver_User;

  private String customer_Name;

  private String branch_Name;

  private String payment_Type;

  private String payment_Type_Code;

  private String amount;

  private String uin_Uip;

  private String operation_Type;

  private String payment_Priority;

  private String ground_Operation_Code;

  private String ground_Description;

  private long ground_Nds_Calculation;

  private String ground_Nds_Percent;

  private String ground_Nds;

  private String commission;

  private String commission_Type;

  private String note_From_Receiver;

  private long payment_Code;

  private Integer income_Type_Code;

  private String user_Payment_Type;

  private String payer_Name;

  private String payer_Account;

  private String payer_Inn;

  private String payer_Kpp;

  private String payer_Bank_Name;

  private String payer_Bank_Address;

  private String payer_Bank_Bic;

  private String payer_Bank_Corr_Account;

  private String receiver_Name;

  private String receiver_Account;

  private String receiver_Inn;

  private String receiver_Kpp;

  private String receiver_Bank_Name;

  private String receiver_Bank_Address;

  private String receiver_Bank_Bic;

  private String receiver_Bank_Corr_Account;

  private String budget_Type;

  private String budget_Payer_Status;

  private String budget_Kbk;

  private String budget_Oktmo;

  private String budget_Reason_Code;

  private String budget_Field_107;

  private String budget_Reason_Date;

  private String budget_Reason_Number;

  private String budget_Customs_Code;

  private BigDecimal amount_Recovery;

  private String transfer_Term_Code;

  private String transfer_Term_Description;

  private UUID id_Import;

  public RuPaymentBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public RuPaymentBuilder setId_Customer(UUID id_Customer) {
    this.id_Customer = id_Customer;
    return this;
  }

  public RuPaymentBuilder setId_Branch(UUID id_Branch) {
    this.id_Branch = id_Branch;
    return this;
  }

  public RuPaymentBuilder setDocument_Number(String document_Number) {
    this.document_Number = document_Number;
    return this;
  }

  public RuPaymentBuilder setDocument_Number_Sort(String document_Number_Sort) {
    this.document_Number_Sort = document_Number_Sort;
    return this;
  }

  public RuPaymentBuilder setReceive_Date(LocalDate receive_Date) {
    this.receive_Date = receive_Date;
    return this;
  }

  public RuPaymentBuilder setDocument_Date(LocalDate document_Date) {
    this.document_Date = document_Date;
    return this;
  }

  public RuPaymentBuilder setClient_Status(String client_Status) {
    this.client_Status = client_Status;
    return this;
  }

  public RuPaymentBuilder setBank_Status(String bank_Status) {
    this.bank_Status = bank_Status;
    return this;
  }

  public RuPaymentBuilder setChannel(String channel) {
    this.channel = channel;
    return this;
  }

  public RuPaymentBuilder setCreated_At(Timestamp created_At) {
    this.created_At = created_At;
    return this;
  }

  public RuPaymentBuilder setDeleted_At(Timestamp deleted_At) {
    this.deleted_At = deleted_At;
    return this;
  }

  public RuPaymentBuilder setModified_At(Timestamp modified_At) {
    this.modified_At = modified_At;
    return this;
  }

  public RuPaymentBuilder setVersion(long version) {
    this.version = version;
    return this;
  }

  public RuPaymentBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public RuPaymentBuilder setScheme_Version(long scheme_Version) {
    this.scheme_Version = scheme_Version;
    return this;
  }

  public RuPaymentBuilder setCpm(String cpm) {
    this.cpm = cpm;
    return this;
  }

  public RuPaymentBuilder setDebit_Date(LocalDate debit_Date) {
    this.debit_Date = debit_Date;
    return this;
  }

  public RuPaymentBuilder setExpected_Execution_Date(LocalDate expected_Execution_Date) {
    this.expected_Execution_Date = expected_Execution_Date;
    return this;
  }

  public RuPaymentBuilder setSign_Check_Message(String sign_Check_Message) {
    this.sign_Check_Message = sign_Check_Message;
    return this;
  }

  public RuPaymentBuilder setExecution_Message(String execution_Message) {
    this.execution_Message = execution_Message;
    return this;
  }

  public RuPaymentBuilder setId_Execution_User(UUID id_Execution_User) {
    this.id_Execution_User = id_Execution_User;
    return this;
  }

  public RuPaymentBuilder setExecution_Date(LocalDate execution_Date) {
    this.execution_Date = execution_Date;
    return this;
  }

  public RuPaymentBuilder setReceive_Message(String receive_Message) {
    this.receive_Message = receive_Message;
    return this;
  }

  public RuPaymentBuilder setId_Receiver_User(UUID id_Receiver_User) {
    this.id_Receiver_User = id_Receiver_User;
    return this;
  }

  public RuPaymentBuilder setCustomer_Name(String customer_Name) {
    this.customer_Name = customer_Name;
    return this;
  }

  public RuPaymentBuilder setBranch_Name(String branch_Name) {
    this.branch_Name = branch_Name;
    return this;
  }

  public RuPaymentBuilder setPayment_Type(String payment_Type) {
    this.payment_Type = payment_Type;
    return this;
  }

  public RuPaymentBuilder setPayment_Type_Code(String payment_Type_Code) {
    this.payment_Type_Code = payment_Type_Code;
    return this;
  }

  public RuPaymentBuilder setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public RuPaymentBuilder setUin_Uip(String uin_Uip) {
    this.uin_Uip = uin_Uip;
    return this;
  }

  public RuPaymentBuilder setOperation_Type(String operation_Type) {
    this.operation_Type = operation_Type;
    return this;
  }

  public RuPaymentBuilder setPayment_Priority(String payment_Priority) {
    this.payment_Priority = payment_Priority;
    return this;
  }

  public RuPaymentBuilder setGround_Operation_Code(String ground_Operation_Code) {
    this.ground_Operation_Code = ground_Operation_Code;
    return this;
  }

  public RuPaymentBuilder setGround_Description(String ground_Description) {
    this.ground_Description = ground_Description;
    return this;
  }

  public RuPaymentBuilder setGround_Nds_Calculation(long ground_Nds_Calculation) {
    this.ground_Nds_Calculation = ground_Nds_Calculation;
    return this;
  }

  public RuPaymentBuilder setGround_Nds_Percent(String ground_Nds_Percent) {
    this.ground_Nds_Percent = ground_Nds_Percent;
    return this;
  }

  public RuPaymentBuilder setGround_Nds(String ground_Nds) {
    this.ground_Nds = ground_Nds;
    return this;
  }

  public RuPaymentBuilder setCommission(String commission) {
    this.commission = commission;
    return this;
  }

  public RuPaymentBuilder setCommission_Type(String commission_Type) {
    this.commission_Type = commission_Type;
    return this;
  }

  public RuPaymentBuilder setNote_From_Receiver(String note_From_Receiver) {
    this.note_From_Receiver = note_From_Receiver;
    return this;
  }

  public RuPaymentBuilder setPayment_Code(long payment_Code) {
    this.payment_Code = payment_Code;
    return this;
  }

  public RuPaymentBuilder setIncome_Type_Code(Integer income_Type_Code) {
    this.income_Type_Code = income_Type_Code;
    return this;
  }

  public RuPaymentBuilder setUser_Payment_Type(String user_Payment_Type) {
    this.user_Payment_Type = user_Payment_Type;
    return this;
  }

  public RuPaymentBuilder setPayer_Name(String payer_Name) {
    this.payer_Name = payer_Name;
    return this;
  }

  public RuPaymentBuilder setPayer_Account(String payer_Account) {
    this.payer_Account = payer_Account;
    return this;
  }

  public RuPaymentBuilder setPayer_Inn(String payer_Inn) {
    this.payer_Inn = payer_Inn;
    return this;
  }

  public RuPaymentBuilder setPayer_Kpp(String payer_Kpp) {
    this.payer_Kpp = payer_Kpp;
    return this;
  }

  public RuPaymentBuilder setPayer_Bank_Name(String payer_Bank_Name) {
    this.payer_Bank_Name = payer_Bank_Name;
    return this;
  }

  public RuPaymentBuilder setPayer_Bank_Address(String payer_Bank_Address) {
    this.payer_Bank_Address = payer_Bank_Address;
    return this;
  }

  public RuPaymentBuilder setPayer_Bank_Bic(String payer_Bank_Bic) {
    this.payer_Bank_Bic = payer_Bank_Bic;
    return this;
  }

  public RuPaymentBuilder setPayer_Bank_Corr_Account(String payer_Bank_Corr_Account) {
    this.payer_Bank_Corr_Account = payer_Bank_Corr_Account;
    return this;
  }

  public RuPaymentBuilder setReceiver_Name(String receiver_Name) {
    this.receiver_Name = receiver_Name;
    return this;
  }

  public RuPaymentBuilder setReceiver_Account(String receiver_Account) {
    this.receiver_Account = receiver_Account;
    return this;
  }

  public RuPaymentBuilder setReceiver_Inn(String receiver_Inn) {
    this.receiver_Inn = receiver_Inn;
    return this;
  }

  public RuPaymentBuilder setReceiver_Kpp(String receiver_Kpp) {
    this.receiver_Kpp = receiver_Kpp;
    return this;
  }

  public RuPaymentBuilder setReceiver_Bank_Name(String receiver_Bank_Name) {
    this.receiver_Bank_Name = receiver_Bank_Name;
    return this;
  }

  public RuPaymentBuilder setReceiver_Bank_Address(String receiver_Bank_Address) {
    this.receiver_Bank_Address = receiver_Bank_Address;
    return this;
  }

  public RuPaymentBuilder setReceiver_Bank_Bic(String receiver_Bank_Bic) {
    this.receiver_Bank_Bic = receiver_Bank_Bic;
    return this;
  }

  public RuPaymentBuilder setReceiver_Bank_Corr_Account(String receiver_Bank_Corr_Account) {
    this.receiver_Bank_Corr_Account = receiver_Bank_Corr_Account;
    return this;
  }

  public RuPaymentBuilder setBudget_Type(String budget_Type) {
    this.budget_Type = budget_Type;
    return this;
  }

  public RuPaymentBuilder setBudget_Payer_Status(String budget_Payer_Status) {
    this.budget_Payer_Status = budget_Payer_Status;
    return this;
  }

  public RuPaymentBuilder setBudget_Kbk(String budget_Kbk) {
    this.budget_Kbk = budget_Kbk;
    return this;
  }

  public RuPaymentBuilder setBudget_Oktmo(String budget_Oktmo) {
    this.budget_Oktmo = budget_Oktmo;
    return this;
  }

  public RuPaymentBuilder setBudget_Reason_Code(String budget_Reason_Code) {
    this.budget_Reason_Code = budget_Reason_Code;
    return this;
  }

  public RuPaymentBuilder setBudget_Field_107(String budget_Field_107) {
    this.budget_Field_107 = budget_Field_107;
    return this;
  }

  public RuPaymentBuilder setBudget_Reason_Date(String budget_Reason_Date) {
    this.budget_Reason_Date = budget_Reason_Date;
    return this;
  }

  public RuPaymentBuilder setBudget_Reason_Number(String budget_Reason_Number) {
    this.budget_Reason_Number = budget_Reason_Number;
    return this;
  }

  public RuPaymentBuilder setBudget_Customs_Code(String budget_Customs_Code) {
    this.budget_Customs_Code = budget_Customs_Code;
    return this;
  }

  public RuPaymentBuilder setAmount_Recovery(BigDecimal amount_Recovery) {
    this.amount_Recovery = amount_Recovery;
    return this;
  }

  public RuPaymentBuilder setTransfer_Term_Code(String transfer_Term_Code) {
    this.transfer_Term_Code = transfer_Term_Code;
    return this;
  }

  public RuPaymentBuilder setTransfer_Term_Description(String transfer_Term_Description) {
    this.transfer_Term_Description = transfer_Term_Description;
    return this;
  }

  public RuPaymentBuilder setId_Import(UUID id_Import) {
    this.id_Import = id_Import;
    return this;
  }

  public RuPayment create() {
    return new RuPayment(id, id_Customer, id_Branch, document_Number, document_Number_Sort, receive_Date, document_Date, client_Status, bank_Status, channel, created_At, deleted_At, modified_At, version, status, scheme_Version, cpm, debit_Date, expected_Execution_Date, sign_Check_Message, execution_Message, id_Execution_User, execution_Date, receive_Message, id_Receiver_User, customer_Name, branch_Name, payment_Type, payment_Type_Code, amount, uin_Uip, operation_Type, payment_Priority, ground_Operation_Code, ground_Description, ground_Nds_Calculation, ground_Nds_Percent, ground_Nds, commission, commission_Type, note_From_Receiver, payment_Code, income_Type_Code, user_Payment_Type, payer_Name, payer_Account, payer_Inn, payer_Kpp, payer_Bank_Name, payer_Bank_Address, payer_Bank_Bic, payer_Bank_Corr_Account, receiver_Name, receiver_Account, receiver_Inn, receiver_Kpp, receiver_Bank_Name, receiver_Bank_Address, receiver_Bank_Bic, receiver_Bank_Corr_Account, budget_Type, budget_Payer_Status, budget_Kbk, budget_Oktmo, budget_Reason_Code, budget_Field_107, budget_Reason_Date, budget_Reason_Number, budget_Customs_Code, amount_Recovery, transfer_Term_Code, transfer_Term_Description, id_Import);
  }

  public static RuPaymentBuilder builder() {
    return new RuPaymentBuilder();
  }
}
