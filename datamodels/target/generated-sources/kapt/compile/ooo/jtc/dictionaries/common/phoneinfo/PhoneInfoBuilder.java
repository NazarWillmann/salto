package ooo.jtc.dictionaries.common.phoneinfo;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class PhoneInfoBuilder {
  private UUID id;

  private int version;

  private UUID ownerId;

  private String supportType;

  private String phoneType;

  private String phone;

  private Integer ordering;

  public PhoneInfoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PhoneInfoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PhoneInfoBuilder setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  public PhoneInfoBuilder setSupportType(String supportType) {
    this.supportType = supportType;
    return this;
  }

  public PhoneInfoBuilder setPhoneType(String phoneType) {
    this.phoneType = phoneType;
    return this;
  }

  public PhoneInfoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public PhoneInfoBuilder setOrdering(Integer ordering) {
    this.ordering = ordering;
    return this;
  }

  public PhoneInfo create() {
    return new PhoneInfo(id, version, ownerId, supportType, phoneType, phone, ordering);
  }

  public static PhoneInfoBuilder builder() {
    return new PhoneInfoBuilder();
  }
}
