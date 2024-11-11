package ooo.jtc.dictionaries.okopf;

import java.lang.String;
import java.util.UUID;

public final class OkopfDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public OkopfDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public OkopfDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public OkopfDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public OkopfDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public OkopfDto create() {
    return new OkopfDto(id, version, code, description);
  }

  public static OkopfDtoBuilder builder() {
    return new OkopfDtoBuilder();
  }
}
