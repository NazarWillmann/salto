package ooo.jtc.dictionaries.individual;

import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.common.BlockingInfoDto;
import ooo.jtc.dictionaries.common.address.AddressDto;
import ooo.jtc.dictionaries.identitydocument.IdentityDocumentDto;
import ooo.jtc.dictionaries.person.PersonDto;
import ooo.jtc.dictionaries.person.PersonalInfoDto;

public final class IndividualDtoBuilder {
  private UUID id;

  private int version;

  private BlockingInfoDto block;

  private PersonDto person;

  private PersonalInfoDto personalInfo;

  private List<IdentityDocumentDto> identityDocuments;

  private AddressDto addressRegistration;

  private AddressDto addressLocation;

  public IndividualDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IndividualDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IndividualDtoBuilder setBlock(BlockingInfoDto block) {
    this.block = block;
    return this;
  }

  public IndividualDtoBuilder setPerson(PersonDto person) {
    this.person = person;
    return this;
  }

  public IndividualDtoBuilder setPersonalInfo(PersonalInfoDto personalInfo) {
    this.personalInfo = personalInfo;
    return this;
  }

  public IndividualDtoBuilder setIdentityDocuments(List<IdentityDocumentDto> identityDocuments) {
    this.identityDocuments = identityDocuments;
    return this;
  }

  public IndividualDtoBuilder setAddressRegistration(AddressDto addressRegistration) {
    this.addressRegistration = addressRegistration;
    return this;
  }

  public IndividualDtoBuilder setAddressLocation(AddressDto addressLocation) {
    this.addressLocation = addressLocation;
    return this;
  }

  public IndividualDto create() {
    return new IndividualDto(id, version, block, person, personalInfo, identityDocuments, addressRegistration, addressLocation);
  }

  public static IndividualDtoBuilder builder() {
    return new IndividualDtoBuilder();
  }
}
