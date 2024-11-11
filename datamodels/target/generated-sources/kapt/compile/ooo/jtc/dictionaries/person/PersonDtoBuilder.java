package ooo.jtc.dictionaries.person;

import java.lang.String;
import java.util.UUID;

public final class PersonDtoBuilder {
  private UUID id;

  private int version;

  private PersonalDataDto personalData;

  private String description;

  private boolean confirmedMobilePhone;

  private boolean confirmedEmail;

  private String category;

  public PersonDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PersonDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PersonDtoBuilder setPersonalData(PersonalDataDto personalData) {
    this.personalData = personalData;
    return this;
  }

  public PersonDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public PersonDtoBuilder setConfirmedMobilePhone(boolean confirmedMobilePhone) {
    this.confirmedMobilePhone = confirmedMobilePhone;
    return this;
  }

  public PersonDtoBuilder setConfirmedEmail(boolean confirmedEmail) {
    this.confirmedEmail = confirmedEmail;
    return this;
  }

  public PersonDtoBuilder setCategory(String category) {
    this.category = category;
    return this;
  }

  public PersonDto create() {
    return new PersonDto(id, version, personalData, description, confirmedMobilePhone, confirmedEmail, category);
  }

  public static PersonDtoBuilder builder() {
    return new PersonDtoBuilder();
  }
}
