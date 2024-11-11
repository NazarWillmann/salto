package ooo.jtc.uaa.catalog.dto;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.uaa.catalog.model.UserCatalogKind;

public final class CatalogDtoBuilder {
  private UUID id;

  private int version;

  private String catalogType;

  private UserCatalogKind catalogKind;

  private String name;

  private String title;

  private String appearance;

  private String description;

  private List<UserCatalogMfaDto> mfa;

  private boolean enabled;

  public CatalogDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CatalogDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CatalogDtoBuilder setCatalogType(String catalogType) {
    this.catalogType = catalogType;
    return this;
  }

  public CatalogDtoBuilder setCatalogKind(UserCatalogKind catalogKind) {
    this.catalogKind = catalogKind;
    return this;
  }

  public CatalogDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public CatalogDtoBuilder setTitle(String title) {
    this.title = title;
    return this;
  }

  public CatalogDtoBuilder setAppearance(String appearance) {
    this.appearance = appearance;
    return this;
  }

  public CatalogDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CatalogDtoBuilder setMfa(List<UserCatalogMfaDto> mfa) {
    this.mfa = mfa;
    return this;
  }

  public CatalogDtoBuilder setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  public CatalogDto create() {
    return new CatalogDto(id, version, catalogType, catalogKind, name, title, appearance, description, mfa, enabled);
  }

  public static CatalogDtoBuilder builder() {
    return new CatalogDtoBuilder();
  }
}
