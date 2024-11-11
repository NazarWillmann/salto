package ooo.jtc.dictionaries.lettertypetobank;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class LetterTypeToBankBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public LetterTypeToBankBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterTypeToBankBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LetterTypeToBankBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public LetterTypeToBankBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public LetterTypeToBankBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LetterTypeToBankBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public LetterTypeToBank create() {
    return new LetterTypeToBank(id, version, code, description, createdAt, deletedAt);
  }

  public static LetterTypeToBankBuilder builder() {
    return new LetterTypeToBankBuilder();
  }
}
