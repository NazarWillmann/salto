package ooo.jtc.curtransfer.dto;

import java.lang.String;
import ooo.jtc.dictionaries.country.ReducedCountryDto;

public final class CurTrPayerDtoBuilder {
  private String name;

  private String account;

  private String inn;

  private ReducedCountryDto country;

  private String city;

  private String address;

  public CurTrPayerDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurTrPayerDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public CurTrPayerDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public CurTrPayerDtoBuilder setCountry(ReducedCountryDto country) {
    this.country = country;
    return this;
  }

  public CurTrPayerDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public CurTrPayerDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public CurTrPayerDto create() {
    return new CurTrPayerDto(name, account, inn, country, city, address);
  }

  public static CurTrPayerDtoBuilder builder() {
    return new CurTrPayerDtoBuilder();
  }
}
