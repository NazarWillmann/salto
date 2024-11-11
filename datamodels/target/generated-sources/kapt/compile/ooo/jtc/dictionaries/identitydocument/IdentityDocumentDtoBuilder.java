package ooo.jtc.dictionaries.identitydocument;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;
import ooo.jtc.dictionaries.identitydocumenttype.IdentityDocumentTypeDto;

public final class IdentityDocumentDtoBuilder {
  private UUID id;

  private int version;

  private IdentityDocumentTypeDto docType;

  private String series;

  private String number;

  private LocalDate issuingDate;

  private String issuingAuthority;

  private String departmentCode;

  private String countryDigitCode;

  private String status;

  public IdentityDocumentDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IdentityDocumentDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IdentityDocumentDtoBuilder setDocType(IdentityDocumentTypeDto docType) {
    this.docType = docType;
    return this;
  }

  public IdentityDocumentDtoBuilder setSeries(String series) {
    this.series = series;
    return this;
  }

  public IdentityDocumentDtoBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public IdentityDocumentDtoBuilder setIssuingDate(LocalDate issuingDate) {
    this.issuingDate = issuingDate;
    return this;
  }

  public IdentityDocumentDtoBuilder setIssuingAuthority(String issuingAuthority) {
    this.issuingAuthority = issuingAuthority;
    return this;
  }

  public IdentityDocumentDtoBuilder setDepartmentCode(String departmentCode) {
    this.departmentCode = departmentCode;
    return this;
  }

  public IdentityDocumentDtoBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public IdentityDocumentDtoBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public IdentityDocumentDto create() {
    return new IdentityDocumentDto(id, version, docType, series, number, issuingDate, issuingAuthority, departmentCode, countryDigitCode, status);
  }

  public static IdentityDocumentDtoBuilder builder() {
    return new IdentityDocumentDtoBuilder();
  }
}
