package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;
import java.time.LocalDate;

public final class ED807AccountRestrictionBuilder {
  private String accRstr;

  private LocalDate accRstrDate;

  public ED807AccountRestrictionBuilder setAccRstr(String accRstr) {
    this.accRstr = accRstr;
    return this;
  }

  public ED807AccountRestrictionBuilder setAccRstrDate(LocalDate accRstrDate) {
    this.accRstrDate = accRstrDate;
    return this;
  }

  public ED807AccountRestriction create() {
    return new ED807AccountRestriction(accRstr, accRstrDate);
  }

  public static ED807AccountRestrictionBuilder builder() {
    return new ED807AccountRestrictionBuilder();
  }
}
