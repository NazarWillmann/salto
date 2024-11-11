package ooo.jtc.uaa.mfa.model;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class MfaBuilder {
  private UUID id;

  private int version;

  private String mfaType;

  private String name;

  private String title;

  private String description;

  private String config;

  private ZonedDateTime createdAt;

  private ZonedDateTime deletedAt;

  public MfaBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public MfaBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public MfaBuilder setMfaType(String mfaType) {
    this.mfaType = mfaType;
    return this;
  }

  public MfaBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public MfaBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public MfaBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public MfaBuilder setConfig(String config) {
    this.config = config;
    return this;
  }

  public MfaBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public MfaBuilder setDeletedAt(ZonedDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Mfa create() {
    return new Mfa(id, version, mfaType, name, title, description, config, createdAt, deletedAt);
  }

  public static MfaBuilder builder() {
    return new MfaBuilder();
  }
}
