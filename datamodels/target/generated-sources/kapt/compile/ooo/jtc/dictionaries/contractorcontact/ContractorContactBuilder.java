package ooo.jtc.dictionaries.contractorcontact;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ContractorContactBuilder {
  private UUID id;

  private int version;

  private UUID contractorId;

  private String name;

  private String position;

  private String email;

  private String telephone;

  private String comment;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ContractorContactBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorContactBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorContactBuilder setContractorId(UUID contractorId) {
    this.contractorId = contractorId;
    return this;
  }

  public ContractorContactBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContractorContactBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public ContractorContactBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public ContractorContactBuilder setTelephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

  public ContractorContactBuilder setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public ContractorContactBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ContractorContactBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public ContractorContact create() {
    return new ContractorContact(id, version, contractorId, name, position, email, telephone, comment, createdAt, deletedAt);
  }

  public static ContractorContactBuilder builder() {
    return new ContractorContactBuilder();
  }
}
