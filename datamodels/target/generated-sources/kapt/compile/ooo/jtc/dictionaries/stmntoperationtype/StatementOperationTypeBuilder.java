package ooo.jtc.dictionaries.stmntoperationtype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class StatementOperationTypeBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public StatementOperationTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public StatementOperationTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public StatementOperationTypeBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public StatementOperationTypeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public StatementOperationTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public StatementOperationTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public StatementOperationType create() {
    return new StatementOperationType(id, version, code, description, createdAt, deletedAt);
  }

  public static StatementOperationTypeBuilder builder() {
    return new StatementOperationTypeBuilder();
  }
}
