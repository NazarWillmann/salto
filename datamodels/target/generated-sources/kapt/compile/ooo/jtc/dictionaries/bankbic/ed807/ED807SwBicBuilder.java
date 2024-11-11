package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;

public final class ED807SwBicBuilder {
  private String swBic;

  private String defaultSwBic;

  public ED807SwBicBuilder setSwBic(String swBic) {
    this.swBic = swBic;
    return this;
  }

  public ED807SwBicBuilder setDefaultSwBic(String defaultSwBic) {
    this.defaultSwBic = defaultSwBic;
    return this;
  }

  public ED807SwBic create() {
    return new ED807SwBic(swBic, defaultSwBic);
  }

  public static ED807SwBicBuilder builder() {
    return new ED807SwBicBuilder();
  }
}
