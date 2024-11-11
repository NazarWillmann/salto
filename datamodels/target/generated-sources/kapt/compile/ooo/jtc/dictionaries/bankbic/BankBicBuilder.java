package ooo.jtc.dictionaries.bankbic;

import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccount;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestriction;

public final class BankBicBuilder {
  private UUID id;

  private int version;

  private String bic;

  private String name;

  private String countryAlpha2Code;

  private String zip;

  private String locationType;

  private String location;

  private String address;

  private String parentBic;

  private String participantTransferType;

  private String participantType;

  private String allowedServices;

  private LocalDate dateIn;

  private LocalDate dateOut;

  private String status;

  private List<BankBicAccount> accounts;

  private List<BankBicRestriction> restrictions;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BankBicBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public BankBicBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankBicBuilder setCountryAlpha2Code(String countryAlpha2Code) {
    this.countryAlpha2Code = countryAlpha2Code;
    return this;
  }

  public BankBicBuilder setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public BankBicBuilder setLocationType(String locationType) {
    this.locationType = locationType;
    return this;
  }

  public BankBicBuilder setLocation(String location) {
    this.location = location;
    return this;
  }

  public BankBicBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public BankBicBuilder setParentBic(String parentBic) {
    this.parentBic = parentBic;
    return this;
  }

  public BankBicBuilder setParticipantTransferType(String participantTransferType) {
    this.participantTransferType = participantTransferType;
    return this;
  }

  public BankBicBuilder setParticipantType(String participantType) {
    this.participantType = participantType;
    return this;
  }

  public BankBicBuilder setAllowedServices(String allowedServices) {
    this.allowedServices = allowedServices;
    return this;
  }

  public BankBicBuilder setDateIn(LocalDate dateIn) {
    this.dateIn = dateIn;
    return this;
  }

  public BankBicBuilder setDateOut(LocalDate dateOut) {
    this.dateOut = dateOut;
    return this;
  }

  public BankBicBuilder setStatus(String status) {
    this.status = status;
    return this;
  }

  public BankBicBuilder setAccounts(List<BankBicAccount> accounts) {
    this.accounts = accounts;
    return this;
  }

  public BankBicBuilder setRestrictions(List<BankBicRestriction> restrictions) {
    this.restrictions = restrictions;
    return this;
  }

  public BankBicBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BankBicBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BankBic create() {
    return new BankBic(id, version, bic, name, countryAlpha2Code, zip, locationType, location, address, parentBic, participantTransferType, participantType, allowedServices, dateIn, dateOut, status, accounts, restrictions, createdAt, deletedAt);
  }

  public static BankBicBuilder builder() {
    return new BankBicBuilder();
  }
}
