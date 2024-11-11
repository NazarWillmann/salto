package ooo.jtc.dictionaries.kbk;

import java.lang.String;
import java.util.UUID;

public final class KbkDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public KbkDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public KbkDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public KbkDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public KbkDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public KbkDto create() {
    return new KbkDto(id, version, code, description);
  }

  public static KbkDtoBuilder builder() {
    return new KbkDtoBuilder();
  }
}
