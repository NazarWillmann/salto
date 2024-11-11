package ooo.jtc.dictionaries.contractor;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.contractorcontact.ContractorContact;
import ooo.jtc.dictionaries.contractorpayment.ContractorPayment;
import ooo.jtc.dictionaries.ground.Ground;

public final class ContractorBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private String name;

  private String inn;

  private String kpp;

  private String description;

  private List<ContractorPayment> payments;

  private List<Ground> grounds;

  private List<ContractorContact> contacts;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ContractorBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public ContractorBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContractorBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public ContractorBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public ContractorBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ContractorBuilder setPayments(List<ContractorPayment> payments) {
    this.payments = payments;
    return this;
  }

  public ContractorBuilder setGrounds(List<Ground> grounds) {
    this.grounds = grounds;
    return this;
  }

  public ContractorBuilder setContacts(List<ContractorContact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public ContractorBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ContractorBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Contractor create() {
    return new Contractor(id, version, customerId, name, inn, kpp, description, payments, grounds, contacts, createdAt, deletedAt);
  }

  public static ContractorBuilder builder() {
    return new ContractorBuilder();
  }
}
