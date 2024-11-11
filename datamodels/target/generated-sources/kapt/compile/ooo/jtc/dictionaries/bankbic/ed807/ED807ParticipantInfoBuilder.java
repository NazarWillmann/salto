package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;

public final class ED807ParticipantInfoBuilder {
  private String nameP;

  private String englName;

  private String regN;

  private String cntrCd;

  private String rgn;

  private String ind;

  private String tnp;

  private String nnp;

  private String adr;

  private String prntBic;

  private LocalDate dateIn;

  private LocalDate dateOut;

  private String ptType;

  private String srvcs;

  private String xchType;

  private String uid;

  private String npsParticipant;

  private String toNpsDate;

  private String participantStatus;

  private List<ED807ParticipantRestriction> restrictionList;

  public ED807ParticipantInfoBuilder setNameP(String nameP) {
    this.nameP = nameP;
    return this;
  }

  public ED807ParticipantInfoBuilder setEnglName(String englName) {
    this.englName = englName;
    return this;
  }

  public ED807ParticipantInfoBuilder setRegN(String regN) {
    this.regN = regN;
    return this;
  }

  public ED807ParticipantInfoBuilder setCntrCd(String cntrCd) {
    this.cntrCd = cntrCd;
    return this;
  }

  public ED807ParticipantInfoBuilder setRgn(String rgn) {
    this.rgn = rgn;
    return this;
  }

  public ED807ParticipantInfoBuilder setInd(String ind) {
    this.ind = ind;
    return this;
  }

  public ED807ParticipantInfoBuilder setTnp(String tnp) {
    this.tnp = tnp;
    return this;
  }

  public ED807ParticipantInfoBuilder setNnp(String nnp) {
    this.nnp = nnp;
    return this;
  }

  public ED807ParticipantInfoBuilder setAdr(String adr) {
    this.adr = adr;
    return this;
  }

  public ED807ParticipantInfoBuilder setPrntBic(String prntBic) {
    this.prntBic = prntBic;
    return this;
  }

  public ED807ParticipantInfoBuilder setDateIn(LocalDate dateIn) {
    this.dateIn = dateIn;
    return this;
  }

  public ED807ParticipantInfoBuilder setDateOut(LocalDate dateOut) {
    this.dateOut = dateOut;
    return this;
  }

  public ED807ParticipantInfoBuilder setPtType(String ptType) {
    this.ptType = ptType;
    return this;
  }

  public ED807ParticipantInfoBuilder setSrvcs(String srvcs) {
    this.srvcs = srvcs;
    return this;
  }

  public ED807ParticipantInfoBuilder setXchType(String xchType) {
    this.xchType = xchType;
    return this;
  }

  public ED807ParticipantInfoBuilder setUid(String uid) {
    this.uid = uid;
    return this;
  }

  public ED807ParticipantInfoBuilder setNpsParticipant(String npsParticipant) {
    this.npsParticipant = npsParticipant;
    return this;
  }

  public ED807ParticipantInfoBuilder setToNpsDate(String toNpsDate) {
    this.toNpsDate = toNpsDate;
    return this;
  }

  public ED807ParticipantInfoBuilder setParticipantStatus(String participantStatus) {
    this.participantStatus = participantStatus;
    return this;
  }

  public ED807ParticipantInfoBuilder setRestrictionList(
      List<ED807ParticipantRestriction> restrictionList) {
    this.restrictionList = restrictionList;
    return this;
  }

  public ED807ParticipantInfo create() {
    return new ED807ParticipantInfo(nameP, englName, regN, cntrCd, rgn, ind, tnp, nnp, adr, prntBic, dateIn, dateOut, ptType, srvcs, xchType, uid, npsParticipant, toNpsDate, participantStatus, restrictionList);
  }

  public static ED807ParticipantInfoBuilder builder() {
    return new ED807ParticipantInfoBuilder();
  }
}
