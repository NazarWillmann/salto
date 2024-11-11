package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;
import java.time.LocalDate;

public final class ED807ParticipantRestrictionBuilder {
  private String rstr;

  private LocalDate rstrDate;

  public ED807ParticipantRestrictionBuilder setRstr(String rstr) {
    this.rstr = rstr;
    return this;
  }

  public ED807ParticipantRestrictionBuilder setRstrDate(LocalDate rstrDate) {
    this.rstrDate = rstrDate;
    return this;
  }

  public ED807ParticipantRestriction create() {
    return new ED807ParticipantRestriction(rstr, rstrDate);
  }

  public static ED807ParticipantRestrictionBuilder builder() {
    return new ED807ParticipantRestrictionBuilder();
  }
}
