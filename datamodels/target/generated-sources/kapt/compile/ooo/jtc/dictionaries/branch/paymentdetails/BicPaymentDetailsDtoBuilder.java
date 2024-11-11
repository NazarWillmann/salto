package ooo.jtc.dictionaries.branch.paymentdetails;

import java.lang.String;

public final class BicPaymentDetailsDtoBuilder {
  private String bic;

  private String corrAcc;

  private String bankNameBic;

  private String bankPlaceBic;

  public BicPaymentDetailsDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public BicPaymentDetailsDtoBuilder setCorrAcc(String corrAcc) {
    this.corrAcc = corrAcc;
    return this;
  }

  public BicPaymentDetailsDtoBuilder setBankNameBic(String bankNameBic) {
    this.bankNameBic = bankNameBic;
    return this;
  }

  public BicPaymentDetailsDtoBuilder setBankPlaceBic(String bankPlaceBic) {
    this.bankPlaceBic = bankPlaceBic;
    return this;
  }

  public BicPaymentDetailsDto create() {
    return new BicPaymentDetailsDto(bic, corrAcc, bankNameBic, bankPlaceBic);
  }

  public static BicPaymentDetailsDtoBuilder builder() {
    return new BicPaymentDetailsDtoBuilder();
  }
}
