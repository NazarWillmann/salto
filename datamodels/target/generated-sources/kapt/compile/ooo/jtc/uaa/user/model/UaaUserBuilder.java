package ooo.jtc.uaa.user.model;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public final class UaaUserBuilder {
  private UUID id;

  private int version;

  private boolean permBlock;

  private boolean tempBlock;

  private Timestamp tempBlockUntil;

  private String blockReason;

  private UUID blockUser;

  private String prefLocale;

  private String firstName;

  private String middleName;

  private String lastName;

  private String phoneNumber;

  private String email;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  private List<UUID> scopes;

  public UaaUserBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public UaaUserBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public UaaUserBuilder setPermBlock(boolean permBlock) {
    this.permBlock = permBlock;
    return this;
  }

  public UaaUserBuilder setTempBlock(boolean tempBlock) {
    this.tempBlock = tempBlock;
    return this;
  }

  public UaaUserBuilder setTempBlockUntil(Timestamp tempBlockUntil) {
    this.tempBlockUntil = tempBlockUntil;
    return this;
  }

  public UaaUserBuilder setBlockReason(String blockReason) {
    this.blockReason = blockReason;
    return this;
  }

  public UaaUserBuilder setBlockUser(UUID blockUser) {
    this.blockUser = blockUser;
    return this;
  }

  public UaaUserBuilder setPrefLocale(String prefLocale) {
    this.prefLocale = prefLocale;
    return this;
  }

  public UaaUserBuilder setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public UaaUserBuilder setMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public UaaUserBuilder setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public UaaUserBuilder setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public UaaUserBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public UaaUserBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public UaaUserBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public UaaUserBuilder setScopes(List<UUID> scopes) {
    this.scopes = scopes;
    return this;
  }

  public UaaUser create() {
    return new UaaUser(id, version, permBlock, tempBlock, tempBlockUntil, blockReason, blockUser, prefLocale, firstName, middleName, lastName, phoneNumber, email, createdAt, deletedAt, scopes);
  }

  public static UaaUserBuilder builder() {
    return new UaaUserBuilder();
  }
}
