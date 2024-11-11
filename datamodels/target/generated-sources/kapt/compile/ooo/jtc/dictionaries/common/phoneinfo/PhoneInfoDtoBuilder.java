package ooo.jtc.dictionaries.common.phoneinfo;

import java.lang.String;
import java.util.UUID;

public final class PhoneInfoDtoBuilder {
  private UUID id;

  private int version;

  private UUID ownerId;

  private String supportType;

  private String phoneType;

  private String phone;

  public PhoneInfoDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public PhoneInfoDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public PhoneInfoDtoBuilder setOwnerId(UUID ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  public PhoneInfoDtoBuilder setSupportType(String supportType) {
    this.supportType = supportType;
    return this;
  }

  public PhoneInfoDtoBuilder setPhoneType(String phoneType) {
    this.phoneType = phoneType;
    return this;
  }

  public PhoneInfoDtoBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public PhoneInfoDto create() {
    return new PhoneInfoDto(id, version, ownerId, supportType, phoneType, phone);
  }

  public static PhoneInfoDtoBuilder builder() {
    return new PhoneInfoDtoBuilder();
  }
}
