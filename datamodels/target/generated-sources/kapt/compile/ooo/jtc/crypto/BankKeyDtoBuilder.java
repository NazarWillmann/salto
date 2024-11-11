package ooo.jtc.crypto;

import java.lang.String;
import java.util.List;
import java.util.UUID;

public final class BankKeyDtoBuilder {
  private UUID id;

  private int version;

  private ProfileType profileType;

  private UUID userId;

  private String storageName;

  private String storagePassword;

  private String alias;

  private String keyPassword;

  private List<?> keyParameters;

  public BankKeyDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankKeyDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankKeyDtoBuilder setProfileType(ProfileType profileType) {
    this.profileType = profileType;
    return this;
  }

  public BankKeyDtoBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public BankKeyDtoBuilder setStorageName(String storageName) {
    this.storageName = storageName;
    return this;
  }

  public BankKeyDtoBuilder setStoragePassword(String storagePassword) {
    this.storagePassword = storagePassword;
    return this;
  }

  public BankKeyDtoBuilder setAlias(String alias) {
    this.alias = alias;
    return this;
  }

  public BankKeyDtoBuilder setKeyPassword(String keyPassword) {
    this.keyPassword = keyPassword;
    return this;
  }

  public BankKeyDtoBuilder setKeyParameters(List<?> keyParameters) {
    this.keyParameters = keyParameters;
    return this;
  }

  public BankKeyDto create() {
    return new BankKeyDto(id, version, profileType, userId, storageName, storagePassword, alias, keyPassword, keyParameters);
  }

  public static BankKeyDtoBuilder builder() {
    return new BankKeyDtoBuilder();
  }
}
