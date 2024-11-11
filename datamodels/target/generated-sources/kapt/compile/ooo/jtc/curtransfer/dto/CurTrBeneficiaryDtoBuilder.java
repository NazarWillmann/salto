package ooo.jtc.curtransfer.dto;

import java.lang.String;
import ooo.jtc.dictionaries.country.ReducedCountryDto;

public final class CurTrBeneficiaryDtoBuilder {
  private String name;

  private String account;

  private ReducedCountryDto country;

  private String city;

  private String address;

  public CurTrBeneficiaryDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurTrBeneficiaryDtoBuilder setAccount(String account) {
    this.account = account;
    return this;
  }

  public CurTrBeneficiaryDtoBuilder setCountry(ReducedCountryDto country) {
    this.country = country;
    return this;
  }

  public CurTrBeneficiaryDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public CurTrBeneficiaryDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public CurTrBeneficiaryDto create() {
    return new CurTrBeneficiaryDto(name, account, country, city, address);
  }

  public static CurTrBeneficiaryDtoBuilder builder() {
    return new CurTrBeneficiaryDtoBuilder();
  }
}
