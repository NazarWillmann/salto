package ooo.jtc.dictionaries.bankrepresentative;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class BankRepresentativeBuilder {
  private UUID id;

  private int version;

  private UUID bankId;

  private UUID userId;

  private String position;

  private String email;

  private String phone;

  private boolean isBlock;

  private Timestamp blockDate;

  private UUID blockUserId;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public BankRepresentativeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankRepresentativeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankRepresentativeBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BankRepresentativeBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public BankRepresentativeBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public BankRepresentativeBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BankRepresentativeBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public BankRepresentativeBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public BankRepresentativeBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public BankRepresentativeBuilder setBlockUserId(UUID blockUserId) {
    this.blockUserId = blockUserId;
    return this;
  }

  public BankRepresentativeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BankRepresentativeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BankRepresentativeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BankRepresentative create() {
    return new BankRepresentative(id, version, bankId, userId, position, email, phone, isBlock, blockDate, blockUserId, description, createdAt, deletedAt);
  }

  public static BankRepresentativeBuilder builder() {
    return new BankRepresentativeBuilder();
  }
}
