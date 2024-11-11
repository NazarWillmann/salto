package ooo.jtc.uaa.scope.dto;

import java.lang.String;
import java.util.UUID;

public final class ScopeUpdateRequestBuilder {
  private UUID id;

  private int version;

  private String uiName;

  private String description;

  private boolean needApprove;

  public ScopeUpdateRequestBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ScopeUpdateRequestBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ScopeUpdateRequestBuilder setUiName(String uiName) {
    this.uiName = uiName;
    return this;
  }

  public ScopeUpdateRequestBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ScopeUpdateRequestBuilder setNeedApprove(boolean needApprove) {
    this.needApprove = needApprove;
    return this;
  }

  public ScopeUpdateRequest create() {
    return new ScopeUpdateRequest(id, version, uiName, description, needApprove);
  }

  public static ScopeUpdateRequestBuilder builder() {
    return new ScopeUpdateRequestBuilder();
  }
}
