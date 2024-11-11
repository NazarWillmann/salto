package ooo.jtc.uaa.catalog.model;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class CatalogBuilder {
  private UUID id;

  private int version;

  private String name;

  private UserCatalogKind catalogKind;

  private String catalogType;

  private String appearance;

  private String title;

  private String description;

  private String config;

  private boolean enabled;

  private ZonedDateTime createdAt;

  private ZonedDateTime deletedAt;

  public CatalogBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CatalogBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CatalogBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CatalogBuilder setCatalogKind(UserCatalogKind catalogKind) {
    this.catalogKind = catalogKind;
    return this;
  }

  public CatalogBuilder setCatalogType(String catalogType) {
    this.catalogType = catalogType;
    return this;
  }

  public CatalogBuilder setAppearance(String appearance) {
    this.appearance = appearance;
    return this;
  }

  public CatalogBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public CatalogBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CatalogBuilder setConfig(String config) {
    this.config = config;
    return this;
  }

  public CatalogBuilder setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  public CatalogBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CatalogBuilder setDeletedAt(ZonedDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Catalog create() {
    return new Catalog(id, version, name, catalogKind, catalogType, appearance, title, description, config, enabled, createdAt, deletedAt);
  }

  public static CatalogBuilder builder() {
    return new CatalogBuilder();
  }
}
