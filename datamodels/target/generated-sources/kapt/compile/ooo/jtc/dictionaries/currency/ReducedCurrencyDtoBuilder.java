package ooo.jtc.dictionaries.currency;

import java.lang.String;

public final class ReducedCurrencyDtoBuilder {
  private String digitCode;

  private String alphaCode;

  public ReducedCurrencyDtoBuilder setDigitCode(String digitCode) {
    this.digitCode = digitCode;
    return this;
  }

  public ReducedCurrencyDtoBuilder setAlphaCode(String alphaCode) {
    this.alphaCode = alphaCode;
    return this;
  }

  public ReducedCurrencyDto create() {
    return new ReducedCurrencyDto(digitCode, alphaCode);
  }

  public static ReducedCurrencyDtoBuilder builder() {
    return new ReducedCurrencyDtoBuilder();
  }
}
