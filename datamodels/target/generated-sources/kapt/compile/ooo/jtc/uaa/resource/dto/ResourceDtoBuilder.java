package ooo.jtc.uaa.resource.dto;

import java.lang.String;
import java.util.List;
import java.util.UUID;
import ooo.jtc.uaa.scope.dto.ScopeDto;

public final class ResourceDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String description;

  private String audience;

  private List<ScopeDto> scopes;

  public ResourceDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ResourceDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ResourceDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ResourceDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ResourceDtoBuilder setAudience(String audience) {
    this.audience = audience;
    return this;
  }

  public ResourceDtoBuilder setScopes(List<ScopeDto> scopes) {
    this.scopes = scopes;
    return this;
  }

  public ResourceDto create() {
    return new ResourceDto(id, version, name, description, audience, scopes);
  }

  public static ResourceDtoBuilder builder() {
    return new ResourceDtoBuilder();
  }
}
