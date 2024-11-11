package ooo.jtc.crypto;

import java.lang.String;
import java.util.UUID;

public final class ProfileDtoBuilder {
  private UUID id;

  private int version;

  private boolean authOnly;

  private ProfileType profileType;

  private String state;

  private UUID userId;

  public ProfileDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public ProfileDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public ProfileDtoBuilder setAuthOnly(boolean authOnly) {
    this.authOnly = authOnly;
    return this;
  }

  public ProfileDtoBuilder setProfileType(ProfileType profileType) {
    this.profileType = profileType;
    return this;
  }

  public ProfileDtoBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public ProfileDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public ProfileDto create() {
    return new ProfileDto(id, version, authOnly, profileType, state, userId);
  }

  public static ProfileDtoBuilder builder() {
    return new ProfileDtoBuilder();
  }
}
