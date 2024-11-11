package ooo.jtc.dictionaries.accountype;

import java.lang.String;
import java.util.UUID;

public final class AccountTypeDtoBuilder {
  private UUID id;

  private int version;

  private String fullName;

  private String shortName;

  private String systemName;

  private String clientType;

  private String description;

  public AccountTypeDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccountTypeDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccountTypeDtoBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public AccountTypeDtoBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public AccountTypeDtoBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public AccountTypeDtoBuilder setClientType(String clientType) {
    this.clientType = clientType;
    return this;
  }

  public AccountTypeDtoBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccountTypeDto create() {
    return new AccountTypeDto(id, version, fullName, shortName, systemName, clientType, description);
  }

  public static AccountTypeDtoBuilder builder() {
    return new AccountTypeDtoBuilder();
  }
}
