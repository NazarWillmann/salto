package ooo.jtc.dictionaries.bankbic;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.bankbic.acc.BankBicAccountDto;
import ooo.jtc.dictionaries.bankbic.innerenum.BankBicAllowedServicesIEnumDto;
import ooo.jtc.dictionaries.bankbic.innerenum.ValDescIEnumDto;
import ooo.jtc.dictionaries.bankbic.restr.BankBicRestrictionDto;

public final class BankBicDtoBuilder {
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

  private ValDescIEnumDto participantTransferType;

  private ValDescIEnumDto participantType;

  private BankBicAllowedServicesIEnumDto allowedServices;

  private LocalDate dateIn;

  private LocalDate dateOut;

  private ValDescIEnumDto status;

  private List<BankBicAccountDto> accounts;

  private List<BankBicRestrictionDto> restrictions;

  public BankBicDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankBicDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankBicDtoBuilder setBic(String bic) {
    this.bic = bic;
    return this;
  }

  public BankBicDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankBicDtoBuilder setCountryAlpha2Code(String countryAlpha2Code) {
    this.countryAlpha2Code = countryAlpha2Code;
    return this;
  }

  public BankBicDtoBuilder setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public BankBicDtoBuilder setLocationType(String locationType) {
    this.locationType = locationType;
    return this;
  }

  public BankBicDtoBuilder setLocation(String location) {
    this.location = location;
    return this;
  }

  public BankBicDtoBuilder setAddress(String address) {
    this.address = address;
    return this;
  }

  public BankBicDtoBuilder setParentBic(String parentBic) {
    this.parentBic = parentBic;
    return this;
  }

  public BankBicDtoBuilder setParticipantTransferType(ValDescIEnumDto participantTransferType) {
    this.participantTransferType = participantTransferType;
    return this;
  }

  public BankBicDtoBuilder setParticipantType(ValDescIEnumDto participantType) {
    this.participantType = participantType;
    return this;
  }

  public BankBicDtoBuilder setAllowedServices(BankBicAllowedServicesIEnumDto allowedServices) {
    this.allowedServices = allowedServices;
    return this;
  }

  public BankBicDtoBuilder setDateIn(LocalDate dateIn) {
    this.dateIn = dateIn;
    return this;
  }

  public BankBicDtoBuilder setDateOut(LocalDate dateOut) {
    this.dateOut = dateOut;
    return this;
  }

  public BankBicDtoBuilder setStatus(ValDescIEnumDto status) {
    this.status = status;
    return this;
  }

  public BankBicDtoBuilder setAccounts(List<BankBicAccountDto> accounts) {
    this.accounts = accounts;
    return this;
  }

  public BankBicDtoBuilder setRestrictions(List<BankBicRestrictionDto> restrictions) {
    this.restrictions = restrictions;
    return this;
  }

  public BankBicDto create() {
    return new BankBicDto(id, version, bic, name, countryAlpha2Code, zip, locationType, location, address, parentBic, participantTransferType, participantType, allowedServices, dateIn, dateOut, status, accounts, restrictions);
  }

  public static BankBicDtoBuilder builder() {
    return new BankBicDtoBuilder();
  }
}
