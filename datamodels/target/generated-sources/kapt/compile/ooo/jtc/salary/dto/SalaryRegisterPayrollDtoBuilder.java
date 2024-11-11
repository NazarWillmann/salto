package ooo.jtc.salary.dto;

import java.lang.String;
import java.util.UUID;

public final class SalaryRegisterPayrollDtoBuilder {
  private UUID id;

  private String lastName;

  private String firstName;

  private String middleName;

  private String inn;

  private String amount;

  private String account;

  private String bic;

  private String corrAccount;

  private String bankName;

  private String bankAddress;

  private String checkResult;

  private String comment;

  private String salaryRegisterId;

  private String employeeId;

  public SalaryRegisterPayrollDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setAmount(String amount) {
    this.amount = amount;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setBankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setCheckResult(String checkResult) {
    this.checkResult = checkResult;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setSalaryRegisterId(String salaryRegisterId) {
    this.salaryRegisterId = salaryRegisterId;
    return this;
  }

  public SalaryRegisterPayrollDtoBuilder setEmployeeId(String employeeId) {
    this.employeeId = employeeId;
    return this;
  }

  public SalaryRegisterPayrollDto create() {
    return new SalaryRegisterPayrollDto(id, lastName, firstName, middleName, inn, amount, account, bic, corrAccount, bankName, bankAddress, checkResult, comment, salaryRegisterId, employeeId);
  }

  public static SalaryRegisterPayrollDtoBuilder builder() {
    return new SalaryRegisterPayrollDtoBuilder();
  }
}
