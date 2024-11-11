package ooo.jtc.uaa.application.dto;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import java.util.UUID;

public final class ApplicationDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private String description;

  private List<? extends AllowedFlows> allowedFlows;

  private String redirectUrls;

  private List<UUID> availableResources;

  private List<UUID> availableCatalogs;

  private boolean autoApproveScopes;

  private Integer accessTokenLifeTime;

  private Integer refreshTokenLifeTime;

  private Integer sessionLifeTime;

  private ApplicationLoginSiteDto loginSite;

  private UUID clientId;

  private String clientSecret;

  public ApplicationDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ApplicationDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ApplicationDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public ApplicationDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public ApplicationDtoBuilder setAllowedFlows(List<? extends AllowedFlows> allowedFlows) {
    this.allowedFlows = allowedFlows;
    return this;
  }

  public ApplicationDtoBuilder setRedirectUrls(String redirectUrls) {
    this.redirectUrls = redirectUrls;
    return this;
  }

  public ApplicationDtoBuilder setAvailableResources(List<UUID> availableResources) {
    this.availableResources = availableResources;
    return this;
  }

  public ApplicationDtoBuilder setAvailableCatalogs(List<UUID> availableCatalogs) {
    this.availableCatalogs = availableCatalogs;
    return this;
  }

  public ApplicationDtoBuilder setAutoApproveScopes(boolean autoApproveScopes) {
    this.autoApproveScopes = autoApproveScopes;
    return this;
  }

  public ApplicationDtoBuilder setAccessTokenLifeTime(Integer accessTokenLifeTime) {
    this.accessTokenLifeTime = accessTokenLifeTime;
    return this;
  }

  public ApplicationDtoBuilder setRefreshTokenLifeTime(Integer refreshTokenLifeTime) {
    this.refreshTokenLifeTime = refreshTokenLifeTime;
    return this;
  }

  public ApplicationDtoBuilder setSessionLifeTime(Integer sessionLifeTime) {
    this.sessionLifeTime = sessionLifeTime;
    return this;
  }

  public ApplicationDtoBuilder setLoginSite(ApplicationLoginSiteDto loginSite) {
    this.loginSite = loginSite;
    return this;
  }

  public ApplicationDtoBuilder setClientId(UUID clientId) {
    this.clientId = clientId;
    return this;
  }

  public ApplicationDtoBuilder setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
    return this;
  }

  public ApplicationDto create() {
    return new ApplicationDto(id, version, name, description, allowedFlows, redirectUrls, availableResources, availableCatalogs, autoApproveScopes, accessTokenLifeTime, refreshTokenLifeTime, sessionLifeTime, loginSite, clientId, clientSecret);
  }

  public static ApplicationDtoBuilder builder() {
    return new ApplicationDtoBuilder();
  }
}
