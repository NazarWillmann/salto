package ooo.jtc.dictionaries.okfs;

import java.lang.String;
import java.util.UUID;

public final class OkfsDtoBuilder {
  private UUID id;

  private int version;

  private String code;

  private String parentCode;

  private String description;

  public OkfsDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public OkfsDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public OkfsDtoBuilder setCode(String code) {
    this.code = code;
    return this;
  }

  public OkfsDtoBuilder setParentCode(String parentCode) {
    this.parentCode = parentCode;
    return this;
  }

  public OkfsDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public OkfsDto create() {
    return new OkfsDto(id, version, code, parentCode, description);
  }

  public static OkfsDtoBuilder builder() {
    return new OkfsDtoBuilder();
  }
}
