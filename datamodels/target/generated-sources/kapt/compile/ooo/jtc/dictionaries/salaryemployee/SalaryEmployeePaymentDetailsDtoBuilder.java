package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.util.UUID;

public final class SalaryEmployeePaymentDetailsDtoBuilder {
  private UUID id;

  private int version;

  private UUID employeeId;

  private String account;

  private String bic;

  private String corrAccount;

  private String bankName;

  private String bankPlace;

  public SalaryEmployeePaymentDetailsDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setEmployeeId(UUID employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public SalaryEmployeePaymentDetailsDtoBuilder setBankPlace(String bankPlace) {
    this.bankPlace = bankPlace;
    return this;
  }

  public SalaryEmployeePaymentDetailsDto create() {
    return new SalaryEmployeePaymentDetailsDto(id, version, employeeId, account, bic, corrAccount, bankName, bankPlace);
  }

  public static SalaryEmployeePaymentDetailsDtoBuilder builder() {
    return new SalaryEmployeePaymentDetailsDtoBuilder();
  }
}
