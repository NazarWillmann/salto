package ooo.jtc.uaa.application.model;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.uaa.application.dto.AllowedFlows;

public final class ApplicationBuilder {
  private UUID id;

  private int version;

  private String name;

  private UUID clientId;

  private String clientSecret;

  private String redirectUrls;

  private boolean autoApprove;

  private Integer accessTokenLifeTime;

  private String description;

  private String baseUrl;

  private String loginPath;

  private String approvePath;

  private String mfaPath;

  private String smsMfaPath;

  private Boolean paramsViaFragment;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  private Integer sessionLifeTime;

  private Integer refreshTokenLifeTime;

  private List<? extends AllowedFlows> allowedFlows;

  private List<UUID> availableResources;

  private List<UUID> availableCatalogs;

  public ApplicationBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ApplicationBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ApplicationBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ApplicationBuilder setClientId(UUID clientId) {
    this.clientId = clientId;
    return this;
  }

  public ApplicationBuilder setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

  public ApplicationBuilder setRedirectUrls(String redirectUrls) {
    this.redirectUrls = redirectUrls;
    return this;
  }

  public ApplicationBuilder setAutoApprove(boolean autoApprove) {
    this.autoApprove = autoApprove;
    return this;
  }

  public ApplicationBuilder setAccessTokenLifeTime(Integer accessTokenLifeTime) {
    this.accessTokenLifeTime = accessTokenLifeTime;
    return this;
  }

  public ApplicationBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ApplicationBuilder setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
    return this;
  }

  public ApplicationBuilder setLoginPath(String loginPath) {
    this.loginPath = loginPath;
    return this;
  }

  public ApplicationBuilder setApprovePath(String approvePath) {
    this.approvePath = approvePath;
    return this;
  }

  public ApplicationBuilder setMfaPath(String mfaPath) {
    this.mfaPath = mfaPath;
    return this;
  }

  public ApplicationBuilder setSmsMfaPath(String smsMfaPath) {
    this.smsMfaPath = smsMfaPath;
    return this;
  }

  public ApplicationBuilder setParamsViaFragment(Boolean paramsViaFragment) {
    this.paramsViaFragment = paramsViaFragment;
    return this;
  }

  public ApplicationBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ApplicationBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public ApplicationBuilder setSessionLifeTime(Integer sessionLifeTime) {
    this.sessionLifeTime = sessionLifeTime;
    return this;
  }

  public ApplicationBuilder setRefreshTokenLifeTime(Integer refreshTokenLifeTime) {
    this.refreshTokenLifeTime = refreshTokenLifeTime;
    return this;
  }

  public ApplicationBuilder setAllowedFlows(List<? extends AllowedFlows> allowedFlows) {
    this.allowedFlows = allowedFlows;
    return this;
  }

  public ApplicationBuilder setAvailableResources(List<UUID> availableResources) {
    this.availableResources = availableResources;
    return this;
  }

  public ApplicationBuilder setAvailableCatalogs(List<UUID> availableCatalogs) {
    this.availableCatalogs = availableCatalogs;
    return this;
  }

  public Application create() {
    return new Application(id, version, name, clientId, clientSecret, redirectUrls, autoApprove, accessTokenLifeTime, description, baseUrl, loginPath, approvePath, mfaPath, smsMfaPath, paramsViaFragment, createdAt, deletedAt, sessionLifeTime, refreshTokenLifeTime, allowedFlows, availableResources, availableCatalogs);
  }

  public static ApplicationBuilder builder() {
    return new ApplicationBuilder();
  }
}
