package ooo.jtc.dictionaries.individualrepresentative;

import java.lang.String;
import java.sql.Timestamp;
import java.util.UUID;

public final class IndividualRepresentativeBuilder {
  private UUID id;

  private int version;

  private UUID userId;

  private UUID individualId;

  private boolean isBlock;

  private UUID blockUser;

  private Timestamp blockDate;

  private String description;

  private Timestamp createdAt;

  private Timestamp deletedAt;

  public IndividualRepresentativeBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public IndividualRepresentativeBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public IndividualRepresentativeBuilder setUserId(UUID userId) {
    this.userId = userId;
    return this;
  }

  public IndividualRepresentativeBuilder setIndividualId(UUID individualId) {
    this.individualId = individualId;
    return this;
  }

  public IndividualRepresentativeBuilder setIsBlock(boolean isBlock) {
    this.isBlock = isBlock;
    return this;
  }

  public IndividualRepresentativeBuilder setBlockUser(UUID blockUser) {
    this.blockUser = blockUser;
    return this;
  }

  public IndividualRepresentativeBuilder setBlockDate(Timestamp blockDate) {
    this.blockDate = blockDate;
    return this;
  }

  public IndividualRepresentativeBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public IndividualRepresentativeBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public IndividualRepresentativeBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public IndividualRepresentative create() {
    return new IndividualRepresentative(id, version, userId, individualId, isBlock, blockUser, blockDate, description, createdAt, deletedAt);
  }

  public static IndividualRepresentativeBuilder builder() {
    return new IndividualRepresentativeBuilder();
  }
}
