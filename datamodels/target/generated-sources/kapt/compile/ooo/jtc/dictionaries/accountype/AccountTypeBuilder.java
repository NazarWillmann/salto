package ooo.jtc.dictionaries.accountype;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class AccountTypeBuilder {
  private UUID id;

  private int version;

  private String fullName;

  private String shortName;

  private String systemName;

  private String description;

  private String clientType;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public AccountTypeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public AccountTypeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public AccountTypeBuilder setFullName(String fullName) {
    this.fullName = fullName;
    return this;
  }

  public AccountTypeBuilder setShortName(String shortName) {
    this.shortName = shortName;
    return this;
  }

  public AccountTypeBuilder setSystemName(String systemName) {
    this.systemName = systemName;
    return this;
  }

  public AccountTypeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public AccountTypeBuilder setClientType(String clientType) {
    this.clientType = clientType;
    return this;
  }

  public AccountTypeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public AccountTypeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public AccountType create() {
    return new AccountType(id, version, fullName, shortName, systemName, description, clientType, createdAt, deletedAt);
  }

  public static AccountTypeBuilder builder() {
    return new AccountTypeBuilder();
  }
}
