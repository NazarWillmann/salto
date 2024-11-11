package ooo.jtc.dictionaries.contractor;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.dictionaries.contractorcontact.ContractorContactDto;
import ooo.jtc.dictionaries.contractorpayment.ContractorPaymentDto;
import ooo.jtc.dictionaries.ground.GroundDto;

public final class ContractorUpdateDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String kpp;

  private String inn;

  private String description;

  private List<ContractorPaymentDto> payments;

  private List<GroundDto> grounds;

  private List<ContractorContactDto> contacts;

  public ContractorUpdateDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ContractorUpdateDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ContractorUpdateDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ContractorUpdateDtoBuilder setKpp(String kpp) {
    this.kpp = kpp;
    return this;
  }

  public ContractorUpdateDtoBuilder setInn(String inn) {
    this.inn = inn;
    return this;
  }

  public ContractorUpdateDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ContractorUpdateDtoBuilder setPayments(List<ContractorPaymentDto> payments) {
    this.payments = payments;
    return this;
  }

  public ContractorUpdateDtoBuilder setGrounds(List<GroundDto> grounds) {
    this.grounds = grounds;
    return this;
  }

  public ContractorUpdateDtoBuilder setContacts(List<ContractorContactDto> contacts) {
    this.contacts = contacts;
    return this;
  }

  public ContractorUpdateDto create() {
    return new ContractorUpdateDto(id, version, name, kpp, inn, description, payments, grounds, contacts);
  }

  public static ContractorUpdateDtoBuilder builder() {
    return new ContractorUpdateDtoBuilder();
  }
}
