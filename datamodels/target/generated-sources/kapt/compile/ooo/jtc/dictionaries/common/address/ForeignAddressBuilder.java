package ooo.jtc.dictionaries.common.address;

import java.lang.String;

public final class ForeignAddressBuilder {
  private String countryDigitCode;

  private String index;

  private String state;

  private String city;

  private String address;

  public ForeignAddressBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public ForeignAddressBuilder setIndex(String index) {
    this.index = index;
    return this;
  }

  public ForeignAddressBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public ForeignAddressBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public ForeignAddressBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public ForeignAddress create() {
    return new ForeignAddress(countryDigitCode, index, state, city, address);
  }

  public static ForeignAddressBuilder builder() {
    return new ForeignAddressBuilder();
  }
}
