package ooo.jtc.dictionaries.branch.paymentdetails;

import java.lang.String;

public final class PaymentDetailsBicBuilder {
  private String bic;

  private String corrAccount;

  private String bankName;

  private String bankPlace;

  public PaymentDetailsBicBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public PaymentDetailsBicBuilder setCorrAccount(String corrAccount) {
    this.corrAccount = corrAccount;
    return this;
  }

  public PaymentDetailsBicBuilder setBankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

  public PaymentDetailsBicBuilder setBankPlace(String bankPlace) {
    this.bankPlace = bankPlace;
    return this;
  }

  public PaymentDetailsBic create() {
    return new PaymentDetailsBic(bic, corrAccount, bankName, bankPlace);
  }

  public static PaymentDetailsBicBuilder builder() {
    return new PaymentDetailsBicBuilder();
  }
}
