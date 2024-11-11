package ooo.jtc.dictionaries.common.address;

import java.lang.String;

public final class ForeignAddressDtoBuilder {
  private String countryDigitCode;

  private String index;

  private String state;

  private String city;

  private String address;

  public ForeignAddressDtoBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public ForeignAddressDtoBuilder setIndex(String index) {
    this.index = index;
    return this;
  }

  public ForeignAddressDtoBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public ForeignAddressDtoBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public ForeignAddressDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public ForeignAddressDto create() {
    return new ForeignAddressDto(countryDigitCode, index, state, city, address);
  }

  public static ForeignAddressDtoBuilder builder() {
    return new ForeignAddressDtoBuilder();
  }
}
