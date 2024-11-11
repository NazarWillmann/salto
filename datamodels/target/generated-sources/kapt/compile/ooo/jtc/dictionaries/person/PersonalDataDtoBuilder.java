package ooo.jtc.dictionaries.person;

import java.lang.String;
import java.time.LocalDate;

public final class PersonalDataDtoBuilder {
  private String firstName;

  private String lastName;

  private String middleName;

  private String mobilePhone;

  private String email;

  private String sex;

  private LocalDate birthdate;

  public PersonalDataDtoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PersonalDataDtoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PersonalDataDtoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public PersonalDataDtoBuilder setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public PersonalDataDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public PersonalDataDtoBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public PersonalDataDtoBuilder setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  public PersonalDataDto create() {
    return new PersonalDataDto(firstName, lastName, middleName, mobilePhone, email, sex, birthdate);
  }

  public static PersonalDataDtoBuilder builder() {
    return new PersonalDataDtoBuilder();
  }
}
