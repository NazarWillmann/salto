package ooo.jtc.news.mailgroup;

import java.lang.Boolean;
import java.lang.String;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import ooo.jtc.news.dto.ReceiverCustomerDto;

public final class MailGroupDtoBuilder {
  private UUID id;

  private int version;

  private UUID branchId;

  private String branchName;

  private MailGroupChannel channel;

  private Timestamp createdAt;

  private String createdUserName;

  private Timestamp editedAt;

  private String editedUserName;

  private List<ReceiverCustomerDto> customers;

  private Boolean isFavorites;

  private String name;

  public MailGroupDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public MailGroupDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public MailGroupDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public MailGroupDtoBuilder setBranchName(String branchName) {
    this.branchName = branchName;
    return this;
  }

  public MailGroupDtoBuilder setChannel(MailGroupChannel channel) {
    this.channel = channel;
    return this;
  }

  public MailGroupDtoBuilder setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public MailGroupDtoBuilder setCreatedUserName(String createdUserName) {
    this.createdUserName = createdUserName;
    return this;
  }

  public MailGroupDtoBuilder setEditedAt(Timestamp editedAt) {
    this.editedAt = editedAt;
    return this;
  }

  public MailGroupDtoBuilder setEditedUserName(String editedUserName) {
    this.editedUserName = editedUserName;
    return this;
  }

  public MailGroupDtoBuilder setCustomers(List<ReceiverCustomerDto> customers) {
    this.customers = customers;
    return this;
  }

  public MailGroupDtoBuilder setIsFavorites(Boolean isFavorites) {
    this.isFavorites = isFavorites;
    return this;
  }

  public MailGroupDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public MailGroupDto create() {
    return new MailGroupDto(id, version, branchId, branchName, channel, createdAt, createdUserName, editedAt, editedUserName, customers, isFavorites, name);
  }

  public static MailGroupDtoBuilder builder() {
    return new MailGroupDtoBuilder();
  }
}
