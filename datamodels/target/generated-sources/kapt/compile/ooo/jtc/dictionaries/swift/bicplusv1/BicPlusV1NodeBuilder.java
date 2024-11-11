package ooo.jtc.dictionaries.swift.bicplusv1;

import java.lang.String;
import java.time.LocalDate;
import ooo.jtc.dictionaries.swift.SwiftInstType;

public final class BicPlusV1NodeBuilder {
  private BicPlusModificationFlagType modificationFlag;

  private String changedField;

  private String recordKey;

  private String previousRecordKey;

  private String nextRecordKey;

  private String eventType;

  private LocalDate eventDate;

  private String bic8;

  private String branchBic;

  private String bic;

  private String recordStatus;

  private BicPlusYesNoType operationallyActiveRecord;

  private String subtypeIndicator;

  private BicPlusYesNoType swiftFin;

  private BicPlusYesNoType swiftFa;

  private BicPlusYesNoType swiftIa;

  private String legalName;

  private String institutionName;

  private SwiftInstType institutionType;

  private String entityType;

  private String reStreetAddress1;

  private String reStreetAddress2;

  private String reStreetAddress3;

  private String reStreetAddress4;

  private String reCity;

  private String reCps;

  private String reZipCode;

  private String rePobNumber;

  private String opStreetAddress1;

  private String opStreetAddress2;

  private String opStreetAddress3;

  private String opStreetAddress4;

  private String opCity;

  private String opCps;

  private String opZipCode;

  private String opPobNumber;

  private String brStreetAddress1;

  private String brStreetAddress2;

  private String brStreetAddress3;

  private String brStreetAddress4;

  private String brCity;

  private String brCps;

  private String brZipCode;

  private String brPobNumber;

  private String branchInformation;

  private String countryName;

  private String isoCountryCode;

  private String locationCode;

  private String finServiceCodes;

  private String recordKeyBdp;

  private String fieldA;

  private String fieldB;

  private String fieldC;

  private String fieldD;

  private String fieldE;

  private String fieldF;

  public BicPlusV1NodeBuilder setModificationFlag(BicPlusModificationFlagType modificationFlag) {
    this.modificationFlag = modificationFlag;
    return this;
  }

  public BicPlusV1NodeBuilder setChangedField(String changedField) {
    this.changedField = changedField;
    return this;
  }

  public BicPlusV1NodeBuilder setRecordKey(String recordKey) {
    this.recordKey = recordKey;
    return this;
  }

  public BicPlusV1NodeBuilder setPreviousRecordKey(String previousRecordKey) {
    this.previousRecordKey = previousRecordKey;
    return this;
  }

  public BicPlusV1NodeBuilder setNextRecordKey(String nextRecordKey) {
    this.nextRecordKey = nextRecordKey;
    return this;
  }

  public BicPlusV1NodeBuilder setEventType(String eventType) {
    this.eventType = eventType;
    return this;
  }

  public BicPlusV1NodeBuilder setEventDate(LocalDate eventDate) {
    this.eventDate = eventDate;
    return this;
  }

  public BicPlusV1NodeBuilder setBic8(String bic8) {
    this.bic8 = bic8;
    return this;
  }

  public BicPlusV1NodeBuilder setBranchBic(String branchBic) {
    this.branchBic = branchBic;
    return this;
  }

  public BicPlusV1NodeBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public BicPlusV1NodeBuilder setRecordStatus(String recordStatus) {
    this.recordStatus = recordStatus;
    return this;
  }

  public BicPlusV1NodeBuilder setOperationallyActiveRecord(
      BicPlusYesNoType operationallyActiveRecord) {
    this.operationallyActiveRecord = operationallyActiveRecord;
    return this;
  }

  public BicPlusV1NodeBuilder setSubtypeIndicator(String subtypeIndicator) {
    this.subtypeIndicator = subtypeIndicator;
    return this;
  }

  public BicPlusV1NodeBuilder setSwiftFin(BicPlusYesNoType swiftFin) {
    this.swiftFin = swiftFin;
    return this;
  }

  public BicPlusV1NodeBuilder setSwiftFa(BicPlusYesNoType swiftFa) {
    this.swiftFa = swiftFa;
    return this;
  }

  public BicPlusV1NodeBuilder setSwiftIa(BicPlusYesNoType swiftIa) {
    this.swiftIa = swiftIa;
    return this;
  }

  public BicPlusV1NodeBuilder setLegalName(String legalName) {
    this.legalName = legalName;
    return this;
  }

  public BicPlusV1NodeBuilder setInstitutionName(String institutionName) {
    this.institutionName = institutionName;
    return this;
  }

  public BicPlusV1NodeBuilder setInstitutionType(SwiftInstType institutionType) {
    this.institutionType = institutionType;
    return this;
  }

  public BicPlusV1NodeBuilder setEntityType(String entityType) {
    this.entityType = entityType;
    return this;
  }

  public BicPlusV1NodeBuilder setReStreetAddress1(String reStreetAddress1) {
    this.reStreetAddress1 = reStreetAddress1;
    return this;
  }

  public BicPlusV1NodeBuilder setReStreetAddress2(String reStreetAddress2) {
    this.reStreetAddress2 = reStreetAddress2;
    return this;
  }

  public BicPlusV1NodeBuilder setReStreetAddress3(String reStreetAddress3) {
    this.reStreetAddress3 = reStreetAddress3;
    return this;
  }

  public BicPlusV1NodeBuilder setReStreetAddress4(String reStreetAddress4) {
    this.reStreetAddress4 = reStreetAddress4;
    return this;
  }

  public BicPlusV1NodeBuilder setReCity(String reCity) {
    this.reCity = reCity;
    return this;
  }

  public BicPlusV1NodeBuilder setReCps(String reCps) {
    this.reCps = reCps;
    return this;
  }

  public BicPlusV1NodeBuilder setReZipCode(String reZipCode) {
    this.reZipCode = reZipCode;
    return this;
  }

  public BicPlusV1NodeBuilder setRePobNumber(String rePobNumber) {
    this.rePobNumber = rePobNumber;
    return this;
  }

  public BicPlusV1NodeBuilder setOpStreetAddress1(String opStreetAddress1) {
    this.opStreetAddress1 = opStreetAddress1;
    return this;
  }

  public BicPlusV1NodeBuilder setOpStreetAddress2(String opStreetAddress2) {
    this.opStreetAddress2 = opStreetAddress2;
    return this;
  }

  public BicPlusV1NodeBuilder setOpStreetAddress3(String opStreetAddress3) {
    this.opStreetAddress3 = opStreetAddress3;
    return this;
  }

  public BicPlusV1NodeBuilder setOpStreetAddress4(String opStreetAddress4) {
    this.opStreetAddress4 = opStreetAddress4;
    return this;
  }

  public BicPlusV1NodeBuilder setOpCity(String opCity) {
    this.opCity = opCity;
    return this;
  }

  public BicPlusV1NodeBuilder setOpCps(String opCps) {
    this.opCps = opCps;
    return this;
  }

  public BicPlusV1NodeBuilder setOpZipCode(String opZipCode) {
    this.opZipCode = opZipCode;
    return this;
  }

  public BicPlusV1NodeBuilder setOpPobNumber(String opPobNumber) {
    this.opPobNumber = opPobNumber;
    return this;
  }

  public BicPlusV1NodeBuilder setBrStreetAddress1(String brStreetAddress1) {
    this.brStreetAddress1 = brStreetAddress1;
    return this;
  }

  public BicPlusV1NodeBuilder setBrStreetAddress2(String brStreetAddress2) {
    this.brStreetAddress2 = brStreetAddress2;
    return this;
  }

  public BicPlusV1NodeBuilder setBrStreetAddress3(String brStreetAddress3) {
    this.brStreetAddress3 = brStreetAddress3;
    return this;
  }

  public BicPlusV1NodeBuilder setBrStreetAddress4(String brStreetAddress4) {
    this.brStreetAddress4 = brStreetAddress4;
    return this;
  }

  public BicPlusV1NodeBuilder setBrCity(String brCity) {
    this.brCity = brCity;
    return this;
  }

  public BicPlusV1NodeBuilder setBrCps(String brCps) {
    this.brCps = brCps;
    return this;
  }

  public BicPlusV1NodeBuilder setBrZipCode(String brZipCode) {
    this.brZipCode = brZipCode;
    return this;
  }

  public BicPlusV1NodeBuilder setBrPobNumber(String brPobNumber) {
    this.brPobNumber = brPobNumber;
    return this;
  }

  public BicPlusV1NodeBuilder setBranchInformation(String branchInformation) {
    this.branchInformation = branchInformation;
    return this;
  }

  public BicPlusV1NodeBuilder setCountryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

  public BicPlusV1NodeBuilder setIsoCountryCode(String isoCountryCode) {
    this.isoCountryCode = isoCountryCode;
    return this;
  }

  public BicPlusV1NodeBuilder setLocationCode(String locationCode) {
    this.locationCode = locationCode;
    return this;
  }

  public BicPlusV1NodeBuilder setFinServiceCodes(String finServiceCodes) {
    this.finServiceCodes = finServiceCodes;
    return this;
  }

  public BicPlusV1NodeBuilder setRecordKeyBdp(String recordKeyBdp) {
    this.recordKeyBdp = recordKeyBdp;
    return this;
  }

  public BicPlusV1NodeBuilder setFieldA(String fieldA) {
    this.fieldA = fieldA;
    return this;
  }

  public BicPlusV1NodeBuilder setFieldB(String fieldB) {
    this.fieldB = fieldB;
    return this;
  }

  public BicPlusV1NodeBuilder setFieldC(String fieldC) {
    this.fieldC = fieldC;
    return this;
  }

  public BicPlusV1NodeBuilder setFieldD(String fieldD) {
    this.fieldD = fieldD;
    return this;
  }

  public BicPlusV1NodeBuilder setFieldE(String fieldE) {
    this.fieldE = fieldE;
    return this;
  }

  public BicPlusV1NodeBuilder setFieldF(String fieldF) {
    this.fieldF = fieldF;
    return this;
  }

  public BicPlusV1Node create() {
    return new BicPlusV1Node(modificationFlag, changedField, recordKey, previousRecordKey, nextRecordKey, eventType, eventDate, bic8, branchBic, bic, recordStatus, operationallyActiveRecord, subtypeIndicator, swiftFin, swiftFa, swiftIa, legalName, institutionName, institutionType, entityType, reStreetAddress1, reStreetAddress2, reStreetAddress3, reStreetAddress4, reCity, reCps, reZipCode, rePobNumber, opStreetAddress1, opStreetAddress2, opStreetAddress3, opStreetAddress4, opCity, opCps, opZipCode, opPobNumber, brStreetAddress1, brStreetAddress2, brStreetAddress3, brStreetAddress4, brCity, brCps, brZipCode, brPobNumber, branchInformation, countryName, isoCountryCode, locationCode, finServiceCodes, recordKeyBdp, fieldA, fieldB, fieldC, fieldD, fieldE, fieldF);
  }

  public static BicPlusV1NodeBuilder builder() {
    return new BicPlusV1NodeBuilder();
  }
}
