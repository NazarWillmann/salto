package ooo.jtc.dictionaries.lettertypefrombank;

import java.lang.String;
import java.util.UUID;

public final class LetterTypeFromBankDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public LetterTypeFromBankDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterTypeFromBankDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LetterTypeFromBankDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public LetterTypeFromBankDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public LetterTypeFromBankDto create() {
    return new LetterTypeFromBankDto(id, version, code, description);
  }

  public static LetterTypeFromBankDtoBuilder builder() {
    return new LetterTypeFromBankDtoBuilder();
  }
}
