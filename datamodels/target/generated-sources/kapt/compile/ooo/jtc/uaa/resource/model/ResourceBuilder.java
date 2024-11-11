package ooo.jtc.uaa.resource.model;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class ResourceBuilder {
  private UUID id;

  private int version;

  private String name;

  private String audience;

  private String description;

  private ZonedDateTime createdAt;

  private ZonedDateTime deletedAt;

  public ResourceBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ResourceBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ResourceBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ResourceBuilder setAudience(String audience) {
    this.audience = audience;
    return this;
  }

  public ResourceBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ResourceBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ResourceBuilder setDeletedAt(ZonedDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Resource create() {
    return new Resource(id, version, name, audience, description, createdAt, deletedAt);
  }

  public static ResourceBuilder builder() {
    return new ResourceBuilder();
  }
}
