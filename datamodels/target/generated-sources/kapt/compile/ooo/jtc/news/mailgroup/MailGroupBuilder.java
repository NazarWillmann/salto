package ooo.jtc.news.mailgroup;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public final class MailGroupBuilder {
  private UUID id;

  private int version;

  private UUID branchId;

  private String branchName;

  private String cpm;

  private MailGroupChannel channel;

  private Timestamp deletedAt;

  private Timestamp modifiedAt;

  private String name;

  private Timestamp createdAt;

  private UUID createdUserId;

  private String createdUserName;

  private Timestamp editedAt;

  private UUID editedUserId;

  private String editedUserName;

  private List<MailGroupReceiverCustomer> customers;

  public MailGroupBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public MailGroupBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public MailGroupBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public MailGroupBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public MailGroupBuilder setCpm(String cpm) {
    this.cpm = cpm;
    return this;
  }

  public MailGroupBuilder setChannel(MailGroupChannel channel) {
    this.channel = channel;
    return this;
  }

  public MailGroupBuilder setDeletedAt(Timestamp deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  public MailGroupBuilder setModifiedAt(Timestamp modifiedAt) {
    this.modifiedAt = modifiedAt;
    return this;
  }

  public MailGroupBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public MailGroupBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public MailGroupBuilder setCreatedUserId(UUID createdUserId) {
    this.createdUserId = createdUserId;
    return this;
  }

  public MailGroupBuilder setCreatedUserName(String createdUserName) {
    this.createdUserName = createdUserName;
    return this;
  }

  public MailGroupBuilder setEditedAt(Timestamp editedAt) {
    this.editedAt = editedAt;
    return this;
  }

  public MailGroupBuilder setEditedUserId(UUID editedUserId) {
    this.editedUserId = editedUserId;
    return this;
  }

  public MailGroupBuilder setEditedUserName(String editedUserName) {
    this.editedUserName = editedUserName;
    return this;
  }

  public MailGroupBuilder setCustomers(List<MailGroupReceiverCustomer> customers) {
    this.customers = customers;
    return this;
  }

  public MailGroup create() {
    return new MailGroup(id, version, branchId, branchName, cpm, channel, deletedAt, modifiedAt, name, createdAt, createdUserId, createdUserName, editedAt, editedUserId, editedUserName, customers);
  }

  public static MailGroupBuilder builder() {
    return new MailGroupBuilder();
  }
}
