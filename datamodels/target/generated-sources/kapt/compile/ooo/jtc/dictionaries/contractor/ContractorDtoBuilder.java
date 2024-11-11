package ooo.jtc.dictionaries.contractor;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto;
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto;
import ooo.jtc.dictionaries.ground.GroundDto;

public final class ContractorDtoBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private String name;

  private String kpp;

  private String inn;

  private String description;

  private Boolean isFavorites;

  private List<ContractorPaymentDto> payments;

  private List<GroundDto> grounds;

  private List<ContractorContactDto> contacts;

  public ContractorDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorDtoBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public ContractorDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContractorDtoBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public ContractorDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public ContractorDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ContractorDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public ContractorDtoBuilder setPayments(List<ContractorPaymentDto> payments) {
    this.payments = payments;
    return this;
  }

  public ContractorDtoBuilder setGrounds(List<GroundDto> grounds) {
    this.grounds = grounds;
    return this;
  }

  public ContractorDtoBuilder setContacts(List<ContractorContactDto> contacts) {
    this.contacts = contacts;
    return this;
  }

  public ContractorDto create() {
    return new ContractorDto(id, version, customerId, name, kpp, inn, description, isFavorites, payments, grounds, contacts);
  }

  public static ContractorDtoBuilder builder() {
    return new ContractorDtoBuilder();
  }
}
