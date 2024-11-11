package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;
import java.util.List;

public final class ED807BicNodeBuilder {
  private String bic;

  private String changeType;

  private ED807ParticipantInfo participantInfo;

  private List<ED807SwBic> swBics;

  private List<ED807Account> accounts;

  public ED807BicNodeBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public ED807BicNodeBuilder setChangeType(String changeType) {
    this.changeType = changeType;
    return this;
  }

  public ED807BicNodeBuilder setParticipantInfo(ED807ParticipantInfo participantInfo) {
    this.participantInfo = participantInfo;
    return this;
  }

  public ED807BicNodeBuilder setSwBics(List<ED807SwBic> swBics) {
    this.swBics = swBics;
    return this;
  }

  public ED807BicNodeBuilder setAccounts(List<ED807Account> accounts) {
    this.accounts = accounts;
    return this;
  }

  public ED807BicNode create() {
    return new ED807BicNode(bic, changeType, participantInfo, swBics, accounts);
  }

  public static ED807BicNodeBuilder builder() {
    return new ED807BicNodeBuilder();
  }
}
