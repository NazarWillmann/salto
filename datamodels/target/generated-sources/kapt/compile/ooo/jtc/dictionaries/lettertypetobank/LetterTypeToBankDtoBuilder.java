package ooo.jtc.dictionaries.lettertypetobank;

import java.lang.String;
import java.util.UUID;

public final class LetterTypeToBankDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public LetterTypeToBankDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public LetterTypeToBankDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public LetterTypeToBankDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public LetterTypeToBankDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public LetterTypeToBankDto create() {
    return new LetterTypeToBankDto(id, version, code, description);
  }

  public static LetterTypeToBankDtoBuilder builder() {
    return new LetterTypeToBankDtoBuilder();
  }
}
