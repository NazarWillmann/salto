package ooo.jtc.dictionaries.salarypaymenttype;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class SalaryPaymentTypeDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String name;

  private Integer incomeTypeCode;

  public SalaryPaymentTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SalaryPaymentTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SalaryPaymentTypeDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public SalaryPaymentTypeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public SalaryPaymentTypeDtoBuilder setIncomeTypeCode(Integer incomeTypeCode) {
    this.incomeTypeCode = incomeTypeCode;
    return this;
  }

  public SalaryPaymentTypeDto create() {
    return new SalaryPaymentTypeDto(id, version, code, name, incomeTypeCode);
  }

  public static SalaryPaymentTypeDtoBuilder builder() {
    return new SalaryPaymentTypeDtoBuilder();
  }
}
