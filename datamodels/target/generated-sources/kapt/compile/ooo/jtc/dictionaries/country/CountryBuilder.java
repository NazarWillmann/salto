package ooo.jtc.dictionaries.country;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class CountryBuilder {
  private UUID id;

  private int version;

  private String digitCode;

  private String shortName;

  private String fullName;

  private String intNameIso;

  private String alpha2Code;

  private String alpha3Code;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public CountryBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CountryBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CountryBuilder setDigitCode(String digitCode) {
    this.digitCode = digitCode;
    return this;
  }

  public CountryBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public CountryBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public CountryBuilder setIntNameIso(String intNameIso) {
    this.intNameIso = intNameIso;
    return this;
  }

  public CountryBuilder setAlpha2Code(String alpha2Code) {
    this.alpha2Code = alpha2Code;
    return this;
  }

  public CountryBuilder setAlpha3Code(String alpha3Code) {
    this.alpha3Code = alpha3Code;
    return this;
  }

  public CountryBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CountryBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Country create() {
    return new Country(id, version, digitCode, shortName, fullName, intNameIso, alpha2Code, alpha3Code, createdAt, deletedAt);
  }

  public static CountryBuilder builder() {
    return new CountryBuilder();
  }
}
