package ooo.jtc.dictionaries.salarypaymenttype;

import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class SalaryPaymentTypeBuilder {
  private UUID id;

  private int version;

  private String code;

  private String name;

  private Integer incomeTypeCode;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public SalaryPaymentTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryPaymentTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryPaymentTypeBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public SalaryPaymentTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public SalaryPaymentTypeBuilder setIncomeTypeCode(Integer incomeTypeCode) {
    this.incomeTypeCode = incomeTypeCode;
    return this;
  }

  public SalaryPaymentTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public SalaryPaymentTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public SalaryPaymentType create() {
    return new SalaryPaymentType(id, version, code, name, incomeTypeCode, createdAt, deletedAt);
  }

  public static SalaryPaymentTypeBuilder builder() {
    return new SalaryPaymentTypeBuilder();
  }
}
