package ooo.jtc.dictionaries.codevo;

import java.lang.String;
import java.util.UUID;

public final class CodeVoDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public CodeVoDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CodeVoDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CodeVoDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public CodeVoDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CodeVoDto create() {
    return new CodeVoDto(id, version, code, description);
  }

  public static CodeVoDtoBuilder builder() {
    return new CodeVoDtoBuilder();
  }
}
