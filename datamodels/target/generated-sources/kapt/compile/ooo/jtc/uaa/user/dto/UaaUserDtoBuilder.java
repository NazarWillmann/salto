package ooo.jtc.uaa.user.dto;

import java.lang.String;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import ooo.jtc.uaa.scope.dto.ScopeDetails;

public final class UaaUserDtoBuilder {
  private UUID id;

  private int version;

  private String blockReason;

  private UUID blockUser;

  private boolean permanentBlocked;

  private String preferredLocale;

  private List<UUID> scopes;

  private List<ScopeDetails> scopeDetails;

  private boolean temporaryBlocked;

  private ZonedDateTime temporaryBlockedUntil;

  private UserDetails userDetails;

  public UaaUserDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public UaaUserDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public UaaUserDtoBuilder setBlockReason(String blockReason) {
    this.blockReason = blockReason;
    return this;
  }

  public UaaUserDtoBuilder setBlockUser(UUID blockUser) {
    this.blockUser = blockUser;
    return this;
  }

  public UaaUserDtoBuilder setPermanentBlocked(boolean permanentBlocked) {
    this.permanentBlocked = permanentBlocked;
    return this;
  }

  public UaaUserDtoBuilder setPreferredLocale(String preferredLocale) {
    this.preferredLocale = preferredLocale;
    return this;
  }

  public UaaUserDtoBuilder setScopes(List<UUID> scopes) {
    this.scopes = scopes;
    return this;
  }

  public UaaUserDtoBuilder setScopeDetails(List<ScopeDetails> scopeDetails) {
    this.scopeDetails = scopeDetails;
    return this;
  }

  public UaaUserDtoBuilder setTemporaryBlocked(boolean temporaryBlocked) {
    this.temporaryBlocked = temporaryBlocked;
    return this;
  }

  public UaaUserDtoBuilder setTemporaryBlockedUntil(ZonedDateTime temporaryBlockedUntil) {
    this.temporaryBlockedUntil = temporaryBlockedUntil;
    return this;
  }

  public UaaUserDtoBuilder setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
    return this;
  }

  public UaaUserDto create() {
    return new UaaUserDto(id, version, blockReason, blockUser, permanentBlocked, preferredLocale, scopes, scopeDetails, temporaryBlocked, temporaryBlockedUntil, userDetails);
  }

  public static UaaUserDtoBuilder builder() {
    return new UaaUserDtoBuilder();
  }
}
