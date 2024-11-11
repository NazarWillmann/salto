package ooo.jtc.dictionaries.swift;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;

public final class SwiftDtoBuilder {
  private UUID id;

  private int version;

  private String swift;

  private SwiftInstType institutionType;

  private LocalDate dateActual;

  private String name;

  private String city;

  private String address1;

  private String address2;

  private String address3;

  private String address4;

  private String branchName;

  private String branchCity;

  private String branchAddress1;

  private String branchAddress2;

  private String branchAddress3;

  private String branchAddress4;

  private String countryAlpha2Code;

  private String recordStatus;

  public SwiftDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public SwiftDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public SwiftDtoBuilder setSwift(String swift) {
    this.swift = swift;
    return this;
  }

  public SwiftDtoBuilder setInstitutionType(SwiftInstType institutionType) {
    this.institutionType = institutionType;
    return this;
  }

  public SwiftDtoBuilder setDateActual(LocalDate dateActual) {
    this.dateActual = dateActual;
    return this;
  }

  public SwiftDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public SwiftDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public SwiftDtoBuilder setAddress1(String address1) {
    this.address1 = address1;
    return this;
  }

  public SwiftDtoBuilder setAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public SwiftDtoBuilder setAddress3(String address3) {
    this.address3 = address3;
    return this;
  }

  public SwiftDtoBuilder setAddress4(String address4) {
    this.address4 = address4;
    return this;
  }

  public SwiftDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public SwiftDtoBuilder setBranchCity(String branchCity) {
    this.branchCity = branchCity;
    return this;
  }

  public SwiftDtoBuilder setBranchAddress1(String branchAddress1) {
    this.branchAddress1 = branchAddress1;
    return this;
  }

  public SwiftDtoBuilder setBranchAddress2(String branchAddress2) {
    this.branchAddress2 = branchAddress2;
    return this;
  }

  public SwiftDtoBuilder setBranchAddress3(String branchAddress3) {
    this.branchAddress3 = branchAddress3;
    return this;
  }

  public SwiftDtoBuilder setBranchAddress4(String branchAddress4) {
    this.branchAddress4 = branchAddress4;
    return this;
  }

  public SwiftDtoBuilder setCountryAlpha2Code(String countryAlpha2Code) {
    this.countryAlpha2Code = countryAlpha2Code;
    return this;
  }

  public SwiftDtoBuilder setRecordStatus(String recordStatus) {
    this.recordStatus = recordStatus;
    return this;
  }

  public SwiftDto create() {
    return new SwiftDto(id, version, swift, institutionType, dateActual, name, city, address1, address2, address3, address4, branchName, branchCity, branchAddress1, branchAddress2, branchAddress3, branchAddress4, countryAlpha2Code, recordStatus);
  }

  public static SwiftDtoBuilder builder() {
    return new SwiftDtoBuilder();
  }
}
