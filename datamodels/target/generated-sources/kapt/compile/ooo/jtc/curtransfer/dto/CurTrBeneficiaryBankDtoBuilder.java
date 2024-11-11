package ooo.jtc.curtransfer.dto;

import java.lang.String;
import ooo.jtc.dictionaries.country.ReducedCountryDto;

public final class CurTrBeneficiaryBankDtoBuilder {
  private String name;

  private String account;

  private String swift;

  private ReducedCountryDto country;

  private String city;

  private String address;

  private String clearingCode;

  public CurTrBeneficiaryBankDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurTrBeneficiaryBankDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public CurTrBeneficiaryBankDtoBuilder setSwift(String swift) {
    this.swift = swift;
    return this;
  }

  public CurTrBeneficiaryBankDtoBuilder setCountry(ReducedCountryDto country) {
    this.country = country;
    return this;
  }

  public CurTrBeneficiaryBankDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public CurTrBeneficiaryBankDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public CurTrBeneficiaryBankDtoBuilder setClearingCode(String clearingCode) {
    this.clearingCode = clearingCode;
    return this;
  }

  public CurTrBeneficiaryBankDto create() {
    return new CurTrBeneficiaryBankDto(name, account, swift, country, city, address, clearingCode);
  }

  public static CurTrBeneficiaryBankDtoBuilder builder() {
    return new CurTrBeneficiaryBankDtoBuilder();
  }
}
