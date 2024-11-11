package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.time.LocalDate;

public final class SalaryEmployeeResidencyPermitDocumentBuilder {
  private String docType;

  private String docTypeName;

  private String series;

  private String number;

  private LocalDate issuingDate;

  private String issuingAuthority;

  private String departmentCode;

  private LocalDate beginDate;

  private LocalDate endDate;

  public SalaryEmployeeResidencyPermitDocumentBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setDocTypeName(String docTypeName) {
    this.docTypeName = docTypeName;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setSeries(String series) {
    this.series = series;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setIssuingDate(LocalDate issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setBeginDate(LocalDate beginDate) {
    this.beginDate = beginDate;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocumentBuilder setEndDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public SalaryEmployeeResidencyPermitDocument create() {
    return new SalaryEmployeeResidencyPermitDocument(docType, docTypeName, series, number, issuingDate, issuingAuthority, departmentCode, beginDate, endDate);
  }

  public static SalaryEmployeeResidencyPermitDocumentBuilder builder() {
    return new SalaryEmployeeResidencyPermitDocumentBuilder();
  }
}
