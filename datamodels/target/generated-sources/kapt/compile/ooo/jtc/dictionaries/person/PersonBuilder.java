package ooo.jtc.dictionaries.person;

import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public final class PersonBuilder {
  private UUID id;

  private int version;

  private String firstName;

  private String lastName;

  private String middleName;

  private String fullName;

  private String mobilePhone;

  private String email;

  private String sex;

  private LocalDate birthdate;

  private String description;

  private boolean phoneConfirmed;

  private boolean emailConfirmed;

  private String category;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public PersonBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PersonBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PersonBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PersonBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PersonBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public PersonBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public PersonBuilder setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public PersonBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public PersonBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public PersonBuilder setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  public PersonBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PersonBuilder setPhoneConfirmed(boolean phoneConfirmed) {
    this.phoneConfirmed = phoneConfirmed;
    return this;
  }

  public PersonBuilder setEmailConfirmed(boolean emailConfirmed) {
    this.emailConfirmed = emailConfirmed;
    return this;
  }

  public PersonBuilder setCategory(String category) {
    this.category = category;
    return this;
  }

  public PersonBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public PersonBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Person create() {
    return new Person(id, version, firstName, lastName, middleName, fullName, mobilePhone, email, sex, birthdate, description, phoneConfirmed, emailConfirmed, category, createdAt, deletedAt);
  }

  public static PersonBuilder builder() {
    return new PersonBuilder();
  }
}
