package ooo.jtc.uaa.scope.dto;

import java.lang.String;
import java.util.UUID;
import ooo.jtc.uaa.resource.dto.ResourceDto;

public final class ScopeDtoBuilder {
  private UUID id;

  private int version;

  private UUID resourceId;

  private String name;

  private String uiName;

  private String description;

  private boolean needApprove;

  private ResourceDto resource;

  public ScopeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ScopeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ScopeDtoBuilder setResourceId(UUID resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public ScopeDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ScopeDtoBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public ScopeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ScopeDtoBuilder setNeedApprove(boolean needApprove) {
    this.needApprove = needApprove;
    return this;
  }

  public ScopeDtoBuilder setResource(ResourceDto resource) {
    this.resource = resource;
    return this;
  }

  public ScopeDto create() {
    return new ScopeDto(id, version, resourceId, name, uiName, description, needApprove, resource);
  }

  public static ScopeDtoBuilder builder() {
    return new ScopeDtoBuilder();
  }
}
