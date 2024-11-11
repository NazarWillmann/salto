package ooo.jtc.dictionaries.gozcontract;

import java.lang.String;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

public final class GozContractBuilder {
  private UUID id;

  private int version;

  private String number;

  private LocalDate date;

  private String identity;

  private String contractNumber;

  private LocalDate contractDate;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public GozContractBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public GozContractBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public GozContractBuilder setNumber(String number) {
    this.number = number;
    return this;
  }

  public GozContractBuilder setDate(LocalDate date) {
    this.date = date;
    return this;
  }

  public GozContractBuilder setIdentity(String identity) {
    this.identity = identity;
    return this;
  }

  public GozContractBuilder setContractNumber(String contractNumber) {
    this.contractNumber = contractNumber;
    return this;
  }

  public GozContractBuilder setContractDate(LocalDate contractDate) {
    this.contractDate = contractDate;
    return this;
  }

  public GozContractBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public GozContractBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public GozContract create() {
    return new GozContract(id, version, number, date, identity, contractNumber, contractDate, createdAt, deletedAt);
  }

  public static GozContractBuilder builder() {
    return new GozContractBuilder();
  }
}
