package ooo.jtc.dictionaries.transferterm;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class TransferTermBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public TransferTermBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TransferTermBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public TransferTermBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public TransferTermBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public TransferTermBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public TransferTermBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public TransferTerm create() {
    return new TransferTerm(id, version, code, description, createdAt, deletedAt);
  }

  public static TransferTermBuilder builder() {
    return new TransferTermBuilder();
  }
}
