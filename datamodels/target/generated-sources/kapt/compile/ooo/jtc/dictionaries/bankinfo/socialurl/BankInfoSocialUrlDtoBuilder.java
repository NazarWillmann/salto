package ooo.jtc.dictionaries.bankinfo.socialurl;

import java.lang.Integer;
import java.lang.String;
import java.util.UUID;

public final class BankInfoSocialUrlDtoBuilder {
  private UUID id;

  private int version;

  private String name;

  private UUID bankId;

  private String socialType;

  private String socialUrl;

  private Integer ordering;

  public BankInfoSocialUrlDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BankInfoSocialUrlDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BankInfoSocialUrlDtoBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public BankInfoSocialUrlDtoBuilder setBankId(UUID bankId) {
    this.bankId = bankId;
    return this;
  }

  public BankInfoSocialUrlDtoBuilder setSocialType(String socialType) {
    this.socialType = socialType;
    return this;
  }

  public BankInfoSocialUrlDtoBuilder setSocialUrl(String socialUrl) {
    this.socialUrl = socialUrl;
    return this;
  }

  public BankInfoSocialUrlDtoBuilder setOrdering(Integer ordering) {
    this.ordering = ordering;
    return this;
  }

  public BankInfoSocialUrlDto create() {
    return new BankInfoSocialUrlDto(id, version, name, bankId, socialType, socialUrl, ordering);
  }

  public static BankInfoSocialUrlDtoBuilder builder() {
    return new BankInfoSocialUrlDtoBuilder();
  }
}
