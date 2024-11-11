package ooo.jtc.dictionaries.incometype;

import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class IncomeTypeBuilder {
  private UUID id;

  private int version;

  private Integer code;

  private String name;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public IncomeTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IncomeTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IncomeTypeBuilder setCode(Integer code) {
    this.code = code;
    return this;
  }

  public IncomeTypeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public IncomeTypeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public IncomeTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public IncomeTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public IncomeType create() {
    return new IncomeType(id, version, code, name, description, createdAt, deletedAt);
  }

  public static IncomeTypeBuilder builder() {
    return new IncomeTypeBuilder();
  }
}
