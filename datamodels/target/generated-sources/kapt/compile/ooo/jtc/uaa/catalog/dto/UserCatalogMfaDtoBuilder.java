package ooo.jtc.uaa.catalog.dto;

import java.util.UUID;

public final class UserCatalogMfaDtoBuilder {
  private UUID id;

  private UUID mfaId;

  private long lifetimeSec;

  private long maxAttempts;

  public UserCatalogMfaDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public UserCatalogMfaDtoBuilder setMfaId(UUID mfaId) {
    this.mfaId = mfaId;
    return this;
  }

  public UserCatalogMfaDtoBuilder setLifetimeSec(long lifetimeSec) {
    this.lifetimeSec = lifetimeSec;
    return this;
  }

  public UserCatalogMfaDtoBuilder setMaxAttempts(long maxAttempts) {
    this.maxAttempts = maxAttempts;
    return this;
  }

  public UserCatalogMfaDto create() {
    return new UserCatalogMfaDto(id, mfaId, lifetimeSec, maxAttempts);
  }

  public static UserCatalogMfaDtoBuilder builder() {
    return new UserCatalogMfaDtoBuilder();
  }
}
