package ooo.jtc.dictionaries.salaryemployee;

import java.lang.String;
import java.time.LocalDate;

public final class SalaryEmployeeIdentityDocumentDtoBuilder {
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

  public SalaryEmployeeIdentityDocumentDtoBuilder setDocTypeCode(String docTypeCode) {
    this.docTypeCode = docTypeCode;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setDocType(String docType) {
    this.docType = docType;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setDocTypeName(String docTypeName) {
    this.docTypeName = docTypeName;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setSeries(String series) {
    this.series = series;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setIssuingDate(LocalDate issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDtoBuilder setEndDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public SalaryEmployeeIdentityDocumentDto create() {
    return new SalaryEmployeeIdentityDocumentDto(docTypeCode, docType, docTypeName, series, number, issuingAuthority, issuingDate, departmentCode, countryDigitCode, endDate);
  }

  public static SalaryEmployeeIdentityDocumentDtoBuilder builder() {
    return new SalaryEmployeeIdentityDocumentDtoBuilder();
  }
}
