package ooo.jtc.dictionaries.individual;

import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;
import ooo.jtc.dictionaries.common.address.Address;

public final class IndividualBuilder {
  private UUID id;

  private int version;

  private UUID personId;

  private String firstName;

  private String lastName;

  private String middleName;

  private String sex;

  private LocalDate birthday;

  private String nationalityCountry;

  private boolean isResident;

  private String inn;

  private String snils;

  private String mobilePhone;

  private String email;

  private boolean isPgAgreed;

  private boolean isBlock;

  private UUID blockUser;

  private Timestamp blockDate;

  private String description;

  private Address addressLocation;

  private Address addressRegistration;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public IndividualBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IndividualBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IndividualBuilder setPersonId(UUID personId) {
    this.personId = personId;
    return this;
  }

  public IndividualBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public IndividualBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public IndividualBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public IndividualBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public IndividualBuilder setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public IndividualBuilder setNationalityCountry(String nationalityCountry) {
    this.nationalityCountry = nationalityCountry;
    return this;
  }

  public IndividualBuilder setIsResident(boolean isResident) {
    this.isResident = isResident;
    return this;
  }

  public IndividualBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public IndividualBuilder setSnils(String snils) {
    this.snils = snils;
    return this;
  }

  public IndividualBuilder setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public IndividualBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public IndividualBuilder setIsPgAgreed(boolean isPgAgreed) {
    this.isPgAgreed = isPgAgreed;
    return this;
  }

  public IndividualBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public IndividualBuilder setBlockUser(UUID blockUser) {
    this.blockUser = blockUser;
    return this;
  }

  public IndividualBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public IndividualBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public IndividualBuilder setAddressLocation(Address addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public IndividualBuilder setAddressRegistration(Address addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public IndividualBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public IndividualBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Individual create() {
    return new Individual(id, version, personId, firstName, lastName, middleName, sex, birthday, nationalityCountry, isResident, inn, snils, mobilePhone, email, isPgAgreed, isBlock, blockUser, blockDate, description, addressLocation, addressRegistration, createdAt, deletedAt);
  }

  public static IndividualBuilder builder() {
    return new IndividualBuilder();
  }
}
