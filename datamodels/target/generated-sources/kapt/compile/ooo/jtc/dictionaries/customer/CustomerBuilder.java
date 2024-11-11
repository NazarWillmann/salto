package ooo.jtc.dictionaries.customer;

import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.common.address.Address;
import ooo.jtc.dictionaries.customerkpp.CustomerKpp;
import ooo.jtc.dictionaries.customertype.CustomerType;

public final class CustomerBuilder {
  private UUID id;

  private int version;

  private String shortName;

  private String fullName;

  private String intName;

  private boolean isResident;

  private String inn;

  private String okopf;

  private String okfs;

  private String okpo;

  private String ogrn;

  private LocalDate ogrnDate;

  private String email;

  private String phone;

  private String description;

  private boolean isAgreed;

  private String countryDigitCode;

  private boolean isBlock;

  private UUID blockUserId;

  private Timestamp blockDate;

  private Address addressLocation;

  private Address addressRegistration;

  private UUID customerTypeId;

  private CustomerType customerType;

  private List<CustomerKpp> kpp;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public CustomerBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public CustomerBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public CustomerBuilder setIntName(String intName) {
    this.intName = intName;
    return this;
  }

  public CustomerBuilder setIsResident(boolean isResident) {
    this.isResident = isResident;
    return this;
  }

  public CustomerBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public CustomerBuilder setOkopf(String okopf) {
    this.okopf = okopf;
    return this;
  }

  public CustomerBuilder setOkfs(String okfs) {
    this.okfs = okfs;
    return this;
  }

  public CustomerBuilder setOkpo(String okpo) {
    this.okpo = okpo;
    return this;
  }

  public CustomerBuilder setOgrn(String ogrn) {
    this.ogrn = ogrn;
    return this;
  }

  public CustomerBuilder setOgrnDate(LocalDate ogrnDate) {
    this.ogrnDate = ogrnDate;
    return this;
  }

  public CustomerBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public CustomerBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CustomerBuilder setIsAgreed(boolean isAgreed) {
    this.isAgreed = isAgreed;
    return this;
  }

  public CustomerBuilder setCountryDigitCode(String countryDigitCode) {
    this.countryDigitCode = countryDigitCode;
    return this;
  }

  public CustomerBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public CustomerBuilder setBlockUserId(UUID blockUserId) {
    this.blockUserId = blockUserId;
    return this;
  }

  public CustomerBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public CustomerBuilder setAddressLocation(Address addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public CustomerBuilder setAddressRegistration(Address addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public CustomerBuilder setCustomerTypeId(UUID customerTypeId) {
    this.customerTypeId = customerTypeId;
    return this;
  }

  public CustomerBuilder setCustomerType(CustomerType customerType) {
    this.customerType = customerType;
    return this;
  }

  public CustomerBuilder setKpp(List<CustomerKpp> kpp) {
    this.kpp = kpp;
    return this;
  }

  public CustomerBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CustomerBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Customer create() {
    return new Customer(id, version, shortName, fullName, intName, isResident, inn, okopf, okfs, okpo, ogrn, ogrnDate, email, phone, description, isAgreed, countryDigitCode, isBlock, blockUserId, blockDate, addressLocation, addressRegistration, customerTypeId, customerType, kpp, createdAt, deletedAt);
  }

  public static CustomerBuilder builder() {
    return new CustomerBuilder();
  }
}
