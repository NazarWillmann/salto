package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.time.LocalDate;

public final class SalaryEmployeeResidencyPermitDocumentDtoBuilder {
  private String docType;

  private String docTypeName;

  private String series;

  private String number;

  private LocalDate issuingDate;

  private String issuingAuthority;

  private String departmentCode;

  private LocalDate beginDate;

  private LocalDate endDate;

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setDocTypeName(String docTypeName) {
    this.docTypeName = docTypeName;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setSeries(String series) {
    this.series = series;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setIssuingDate(LocalDate issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setIssuingAuthority(
      String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setBeginDate(LocalDate beginDate) {
    this.beginDate = beginDate;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDtoBuilder setEndDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentDto create() {
    return new SalaryEmployeeResidencyPermitDocumentDto(docType, docTypeName, series, number, issuingDate, issuingAuthority, departmentCode, beginDate, endDate);
  }

  public static SalaryEmployeeResidencyPermitDocumentDtoBuilder builder() {
    return new SalaryEmployeeResidencyPermitDocumentDtoBuilder();
  }
}
