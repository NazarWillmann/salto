package ooo.jtc.crypto;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class ProfileBuilder {
  private UUID id;

  private int version;

  private boolean authOnly;

  private ProfileType profileType;

  private String state;

  private UUID userId;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public ProfileBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ProfileBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ProfileBuilder setAuthOnly(boolean authOnly) {
    this.authOnly = authOnly;
    return this;
  }

  public ProfileBuilder setProfileType(ProfileType profileType) {
    this.profileType = profileType;
    return this;
  }

  public ProfileBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public ProfileBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public ProfileBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public ProfileBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public Profile create() {
    return new Profile(id, version, authOnly, profileType, state, userId, createdAt, deletedAt);
  }

  public static ProfileBuilder builder() {
    return new ProfileBuilder();
  }
}
