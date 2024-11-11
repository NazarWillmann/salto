package ooo.jtc.curtransfer.dto;

import java.lang.String;
import ooo.jtc.dictionaries.country.ReducedCountryDto;

public final class CurTrIntermediaryBankDtoBuilder {
  private String name;

  private String swift;

  private ReducedCountryDto country;

  private String city;

  private String address;

  private String clearingCode;

  public CurTrIntermediaryBankDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurTrIntermediaryBankDtoBuilder setSwift(String swift) {
    this.swift = swift;
    return this;
  }

  public CurTrIntermediaryBankDtoBuilder setCountry(ReducedCountryDto country) {
    this.country = country;
    return this;
  }

  public CurTrIntermediaryBankDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public CurTrIntermediaryBankDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public CurTrIntermediaryBankDtoBuilder setClearingCode(String clearingCode) {
    this.clearingCode = clearingCode;
    return this;
  }

  public CurTrIntermediaryBankDto create() {
    return new CurTrIntermediaryBankDto(name, swift, country, city, address, clearingCode);
  }

  public static CurTrIntermediaryBankDtoBuilder builder() {
    return new CurTrIntermediaryBankDtoBuilder();
  }
}
