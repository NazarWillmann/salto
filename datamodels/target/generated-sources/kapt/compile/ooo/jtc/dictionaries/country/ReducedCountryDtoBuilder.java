package ooo.jtc.dictionaries.country;

import java.lang.String;

public final class ReducedCountryDtoBuilder {
  private String digitCode;

  private String alpha2Code;

  private String intNameIso;

  public ReducedCountryDtoBuilder setDigitCode(String digitCode) {
    this.digitCode = digitCode;
    return this;
  }

  public ReducedCountryDtoBuilder setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
    return this;
  }

  public ReducedCountryDtoBuilder setIntNameIso(String intNameIso) {
    this.intNameIso = intNameIso;
    return this;
  }

  public ReducedCountryDto create() {
    return new ReducedCountryDto(digitCode, alpha2Code, intNameIso);
  }

  public static ReducedCountryDtoBuilder builder() {
    return new ReducedCountryDtoBuilder();
  }
}
