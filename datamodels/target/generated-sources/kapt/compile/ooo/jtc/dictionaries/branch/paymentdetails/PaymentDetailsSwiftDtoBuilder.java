package ooo.jtc.dictionaries.branch.paymentdetails;

import java.lang.String;

public final class PaymentDetailsSwiftDtoBuilder {
  private String swift;

  private String bankName;

  private String countryDigitCode;

  private String bankCity;

  private String bankAddress;

  public PaymentDetailsSwiftDtoBuilder setSwift(String swift) {
    this.swift = swift;
    return this;
  }

  public PaymentDetailsSwiftDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public PaymentDetailsSwiftDtoBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public PaymentDetailsSwiftDtoBuilder setBankCity(String bankCity) {
    this.bankCity = bankCity;
    return this;
  }

  public PaymentDetailsSwiftDtoBuilder setBankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
    return this;
  }

  public PaymentDetailsSwiftDto create() {
    return new PaymentDetailsSwiftDto(swift, bankName, countryDigitCode, bankCity, bankAddress);
  }

  public static PaymentDetailsSwiftDtoBuilder builder() {
    return new PaymentDetailsSwiftDtoBuilder();
  }
}
