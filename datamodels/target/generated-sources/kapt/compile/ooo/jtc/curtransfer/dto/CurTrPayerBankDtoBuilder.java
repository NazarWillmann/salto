package ooo.jtc.curtransfer.dto;

import java.lang.String;
import ooo.jtc.dictionaries.country.ReducedCountryDto;

public final class CurTrPayerBankDtoBuilder {
  private String name;

  private String swift;

  private ReducedCountryDto country;

  private String city;

  private String address;

  public CurTrPayerBankDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurTrPayerBankDtoBuilder setSwift(String swift) {
    this.swift = swift;
    return this;
  }

  public CurTrPayerBankDtoBuilder setCountry(ReducedCountryDto country) {
    this.country = country;
    return this;
  }

  public CurTrPayerBankDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public CurTrPayerBankDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public CurTrPayerBankDto create() {
    return new CurTrPayerBankDto(name, swift, country, city, address);
  }

  public static CurTrPayerBankDtoBuilder builder() {
    return new CurTrPayerBankDtoBuilder();
  }
}
