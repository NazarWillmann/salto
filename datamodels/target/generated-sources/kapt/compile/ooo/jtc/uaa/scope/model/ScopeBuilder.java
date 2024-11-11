package ooo.jtc.uaa.scope.model;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.UUID;

public final class ScopeBuilder {
  private UUID id;

  private int version;

  private String name;

  private String uiName;

  private String description;

  private UUID resourceId;

  private boolean needApprove;

  private ZonedDateTime createdAt;

  private ZonedDateTime deletedAt;

  public ScopeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ScopeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ScopeBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ScopeBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public ScopeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ScopeBuilder setResourceId(UUID resourceId) {
    this.resourceId = resourceId;
    return this;
  }

  public ScopeBuilder setNeedApprove(boolean needApprove) {
    this.needApprove = needApprove;
    return this;
  }

  public ScopeBuilder setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ScopeBuilder setDeletedAt(ZonedDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Scope create() {
    return new Scope(id, version, name, uiName, description, resourceId, needApprove, createdAt, deletedAt);
  }

  public static ScopeBuilder builder() {
    return new ScopeBuilder();
  }
}
