package ooo.jtc.dictionaries.branchrepresentative;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class BranchRepresentativeBuilder {
  private UUID id;

  private int version;

  private UUID branchId;

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

  public BranchRepresentativeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchRepresentativeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchRepresentativeBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public BranchRepresentativeBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public BranchRepresentativeBuilder setPosition(String position) {
    this.position = position;
    return this;
  }

  public BranchRepresentativeBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public BranchRepresentativeBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public BranchRepresentativeBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public BranchRepresentativeBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public BranchRepresentativeBuilder setBlockUserId(UUID blockUserId) {
    this.blockUserId = blockUserId;
    return this;
  }

  public BranchRepresentativeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public BranchRepresentativeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public BranchRepresentativeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public BranchRepresentative create() {
    return new BranchRepresentative(id, version, branchId, userId, position, email, phone, isBlock, blockDate, blockUserId, description, createdAt, deletedAt);
  }

  public static BranchRepresentativeBuilder builder() {
    return new BranchRepresentativeBuilder();
  }
}
