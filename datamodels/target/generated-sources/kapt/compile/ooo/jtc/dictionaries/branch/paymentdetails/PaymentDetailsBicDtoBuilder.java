package ooo.jtc.dictionaries.branch.paymentdetails;

import java.lang.String;

public final class PaymentDetailsBicDtoBuilder {
  private String bic;

  private String corrAccount;

  private String bankName;

  private String bankPlace;

  public PaymentDetailsBicDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public PaymentDetailsBicDtoBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public PaymentDetailsBicDtoBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public PaymentDetailsBicDtoBuilder setBankPlace(String bankPlace) {
    this.bankPlace = bankPlace;
    return this;
  }

  public PaymentDetailsBicDto create() {
    return new PaymentDetailsBicDto(bic, corrAccount, bankName, bankPlace);
  }

  public static PaymentDetailsBicDtoBuilder builder() {
    return new PaymentDetailsBicDtoBuilder();
  }
}
