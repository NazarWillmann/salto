package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class SalaryEmployeePaymentDetailsBuilder {
  private UUID id;

  private int version;

  private UUID employeeId;

  private UUID customerId;

  private String account;

  private String bic;

  private String corrAccount;

  private String bankName;

  private String bankPlace;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public SalaryEmployeePaymentDetailsBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setEmployeeId(UUID employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setBankPlace(String bankPlace) {
    this.bankPlace = bankPlace;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public SalaryEmployeePaymentDetailsBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public SalaryEmployeePaymentDetails create() {
    return new SalaryEmployeePaymentDetails(id, version, employeeId, customerId, account, bic, corrAccount, bankName, bankPlace, createdAt, deletedAt);
  }

  public static SalaryEmployeePaymentDetailsBuilder builder() {
    return new SalaryEmployeePaymentDetailsBuilder();
  }
}
