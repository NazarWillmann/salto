package ooo.jtc.dictionaries.transferterm;

import java.lang.String;
import java.util.UUID;

public final class TransferTermDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String description;

  public TransferTermDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public TransferTermDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public TransferTermDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public TransferTermDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public TransferTermDto create() {
    return new TransferTermDto(id, version, code, description);
  }

  public static TransferTermDtoBuilder builder() {
    return new TransferTermDtoBuilder();
  }
}
