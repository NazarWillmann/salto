package ooo.jtc.dictionaries.branch.paymentdetails;

import java.lang.String;

public final class PaymentDetailsSwiftBuilder {
  private String swift;

  private String bankName;

  private String countryDigitCode;

  private String bankCity;

  private String bankAddress;

  public PaymentDetailsSwiftBuilder setSwift(String swift) {
    this.swift = swift;
    return this;
  }

  public PaymentDetailsSwiftBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public PaymentDetailsSwiftBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public PaymentDetailsSwiftBuilder setBankCity(String bankCity) {
    this.bankCity = bankCity;
    return this;
  }

  public PaymentDetailsSwiftBuilder setBankAddress(String bankAddress) {
    this.bankAddress = bankAddress;
    return this;
  }

  public PaymentDetailsSwift create() {
    return new PaymentDetailsSwift(swift, bankName, countryDigitCode, bankCity, bankAddress);
  }

  public static PaymentDetailsSwiftBuilder builder() {
    return new PaymentDetailsSwiftBuilder();
  }
}
