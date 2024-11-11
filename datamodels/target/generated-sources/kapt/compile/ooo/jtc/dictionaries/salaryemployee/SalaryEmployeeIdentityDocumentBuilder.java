package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.time.LocalDate;

public final class SalaryEmployeeIdentityDocumentBuilder {
  private String docTypeCode;

  private String docType;

  private String docTypeName;

  private String series;

  private String number;

  private String issuingAuthority;

  private LocalDate issuingDate;

  private String departmentCode;

  private String countryDigitCode;

  private LocalDate endDate;

  public SalaryEmployeeIdentityDocumentBuilder setDocTypeCode(String docTypeCode) {
    this.docTypeCode = docTypeCode;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setDocTypeName(String docTypeName) {
    this.docTypeName = docTypeName;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setSeries(String series) {
    this.series = series;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setIssuingDate(LocalDate issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public SalaryEmployeeIdentityDocumentBuilder setEndDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public SalaryEmployeeIdentityDocument create() {
    return new SalaryEmployeeIdentityDocument(docTypeCode, docType, docTypeName, series, number, issuingAuthority, issuingDate, departmentCode, countryDigitCode, endDate);
  }

  public static SalaryEmployeeIdentityDocumentBuilder builder() {
    return new SalaryEmployeeIdentityDocumentBuilder();
  }
}
