package ooo.jtc.dictionaries.currency;

import java.lang.String;
import java.util.UUID;

public final class CurrencyDtoBuilder {
  private UUID id;

  private int version;

  private String digitCode;

  private String alphaCode;

  private String name;

  private String nameInOkv;

  private int minorUnitCount;

  public CurrencyDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CurrencyDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CurrencyDtoBuilder setDigitCode(String digitCode) {
    this.digitCode = digitCode;
    return this;
  }

  public CurrencyDtoBuilder setAlphaCode(String alphaCode) {
    this.alphaCode = alphaCode;
    return this;
  }

  public CurrencyDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CurrencyDtoBuilder setNameInOkv(String nameInOkv) {
    this.nameInOkv = nameInOkv;
    return this;
  }

  public CurrencyDtoBuilder setMinorUnitCount(int minorUnitCount) {
    this.minorUnitCount = minorUnitCount;
    return this;
  }

  public CurrencyDto create() {
    return new CurrencyDto(id, version, digitCode, alphaCode, name, nameInOkv, minorUnitCount);
  }

  public static CurrencyDtoBuilder builder() {
    return new CurrencyDtoBuilder();
  }
}
