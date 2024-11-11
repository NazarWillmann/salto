package ooo.jtc.dictionaries.contractorcontact;

import java.lang.String;
import java.util.UUID;

public final class ContractorContactDtoBuilder {
  private UUID id;

  private int version;

  private UUID contractorId;

  private String name;

  private String position;

  private String email;

  private String telephone;

  private String comment;

  public ContractorContactDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorContactDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorContactDtoBuilder setContractorId(UUID contractorId) {
    this.contractorId = contractorId;
    return this;
  }

  public ContractorContactDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContractorContactDtoBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public ContractorContactDtoBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public ContractorContactDtoBuilder setTelephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  public ContractorContactDtoBuilder setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public ContractorContactDto create() {
    return new ContractorContactDto(id, version, contractorId, name, position, email, telephone, comment);
  }

  public static ContractorContactDtoBuilder builder() {
    return new ContractorContactDtoBuilder();
  }
}
