package ooo.jtc.dictionaries.bankbic.ed807;

import java.lang.String;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

public final class ED807XmlBuilder {
  private String xmlns;

  private String edNo;

  private LocalDate edDate;

  private String edAuthor;

  private String edReceiver;

  private String creationReason;

  private ZonedDateTime creationDateTime;

  private String infoTypeCode;

  private LocalDate businessDay;

  private String directoryVersion;

  private List<ED807BicNode> bicNodeList;

  public ED807XmlBuilder setXmlns(String xmlns) {
    this.xmlns = xmlns;
    return this;
  }

  public ED807XmlBuilder setEdNo(String edNo) {
    this.edNo = edNo;
    return this;
  }

  public ED807XmlBuilder setEdDate(LocalDate edDate) {
    this.edDate = edDate;
    return this;
  }

  public ED807XmlBuilder setEdAuthor(String edAuthor) {
    this.edAuthor = edAuthor;
    return this;
  }

  public ED807XmlBuilder setEdReceiver(String edReceiver) {
    this.edReceiver = edReceiver;
    return this;
  }

  public ED807XmlBuilder setCreationReason(String creationReason) {
    this.creationReason = creationReason;
    return this;
  }

  public ED807XmlBuilder setCreationDateTime(ZonedDateTime creationDateTime) {
    this.creationDateTime = creationDateTime;
    return this;
  }

  public ED807XmlBuilder setInfoTypeCode(String infoTypeCode) {
    this.infoTypeCode = infoTypeCode;
    return this;
  }

  public ED807XmlBuilder setBusinessDay(LocalDate businessDay) {
    this.businessDay = businessDay;
    return this;
  }

  public ED807XmlBuilder setDirectoryVersion(String directoryVersion) {
    this.directoryVersion = directoryVersion;
    return this;
  }

  public ED807XmlBuilder setBicNodeList(List<ED807BicNode> bicNodeList) {
    this.bicNodeList = bicNodeList;
    return this;
  }

  public ED807Xml create() {
    return new ED807Xml(xmlns, edNo, edDate, edAuthor, edReceiver, creationReason, creationDateTime, infoTypeCode, businessDay, directoryVersion, bicNodeList);
  }

  public static ED807XmlBuilder builder() {
    return new ED807XmlBuilder();
  }
}
