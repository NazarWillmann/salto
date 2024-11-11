package ooo.jtc.dictionaries.lettertypefrombank;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class LetterTypeFromBankBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public LetterTypeFromBankBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterTypeFromBankBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LetterTypeFromBankBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public LetterTypeFromBankBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public LetterTypeFromBankBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public LetterTypeFromBankBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public LetterTypeFromBank create() {
    return new LetterTypeFromBank(id, version, code, description, createdAt, deletedAt);
  }

  public static LetterTypeFromBankBuilder builder() {
    return new LetterTypeFromBankBuilder();
  }
}
