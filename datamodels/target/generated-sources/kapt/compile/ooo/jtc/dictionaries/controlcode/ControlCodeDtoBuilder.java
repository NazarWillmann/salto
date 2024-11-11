package ooo.jtc.dictionaries.controlcode;

import java.lang.String;
import java.util.UUID;

public final class ControlCodeDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public ControlCodeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ControlCodeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ControlCodeDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public ControlCodeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ControlCodeDto create() {
    return new ControlCodeDto(id, version, code, description);
  }

  public static ControlCodeDtoBuilder builder() {
    return new ControlCodeDtoBuilder();
  }
}
