package ooo.jtc.dictionaries.person;

import java.lang.String;
import java.time.LocalDate;

public final class PersonalInfoDtoBuilder {
  private String firstName;

  private String lastName;

  private String middleName;

  private String sex;

  private LocalDate birthday;

  private String nationalityCountryDigitCode;

  private boolean isResident;

  private String inn;

  private String snils;

  private String mobilePhone;

  private String email;

  private boolean isPdAgreed;

  public PersonalInfoDtoBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PersonalInfoDtoBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PersonalInfoDtoBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public PersonalInfoDtoBuilder setSex(String sex) {
    this.sex = sex;
    return this;
  }

  public PersonalInfoDtoBuilder setBirthday(LocalDate birthday) {
    this.birthday = birthday;
    return this;
  }

  public PersonalInfoDtoBuilder setNationalityCountryDigitCode(String nationalityCountryDigitCode) {
    this.nationalityCountryDigitCode = nationalityCountryDigitCode;
    return this;
  }

  public PersonalInfoDtoBuilder setIsResident(boolean isResident) {
    this.isResident = isResident;
    return this;
  }

  public PersonalInfoDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public PersonalInfoDtoBuilder setSnils(String snils) {
    this.snils = snils;
    return this;
  }

  public PersonalInfoDtoBuilder setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public PersonalInfoDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public PersonalInfoDtoBuilder setIsPdAgreed(boolean isPdAgreed) {
    this.isPdAgreed = isPdAgreed;
    return this;
  }

  public PersonalInfoDto create() {
    return new PersonalInfoDto(firstName, lastName, middleName, sex, birthday, nationalityCountryDigitCode, isResident, inn, snils, mobilePhone, email, isPdAgreed);
  }

  public static PersonalInfoDtoBuilder builder() {
    return new PersonalInfoDtoBuilder();
  }
}
