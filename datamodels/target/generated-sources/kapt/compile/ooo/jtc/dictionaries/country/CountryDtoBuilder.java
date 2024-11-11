package ooo.jtc.dictionaries.country;

import java.lang.String;
import java.util.UUID;

public final class CountryDtoBuilder {
  private UUID id;

  private int version;

  private String digitCode;

  private String shortName;

  private String fullName;

  private String intNameIso;

  private String alpha2Code;

  private String alpha3Code;

  public CountryDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CountryDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CountryDtoBuilder setDigitCode(String digitCode) {
    this.digitCode = digitCode;
    return this;
  }

  public CountryDtoBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public CountryDtoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public CountryDtoBuilder setIntNameIso(String intNameIso) {
    this.intNameIso = intNameIso;
    return this;
  }

  public CountryDtoBuilder setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
    return this;
  }

  public CountryDtoBuilder setAlpha3Code(String alpha3Code) {
    this.alpha3Code = alpha3Code;
    return this;
  }

  public CountryDto create() {
    return new CountryDto(id, version, digitCode, shortName, fullName, intNameIso, alpha2Code, alpha3Code);
  }

  public static CountryDtoBuilder builder() {
    return new CountryDtoBuilder();
  }
}
