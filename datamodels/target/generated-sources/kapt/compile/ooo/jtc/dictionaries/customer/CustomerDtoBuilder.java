package ooo.jtc.dictionaries.customer;

import java.lang.String;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.address.AddressDto;
import ooo.jtc.dictionaries.customerkpp.CustomerKppDto;
import ooo.jtc.dictionaries.customertype.CustomerTypeDto;

public final class CustomerDtoBuilder {
  private UUID id;

  private int version;

  private String fullName;

  private String shortName;

  private String intName;

  private boolean isResident;

  private String inn;

  private String okpo;

  private String ogrn;

  private LocalDate ogrnDate;

  private String email;

  private String phone;

  private String description;

  private boolean isAgreed;

  private String countryDigitCode;

  private String okopf;

  private List<CustomerKppDto> kpp;

  private String okfs;

  private BlockingInfoDto block;

  private AddressDto addressRegistration;

  private AddressDto addressLocation;

  private UUID customerTypeId;

  private CustomerTypeDto customerType;

  public CustomerDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerDtoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public CustomerDtoBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public CustomerDtoBuilder setIntName(String intName) {
    this.intName = intName;
    return this;
  }

  public CustomerDtoBuilder setIsResident(boolean isResident) {
    this.isResident = isResident;
    return this;
  }

  public CustomerDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public CustomerDtoBuilder setOkpo(String okpo) {
    this.okpo = okpo;
    return this;
  }

  public CustomerDtoBuilder setOgrn(String ogrn) {
    this.ogrn = ogrn;
    return this;
  }

  public CustomerDtoBuilder setOgrnDate(LocalDate ogrnDate) {
    this.ogrnDate = ogrnDate;
    return this;
  }

  public CustomerDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public CustomerDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CustomerDtoBuilder setIsAgreed(boolean isAgreed) {
    this.isAgreed = isAgreed;
    return this;
  }

  public CustomerDtoBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public CustomerDtoBuilder setOkopf(String okopf) {
    this.okopf = okopf;
    return this;
  }

  public CustomerDtoBuilder setKpp(List<CustomerKppDto> kpp) {
    this.kpp = kpp;
    return this;
  }

  public CustomerDtoBuilder setOkfs(String okfs) {
    this.okfs = okfs;
    return this;
  }

  public CustomerDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public CustomerDtoBuilder setAddressRegistration(AddressDto addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public CustomerDtoBuilder setAddressLocation(AddressDto addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public CustomerDtoBuilder setCustomerTypeId(UUID customerTypeId) {
    this.customerTypeId = customerTypeId;
    return this;
  }

  public CustomerDtoBuilder setCustomerType(CustomerTypeDto customerType) {
    this.customerType = customerType;
    return this;
  }

  public CustomerDto create() {
    return new CustomerDto(id, version, fullName, shortName, intName, isResident, inn, okpo, ogrn, ogrnDate, email, phone, description, isAgreed, countryDigitCode, okopf, kpp, okfs, block, addressRegistration, addressLocation, customerTypeId, customerType);
  }

  public static CustomerDtoBuilder builder() {
    return new CustomerDtoBuilder();
  }
}
