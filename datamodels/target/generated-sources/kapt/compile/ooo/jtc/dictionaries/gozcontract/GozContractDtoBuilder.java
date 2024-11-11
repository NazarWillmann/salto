package ooo.jtc.dictionaries.gozcontract;

import java.lang.String;
import java.time.LocalDate;
import java.util.UUID;

public final class GozContractDtoBuilder {
  private UUID id;

  private int version;

  private String number;

  private LocalDate date;

  private String identity;

  private String contractNumber;

  private LocalDate contractDate;

  public GozContractDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public GozContractDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public GozContractDtoBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public GozContractDtoBuilder setDate(LocalDate date) {
    this.date = date;
    return this;
  }

  public GozContractDtoBuilder setIdentity(String identity) {
    this.identity = identity;
    return this;
  }

  public GozContractDtoBuilder setContractNumber(String contractNumber) {
    this.contractNumber = contractNumber;
    return this;
  }

  public GozContractDtoBuilder setContractDate(LocalDate contractDate) {
    this.contractDate = contractDate;
    return this;
  }

  public GozContractDto create() {
    return new GozContractDto(id, version, number, date, identity, contractNumber, contractDate);
  }

  public static GozContractDtoBuilder builder() {
    return new GozContractDtoBuilder();
  }
}
