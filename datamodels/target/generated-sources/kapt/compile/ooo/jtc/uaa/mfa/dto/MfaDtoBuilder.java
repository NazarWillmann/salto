package ooo.jtc.uaa.mfa.dto;

import java.lang.String;
import java.util.UUID;

public final class MfaDtoBuilder {
  private UUID id;

  private int version;

  private String mfaType;

  private String name;

  private String title;

  private String description;

  public MfaDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public MfaDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public MfaDtoBuilder setMfaType(String mfaType) {
    this.mfaType = mfaType;
    return this;
  }

  public MfaDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public MfaDtoBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public MfaDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public MfaDto create() {
    return new MfaDto(id, version, mfaType, name, title, description);
  }

  public static MfaDtoBuilder builder() {
    return new MfaDtoBuilder();
  }
}
