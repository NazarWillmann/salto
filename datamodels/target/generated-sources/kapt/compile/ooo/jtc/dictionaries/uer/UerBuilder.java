package ooo.jtc.dictionaries.uer;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;
import ooo.jtc.dictionaries.bankru.BankType;

public final class UerBuilder {
  private UUID id;

  private int version;

  private String uer;

  private BankType bankType;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public UerBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public UerBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public UerBuilder setUer(String uer) {
    this.uer = uer;
    return this;
  }

  public UerBuilder setBankType(BankType bankType) {
    this.bankType = bankType;
    return this;
  }

  public UerBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public UerBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public UerBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Uer create() {
    return new Uer(id, version, uer, bankType, description, createdAt, deletedAt);
  }

  public static UerBuilder builder() {
    return new UerBuilder();
  }
}
