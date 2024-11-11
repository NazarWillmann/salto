package ooo.jtc.dictionaries.customerrepresentative;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class CustomerRepresentativeBuilder {
  private UUID id;

  private int version;

  private UUID customerId;

  private UUID userId;

  private String position;

  private String email;

  private String phone;

  private boolean isBlock;

  private UUID blockUserId;

  private Timestamp blockDate;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public CustomerRepresentativeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public CustomerRepresentativeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public CustomerRepresentativeBuilder setCustomerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  public CustomerRepresentativeBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public CustomerRepresentativeBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public CustomerRepresentativeBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerRepresentativeBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public CustomerRepresentativeBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public CustomerRepresentativeBuilder setBlockUserId(UUID blockUserId) {
    this.blockUserId = blockUserId;
    return this;
  }

  public CustomerRepresentativeBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public CustomerRepresentativeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public CustomerRepresentativeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public CustomerRepresentativeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public CustomerRepresentative create() {
    return new CustomerRepresentative(id, version, customerId, userId, position, email, phone, isBlock, blockUserId, blockDate, description, createdAt, deletedAt);
  }

  public static CustomerRepresentativeBuilder builder() {
    return new CustomerRepresentativeBuilder();
  }
}
